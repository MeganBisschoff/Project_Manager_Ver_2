/* Refactored:
 * Created abstract Person parent class with proected attributes for the subclasses.
 * Removed assocaiaed capturing and editing methods from the main class and placed them  
 * directly within the Person class.
 * Validated all inputs when capturing and editing person information. */

package poised;

import java.util.Scanner;

// Abstract Person class provides method implementation to all the subclasses.
public abstract class Person {
			
	// Open scanner object.
	Scanner input = new Scanner(System.in);
	
	// Protected attributes for Person, accessed by Customer, Architect and Contractor classes.
	protected String fullName = "none";
	protected String contactNumber = "none";
	protected String email = "none";
	protected String address = "none";
	
	// Attribute to control access to program methods based on whether Person has been captured.
	protected boolean personCaptured = false;
	
	// Constructor to initialise attributes in each subclass extending the Person class.
	protected Person() {
	}
	
	// ----- Getters & Setters for the Person ----- //
	
	public String getFullName () {
		return fullName;
	}
	
	public void setFullName (String fullName) {
		this.fullName = fullName;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean personCaptured() {
		return personCaptured;
	}

	public void setPersonCaptured(boolean personCaptured) {
		this.personCaptured = personCaptured;
	}
	
	// Abstract method overridden by subclasses to print out instances as STRING.
	public abstract String toString();

	
	// ----- Method to CAPTURE PERSON DATA ----- //
	public void capturePersonData(Person personType, Project projectName, Person projectCustomer) {
		
		// Get input to capture Person's FULL NAME.
		while (true) {
			System.out.println("Enter first and last name: ");
			String inputFullName = input.nextLine();
			
			// Check that the input contains more than one word (Ie. first and last name).
			if (inputFullName.split(" ").length > 1) {
			    personType.setFullName(inputFullName);
				break;
			}
			else {
				System.out.println("Invalid entry, ensure both first and last names ar entered.");
			}
		}
		    
		// Get input to capture Person's CONTACT NUMBER.
		while (true) {
			System.out.println("Enter contact number: ");
			String inputContactNumber = input.nextLine();
			
			// Check that the number contains no letters and has no missing numbers.
			if (inputContactNumber.matches("[0-9]+") && inputContactNumber.length() >= 10) {
					personType.setContactNumber(inputContactNumber);
					break;
			}
			else {
				System.out.println("Invalid entry, enter number without spaces or + symbol.");
			}
		}
		
		// Get input to capture Person's EMAIL.
		while (true) {
			System.out.println("Enter email address: ");
			String inputEmail = input.nextLine();
			
			// Validate if the input contains an email '@' symbol and is not blank.
			if (inputEmail.isEmpty() || !inputEmail.contains("@")) {
				System.out.println("Invalid entry, authorised emails require an @ symbol.");
			}
			else {
				personType.setEmail(inputEmail);
			    break;
			}
		}
		
		// Get input to capture Person's ADDRESS.
		while (true) {
			System.out.println("Enter physicaladdress: ");
			String inputAddress = input.nextLine();
			
			// Validate that the input contains letters and is not blank.
			if (inputAddress.isBlank() || inputAddress.matches("[^a-zA-Z]+")) {
				System.out.println("Invalid address entry, please try again.");
			}
			else {
				personType.setAddress(inputAddress);
				break;
			}
		}
	}
	
	// ----- Method to EDIT PERSON DATA ----- //
	public void editPersonData(Person personType, Project projectName) { 
				
		// Get input to update the NAME.
		while (true) {
			System.out.println("Enter the new first and last name: ");
			String inputNewName = input.nextLine();
			
			// Check that the input contains more than one word (Ie. first and last name).
			if (inputNewName.split(" ").length > 1) {
			    personType.setFullName(inputNewName);
			    break;
			}
			else {
				System.out.println("Invalid entry, ensure both first and last names ar entered.");
			}
		}
				
		// Get input to update the CONTACT NUMBER.
		while (true) {
			System.out.println("Enter the new contact number as 0826669999, with no spaces: ");
			String inputNewContactNumber = input.nextLine();
			
			// Check that the number contains no letters and has no missing numbers.
			if (inputNewContactNumber.matches("[0-9]+") && inputNewContactNumber.length() >= 10) {
				System.out.println("Invalid entry, enter number without spaces or + symbol.");
			}
			else {
				personType.setContactNumber(inputNewContactNumber);
			    System.out.println("Contact number updated to " + personType.getContactNumber());
			    break;
			}
		}
		
		// Get input to update the EMAIL.
		while (true) {
			System.out.println("Enter new email address: ");
			String inputNewEmail = input.nextLine();
			
			// Validate if the input contains an email '@' symbol and is not blank.
			if (inputNewEmail.isEmpty() || !inputNewEmail.contains("@")) {
				System.out.println("Invalid entry, authorised emails require an @ symbol.");
			} 
			else {
				personType.setEmail(inputNewEmail);
				System.out.println("Email updated to " + personType.getEmail());
				break;
				
			}
		}
		
		// Get input to update the physical ADDRESS.
		while (true) {
			System.out.println("Enter the new address: ");
			String inputNewAddress = input.nextLine();
			
			// Validate that the input contains letters and is not blank.
			if (inputNewAddress.isEmpty() || !inputNewAddress.matches("[a-zA-Z]+")) {
				System.out.println("Invalid address entry, please try again.");
			}
			else {
				personType.setAddress(inputNewAddress);
				System.out.println("Address updated to " + personType.getAddress());
				break;
			}
		}
		
	}
	
}
		

