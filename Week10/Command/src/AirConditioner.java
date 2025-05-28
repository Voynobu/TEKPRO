package Week10.Command.src;

public class AirConditioner {
    private String location;
    private boolean isOn;
    private int temperature; // Celsius

    public AirConditioner(String location) {
        this.location = location;
        this.isOn = false;
        this.temperature = 24;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("❄️ " + location + " AC is ON (temp: " + temperature + "°C)");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("🔴 " + location + " AC is OFF");
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        if (isOn) {
            System.out.println("🌡️ " + location + " AC temperature set to " + temp + "°C");
        }
    }

    public boolean isOn() { return isOn; }
    public int getTemperature() { return temperature; }
}