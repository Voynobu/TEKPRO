package Week10.Decorator.src;
public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Gula";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1000; // Tambah gula Rp 1.000
    }
}
