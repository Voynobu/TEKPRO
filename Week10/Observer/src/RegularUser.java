package Week10.Observer.src;

import java.util.ArrayList;
import java.util.List;

// Concrete Observer - Regular User yang follow orang lain
public class RegularUser implements Observer {
    private String name;
    private List<String> notifications;
    private boolean enableNotifications;

    public RegularUser(String name) {
        this.name = name;
        this.notifications = new ArrayList<>();
        this.enableNotifications = true;
    }

    @Override
    public void update(String event, String data) {
        if (!enableNotifications) {
            return; // Skip notification jika dimatikan
        }

        String notification = "";
        switch (event) {
            case "NEW_POST":
                notification = "📝 New post: " + data;
                break;
            case "LIVE_STREAM":
                notification = "🔴 Live now: " + data;
                break;
            case "LIVE_ENDED":
                notification = "⚫ " + data;
                break;
            case "NEW_STORY":
                notification = "📸 " + data;
                break;
            default:
                notification = "📱 " + data;
        }

        notifications.add(notification);
        System.out.println("  🔔 " + name + " received: " + notification);
    }

    @Override
    public String getName() {
        return name;
    }

    public void enableNotifications() {
        this.enableNotifications = true;
        System.out.println("🔔 " + name + " enabled notifications");
    }

    public void disableNotifications() {
        this.enableNotifications = false;
        System.out.println("🔕 " + name + " disabled notifications");
    }

    public void viewNotifications() {
        System.out.println("\n📱 " + name + "'s Notifications:");
        if (notifications.isEmpty()) {
            System.out.println("  No notifications");
        } else {
            for (int i = notifications.size() - 1; i >= Math.max(0, notifications.size() - 5); i--) {
                System.out.println("  " + notifications.get(i));
            }
        }
    }
}