/* Refactored:
 * Removed project editing methods from the main class and placed them within the Project class.
 * Validated all inputs when capturing and editing project information. */

package poised;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Main class to create a Project.
public class Project {

	// new scanner object to read user input
	Scanner input = new Scanner(System.in); 
		
	// Attributes for the Project.
	private int projNumber = 0;
	private String projName = "none";
	private String projType = "none";
	private String projAddress = "none";
	private int projErf = 0;
	private double feeTotal = 0;
	private double feePaid = 0;
	private Date projDeadline = null;	
	private boolean projFinalised = false;	
	private Date projCompletionDate = null;
	
	// Attribute to control access to program methods based on whether Project has been captured.
	protected boolean projectCaptured = false;
	
	// Attributes for the Person class, excluded from constructor
	private Person customer;
	private Person architect;
	private Person contractor;
	
	// Empty Project constructor to create valid instance of the Project object.
	public Project() {
	}
	
	// ----- Getters & Setters for the PROJECT ----- //
	
	public int getProjNumber() {
		return projNumber;
	}
	
	public void setProjNumber(int newProjNumber) {
		this.projNumber = newProjNumber;
	}
	
	public String getProjName() {
		return projName;
	}
	
	public void setProjName(String newProjName) {
		this.projName = newProjName;
	}
	
	public String getProjType() {
		return projType;
	}
	
	public void setProjType(String newProjType) {
		this.projType = newProjType;
	}
	
	public String getProjAddress() {
		return projAddress;
	}
	
	public void setProjAddress(String newProjAddress) {
		this.projAddress = newProjAddress;
	}
	
	public int getProjErf() {
		return projErf;
	}
	
	public void setProjErf(int newProjErf) {
		this.projErf = newProjErf;
	}
	
	public double getFeeTotal() {
		return feeTotal;
	}
	
	public void setFeeTotal(double newfeeTotal) {
		this.feeTotal = newfeeTotal;
	}
	
	public double getFeePaid() {
		return feePaid;
	}
	
	public void setFeePaid(double newfeePaid) {
		this.feePaid = newfeePaid;
	}
	
	public Date getProjDeadline() {
		return projDeadline;
	}
	
	public void setProjDeadline(Date newProjDeadline) {
		this.projDeadline = newProjDeadline;
	}
	
	public boolean getProjFinalised() {	
		return projFinalised;
	}
	
	public void setProjFinalised () {			
		this.projFinalised = true;	
	}
	
	public Date getProjCompletionDate() {	 
		return projCompletionDate;
	}
	
	public void setProjCompletionDate(Date newProjCompletionDate) {	
		this.projCompletionDate = newProjCompletionDate;
	}
	
	public boolean projectCaptured() {
		return projectCaptured;
	}
	
	public void setProjectCaptured(boolean projectCaptured) {
		this.projectCaptured = projectCaptured;
	}
	
	// ----- Getters & Setters for the PERSON's of the project ----- //
	
	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}
	
	public Person getArchitect() {
		return architect;
	}

	public void setArchitect(Person architect) {
		this.architect = architect;
	}
			
	public Person getContractor() {
		return contractor;
	}

	public void setContractor(Person contractor) {
		this.contractor = contractor;
	}
	
	// Method to print out instances as string.
	@Override
	public String toString() {
		String output = "\n--- Project Information ---\n";
		output += "\nProject Number: " + projNumber;
		output += "\nProject Name: " + projName;
		output += "\nBuilding Type: " + projType;
		output += "\nPhysical address: " + projAddress;
		output += "\nERF Number: " + projErf;
		output += "\nTotal fee.: " + feeTotal;
		output += "\nTotal paid: " + feePaid;
		output += "\nDeadline: " + projDeadline;
		output += "\nFinalised: " + projFinalised;
		output += "\nCompletion date: " + projCompletionDate;
		return output;
	}
	
	// ----- Method to CAPTURE PROJECT information ----- //
	public void captureProject(Project projectName) {
		
		// --- Capture, validate and set the project NUMBER --- 
		while (true) {
			System.out.println("Enter the project number: ");
			
			// Validate that the input has an integer present.
			if (input.hasNextInt()) {
				int inputProjNumber = input.nextInt();
				projectName.setProjNumber(inputProjNumber);
				System.out.println("\nProject number captured as " + projectName.getProjNumber() +"\n");
				break;
			} else {
				System.out.println("Invalid entry, enter project number without spaces or letters.");
				input.nextLine();
			}
		}
		input.nextLine();
		
		// --- Capture, validate and set the project building TYPE --- 
		while (true) {
			System.out.println("Enter the building type (house, apartment, etc.): ");
			String userProjType = input.nextLine();
			
			// Validate that the input is not blank and that it has letters in the word.
			if (userProjType.isBlank() || userProjType.matches("[^a-zA-Z]+")) {
				System.out.println("Invalid building type, please try again."); 
			} else {
				projectName.setProjType(userProjType);
				System.out.println("\nBuilding type captured as " + projectName.getProjType() +"\n");
				break;
			}
		}	
		
		// --- Capture and set the project NAME ---
		// No validation check required as project name is created afterwards if empty.
		System.out.println("Enter the projects name: ");	
		String inputProjName = input.nextLine() ;
		projectName.setProjName(inputProjName);		
		
		// --- Capture, validate and set the projects physical ADDRESS --- 
		while (true) {
			System.out.println("Enter projects physical address: ");
			String inputProjAddress = input.nextLine();
			
			// Validate that the input is not blank and that it has letters in the word.
			if (inputProjAddress.isBlank() || inputProjAddress.matches("[^a-zA-Z]+")) {
				System.out.println("Invalid address entry, please try again."); 
			} else {
				projectName.setProjAddress(inputProjAddress);
				System.out.println("\nProject address captured as " + projectName.getProjAddress() +"\n");
				break;
			}
		}
		
		// --- Capture, validate and set the project ERF number  --- 
		while (true) {
			System.out.println("Enter projects ERF number: ");
			
			// Validate that the input has an integer present.
			if (input.hasNextInt()) {
				int inputProjErf = input.nextInt();
				projectName.setProjErf(inputProjErf);
				System.out.println("\nERF number captured as " + projectName.getProjErf() +"\n");
				break;
			} else {
				System.out.println("Invalid entry, enter ERF number without spaces or letters."); 
				input.nextLine();
			}
		}
		input.nextLine();

		// --- Capture, validate and set the projects FEE TOTAL --- 
		while (true) {
			System.out.println("Enter projects total fee: R");
			String inputFeeTotal = input.nextLine();
			
			// Validate that the input matches any number of digits, then parse to a double type.
			if (inputFeeTotal.matches("\\d+")) {
				Double projectFeePaid = Double.parseDouble(inputFeeTotal);
				projectName.setFeeTotal(projectFeePaid);
				System.out.println("\nFee total captured as " + projectName.getFeeTotal() +"\n");
				break;
			} else {
				System.out.println("Invalid fee, enter digits only with no spaces, dots or commas"); 
			}
		}
		
		// --- Capture, validate and set the projects FEE PAID --- 
		while (true) {
			System.out.println("Enter projects fee paid: R");
			String inputFeePaid = input.nextLine();
			
			// Validate that the input matches any number of digits, then parse to a double type.
			if (inputFeePaid.matches("\\d+")) {
				Double projectFeePaid = Double.parseDouble(inputFeePaid);
				projectName.setFeePaid(projectFeePaid);
				System.out.println("\nFee paid captured as " + projectName.getFeePaid() +"\n");
				break;
			} else {
				System.out.println("Invalid fee, enter digits only with no spaces, dots or commas"); 
			}
		}
		
		// --- Capture, validate and set the projects DUE DATE --- 
		while (true) {
			System.out.println("Enter projects deadline as dd/mm/yyyy: ");
			String strDate = input.nextLine();
			
			// Validate that the input is the correct length, has a "/" and doesn't contain letters.
			if (strDate.length() == 10 && strDate.contains("/") && strDate.matches("[^a-zA-Z]+")) {
				try {
					// Format string deadline to date format, and set deadline.
					Date inputProjDeadline = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
					projectName.setProjDeadline(inputProjDeadline);
					System.out.println("\nDeadline captured as " + projectName.getProjDeadline() +"\n");
					break;
				} catch (ParseException e) {
					System.out.println(strDate + " is not a valid date, please try again."); 
				}
			}
			else {
				System.out.println(strDate + " is not a valid date, please try again.");
			}
		}
	}
	
	// ----- Method to EDIT PROJECT DEADLINE ----- //
	public void editProjDeadline(Project projectName) {
		
		while (true) {
			System.out.println("Enter projects deadline as dd/mm/yyyy: ");
			String strDate = input.nextLine();
			
			// Validate that the input is the correct length, has a "/" and doesn't contain letters.
			if (strDate.length() == 10 && strDate.contains("/") && strDate.matches("[^a-zA-Z]+")) {	
				try {
					// Format string deadline to date format, and set new due date.
					Date newProjDeadline = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
					projectName.setProjDeadline(newProjDeadline);
					System.out.println("\nDeadline successfully updated to " 
							+ projectName.getProjDeadline() +"\n");
					break;
				} 
				catch (Exception e) {
					System.out.println(strDate + " is not a valid date, please try again.");
				}
			}
		}
	}
	
	// ----- Method to MARK PROJECT FINALISED ----- //
	public void markProjFinalisation(Project projectName) {
			
		while (true) {
			System.out.println("Enter projects date of completion as dd/mm/yyyy: ");
			String strDate = input.nextLine();
			
			// Validate that the input is the correct length, has a "/" and doesn't contain letters.
			if (strDate.length() == 10 && strDate.contains("/") && strDate.matches("[^a-zA-Z]+")) {
				try {
					// Format string final date to date format, and set completion date.
					Date newProjCompletionDate = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
					projectName.setProjCompletionDate(newProjCompletionDate);
					
					// Set project as finalised
					projectName.setProjFinalised();
					System.out.println("Project completion date and finalisation status "
							+ "successfully updated.");
					break;
				} 
				catch (Exception e) {
					System.out.println(strDate + " is not a valid date");
				}
			}
		}				      
	}
		
	// ----- Method to GENERATE INVOICE ----- //
	public void generateProjInvoice(Project projectName) {
			
		// Calculate outstanding project fee.
		double outstandingFee = projectName.getFeeTotal() - projectName.getFeePaid();
		
		// If there is an oustanding fee, generate an invoice with the project fees.
		if (outstandingFee > 0) {
			System.out.println("\n--- INVOICE ---\n" 
					+ customer.toString()
					+ projectName.toString()
					+ "\n\n--- Project Fees ---" 
					+ "\nTotal fee: \t\tR" + projectName.getFeeTotal()
					+ "\nTotal paid: \t\tR" + projectName.getFeePaid()
					+ "\nOutstanding balance: \tR" + outstandingFee);
		}
	}
	
	// ----- Method to WRITE COMPLETED PROJECTS TO FILE ----- //
	public void writeCompletedProjToFile(Project projectName) {
		
		// Check if project is finalised then create file and print string to the file.
		if (projectName.getProjFinalised()) {
				
			String projectOverview = projectName.toString() + "\n" 
			+ customer.toString() + "\n"
			+ architect.toString() + "\n"
			+ contractor.toString() + "\n";
		
			// Write completed project details to 'completedtasks' text file.	
			try (FileWriter writer = new FileWriter("completedtasks.txt")) {
				writer.write(projectOverview);
				System.out.println("\nCompleted Poised project added to file.");
			} 
			catch (IOException e) {
				System.out.println("Error writing to file.");
			}
		}	
	}
	 
	// ----- Method to VIEW INCOMPLETE PROJECTS ----- //
	public void viewIncompleteProj(Project projectName) {
		
		// Check if project is not finalised and display the project information.
		if (!projectName.getProjFinalised()) { 
			System.out.println("\nIncomplete Poised projects: \n" + projectName.toString());	
		}
		else {
			System.out.println("\nAll projects are complete.");
		}
	}
	
	// ----- Method to VIEW INCOMPLETE PROJECTS ----- //
	public void viewOverdueProj(Project projectName) {
		
		// Get todays date using Date method.
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date currentDate = null;
		try {
			currentDate = formatter.parse(formatter.format(new Date()));
		} 
		catch (ParseException e) {
			System.out.println("Could not retrieve current date.");
			e.printStackTrace();
		}

		// If deadline occurs before currentDate, display projects that are behind schedule.
		if (projectName.getProjDeadline().compareTo(currentDate) < 0) { 
			System.out.println("\nPoised projects past deadline:\n"
					+ projectName.toString());
		} 
		else { 
			System.out.println("\nAll Poised projects are on schedule.");	
		}
	}
	
	// ----- Method to SEARCH PROJECTS ----- //
	public void searchProj(Project projectName) {
		
		while (true) {
			// Get user to input search name or number.
			System.out.println("\nEnter the project name or number: ");
			String searchNameOrNumber = input.nextLine();
			
			// Check if search term matches the project name or number and display project info.
			if (searchNameOrNumber.equals(projectName.getProjName()) ||
							Integer.parseInt(searchNameOrNumber) == projectName.getProjNumber()) { 
					System.out.println(projectName.toString()); 
					break;
			} 
			else {
				System.out.println("\n Invalid search name or number.");
			}
		}
	}
	
	// ----- Method to EDIT FEE PAID ----- //
	public void editProjFee(Project projectName) { 
		
		while (true) {
			System.out.println("\nEnter the project fee paid: ");
			String inputFeePaid = input.nextLine();
		
			// Validate that the input matches any number of digits, then parse to a double type. 
			if (inputFeePaid.matches("\\d+")) {
				Double newFeePaid = Double.parseDouble(inputFeePaid);
				projectName.setFeePaid(newFeePaid);
				System.out.println("\nFee paid successfully updated to " + projectName.getFeePaid() +"\n");
				break;
			}
			else {
				System.out.println("Invalid fee, enter digits only with no spaces, dots or commas");
			}
		}
	}

	// ----- Method to create PROJECT NAME ----- //
	public void createProjectName(Project projectName, Person projectCustomer) {
		
		// Create and set a new prpject name if one doesn't exist.
		if (!projectName.getProjName().equals("none")) {
			String alternativeProjName = projectName.getProjType() 
					+ " " + projectCustomer.getFullName().split(" ")[1];
			projectName.setProjName(alternativeProjName);
			System.out.printf("Project name set as %s", alternativeProjName);
		}
	}
}
