package assignment2;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class CarWarehouse is a used car warehouse database system
 * can search car (via registration number/ car make and car model/ car age/ price range)
 * can add car
 * can delete (via registration number)
 * can edit car (via registration number, edit color and price)
 * when exit system, will save cars data in file
 *
 * @author Jingmin Zhang
 * @version 1.8.0   28 May 2021
 */
public class CarWarehouse
{
    /**
     * Field
     * carMakers: a object of class CarMakerDatabase, a collection of car makers
     * cars: a object of class CarDatabase, a collection of cars
     */
    private CarMakerDatabase carMakers;
    private CarDatabase cars;
    private static final String CARS_FILENAME = "usedcars.txt";
    private static final String CARMAKERS_FILENAME = "carmakers.txt";

    /**
     * Default Constructor of class CarWarehouse
     * initialize cars and carMakers
     */
    public CarWarehouse()
    {
        this.cars = new CarDatabase();
        this.carMakers = new CarMakerDatabase();
    }

    /**
     * the whole process
     *
     * @throws FileNotFoundException
     */
    public void buyWholeProcess() throws FileNotFoundException
    {
        System.out.print("\u000C");
        setCars(CARS_FILENAME);
        setCarMakers(CARMAKERS_FILENAME);
        int option = 0;
        do
        {
            printMenu();
            System.out.print(">>> Please input your choose: ");
            option = Input.inputIntegerInRange(1, 5);
            System.out.print("\u000C");
            optionSwitch(option);
            if (option != 5)
                System.out.println("\n---------------Option finished---------------\n\n");
        } while (option != 5);
    }

    /**
     * choose one car maker name from list
     *
     * @return a string, a car maker name
     */
    private String chooseMakerNameFromList()
    {
        System.out.println("\n---------------Choose car maker name---------------");
        System.out.println("There are all CAR MAKER NAMES that you can choose:\n");
        carMakers.printCarMakersNameList();
        System.out.print("\n>>> Please choose a CAR MAKER NAME: ");
        //check option input
        int option = Input.inputIntegerInRange(1, carMakers.getCarMakers().size());
        System.out.println("------------------------done------------------------");
        return carMakers.getCarMaker(option - 1).getMakerName();
    }

    /**
     * choose one car maker model of this car maker from list
     *
     * @param makerName: a string, the car maker name
     * @return a string, a car model
     */
    private String chooseModelFromList(String makerName)
    {
        System.out.println("\n------------------Choose car model------------------");
        System.out.println("There are all car MODELS of this car maker that you can choose:\n");
        int index = carMakers.getCarMakers().indexOf(carMakers.getCarMaker(makerName));
        carMakers.printCarMakersModelsList(index);
        System.out.println();
        System.out.print(">>> Please choose a car MODEL of this car maker: ");
        int option = Input.inputIntegerInRange(1, carMakers.getCarMaker(index).getModels().size());
        System.out.println("------------------------done------------------------");
        return carMakers.getCarMaker(index).getModels().get(option - 1);
    }

    /**
     * Accessor (getter) to get car makers
     *
     * @return carMakers: a object of class CarMakerDatabase
     */
    public CarMakerDatabase getCarMakers()
    {
        return carMakers;
    }

    /**
     * Accessor (getter) to get cars
     *
     * @return cars: a object of class CarDatabase
     */
    public CarDatabase getCars()
    {
        return cars;
    }

    /**
     * Start Point
     *
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        CarWarehouse carWarehouse = new CarWarehouse();
        carWarehouse.buyWholeProcess();
    }

    /**
     * option 1: search cars
     * following sub-menu and option to search cars
     */
    private void option1SearchCars()
    {
        int option = 0;
        do
        {
            printSearchCarsOptions();
            System.out.print(">>> Please input your choose: ");
            option = Input.inputIntegerInRange(1, 5);
            System.out.print("\u000C");
            switch (option)
            {
                case 1:
                    search1ByRegistrationNo();
                    break;
                case 2:
                    search2ByCarMaker();
                    break;
                case 3:
                    search3ByCarAge();
                    break;
                case 4:
                    search4ByPrice();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Error: your choice must be between 1-5");
            }
            if (option != 5)
                System.out.println("\n---------------Option finished---------------\n\n");
        } while (option != 5);
    }

    /**
     * option 2: add car
     * add a valid car to car database
     * check the car input if it is valid
     * if not, print error message (include in add method)
     * check the car registration number if it is unique in car database
     * if all right, add it and print success message
     * if not, do not add it, and print error message (include in add method)
     */
    private void option2AddCar()
    {
        System.out.println("You should input attribute one by one to add the car.\n");
        System.out.print(">>> Please input REGISTRATION NUMBER: ");
        String registrationNo = Input.inputString();
        while (!cars.checkUnique(registrationNo))
        {
            System.out.print("\nInput Error! Please input a valid REGISTRATION NUMBER again: ");
            registrationNo = Input.inputString();
        }
        System.out.print(">>> Please input car YEAR: ");
        int year = Input.inputIntegerInRange(1950, 2021);
        String[] color = Input.inputStringArray("COLOR", 3);
        String makerName = chooseMakerNameFromList();
        String model = chooseModelFromList(makerName);
        System.out.print("\n>>> Please input car PRICE: ");
        int price = Input.inputIntegerInRange(500, 30000);
        System.out.print("\u000C");
        if (cars.addCar(registrationNo, year, color, makerName, model, price))
            System.out.println("ADD SUCCESSFULLY!");
    }

    /**
     * option 3: delete car
     * remove a car from car database via car registration number (case insensitive)
     * check car registration number is valid and the car is exit (include in remove method)
     * if not, do not remove it, and print error message (include in remove method)
     * if all right, print success massage
     */
    private void option3DeleteCar()
    {
        System.out.println("You can delete a car via input this car's REGISTRATION NUMBER.\n");
        System.out.print(">>> Please input REGISTRATION NUMBER: ");
        String registrationNo = Input.inputString();
        System.out.print("\u000C");
        if (cars.removeCar(registrationNo))
            System.out.println("DELETE SUCCESSFULLY!");
    }

    /**
     * option 4: edit car
     * edit a car's color and price in car database (case insensitive)
     * identified the car by car registration number (case insensitive) and edit its color and price
     * check all input (include in edit method)
     * if the input is invalid, print error message (include in edit method)
     * if the car is not exit, print error message (include in edit method)
     * if all right, edit it and print success message
     */
    private void option4EditCar()
    {
        System.out.print("Which car you want to edit?\n>>> Please input the REGISTRATION NUMBER: ");
        String registrationNo = Input.inputString();
        while (!cars.searchCar(registrationNo))
        {
            System.out.print("\nInput Error! Please input a valid REGISTRATION NUMBER again: ");
            registrationNo = Input.inputString();
        }
        if (cars.checkCarExit(registrationNo))
        {
            System.out.println("\nYou can only edit the COLOR and PRICE of the car.");
            String[] color = Input.inputStringArray("COLOR", 3);
            System.out.print("\n>>> Please input car PRICE: ");
            int price = Input.inputIntegerInRange(500, 30000);
            System.out.print("\u000C");
            if (cars.editCar(registrationNo, color, price))
                System.out.println("EDIT SUCCESSFULLY!");
        }
    }

    /**
     * option 5: exit system
     * exit system and save cars in "usedcars.txt"
     * clear the memory !!!
     *
     * @throws FileNotFoundException
     */
    private void option5ExitSystem() throws FileNotFoundException
    {
        FileTxt.write(CARS_FILENAME, cars.getCarsDetail());
        cars.getCars().clear();
        carMakers.getCarMakers().clear();
        System.out.println("ฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅ");
        System.out.println("\n            THANK YOU VERY MUCH!             \n");
        System.out.println("ฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅ");
    }

    /**
     * main menu option switch
     *
     * @param option: a integer, option input
     * @throws FileNotFoundException
     */
    private void optionSwitch(int option) throws FileNotFoundException
    {
        switch (option)
        {
            case 1:
                option1SearchCars();
                break;
            case 2:
                option2AddCar();
                break;
            case 3:
                option3DeleteCar();
                break;
            case 4:
                option4EditCar();
                break;
            case 5:
                option5ExitSystem();
                break;
//            default:
//                System.out.println("Error: your choice must be between 1-5");
        }
    }

    /**
     * print main menu
     */
    private void printMenu()
    {
        System.out.println("ฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅ");
        System.out.println("Welcome to Used Car Warehouse Database System");
        System.out.println("==============================================\n");
        System.out.println("(1) Search Cars");
        System.out.println("(2) Add Car");
        System.out.println("(3) Delete Car");
        System.out.println("(4) Edit Car");
        System.out.println("(5) Exit System");
        System.out.println();
    }

    /**
     * print search cars option
     */
    private void printSearchCarsOptions()
    {
        System.out.println("ฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅฅʕ•̫͡•ʔฅ");
        System.out.println("       Sub Menu - Car Searching Options       ");
        System.out.println("==============================================\n");
        System.out.println("(1) By Registration Number");
        System.out.println("(2) By Car Make and Car Model");
        System.out.println("(3) By Car Age");
        System.out.println("(4) By Price (range)");
        System.out.println("(5) Back to Main Menu");
        System.out.println();
    }

    /**
     * search by car registration number
     * check input registration number is valid: maximum 6 character, only alphabet/digit
     * (include in search method)
     * if not, print error message and ask input again and again until it is valid
     * if exit, print all information of this car (include in search method)
     * if not exit, print error message (include in search method)
     */
    private void search1ByRegistrationNo()
    {
        System.out.println("You can search a car via REGISTRATION NUMBER.\n");
        System.out.print(">>> Please input REGISTRATION NUMBER: ");
        while (!cars.searchCar(Input.inputString()))
        {
            System.out.print("\nInput Error! Please input a valid REGISTRATION NUMBER again: ");
        }
    }

    /**
     * search by car maker
     * select car maker name from list
     * can input "ANY" will print all car models from this car maker (case insensitive)
     * also can input other not "ANY" and then select car maker model from list
     * print all car models from this car maker from the database
     */
    private void search2ByCarMaker()
    {
        System.out.println("You can search a car via choose the CAR MAKER.");
        String makerName = chooseMakerNameFromList();
        System.out.println("\nIf you want display ALL car models of the car maker, please choose " + "ANY" + ".\nOtherwise, input 2 to choose ONLY ONE MODEL of this car maker to display car.\n");
        System.out.println("(1) ANY");
        System.out.println("(2) choose ONLY ONE MODEL");
        System.out.print("\n>>> Please input your choose: ");
        int option = Input.inputIntegerInRange(1, 2);
        if (option == 1)
            cars.searchCars(makerName);
        else
            cars.searchCars(makerName, chooseModelFromList(makerName));
    }

    /**
     * search by car maximum age
     * check age input is a non-negative integer
     * if not, print error message and ask input again and again until it is valid
     * age input should again be validated: input age and input again to validate
     * if have cars no more than car maximum age, print all these cars information
     * if no one, print error massage (include in search method)
     */
    private void search3ByCarAge()
    {
        int age = 0;
        int ageAgain = 1;
        System.out.println("You can search car whose AGE no more than the maximum age.\n");
        while (true)
        {
            System.out.print(">>> Please input the MAXIMUM AGE: ");
            age = Input.inputNaturalNumber();
            System.out.print("\nVERIFICATION:\n>>> Please input the MAXIMUM AGE again: ");
            ageAgain = Input.inputNaturalNumber();
            if (age == ageAgain)
                break;
            else
                System.out.println("\nVALIDATION FAILED! Please re-enter.\n");
        }
        cars.searchCars(age);
    }

    /**
     * search by price
     * check input of two price are positive integer and priceMin < priceMax
     * if not, print error message and ask input again and again until it is valid
     * check if have cars in this price range
     * if have, print all these cars' detail
     * if no one car's price in the price range, print error massage
     */
    private void search4ByPrice()
    {
        System.out.println("You can search car whose PRICE between minimum and maximum price.\n");
        System.out.print(">>> Please input MINIMUM PRICE: ");
        int priceMin = Input.inputPositiveInteger();
        System.out.print("\n>>> Please input MAXIMUM PRICE: ");
        int priceMax = Input.inputPositiveInteger();
        while (!cars.searchCars(priceMin, priceMax))
        {
            System.out.print("Input Error!\n\n>>> Please input MINIMUM PRICE again: ");
            priceMin = Input.inputPositiveInteger();
            System.out.print("\n>>> Please input MAXIMUM PRICE again: ");
            priceMax = Input.inputPositiveInteger();
        }
    }

    /**
     * Mutator (setter) to set car makers (from a file input)
     * each line of the file input is a car maker
     * assumption: all input follow the car maker input format
     * check each car maker if it is valid (include in addCarMaker method)
     * if not, do not add it, and print error message (include in check method)
     *
     * @param fileName: a string, the input of a file name
     * @throws FileNotFoundException
     */
    public void setCarMakers(String fileName) throws FileNotFoundException
    {
        ArrayList<String> fileStr = FileTxt.read(fileName);
        if (fileStr != null)
            for (String str : fileStr)
            {
                String[] strs = str.split(",");
                if (strs.length >= 2)
                {
                    ArrayList<String> models = new ArrayList<>();
                    for (int i = 1; i < strs.length; i++)
                    {
                        models.add(strs[i]);
                    }
                    this.carMakers.addCarMaker(strs[0], models);
                }
            }
    }

    /**
     * Mutator (setter) to set cars (from a file input)
     * each line of the file input is a car
     * assumption: all input follow the car input format
     * check each car if it is valid
     * if not, set it to default car, and print error message (include in check method)
     * check each car if it is unique (include in add method)
     * if not, do not add it, and print error message (include in check method)
     *
     * @param fileName: a string, the input of a file name
     * @throws FileNotFoundException
     */
    public void setCars(String fileName) throws FileNotFoundException
    {
        ArrayList<String> fileStr = FileTxt.read(fileName);
        if (fileStr != null)
            for (String str : fileStr)
            {
                String[] strs = str.split(",");
                if (strs.length == 8)
                    this.cars.addCar(strs[0], Integer.parseInt(strs[1]), new String[]{strs[2], strs[3], strs[4]}, strs[5], strs[6], Integer.parseInt(strs[7]));
            }
    }


}
