import java.io.File;

public class Bioskop_main {
    public static void main (String[] args){
        Bioskop bioskop = new Bioskop();

        Film film1 = new Film("Nosferatu", "Horror", 2.12);
        Film film2 = new Film("1 Mahasiswa 7 Matkul", "Horror", 3.0);

        bioskop.Tambahfilm(film1);
        bioskop.Tambahfilm(film2);

        Ticket ticket1 = new Ticket(film1, "19.30", 50_000);
        Ticket ticket2 = new Ticket(film2, "20.00", 45_000);

        bioskop.TambahTicket(ticket1);
        bioskop.TambahTicket(ticket2);

        bioskop.TampilkanDaftarFilm();
        bioskop.TampilkanDaftarTicket();

        Pelanggan pelanggan = new Pelanggan("Zaidan", "Zaidanganteng123@gmail.com");

        bioskop.BuatPemesanan(pelanggan, ticket1, 2);
        bioskop.tampilkanDaftarPemesanan();
    }
}
