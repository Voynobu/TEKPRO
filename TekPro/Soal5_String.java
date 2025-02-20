//Nama: Zaidan Zulkaisi Setiaji
//NIM: 241524031
//Kelas: D4-1A

import java.util.Scanner;

public class Soal5_String {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String A = scan.nextLine();
        String B = scan.nextLine();
        int a = A.length();
        int b = B.length();
        int Total_lenght = a + b;
        System.out.println(Total_lenght);

        int Hasil_perbandingan = A.compareTo(B);
        if (Hasil_perbandingan < 0){
            System.out.println("False");
        } else {
            System.out.println("True");
        }

        char[] arr1 = A.toCharArray();
        char[] arr2 = B.toCharArray();
        arr1[0] = Character.toUpperCase(arr1[0]);
        arr2[0] = Character.toUpperCase(arr2[0]);
        String str = new String(arr1);
        String ing = new String(arr2);
        System.out.println(str+" "+ing);
    }
}
