package Week10.Observer.src;
import java.util.HashMap;
import java.util.Map;

// Concrete Observer - Mobile App yang memberikan push notifications
public class MobileApp implements Observer {
    private String appName;
    private Map<String, Integer> notificationCount;

    public MobileApp(String appName) {
        this.appName = appName;
        this.notificationCount = new HashMap<>();
    }

    @Override
    public void update(String event, String data) {
        // Count notifications by type
        notificationCount.put(event, notificationCount.getOrDefault(event, 0) + 1);

        // Send push notification
        System.out.println("  📲 " + appName + " sent push notification: " + data);

        // Special handling for live streams (high priority)
        if (event.equals("LIVE_STREAM")) {
            System.out.println("  🚨 " + appName + " sent HIGH PRIORITY notification!");
        }
    }

    @Override
    public String getName() {
        return appName;
    }

    public void showStats() {
        System.out.println("\n📊 " + appName + " Notification Stats:");
        for (Map.Entry<String, Integer> entry : notificationCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " notifications");
        }
    }
}