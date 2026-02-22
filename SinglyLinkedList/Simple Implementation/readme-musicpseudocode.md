 # Music Playlist  Pseudocode
 ```
BEGIN MAIN
    CREATE Playlist
    SET head = NULL
    CREATE Song1 ("Perfect", "Ed Sheran", 5)
    CALL adding(Song1)
    CREATE Song2 ("Halo", "Beyonce", 4)
    CALL adding(Song2)
    CREATE Song3 ("One Love", "Bob Marley", 6)
    CALL adding(Song3)
    // Play all songs
    SET current = head
    WHILE current IS NOT NULL DO
        PRINT "Playing: " + current.song.title
        PRINT "Artist: " + current.song.artist
        PRINT "Duration: " + current.song.duration + " seconds"
        WAIT for current.song.duration seconds
        MOVE current TO current.next
    END WHILE
    PRINT "End of playlist"
END MAIN
```
