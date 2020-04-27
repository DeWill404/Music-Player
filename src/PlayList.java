import java.util.ArrayList;

public class PlayList {
	// Playlist name
	private String name;
	// Playlist song list
	private final ArrayList<String[]> song = new ArrayList<>();

	// Constructors
	public PlayList(String name) {
		this.name = name;
	}

	// Getters
	public String getName() {
		return this.name;
	}
	public void getSong() {
		if (!this.song.isEmpty()) {
			System.out.println("\t" + this.getName() + " :");
			for (String[] item : this.song) {
				System.out.println("\t" + item[0] + "\t" + item[1] + "\t" + item[2]);
			}
		} else {
			System.out.println("Playlist " + this.getName() + " is empty......");
		}
	}

	// Setters
	public void rename(String name) {
		if(!name.isBlank() && name.equals(this.getName())) {
			System.out.println("Please enter different name.....");
		} else {
			this.name = name;
			System.out.println("Name is changed to " + name + " successfully.........");
		}
	}

	// Method to check if song is present
	public int isPresent(String name) {
		for (String[] item : this.song)
			if (item[0].equals(name))
				return this.song.indexOf(item); // IF present
		return -1;								// IF not present
	}

	// Method to add song
	public void addSong(String[] songDetail) {
		if(this.isPresent(songDetail[0]) == -1) { // If not present then add
			this.song.add(songDetail);
			System.out.println(songDetail[0] + " is from album " + songDetail[2] + " is added successfully....");
		} else {
			System.out.println(songDetail[0] + " song is already present in playlist " + this.getName() + "....");
		}
	}

	// Method to delete song
	public void deleteSong(String name) {
		int index = this.isPresent(name); // Get index
		if (index != -1) {
			this.song.remove(index); // Delete
			System.out.println(name + " is removed from playlist" + this.getName() + "....");
		} else {					// Not present
			System.out.println(name + " is not present in " + this.getName() + " playlist......");
		}
	}
}
