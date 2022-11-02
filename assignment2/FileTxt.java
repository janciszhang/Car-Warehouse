package assignment2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class FileTxt is read file or write to file
 * can read file and get a String ArrayList
 * can write a string to a file
 * if there are something wrong when run the code, will catch the error and print error message
 *
 * @author Jingmin Zhang
 * @version 1.8.0   28 May 2021
 */
public class FileTxt
{
    /**
     * Default constructor for class FileTxt
     */
    public FileTxt()
    {
    }

    /**
     * read a file and return a string ArrayList
     * each line in file is stored as a string item in this string ArrayList
     *
     * @param fileName: a string, file name or path
     * @return fileStr: a string ArrayList, store all lines of the file
     * @throws FileNotFoundException
     */


    /**
     *
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<String> read(String fileName) throws FileNotFoundException
    {
        ArrayList<String> fileStr = new ArrayList<>();
        try
        {
            FileReader fileReader = new FileReader(fileName);
            try
            {
                Scanner scan = new Scanner(fileReader);

                while (scan.hasNextLine())
                {
                    String lineStr = scan.nextLine();
                    fileStr.add(lineStr);
                }
            }
            finally
            {
                fileReader.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error! Cannot find the file: " + fileName);
        }
        catch (IOException e)
        {
            System.out.println("Error! IO exception");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return fileStr;
    }

    /**
     * write a string to a file
     *
     * @param fileName:  a string, file name or path
     * @param strOutput: a string, that need to be output to a file
     * @throws FileNotFoundException
     */
    public static void write(String fileName, String strOutput) throws FileNotFoundException
    {
        try
        {
            PrintWriter printWriter = new PrintWriter(fileName);
            printWriter.println(strOutput);
            printWriter.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error! Cannot find the file: " + fileName);
        }
        catch (IOException e)
        {
            System.out.println("Error! IO exception");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

//    public static void saveStudentList(String filename, ArrayList<Student> listOfStudents) throws FileNotFoundException
//    {
//        try
//        {
//            PrintWriter printWriter = new PrintWriter(fileName);
//            for (Student student : listOfStudents)
//            {
//                String result = "";
//                if (student[3] >= 50)
//                    result = "Pass";
//                else
//                    result = "Fail";
//                String studentInfo = student[0] + "," + student[1] + "," + student[2] + "," + student[3] + "," + result + "\n";
//                printWriter.println(studentInfo);
//            }
//            printWriter.close();
//        }
//        catch (FileNotFoundException e)
//        {
//            System.out.println("Error! Cannot find the file: " + filename);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.toString());
//        }
//    }

//    public static boolean loadStudentList(String filename,ArrayList<Student> listOfStudents) throws FileNotFoundException
//    {
//        try
//        {
//            FileReader fileReader = new FileReader(filename);
//            try
//            {
//                Scanner scan = new Scanner(fileReader);
//                while (scan.hasNextLine())
//                {
//                    String lineStr = scan.nextLine();
//                    String[] info = lineStr.split(",");
//                    listOfStudents.add(new Student(info[0],info[1],info[2]));
//                }
//                return true;
//            }
//            finally
//            {
//                fileReader.close();
//            }
//        }
//        catch (FileNotFoundException e)
//        {
//            System.out.println("Error! Cannot find the file: " + filename);
//            return false;
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.toString());
//            return false;
//        }
//    }


    public static void main(String[] args)
    {
//        int n1=1;
//        int n2 =2;
//        int n3 =3;
//        System.out.println(n1++);
//        System.out.println(--n2);
//        n3=n1+n2;
//        System.out.println(n3++);

//        boolean v=true;
//        String w="abcxyz";
//        if (!v||w.charAt(3)=='x')
//            System.out.println("yes");
//        else
//            System.out.println("ni");
//        System.out.println("really?");

//        System.out.println("loa ded".length().trim());
//        System.out.println(!(3%7!=4)?1:2)

//        int[] n1 = {11, -5, 2, -6, 24, 12, 13};
//        int[] n2 = {1, 3, 5, 7, 9, 11, 13};
//        int j = 0;
//        while (j < n1.length)
//        {
//            n2[j] = n1[n1.length - 1 - j];
//            j++;
//        }
//        for (int n :n2)
//        {
//            System.out.print(n);
//            System.out.print(',');
//        }

        String a = "";
        a.length();

        Movie[] myMovies = new Movie[30];
        ArrayList<Student> myStudents = new ArrayList();
        Iterator<Student> myIterator = myStudents.iterator();

        ArrayList<Player> players = new ArrayList<>();

        Iterator<Player> currentPlayer = players.iterator();
        while (currentPlayer.hasNext())
        {
            System.out.println(currentPlayer.next());
        }

    }

    class Movie
    {

    }

    class Player
    {
    }

    class Student
    {
    }


    public void findRatedMovies(String movieRating, Movie[] movies)
    {
    }

    public boolean stringNumeric(String aString)
    {
        for (char ch : aString.toCharArray())
        {
            if (!Character.isAlphabetic(ch))
                return false;
        }
        return true;
    }


//    public Rectangle(double length, double width) throws IllegalArgumentException
//    {
//    }

//    public static returnType classMethod(parameterType parameter)

}
