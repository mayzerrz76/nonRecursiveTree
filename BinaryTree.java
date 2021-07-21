package binarysearchtree;

import java.util.*;

/**********************************************************
* Program Name   : BinaryTree
* Author         : Ryan May
* Due Date       : 11/11/2020
* Course/Section : CSC112-301
* Program Description: This class allows you to construct
*	 a binary tree object that holds nodes that contain info
*	 about people, including their first name last name, and
*	 id number. This program provides public methods to return the
*	 root node of the tree, add a person to the binary tree,
*	 delete a person by id number from a binary tree.  The program
*	 provides private support methods that aide the deletePerson
*	 method in deleting a node from the tree.  The program also
*	 provides a toString method that displays the tree in order according
*	 to a person's(node) id number.
*
* Methods:
* -------
* Constructor     -  Instantiates an obect of this class and initializes
*				     the instance data. Constructs a binary object with
*				     head and tail initialized to null.
* getRootNode     -  Returns a reference to the binary trees root node object
* addPerson	 	  -  Takes a node object passed in and adds it to binary tree
*				     using an inOrder tree format.  The nodes are stored in order
*				     in tree, by idNumber.
* deletePerson    -  Takes id number passed in and traverses through the tree
*				     and deletes node if there is a match.
* findReplacement -  Takes a node to be deleted and returns a replacement for node to be deleted
* removeNode	  -  Takes an id number as a string and 2 node objects, and uses 2 node objects
*	  				 to traverse a subtree of the root, to find a node that matches the id passed in
*	 				 and deletes the node if a match is found.
* toString        -  Returns string representation of binary tree object for ouput
**********************************************************/

public class BinaryTree
{
    //class constants

    //class variables
    private Node root;		//Represents the root node of our binary tree object

    /*******************************************************/

    /**********************************************************
    * Method Name    : BinaryTree(Constructor)
    * Author         : Ryan May
    * Due Date       : 11/11/2020
    * Course/Section : CSC112-301
    * Program Description: This is a constructor method that is
    * 	 used to instantiate a LinkedList object. The method takes
    *	 no parameters and initializes the head and tail node of the
    *	 list to null. Thus the list is empty when constructor is called.
    *
    * BEGIN BinaryTree(Constructor)
    *	 Initialize the instance data
    * END BinaryTree(Constructor)
    **********************************************************/
    public BinaryTree()
    {
        //local constants

        //local variables

        /*******************************************************/

        //Initialize the instance data
        root = null;

    }//END BinaryTree(Constructor)

	/**********************************************************
	* Method Name    : getRoot
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method returns a reference to the
	*	 binary tree's root node.
	*
	* BEGIN getRoot
	*	 Return reference to the root node of the binary tree
	* END getRoot
    **********************************************************/
    public Node getRoot()
    {
		//local constants

		//local variables

		/**********************************************/

		//Return reference to the root node of the binary tree
        return root;

    }//END getRoot

    /**********************************************************
    * Method Name    : addPerson
    * Author         : Ryan May
    * Due Date       : 11/20/2020
    * Course/Section : CSC112-301
    * Program Description: This method takes a node object as a parameter
    *	 and add it to binary tree data structure.  The node is added in
    *	 such a way, that when the tree is traversed in order, the nodes of
    *	 the tree will be in ascending order by the nodes' id numbers. Adding
    *	 nodes to the tree allows us to dynamically allocate memory for node
    *	 objects created during runtime.  The tree also allows us to organize
    *	 node objects in the way we see fits. Here we are organizing nodes according
    *	 to id number.
    *
    * BEGIN addPerson
    *	 IF(The tree is empty)
    *	 	Set root to node passed in
    *		Set added boolean indicator to true
    *	ELSE(Tree is not empty)
    *		Set node in focus to root node
    *		WHILE(Until the node is added to the BST)
    *			IF(Node passed in has ID num greater than or equal to focus node)
    *				IF(Right child of focus node exists)
    *					Advance focus node pointer to right child
    *				ELSE(Right child does not exist)
    *					Set right child to node passed in
    *					Set 'added' boolean indicator to true to quit loop
    *				END IF(Right child of focus node exists)
    *			ELSE(Node passed in has ID num less than focus node)
    *				IF(Left child of focus node exists)
    *					Advance focus node pointer to left child
    *				ELSE(Left child does not exist)
    *					Set left child to node passed in
    *					Set 'added' boolean indicator to true to quit loop
    *				END IF(Left child of focus node exists)
    *			END IF(Node passed in has ID num greater than or equal to focus node)
    *		END WHILE(Until the node is added to the BST)
    *	END IF(The tree is empty)
    * END addPerson
    **********************************************************/
    public boolean addPerson(Node nodeAdded)
    {
        //local constants

        //local variables
        Node focusNode;
        boolean added = false;

        /*******************************************************/

        //IF(The tree is empty)
        if(root == null)
        {
            //Set root to node passed in
            root = nodeAdded;

            //Set added boolean indicator to true
            added = true;

        }
        //ELSE(Tree is not empty)
        else
        {
            //Set node in focus to root node
            focusNode = root;

            //WHILE(Until the node is added to the BST)
            while(!added)
            {
                //IF(Node passed in has ID num greater than or equal to focus node)
                if(nodeAdded.getIdNum().compareToIgnoreCase(focusNode.getIdNum()) >= 0)
                {
                    //IF(Right child of focus node exists)
                    if(focusNode.getRightChild() != null)

                        //Advance focus node pointer to right child
                        focusNode = focusNode.getRightChild();

                    //ELSE(Right child of focus node does not exist)
                    else
                    {
                        //Set right child to node passed in
                        focusNode.setRightChild(nodeAdded);

                        //Set 'added' boolean indicator to true to quit add loop
                        added = true;

                    }//END IF(Right child of focus node exists)

                }

                //ELSE(Node passed in has ID num less than focus node)
                else
                {
                    //IF(Left child of focus node exists)
                    if(focusNode.getLeftChild() != null)

                        //Advance focus node pointer to left child
                        focusNode = focusNode.getLeftChild();

                    //ELSE(Left child does not exist)
                    else
                    {
                        //Set left child to node passed in
                        focusNode.setLeftChild(nodeAdded);

                        //Set 'added' boolean indicator to true to quit loop
                        added = true;

                    }//END IF(Left child of focus node exists)

                }//END IF(Node passed in has ID num greater than or equal to focus node)

            }//END WHILE(Until the node is added to the BST)

        }//END IF(The tree is empty)

        //Return boolean indicating if person was added
        return added;

    }//END addPerson

    /**********************************************************
    * Method Name    : findReplacement
    * Author         : Ryan May
    * Due Date       : 11/20/2020
    * Course/Section : CSC112-301
    * Program Description: This method is called when a node object to
    *	 delete has been found.  This method recieves the node object
    *	 that is to be deleted as a parameter.  It then uses that object
    *	 to determine the replacement node for it.  If the node to be deleted
    *	 has no children then null will be returned.  If the node has only one
    *	 child, that child will be returned.  In the case that the node passed in
    *	 has 2 children.  This method will traverse the nodes right sub tree to find the
    *	 minimum value in this sub tree.  This value is known as the inorder successor.
    *	 The in order successor's left and right child references will adjusted so that
    *	 it can be used to replace the node to be deleted.
    *
    * BEGIN findReplacement
    *    IF(Node passed in has no children)
    *     	 Return null as the replacement node
    *    ELSE IF(Node passed in has only a left child)
    *        Return replacement as node passed ins left child
    *    ELSE IF(Node passed in has only a left child)
    *        Return replacement as node passed ins right child
    *    ELSE(Node passed in has 2 children)
    *        Initialize parent to the node passed in
    *        Initialize current to right child to find in order successor
    *        WHILE(Current pointer has a left child)
    *          	 Advance parent to point to current
    *            Advance current to left child
    *        END WHILE(Current pointer has a left child
    *        Set the inorder succesors left child to left child of node passed in
    *        IF(The in order succesor is not the right child of node passed in)
    *            Set the left child of successors parent as succussors right child
    *            Set successors right child as the right child of node passed in
    *        END IF(The in order succesor is not the right child of node passed in)
   	*		 Set replacement node to return as the current node
   	*	 END IF(Node has no children)
   	*	 Return the replacement node
    * END findReplacement
    **********************************************************/

    private Node findReplacement(Node nodeIn)
    {
        //local constants

        //local variables
        Node replacement;
        Node current;
        Node parent;
        /**************************************************/

        //IF(Node passed in has no children)
        if(nodeIn.getLeftChild() == null && nodeIn.getRightChild() == null)
        {
            //Return null as the replacement node
            replacement = null;
        }

        //ELSE IF(Node passed in has only a left child)
        else if(nodeIn.getLeftChild()!= null && nodeIn.getRightChild() == null)
        {
            //Return replacement as node passed ins left child
            replacement = nodeIn.getLeftChild();
        }

        //ELSE IF(Node passed in has only a right child)
        else if(nodeIn.getLeftChild()== null && nodeIn.getRightChild()!= null)
        {
            //Return replacement as node passed ins right child
            replacement = nodeIn.getRightChild();
        }

        //ELSE(Node passed in has 2 children)
        else
        {
            //Initialize parent to the node passed in
            parent = nodeIn;

            //Initialize current to right child to find in order successor
            current = nodeIn.getRightChild();

            //WHILE(Current pointer has a left child)
            while(current.getLeftChild() != null)
            {
                //Advance parent to point to current
                parent = current;

                //Advance current to left child
                current = current.getLeftChild();

            }//END WHILE(Current pointer has a left child)

            //Set the inorder succesors left child to left child of node passed in
            current.setLeftChild(nodeIn.getLeftChild());

            //IF(The in order succesor is not the right child of node passed in)
            if(nodeIn.getRightChild() != current)
            {
                //Set the left child of successors parent as successors right child
                parent.setLeftChild(current.getRightChild());

                //Set successors right child as the right child of node passed in
                current.setRightChild(nodeIn.getRightChild());

            }//END IF(The in order succesor is not the right child of node passed in)

            //Set replacement node to return as the current node
            replacement = current;

        }//END IF(Node has no children)

        //Return the replacement node
        return replacement;

    }//END findReplacement


    /**********************************************************
    * Method Name    : deletePerson
    * Author         : Ryan May
    * Due Date       : 11/20/2020
    * Course/Section : CSC112-301
    * Program Description: This method takes a string representing a person's
    *	 id number and uses that ID number to search through the binary tree
    *	 data structure to see if the person is in the tree, and deletes the
    *	 person if they are in the tree.  The method starts by checking to see
    *    if it is the root node that needs to be deleted, since it is a special
    *	 case. If it is not the root that matches, his method then calls upon a
    *	 private support methods to traverse either the left or right subtree of the
    *	 root node depending on if the id passed in is less than or greater than id
    *	 of root node. This method relies on another support method to return a
    *	 replacement node to put in place of the node that the user wants to delete.
    *	 This method will return true if a node was deleted.
    *
    * BEGIN deletePerson
    *    IF(Binary tree is empty)
    *    	Set deleted boolean indicator to false
    *    ELSE(Binary tree is not empty)
	*		IF(ID passed in matches roots ID)
    *     		Call method to return replacement node for root node to be deleted
    *           IF(Replacement node returned is null)
    *           	Node has no children so set root to null to delete root
    *           ELSE(Replacement node is not null)
    *            	Set root to it's replacement node
    *           END IF(Replacement node returned is null)
	*			Set deleted boolean indicator to true
	*		ELSE(ID Passed in does not match root)
    *           IF(ID passed in is less than root node)
    *            	IF(Call to method to traverse left subtree of root to delete node returns true)
    *                	Set deleted boolean indicator to true
    *               ELSE(Call to method to traverse left subtree of root to delete node returns false)
    *                	Set deleted boolean indicator to false
    *	 			END IF(Call to method to traverse left subtree of root to delete node returns true)
    *           ELSE(ID passed in is greater than root node)
    *            	IF(Call to method to traverse right subtree of root to delete node returns true)
    *                	Set deleted boolean indicator to true
    *               ELSE(Call to method to traverse right subtree of root to delete node returns false)
    *                	Set deleted boolean indicator to false
    *				END IF(Call to method to traverse rightt subtree of root to delete node returns true)
    *           END IF(ID passed in is less than root node)
	*		END IF(ID passed in matches roots ID)
    *    END IF(Binary tree is empty)
    *    Return boolean indicating if person node was deleted
    * END deletePerson
    **********************************************************/
    public boolean deletePerson(String idIn)
    {
        //local constants

        //local variables
        Node temp;				//Used to hold the replacement node for the node to be deleted
        boolean deleted;		//Boolean indicating if node has been deleted
        /*****************************************/

        //IF(Binary tree is empty)
        if(root == null)
        {
            //Set deleted boolean indicator to false
            deleted = false;
        }

        //ELSE(Binary tree is not empty)
        else
        {
            //IF(ID passed in matches roots ID)
            if(idIn.compareToIgnoreCase(root.getIdNum()) == 0)
            {
                //Call method to return replacement node for root node to be deleted
                temp = findReplacement(root);

                //IF(Replacement node returned is null)
                if(temp == null)
                {
                    //Node has no children so set root to null to delete root
                    root = null;

                }

                //ELSE(Replacement node is not null)
                else
                {
                    //Set root to it's replacement node
                    root = temp;

                }//END IF(Replacement node returned is null)

                //Set deleted boolean indicator to true
                deleted = true;

            }
            //ELSE(ID Passed in does not match root)
            else
            {
                //IF(ID passed in is less than root node)
                if(idIn.compareToIgnoreCase(root.getIdNum()) < 0)
                {
                    //IF(Call to method to traverse left subtree of root to delete node returns true)
                    if(removeNode(idIn, root.getLeftChild(), root))

                        //Set deleted boolean indicator to true
                        deleted = true;

                    //ELSE(Call to method to traverse left subtree of root to delete node returns false)
                    else

                        //Set deleted boolean indicator to false
                        deleted = false;

                    //END IF(Call to method to traverse left subtree of root to delete node returns true)
                }

                //ELSE(ID passed in is greater than root node)
                else
                {
                    //IF(Call to method to traverse right subtree of root to delete node returns true)
                    if(removeNode(idIn, root.getRightChild(), root))

                        //Set deleted boolean indicator to true
                        deleted = true;

                    //ELSE(Call to method to traverse right subtree of root to delete node returns false)
                    else

                        //Set deleted boolean indicator to false
                        deleted = false;

                    //END IF(Call to method to traverse right subtree of root to delete node returns true)

                }//END IF(ID passed in is less than root node)

            }//END IF(ID passed in matches roots ID)

        }//END IF(Binary tree is empty)

        //Return boolean indicating if person node was deleted
        return deleted;

    }//END deletePerson

    /**********************************************************
    * Method Name    : removeNode
    * Author         : Ryan May
    * Due Date       : 11/20/2020
    * Course/Section : CSC112-301
    * Program Description: This method takes a string representing a person's
    *	 id number, and 2 nodes as parameters.  This method uses the 2 nodes
    *	 passed in to traverse a sub tree of the binary tree's root node. If
    *	 the node to be deleted is found in the sub tree, this method will
    *	 call upon a private support method to return a replacement node for
    *	 the node that we want to delete.  This method will return true if a
    *	 node was deleted.
    *
    * BEGIN removeNode
    *    WHILE(Child pointer exists and node to delete has not been found)
    *    	IF(ID passed in equals current child node)
    *       	Call method to return the replacement node for node to be deleted
    *           IF(Node to be deleted is a right child)
    *            	Set parents right child to replacement node
    *               Set found boolean indicator to true to exit delete loop
    *           ELSE(Node to be deleted is a left child)
    *            	Set parents left child to replacement node
    *               Set found boolean indicator to true to exit delete loop
    *           END IF(Node to be deleted is a right child)
	*		ELSE(ID passed in is not equal to ID of current child node)
    *        	Advance parent pointer to child pointer
    *           IF(ID passed in is less than current childs ID)
    *            	Advance child to its left child
    *           ELSE(ID passed in is greater than current childs ID)
    *            	Advance child to its right child
    *           	END IF(ID passed in is less than current childs ID)
    *       END IF(ID passed in equals current node)
	*	 END WHILE(Child pointer exists and node to delete has not been found)
  	*	 Return boolean indicating if node was found/deleted
    * END removeNode
    **********************************************************/
    private boolean removeNode(String idNum, Node childIn, Node parentIn)
    {
        //local constants

        //local variables
        Node temp;					//Used to hold the replacement node for the node to be deleted
        boolean found = false;		//Boolean indicating if element has been found/deleted
        /*********************************/

        //WHILE(Child pointer exists and node to delete has not been found)
        while(childIn != null && !found)
        {
            //IF(ID passed in equals current child node)
            if(idNum.equalsIgnoreCase(childIn.getIdNum()))
            {
                //Call method to return the replacement node for node to be deleted
                temp = findReplacement(childIn);

                //IF(Node to be deleted is a right child)
                if(parentIn.getRightChild() == childIn)
                {
                    //Set parents right child to replacement node
                    parentIn.setRightChild(temp);

                    //Set found boolean indicator to true to exit delete loop
                    found = true;
                }

                //ELSE(Node to be deleted is a left child)
                else
                {
                    //Set parents left child to replacement node
                    parentIn.setLeftChild(temp);

                    //Set found boolean indicator to true to exit delete loop
                    found = true;

                }//END IF(Node to be deleted is a right child)

            }

            //ELSE(ID passed in is not equal to ID of current child node)
            else
            {
                //Advance parent pointer to child pointer
                parentIn = childIn;

                //IF(ID passed in is less than current childs ID)
                if(idNum.compareToIgnoreCase(childIn.getIdNum()) < 0)

                    //Advance child to its left child
                    childIn = childIn.getLeftChild();

                //ELSE(ID passed in is greater than current childs ID)
                else

                    //Advance child to its right child
                    childIn = childIn.getRightChild();

                //END IF(ID passed in is less than current childs ID)

            }//END IF(ID passed in equals current node)

        }//END WHILE(Child pointer exists and node to delete has not been found)

		//Return boolean indicating if node was found/deleted
        return found;

    }//END removeNode

	/**********************************************************
	* Method Name    : toString
	* Author         : Ryan May
	* Due Date       : 11/20/2020
	* Course/Section : CSC112-301
	* Program Description: This method will format the data from a
	*	 binary tree data structure to string object type for output
	*	 purposes.  This method utilizes a stack to store node object
	*	 in as we perform an inorder traversal of the tree.  The stack
	*	 allows us to traverse through the array without losing access
	*	 to parent nodes, as they will be placed in the stack, and popped
	*	 off the stack when they should be displayed.  When the stack is
	*	 empty, it means that the tree has been travered.
	*
	* BEGIN toString
	*	 Set current node pointer to root node
    *    WHILE(The tree has not been traversed)
    *    	IF(Current node pointer is not null)
    *        	Push the current node onto the stack
    *           Advance current pointer to its left child
    *       ELSE(Current node pointer is null)
    *        	IF(The stack is empty)
    *            	Set traversed boolean indicator to true
    *           ELSE(Stack is not empty)
    *            	Pop node off stack and assign to current node pointer
    *               Add node to string output
    *               Advance current node to its right child
    *           END IF(The stack is empty)
	*		END IF(Current node pointer is not null
	*	 END WHILE(Tree is not traversed)
	*	 Return the trees output as a string
	* END toString
    **********************************************************/
    public String toString()
    {
        //local constants

        //local variables
        String output = "";								//String output of our binary tree object
        Node current;									//Represents current node while traversing tree in order
        Stack<Node> nodeStack = new Stack<Node>();		//Represents a stack to hold node objects used for in order display
        boolean traversed = false;						//Boolean indicating if tree has been traversed
        /****************************************/

		//Set current node pointer to root node
        current = root;

		//WHILE(The tree has not been traversed)
        while(!traversed)
        {
			//IF(Current node pointer is not null)
            if(current != null)
            {
				//Push the current node onto the stack
                nodeStack.push(current);

                //Advance current pointer to its left child
                current = current.getLeftChild();
            }

            //ELSE(Current node pointer is null)
            else
            {

				//IF(The stack is empty)
                if(nodeStack.isEmpty())
                {
					//Set traversed boolean indicator to true
                    traversed = true;
                }

                //ELSE(Stack is not empty)
                else
                {
					//Pop node off stack and assign to current node pointer
                    current = nodeStack.pop();

                    //Add node to string output
                    output += Util.center(current.toString()) + "\n";

                    //Advance current node to its right child
                    current = current.getRightChild();

                }//END IF(The stack is empty)

            }//END IF(Current node pointer is not null

        }//END WHILE(Tree is not traversed)

        //Return the trees output as a string
        return output;

    }//END toString

}//END BinaryTree