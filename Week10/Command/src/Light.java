package Week10.Command.src;

public class Light {
    private String location;
    private boolean isOn;
    private int brightness; // 0-100

    public Light(String location) {
        this.location = location;
        this.isOn = false;
        this.brightness = 50;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("💡 " + location + " light is ON (brightness: " + brightness + "%)");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("🌑 " + location + " light is OFF");
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
        if (isOn) {
            System.out.println("💡 " + location + " light brightness set to " + brightness + "%");
        }
    }

    public boolean isOn() { return isOn; }
    public int getBrightness() { return brightness; }
    public String getLocation() { return location; }
}