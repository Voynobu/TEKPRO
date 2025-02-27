

public class Game{
    public static void main(String[] args) {
        GameInfo game1 = new GameInfo("Library of Ruina", "ProjectMoon",29.99);
        GameInfo game2 = new GameInfo("Lobotomy Corporation", "ProjectMoon", 24.99);
        GameInfo game3 = new GameInfo("Noita","Nolla Games",19.99);

        Steam steam = new Steam();
        steam.AddtoCart(game1, "Voynpbu");
        steam.AddtoCart(game2, "NoSalt");
        steam.AddtoCart(game3, "Jojo");

        game3.setHarga(7.99);
        System.out.println("\nSetelah diskon: ");
        steam.AddtoCart(game3, "Jojo");
    }
}

class GameInfo {
    private String judul;
    private String developer;
    private double harga;

    public GameInfo (String judul, String developer, double harga){
        this.judul = judul;
        this.developer = developer;
        this.harga = harga;
    }

    public String getJudul(){
        return judul;
    }

    public void setJudul() {
        this.judul = judul;
    }

    public String getDeveloper(){
        return developer;
    }

    public void setDeveloper(){
        this.developer = developer;
    }

    public double getHarga(){
        return harga;
    }

    public void setHarga(double harga){
        this.harga = harga;
    }

    public void TampilInformasi() {
        System.out.println("Judul :" + judul);
        System.out.println("Developer :" + developer);
        System.out.println("Harga : $" + harga);
    }
}

class Steam{
    public void AddtoCart(GameInfo game, String Username){
        System.out.println("\nGame telah dimasukkan ke dalam Cart: ");
        game.TampilInformasi();
        System.out.println("Pembeli :" + Username);
        System.out.println("Terimakasih telah menggunakan Steam");
    }
}
