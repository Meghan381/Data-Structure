# Music Player Application
A Java-based music player application that allows users to manage and play MP3 files from a local folder.

This console-based music player provides playlist management and MP3 playback functionality. It automatically detects MP3 files from a music folder and allows users to play, pause, and manage their songs through an interactive menu.

##  Project Structure
text
music-player/
├── src/
│   └── com/
│       └── musicapp/
│           └── musicplayer/
│               └── MusicPlayerApp.java
├── music/           # Folder for MP3 files (auto-created)
└── README.md
##  Features
Play, pause, resume, and stop MP3 files

Create and manage playlists

Load all MP3 files from music folder automatically

Search songs in playlist

Navigate between songs (next/previous)

Add songs at specific positions

## Requirements
Java 8 or higher

MP3 files for playback

## Usage
First Time Setup
Run the application

## Sample Output

🎵 Music player Menu
==================================================
 Use option 11 to load them
 1. Add Song Manually
 2. Remove Song
 3. Display Playlist
 4. Play Current Song
 5. Pause
 6. Next Song
 7. Previous Song
 8. Resume
 9. Search Songs
10. Add Song at Position
11. 📁 LOAD MUSIC FROM FOLDER
12. 📂 Show Music Folder Location
 0. Exit
==================================================
Enter choice: 11

📁 MP3 FILES FOUND:
--------------------------------------------------
 1. song1.mp3 (5120 KB)
 2. song2.mp3 (4352 KB)
 3. song3.mp3 (5898 KB)
--------------------------------------------------
Enter numbers to add (e.g., 1,2,3 or 1-5) or A for all): 
Choice: A
✅ Added all 3 songs!=