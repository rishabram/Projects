package SongProject;

/**
 * Represents a song with a title and duration. This class provides methods to
 * access song details such as title and duration.
 * 
 * @author Rishab Ramalingam
 */
public class Song {
	private String title;
	private double duration;

	/**
	 * Constructs a new Song with specified title and duration.
	 *
	 * @param title    The title of the song.
	 * @param duration The duration of the song in minutes.
	 */
	public Song(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}

	/**
	 * Gets the title of the song.
	 *
	 * @return The title of the song.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the duration of the song.
	 *
	 * @return The duration of the song in minutes.
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * Returns a string representation of the song, including title and duration.
	 *
	 * @return A string representation of the song.
	 */
	@Override
	public String toString() {
		return title + " / " + duration;
	}
}
