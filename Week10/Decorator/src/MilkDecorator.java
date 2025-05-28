package Week10.Decorator.src;
public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Susu";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 3000; // Tambah susu Rp 3.000
    }
}
