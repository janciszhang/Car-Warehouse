package assignment2;

/**
 * This class Car includes six attributes and can print all details of the car
 * The six attributes of the car:
 * car registration number, car year, car color, car maker name, car model, car price
 * check method for car registration number, car year, car color, car price
 *
 * @author Jingmin Zhang
 * @version 1.8.0   28 May 2021
 */
public class Car
{
    /**
     * Field
     * color: a String array, the color of car, a car has at most three color
     * makerName: a String, the car maker name of car
     * model: a String, the model of car
     * price: a integer, the price of car
     * registrationNo: a String, the registration number of the car, that is unique
     * year: a integer, the year of the car
     */
    private String[] color;
    private String makerName;
    private String model;
    private int price;
    private String registrationNo;
    private int year;

    /**
     * Default constructor for class Car
     * only initialize color as a String array which length is three
     */
    public Car()
    {
        color = new String[3];
    }

    /**
     * Constructor for class Car
     * initialize color as String array which length is three
     * all parameters are be checked
     * if all parameters are valid, assign these parameters to all field
     * if not, just like default constructor, and print error message(include in check method)
     *
     * @param registrationNo: a String array, the input of car registration number
     * @param year:           a integer, the input of car year
     * @param color:          a String array, input of car color
     * @param makerName:      a String, input of car maker name
     * @param model:          a String, input of car model
     * @param price:          a integer, input of car price
     */
    public Car(String registrationNo, int year, String[] color, String makerName, String model, int price)
    {
        this.color = new String[3];
        if (Check.checkStringAlNumLength(registrationNo, 6) && Check.checkIntegerInRange(year, 1950, 2021) && Check.checkStringArray(color, 3) && (new CarMaker()).setMakerName(makerName) && (new CarMaker()).addModel(model) && Check.checkIntegerInRange(price, 500, 30000))
        {
            this.registrationNo = registrationNo;
            this.year = year;
            this.color = color;
            this.makerName = makerName;
            this.model = model;
            this.price = price;
        }
    }

    /**
     * check the car if it is valid
     * all six fields set complete, no one is default value
     *
     * @return check: a boolean, check result
     */
    public boolean checkCarValid()
    {
        if (registrationNo != null && year != 0 && color[0] != null && color[1] != null && color[2] != null && makerName != null && model != null && price != 0)
            return true;
        System.out.println("Error! This car is invalid. The detail of the car is not complete");
        return false;
    }


    /**
     * get string of all car details
     * format: registrationNo,year,color1,color2,color3,makerName,model,price
     * no empty space in between a word and a comma
     * if a car has less than 3 colours, the corresponding fields are empty
     */
    public String getCarDetail()
    {
        return registrationNo + "," + year + "," + color[0] + "," + color[1] + "," + color[2] + "," + makerName + "," + model + "," + price;
    }

    /**
     * Accessor (getter) to get all car color of the car
     *
     * @return color: a string array, all car color of the car
     */
    public String[] getColor()
    {
        return color;
    }

    /**
     * Accessor (getter) to get car maker name of the car
     *
     * @return makerName: a Sting, car maker name of the car
     */
    public String getMakerName()
    {
        return makerName;
    }

    /**
     * Accessor (getter) to get car model of the car
     *
     * @return model: a String, car model of the car
     */
    public String getModel()
    {
        return model;
    }

    /**
     * Accessor (getter) to get car price of the car
     *
     * @return price: a integer, car price of the car
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Accessor (getter) to get car registration number of the car
     *
     * @return registrationNo: a String, car registration number of the car
     */
    public String getRegistrationNo()
    {
        return registrationNo;
    }

    /**
     * Accessor (getter) to get car year of the car
     *
     * @return year: a integer, car year of the car
     */
    public int getYear()
    {
        return year;
    }

    /**
     * print all car details
     * format: registrationNo,year,color1,color2,color3,makerName,model,price
     * no empty space in between a word and a comma
     * if a car has less than 3 colours, the corresponding fields are empty
     */
    public void printCarDetail()
    {
        System.out.println(getCarDetail());
    }

    /**
     * Mutator (setter) to set color
     * check color input
     * a car at least has one color
     * a car can have up to 3 colours (e.g. White + Blue)
     * all the three cannot be null and cannot contain comma
     * if the color input is valid, set it
     * if not, do not set color, and print error message(include in check method)
     *
     * @param color: a string array input to set color
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean setColor(String[] color)
    {
        if (Check.checkStringArray(color, 3))
        {
            this.color = color;
            return true;
        }
        return false;
    }

    /**
     * Mutator (setter) to set car maker name
     * check maker name input
     * if the maker name input is valid, set it
     * if not, do not set maker name, and print error message(include in check method)
     *
     * @param makerName: a string input to set maker name
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean setMakerName(String makerName)
    {
        if ((new CarMaker()).setMakerName(makerName))
        {
            this.makerName = makerName;
            return true;
        }
        return false;
    }

    /**
     * Mutator (setter) to set car model
     * check car model input
     * if the car model input is valid, set it
     * if not, do not set car model, and print error message(include in check method)
     *
     * @param model: a string input to set car model
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean setModel(String model)
    {
        if ((new CarMaker()).addModel(model))
        {
            this.model = model;
            return true;
        }
        return false;
    }

    /**
     * Mutator (setter) to set car price
     * check car price input
     * between 500-30000 (inclusive)
     * if not, print error message
     * if the car price input is valid, set it
     * if not, do not set car price, and print error message(include in check method)
     *
     * @param price: a integer input to set car price
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean setPrice(int price)
    {
        if (Check.checkIntegerInRange(price, 500, 30000))
        {
            this.price = price;
            return true;
        }
        return false;
    }

    /**
     * Mutator (setter) to set car registration number
     * check car registration number input
     * cannot be null
     * must not be blank, must be numeric/alphabetic
     * (checkAlNum method already checked: not empty/no blank/only numeric and alphabetic)
     * maximum 6 characters
     * if the car registration number input is valid, set it
     * if not, do not set car registration number, and print error message(include in check method)
     *
     * @param registrationNo: a string input to set car registration number
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean setRegistrationNo(String registrationNo)
    {
        if (Check.checkStringAlNumLength(registrationNo, 6))
        {
            this.registrationNo = registrationNo;
            return true;
        }
        return false;
    }

    /**
     * Mutator (setter) to set car year
     * check car year input
     * between 1950-2021 (inclusive)
     * if the car year input is valid, set it
     * if not, do not set car year, and print error message(include in check method)
     *
     * @param year: a integer input to set car year
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean setYear(int year)
    {
        if (Check.checkIntegerInRange(year, 1950, 2021))
        {
            this.year = year;
            return true;
        }
        return false;
    }


}
