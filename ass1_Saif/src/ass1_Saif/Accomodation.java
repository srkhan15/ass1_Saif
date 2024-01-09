package ass1_Saif;

class Accomodation {

private int accomId;
private String accomType;
private int price;
private boolean availability = true;
static int nextID = 100;

public Accomodation() {
	
}



public Accomodation(String type, int price) {
	this.accomType = type;
	this.price = price;
	accomId = nextID++;
}


public int getAccomId() {
	return accomId;
}
public void setAccomId(int accomId) {
	this.accomId = accomId;
}
public String getAccomType() {
	return accomType;
}
public void setAccomType(String accomType) {
	this.accomType = accomType;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public boolean isAvailability() {
	return availability;
}
public void setAvailability(boolean availability) {
	this.availability = availability;
}

@Override
public String toString() {
	return "Accomodation [accomId=" + accomId + ", accomType=" + accomType + ", price=" + price + ", availability="
			+ availability + "]";
}





	
	
	
}
