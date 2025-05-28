package Week10.Observer.src;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOCIAL MEDIA OBSERVER PATTERN DEMO ===\n");

        // ========== MEMBUAT SUBJECTS (INFLUENCERS) ==========
        System.out.println(">>> CREATING INFLUENCERS <<<");
        SocialMediaUser alice = new SocialMediaUser("@alice_lifestyle");
        SocialMediaUser bob = new SocialMediaUser("@bob_gaming");
        System.out.println("✨ Created influencer accounts\n");

        // ========== MEMBUAT OBSERVERS (FOLLOWERS & SERVICES) ==========
        System.out.println(">>> CREATING OBSERVERS <<<");
        RegularUser john = new RegularUser("John");
        RegularUser sarah = new RegularUser("Sarah");
        RegularUser mike = new RegularUser("Mike");

        MobileApp instagram = new MobileApp("Instagram");
        MobileApp tiktok = new MobileApp("TikTok");
        EmailService emailService = new EmailService("Gmail Notifications");

        System.out.println("👥 Created users and services\n");

        // ========== SUBSCRIPTION PROCESS ==========
        System.out.println(">>> USERS FOLLOWING INFLUENCERS <<<");
        alice.addObserver(john);
        alice.addObserver(sarah);
        alice.addObserver(instagram);
        alice.addObserver(emailService);

        bob.addObserver(john);
        bob.addObserver(mike);
        bob.addObserver(tiktok);
        bob.addObserver(emailService);

        System.out.println();

        // ========== ALICE'S ACTIVITIES ==========
        System.out.println(">>> ALICE'S SOCIAL MEDIA ACTIVITIES <<<");
        alice.createPost("Just tried the new coffee shop downtown! ☕️ #lifestyle");
        alice.uploadStory("Getting ready for today's workout 💪");
        alice.startLiveStream("Morning Yoga Session - Join me! 🧘‍♀️");

        // Sarah disable notifications
        sarah.disableNotifications();
        alice.createPost("Live session was amazing! Thanks everyone who joined! 🙏");

        alice.endLiveStream();

        // ========== BOB'S ACTIVITIES ==========
        System.out.println("\n>>> BOB'S GAMING CONTENT <<<");
        bob.createPost("New gaming setup is fire! 🔥 RTX 4090 installed!");
        bob.startLiveStream("Valorant Ranked Grind - Road to Radiant! 🎮");

        // Mike unfollows Bob
        bob.removeObserver(mike);

        bob.createPost("GG everyone! Almost reached Radiant rank!");
        bob.endLiveStream();

        // ========== VIEWING NOTIFICATIONS ==========
        System.out.println("\n>>> CHECKING NOTIFICATIONS <<<");
        john.viewNotifications();
        sarah.enableNotifications(); // Re-enable notifications
        sarah.viewNotifications();

        // ========== SERVICE STATISTICS ==========
        System.out.println("\n>>> SERVICE STATISTICS <<<");
        instagram.showStats();
        tiktok.showStats();
        emailService.processEmailQueue();

        System.out.println("\n=== DEMO COMPLETED ===");
    }
}