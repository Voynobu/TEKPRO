//Nama: Zaidan Zulkaisi Setiaji
//NIM: 241524031
//Kelas: D4-1A
import java.util.Scanner;//Digunakan agar dapat menerima input

public class Soal1_DataTypes {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        int i = 0;

        while (i<T){
            try {
                boolean valid = false;
                long n = scn.nextLong();

                System.out.println(n + " can be fitted in: ");
                if (n <= Byte.MAX_VALUE && n >= Byte.MIN_VALUE) {
                    System.out.println("* byte");
                    valid = true;
                }
                if (n <= Short.MAX_VALUE && n >= Short.MIN_VALUE) {
                    System.out.println("* short");
                    valid = true;
                }
                if (n <= Integer.MAX_VALUE && n >= Integer.MIN_VALUE) {
                    System.out.println("* int");
                    valid = true;
                }
                if (n <= Long.MAX_VALUE && n >= Long.MIN_VALUE) {
                    System.out.println("* long");
                    valid = true;
                }
                if (!valid) {
                    System.out.println(n + "can’t be fitted anywhere");
                }
            } catch (Exception e) { 
                System.out.println(scn.next() + " can't be fitted anywhere.");
            }
            i = i + 1;
        }
    }
}

