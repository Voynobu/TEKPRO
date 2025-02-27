import java.util.ArrayList;

public class Bioskop {
    private final ArrayList<Film> films;
    private final ArrayList<Ticket> tickets;
    private final ArrayList<Pemesanan> daftar_pemesanan;

    public Bioskop() {
        films = new ArrayList<>();
        tickets = new ArrayList<>();
        daftar_pemesanan = new ArrayList<>();
    }

    public void Tambahfilm(Film film) {
        films.add(film);
    }

    public void TambahTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void TampilkanDaftarFilm() {
        System.out.println("Daftar Film: ");
        for (Film film : films) {
            System.out.println("- " + film.getJudul_film() + "(" + film.getGenre() + ")" + ", Durasi: " + film.getDurasi() + "jam");
        }
    }

    public void TampilkanDaftarTicket() {
        System.out.println("Daftar Ticket Tersedia: ");
        for (Ticket ticket : tickets) {
            System.out.println("- " + ticket.getFilm() + ", Jadwal: " + ticket.getJadwal() + ", Harga: Rp. " + ticket.getHarga());
        }
    }

    public void BuatPemesanan(Pelanggan pelanggan, Ticket ticket, int jumlah) {
        Pemesanan pemesanan = new Pemesanan(ticket, pelanggan, jumlah);
        daftar_pemesanan.add(pemesanan);
        System.out.println("Pemesanan berhasil dibuat.");
    }

    public void tampilkanDaftarPemesanan() {
        System.out.println("Daftar Pemesanan:");
        for (Pemesanan pemesanan : daftar_pemesanan) {
            System.out.println("- Pelanggan: " + pemesanan.getPelanggan().getNama() +
                    ", Film: " + pemesanan.getTiket().getFilm().getClass() +
                    ", Jadwal: " + pemesanan.getTiket().getJadwal() +
                    ", Jumlah: " + pemesanan.getJumlah() +
                    ", Total Harga: Rp " + pemesanan.TotalHarga());
        }

    }
}

    class Film {
        private final String judul_film;
        private final String Genre;
        private final double Durasi;

        public Film(String judulFilm, String genre, double durasi) {
            this.judul_film = judulFilm;
            this.Genre = genre;
            this.Durasi = durasi;
        }

        public String getJudul_film() {
            return judul_film;
        }

        public String getGenre() {
            return Genre;
        }

        public double getDurasi() {
            return Durasi;
        }
    }

    class Ticket {
        private final Film judulFilm;
        private final String Jadwal;
        private final double Harga;

        public Ticket(Film film, String jadwal, double harga) {
            this.judulFilm = film;
            this.Harga = harga;
            this.Jadwal = jadwal;
        }

        public String getFilm() {
            return judulFilm.getJudul_film();
        }

        public double getHarga() {
            return Harga;
        }

        public String getJadwal() {
            return Jadwal;
        }
    }

    class Pelanggan {
        private final String nama;
        private final String email;

        public Pelanggan(String nama, String email) {
            this.email = email;
            this.nama = nama;
        }

        public String getEmail() {
            return email;
        }

        public String getNama() {
            return nama;
        }
    }

    class Pemesanan {
        private final Ticket tiket;
        private final Pelanggan pelanggan;
        private final int jumlah;

        public Pemesanan(Ticket tiket, Pelanggan pelanggan, int jumlah) {
            this.tiket = tiket;
            this.pelanggan = pelanggan;
            this.jumlah = jumlah;
        }

        public Pelanggan getPelanggan() {
            return pelanggan;
        }

        public Ticket getTiket() {
            return tiket;
        }

        public int getJumlah() {
            return jumlah;
        }

        public double TotalHarga() {
            return jumlah * tiket.getHarga();
        }

    }
