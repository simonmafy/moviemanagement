package sait.mms.application;

import sait.mms.managers.MovieManagementSystem;
import sait.mms.problemdomain.Movie;

import java.util.*;
import java.io.*;

/**
 * AppDriver - This main class loads all the other movie classes such as
 * MovieManagementSystem class, and Movie class. This main class also consists
 * of a switch case within a loop and would end when the number 4 is the input.
 * This main class is part of a program that allows you to add new movies,
 * generate a list of movies released in a year and generate a list of random
 * movies.
 * 
 * @author Simon Ma 562187
 * @version February 13/2020
 */

public class AppDriver {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		/**
		 * Initiates the ArrayList movieList to store objects such as duration, year,
		 * and title.
		 */
		ArrayList<Movie> movieList = new ArrayList<>();

		/**
		 * MovieManagementSystem.loadMovie(movieList); @ returns the Array<Movie>
		 * movieList.
		 */

		MovieManagementSystem obj = new MovieManagementSystem();

		obj.loadMovie(movieList);

		int x = 0;
		while (x != 4) {

			/**
			 * Switch case statement used to as a menu for people to pick from options 1 to
			 * 4. Case 1: adds the movies to the movieList ArrayList. Case 2: generates
			 * movies from the movieList in a given input year. Case 3: generates a random
			 * amount of movies where the amount is given by the user through an input. Case
			 * 4: This exits the program. Default: This is when the user give an invalid
			 * input for a choice, a message would pop up that says invalid option.
			 */
			switch (MovieManagementSystem.displayMenu(input)) {
			case 1:
				MovieManagementSystem.addMovie(movieList);
				break;
			case 2:
				obj.generateMovieInYear(movieList);
				break;
			case 3:
				obj.generateRandomMovie(movieList);
				break;
			case 4:
				System.out.println();
				System.out.println("Goodbye!");
				System.out.println();
				x = 4;
				break;
			default:
				System.out.println();
				System.out.println("Invalid option");
				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

			}

		}
	}
}
