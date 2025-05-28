package Week10.Observer.src;
public interface Observer {
    void update(String event, String data);
    String getName();
}