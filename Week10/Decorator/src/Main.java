package Week10.Decorator.src;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SELAMAT DATANG DI COFFEE SHOP ===\n");

        // Pesanan 1: Kopi sederhana
        Coffee coffee1 = new SimpleCoffe();
        System.out.println("Pesanan 1:");
        System.out.println("Deskripsi: " + coffee1.getDescription());
        System.out.println("Harga: Rp " + coffee1.getCost());
        System.out.println();

        // Pesanan 2: Kopi dengan susu dan gula
        Coffee coffee2 = new SimpleCoffe();
        coffee2 = new MilkDecorator(coffee2);
        coffee2 = new SugarDecorator(coffee2);
        System.out.println("Pesanan 2:");
        System.out.println("Deskripsi: " + coffee2.getDescription());
        System.out.println("Harga: Rp " + coffee2.getCost());
        System.out.println();

        // Pesanan 3: Kopi spesial dengan semua topping
        Coffee coffee3 = new SimpleCoffe();
        coffee3 = new MilkDecorator(coffee3);
        coffee3 = new SugarDecorator(coffee3);
        coffee3 = new WhippedCreamDecorator(coffee3);
        coffee3 = new VanillaSyrupDecorator(coffee3);
        coffee3 = new ExtraShotDecorator(coffee3);
        System.out.println("Pesanan 3 (Kopi Spesial):");
        System.out.println("Deskripsi: " + coffee3.getDescription());
        System.out.println("Harga: Rp " + coffee3.getCost());
        System.out.println();

        // Pesanan 4: Double milk coffee
        Coffee coffee4 = new SimpleCoffe();
        coffee4 = new MilkDecorator(coffee4);
        coffee4 = new MilkDecorator(coffee4); // Bisa menambah topping yang sama berkali-kali
        coffee4 = new SugarDecorator(coffee4);
        System.out.println("Pesanan 4 (Double Milk):");
        System.out.println("Deskripsi: " + coffee4.getDescription());
        System.out.println("Harga: Rp " + coffee4.getCost());
        System.out.println();

        System.out.println("=== TERIMA KASIH TELAH BERBELANJA ===");
    }
}