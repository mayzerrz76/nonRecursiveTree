package binarysearchtree;

/**
 *
 * @author mymac
 */
public class Util
{

   /**********************************************************
	* Method Name    : setLeft
	* Author         : Prof Scheemaker
	* Date           :
	* Course/Section :
	* Program Description:  This method will insert spaces
	*    in front of a string and return the new string. The
	*    number of spaces to insert and the string itself will
	*    be passed in as parameters.
	*
	* BEGIN setLeft (number of spaces, string)
	*   FOR (each space to be inserted)
	*      add a space to be beginning of the string
	*   END FOR
	*   return the new string with the leading spaces
	* END setLeft
	**********************************************************/

	public static String setLeft(int num, String word)
	{
		//local constants

		//local variables

		/*******************************************************/

		for (int i = 0;i < num;i++)

		   word = " " + word;

		return word;

	}
   /**********************************************************
	* Method Name    : setRight
	* Author         : Prof Scheemaker
	* Date           :
	* Course/Section :
	* Program Description:  This method will insert spaces
	*    in front of a string and return the new string. The
	*    number of spaces will be determined by the field
	*    width and the length of the string (Width - Length).
	*    If the string is wider than the field width, no
	*    spaces will be added to the front of the string
	*
	* BEGIN setRight (field width, string)
	*    Find the length of the string
	*    Calc the number of spaces to be added
	*    IF (there is room to add spaces)
	*       FOR (each space to be added)
	*          add a space to the front of the string
	*       END FOR
	*    END IF
	*    return the string
	* END setLeft
	**********************************************************/

	public static String setRight(int width, String word)
	{
		//local constants

        //local variables
		int len = word.length(); //get the string length
		int pad = width - len;   //how many spaces to add to front of string

		/*******************/

        //if there is room to add sapces
		if (len < width)

           //add the spaces to the front of the string
		   for (int i = 0; i < pad; i++)
		      word = " " + word;

        //return the string
		return word;

	}
	/**********************************************
	* Method Name        : cls
	* Author             : Gabriel Mercado
	* Date               : 1/29/2020
	* Course/Section     : CSC-264-501
	* Program Description: This method clears the screen.
	* BEGIN cls
	*	try to create a new processbuilder
	* END cls
	******************************************/
	public static void cls()
	{
		try
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (Exception E)
		{
			System.out.println(E);
		}

	}

    /**********************************************************
	* Method Name    : center
	* Author         : Ryan May
	* Date           : 11/11/2020
	* Course/Section :
	* Program Description:  This method will determine how many spaces
	*	 to add to the front of the string to center it on a 120px screen.
	*	 The formatted string with leading spaces will be returned
	*
	* BEGIN center
	*	Get length of string
	*	Calculate number of desired spaces
	*   FOR(Until desired number of spaces are added)
	*      Add a space to the front of the string
	*   END FOR
	*   Return the centered string
	* END center
	**********************************************************/

	public static String center(String word)
	{
		//local constants
		final int SCREEN_WIDTH = 120;

		//local variables
		int num;

		/*******************************************************/

		//Get length of string
		num = word.length();

		//Calculate number of desired spaces
		num = (SCREEN_WIDTH - num) / 2;


		//FOR(Until desired number of spaces are added)
		for (int i = 0;i < num;i++)

			//Add a space to the front of the string
			word = " " + word;

		//END FOR

		//Return the centered string
		return word;

	}//END center

	/***********************************************************
	* Method Name : phoneBookFormat
	* Author 	  : Ryan May
	* Section	  : CSC111-302
	* Program Description: This method takes 2 names and makes them
	*				in phone book format. The names will appear as
	*				Last, First. Note that both names are title case.
	*
	* BEGIN phoneBookFormat
	*    Identify the name string index of the space
	*    IF(There is a space)
	*	 	 Separate first name and last name
	*		 Title case format first name and last name
	*		 Concatenate last name and first name with comma for phonebook format
	*	 ELSE
	*		 Format name to title case
	*    Return the formatted name
	* END phoneBookFormat
	**************************************************************/

	public static String phoneBookFormat(String fullName)
	{
		//local contants

		//local variables
		int space;								//Represents the index of a string where the space is
		String firstName;						//Represents the first name of a full name
		String lastName;						//Represents the last name of a full name

		/*************************************/

		//Identify the name string index of the space
		space = fullName.indexOf(' ');

		//IF(There is a space)
		if (space >= 0)
		{
			//Separate first name and last name
			firstName = fullName.substring(0,space);
			lastName = fullName.substring(space + 1);

			//Title case format first name and last name
			firstName = toTitleCase(firstName);
			lastName = toTitleCase(lastName);

			//Concatenate last name and first name with comma for phonebook format
			fullName = lastName + ", " + firstName;
		}

		//ELSE
		else

			//Format name to title case
			fullName = toTitleCase(fullName);

		//Return the formatted name
		return fullName;
	}

	/***********************************************************
	* Method Name : toTitleCase
	* Author 	  : Ryan May
	* Section	  : CSC111-302
	* Program Description: This method converts one word or name
	*	 to title case format.
	*
	* BEGIN toTitleCase
	*    Make first character of string uppercase
	*    Concatenate capital first letter with lowercase end of string
	*    Return new string
	* END toTitleCase
	**************************************************************/

	public static String toTitleCase (String str)
	{

		//local constants

	    //local variables
	    String firstLetter;		          //1st letter of string we need to make uppercase
	    String upperLetter;               //1st letter of string uppercase
	    String endStr;                    //The string excluding the first letter
	    String newStr;                    //The string once it has been changed to title case

	    /********************************************/

	    //Make first character of string uppercase
		firstLetter = str.substring(0, 1);
		upperLetter = firstLetter.toUpperCase( );

	    //Concatenate capital first letter with lowercase end of string
		endStr = str.substring(1);
		newStr = upperLetter + endStr.toLowerCase();

		//Return the new title case string
	    return newStr;

	}//End toTitleCase

	/***********************************************************
	* Method Name : formatNameLength
	* Author 	  : Ryan May
	* Section	  : CSC111-302
	* Program Description: This method takes a string and reformats to a
	*	 desired length of characters by cutting characters off the end of the
	*	 string. If the full formatted name is shorter than the desired
	*    length, this method will append spaces on the end until it is
	*	 desired length
	*
	* BEGIN formatNameLength
	*    IF(Employee full name is more than max name length)
	*		Reduce employee full name to the max length
	*	 ELSE add spaces until the name is max length
	*		FOR(as long as full name is less than max length)
	*			add a space to the end of the name
	*		END FOR
	*	 END IF
	*    Return length formatted name
	* END formatNameLength
	**************************************************************/

	public static String formatNameLength (int length, String name)
	{
		//local constants

		//local variables

		/******************************************************/

		//IF(Employee full name is more than max name length)
		if (name.length() > length)

			//Reduce employee full name to the max length
			name = name.substring(0, length);

		//ELSE add spaces until the name is max length
		else

			//FOR (as long as full name is less than max length)
			for (int count = name.length(); count < length; count ++)

				//Add a space to the end of the name
				name += " ";

			//END FOR

		//END IF

		//Return length formatted name
		return name;

	}//End formatNameLength
}