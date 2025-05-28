package Week10.Command.src;

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }

    @Override
    public String getDescription() {
        return "Turn OFF " + light.getLocation() + " light";
    }
}
