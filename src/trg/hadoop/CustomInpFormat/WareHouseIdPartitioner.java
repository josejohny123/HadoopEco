package trg.hadoop.CustomInpFormat;

import org.apache.hadoop.mapreduce.Partitioner;

public class WareHouseIdPartitioner extends Partitioner<InvKeyWritable, InvValueWritable> {

	public int getPartition(InvKeyWritable key,InvValueWritable arg1, int num_partition) {
		// TODO Auto-generated method stub
		
		
		if(key.getWhid().toString().equals("WH01")) {
			return (key.hashCode() & Integer.MAX_VALUE) % num_partition;
	}else 	if(key.getWhid().equals("WH02")) {
		return (key.hashCode() & Integer.MAX_VALUE) % num_partition;
}if(key.getWhid().toString().equals("WH03")) {
	return (key.hashCode() & Integer.MAX_VALUE) % num_partition;
} else {
return (key.hashCode() & Integer.MAX_VALUE) % num_partition;
}

	}}