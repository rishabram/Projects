package SongProject;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();

	}

	public boolean addSong(String title, double duration) {
		if (findSong(title) == null) {
			songs.add(new Song(title, duration));
			
			return true;
		} else {
			System.out.println(title + " " + "is already on the list");
			return false;
		}

	}

	public Song findSong(String title) {
		for (Song checkedSong : songs) {
			if (checkedSong.getTitle().equals(title))
				return checkedSong;
		}
		return null;
	}

	public boolean addPlayList(int trackNumber, LinkedList<Song> PlayList) {
		int index = trackNumber - 1;
		if (index > 0 && index <= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			return true;
		} else {
			System.out.println("The entered track number " + trackNumber + " does not exist");
			return false;
		}
	}

	public boolean addPlayList(String title, LinkedList<Song> PlayList) {
		for (Song checkedSong : this.songs) {
			if (checkedSong.getTitle().equals(title)) {
				PlayList.add(checkedSong);
			System.out.println(checkedSong + " was added to the playlist ");
				return true;}
		}
	
			System.out.println("The entered Song does not exist in the album");
			return false;
		}
	}

