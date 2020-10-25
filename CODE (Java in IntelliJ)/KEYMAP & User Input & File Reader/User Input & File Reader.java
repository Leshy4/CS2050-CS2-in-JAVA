    /*~~ VERY HANDY!! ~~*/    /** ~~~~~~~~~~~~Gets User Input && Reads Files (.txt)~~~~~~~ */
    // The File is contained in the same folder, but not necessary) Need File Path to the destination file
/** USEFUL INTELLIJ KEYBOARD SHORTCUTS ~~~(KEYMAP)~~~~~~~~~~~~ RUN = shift + f10 ~~~~~ BUILD = ctrl + f9 ~~~~~~~~~~~~~~~~~~~
~~~ Code COMPLETION Smart = ctrl + shift + spacebar ~~~~~~~~~~~~~~~~~ SEARCH EVERYWHERE = shift + shift ~~~~~~~~~~
~~~ Code UNFOLDING = ctrl + '+' ~~~~~~ Code FOLDING = ctrl + '-' ~~~~ HELP (Find Setting) = ctrl + shift + A ~~~~~
~~~ ^RECURSIVE = ctrl + alt + '+'  ||  '-' for ^ ~~~~~~~ RECENT Files = ctrl + E  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~ NEXT Error/Warning = fn + f2 ~~~~~ Warning/Error SUGGESTIONS = alt + enter ~~~~ Smart SELECT = ctrl + W ~~~~~~  */

// TODO <- Mark Code to finish.   EX: newFunctionCall(); wherever, Then Code the function && Erase when done
import java.util.*;     // Data Structures, Random, Timers, Event Listeners, ...
import java.io.*;       //  File/User Readers/Writers         * == Everything

public class BSheep {
        // static = Global Variable with the class  // final = Unchangeable Variable
    final static int FIRST_FILE_NUM = 1;
    final static int LAST_FILE_NUM = 5;
    final static int MIN_SHEEP = 2; // Arbitrary. 1st # in text#.txt = nSheep
    static ArrayList fileData = new ArrayList();

    //todo). How to get Input from User & Corrects user if out of bounds (continuous)
    public static int getUserInput() {
        Scanner uInput = new Scanner(System.in);  // Puts User Input into a buffer as a String value
        System.out.print("\t\t");    //Formatting
        int fileNum = uInput.nextInt();       // Interpret User Input as an int

        // Checks User Input for Bounds and gets new input if out of Bounds.
        while (fileNum < FIRST_FILE_NUM || fileNum > LAST_FILE_NUM) {
            System.out.println("You have Entered an Incorrect Selection. PLEASE SELECT A NUMBER 1-5");
            uInput = new Scanner(System.in);
            fileNum = uInput.nextInt();
        }
        return fileNum;
    }

    public static void readFile() throws FileNotFoundException { //TODO <- Requires try/catch | throws ...Exception
/**~~~TEST_FILE_LOCATION must have Current File Location ==>>    [File Manager] > (Copy Address as Text)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        String TEST_FILE_LOCATION = "C:\\Users\\leshy\\Desktop\\CS 2050 CS II\\JAVA Programs\\out\\BSheepNew\\src\\test";  // Address of Files

           // How to store File Info into a Scanner.          Use Concatenation for Filename: text#.txt
        Scanner in = new Scanner(new FileInputStream( TEST_FILE_LOCATION + getUserInput() + ".txt")); // getUserInput() == an int (File Number to open)
        int line;   //was Integer data type for some reason?

        /**~~~~~~~~~~~~~~~~READ FILE UNTIL THE END~~~~~~~~~~~~~~~~~~~~*/
        while (in.hasNextLine()) {  // while File has more ints
            line = in.nextInt();    // line = int
            fileData.add(line);     // add ints to ArrayList "fileData"
        }

        in.close(); /**~~~~~~~~~~ALWAYS CLOSE THE FILE AFTER OPENING OR IT CAUSES BUGS!!!! ~~~~~~~~~*/
    }

    public static void getFencePostCoordinates(ArrayList fileData) {

        int x = 0; int y = 0; int xMin = 0; //Multiple Assignments
        int xMax, yMin, yMax;     // Multiple Members == null
        xMax = 0;   yMin = 0;   yMax = 0;

        int coordsToGet = (fileData.size() - 1);

        for (int i = 1; i <= coordsToGet; i++) {        //Get all Coordinates
            if (i % 2 == 0) {   y = (int) fileData.get(i);  }   // Get Y Coords
            else {x = (int) fileData.get(i);}               // Get X Coords
            if (x < xMin){xMin = x;}                // Find Min/Max of X/Y
            if (x > xMax){xMax = x;}
            if (y < yMin){yMin = y;}
            if (y > yMax){yMax = y;}
        }      //Print Fence Post Location
        System.out.print("Fence Posts @ Coordinates: { (" + xMin + "," + yMin + "), ");
        System.out.print("(" + xMax + "," + yMin + "), ");
        System.out.print("(" + xMax + "," + yMax + "), ");
        System.out.println("(" + xMin + "," + yMax + ") }");

        int firstNumberInFile = (int) fileData.get(0);
        System.out.println(firstNumberInFile);
        // Arbitrary. Validate nSheep
        if (firstNumberInFile < MIN_SHEEP){
            System.out.println("Invalid input! We need at least " + MIN_SHEEP + " sheep to build a fence!");
            System.exit(1);
        }
    }

        // Arbitrary //Prints File Numbers //Used for program
    public static void printFileNumbers(){
        final String fileToReadMessage = "\n\n\tWhich test file would you like to read? \n\tENTER: ";
        System.out.print(fileToReadMessage);

            // Print ALL File numbers
        for(int x = FIRST_FILE_NUM; x <= LAST_FILE_NUM; ++x) {
            if(x == LAST_FILE_NUM) System.out.print("or " + x);
            else System.out.print(x + ", ");
        }
    }

/*// Using 'args' for Command Line ~~~~~~~~~~// In Edit Configuration -> Program arguments~~~~~~~~~~~~~~~~~~~~~~~~~
            if (args.length != 1)
            {   System.out.println("Name of the file expected!");
                System.exit(1);                                                             // UNDER THE HOOD STUFF
            }
            System.out.println("# of command line parameters passed: " + args.length);
    *///~~~~~~~~~~~Notes of ^ how main works~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) throws Exception {

        printFileNumbers(); // Arbitrary Function call. Needed for file
        readFile();     // Reads .txt file for integers     VURRY IMPORTANT
        getFencePostCoordinates(fileData);  // Gets & prints Fence Post Coordinates

    } // end of main function

} // end of class definition