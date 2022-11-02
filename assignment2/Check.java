package assignment2;

import java.util.ArrayList;

/**
 * This class Check check string or integer follow the requirement
 *
 * @author Jingmin Zhang
 * @version 1.8.0   28 May 2021
 */
public class Check
{
    /**
     * Default constructor for class Check
     */
    public Check()
    {
    }

    /**
     * check all chars in a string are numeric or alphabetic
     * is empty or contain blank
     * cannot contain other not numeric/alphabetic char
     * if not, print error message
     *
     * @param str: a string
     * @return a boolean, check result
     */
    public static boolean checkStringAlNum(String str)
    {
        if (!str.isEmpty())
        {
            for (int i = 0; i < str.length(); i++)
            {
                if (!Character.isDigit(str.charAt(i)) && !Character.isLetter(str.charAt(i)))
                {
                    System.out.println("Error! It must only contain numeric or alphabetic");
                    return false;
                }
            }
            return true;
        }
        else
        {
            System.out.println("Error! It cannot be empty");
            return false;
        }
    }

    /**
     * check integer in a required range
     * between min-max (inclusive)
     * if not, print error message
     *
     * @param integer: a int input
     * @param min:     a int, the start of the range
     * @param max:     a int, the end of the range
     * @return a boolean, check result
     */
    public static boolean checkIntegerInRange(int integer, int min, int max)
    {
        if (integer >= min && integer <= max)
            return true;
        else
        {
            System.out.println("Error! The number must between " + min + " and " + max);
            return false;
        }
    }

    /**
     * check a string input
     * cannot be null
     * must not be blank, must be numeric/alphabetic
     * (checkAlNum method already checked: not empty/no blank/only numeric and alphabetic)
     * maximum n characters
     * if not, print error message
     *
     * @param string:    a string input
     * @param lengthMax: the maximum length of the string requirement
     * @return a boolean, check result
     */
    public static boolean checkStringAlNumLength(String string, int lengthMax)
    {
        if (string != null)
            if (string.length() <= lengthMax)
                return checkStringAlNum(string);
            else
            {
                System.out.println("Error! The length must be no more than " + lengthMax);
                return false;
            }
        System.out.println("Error! It cannot be null");
        return false;
    }

    /**
     * check a string array
     * length is required
     * all element cannot be null
     * at least one and no one cannot contain comma
     * if not, print error message
     *
     * @param strings: a string array input
     * @param length:  the length of the string array requirement
     * @return a boolean, check result
     */
    public static boolean checkStringArray(String[] strings, int length)
    {
        if (strings.length == length)
        {
            String strs = "";
            for (String str : strings)
            {
                if (str == null)
                {
                    System.out.println("Error! It cannot be null");
                    return false;
                }
                else
                    strs += str;
            }
            return checkStringNotContain(strs.trim(), new String[]{","});
        }
        System.out.println("Error! It must contain " + length + " element");
        return false;
    }

    /**
     * check a string arraylist input
     * cannot be empty[]
     * for all items:
     * must not null or empty
     * require not contain these element
     * if not, print error message
     *
     * @param strings:     a string ArrayList input
     * @param notContains: a string array, require the strings not contain these elements
     * @return a boolean, check result
     */
    public static boolean checkStringNotContain(ArrayList<String> strings, String[] notContains)
    {
        if (!strings.isEmpty())
        {
            for (String string : strings)
            {
                if (!checkStringNotContain(string, notContains))
                    return false;
            }
            return true;
        }
        System.out.println("Error! It cannot be empty");
        return false;
    }

    /**
     * check a string input
     * cannot be null
     * a non-empty String, must not contain some element
     * if not, print error message
     *
     * @param string:      a string input
     * @param notContains: a string array, require the string not contain these elements
     * @return a boolean, check result
     */
    public static boolean checkStringNotContain(String string, String[] notContains)
    {
        if (string != null && !string.isEmpty())
        {
            for (String notContain : notContains)
            {
                if (string.contains(notContain))
                {
                    System.out.println("Error! It cannot contain '" + notContain + "'");
                    return false;
                }
            }
            return true;
        }
        System.out.println("Error! It cannot be null or empty");
        return false;
    }
}
