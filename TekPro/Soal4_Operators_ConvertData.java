//Nama: Zaidan Zulkaisi Setiaji
//NIM: 241524031
//Kelas: D4-1A

public class Soal4_Operators_ConvertData {

    static short methodOne(long l)
    {
        int i = (int) l;
        return (short)i;
    }

    public static void main(String[] args)
    {
        double d = 10.25;
        float f = (float) d;
        byte b = (byte) methodOne((long) f);
        System.out.println(b);
    }
}
