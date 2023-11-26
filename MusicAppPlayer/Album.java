package SongProject;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Represents a music album, including details such as album name, artist, and a
 * collection of songs. Provides functionalities to add songs to the album, find
 * a specific song, and manage playlists.
 * 
 * @author Rishab Ramalingam
 */
public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	/**
	 * Constructs a new Album with a specified name and artist. Initializes an empty
	 * list to store songs.
	 *
	 * @param name   The name of the album.
	 * @param artist The name of the artist of the album.
	 */
	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}

	/**
	 * Attempts to add a new song to the album. If the song already exists, it is
	 * not added again.
	 *
	 * @param title    The title of the song.
	 * @param duration The duration of the song in minutes.
	 * @return true if the song was successfully added, false otherwise.
	 */
	public boolean addSong(String title, double duration) {
		if (findSong(title) == null) {
			songs.add(new Song(title, duration));
			return true;
		} else {
			System.out.println(title + " is already on the list");
			return false;
		}
	}

	/**
	 * Searches for a song in the album by its title.
	 *
	 * @param title The title of the song to find.
	 * @return The Song object if found, null otherwise.
	 */
	public Song findSong(String title) {
		for (Song checkedSong : songs) {
			if (checkedSong.getTitle().equals(title))
				return checkedSong;
		}
		return null;
	}

	/**
	 * Adds a song to the playlist by its track number in the album. Track numbers
	 * start from 1.
	 *
	 * @param trackNumber The track number of the song in the album.
	 * @param PlayList    The playlist to which the song will be added.
	 * @return true if the song was successfully added to the playlist, false
	 *         otherwise.
	 */
	public boolean addPlayList(int trackNumber, LinkedList<Song> PlayList) {
		int index = trackNumber - 1;
		if (index >= 0 && index < this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		} else {
			System.out.println("The entered track number " + trackNumber + " does not exist");
			return false;
		}
	}

	/**
	 * Adds a song to the playlist by its title.
	 *
	 * @param title    The title of the song to add to the playlist.
	 * @param PlayList The playlist to which the song will be added.
	 * @return true if the song was successfully added to the playlist, false
	 *         otherwise.
	 */
	public boolean addPlayList(String title, LinkedList<Song> PlayList) {
		for (Song checkedSong : this.songs) {
			if (checkedSong.getTitle().equals(title)) {
				PlayList.add(checkedSong);
				System.out.println(checkedSong + " was added to the playlist ");
				return true;
			}
		}

		System.out.println("The entered Song does not exist in the album");
		return false;
	}

}
