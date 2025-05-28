package Week10.Command.src;
public class MusicSystem {
    private String location;
    private boolean isOn;
    private int volume; // 0-100
    private String currentSong;

    public MusicSystem(String location) {
        this.location = location;
        this.isOn = false;
        this.volume = 30;
        this.currentSong = "No song";
    }

    public void turnOn() {
        isOn = true;
        System.out.println("🎵 " + location + " music system is ON (volume: " + volume + "%)");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("🔇 " + location + " music system is OFF");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        if (isOn) {
            System.out.println("🔊 " + location + " volume set to " + volume + "%");
        }
    }

    public void playSong(String song) {
        if (isOn) {
            this.currentSong = song;
            System.out.println("🎶 Now playing: " + song + " in " + location);
        }
    }

    public boolean isOn() {
        return false;
    }
}
