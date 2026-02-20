# Music Player System
## MAIN PROGRAM
BEGIN MAIN
    CREATE MusicPlayerApp object called app
    CALL app.start()
END MAIN
## MusicPlayerApp Logic
METHOD start()
    SET choice
    DO
        DISPLAY menu
        INPUT choice
        IF choice = 1 THEN
            CALL addSong()
        ELSE IF choice = 2 THEN
            CALL removeSong()
        ELSE IF choice = 3 THEN
            CALL displayPlaylist()
        ELSE IF choice = 4 THEN
            CALL playCurrentSong()
        ELSE IF choice = 5 THEN
            CALL pauseSong()
        ELSE IF choice = 6 THEN
            CALL nextSong()
        ELSE IF choice = 7 THEN
            CALL previousSong()
        ELSE IF choice = 8 THEN
            CALL resumeSong()
        ELSE IF choice = 9 THEN
            CALL searchSong()
        ELSE IF choice = 10 THEN
            CALL addSongAtPosition()
        ELSE IF choice = 11 THEN
            CALL loadMusicFromFolder()
        ELSE IF choice = 12 THEN
            DISPLAY music folder location
        ELSE IF choice = 0 THEN
            DISPLAY "Goodbye"
            STOP player
        ELSE
            DISPLAY "Invalid choice"
        END IF
    WHILE choice ≠ 0
END METHOD
## METHOD addSong(title, artist, filePath)
    CREATE new Song
    IF playlist is empty THEN
        SET head, tail, currentSong = new Song
    ELSE
        ADD new Song at end
        UPDATE tail
    END IF
    INCREMENT size
END METHOD
## METHOD removeSong(title)
    IF playlist empty THEN
        DISPLAY "Playlist empty"
    ELSE
        SEARCH for song
        REMOVE song if found
        UPDATE links
    END IF
END METHOD
## METHOD nextSong()
    IF currentSong has next THEN
        MOVE to next
    ELSE
        MOVE to first song
    END IF
END METHOD
## METHOD previousSong()
    IF currentSong is first THEN
        MOVE to last song
    ELSE
        MOVE to previous song
    END IF
END METHOD
## METHOD play(filePath)
    IF file exists THEN
        STOP current playback
        START new thread
        PLAY file
    ELSE
        DISPLAY "File not found"
    END IF
END METHOD
## METHOD pause()
    STOP player
END METHOD
## METHOD resume()
    PLAY last file again
END METHOD
## METHOD stop()
    CLOSE player
END METHOD
##  Program Flow Summary
BEGIN MAIN
    Initialize system
    Show menu repeatedly
    Perform selected playlist or playback operation
    Exit when user selects 0
END MAIN