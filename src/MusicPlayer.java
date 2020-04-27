import java.util.*;

public class MusicPlayer {

	// Album
	private Album album;
	private final ArrayList<Album> albums = new ArrayList<>();
	// Playlist
	private PlayList playlist;
	private final ArrayList<PlayList> playlists = new ArrayList<>();

	// Constructor
	public MusicPlayer() {
		this.albums.add(new Album("Default")); // Making "DEFAULT" album
		this.album = this.albums.get(0);			 // Set "Default" as current album
		this.playlists.add(new PlayList("Default")); // Making "DEFAULT" album
		this.playlist = this.playlists.get(0);			 // Set "Default" as current album
	}

	// Getter
	public String getAlbum() {
		return album.getName();
	}
	public String getPlayList() {
		return playlist.getName();
	}

	// ALBUM SECTION ////////////////////////////////////////
	// Check if entered name is valid
	private boolean ifNotPresentInAlbum(String name) {
		if (!name.isEmpty())
			for (Album item : this.albums)
				if (item.getName().equals(name))
					return false;
		return true;
	}
	// To delete album
	public void deleteAlbum(String name) {
		if (name.equals(this.albums.get(0).getName())) {
			System.out.println("Can't delete Default one..");
		} else {  // If not default
			if (!this.ifNotPresentInAlbum(name)) { // If album is present
				for (Album item : this.albums)
					if (item.getName().equals(name)) {       // If found
						if (item.equals(this.album)) {       // if name is current album
							this.album = this.albums.get(0); // set album to default
						}
						this.albums.remove(item); // Remove
						break;
					}
				System.out.println("Album " + name + " is removed successfully....");
			} else {
				System.out.println("Album " + name + " is not present...");
			}
		}
	}
	// Add new Album
	public void addAlbum(String name) {
		if (this.ifNotPresentInAlbum(name)) {
			this.albums.add(new Album(name));
			System.out.println(name + " is added successfully...");
		} else {
			System.out.println(name + " is already preset....");
		}
	}
	// To rename a album
	public void renameAlbum(String original, String target) {
		if (!this.ifNotPresentInAlbum(original)) {	// If valid
			if (!target.isEmpty()) {		// If string is not empty
				for (Album item : this.albums)
					if (item.getName().equals(original)) { // If found
						item.rename(target);	// Rename
						System.out.println("Album " + original + " is successfully renamed to " + target);
					}
			} else {
				System.out.println("Can not replace with empty string....");
			}
		} else {
			System.out.println(original + " album is not present....");
		}
	}
	// Get list of album
	public void displayAlbum() {
		if (this.albums.isEmpty()) {  // If there is no album
			System.out.println("!-> There is not album present here <-!");
		} else {  // If album are present
			System.out.println("\tList of Album");
			for (Album item : this.albums)
				System.out.println("\t* " + item.getName());
		}
	}
	// Select an album as current
	public String selectAlbum(String name) {
		for (Album item : this.albums) {
			if (name.equals(item.getName())) {
				this.album = item;
				return this.getAlbum();
			}
		}
		return null;
	}
	// List song in playlist
	public void songInAlbum() {
		this.album.display();
	}
	// Add song in album
	public void addSongInAlbum(String name, String dur) {
		this.album.addSong(name, dur);
	}
	// Remove song from album
	public void removeSongInAlbum(String name) {
		this.album.deleteSong(name);
		// Delete from playlist too
		for (PlayList item : this.playlists) {
			if (item.isPresent(name) != -1) {
				item.deleteSong(name);
			}
		}
	}

	// PLAYLIST SECTION ////////////////////////////////////////
	// Check if entered name is valid
	private boolean ifNotPresentInPlaylist(String name) {
		if (!name.isEmpty())
			for (PlayList item : this.playlists)
				if (item.getName().equals(name))
					return false;
		return true;
	}
	// To delete playlist
	public void deletePlayList(String name) {
		if (name.equals(this.playlists.get(0).getName())) {
			System.out.println("Can't delete Default one..");
		} else {  // If not default
			if (!this.ifNotPresentInPlaylist(name)) { // If playlist is present
				for (PlayList item : this.playlists)
					if (item.getName().equals(name)) {       // If found
						if (item.equals(this.playlist)) {       // if name is current playlist
							this.playlist = this.playlists.get(0); // set playlist to default
						}
						this.playlists.remove(item); // Remove
						break;
					}
				System.out.println("PlayList " + name + " is removed successfully....");
			} else {
				System.out.println("PlayList " + name + " is not present...");
			}
		}
	}
	// Add new PlayList
	public void addPlayList(String name) {
		if (this.ifNotPresentInPlaylist(name)) {
			this.playlists.add(new PlayList(name));
			System.out.println(name + " is added successfully...");
		} else {
			System.out.println(name + " is already preset....");
		}
	}
	// To rename a playlist
	public void renamePlayList(String original, String target) {
		if (!this.ifNotPresentInPlaylist(original)) {	// If valid
			if (!target.isEmpty()) {		// If string is not empty
				for (PlayList item : this.playlists)
					if (item.getName().equals(original)) { // If found
						item.rename(target);	// Rename
						System.out.println("PlayList " + original + " is successfully renamed to " + target);
					}
			} else {
				System.out.println("Can not replace with empty string....");
			}
		} else {
			System.out.println(original + " playlist is not present....");
		}
	}
	// Get list of playlist
	public void displayPlayList() {
		if (this.playlists.isEmpty()) {  // If there is no playlist
			System.out.println("!-> There is not playlist present here <-!");
		} else {  // If playlist are present
			System.out.println("\tList of PlayList");
			for (PlayList item : this.playlists)
				System.out.println("\t* " + item.getName());
		}
	}
	// Select an playlist as current
	public String selectPlayList(String name) {
		for (PlayList item : this.playlists) {
			if (name.equals(item.getName())) {
				this.playlist = item;
				return this.getPlayList();
			}
		}
		return null;
	}
	// List all song from playlist
	public void songInPlayList() {
		this.playlist.getSong();
	}
	// Add song in playList
	public void addSongInPLayList(String name) {
		for (Album item : this.albums) {
			if (item.getSong(name) != null) {
				String[] temp = {name, item.getSong(name), item.getName()};
				this.playlist.addSong(temp);
				return;
			}
		}
		System.out.println("Invalid song......");
	}
	// Delete song from playlist
	public void removeSongInPlayList(String name) {
		this.playlist.deleteSong(name);
	}
}
