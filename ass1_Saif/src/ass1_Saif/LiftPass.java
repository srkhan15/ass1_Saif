package ass1_Saif;

public class LiftPass {
	 private String liftType;
	  private int price;
	  private int numOfDays;
	  
	  public LiftPass(){
	  }
	  
	  public LiftPass(String type){
		    this.liftType = type;
		    
		  }
	  
	  public LiftPass(String type, int price){
	    this.liftType = type;
	    this.price = price;
	  }
	  
	

	public double getPrice(){
	    return price;
	  }
	   public String getType(){
	    return liftType;
	  }
	  public void setPrice(int price){
	     this.price = price;
	  }
	   public int getnumOfDays(){
	    return numOfDays;
	  }
	  public void setnumOfDays(int numOfDays){
	     this.numOfDays = numOfDays;
	  }
	  public String toString(){
	    return "LiftPass: " + liftType + " " + price;
	  }
}
