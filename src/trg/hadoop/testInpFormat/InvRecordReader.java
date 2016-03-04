package trg.hadoop.testInpFormat;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;

public class InvRecordReader extends RecordReader<LongWritable, InvRecordWritable> {

    private LineRecordReader lineReader;
    private InvRecordWritable value; 

	@Override
	public void close() throws IOException {
        if (lineReader != null) {
            lineReader.close();
        }
	}

	@Override
	public LongWritable getCurrentKey() throws IOException,
			InterruptedException {
		return lineReader.getCurrentKey();
	}
	
	@Override
	public InvRecordWritable getCurrentValue() throws IOException, InterruptedException {
		return value;
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		return lineReader.getProgress();
	}

	@Override
	public void initialize(InputSplit inputSplit, TaskAttemptContext context)
			throws IOException, InterruptedException {
		
		lineReader = new LineRecordReader();
		lineReader.initialize(inputSplit, context);		
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {

		if (!lineReader.nextKeyValue()) {
			return false;
		}
		
		String[] fields = lineReader.getCurrentValue().toString().split( "," );

		String prodid =  fields[0];
		String whid =  fields[1];
		int qoh = Integer.parseInt(fields[2]);
		int qty_ordered = Integer.parseInt(fields[3]);		
		int reorder_lvl = Integer.parseInt(fields[4]);
		
		if ((prodid.length() != 4) || (whid.length() != 4) || (qoh < 0) || (qty_ordered < 0) || (reorder_lvl < 0)) {
			System.out.println("Error Record : " + prodid.concat("|").concat(whid));
		}
		
		value = new InvRecordWritable();
		value.set(prodid, whid, qoh, qty_ordered, reorder_lvl);
		
		return true;
	}
}
