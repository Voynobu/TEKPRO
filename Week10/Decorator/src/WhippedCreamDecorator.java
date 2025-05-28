package Week10.Decorator.src;
public class WhippedCreamDecorator extends CoffeeDecorator{
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + Whipped Cream";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 5000; // Tambah whipped cream Rp 5.000
    }
}
