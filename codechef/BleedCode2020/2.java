/* package codechef; // don't place package name! */

import java.lang.Boolean;
import java.lang.String;
import java.lang.String;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.HashMap;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc=new Scanner(System.in);
        int t;
        t=sc.nextInt();
        while(t-->0){
            int n;
            n=sc.nextInt();
            int k;
            k=sc.nextInt();

            Garage bashemin = new Garage() ;

            for(int i=0;i<k;i++){

                String action = sc.next();

               String name = sc.next();



                if(action.equals("A"))
                {
                    // Create car object
                    Car nextCar = new Car(name);

//                    // echo input operations to window and output file
//                    System.out.println("Car with plate number: "+ name + " is arriving"
//                            +  ".");


                    // if garage is not full add car, else turn car away.
                    if (bashemin.arrive(nextCar,n) == true)
                    {

                        System.out.println("AVAILABLE");

                    }
                    else
                    {
                        System.out.println("NO ROOM");

                    }

                }

                else
                {
//                    System.out.println("Car with plate number: "+ name +
//                            " is departing.");


                    // if depart method finds car in array, get values and remove car..
                    //                                          else car not found.
                    if ( bashemin.depart(name) == true)
                    {
                        int moves = bashemin.getLeft().getMoves();

                        System.out.println(moves );


                    }
                    else
                    {
                        System.out.println("NOT FOUND");


                    }

                }

            }

        }
    }



    public  static class Garage {

        private  Car justLeft;

        private  ArrayList<Car> Garage;

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
        public  boolean arrive(Car number,int n)   // Add a car to list if list < 10
        {
            if (Garage.size() < n)
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
        public  boolean depart(String name)
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
        public  Car getLeft()
        {
            return justLeft;
        }




    }

    public static class Car {


        private  String name;  // license plate number
        private  int moves = 0;    // number of moves car has endured

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
        public  void addMove()   //increment number of moves
        {
            moves = moves + 1;
        }

        /**
         * Gets the plate number of car.
         * @return the plate number.
         */
        public  String getName()
        {
            return name;
        }

        /**
         * Gets the number of times the car was moved.
         * @return the number of moves.
         */
        public  int getMoves()
        {
            return moves;
        }




    }

}
