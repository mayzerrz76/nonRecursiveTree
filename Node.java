package binarysearchtree;

/**********************************************************
* Program Name   : Node
* Author         : Ryan May
* Due Date       : 11/17/2020
* Course/Section : CSC112-301
* Program Description: This class allows you to construct
*    node objects that contain data about a person, as well
*   as references to the node's left and right child nodes. The
*   class provides methods to retrieve or set either child node
*   references. There is a method that returns a persons last
*   name from a node, and a method that returns a persons id number.
*   The class also provides a method that formats an object of
*   this class to string, and returns it for display purposes.
*   The references to the left and right child nodes allows
*    objects of this class to work with a binary tree.
*
* Methods:
* -------
* Constructor   -  Instantiates an obect of this class and initializes
*		   		   the instance data. Constructs a node object using person
*		           data passed in as parameter, and sets left and right child
*                  nodes to null.
* setRightChild -  Sets the reference of the right child node to the node passed in
* setLeftChild  -  Sets the reference of the left child node to the node passed in
* getRightChild -  Returns reference to the right child node
* getLeftChild  -  Returns reference to the left child node
* getlastName   -  Returns the last name of the person in node as string
* getIdNum		-  Returns the id number of person in node as string
* toString      -  Returns string representation of node object for output
**********************************************************/
public class Node
{
	//class constants

	//class variables
	private String firstName;		//Represents first name of a person
	private String lastName;		//Represents last name of a person
	private String idNumber;		//Represents persons ID number
	private Node rightChild;		//Represents reference to left child node in tree
	private Node leftChild;			//Represents referenct to right child node in tree

	/**************************************************************/

	/**********************************************************
	* Method Name    : Node(Constructor)
	* Author         : Ryan May
	* Due Date       : 11/17/2020
	* Course/Section : CSC112-301
	* Program Description: This is a constructor method that is
	* 	 used to instantiate a Node object. The method takes a
	*	 person's first name, last name, and id number, and uses that
	*	 data to initialize the instance data of the node object.
	*	 The node's left and right child references are set to null.
	*
	* BEGIN Node(Constructor)
	*	 Initialize the instance data
	* END Node(Constructor)
    **********************************************************/
	public Node(String first, String last, String idIn)
	{
		//local constants

		//local variables

		/*******************************************************/

		//Initialize the instance data
		firstName = first;
		lastName = last;
		idNumber = idIn;
		rightChild = null;
		rightChild = null;

	}//END Node(Constuctor)

	/**********************************************************
	* Method Name    : setRightChild
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method takes a node object as a
	*	 parameter, and sets our left child reference to that node.
	*
	* BEGIN setRightChild
	*	 Set reference to next node to node passed in
	* END setRightChild
    **********************************************************/

	public void setRightChild(Node rightIn)
	{
		//local constants

		//local variables

		/*******************************************************/

		//Set reference to next node to node passed in
		rightChild = rightIn;

	}//END setRightChild

	/**********************************************************
	* Method Name    : setLeftChild
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method takes a node object as a
	*	 parameter, and sets our left child reference to that node.
	*
	* BEGIN setLeftChild
	*	 Set reference to next node to node passed in
	* END setRightChild
    **********************************************************/

	public void setLeftChild(Node leftIn)
	{
		//local constants

		//local variables

		/*******************************************************/

		//Set reference to next node to node passed in
		leftChild = leftIn;

	}//END setLeftChild


	/**********************************************************
	* Method Name    : getRightChild
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method returns a reference to the
	*	 right child node.
	*
	* BEGIN getRightChild
	*	 Return reference to next node
	* END getRightChild
    **********************************************************/
	public Node getRightChild()
	{
		//local constants

		//local variables

		/*******************************************************/

		//Return reference to next node
		return rightChild;

	}//END getRightChild

	/**********************************************************
	* Method Name    : getLeftChild
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method returns a reference to the
	*	 left child node.
	*
	* BEGIN getLeftChild
	*	 Return reference to next node
	* END getLeftChild
    **********************************************************/
	public Node getLeftChild()
	{
		//local constants

		//local variables

		/*******************************************************/

		//Return reference to next node
		return leftChild;

	}//END getLeftChild

	/**********************************************************
	* Method Name    : getLastName
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method returns the last name that
	*	 is stored in the node as a string.
	*
	* BEGIN getLastName
	*	 Return person's last name from node
	* END getLastName
    **********************************************************/
	public String getLastName()
	{
		//local constants

		//local variables

		/*******************************************************/

		//Return person's last name from node
		return lastName;

	}//END getLastName

	/**********************************************************
	* Method Name    : getIdNum
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method returns the id number that
	*	 is stored in the node as a string.
	*
	* BEGIN getIdNum
	*	 Return person's id number from node
	* END getIdNum
    **********************************************************/
	public String getIdNum()
	{
		//local constants

		//local variables

		/*******************************************************/

		//Return person's id number from node
		return idNumber;

	}//END getIdNum

	/**********************************************************
	* Method Name    : toString
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method will format the data of a
	*	 node object to a string for output purposes.
	*
	* BEGIN toString
	*    Format the persons name to full name
	*	 Phone book format the person's name
	*	 Format length of name
	*	 Format the output for display with id number
	*	 Return the output
	* END toString
    **********************************************************/

	public String toString()
	{
		//local constants
		final int NAME_LENGTH = 20;		//Represents max length of full name

		//local variables
		String fullName;				//Represents full name of person
		String output;					//Represent string output of object

		/*******************************************************/

		//Format the persons name to full name
		fullName = firstName + " " + lastName;

		//Phone book format the person's name
		fullName = Util.phoneBookFormat(fullName);

		//Format length of name
		fullName = Util.formatNameLength(NAME_LENGTH, fullName);

		//Format the output for display with idNumber
		output = fullName + Util.setRight(10, "" + idNumber);

		//Return the output
		return output;

	}//END toString

}//END Node