package Week10.Command.src;

class LightDimCommand implements Command {
    private Light light;
    private int newBrightness;
    private int previousBrightness;

    public LightDimCommand(Light light, int brightness) {
        this.light = light;
        this.newBrightness = brightness;
    }

    @Override
    public void execute() {
        previousBrightness = light.getBrightness();
        light.setBrightness(newBrightness);
    }

    @Override
    public void undo() {
        light.setBrightness(previousBrightness);
    }

    @Override
    public String getDescription() {
        return "Set " + light.getLocation() + " light to " + newBrightness + "%";
    }
}
