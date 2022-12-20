/* Refactored:
 * Created Contractor subclass to inherit properties from the Person parent class. */

package poised;

public class Contractor extends Person {

	// Empty constructor inherited by the Person class to create instance of the Contractor object.
	public Contractor() {
	}
	
	// Override method implemented in the Person class.
	@Override
	public String toString() {
		String output = "\n--- Contractor's Information ---\n";
		output += "\nName: " + fullName;
		output += "\nPhone number: " + contactNumber;
		output += "\nEmail address: " + email;
		output += "\nWork address: " + address;
		return output;
	}

}
