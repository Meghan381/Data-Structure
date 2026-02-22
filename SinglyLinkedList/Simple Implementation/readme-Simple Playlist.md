# Simple Playlist
This project is a simple Playlist Management System built using Java.
It demonstrates the use of:

Object-Oriented Programming (OOP)

Linked Lists

Classes and Objects

Constructors

Methods

Exception Handling (Thread.sleep)

Traversing a linked list

## The program allows users to:

Add songs to a playlist

Play all songs sequentially

Simulate song playback using thread delay

## Project Structure

The project contains three main classes:

1️⃣ Song

Represents a song with:

title

artist

duration (in seconds)

2️⃣ SongNode

Represents a node in the linked list.
Each node contains:

A Song object

A reference to the next node

3️⃣ Playlist

Manages the playlist using a singly linked list.

## Methods:
Method	Description
adding(Song song)	Adds a song to the end of the playlist
playAll()	Plays all songs in order
playSong(Song song)	Simulates playing a song
## Sample Code 
public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.adding(new Song("Shape of You", "Ed Sheeran", 3));
        playlist.adding(new Song("Blinding Lights", "The Weeknd", 4));
        playlist.adding(new Song("Perfect", "Ed Sheeran", 5));
        playlist.playAll();
    }
}

## Sample Output
Playing: Shape of You | Artist: Ed Sheeran | Duration: 3s
Playing: Blinding Lights | Artist: The Weeknd | Duration: 4s
Playing: Perfect | Artist: Ed Sheeran | Duration: 5s
End of playlist

img(<img width="655" height="372" alt="SinglySimple" src="https://github.com/user-attachments/assets/6a62befe-b491-4ce4-a530-0701d5087db9" />

