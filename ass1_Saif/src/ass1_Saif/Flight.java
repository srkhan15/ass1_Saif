package ass1_Saif;

import java.time.LocalDate;
import java.io.Serializable;


class Flight implements Serializable {

	private int packageId;
	  private int custId;
	  private int accomNo;
	 
	  private int duration;
	  private double cost;
	  private boolean isPaid;
	  static int nextID = 10;
	  
	  
	  public Flight() {
		packageId = nextID++;	
		} 
	 
	  public Flight(int custId, int duration) {
			this.custId = custId;
			this.duration = duration;
			packageId = nextID++;
			
		} 
	  
	  
	  public Flight(int custId, LocalDate startDate, int duration) {
			this.custId = custId;
			
			this.duration = duration;
			packageId = nextID++;
			
		} 
	  
	  
	public Flight(int custId, int accomNo, LocalDate startDate, int duration) {
		this.custId = custId;
		this.accomNo = accomNo;
		
		this.duration = duration;
		packageId = nextID++;
		
	}
	public int getBookingId() {
		return packageId;
	}
	public void setBookingId(int bookingId) {
		this.packageId = bookingId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getAccomNo() {
		return accomNo;
	}
	public void setAccomNo(int accomNo) {
		this.accomNo = accomNo;
	}
	
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) { 
		this.isPaid = isPaid;
	}
	
	public void setTotalCost(double cost){
	    this.cost = cost;
	  }
	@Override
	public String toString() {
		return "TravelPackage [PackageID=" + packageId + ", custId=" + custId + ", accomNo=" + accomNo  
				+ ", duration=" + duration + "]";
	}
	
	
	  
	  
	  

}

