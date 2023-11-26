package SongProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * The main class for the music app demonstration. This class showcases the
 * creation of albums, addition of songs to these albums, and playlist
 * management. It also provides a simple command-line interface to interact with
 * playlists.
 * 
 * @author Rishab Ramalingam
 */
public class Main {

	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) {

		Album album = new Album("Scorpion", "Drake");
		album.addSong("Survival", 2.16);
		album.addSong("Nonstop", 3.58);
		album.addSong("Elevate", 3.04);
		album.addSong("Emotionless", 5.02);
		album.addSong("God's Plan", 3.18);
		album.addSong("Im Upset", 3.34);
		album.addSong("Mob Ties", 3.24);
		albums.add(album);

		album = new Album("Utopia", "Travis Scott");
		album.addSong("HYAENA", 3.42);
		album.addSong("THANK GOD", 3.04);
		album.addSong("MODERN JAM", 4.15);
		album.addSong("MY EYES", 4.11);
		album.addSong("GODS COUNTRY", 2.07);
		album.addSong("SIRENS", 3.24);
		album.addSong("MELTDOWN", 4.06);
		albums.add(album);

		LinkedList<Song> playlist_1 = new LinkedList<>();
		albums.get(1).addPlayList("MY EYES", playlist_1);
		albums.get(0).addPlayList("Nonstop", playlist_1);
		albums.get(1).addPlayList("MODERN JAM", playlist_1);
		albums.get(1).addPlayList("THANK GOD", playlist_1);
		albums.get(1).addPlayList("SIRENS", playlist_1);
		albums.get(1).addPlayList("MELTDOWN", playlist_1);

		play(playlist_1);
	}

	/**
	 * Plays the songs in the provided playlist. Provides a command-line interface
	 * for the user to control the playback. Users can choose to play the next or
	 * previous song, replay the current song, or delete a song from the playlist.
	 *
	 * @param playList The playlist of songs to be played.
	 */
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();

		if (playList.size() == 0) {
			System.out.println("This playlist is empty");
		} else {
			System.out.println("Now playing " + listIterator.next().toString());
			printMenu();
		}
		while (!quit) {
			int action = sc.nextInt();
			switch (action) {

			case 0:
				System.out.println("Playlist exited!");
				quit = true;

			case 1:
				if (!forward) {
					if (listIterator.hasNext()) {
						listIterator.next();

						forward = true;

					}
				}
				if (listIterator.hasNext()) {
					System.out.print("Now playing " + listIterator.next().toString());
					break;

				} else {
					System.out.print("No song available next :( ");
					forward = false;
				}
				break;

			case 2:
				if (forward) {
					if (listIterator.hasPrevious()) {
						listIterator.hasPrevious();
						forward = false;
					}

				}
				if (listIterator.hasPrevious()) {
					System.out.print("Now playing " + listIterator.previous().toString());
				} else {
					System.out.println("This is the first song!");
					forward = false;

				}
				break;

			case 3:
				if (forward) {
					if (listIterator.hasPrevious()) {
						System.out.print("Now playing " + listIterator.previous().toString());
						forward = false;

					} else {
						System.out.println("This is the first song!");

					}
					break;
				} else {
					if (listIterator.hasNext()) {
						System.out.print("Now playing " + listIterator.next().toString());
						forward = true;
					} else {
						System.out.print("No song available next :( ");
					}
					break;
				}
			case 4:
				printList(playList);
				break;
			case 5:
				printMenu();
				break;
			case 6:

				if (playList.size() > 1) {
					listIterator.remove();

					if (listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
						forward = true;

					} else {
						if (listIterator.hasPrevious()) {
							System.out.println("Now playing \" + listIterator.previous().toString()");

						} else {
							if (listIterator.hasNext()) {

								System.out.println("Now playing " + listIterator.next().toString());

								forward = true;
							}
						}
					}
				} else {
					System.out.println("There are no more songs left in the playlist :(");
				}
			}
		}

	}

	/**
	 * Displays the menu of options for the user. This method is called during the
	 * playback to show available control options.
	 */
	private static void printMenu() {
		System.out.println("Available options\n Press");
		System.out.println("0 - to quit\n" + "1 - to play the next song\n" + "2 - to play the previous song\n"
				+ "3 - to replay the current song\n" + "4 - to see all songs\n" + "5 - to see all available options\n"
				+ "6 - to delete the current song");
	}

	/**
	 * Prints the list of songs in the current playlist. This method helps the user
	 * see all the songs available in the playlist.
	 *
	 * @param playList The playlist whose songs are to be displayed.
	 */
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("-----------------");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-----------------");

	}

}
