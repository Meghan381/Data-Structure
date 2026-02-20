
public  class Playlist {
SongNode head;
	public Playlist() {
		// TODO Auto-generated constructor stub
		this.head = null;
	}
public	void adding(Song song) {
		SongNode newNode = new SongNode(song);
		if(head == null) {
			head = newNode;
			return;
		}
		SongNode temp = head;
		while( temp.Next != null) {
			temp = temp.Next;
		}
		temp.Next = newNode;
	}
public	void playAll() {
		SongNode current = head;
		while(current != null) {
			playSong( current.song);
			current = current.Next;
		}
		
		System.out.println("end of playlist");
		
	}

public 	void playSong( Song song) {
		System.out.println(" playing:" + song.title + "1 artist:"+ song.artist+ " 1 duration:"+ song.duration + "s");
		try {
			Thread.sleep(song.duration * 1000);
		}catch (InterruptedException e){
			System.out.println("PlaybackInterrupted");
		}
	}

}
