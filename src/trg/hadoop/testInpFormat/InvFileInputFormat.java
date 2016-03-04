package trg.hadoop.testInpFormat;
import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;


public class InvFileInputFormat extends FileInputFormat<LongWritable, InvRecordWritable>{

	@Override
	public RecordReader<LongWritable, InvRecordWritable> createRecordReader(
			InputSplit arg0, TaskAttemptContext arg1) throws IOException,
			InterruptedException {
		return new InvRecordReader();
	}

}