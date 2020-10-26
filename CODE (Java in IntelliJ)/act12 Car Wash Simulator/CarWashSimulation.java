package CarWashSimulator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class CarWashSimulation {

    private static final int    MIN_TIME_WASH = 5;  // minutes
    private static final int    MAX_TIME_WASH = 15;  // minutes
    private static final int    CHANCE_NEW_CAR = 50; // 1-100% chance
    private static final String DATA_FILENAME = "cars.csv";     // Holds #ofCars, Then: MAKE,MODEL,YEAR
    private static String[] data = null;

    public static void loadData() {
        try {
            Scanner in = new Scanner(new FileInputStream(DATA_FILENAME));   // Read file "cars.csv"

            int total = Integer.parseInt(in.nextLine());    // First Value in File == #OfCars
            data = new String[total];
            int i = 0;                          // THEN:  Make, Model, Year

            while (in.hasNextLine()) {          // Reads Make,Model,Year
                String line = in.nextLine();    // as String as Line
                data[i++] = line;               // Add Car details in String[]
            }
            in.close();
        } catch (FileNotFoundException e) {     // DATA_FILENAME != Valid
            e.printStackTrace();
        }
    }

    public static Car getRandomCar() {
        Random r = new Random();
        int i = r.nextInt(data.length);
        String fields[] = data[i].split(",");
        return new Car(fields[0], fields[1], Integer.parseInt(fields[2]));
    }

    public static void run(int minutes) {
        DynamicQueue<Car> queue = new DynamicQueue<>();
        Random ran = new Random();
        Car car = null; // Car being washed
        int timer = 0; // Minutes to Wash the car
        System.out.println("Simulation starts now for " + minutes + " minutes!");
        for (int i = 0; i < minutes; i++) {
            String padded = String.format("%03d" , i);
            System.out.print(padded + ". ");
            System.out.println(queue);
            if (car != null) System.out.println(car + " is being washed.");
            // TODO: simulate that a new car arrived using CHANCE_NEW_CAR
            if (ran.nextInt(100)+1 <= CHANCE_NEW_CAR) {
                queue.enqueue(getRandomCar());
            }

            // TODO: if no cars is being washed, get the next car to be served from the queue
            if (car == null && !queue.isQueueEmpty()) {
                car = queue.pop();
                timer = ran.nextInt((MAX_TIME_WASH - MIN_TIME_WASH + 1)) + MIN_TIME_WASH;
            }

            // TODO: if a car is currently being served, decrease the timer and finish servicing the car if timer reaches 0
            // MIN_TIME_WASH & MAX_TIME_WASH        in Minutes
            if (car != null)
            {   timer--;
                if(timer ==0){ car = null; }
            }
        }   System.out.println("Simulation completed!");
    }   //run(minutes) over

    public static void main(String[] args) {
        loadData();
        run(100);
    }
}