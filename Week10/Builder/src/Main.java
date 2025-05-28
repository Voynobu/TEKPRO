package Week10.Builder.src;

// Product class
class Pizza {
    private String size;
    private String crust;
    private String sauce;
    private String cheese;
    private java.util.List<String> toppings;
    private boolean extraCheese;
    private boolean stuffedCrust;
    private double price;

    // Private constructor - only builder can create Pizza
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
        this.extraCheese = builder.extraCheese;
        this.stuffedCrust = builder.stuffedCrust;
        this.price = calculatePrice();
    }

    private double calculatePrice() {
        double basePrice = size.equals("Large") ? 15.99 : size.equals("Medium") ? 12.99 : 9.99;
        basePrice += toppings.size() * 1.50;
        if (extraCheese) basePrice += 2.00;
        if (stuffedCrust) basePrice += 3.00;
        return basePrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PIZZA ORDER ===\n");
        sb.append("Size: ").append(size).append("\n");
        sb.append("Crust: ").append(crust).append("\n");
        sb.append("Sauce: ").append(sauce).append("\n");
        sb.append("Cheese: ").append(cheese).append("\n");
        if (!toppings.isEmpty()) {
            sb.append("Toppings: ").append(String.join(", ", toppings)).append("\n");
        }
        if (extraCheese) sb.append("Extra Cheese: Yes\n");
        if (stuffedCrust) sb.append("Stuffed Crust: Yes\n");
        sb.append("Total Price: $").append(String.format("%.2f", price));
        return sb.toString();
    }

    // Static nested Builder class
    public static class PizzaBuilder {
        // Required parameters
        private String size;
        private String crust;

        // Optional parameters with default values
        private String sauce = "Tomato";
        private String cheese = "Mozzarella";
        private java.util.List<String> toppings = new java.util.ArrayList<>();
        private boolean extraCheese = false;
        private boolean stuffedCrust = false;

        // Constructor with required parameters
        public PizzaBuilder(String size, String crust) {
            this.size = size;
            this.crust = crust;
        }

        // Methods for optional parameters - return builder for chaining
        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder cheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public PizzaBuilder extraCheese() {
            this.extraCheese = true;
            return this;
        }

        public PizzaBuilder stuffedCrust() {
            this.stuffedCrust = true;
            return this;
        }

        // Build method creates and returns the Pizza
        public Pizza build() {
            return new Pizza(this);
        }
    }
}

// Service class to handle pizza operations
class PizzaService {

    public Pizza createBasicPizza() {
        return new Pizza.PizzaBuilder("Medium", "Thin Crust")
                .build();
    }

    public Pizza createVegetarianPizza() {
        return new Pizza.PizzaBuilder("Large", "Thick Crust")
                .sauce("Pesto")
                .cheese("Parmesan")
                .addTopping("Mushrooms")
                .addTopping("Bell Peppers")
                .addTopping("Olives")
                .extraCheese()
                .build();
    }

    public Pizza createMeatLoversPizza() {
        return new Pizza.PizzaBuilder("Large", "Hand Tossed")
                .sauce("BBQ")
                .addTopping("Pepperoni")
                .addTopping("Sausage")
                .addTopping("Bacon")
                .addTopping("Ham")
                .extraCheese()
                .stuffedCrust()
                .build();
    }

    public Pizza createKidsPizza() {
        return new Pizza.PizzaBuilder("Small", "Thin Crust")
                .addTopping("Pepperoni")
                .build();
    }

    public void displayPizza(Pizza pizza) {
        System.out.println(pizza);
        System.out.println();
    }
}

// Order management class
class PizzaOrderManager {
    private PizzaService pizzaService;

    public PizzaOrderManager() {
        this.pizzaService = new PizzaService();
    }

    public void processOrders() {
        System.out.println("=== PIZZA PALACE ORDERING SYSTEM ===\n");

        // Process different pizza orders
        Pizza basicPizza = pizzaService.createBasicPizza();
        pizzaService.displayPizza(basicPizza);

        Pizza vegetarianPizza = pizzaService.createVegetarianPizza();
        pizzaService.displayPizza(vegetarianPizza);

        Pizza meatLoversPizza = pizzaService.createMeatLoversPizza();
        pizzaService.displayPizza(meatLoversPizza);

        Pizza kidsPizza = pizzaService.createKidsPizza();
        pizzaService.displayPizza(kidsPizza);
    }

    public Pizza createCustomPizza(String size, String crust) {
        return new Pizza.PizzaBuilder(size, crust).build();
    }
}

// Client code - Pizza ordering application
public class Main {
    public static void main(String[] args) {
        PizzaOrderManager orderManager = new PizzaOrderManager();
        orderManager.processOrders();

        // Example of custom pizza creation
        Pizza customPizza = orderManager.createCustomPizza("Medium", "Stuffed Crust");
        System.out.println("Custom Order:");
        System.out.println(customPizza);
    }
}