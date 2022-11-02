package assignment2;

import java.util.ArrayList;

/**
 * This class CarDatabase is the collection of cars
 * can add or remove car in the car database
 * can get a car in the car database via car registration number
 * can edit a car's color and price in the car database
 * can search and print a car in the car database via car registration number
 * can search and print cars by age, price range, maker name, or maker name & model
 * can check unique of car registration number
 *
 * @author Jingmin Zhang
 * @version 1.8.0   28 May 2021
 */
public class CarDatabase
{
    /**
     * Field
     * cars: a Car ArrayList, a collection of cars
     */
    private ArrayList<Car> cars;

    /**
     * Default Constructor of class CarDatabase
     * initialize cars
     */
    public CarDatabase()
    {
        this.cars = new ArrayList<>();
    }

    /**
     * Constructor of class CarDatabase
     * initialize cars
     * check each car of cars input if it is valid and unique in the car database
     * if unique, add it to cars
     * if not, do not add it, and print error message(include in check method)
     *
     * @param cars: a Car ArrayList, a collection of cars input
     */
    public CarDatabase(ArrayList<Car> cars)
    {
        this.cars = new ArrayList<>();
        for (Car car : cars)
        {
            if (car.checkCarValid() && checkUnique(car.getRegistrationNo()))
                this.cars.add(car);
        }
    }

    /**
     * Mutator (setter) to set cars: add a valid car to car database
     * check the car input if it is valid
     * if not, print error message (include in check method)
     * check the car registration number if it is unique in car database
     * if not, do not add it, and print error message (include in check method)
     *
     * @param registrationNo: a String array, the input of car registration number
     * @param year:           a integer, the input of car year
     * @param color:          a String array, input of car color
     * @param makerName:      a String, input of car maker name
     * @param model:          a String, input of car model
     * @param price:          a integer, input of car price
     * @return a boolean, add successful return true, else return false
     */
    public boolean addCar(String registrationNo, int year, String[] color, String makerName, String model, int price)
    {
        Car car = new Car(registrationNo, year, color, makerName, model, price);
        if (car.checkCarValid() && checkUnique(car.getRegistrationNo()))
        {
            cars.add(car);
            return true;
        }
        System.out.println("ADD FAILED!");
        return false;
    }

    /**
     * check a car is exit in car database via car registration number (case insensitive)
     * check car registration number input
     * if the car registration number input is valid, go on
     * if not, do not to find, and print error message (include in check method)
     * check the car if it in the car database
     *
     * @param registrationNo: a string, car registration number input
     * @return a boolean, if car is exit return true, else return false
     */
    public boolean checkCarExit(String registrationNo)
    {
        if ((new Car()).setRegistrationNo(registrationNo))
        {
            int have = 0;
            for (Car car : cars)
            {
                if (car.getRegistrationNo().equalsIgnoreCase(registrationNo))
                    return true;
            }
        }
        return false;
    }

    /**
     * check car registration number input is unique to car database (case insensitive)
     * check car registration number input if it is valid
     * if not, print error message (include in check method)
     * car registration number must be unique (no duplicates)
     * if not, print error message
     *
     * @param registrationNo: a string, car registration number input
     * @return a boolean, check result
     */
    public boolean checkUnique(String registrationNo)
    {
        if ((new Car()).setRegistrationNo(registrationNo))
        {
            for (Car car : cars)
            {
                if (car.getRegistrationNo().equalsIgnoreCase(registrationNo))
                {
                    System.out.println("Error! Car registration number must be unique (no duplicates)");
                    return false;
                }
            }
            return true;
        }
        else
            return false;
    }

    /**
     * Mutator (setter) to set cars:
     * edit a car's color and price in car database (case insensitive)
     * identified the car by car registration number (case insensitive) and edit its color and price
     * check all parameters
     * if the parameter is invalid, print error message (include in set method)
     * if the car is not exit, print error message (include in getCar method)
     *
     * @param registrationNo: a string, car registration number input
     * @param color:          a string array, car color input to set the color of this car
     * @param price:          a integer, car price input to set the price of this car
     * @return a boolean, edit successful return true, else return false
     */
    public boolean editCar(String registrationNo, String[] color, int price)
    {
        Car car = getCar(registrationNo);
        if (car != null && car.setColor(color) && car.setPrice(price))
            return true;
        System.out.println("EDIT FAILED!");
        return false;
    }

    /**
     * get the car in car database via car registration number (case insensitive)
     * check car registration number input
     * if the car registration number input is valid, go on
     * if not, do not to find, and print error message (include in check method)
     * check the car if it in the car database
     * if not, print error message
     *
     * @param registrationNo: a string, car registration number input
     * @return target car or null
     */
    private Car getCar(String registrationNo)
    {
        if ((new Car()).setRegistrationNo(registrationNo))
        {
            for (Car car : cars)
            {
                if (car.getRegistrationNo().equalsIgnoreCase(registrationNo))
                    return car;
            }
            System.out.println("Error! This car does not exist in the car database!");
        }
        return null;
    }

    /**
     * Accessor (getter) to get cars
     *
     * @return cars: a Car ArrayList, a collection of cars
     */
    public ArrayList<Car> getCars()
    {
        return cars;
    }

    /**
     * get string of all cars' details
     * each car follow the format: registrationNo,year,color1,color2,color3,makerName,model,price
     * no empty space in between a word and a comma
     * if a car has less than 3 colours, the corresponding fields are empty
     */
    public String getCarsDetail()
    {
        String carsString = "";
        for (Car car : cars)
        {
            carsString += car.getCarDetail() + "\n";
        }
        return carsString;
    }

    /**
     * print all cars' details line by line
     * each car follow the format: registrationNo,year,color1,color2,color3,makerName,model,price
     * no empty space in between a word and a comma
     * if a car has less than 3 colours, the corresponding fields are empty
     */
    public void printCarsDetail()
    {
        System.out.println(getCarsDetail());
    }

    /**
     * Mutator (setter) to set cars:
     * remove a car from car database via car registration number (case insensitive)
     * check car registration number is valid and the car is exit (include in getCar method)
     * if not, do not remove it, and print error message (include in getCar method)
     *
     * @param registrationNo: a string, car registration number input
     * @return a boolean, remove successful return true, else return false
     */
    public boolean removeCar(String registrationNo)
    {
        Car car = getCar(registrationNo);
        if (car != null)
        {
            cars.remove(car);
            return true;
        }
        System.out.println("REMOVE FAILED!");
        return false;
    }

    /**
     * search and print a car via car registration number (case insensitive)
     * check car registration number input
     * if the car registration number input is valid, go on
     * if not, do not to find, and print error message (include in check method)
     * check the car if it in the car database
     * if not, print error message
     *
     * @param registrationNo: a string, car registration number input
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean searchCar(String registrationNo)
    {
        if ((new Car()).setRegistrationNo(registrationNo))
        {
            System.out.println("\u000C----------------Search result----------------");
            int have = 0;
            for (Car car : cars)
            {
                if (car.getRegistrationNo().equalsIgnoreCase(registrationNo))
                {
                    car.printCarDetail();
                    have++;
                }
            }
            if (have == 0)
                System.out.println("Error! This car does not exist in the car database!");
            return true;
        }
        return false;
    }

    /**
     * search and print all cars if its age is no more than the largest age
     * age to year: year = 2021 - age
     * check age input if it is valid: non-negative integer
     * if not, do not search, and print error message
     * check if have cars no more than the age
     * if have, print all these cars' detail
     * if no one car's age no more than the largest age, print error massage
     *
     * @param age: a integer, the largest car age input
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean searchCars(int age)
    {
        if (age >= 0)
        {
            System.out.println("\u000C----------------Search result----------------");
            int have = 0;
            for (Car car : cars)
            {
                if (car.getYear() >= (2021 - age))
                {
                    car.printCarDetail();
                    have++;
                }
            }
            if (have == 0)
                System.out.println("Cannot Find it! This car does not exist!");
            return true;
        }
        else
        {
            System.out.println("Error! Age must be a non-negative integer");
            return false;
        }
    }

    /**
     * search and print all cars if its price is in the price range
     * the price range is form priceMin and priceMax (inclusive)
     * check two price input if it are valid: positive integer and priceMin < priceMax
     * if not, do not search, and print error message
     * check if have cars in this price range
     * if have, print all these cars' detail
     * if no one car's price in the price range, print error massage
     *
     * @param priceMin: a integer, the minimum price of price range
     * @param priceMax: a integer, the maximum price of price range
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean searchCars(int priceMin, int priceMax)
    {
        if (priceMin > 0 && priceMax > 0)
            if (priceMin < priceMax)
            {
                System.out.println("\u000C----------------Search result----------------");
                int have = 0;
                for (Car car : cars)
                {
                    if (car.getPrice() >= priceMin && car.getPrice() <= priceMax)
                    {
                        car.printCarDetail();
                        have++;
                    }
                }
                if (have == 0)
                    System.out.println("Cannot Find it! This car does not exist!");
                return true;
            }
            else
            {
                System.out.println("The maximum price should be grater than the minimum price");
                return false;
            }
        else
        {
            System.out.println("The price must be positive integer");
            return false;
        }
    }

    /**
     * search and print all cars if its maker name is makerName (case insensitive)
     * check car makerName if it is valid
     * if not, do not search, and print error message (include in check method)
     *
     * @param makerName: a String, car maker name input
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean searchCars(String makerName)
    {
        if ((new Car()).setMakerName(makerName))
        {
            System.out.println("\u000C----------------Search result----------------");
            int have = 0;
            for (Car car : cars)
            {
                if (car.getMakerName().equalsIgnoreCase(makerName))
                {
                    car.printCarDetail();
                    have++;
                }
            }
            if (have == 0)
                System.out.println("Cannot Find it! This car does not exist!");
            return true;
        }
        return false;
    }

    /**
     * search and print all cars if its maker name is makerName and its model is model (case
     * insensitive)
     * check all parameter if it are valid
     * if not, do not search, and print error message (include in check method)
     *
     * @param makerName: a String, car maker name input
     * @param model:     a String, car model
     * @return a boolean, if parameter input is valid return true, else return false
     */
    public boolean searchCars(String makerName, String model)
    {
        if ((new Car()).setMakerName(makerName) && (new Car()).setModel(model))
        {
            System.out.println("\u000C----------------Search result----------------");
            int have = 0;
            for (Car car : cars)
            {
                if (car.getMakerName().equalsIgnoreCase(makerName) && car.getModel().equalsIgnoreCase(model))
                {
                    car.printCarDetail();
                    have++;
                }
            }
            if (have == 0)
                System.out.println("Cannot Find it! This car does not exist!");
            return true;
        }
        return false;
    }
}
