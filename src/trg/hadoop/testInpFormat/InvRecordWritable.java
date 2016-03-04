
package trg.hadoop.testInpFormat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
// import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;


public class InvRecordWritable implements WritableComparable<InvRecordWritable> {
  
    private Text prodid;
    private Text whid;
    private IntWritable qoh;
    private IntWritable qty_ordered;
    private IntWritable reorder_lvl;
    
  public InvRecordWritable() {
	  this.prodid = new Text();
	  this.whid = new Text();
	  this.qoh = new IntWritable();
	  this.qty_ordered = new IntWritable();
	  this.reorder_lvl = new IntWritable();
  }
  
  public void set(String prodid, String whid, int qoh, int qty_ordered, int reorder_lvl) {
  // super();

  this.prodid.set(prodid);
  this.whid.set(whid);
  this.qoh.set(qoh);
  this.qty_ordered.set(qty_ordered);
  this.reorder_lvl.set(reorder_lvl);

 }

 public Text getProdId() {
  return prodid;
 }

 public Text getWarehouseID() {
  return whid;
 }

 public IntWritable getQOH() {
  return qoh;
 }

 public IntWritable getQtyOrdered() {
	  return qty_ordered;
	 }

 public IntWritable getReorderLevel() {
	  return reorder_lvl;
	 }

 @Override
    public void readFields(DataInput in) throws IOException {
	 prodid.readFields(in);
	 whid.readFields(in); 
	 qoh.readFields(in); 
	 qty_ordered.readFields(in);
	 reorder_lvl.readFields(in);	 
    }
 
    @Override
    public void write(DataOutput out) throws IOException {
     prodid.write(out);
     whid.write(out);
     qoh.write(out);
     qty_ordered.write(out);
     reorder_lvl.write(out);     
    }
    
	@Override
	public int compareTo(InvRecordWritable o) {
		if (prodid.compareTo(o.prodid) == 0) {
			return qoh.compareTo(o.qoh);
		} else
			return prodid.compareTo(o.prodid);
	}
	
	public int hashCode()
	{
		return prodid.hashCode();
	}
    
}
