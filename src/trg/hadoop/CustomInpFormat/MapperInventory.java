package trg.hadoop.CustomInpFormat;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
public class MapperInventory extends Mapper<InvKeyWritable, InvValueWritable, InvKeyWritable, InvValueWritable> {

	protected void map(InvKeyWritable key, InvValueWritable value, Context context) throws IOException, InterruptedException {
//		String[] tokens = value.toString().split(",");
						
		context.write(key, value);
			
		}
	}

