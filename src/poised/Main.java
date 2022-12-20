/* Refactored:
 * Moved all methods from main class to the associated Person and Project classes.
 * Reduced nesting of if/else logic and improved efficiency with switch statements and 
 * arrow case labels to eliminate the need for break statements and prevent fall through.
 * Validated all inputs when selecting a menu choice. */

package poised;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		// Open scanner to read user input.
		Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
					
		// Initialise error message when encountering a null pointer exception.
		String nullPointerMessage = "\nRedirect to program menu 1"
				+ " to capture project details first.\n";
			
		// Create global Project and Person objects, outside the while loop to retain data.
		Project projectPoise = new Project();	
		Person projectCustomer = new Customer();
		Person projectContractor = new Contractor();
		Person projectArchitect = new Architect();
		
		// Display program menu then get and validate user input before running program.
		while (true) {

			String programMenu = "\n--- Poised Program ---\n"
							+ "\nEnter 1 to create and capture a new Poise project"
							+ "\nEnter 2 to edit the projects due date"
							+ "\nEnter 3 to finalise a project"
							+ "\nEnter 4 to view all incomplete projects"
							+ "\nEnter 5 to view all overdue projects"
							+ "\nEnter 6 to search for a project"
							+ "\nEnter 7 to edit the projects fee paid"
							+ "\nEnter 8 to update the contractors details"
							+ "\nEnter 9 to exit the program"
							+ "\nEnter selection: ";
			
			// Show menu and take user input for program choice.
			System.out.println(programMenu);
			String inputChoice = input.nextLine();
		
			// Check if the inputted choice only has integers with no letters, 
			// then parse to validate menu choice.
			if (inputChoice.matches("[0-9]") && inputChoice.matches("[^a-zA-Z]+")) {
				int menuChoice = Integer.parseInt(inputChoice);
				
				// Switch through each case of the menu and perform associated program operation.
				switch (menuChoice) {
				
					// Capture new Project and Person object information
					case 1 -> {			
						System.out.println("\n--- Capture Project data ---");
						projectPoise.captureProject(projectPoise);
			
						System.out.println("\n--- Capture Customer Details ---");
						projectCustomer.capturePersonData(projectCustomer, projectPoise, 
										projectCustomer);
						projectPoise.setCustomer(projectCustomer);
					
						System.out.println("\n--- Capture Architect Details ---");
						projectArchitect.capturePersonData(projectArchitect, projectPoise, 
										projectCustomer);
						projectPoise.setArchitect(projectArchitect);
			
						System.out.println("\n--- Capture Contractor Details ---");
						projectContractor.capturePersonData(projectContractor, projectPoise, 
										projectCustomer);
						projectPoise.setContractor(projectContractor);
						
						// Control variable ensuring objects are captured before further operations.
						projectPoise.setProjectCaptured(true);
						projectCustomer.setPersonCaptured(true);
						projectArchitect.setPersonCaptured(true);
						projectContractor.setPersonCaptured(true);
						
						// Set project name if it was left empty.
						projectPoise.createProjectName(projectPoise, projectCustomer);
						
						// Display object information captured.
						System.out.println(projectPoise.toString());
						System.out.println(projectCustomer.toString());
						System.out.println(projectArchitect.toString());
						System.out.println(projectContractor.toString());
					}	
					
					// Edit project deadline, if project is captured.
					case 2 -> {
						if (projectPoise.projectCaptured()) {
							System.out.println("-\n-- Edit Project Deadline ---");
							projectPoise.editProjDeadline(projectPoise);
						} else {
							System.out.println(nullPointerMessage);
						} 
					}
	
					// Finalise project, if project is captured.
					case 3 -> {
						if (projectPoise.projectCaptured()) {
							System.out.println("\n--- Finalise Project ---");
							projectPoise.markProjFinalisation(projectPoise);
							projectPoise.generateProjInvoice(projectPoise);
							projectPoise.writeCompletedProjToFile(projectPoise);
						} else {
							System.out.println(nullPointerMessage);
						} 
					}
					
					// View incomplete projects, if project is captured.
					case 4 -> { 
						if (projectPoise.projectCaptured()) {
							System.out.println("\n--- View Incomplete Projects ---");
							projectPoise.viewIncompleteProj(projectPoise);
						} else {
							System.out.println(nullPointerMessage);
						} 
					}
					
					// View overdue projects, if project is captured.
					case 5 -> {
						if (projectPoise.projectCaptured()) {
							System.out.println("\n--- View Overdue Projects ---");
							projectPoise.viewOverdueProj(projectPoise);
						} else {
							System.out.println(nullPointerMessage);
						} 
					}
					
					// Search for project, if project is captured.
					case 6 -> { 
						if (projectPoise.projectCaptured()) {
							System.out.println("\n--- Search For Project ---");
							projectPoise.searchProj(projectPoise);
						} else {
							System.out.println(nullPointerMessage);
						} 
					}
					
					// Edit project fee, if project is captured.
					case 7 -> { 
						if (projectPoise.projectCaptured()) {
							System.out.println("\n--- Edit Project Fee ---");
							projectPoise.editProjFee(projectPoise);
						} else {
							System.out.println(nullPointerMessage);
						} 
					}
					
					// Update Contractors details, if person is captured.
					case 8 -> { 
						if (projectContractor.personCaptured()) {
							System.out.println("\n--- Update Contractors Details ---");
							projectContractor.editPersonData(projectContractor, projectPoise);
						} else {
							System.out.println(nullPointerMessage);
						} 
					}
									
					// Exit Program
					case 9 -> { 
						System.out.println("Poised program closed."); 
						System.exit(0);
					}
				
					// Notify of invalid input.
					default -> {
						System.out.println("Invalid menu choice, please try again.");
						throw new IllegalArgumentException();
					}
				} 
			}
			// Else if menu input choice contains letters and no numbers, notify of invalid input.
			else if (inputChoice.matches("[^0-9]") && inputChoice.matches("[a-zA-Z]+")) {
				System.out.println("Invalid entry, ensure input choice contains numbers only.");
			}
			else {
				break;
			}
		} 
		// Close scanner object when while loop breaks.
		input.close();	
	}

}

		