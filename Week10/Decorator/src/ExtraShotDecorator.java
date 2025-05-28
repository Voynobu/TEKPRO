package Week10.Decorator.src;
public class ExtraShotDecorator extends CoffeeDecorator{
    public ExtraShotDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Extra Shot";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 8000; // Tambah extra shot Rp 8.000
    }
}
