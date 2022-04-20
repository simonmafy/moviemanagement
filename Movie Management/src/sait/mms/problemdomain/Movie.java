package sait.mms.problemdomain;

import java.util.*;

/**
 * Movie - This class loads all the accessors and mutators. This class is mainly
 * used to load all the movie objects into the Arraylist movieList.
 * 
 * @author Simon Ma 562187
 *
 */

public class Movie {
	int duration;
	int year;
	String title;

	Movie() {
		int duration = 0;
		int year = 0;
		String title = "";
	}

	public Movie(int getDuration, int getYear, String getTitle) {

		duration = getDuration;
		year = getYear;
		title = getTitle;
	}

	/**
	 * Gets the movie duration.
	 * 
	 * @return The movie duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets the movie duration.
	 * 
	 * @param duration The movie duration
	 * 
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Get the year of the movie.
	 * 
	 * @return The year of the movie
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year of the movie.
	 * 
	 * @param year The year of the movie
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Get the title of the movie.
	 * 
	 * @return The title of the movie
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the movie.
	 * 
	 * @param title The title of the movie
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The toString Method formats the print into there columns such as duration,
	 * year, and title.
	 */
	public String toString() {
		return String.format("%-10s \n", title);
		// return String.format("%-10s %-10s %-10s \n", duration, year, title);
	}

}
