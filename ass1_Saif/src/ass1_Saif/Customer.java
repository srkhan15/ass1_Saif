package ass1_Saif;

public class Customer {
	  
	  private int custId;
	  private String name;
	  private String expLevel;
	  static int nextID = 100;
	  
	  
	  public Customer () {}
	  
	  public Customer (String name, String level) {
	    this.name = name;
	    this.expLevel = level;
	    custId = nextID++;
	  }
	  
	  public int getCustId () {
	    return custId;
	  }
	  public String getName () {
	    return name;
	  }
	  
	  public void setName (String name) {
	    this.name = name;
	  }
	  
	  public String getExpLevel() {
		return expLevel;
	}

	public void setExpLevel(String expLevel) {
		this.expLevel = expLevel;
	}

	public String toString () {
	    return "Customer ID: " + custId + ", name: " + name + " Experiece Level: " + expLevel;
	  }
	  
	}