/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package garage.project;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author superuser
 */
public class GarageProject {

    public static void main(String[] args) throws Exception {

        // variable to store plate numbers as they are read
        String name;

        // variable to hold arrive or depart action
        String action;

        Scanner read = new Scanner (new File("garage.txt"));

        PrintWriter toFile = new PrintWriter("Output.txt") ;

        // Create garage object.
        Garage bashemin = new Garage() ;

        // while not end of file
        while (read.hasNext())
        {
            //add blank line between each cars output
            System.out.println("");
            toFile.println("");

            name = read.next();

            action = read.next();

            // test for arrival vs departure
            if(action.equals("ARRIVE"))
            {
                // Create car object
                Car nextCar = new Car(name);

                // echo input operations to window and output file
                System.out.println("Car with plate number: "+ name + " is arriving"
                        +  ".");

                toFile.println("Car with plate numbers: "+ name + " is arriving"
                        +  ".");

                // if garage is not full add car, else turn car away.
                if (bashemin.arrive(nextCar) == true)
                {

                    System.out.println("Car has been parked.");

                    toFile.println("Car has been parked");
                }
                else
                {
                    System.out.println("No room for this car!");

                    toFile.println("No room for this car!");
                }

            }
            // if car fails arrival test, it must be a departure.
            else
            {
                System.out.println("Car with plate number: "+ name +
                        " is departing.");

                toFile.println("Car with plate number: "+ name +
                        " is departing.");

                // if depart method finds car in array, get values and remove car..
                //                                          else car not found.
                if ( bashemin.depart(name) == true)
                {
                    int moves = bashemin.getLeft().getMoves();

                    System.out.println("Car has left the garage. Car moved: "
                            + moves + " times.");

                    toFile.println("Car has left the garage. Car moved: "
                            + moves + " times.");
                }
                else
                {
                    System.out.println("Car not found in Garage!");

                    toFile.println("Car not found in Garage!");

                }

            }

        }
        // close output file
        toFile.close();

    }

    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */


/**
 * @author superuser
 */

    /**
     *  Class to represent a car that contains the plate number and the number of
     * times the car was moved.
     * @param name the license plate number.
     * @param moves the number of times the car was moved because of departures.
     */
    public class Car {

        private String name;  // license plate number
        private int moves = 0;    // number of moves car has endured

        /**
         * Assigns plate number to the name variable.
         * @param number the plate number.
         */
        public Car(String number)
        {
            name = number;
        }

        /**
         * increments number of moves for a car.
         */
        public void addMove()   //increment number of moves
        {
            moves = moves + 1;
        }

        /**
         * Gets the plate number of car.
         * @return the plate number.
         */
        public String getName()
        {
            return name;
        }

        /**
         * Gets the number of times the car was moved.
         * @return the number of moves.
         */
        public int getMoves()
        {
            return moves;
        }




    }


    /**
     *
     * @author superuser
     */

    /**
     * Class that contains an array list full of car objects. Contains methods to
     * handle departure and arrival operations of the cars.
     * @param justLeft saves the value of a car that just left.
     */
    public class Garage {

        private Car justLeft;

        private ArrayList<Car> Garage;

        /**
         * Constructor to intialize empty array list.
         */
        public Garage()
        {
            Garage = new ArrayList<>() ;
        }

        /**
         * Adds car to the array if there is room and turns car away if not.
         * @param number the plate numbers for the car
         * @return true if car object is added to array and false if list is full.
         */
        public boolean arrive(Car number)   // Add a car to list if list < 10
        {
            if (Garage.size() < 10)
            {
                Garage.add(number);
                return true;
            }

            return false;

        }

        /** Check for car in garage and remove it. Pass true if car was removed.
         * Removed car object is assigned to the variable justLeft.
         * @param name the plate number of the car.
         * @return true if car is found in list but false if not.
         */
        public boolean depart(String name)
        {
            int position = -1;

            // Traverse array to check for car position.
            for (int i = 0; i < Garage.size(); i++)
            {
                String matchName = Garage.get(i).getName();  //get plate number
                if ( name.equals(matchName) )                //compare plate numbers
                {
                    position = i;                       // Get index if car is found
                }
            }

            // if car is in garage then increment moves for cars ahead of it.
            // Remove car and add its values to justLeft variable.
            if (position != -1)
            {
                for (int i=position - 1; i >= 0; i--)
                {
                    Garage.get(i).addMove();
                }

                justLeft = Garage.remove(position);

                return true;

            }

            return false;
        }

        /**
         * Gets the value of the variable justLeft.
         * @return justLeft the variable that contains the last car to leave.
         */
        public Car getLeft()
        {
            return justLeft;
        }




    }

}
