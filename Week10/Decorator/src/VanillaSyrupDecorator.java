package Week10.Decorator.src;
public class VanillaSyrupDecorator extends CoffeeDecorator{
    public VanillaSyrupDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Sirup Vanilla";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 4000; // Tambah sirup vanilla Rp 4.000
    }
}
