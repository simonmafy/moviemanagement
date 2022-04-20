package sait.mms.managers;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import sait.mms.problemdomain.*;

/**
 * MovieManagementSystem - This class has methods that loads the ArrayList
 * movieList and filters it to the specification that the user wants the
 * information to be displayed. This could be a specific year or could be at
 * random. This class also has methods that scans the movie text file and puts
 * it into the ArrayList movieList. This class also has methods that adds movies
 * into the ArrayList.
 * 
 * @author Simon Ma
 *
 */

public class MovieManagementSystem {

	int duration;
	String title;
	int year;

	public MovieManagementSystem() {
		duration = 0;
		title = "";
		year = 0;
	}

	/**
	 * Gets the input from the user and returns it back to the AppDriver where it is
	 * used for the switch case.
	 * 
	 * @return answer Input from user
	 */
	static public int displayMenu(Scanner input) {
		System.out.println();
		System.out.println("Movie Management System");
		System.out.printf("%-5s %-15s \n", "1", "Add New Movie and Save");
		System.out.printf("%-5s %-15s \n", "2", "Generate List of Movies Released in a Year");
		System.out.printf("%-5s %-15s \n", "3", "Generate List of Random Movies");
		System.out.printf("%-5s %-15s \n", "4", "Exit");
		System.out.print("\n");
		System.out.print("Enter an option: ");
		int answer = input.nextInt();
		return answer;
	}

	/**
	 * Adds movies based on its duration, year, and title to the ArrayList
	 * movieList.
	 * 
	 * @param movieList The ArrayList movieList
	 */
	public static void addMovie(ArrayList<Movie> movieList) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.print("\n");

		Boolean pass1 = false;
		while (pass1 != true) {

			try {
				System.out.print("Enter duration: ");
				int getDuration = input.nextInt();
				input.nextLine();

				System.out.print("Enter Movie Title: ");
				String getTitle = input.nextLine();

				System.out.print("Enter year: ");
				int getYear = input.nextInt();
				System.out.println();
				System.out.println("Saving movie...");
				String addedMovie = getDuration + "," + getTitle + "," + getYear;
				movieList.add(new Movie(getDuration, getYear, getTitle));
				String path = ".\\res\\movies.txt";
				FileWriter movieFile = new FileWriter(path, true);
				PrintWriter printFile = new PrintWriter(movieFile);
				printFile.print("\n" + addedMovie);
				printFile.close();

				System.out.println("Added movie to the data file.");
				System.out.println();
				System.out.print("Please press enter to continue");
				input.nextLine();
				input.nextLine();

				pass1 = true;

			} catch (Exception e) {

				System.out.println("Incorrect input, please try again \n");
				input.next();
			}
		}

	}

	/**
	 * Gives a list of movies within a specific year that is requested by the user.
	 * 
	 * @param movieList The ArrayList movieList
	 */
	public static void generateMovieInYear(ArrayList<Movie> movieList) {
		Scanner input = new Scanner(System.in);
		int totalTime = 0;
		int searchYear = 0;

		Boolean pass2 = false;

		while (pass2 != true) {

			try {

				System.out.print("Enter in year: ");
				searchYear = input.nextInt();
				System.out.println();
				System.out.println("Movielist");
				System.out.printf("%-10s %-10s %-10s \n", "Duration", "Year", "Title");

				pass2 = true;

			} catch (Exception e) {

				System.out.println("Incorrect input, please try again \n");
				input.next();

			}

		}
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getYear() == searchYear) {
				// System.out.print(movieList.get(i).toString());
				System.out.printf("%-10s %-10s %-10s \n", movieList.get(i).getDuration(), movieList.get(i).getYear(),
						movieList.get(i).getTitle());

				totalTime += movieList.get(i).getDuration();
			}
		}

		System.out.println("Total Duration: " + totalTime + " minutes");
		System.out.println();
		System.out.print("Please press enter to continue");

		input.nextLine();
		input.nextLine();

	}

	/**
	 * Scans the movie text file and loads it into the ArrayList movieList.
	 * 
	 * @param movieList The ArrayList movieList
	 * @throws IOException Thrown when the file cannot be accessed.
	 */
	public void loadMovie(ArrayList<Movie> movieList) throws IOException {
		String filename = "./res/movies.txt";
		Scanner input = new Scanner(new FileInputStream(filename), "UTF-8").useDelimiter(",|\\n|\\r");

		int getDuration = 0;
		int getYear = 0;
		String getTitle = "";
		String getX = "";

		while (input.hasNext()) {
			getDuration = input.nextInt();
			getTitle = input.next();
			getX = input.next();
			getYear = Integer.parseInt(getX);
			if (input.hasNextLine()) {
				input.nextLine();
			}
			// Into a string, split into an array with comma, parse into variable
			// getDuration, getYear, getYear, parts [0], parts [1] parts [2], put into
			// object, add to the arraylist
			movieList.add(new Movie(getDuration, getYear, getTitle));
		}

	}

	/**
	 * Gives a list of random movies. The amount of random movies that are given is
	 * specified by the user.
	 * 
	 * @param movieList The ArrayList movieList
	 */
	public void generateRandomMovie(ArrayList<Movie> movieList) {

		Scanner input = new Scanner(System.in);
		int number = 0;
		int totalTime = 0;

		Boolean pass3 = false;

		while (pass3 != true) {

			try {

				System.out.print("Enter number of movies: ");
				number = input.nextInt();

				pass3 = true;

			} catch (Exception e) {

				System.out.println("Incorrect input, please try again \n");

				input.next();
			}

		}

		Random randomGenerate = new Random();

		System.out.println();
		System.out.printf("%-10s %-10s %-10s \n", "Duration", "Year", "Title");

		for (int i = 0; i < number; i++) {

			int randomI = randomGenerate.nextInt(movieList.size());
			System.out.print(movieList.get(randomI).toString());
			totalTime += movieList.get(i).getDuration();
		}
		System.out.println("Total duration: " + totalTime);
		System.out.println();
		System.out.print("Please press enter to continue");
		input.nextLine();
		input.nextLine();

	}
}
