package binarysearchtree;

/**********************************************************
* Program Name   : BinarySearchDriver (Linked List)
* Author         : Ryan May
* Due Date       : 11/20/2020
* Course/Section : CSC112-301
* Program Description: This program creates a binary search tree and allows
*	 the user to perform different actions to the tree.  The tree holds
*	 node objects that contain info about a person. The user is presented
*	 menu options to select an action to perform on the list.  The menu
*	 options include adding people to the tree, deleting people from the
*	 tree, displaying the people in tree, populating the tree from an input file,
*	 and quitting the program. The program lets the user know when an
*	 addition or deletion of a person to the tree was made or not. The
*	 program also handles bad menu input, by displaying an error message
*	 to the user, and carefully returning to the menu.  When the user chooses
*	 to quit the program, an exit message with an author signature will be displayed.
*
* Methods:
* -------
* main		    -  Instantiates a binary object and provides a menu to user
*	   			   to select different actions to perform on the list. Displays and
*				   error message for invalid selection, and an exit message when
*				   user quits.
* menu		 	-  Displays a menu options to user, with numbers next to each option.
*				   This method prompts the user for a menu selction and returns user
*				   selection as string.
* addPeople     -  Allows user to add multiple people(nodes) to the binary tree
* deletePeople  -  Allows user to delete multiple people(nodes) from the binary tree
* createPerson  -  Prompts user for person info and uses info to instantiate a node(person)
*	   			   object, and returns the node(person) object.
* populateTree  -  This method will read people data in from a text file used to instantiate
*                  node(person) objects. The method adds each node created from file data into
*		   		   the binary tree.
* displayTree   -  Displays each node(person) in binary tree in order by ID number
* errorMessage	-  Displays an error message to the user for invalid menu selection
* exitMessage   -  Displays exit message and program author signature
**********************************************************/

import java.util.*;
import java.io.*;

public class BinarySearchDriver
{

	/**********************************************************
	* Method Name    : main
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method instantiates a binary tree object and
	*	 presents a menu to the user to allow them to perform different actions
	*	 on the binary tree object.  The menu provides options for the user to
	*	 add people to the tree, delete people from the tree, display people in the
	*	 tree in order by ID , populate the tree from an input file, or quit.
	*	 If the user chooses an invalid menu selection, an error message will be
	*	 displayed to user.  When the user chooses quit, an exit message will be
	*	 displayed and the program will end.
	*
	* BEGIN main
	*	 Instantiate a binary tree object
	*	 Call the menu method to display menu and get user menu selection
	*	 WHILE(The selection is not quit)
	*	  	 IF(User selection is add people to tree)
	*			Call method to add people
	*	  	 ELSE
	*			IF(User selection is delete people from tree)
	*			   Call method to delete people
	*			ELSE
	*			   IF(User selection is display people in binary tree)
	*				  Call method to display tree in order by peoples' ID num
	*			   ELSE
	*				  IF(User selection is populate binary tree)
	*					 Call method to populate tree from a file
	*				  ELSE
	*				  	 Call method to display error message
	*				  END IF(User selection is populate binary tree)
	*		       END IF(User selection is display people in binary tree)
	*			END IF(User selection is delete people from tree)
	*		 END IF(User selection is add people to tree)
	*		 Call the menu method to display menu and get user menu selection
	*	 END WHILE(User selection is not QUIT)
	*	 Call method to display exit message to user
	* END main
    **********************************************************/
	public static void main(String [] args)
	{
		//local constants
		final String QUIT = "0";					//Used as a quit sentinel value for our menu
		final String ADD_PEOPLE = "1";				//Represents the add people to tree menu choice
		final String DELETE_PEOPLE = "2";			//Represents the delete people from tree menu choice
		final String DISPLAY_TREE = "3";			//Represents the display binary tree in order menu choice
		final String POPULATE_TREE = "4";			//Represents the populate binary tree menu choice

		//local variables
		BinaryTree treePpl;							//Binary tree of nodes that contain person data
		String userSelection;						//Represents user menu selection

		/*******************************************************/

		//Instantiate a linked list object
		treePpl = new BinaryTree();

		//Call the menu method to display menu and get user menu selection
		userSelection = menu();

		//WHILE(User selection is not QUIT)
		while(!userSelection.equals(QUIT))
		{
			//IF(User selection is add people to tree)
			if(userSelection.equals(ADD_PEOPLE))

				//Call method to add people
				addPeople(treePpl);

			//ELSE
			else

				//IF(User selection is delete people from tree)
				if(userSelection.equals(DELETE_PEOPLE))

					//Call method to delete people
					deletePeople(treePpl);

				//ELSE
				else

					//IF(User selection is display people in binary tree)
					if(userSelection.equals(DISPLAY_TREE))

						//Call method to display tree in order by peoples' ID num
						displayTree(treePpl);

					//ELSE(User selection is invalid)
					else

						//IF(User selection is populate binary tree)
						if(userSelection.equals(POPULATE_TREE))

							//Call method to populate tree from a file
							populateTree(treePpl);

						//ELSE
						else

							//Call method to display error message
							errorMessage();

						//END IF(User selection is populate binary tree)

					//END IF(User selection is display people in binary tree)

				//END IF(User selection is delete people from tree)

			//END IF(User selection is add people to tree)

			//Call method to get menu selection from user
			userSelection = menu();

		}//END WHILE(User selection is not QUIT)

		//Call method to display exit message to user
		exitMessage();

	}//END main

	/**********************************************************
	* Method Name    : menu
	* Author         : Ryan May
	* Due Date       : 11/11/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and display
	*	 a menu with numbers next to each menu choice.  The method then
	*	 prompts the user for their menu choice.  Their menu choice is
	*	 returned as a string.
	*
	* BEGIN menu
	*	 Clear the screen
	*	 Display a menu header
	*	 Display menu options with number choices
	*	 Get menu choice from user
	*	 Return menu choice as a string
	* END menu
	**********************************************************/
	public static String menu()
	{
		//local constants

		//local variables
		String menuChoice;							//Represents user's menu choice as a string
		Scanner scan = new Scanner(System.in);		//Scanner object used to get keyboard input from user

		/*******************************************************/

		//Clear the screen
		Util.cls();

		//Display a menu header
		System.out.print("\n\n\n" + Util.center("BINARY TREE MENU"));

		//Display menu options with number choices
		System.out.print("\n\n" +
						Util.setLeft(46,"(0) Quit Binary Tree Program") + "\n" +
						Util.setLeft(46,"(1) Add People to Binary Tree") + "\n" +
						Util.setLeft(46,"(2) Delete People from Binary Tree") + "\n" +
						Util.setLeft(46,"(3) Display Binary Tree in Order") + "\n" +
						Util.setLeft(46,"(4) Populate Binary Tree from File") + "\n\n" +
						Util.center("Enter a menu choice number: "));

		//Get menu choice from user input
		menuChoice = scan.nextLine();

		//Return user menu choice as a string
		return menuChoice;

	}//END menu

	/**********************************************************
	* Method Name    : addPeople
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method will call upon the create
	*	 person method to allow a user to create a node object by inputting
	*	 person info. That method returns the created node object that we can
	*	 use to add to the binary tree passed in as a parameter.  This
	*	 method calls upon a binary tree method that will take the node
	*	 created, and add it to the tree in a way that that when the
	*	 tree is traversed in order, the tree will be in order by ID number.
	*	 If the node was added, this method will display a message
	*    that it was added. If the node was not added, a message will
	*	 display indicating node(person) was not added to the tree.
	*	 This method allows for multiple people to be added to the
	*	 binary tree until the user chooses to quit to the menu.
	*	 The method forces the user to add at least one person to the tree.
	*
	* BEGIN addPeople
	*	 Call method to create a person
	*	 IF(Method called to add person returns true)
	*	 	Display message that person was added to tree
	*	 ELSE(Person was not added)
	*	 	Display message that person was NOT added to tree
	*	 END IF(Method called to add person returns true)
	*	 Ask user if they would like to add another person
	*	 WHILE(User chooses to add more)
	*	 	Call method to create a person
	*	 	IF(Method called to add person returns true)
	*	 		Display message that person was added to tree
	*	 	ELSE(Person was not added)
	*	 		Display message that person was NOT added to tree
	*	 	END IF(Method called to add person returns true)
	*	 	Ask user if they would like to add another person
	*	 END WHILE(User does not quit to menu)
	* END addPeople
	**********************************************************/
	public static void addPeople(BinaryTree treeIn)
	{
		//local constants
		final String QUIT = "N";					//Represents quit to menu value
		final String CONTINUE = "Y";				//Represents value to add more people to list

		//local variables
		Scanner scan = new Scanner(System.in);		//Scanner object used to get keyboard input from user
		Node tempPerson;							//Represents a temporary node object used to add to list
		String addMore;								//Represents users choice to add more or quit to menu

		/*******************************************************/

		//Call method to create a person
		tempPerson = createPerson();

		//IF(Method called to add person returns true)
		if(treeIn.addPerson(tempPerson))

			//Display message that person was added to tree
			System.out.print("\n\n" + Util.center("Person was added to tree") +
						     "\n\n");

		//ELSE(Person was not added)
		else

			//Display message that person was NOT added to tree
			System.out.print("\n\n" + Util.center("Person was NOT added to tree") +
							 "\n\n");

		//END IF(Method called to add person returns true)

		//Ask user if they would like to add another person
		System.out.print(Util.setLeft(47, "Add another person? [Y/N]: "));
		addMore = scan.next();

		//WHILE(User chooses to add more)
		while(addMore.equalsIgnoreCase(CONTINUE))
		{
			//Call method to create a person
			tempPerson = createPerson();

			//IF(Method called to add person returns true)
			if(treeIn.addPerson(tempPerson))

				//Display message that person was added to tree
				System.out.print("\n\n" + Util.center("Person was added to tree") +
						         "\n\n");

			//ELSE(Person was not added)
			else

				//Display message that person was NOT added to tree
				System.out.print("\n\n" + Util.center("Person was NOT added to tree") +
							     "\n\n");

			//END IF(Method called to add person returns true)

			//Ask user if they would like to add another person
			System.out.print(Util.setLeft(47, "Add another person? [Y/N]: "));
			addMore = scan.next();

		}//END WHILE(User chooses to add more)

	}//END addPerson

	/**********************************************************
	* Method Name    : deletePeople
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and prompt
	*	 user for a persons id number to delete the person with that ID from
	*	 binary tree passed in as a parameter.  This method will call a method
	*	 of the binary tree object to search the tree for a node with the same id
	*	 number and delete the person at corresponding node, if a matching node is
	*	 found. This method will let the user know if a person was deleted from
	*	 the tree or not by displaying corresponding message. This method
	*	 allows the user to delete as many people as they want from the
	*	 tree until they choose to quit to the menu. The method forces user
	*	 to enter at least one last name to delete, when this method is called.
	*
	* BEGIN deletePeople
	*	 IF(Tree is empty)
	*	 	Clear screen
	*		Display message that the tree is empty
	*		Pause the screen
	*	 ELSE(Tree is not empty)
	*	 	Clear screen
	*		Display the list data header
	*		Display the tree
	*	 	Prompt user for an ID of a person to delete
	*	 	Clear the screen again
	*	 	IF(Method called to delete person returns true)
	*	 		Display message that person was deleted
	*	 	ELSE(Person was not deleted)
	*	 		Display message that person was NOT deleted
	*		END IF(Method called to delete person returns true)
	*		Display the list data header
	*		Display the tree
	*	 	Prompt user for another id number or quit to menu
	*	 	WHILE(User does not quit to menu)
	*	 		Clear the Screen
	*	 		IF(Method called to delete person returns true)
	*	 			Display message that person was deleted
	*	 		ELSE(Person was not deleted)
	*	 			Display message that person was NOT deleted
	*	 		END IF(Method called to delete person returns true)
	*			Display the list data header
	*			Display the tree
	*	 		Prompt user for another id number or quit to menu
	*	 	END WHILE(User does not quit to menu)
	*	 END IF(Tree is empty)
	* END deletePeople
	**********************************************************/
	public static void deletePeople(BinaryTree treeIn)
	{
		//local constants
		final String QUIT = "0";					//Represents delete people loop quit value

		//local variables
		String idNumIn;								//Id number input by user used to search tree for deletion
		Scanner scan = new Scanner(System.in);		//Scanner object used to get keyboard input from user
		String pause;								//Arbitrary input value used to pause the screen

		/*******************************************************/

		//IF(Tree is empty)
		if(treeIn.getRoot() == null)
		{
			//Clear the screen
			Util.cls();

			//Display message that the tree is empty
			System.out.print("\n\n" + Util.center("Tree is empty, there are no nodes to delete") +
							 "\n" + Util.center("Enter 0 to return to the main menu: "));

			//Pause the screen
			pause = scan.nextLine();

		}

		//ELSE(Tree is not empty)
		else
		{
			//Clear the screen
			Util.cls();

			//Display a list data header
			System.out.print("\n\n\n"+ Util.center("NAME                    ID NUM") +
							 "\n");

			//Display the tree
			System.out.print(treeIn.toString());

			//Prompt user for an ID of a person to delete
			System.out.print("\n\n" + Util.center("Enter ID number of person to delete: "));
			idNumIn = scan.next();

			//Clear the screen again
			Util.cls();

			//IF(Method called to delete person returns true)
			if(treeIn.deletePerson(idNumIn))

				//Display message that person was deleted
				System.out.print("\n" + Util.center("Person was deleted"));

			//ELSE(Person was not deleted)
			else

				//Display message that person was NOT deleted
				System.out.print("\n" + Util.center("Person was NOT deleted"));

			//END IF(Method called to delete person returns true)

			//Display a list data header
			System.out.print("\n\n"+ Util.center("NAME                    ID NUM") +
							 "\n");

			//Display the tree
			System.out.print(treeIn.toString() + "\n");

			//Prompt user for another id number or quit to menu
			System.out.print(Util.center("Enter another ID number or 0 for menu: "));
			idNumIn = scan.next();

			//WHILE(User does not quit to menu)
			while(!idNumIn.equals(QUIT))
			{

				//Clear the screen
				Util.cls();

				//IF(Method called to delete person returns true)
				if(treeIn.deletePerson(idNumIn))

					//Display message that person was deleted
					System.out.print("\n" + Util.center("Person was deleted"));
				//ELSE(Person was not deleted)
				else

					//Display message that person was NOT deleted
					System.out.print("\n" + Util.center("Person was NOT deleted"));

				//END IF(Method called to delete person returns true)

				//Display a list data header
				System.out.print("\n\n"+ Util.center("NAME                    ID NUM") +
								 "\n");

				//Display the tree
				System.out.print(treeIn.toString() + "\n");

				//Prompt user for another id number or quit to menu
				System.out.print(Util.center("Enter another ID number or 0 for menu: "));
				idNumIn = scan.next();

			}//END WHILE(User does not quit to menu)

		}//END IF(Tree is empty)

	}//END deletePeople

	/**********************************************************
	* Method Name    : createPerson
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and prompt
	*	 user for person info that is used to instantiate and return
	*	 a node object that represents a person.  The person info includes
	*	 first name, last name, and person's id number.
	*
	* BEGIN createPerson
	*	 Clear screen
	*	 Prompt user for first name
	*	 Prompt user for last name
	*	 Prompt user for id number
	*	 Instantiate person(node) object using user input
	*	 Return created person(node) object
	* END createPerson
	**********************************************************/
	public static Node createPerson()
	{
		//local constants

		//local variables
		String firstIn;								//First name input by user
		String lastIn;								//Last name input by user
		String idIn;								//Persons id number input by user
		Scanner scan = new Scanner(System.in);		//Scanner object used to get keyboard input from user
		Node person;								//Node person object to instantiate and return

		/*******************************************************/

		//Clear the screen
		Util.cls();

		//Prompt user for first name
		System.out.print("\n\n" + Util.center("Enter a first name: "));
		firstIn = scan.nextLine();

		//Prompt user for last name
		System.out.print(Util.center("Enter a last name : "));
		lastIn = scan.nextLine();

		//Prompt user for id number
		System.out.print(Util.center("Enter persons ID #: "));
		idIn = scan.nextLine();

		//Instantiate person(node) object using user input
		person = new Node(firstIn, lastIn, idIn);

		//Return created person(node) object
		return person;

	}//END createPerson

	/**********************************************************
	* Method Name    : displayTree
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method will clear the screen and display
	*	 the people(nodes) from the binary tree object passed in. The people
	*	 will be displayed in order according to each persons ID number.
	*	 A data header is also provided above the names displayed.
	*	 When the object is printed, Java automatically calls the toString
	*	 method of the binary object passed in. If the tree is empty
	*	 a message will be displayed letting the user know list is empty.
	*
	* BEGIN displayTree
	*	 Clear screen
	*	 Display a tree data header
	*	 IF(Tree is empty)
	*		Display message that tree is empty
	*	 END IF(Tree is empty)
	*	 Display the tree
	*	 Pause screen by asking for input
	* END displayTree
	**********************************************************/
	public static void displayTree(BinaryTree treeIn)
	{
		//local constants

		//local variables
		String pause;							//Aribitrary value used to pause the screen
		Scanner scan = new Scanner(System.in);	//Scanner object use to pause the screen

		/****************************************************/

		//Clear the screen
		Util.cls();

		//Display a list data header
		System.out.print("\n\n"+ Util.center("NAME                    ID NUM") +
						 "\n");

		//IF(Tree is empty)
		if(treeIn.getRoot() == null)

			//Display message that tree is empty
			System.out.print("\n"+ Util.center("Tree is empty"));

		//END IF(Tree is empty)

		//Display the tree
		System.out.print(treeIn.toString());

		//Pause the screen by asking for input
		System.out.print("\n\n\n"+ Util.center("Enter 0 to return to main menu: "));
		pause = scan.nextLine();

	}//END displayTree

	/**********************************************************
	* Method Name    : populateTree
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method will read input in from a file.
	*	 The file read in contains info about people.  Each line has of
	*	 the file contains a person's first name, last name and id number.
	*	 This method reads in each line and uses the lines info to create
	*	 a person(node) object.  Each object created from the file will be
	*    added to the binary tree.  The method lets the user know that the
	*	 tree was populated.
	*
	* BEGIN populateTree
	*	 TRY(Reading file in to populate tree)
	*	 	Open the input stream for reading
	*	 	Get first file line from the file
	*		WHILE(File line is not NULL)
	*			Instantiate a string tokenizer object to read tokens from line
	*			Get first name from file line
	*			Get last name from file line
	*			Get persons id number from file line
	*			Create a node(person) object using data read in from file
	*			Add node created from file input to the binary tree passed in
	*			Get next line from file
	*		END WHILE(File line is not NULL)
	*		Clear the screen
	*		Display message that tree was populated
	*		Pause the screen by asking for input
	*	 END TRY(Reading file in to populate tree)
	*	 CATCH(IO exception)
	*		Display exception to user
	*	 END CATCH(IO exception)
	* END populateTree
	**********************************************************/
	public static void populateTree(BinaryTree treeIn)
	{
		//local constants
		final String FILE_NAME = "peopleIDList.txt";

		//local variables
		FileReader inFileRead;					//Object establishes relationship between program and input file
		BufferedReader bufReader;         		//Object uses FileReader object to read lines of input from file
		String fileLine;						//Represents a line grabbed from input file
		StringTokenizer line;					//String tokenizer object that allows us to analyze tokens
		String firstNameIn, lastNameIn;			//Represents persons first name and last name as strings read from file line
		String idIn;							//Represents id number of person read in from file line
		Node nodeIn;							//Represents node object created from data read in from a file line
		Scanner scan = new Scanner(System.in);	//Scanner object used to get input when screen is paused
		String pauseScreen;						//Arbitrary value input used to pause the screen

		/****************************************************/

		//TRY(Reading file in to populate tree)
		try
		{
			//Open the input stream for reading
			inFileRead = new FileReader(FILE_NAME);
			bufReader = new BufferedReader(inFileRead);

			//Get first file line from the file
			fileLine = bufReader.readLine();

			//WHILE(File line is not NULL)
			while(fileLine != null)
			{
				//Instantiate a string tokenizer object to read tokens from line
				line = new StringTokenizer(fileLine);

				//Get first name from file line
				firstNameIn = line.nextToken();

				//Get last name from file line
				lastNameIn = line.nextToken();

				//Get persons age from file line
				idIn = line.nextToken();

				//Create a node(person) object using data read in from file
				nodeIn = new Node(firstNameIn, lastNameIn, idIn);

				//Add node created from file input to the binary tree passed in
				treeIn.addPerson(nodeIn);

				//Get next line from file
				fileLine = bufReader.readLine();

			}//END WHILE(File line is not NULL)

			//Clear the screen
			Util.cls();

			//Display message that tree was populated
			System.out.print("\n\n" + Util.center("Tree was populated!") +
							 "\n" + Util.center("Enter 0 to return to menu: "));

			//Pause the screen by asking for input
			pauseScreen = scan.nextLine();

		}//END TRY(Reading file in to populate tree)

		//CATCH(IO exception)
		catch(IOException fileEx)
		{
			//Display exception to user
			System.out.print(fileEx);

		}//END CATCH(IO exception)

	}//END populateTree

    /**********************************************************
    * Method Name    : errorMessage
    * Author         : Ryan May
    * Due Date       : 11/20/2020
    * Course/Section : CSC112-301
    * Program Description: This method will clear the screen and display
    *	 an error message to the user. This method pauses the screen on
    *	 the message by asking for input.
    *
    * BEGIN errorMessage
    *	 Clear screen
    *	 Display error message
    *	 Pause screen by asking for input
    * END errorMessage
    **********************************************************/
    public static void errorMessage()
    {
        //local constants

        //local variables
        String errorPause;							//Aribitrary value used to pause the screen
        Scanner scan = new Scanner(System.in);		//Scanner object used for screen pause

        /****************************************************/

        //Clear screen
        Util.cls();

        //Display error message
        System.out.print("\n\n" +
                        Util.center("Your selection was invalid!!"));

        //Pause screen by asking for input
        System.out.print("\n\n" +
                        Util.center("Enter 0 to return to the main menu: "));
        errorPause = scan.nextLine();

    }//END errorMessage

    /**********************************************************
    * Method Name    : exitMessage
    * Author         : Ryan May
    * Due Date       : 11/20/2020
    * Course/Section : CSC112-301
    * Program Description: This method will clear the screen and display
    *	 an exit and thank you method with author signature.
    *
    * BEGIN exitMessage
    *	 Clear screen
    *	 Display exit message
    *	 Display author signature
    * END exitMessage
    **********************************************************/
    public static void exitMessage()
    {
        //local constants

        //local variables

        /****************************************************/

        //Clear screen
        Util.cls();

        //Display exit message
        System.out.print("\n\n\n\n" +
                        Util.center("Thank you for using Binary Search Tree!!"));

        //Display author signature
        System.out.print("\n\n" +
                        Util.center("Created by:   Ryan May") + "\n" +
                        Util.center("Class     : CSC112-301") + "\n" +
                        Util.center("Due Date  : 11/20/2020") + "\n\n\n\n\n\n");

    }//END exitMessage

}//END BinarySearchDriver