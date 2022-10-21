package Mobile_application;

public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactID1, String firstName1, String lastName1, String phone1, String address1) {
		
		if (contactID1.equals("") || contactID1.length() > 10) {
			throw new IllegalArgumentException("Invalid ID number");
		}
		if (firstName1.equals("") || firstName1.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName1.equals("") || lastName1.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone1.equals("") || !(phone1.length() == 10)) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address1.equals("") || address1.length() > 30) {
			throw new IllegalArgumentException("Invalid E-mail");
		}
		
		this.contactID = contactID1;
		this.firstName = firstName1;
		this.lastName = lastName1;
		this.phone = phone1;
		this.address = address1;
	}
	
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName1) {
		this.firstName = firstName1;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName1) {
		this.lastName = lastName1;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone1) {
		this.phone = phone1;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address1) {
		this.address = address1;
	}
}
