package trg.hadoop.invagg.rsj;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class InvReducer extends Reducer<Text, Text, Text, Text> {
		
		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			String prodname = "";
			String suppliername = "";
			int totInv = 0;
			
			for (Text invRec : values) {
				String invArray[] = invRec.toString().split(",");
				
				if (invArray[0].equals("invrec")) {
					totInv += Integer.valueOf(invArray[2]) + Integer.valueOf(invArray[3]);
				} else if (invArray[0].equals("prodrec")) {
					prodname = invArray[1];
					suppliername = invArray[2];
				}
			}
			String recOut = prodname + "," + suppliername + "," + Integer.toString(totInv);
			context.write(key, new Text(recOut));
		}
}
	
