package Week10.Command.src;
public class MusicPlayCommand implements Command {
    private MusicSystem musicSystem;
    private String song;
    private String previousSong;

    public MusicPlayCommand(MusicSystem musicSystem, String song) {
        this.musicSystem = musicSystem;
        this.song = song;
    }

    @Override
    public void execute() {
        if (!musicSystem.isOn()) {
            musicSystem.turnOn();
        }
        musicSystem.playSong(song);
    }

    @Override
    public void undo() {
        musicSystem.turnOff();
    }

    @Override
    public String getDescription() {
        return "Play " + song;
    }
}