// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils{
    //-------------------------------------------------------------
// Returns the factorial of the argument given
//-------------------------------------------------------------
    public static int factorial(int n){
        //Mengecek input user apakah diantara 0 dan 16
        if (n <0){
            throw new IllegalArgumentException("Faktorial tidak dapat mengdefinisi bilangan negatif");
        } //Memberitahu user bahwa nilai negatif tidak dapat diproses dengan baik oleh program

        if(n>16) {
           throw new IllegalArgumentException("Faktorial diatas nilai 16 tidak dapat didefinisi");
        } //Memberitahu user bahwa nilai diatas 16 tidak dapat diproses dengan baik oleh program
        int fac = 1;
        for (int i=n; i>0; i--)
            fac *= i;
        return fac;
    }
}