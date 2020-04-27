import java.util.Scanner;

public class Main{
	private final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MusicPlayer mp = new MusicPlayer();

		int s;
		boolean a=true, b, c;
		String temp1, temp2;

		while (a) {
			b = true;
			System.out.println("\nEnter ");
			System.out.print("\t1. PlayList \n\t2. Album \t3. Exit\n-> ");
			s = isValidInt(3); // Check
			switch (s) {
				/* ||||||||| { PLAYLIST SECTION } ||||||||| */
				case 1:
					while (b) {
						c = true;
						System.out.println("\nEnter ( " + mp.getPlayList() + " )");
						System.out.print("\t1. View \t2. Select \t3. Add \n\t4. Delete \t5. Rename \t6. Back \n\t7. Exit\n-> ");
						s = isValidInt(7); // Check
						switch (s) {
							case 1: // Display list of playlist
								mp.displayPlayList();
								break;

							case 2: // Selecting a playlist and editing it
								System.out.print("Enter the name of album : ");
								temp1 = sc.nextLine();   // Input
								if (mp.selectPlayList(temp1) == null) {  // If error occur
									System.out.println(temp1 + " is same as current album or it is not present");
								} else {     // If successfully changed
									System.out.print("Enter inside " + mp.getPlayList() + " PlayList (Y/N) : ");
									temp1 = isValidString();
									// Entering into playlist
									if (temp1.equals("Y") || temp1.equals("y")) {
										System.out.println("\nEnter ( " + mp.getPlayList() + " )");
										while (c) {
											System.out.print("\t1. List \t2. Add song \n\t3. Remove Song \n\t4. Back \t5. Exit\n-> ");
											s = isValidInt(5);
											switch (s) {
												case 1: // List of song in current play list
													mp.songInPlayList();
													break;

												case 2: // Adding song to current playlist
													System.out.print("Enter the name of song : ");
													temp1 = isValidString();   // Input
													mp.addSongInPLayList(temp1);
													break;

												case 3: // Remove song from current playlist
													System.out.print("Enter the name of song : ");
													temp1 = isValidString();   // Input
													mp.removeSongInPlayList(temp1);
													break;

												case 5:
													a = b = false; // Exit
												case 4:
													c = false; // exit
													break;
											}
											System.out.println("\n" + mp.getAlbum());
										}
									}
								}
								break;

							case 3: // Creating a new playlist
								System.out.print("Enter the name : ");
								temp1 = isValidString();   // Input
								mp.addPlayList(temp1);
								break;

							case 4: // Deleting a playlist
								System.out.print("Enter the name of album : ");
								temp1 = isValidString();   // Input
								mp.deletePlayList(temp1);
								break;

							case 5: // Rename a particular playlist
								System.out.print("Enter the original name of album : ");
								temp1 = isValidString();   // Input
								System.out.print("Enter the new name of album : ");
								temp2 = isValidString();   // Input
								mp.renamePlayList(temp1, temp2);
								break;

							case 7:
								a = false; // Exit
							case 6:
								b = false; // exit
								break;
						}
					}
					break;

				/* ||||||||| { ALBUM SECTION } ||||||||| */
				case 2:
					while (b) {
						c = true;
						System.out.println("\nEnter ( " + mp.getAlbum() + " )");
						System.out.print("\t1. View \t2. Select \t3. Add \n\t4. Delete \t5. Rename \t6. Back \n\t7. Exit\n-> ");
						s = isValidInt(7); // Check
						switch (s) {
							case 1: // Display list of album
								mp.displayAlbum();
								break;

							case 2: // Selecting an album and editing it
								System.out.print("Enter the name of album : ");
								temp1 = isValidString();   // Input
								if(mp.selectAlbum(temp1) == null) {  // If error occur
									System.out.println(temp1 + " is same as current album or it is not present");
								} else {     // If successfully changed
									System.out.print("Enter inside " + mp.getAlbum() + " album (Y/N) : ");
									temp1 = isValidString();
									// Entering into album
									if (temp1.equals("Y") || temp1.equals("y")) {
										System.out.println("\nEnter ( " + mp.getAlbum() + " )");
										while (c) {
											System.out.print("\t1. List \t2. Add song \n\t3. Remove Song \n\t4. Back \t5. Exit\n-> ");
											s = isValidInt(5);
											switch (s) {
												case 1: // List of song in current album
													mp.songInAlbum();
													break;

												case 2: // Adding song to current album
													System.out.print("Enter the name of song : ");
													temp1 = isValidString();   // Input
													System.out.print("Enter the Duration of song : ");
													temp2 = isValidString();   // Input
													mp.addSongInAlbum(temp1, temp2);
													break;

												case 3: // delete song from current album and playlist too
													System.out.print("Enter the name of song : ");
													temp1 = isValidString();   // Input
													mp.removeSongInAlbum(temp1);
													break;

												case 5:
													a = b = false; // Exit
												case 4:
													c = false; // exit
													break;
											}
											System.out.println("\n" + mp.getAlbum());
										}
									}
								}
								break;

							case 3: // Creating a new album
								System.out.print("Enter the name : ");
								temp1 = isValidString();   // Input
								mp.addAlbum(temp1);
								break;

							case 4: // Deleting an album
								System.out.print("Enter the name of album : ");
								temp1 = isValidString();   // Input
								mp.deleteAlbum(temp1);
								break;

							case 5: // Rename a particular album
								System.out.print("Enter the original name of album : ");
								temp1 = isValidString();   // Input
								System.out.print("Enter the new name of album : ");
								temp2 = isValidString();   // Input
								mp.renameAlbum(temp1, temp2);
								break;

							case 7:
								a = false; // Exit
							case 6:
								b = false; // exit
								break;
						}
					}
					break;

				case 3:
					a = false; // Exit
					break;
			}
		}
	}

	// To check validity of input string
	private static String isValidString() {
		String ip = sc.nextLine();  // Storing input
		// Checking it empty
		if (ip.isBlank()) {
			// Error message & recursive call
			System.out.print("! -> Please enter a string <- !\n-> ");
			return isValidString();
		}
		// Removing excess spaces
		return ip.trim();
	}

	// To check validity of input integer
	private static int isValidInt(int max) {
		int num;
		if (sc.hasNextInt()) {  // check if input is integer
			num = sc.nextInt();
			if (num >=1 && num<=max) {// check if input is in limit
				sc.nextLine(); // escape sequence
				return num;    // return if true
			}
		}
		// Invalid message
		System.out.print("! -> Please enter a valid integer <- !\n-> ");
		sc.nextLine(); // Escape sequence from enter key
		// Recursive call
		return isValidInt(max);
	}
}
