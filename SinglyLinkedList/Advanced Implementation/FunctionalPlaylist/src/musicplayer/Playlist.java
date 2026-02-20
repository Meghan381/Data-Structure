
	package musicplayer;

	public class Playlist {
	    private Song head;
	    private Song tail;
	    private Song currentSong;
	    private int size;

	    public Playlist() {
	        this.head = null;
	        this.tail = null;
	        this.currentSong = null;
	        this.size = 0;
	    }

	   
	    public void addSong(String title, String artist, String filePath) {
	        Song newSong = new Song(title, artist, filePath);
	        
	        if (head == null) {
	            head = newSong;
	            tail = newSong;
	            currentSong = newSong;
	        } else {
	            tail.setNext(newSong);
	            tail = newSong;
	        }
	        size++;
	        System.out.println("Added: " + title + " by " + artist);
	    }

	  
	    public void addSongAtPosition(int position, String title, String artist, String filePath) {
	        if (position < 1 || position > size + 1) {
	            System.out.println("Invalid position!");
	            return;
	        }

	        Song newSong = new Song(title, artist, filePath);

	        if (position == 1) {
	            newSong.setNext(head);
	            head = newSong;
	            if (size == 0) {
	                tail = newSong;
	                currentSong = newSong;
	            }
	        } else {
	            Song current = head;
	            for (int i = 1; i < position - 1; i++) {
	                current = current.getNext();
	            }
	            newSong.setNext(current.getNext());
	            current.setNext(newSong);
	            
	            if (position == size + 1) {
	                tail = newSong;
	            }
	        }
	        size++;
	        System.out.println("Added: " + title + " at position " + position);
	    }

	
	    public boolean removeSong(String title) {
	        if (head == null) {
	            System.out.println("Playlist is empty!");
	            return false;
	        }

	     
	        if (head.getTitle().equalsIgnoreCase(title)) {
	            head = head.getNext();
	            if (head == null) {
	                tail = null;
	                currentSong = null;
	            } else if (currentSong == head) {
	                currentSong = head;
	            }
	            size--;
	            System.out.println("Removed: " + title);
	            return true;
	        }

	      
	        Song current = head;
	        Song previous = null;

	        while (current != null && !current.getTitle().equalsIgnoreCase(title)) {
	            previous = current;
	            current = current.getNext();
	        }

	        if (current == null) {
	            System.out.println("Song not found: " + title);
	            return false;
	        }

	     
	        previous.setNext(current.getNext());
	        
	       
	        if (current == tail) {
	            tail = previous;
	        }
	        
	    
	        if (current == currentSong) {
	            currentSong = current.getNext();
	        }
	        
	        size--;
	        System.out.println("Removed: " + title);
	        return true;
	    }

	    // Get current song
	    public Song getCurrentSong() {
	        return currentSong;
	    }

	    // Move to next song
	    public Song nextSong() {
	        if (currentSong != null && currentSong.getNext() != null) {
	            currentSong = currentSong.getNext();
	            return currentSong;
	        } else if (currentSong != null && currentSong.getNext() == null) {
	            // Loop back to beginning (optional)
	            currentSong = head;
	            return currentSong;
	        }
	        return null;
	    }

	
	    public Song previousSong() {
	        if (currentSong == null || currentSong == head) {
	            // If at first song, go to last song (optional)
	            currentSong = tail;
	            return currentSong;
	        }

	        Song current = head;
	        while (current != null && current.getNext() != currentSong) {
	            current = current.getNext();
	        }
	        
	        if (current != null) {
	            currentSong = current;
	        }
	        
	        return currentSong;
	    }

	  
	    public void displayPlaylist() {
	        if (head == null) {
	            System.out.println("Playlist is empty!");
	            return;
	        }

	        System.out.println("\n=== PLAYLIST ===");
	        Song current = head;
	        int position = 1;
	        
	        while (current != null) {
	            String indicator = (current == currentSong) ? " ▶ " : "   ";
	            System.out.println(position + "." + indicator + current);
	            current = current.getNext();
	            position++;
	        }
	        System.out.println("Total songs: " + size);
	    }

	   
	    public void searchSong(String keyword) {
	        if (head == null) {
	            System.out.println("Playlist is empty!");
	            return;
	        }

	        System.out.println("\n=== SEARCH RESULTS ===");
	        Song current = head;
	        int found = 0;
	        
	        while (current != null) {
	            if (current.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
	                current.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
	                System.out.println("• " + current);
	                found++;
	            }
	            current = current.getNext();
	        }
	        
	        if (found == 0) {
	            System.out.println("No songs found matching: " + keyword);
	        } else {
	            System.out.println("Found " + found + " song(s)");
	        }
	    }

	   
	    public int getSize() {
	        return size;
	    }

	  
	    public boolean isEmpty() {
	        return head == null;
	    }
	}


