package ass1_Saif;

import java.io.EOFException;

import java.io.Serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class MtBullerResort implements Serializable {

	private FileInputStream fis;
	private ObjectInputStream ois;
	private FileOutputStream fos;
	private ObjectOutputStream oos;

	private ArrayList<Accomodation> accomodation;
	private ArrayList<Customer> customers;
	private ArrayList<Flight> travelpackage;
	private ArrayList<LiftPass> liftpass;

	public MtBullerResort() {
		accomodation = new ArrayList<Accomodation>();
		customers = new ArrayList<Customer>();
		travelpackage = new ArrayList<Flight>();
		liftpass = new ArrayList<LiftPass>();

	}

	public void populateList() {
		Accomodation[] acomm = { new Accomodation("Hotel", 50), new Accomodation("Apartment", 100),
				new Accomodation("Lodges", 300), new Accomodation("Apartment", 150), new Accomodation("Lodges", 180),
				new Accomodation("Apartment", 120), new Accomodation("Hotel", 110), new Accomodation("Lodges", 500),
				new Accomodation("Hotel", 340), new Accomodation("Apartment", 330), };

		Customer[] cust = { new Customer("Darrel", "Expert"), new Customer("Tim", "Beginner"),
				new Customer("Chris", "Intermediate"), };

		for (int i = 0; i < acomm.length; i++)
			accomodation.add(acomm[i]);
		for (int i = 0; i < cust.length; i++)
			customers.add(cust[i]);

		liftpass.add(new LiftPass("Full day", 26));
		liftpass.add(new LiftPass("Full season", 200));

	}

	public void run() {
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		while (flag) {
			System.out.println("Mt Buller Winter Resort options\n------------------------\n"
					+ "1: Display all accomodations\n" + "2: Display available accomodations\n" + "3: Add customer\n"
					+ "4: List customers\n" + "5: Create Package\n" + "6: Add a Lift pass\n" + "7: Add a Lessons\n"
					+ "8: List Packages\n" + "9: Save Packages to file\n" + "10: Read Pacakges from files\n"
					+ "11: Quit\n");

			System.out.print("Choose an option: ");
			int option = input.nextInt();
			input.nextLine();
			switch (option) {
			case 1:
				displayAllAccomodations();
				break;
			case 2:
				displayAvailableAccomodations();
				break;
			case 3:
				addCustomer();
				break;
			case 4:
				listCustomers();
				break;
			case 5:
				addPackage();
				break;
			case 6:
				Scanner input1 = new Scanner(System.in);
				System.out.println("Customer ID? ");
				int custId = input1.nextInt();
				input1.nextLine();
				addliftPass(custId);

				break;
			case 7:
				Scanner input3 = new Scanner(System.in);
				System.out.println("Customer ID? ");
				int custIdd = input3.nextInt();
				input3.nextLine();

				addLessons1(custIdd);
				break;
			case 8:
				listPackage();

				break;
			case 9:
				savePackage();

				break;
			case 10:
				readPackage();
				break;
			case 11:
				flag = false;
				System.out.println("Thank you.");
				break;
			default:
				System.out.println("Invalid option.");
			}

		}

	}

	public void displayAvailableAccomodations() {
		for (Accomodation r : accomodation) {
			if (r.isAvailability())
				System.out.println(r);
		}

	}

	public void displayAllAccomodations() {
		for (Accomodation r : accomodation) {
			System.out.println(r);
		}
	}

	public void addCustomer() {
		String expLevel = null;
		Scanner input = new Scanner(System.in);

		System.out.print("Customer name? ");
		String name = input.nextLine();
		do {
			System.out.print("Customer Experience Level?:" + "Beginner " + "Intermediate " + "Expert");
			expLevel = input.nextLine();
		} while (!expLevel.equalsIgnoreCase("expert") && !expLevel.equalsIgnoreCase("beginner")
				&& !expLevel.equalsIgnoreCase("intermediate"));
		Customer c = new Customer(name, expLevel);
		customers.add(c);

	}

	public void listCustomers() {
		for (Customer c : customers) {
			System.out.println(c);
		}
	}

	public void addPackage() {

		Scanner input = new Scanner(System.in);
		System.out.print("Customer ID? ");
		int custId = input.nextInt();
		input.nextLine();
		System.out.print("How many days are you going to stay ");
		int dur = input.nextInt();
		input.nextLine();

		System.out.print("Date in format yyyy-mm-dd? ");
		String dateStr = input.nextLine();
		LocalDate date = null;
		try {
			date = LocalDate.parse(dateStr);
		} catch (Exception e) {
		}

		Flight travel = new Flight(custId, date, dur);
		boolean match = false;
		while (true) {
			System.out.print("Acomodation Type? ");
			String AccomType = input.nextLine();
			System.out.print("Acomodation Price? ");
			int Accomprice = input.nextInt();
			for (Accomodation r : accomodation) {
				if (r.getAccomType().equalsIgnoreCase(AccomType) && r.getPrice() == Accomprice && r.isAvailability()) {

					r.setAvailability(false);
					travel.setAccomNo(r.getAccomId());

					match = true;

					break;
				}
			}
			if (match)
				break;
			System.out.println("Did not find a match.");

		}
		travelpackage.add(travel);
		System.out.println("Package Created.");

	}

	public void listPackage() {
		for (Flight t : travelpackage) {
			System.out.println(t);
		}
	}

	public Flight searchTravelPackByCustId(int custId) {
		for (Flight b : travelpackage) {
			if (b.getCustId() == custId)
				return b;
		}
		return null;
	}

	public void displayliftPass() {
		for (LiftPass s : liftpass) {
			System.out.println(s);
		}
	}

	public LiftPass searchLiftType(String type) {
		for (LiftPass l : liftpass) {
			if (l.getType().equalsIgnoreCase(type))
				return l;
		}
		return null;
	}

	public void addliftPass(int custID) {
		Flight p = searchTravelPackByCustId(custID);
		int duration = p.getDuration();
		int accomNo = p.getAccomNo();
		Accomodation r = searchAccomNo(accomNo);
		r.setAvailability(true);
		int totalCost = duration * r.getPrice();
		Scanner input = new Scanner(System.in);
		displayliftPass();
		System.out.println("Enter type of Lift Pass?");
		String liftpass = input.nextLine();
		System.out.println("Enter num of days");
		int numofDays = input.nextInt();

		LiftPass l = searchLiftType(liftpass);
		if (l != null) {
			l.setnumOfDays(numofDays);
			totalCost += l.getPrice() * l.getnumOfDays();
		}
		if (l != null && liftpass.equalsIgnoreCase("fullseason")) {
			totalCost += l.getPrice() * 0.1;
			;
		}

		p.setTotalCost(totalCost);
		System.out.println("Your total cost is " + totalCost);

	}

	public Customer searchCustomerByCustExp(String expLevel) {
		for (Customer b : customers) {
			if (b.getExpLevel() == expLevel)
				return b;
		}
		return null;
	}

	public void addLessons1(int custID) {

		
		int price;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Exp Level?");
		String lesson = input.nextLine();

		if (lesson.equalsIgnoreCase("expert")) {
			price = 15;
		} else if (lesson.equalsIgnoreCase("beginner")) {
			price = 25;
		} else {
			price = 20;
		}

		Flight p = searchTravelPackByCustId(custID);

		double total = p.getCost() + price;
		p.setTotalCost(total);
		System.out.println("Your total cost is " + total);

		p.setCost(total);

	}

	public Accomodation searchAccomNo(int accomNo) {
		for (Accomodation r : accomodation) {
			if (r.getAccomId() == accomNo)
				return r;
		}
		return null;
	}

	public void savePackage() {
		try {
			fos = new FileOutputStream("travelpackage.dat");
			oos = new ObjectOutputStream(fos);
			for (Flight b : travelpackage) {
				oos.writeObject(b);
			}
			fos.close();
			oos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readPackage() {
		travelpackage.clear();
		try {
			fis = new FileInputStream("travelpackage.dat");
			ois = new ObjectInputStream(fis);

			while (true) {
				try {
					Object object = ois.readObject();
					Flight b = (Flight) object;
					// update room status
					int roomNo = b.getAccomNo();
					Accomodation r = searchAccomNo(roomNo);
					try {
						r.setAvailability(false);
					} catch (NullPointerException e) {
						break;
					}
					// add to array list
					travelpackage.add(b);
					System.out.println(b);
				} catch (EOFException eof) {
					fis.close();
					ois.close();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
