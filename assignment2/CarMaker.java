package assignment2;

import java.util.ArrayList;

/**
 * This class CarMaker contain two attributes of the car maker
 * can add or remove car model(s)
 * can print car maker all details and can print all car models in list format
 * two attributes of the car maker:
 * car maker name, car models which are available from the car maker
 * check method for car maker name, one car model, many car models
 *
 * @author Jingmin Zhang
 * @version 1.8.0   28 May 2021
 */
public class CarMaker
{
    /**
     * Field
     * makerName: a String, car maker name
     * models: a string ArrayList, many available car models from the car maker
     */
    private String makerName;
    private ArrayList<String> models;

    /**
     * Default constructor for class CarMaker
     * only initialize models
     */
    public CarMaker()
    {
        this.models = new ArrayList<>();
    }

    /**
     * Constructor for class CarMaker (set many models)
     * initialize models
     * all parameters are be checked
     * if all parameters are valid, assign these parameters to all field
     * if not, just like default constructor, and print error message(include in check method)
     *
     * @param makerName: a String, the input of car maker name
     * @param models:    a string ArrayList, the input of many car models
     */
    public CarMaker(String makerName, ArrayList<String> models)
    {
        this.models = new ArrayList<>();
        if (Check.checkStringNotContain(makerName, new String[]{" ", ","}) && Check.checkStringNotContain(models, new String[]{","}))
        {
            this.makerName = makerName;
            this.models = models;
        }
    }

    /**
     * Mutator (setter) to set models:
     * add one car model to CarMaker
     * check one car model input
     * cannot be null
     * a non-empty String, must not contain commas
     * if the car model is valid, add it
     * if not, do not add it, and print error message(include in check method)
     *
     * @param model: a String, the input of one car model which want to be added
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean addModel(String model)
    {
        if (Check.checkStringNotContain(model, new String[]{","}))
        {
            this.models.add(model);
            return true;
        }
        return false;
    }

    /**
     * check the car maker if it is valid
     * all six fields set complete, no one is default value
     *
     * @return check: a boolean, check result
     */
    public boolean checkCarMakerValid()
    {
        boolean check = Check.checkStringNotContain(makerName, new String[]{" ", ","}) && Check.checkStringNotContain(models, new String[]{","});
        if (check == false)
            System.out.println("Error! This car maker is invalid. The detail of the car maker is " + "not complete");
        return check;
    }

    /**
     * Accessor (getter) to get car maker name of the car maker
     *
     * @return makerName: a Sting, car maker name of the car maker
     */
    public String getMakerName()
    {
        return makerName;
    }

    /**
     * Accessor (getter) to get all car models of the car maker
     *
     * @return makerName: a Sting ArrayList, all car models of the car maker
     */
    public ArrayList<String> getModels()
    {
        return models;
    }

    /**
     * print all detail of the car maker
     * format: makerName,model1,model2,model3...
     * no empty space in between a word and a comma
     */
    public void printCarMakerDetail()
    {
        System.out.print(makerName);
        if (!models.isEmpty())
        {
            for (String model : models)
            {
                System.out.print("," + model);
            }
            System.out.println();
        }
        else
            System.out.println("," + models);
    }

    /**
     * print all car model of the car maker in list format
     * format:
     * (1) model1
     * (2) model2
     * .....
     */
    public void printCarMakerModelsList()
    {
        for (String model : models)
        {
            System.out.println("(" + (models.indexOf(model) + 1) + ") " + model);
        }
    }

    /**
     * Mutator (setter) to set car models:
     * remove one model
     * check car model input
     * if the car model is not valid, do not remove it, print error message(include in check method)
     * if the model input in the car models, remove it
     * if not, do not remove it, and print error message
     *
     * @param model: a String, the car model input which want to be removed
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean removeModel(String model)
    {
        if (Check.checkStringNotContain(model, new String[]{","}))
        {
            if (models.contains(model))
                this.models.remove(model);
            else
                System.out.println("Error! This model does not exist!");
            return true;
        }
        return false;
    }

    /**
     * Mutator (setter) to set car maker name
     * check car maker name input
     * cannot be null
     * a non-empty String, must not contain blank or commas
     * if the maker name input is valid, set it
     * if not, do not set maker name, and print error message (include in check method)
     *
     * @param makerName: a string input to set maker name
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean setMakerName(String makerName)
    {
        if (Check.checkStringNotContain(makerName, new String[]{" ", ","}))
        {
            this.makerName = makerName;
            return true;
        }
        return false;
    }

    /**
     * Mutator (setter) to set car models
     * check many car models input
     * cannot be empty[]
     * all car models must not null or empty or contain commas
     * if the car models input is valid, set it
     * if not, do not set car models, and print error message (include in check method)
     *
     * @param models: a string ArrayList input to set car models
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean setModels(ArrayList<String> models)
    {
        if (Check.checkStringNotContain(models, new String[]{","}))
        {
            this.models = models;
            return true;
        }
        return false;
    }
}
