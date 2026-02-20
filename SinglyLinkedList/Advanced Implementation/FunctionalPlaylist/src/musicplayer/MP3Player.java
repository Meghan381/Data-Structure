package musicplayer;


import javazoom.jl.player.Player;
import java.io.File;
import java.io.FileInputStream;

public class MP3Player {
    private Player player;
    private String currentFilePath;
    private Thread playerThread;
    private boolean isPaused;

    public MP3Player() {
        this.isPaused = false;
    }

    public void play(String filePath) {
        try {
            System.out.println("\n🔍 Attempting to play: " + filePath);
            
            // Get the absolute path to the music folder
            File currentDir = new File(System.getProperty("user.dir"));
            File musicFolder = new File(currentDir, "music");
            
            System.out.println("📁 Current working directory: " + currentDir.getAbsolutePath());
            System.out.println("📁 Music folder path: " + musicFolder.getAbsolutePath());
            
            // Try different ways to find the file
            File file = null;
            
            // Method 1: Direct path
            file = new File(filePath);
            
            // Method 2: In music folder with filename only
            if (!file.exists() && !filePath.contains(File.separator)) {
                file = new File(musicFolder, filePath);
            }
            
            // Method 3: In music folder with music/ prefix
            if (!file.exists() && filePath.startsWith("music/")) {
                file = new File(filePath.replace("music/", musicFolder.getAbsolutePath() + File.separator));
            }
            
            if (!file.exists()) {
                System.out.println("❌ File not found!");
                System.out.println("🔍 Searched locations:");
                System.out.println("   - " + new File(filePath).getAbsolutePath());
                if (musicFolder.exists()) {
                    System.out.println("   - " + new File(musicFolder, filePath).getAbsolutePath());
                    
                    // List all files in music folder to help user
                    System.out.println("\n📁 Files in music folder:");
                    File[] files = musicFolder.listFiles();
                    if (files != null && files.length > 0) {
                        for (File f : files) {
                            System.out.println("   - " + f.getName() + " (" + f.length() + " bytes)");
                        }
                    } else {
                        System.out.println("   (folder is empty)");
                    }
                } else {
                    System.out.println("📁 Music folder doesn't exist!");
                    boolean created = musicFolder.mkdirs();
                    if (created) {
                        System.out.println("✅ Created music folder at: " + musicFolder.getAbsolutePath());
                        System.out.println("📁 Please add MP3 files to this folder and try again.");
                    }
                }
                return;
            }
            
            System.out.println("✅ File found: " + file.getAbsolutePath());
            System.out.println("📊 File size: " + file.length() + " bytes");
            
            // Stop current playback
            stop();
            
            // Play the file
            currentFilePath = file.getAbsolutePath();
            FileInputStream fis = new FileInputStream(file);
            player = new Player(fis);
            
            playerThread = new Thread(() -> {
                try {
                    System.out.println("▶ Playback started");
                    player.play();
                    System.out.println("\n✅ Playback finished");
                } catch (Exception e) {
                    System.out.println("\n⏸️ Playback stopped: " + e.getMessage());
                }
            });
            
            playerThread.start();
            isPaused = false;
            
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void pause() {
        if (player != null && !isPaused) {
            isPaused = true;
            stop();
            System.out.println("⏸️ Paused");
        }
    }

    public void resume() {
        if (isPaused && currentFilePath != null) {
            System.out.println("▶ Resuming...");
            play(currentFilePath);
        }
    }

    public void stop() {
        if (player != null) {
            player.close();
            player = null;
        }
        if (playerThread != null) {
            playerThread.interrupt();
            playerThread = null;
        }
    }

    public boolean isPlaying() {
        return player != null && !isPaused;
    }

    public boolean isPaused() {
        return isPaused;
    }
}