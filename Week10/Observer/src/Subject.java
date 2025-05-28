package Week10.Observer.src;
// Subject interface - Kontrak untuk semua subject (yang bisa diobserve)
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String event, String data);
}