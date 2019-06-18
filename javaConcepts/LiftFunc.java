package javaConcepts;
import java.awt.geom.*;
import java.util.Scanner;
import java.io.*;
public class LiftFunc {
	public static void main(String args[])
	{
		int floor = (int) (Math.random() * 10 + 1);
		int person;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("The elevator is now on floor " +floor);
        System.out.print("Which floor are you at now (0-10) where 0 = basement: ");
		int personChoice = keyboard.nextInt();
		System.out.println(floor+","+personChoice);
		
		if(personChoice==floor)
		{
			System.out.println("you are on the floor no " +personChoice+" ,Enter some other floor number");
		}
		if(personChoice>floor)
		{
			System.out.println("The elevator is on it's way up...");
			for(person=personChoice;personChoice>=floor;floor++)
			{
				System.out.println(floor);

		        System.out.println("The elevator has arrived");
			}
		}
		if(personChoice<floor)
		{
			
			System.out.println("The elevator is on it's way down...");
			for(person=personChoice;personChoice<=floor;floor--)
			{
				System.out.println(floor);

		        System.out.println("The elevator has arrived");
			}
		}
	}

}
