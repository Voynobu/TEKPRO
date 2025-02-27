import java.util.Scanner;

public class RestaurantMainFix {
    public static void main(String[] args){
        RestaurantFix menu = new RestaurantFix();
        menu.tambahMenuMakanan("Bala-bala", 1_000, 20);
        menu.tambahMenuMakanan("Gehu", 1_000, 20);
        menu.tambahMenuMakanan("Tahu", 1_000, 0);
        menu.tambahMenuMakanan("Molen", 1_000, 20);
        menu.tambahMenuMakanan("Bubur Memek", 15_000, 20);

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop == true){
            System.out.println("\n1. Tampilkan Menu");
            System.out.println("2. Pesan Makanan");
            System.out.println("3. Keluar");
            System.out.println("Pilih opsi: ");
            int opsi = scanner.nextInt();

            switch (opsi){
                case 1:
                    menu.tampilMenuMakanan();
                    break;

                case 2:
                    menu.pesanMakanan();
                    break;

                case 3:
                    loop = false;
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    break;
            }


        }
    }
}
