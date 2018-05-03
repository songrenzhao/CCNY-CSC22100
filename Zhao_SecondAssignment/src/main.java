// Songren Zhao
// 23390916
// CSC 22100 Spring 2018

import java.util.Scanner;
public class main
{
    public static Board raceGame; //I put these variables into static because it will be shared among multiple methods
    public static Player Tortoise = new Player('T');
    public static Player Hare = new Player('H');
    public static void check() //Make sure I will not assign out of bound
    {
        if(Tortoise.getIndex() < raceGame.getGameLength() && Hare.getIndex() < raceGame.getGameLength())
        {
            raceGame.getArray()[Tortoise.getIndex()] = "T";
            raceGame.getArray()[Hare.getIndex()] = "H";
        }
    }
    public static void reset() //Since H and T were modified by the first trial, I have to reset the locations of H and T,
    {
        raceGame = new Board();
        Tortoise = new Player('T');
        Hare = new Player('H');
    }
    public static void run(int size)
    {
        raceGame = new Board(size); //This is determine the size of the race
        int time = 1;
        System.out.println("BANG !!!\nAND THEY'RE OFF");
        while(Tortoise.getIndex() < raceGame.getGameLength()-1 && Hare.getIndex() < raceGame.getGameLength()-1)
        {
            raceGame.getArray()[Tortoise.getIndex()] = " "; //I make sure there is only one H and one T at a time
            raceGame.getArray()[Hare.getIndex()] = " ";//I set the previous location to _ before I move to the next trial
            int jumps = (int)(Math.random()*10+1);     //Because i don't want any recurrences
            switch(jumps) { //Switch for probability assigning to each action
                case 1: case 2:
                    Tortoise.setIndex(3);
                    check();
                    break;
                case 3: case 4:
                    Tortoise.setIndex(3);
                    Hare.setIndex(9);
                    check();
                    break;
                case 5:
                    Tortoise.setIndex(3);
                    Hare.setIndex(-12);
                    check();
                    break;
                case 6: case 7:
                    Tortoise.setIndex(-6);
                    Hare.setIndex(1);
                    check();
                    break;
                case 8:
                    Tortoise.setIndex(1);
                    Hare.setIndex(1);
                    check();
                    break;
                case 9:case 10:
                    Tortoise.setIndex(1);
                    Hare.setIndex(-2);
                    check();
                    break;
            }
            if(Tortoise.getIndex() == Hare.getIndex())
                raceGame.getArray()[Tortoise.getIndex()] = "Ouch";
            if(Tortoise.getIndex() < raceGame.getGameLength() && Hare.getIndex() < raceGame.getGameLength())
            {
                System.out.println("At time t = " + (time++) + ". Hare is at position " + (Hare.getIndex()+1)
                                    + ", Tortoise is at position " + ((Tortoise.getIndex()+1)));
                for (int i = 0; i < raceGame.getArray().length; i++)
                    System.out.print(raceGame.getArray()[i]);
                System.out.println("\n");
            }
        }
        if(Hare.getIndex() >= raceGame.getGameLength() && Tortoise.getIndex() >= raceGame.getGameLength())
            System.out.println("It's a tie");
        else if(Hare.getIndex() > Tortoise.getIndex())
            System.out.println("Hare wins. Yuch");
        else
            System.out.println("TORTOISE WINS!!! YAY!!!");

        System.out.println();
    }
    public static void main(String[] args)
    {
        run(70); //First race, size is 70 by default
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to start another race? Please look at the following options");
        System.out.printf("%s\n%s\n", "1. Start the race", "2. Shut down the program");
        System.out.print("Please select your choice: ");
        int option = input.nextInt();
        switch (option)
        {
                case 1:
                    System.out.print("Please enter your desired distance for the race: ");
                    int distance = input.nextInt();
                    reset(); //Since H and T were modified by the first trial, I have to reset the locations of H and T,
                    run(distance); //Run the race one more time
                    break;
                case 2:
                    System.exit(0);
                    break;
        }
    }
}
