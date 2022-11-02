package assignment2;

import java.util.ArrayList;

/**
 * This class CarMakerDatabase is the collection of car makers
 * can add and remove car maker in the car maker database
 * can get a car maker in the car maker database via index or maker name
 * can print all car makers' details in the car maker database
 * can print all car makers' name in the car maker database in list format
 * can print all car maker's model in the car maker database in list format via index
 *
 * @author Jingmin Zhang
 * @version 1.8.0   28 May 2021
 */
public class CarMakerDatabase
{
    /**
     * Field
     * carMakers: a CarMaker ArrayList, a collection of car makers
     */
    private ArrayList<CarMaker> carMakers;


    /**
     * Default Constructor of class CarMakerDatabase
     * initialize carMakers
     */
    public CarMakerDatabase()
    {
        this.carMakers = new ArrayList<>();
    }

    /**
     * Constructor of class CarMakerDatabase
     * initialize carMakers
     * check each car maker of car makers input if it is valid
     * if valid, add it to carMakers
     * if not, do not add it, and print error message (include in check method)
     *
     * @param carMakers: a CarMaker ArrayList, a collection of car makers input
     */
    public CarMakerDatabase(ArrayList<CarMaker> carMakers)
    {
        this.carMakers = new ArrayList<>();
        for (CarMaker carMaker : carMakers)
        {
            if (carMaker.checkCarMakerValid())
                this.carMakers.add(carMaker);
        }
    }

    /**
     * Mutator (setter) to set car makers: add a car maker to car maker database (no check)
     * check car maker input if it is valid
     * if valid, add it to carMakers
     * if not, do not add it, and print error message (include in check method)
     *
     * @param makerName: a String, the input of car maker name
     * @param models:    a string ArrayList, the input of many car models
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean addCarMaker(String makerName, ArrayList<String> models)
    {
        CarMaker carMaker = new CarMaker(makerName, models);
        if (carMaker.checkCarMakerValid())
        {
            this.carMakers.add(carMaker);
            return true;
        }
        return false;
    }

    /**
     * get the car maker from car maker database via index
     * check index if it is valid
     * if not, print the error message
     *
     * @param index: a integer, the input of carMakers index
     * @return target car maker or null
     */
    public CarMaker getCarMaker(int index)
    {
        if (index >= 0 && index < carMakers.size())
            return carMakers.get(index);
        else
        {
            System.out.println("Error! The index input out of the range");
            return null;
        }
    }

    /**
     * get the car maker from car maker database via car maker name (case insensitive)
     * assumption: the maker name is unique
     * check maker name input if it is valid
     * if not, print error message (include in check method)
     * check car maker with the name if it is exit in car maker database
     * if not, print error message
     *
     * @param makerName: a integer, the input of carMakers index
     * @return target car maker or null
     */
    public CarMaker getCarMaker(String makerName)
    {
        if ((new CarMaker()).setMakerName(makerName))
        {
            for (CarMaker carMaker : carMakers)
            {
                if (carMaker.getMakerName().equalsIgnoreCase(makerName))
                    return carMaker;
            }
            System.out.println("Error! This car maker does not exit in car maker database");
        }
        return null;
    }

    /**
     * Accessor (getter) to get car makers
     *
     * @return carMakers: a CarMaker ArrayList, a collection of car makers
     */
    public ArrayList<CarMaker> getCarMakers()
    {
        return carMakers;
    }

    /**
     * print all car makers details line by line
     * each car maker follow the format: makerName,model1,model2,model3...
     * no empty space in between a word and a comma
     */
    public void printCarMakers()
    {
        for (CarMaker carMaker : carMakers)
        {
            carMaker.printCarMakerDetail();
        }
    }

    /**
     * print all car model of a car maker in car maker database in list format via index
     * format:
     * (1) model1
     * (2) model2
     * .....
     *
     * @param index: a integer, the input of carMakers index
     */
    public void printCarMakersModelsList(int index)
    {
        CarMaker carMaker = getCarMaker(index);
        if (carMaker != null)
            carMaker.printCarMakerModelsList();
    }

    /**
     * print all car makers' name in car maker database in list format
     * format:
     * (1) makerName1
     * (2) makerName2
     * ......
     */
    public void printCarMakersNameList()
    {
        for (CarMaker carMaker : carMakers)
        {
            System.out.println("(" + (carMakers.indexOf(carMaker) + 1) + ") " + carMaker.getMakerName());
        }
    }

    /**
     * Mutator (setter) to set car makers:
     * remove a car maker in car maker database via car maker name (case insensitive)
     * check maker name input if it is valid (include in getCarMaker method)
     * if not, print error message (include in check method)
     * check the car maker with the name if it is in car maker database
     * if not, print error message (include in getCarMaker method)
     *
     * @param makerName: a String, a car maker name input
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean removeCarMaker(String makerName)
    {
        CarMaker carMaker = getCarMaker(makerName);
        if (carMaker != null)
        {
            this.carMakers.remove(carMaker);
            return true;
        }
        return false;
    }
}
