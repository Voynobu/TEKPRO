package Week10.Command.src;

public class ACOffCommand implements Command {
    private AirConditioner ac;

    public ACOffCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOff();
    }

    @Override
    public void undo() {
        ac.turnOn();
    }

    @Override
    public String getDescription() {
        return "Turn OFF AC";
    }
}