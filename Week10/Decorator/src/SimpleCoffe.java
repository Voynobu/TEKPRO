package Week10.Decorator.src;
public class SimpleCoffe implements Coffee{
    @Override
    public String getDescription() {
        return "Kopi sederhana";
    }

    @Override
    public double getCost() {
        return 15000; // Harga dasar kopi Rp 15.000
    }
}
