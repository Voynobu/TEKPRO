package Week10.Observer.src;

import java.util.ArrayList;
import java.util.List;

// Concrete Observer - Email Service
public class EmailService implements Observer {
    private String serviceName;
    private List<String> emailQueue;

    public EmailService(String serviceName) {
        this.serviceName = serviceName;
        this.emailQueue = new ArrayList<>();
    }

    @Override
    public void update(String event, String data) {
        // Only send email for important events
        if (event.equals("NEW_POST") || event.equals("LIVE_STREAM")) {
            String emailContent = "Subject: " + event.replace("_", " ") + " - " + data;
            emailQueue.add(emailContent);
            System.out.println("  📧 " + serviceName + " queued email: " + event);
        }
    }

    @Override
    public String getName() {
        return serviceName;
    }

    public void processEmailQueue() {
        System.out.println("\n📬 " + serviceName + " processing " + emailQueue.size() + " emails...");
        for (String email : emailQueue) {
            System.out.println("  ✉️ Sent: " + email);
        }
        emailQueue.clear();
    }
}
