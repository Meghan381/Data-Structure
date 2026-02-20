
public class MusicApp {

	public MusicApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TOPDO Auto-generated method stub
Playlist Playlist = new Playlist();
Playlist.adding(new Song("Perfect","Ed Sheran",5));
Playlist.adding(new Song("Halo","Beyonce",4));
Playlist.adding(new Song("One Love","Bob Marley",6));
Playlist.playAll();
	}

}
