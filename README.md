# Project Manager Ver. 2

A Java program that tracks various projects details and project members.

## Description

This program is for a fictitious structural engineering firm, called Poised, that allows them to capture project information, edit the deadlinie, finalise a project, view an exisitng projects details, search for a project and update the details of a project contractor.

It is the second version of the Project Manager program which has now been fully debugged; formatted to adhere to Java style guidelines; and refactored to improve the quality and readability of the code including defensive programming practices to catch errors.

Updates:
* The ``Project()`` class incorporates exception handling with try-catch, together with regex expressions, *.matches()*, *.equals()* and *.compareTo()* functions, blocks to validate all user inputs of project details.
* The ``Person()`` class incorporates conditional logic, together with regex expressions, *.matches()*, *.isBlank()* and *.contains()* functions, to validate all user inputs of the architect, contractor and customer details.
* The ``Person()`` class was deconstructed into seperate ``Architect()``, ``Customer()`` and ``Contractor()`` classes which now extends the ``Person()``` abstract class, with each having their own properties to ensure weak coupling.
* All methods related to the various 'persons', that were previously in the Main class, have now been moved to the ``Persons()`` class to ensure high levels of cohesion.
* Reduced nesting complexity with switch statements and implemented arrow case labels to eliminate the need for break statements and prevent fall through.
* Code is fully debugged with no runtime or logical errors.
* Code has been meticulously formatted to adhere to the Java Style Guidelines and variable names have been updated to be more descriptive.

The program includes the following classes and subclasses:

* Main()
* Project()
* Person()
	* Architect()
	* Contractor()
	* Customer()
	
## The Program

At startup, global Project, Architect, Contractor and Customer objects are instantiated. The staff member is presented with the Poised program menu. In order to use the functions of the program, a project must first be captured.

From the menu, in the ``Main()`` class, the staff member is able to:

* Create and capture a new Poise project, including architect, contractor and customer details
* Edit the projects due date
* Finalise a project
* View all incomplete projects
* View all overdue projects
* Search for a project
* Edit a projects fee
* Update the contractors details
* Exit the program

Each menu option calls the related class method for action. 

A new project (object) is captured in the ``Project()`` class. The project also contains the customer, architect and contractor (object) properties. When a project is captured or edited the details are added to the internal database, which is then written to an external file when the project is finalised. When a project is finalised, the completion date is added and an invoice is generated if there is an oustanding fee on the project.

The ``Project()`` class includes functions to:

* captureProject()
* editProjDeadline()
* markProjFinalisation()
* generateProjInvoice()
* writeCompletedProjToFile()
* viewIncompleteProj()
* viewOverdueProj()
* searchProj()
* editProjFee()
* createProjectName()

The ``Project()`` class includes the attributes, along with getters and setters for:

* projNumber
* projName
* projType
* projAddress
* projErf
* feeTotal
* feePaid
* projDeadline
* projFinalised
* projCompletionDate
* projectCaptured
* customer
* architect
* contractor

A new architect, contractor and customer (objects) is captured in their respective subclasses which extends the ``Person()`` class. The ``Person()`` class allows the user to capture and edit the various persons details. The subclasses ``Architect()``, ``Contractor()``, and ``Customer()`` have their own *toString()* methods which overrides the abstract *toString()* method in the ``Person()`` class.

The ``Person()`` class includes functions to:

* capturePersonData()
* editPersonData()

The Person class includes the attributes, along with getters and setters for:

* fullName
* contactNumber
* email
* address



## Functionality summary:

* Capture information about new projects.
* Edit the projects deadline.
* Finalise existing projects.
* See a list of projects that still need to be completed.
* See a list of projects that are past the due date.
* Find and select a project by entering either the project number or project name.
* Change the total fee of the project.
* Update the contractors contact details

## Programming principles

This program employs the programming concepts of Java OOP including classes, accessor and mutator methods, dot notation and functions. Furthermore it employs fundamental programming techniques that include external IO databases, comparison operators, conditional logic, loops, indexing, date formatting and regex expressions. Lastly, it also employs the built in matches(), equals(), compareTo() and isBlank() functions.

## Dependencies

import java.util.Locale;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

## Running the program

Open all the files in the poised package in any Java IDE and run the Main.java file.

## Code preview

```java
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
```

## Program output preview

```
--- Project Information ---

Project Number: 1
Project Name: House Deer
Building Type: House
Physical address: 11 Acacia drive, Franschhoek, Western Cape
ERF Number: 10111
Total fee.: 1000000.0
Total paid: 10000.0
Deadline: Fri Oct 01 00:00:00 SAST 2021
Finalised: false
Completion date: null

--- Customer's Information ---

Name: John Deer
Phone number: 0820001111
Email address: john@email.com
Work address: 11 Veld street, Swellendam, Western Cape

--- Architect's Information ---

Name: Alistair Archi
Phone number: 0720001111
Email address: alistair@email.com
Work address: 11 Main road, Cape Town CBD, Western Cape

--- Contractor's Information ---

Name: Calvin Contra
Phone number: 0620001111
Email address: calvin@email.com
Work address: 11 Industrial drive, Paarl, Western Cape
```

&nbsp;
***  
_A project is complete when it starts working for you, rather than you working for it._ ~ Scott Allen
***
&nbsp;

## Author

Megan Bisschoff

Project submitted for Software Engineering learnership Level 2 Task 21 at [HyperionDev](https://www.hyperiondev.com/)

[View](https://www.hyperiondev.com/portfolio/86596/) submission results.
