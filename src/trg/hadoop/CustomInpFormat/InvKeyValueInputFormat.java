package trg.hadoop.CustomInpFormat;

import java.io.IOException;

import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordReader;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class InvKeyValueInputFormat extends org.apache.hadoop.mapreduce.lib.input.FileInputFormat<InvKeyWritable, InvValueWritable> {

	@Override
	public org.apache.hadoop.mapreduce.RecordReader<InvKeyWritable, InvValueWritable> createRecordReader(
			org.apache.hadoop.mapreduce.InputSplit arg0, TaskAttemptContext arg1)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return new InvKeyValueRecordReader();
	}


	
}
