import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantFix {
    private MenuManager menuManager;

    public RestaurantFix(){
        menuManager = new MenuManager();
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        menuManager.tambahMenuMakanan(nama, harga, stok);
    }

    public void tampilMenuMakanan() {
        menuManager.tampilMenuMakanan();
    }

    public void pesanMakanan(){
        menuManager.PesanMakanan();
    }

}

class Menu{
    private final String nama_makanan;
    private final double harga_makanan;
    private int stok;

    public Menu(String nama, double harga, int stok){
        this.nama_makanan = nama;
        this.harga_makanan = harga;
        this.stok = stok;
    }

    public String getNama_makanan(){
        return nama_makanan;
    }

    public double getHarga_makanan() {
        return harga_makanan;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}

class MenuManager{
    private ArrayList<Menu> menu;
    public MenuManager(){
        menu = new ArrayList<>();
    }

    public void tambahMenuMakanan(String nama,double harga, int stok){
        menu.add(new Menu(nama, harga, stok));
    }

    public void tampilMenuMakanan(){
        int i = 1;
        for(Menu makanan : menu){
            if(!isOutOfStock(makanan)){
                System.out.println(i+ ". " + makanan.getNama_makanan() + "[" + makanan.getStok() + "]" + "\tRp. " + makanan.getHarga_makanan());
                i++;
            }
        }
    }

    private boolean isOutOfStock(Menu makanan) {
        return makanan.getStok() == 0;
    }

    public void PesanMakanan() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            tampilMenuMakanan();
            System.out.println("Pilih nomor makanan (Ketik 0 jika ingin keluar): ");
            int pilihan = scanner.nextInt();

            if (pilihan == 0) {
                System.out.println("Terima kasih telah memesan!");
                break;
            }
            if (pilihan < 1 || pilihan > menu.size()) {
                System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
                continue;
            }

            Menu makanan = menu.get(pilihan - 1);
            if (isOutOfStock(makanan)) {
                System.out.println("Maaf, stok " + makanan.getNama_makanan() + "habis.");
                continue;
            }

            System.out.println("Masukkan jumlah yang ingin dipesan: ");
            int jumlah = scanner.nextInt();

            if (jumlah <= 0) {
                System.out.println("Jumlah tidak valid. Silahkan coba lagi.");
                continue;
            }
            if (jumlah > makanan.getStok()) {
                System.out.println("Maaf, jumlah stok " + makanan.getNama_makanan() + " tidak mencukupi.");
                continue;
            }

            makanan.setStok(makanan.getStok() - jumlah);
            System.out.println("Anda telah memesan " + jumlah + " " + makanan.getNama_makanan() + ".");
            System.out.println("Stok tersisa: " + makanan.getStok());
        }
    }
}