package Week10.Observer.src;
import java.util.ArrayList;
import java.util.List;

// Concrete Subject - User/Influencer yang bisa difollow
public class SocialMediaUser implements Subject {
    private String username;
    private List<Observer> followers;
    private String latestPost;
    private boolean isLive;

    public SocialMediaUser(String username) {
        this.username = username;
        this.followers = new ArrayList<>();
        this.isLive = false;
    }

    @Override
    public void addObserver(Observer observer) {
        followers.add(observer);
        System.out.println("✅ " + observer.getName() + " started following " + username);
    }

    @Override
    public void removeObserver(Observer observer) {
        followers.remove(observer);
        System.out.println("❌ " + observer.getName() + " unfollowed " + username);
    }

    @Override
    public void notifyObservers(String event, String data) {
        System.out.println("\n📢 Broadcasting to " + followers.size() + " followers...");
        for (Observer observer : followers) {
            observer.update(event, data);
        }
    }

    // Business methods yang trigger notifications
    public void createPost(String content) {
        this.latestPost = content;
        System.out.println("\n🎯 " + username + " posted: \"" + content + "\"");
        notifyObservers("NEW_POST", username + ": " + content);
    }

    public void startLiveStream(String title) {
        this.isLive = true;
        System.out.println("\n🔴 " + username + " started live stream: \"" + title + "\"");
        notifyObservers("LIVE_STREAM", username + " is live: " + title);
    }

    public void endLiveStream() {
        this.isLive = false;
        System.out.println("\n⚫ " + username + " ended live stream");
        notifyObservers("LIVE_ENDED", username + " has ended their live stream");
    }

    public void uploadStory(String storyContent) {
        System.out.println("\n📸 " + username + " uploaded a story: \"" + storyContent + "\"");
        notifyObservers("NEW_STORY", username + " story: " + storyContent);
    }

    public String getUsername() {
        return username;
    }
}