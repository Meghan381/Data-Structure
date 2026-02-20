package com.musicapp.musicplayer;


import java.io.File;
import java.util.Scanner;

import musicplayer.MP3Player;
import musicplayer.Playlist;
import musicplayer.Song;

public class MusicPlayerApp {
    private Playlist playlist;
    private MP3Player mp3Player;
    private Scanner scanner;
    private File musicFolder;

    public MusicPlayerApp() {
        this.playlist = new Playlist();
        this.mp3Player = new MP3Player();
        this.scanner = new Scanner(System.in);
        
        // Setup music folder
        setupMusicFolder();
    }

    private void setupMusicFolder() {
        // Get current working directory
        String currentDir = System.getProperty("user.dir");
        musicFolder = new File(currentDir, "music");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎵 MUSIC PLAYER INITIALIZING");
        System.out.println("=".repeat(60));
        System.out.println("📍 Project location: " + currentDir);
        
        if (!musicFolder.exists()) {
            boolean created = musicFolder.mkdirs();
            if (created) {
                System.out.println("✅ Created music folder at: " + musicFolder.getAbsolutePath());
                System.out.println("📁 PLEASE DO THE FOLLOWING:");
                System.out.println("   1. Open this folder in File Explorer/Finder");
                System.out.println("   2. Copy your MP3 files into it");
                System.out.println("   3. Restart the program");
            }
        } else {
            System.out.println("✅ Music folder found at: " + musicFolder.getAbsolutePath());
            
            // Count MP3 files
            File[] mp3Files = musicFolder.listFiles((dir, name) -> 
                name.toLowerCase().endsWith(".mp3"));
            
            if (mp3Files != null && mp3Files.length > 0) {
                System.out.println("📁 Found " + mp3Files.length + " MP3 files");
                System.out.println("   Use option 11 to load them");
            } else {
                System.out.println("⚠️ Music folder is empty!");
                System.out.println("   Add MP3 files to: " + musicFolder.getAbsolutePath());
            }
        }
        System.out.println("=".repeat(60) + "\n");
    }

    public void start() {
        int choice;
        
        do {
            displayMenu();
            System.out.print("Enter choice: ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1: addSong(); break;
                    case 2: removeSong(); break;
                    case 3: playlist.displayPlaylist(); break;
                    case 4: playCurrent(); break;
                    case 5: mp3Player.pause(); break;
                    case 6: next(); break;
                    case 7: previous(); break;
                    case 8: mp3Player.resume(); break;
                    case 9: searchSongs(); break;
                    case 10: addSongAtPosition(); break;
                    case 11: loadMusicFromFolder(); break;
                    case 12: showMusicFolder(); break;
                    case 0: 
                        System.out.println("Goodbye!");
                        mp3Player.stop();
                        break;
                    default: System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                choice = -1;
            }
        } while (choice != 0);
        
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎵 MUSIC PLAYER MENU");
        System.out.println("=".repeat(50));
        System.out.println(" 1. Add Song Manually");
        System.out.println(" 2. Remove Song");
        System.out.println(" 3. Display Playlist");
        System.out.println(" 4. Play Current Song");
        System.out.println(" 5. Pause");
        System.out.println(" 6. Next Song");
        System.out.println(" 7. Previous Song");
        System.out.println(" 8. Resume");
        System.out.println(" 9. Search Songs");
        System.out.println("10. Add Song at Position");
        System.out.println("11. 📁 LOAD MUSIC FROM FOLDER");
        System.out.println("12. 📂 Show Music Folder Location");
        System.out.println(" 0. Exit");
        System.out.println("=".repeat(50));
    }

    private void showMusicFolder() {
        System.out.println("\n📂 MUSIC FOLDER LOCATION:");
        System.out.println(musicFolder.getAbsolutePath());
        System.out.println("\nTo add music:");
        System.out.println("1. Open this folder in File Explorer/Finder");
        System.out.println("2. Copy your MP3 files into it");
        System.out.println("3. Use option 11 to load them");
    }

    private void loadMusicFromFolder() {
        if (!musicFolder.exists()) {
            System.out.println("❌ Music folder not found!");
            showMusicFolder();
            return;
        }
        
        File[] mp3Files = musicFolder.listFiles((dir, name) -> 
            name.toLowerCase().endsWith(".mp3"));
        
        if (mp3Files == null || mp3Files.length == 0) {
            System.out.println("❌ No MP3 files found in:");
            System.out.println(musicFolder.getAbsolutePath());
            return;
        }
        
        System.out.println("\n📁 MP3 FILES FOUND:");
        System.out.println("-".repeat(50));
        
        for (int i = 0; i < mp3Files.length; i++) {
            System.out.printf("%2d. %s (%d KB)%n", 
                i+1, 
                mp3Files[i].getName(),
                mp3Files[i].length() / 1024);
        }
        
        System.out.println("-".repeat(50));
        System.out.println("Enter numbers to add (e.g., 1,2,3 or 1-5) or A for all): ");
        System.out.print("Choice: ");
        
        String choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("A")) {
            for (File file : mp3Files) {
                addSongToPlaylist(file);
            }
            System.out.println("✅ Added all " + mp3Files.length + " songs!");
        } else {
            // Parse numbers
            String[] parts = choice.split(",");
            for (String part : parts) {
                try {
                    int index = Integer.parseInt(part.trim()) - 1;
                    if (index >= 0 && index < mp3Files.length) {
                        addSongToPlaylist(mp3Files[index]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number: " + part);
                }
            }
        }
    }

    private void addSongToPlaylist(File file) {
        String fileName = file.getName();
        String title = fileName.substring(0, fileName.lastIndexOf('.'));
        
        // Use just the filename - the MP3Player will find it in music folder
        playlist.addSong(title, "Unknown", fileName);
    }

    private void addSong() {
        System.out.print("Song title: ");
        String title = scanner.nextLine();
        System.out.print("Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Filename (e.g., song.mp3): ");
        String filename = scanner.nextLine();
        
        playlist.addSong(title, artist, filename);
    }

    private void addSongAtPosition() {
        System.out.print("Position: ");
        int pos = Integer.parseInt(scanner.nextLine());
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Filename: ");
        String filename = scanner.nextLine();
        
        playlist.addSongAtPosition(pos, title, artist, filename);
    }

    private void removeSong() {
        System.out.print("Song title to remove: ");
        playlist.removeSong(scanner.nextLine());
    }

    private void playCurrent() {
        Song current = playlist.getCurrentSong();
        if (current != null) {
            System.out.println("\n▶ Playing: " + current);
            mp3Player.play(current.getFilePath());
        } else {
            System.out.println("No song selected");
        }
    }

    private void next() {
        Song next = playlist.nextSong();
        if (next != null) {
            mp3Player.stop();
            mp3Player.play(next.getFilePath());
        }
    }

    private void previous() {
        Song prev = playlist.previousSong();
        if (prev != null) {
            mp3Player.stop();
            mp3Player.play(prev.getFilePath());
        }
    }

    private void searchSongs() {
        System.out.print("Search: ");
        playlist.searchSong(scanner.nextLine());
    }

    public static void main(String[] args) {
        MusicPlayerApp app = new MusicPlayerApp();
        app.start();
    }
}

