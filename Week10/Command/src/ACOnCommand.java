package Week10.Command.src;
public class ACOnCommand implements Command {
    private AirConditioner ac;

    public ACOnCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOn();
    }

    @Override
    public void undo() {
        ac.turnOff();
    }

    @Override
    public String getDescription() {
        return "Turn ON AC";
    }
}
