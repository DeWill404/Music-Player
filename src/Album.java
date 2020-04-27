import java.util.ArrayList;

public class Album {
	//  Album name
	private String name;
	// Album song list
	private final ArrayList<Song> song = new ArrayList<>();

	// Constructor
	public Album(String name) {
		this.name = name;
	}

	// Getters for album
	public String getName() {
		return this.name;
	}
	public String getSong(String songName) {
		// Check if present
		for (Song item : song)
			if (item.getName().equals(songName))
				return item.getDuration();
		return null;
	}

	// Display song Method
	public void display() {
		if (this.song.isEmpty()) {
			System.out.println("Album " + this.getName() + " is empty...");
		} else {
			System.out.println(this.getName() + " :");
			for (Song item : this.song)
				System.out.println("\t" + item.getName() + " -> " + item.getDuration());
		}
	}

	// Rename current album Method
	public void rename(String name) {
		// If input name is empty or same as before
		if (name.equals(this.getName())) {
			System.out.println("please enter different name....");
		} else {
			this.name = name;
		}
	}

	// Check if songName and songDuration is valid
	private boolean isValidSong(String songName, String songDuration) {
		// If duration values do not have separator
		if (!songDuration.contains(":"))
			return false;
		// If duration is not a number
		try {
			songDuration = songDuration.replace(':', '0');
			Integer.parseInt(songDuration);
		} catch (NumberFormatException e) {
			return false;
		}
		// If song is already present
		for (Song item : this.song)
			if (item.getName().equals(songName))
				return false;

		return true;
	}

	// Method to add new song
	public void addSong(String songName, String songDuration) {
		if (isValidSong(songName, songDuration)) {  // If song is valid
			this.song.add(new Song(songName, songDuration));
		} else {		// If song is not valid
			System.out.println("Please enter valid song.....");
		}
	}

	// Method to delete song in album
	public void deleteSong(String songName) {
		if (this.song.isEmpty()) {
			boolean isPresent = false;
			Song temp = null;
			for (Song item : this.song) {
				if (item.getName().equals(songName)) {
					isPresent = true;
					temp = item;
				}
			}

			if (isPresent) {
				this.song.remove(temp);
				System.out.println(songName + " removed successfully..");
			} else {
				System.out.println(songName + " is not present..");
			}
		}
	}

	// Song class
	private final class Song {
		// Variable for song
		final private String name;
		final private String duration;

		// Constructor
		public Song(String name, String duration) {
			this.name = name;
			this.duration = duration;
		}

		// Getters for Song class
		public String getName() {
			return this.name;
		}
		public String getDuration() {
			return this.duration;
		}
	}
}
