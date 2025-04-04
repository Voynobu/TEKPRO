// ****************************************************************
// ParseInts.java
//
// Reads a line of text and prints the integers in the line.
//
// ****************************************************************
import java.util.Scanner;
public class ParseInt{
    public static void main(String[] args){
        int val, sum=0;
        Scanner scan = new Scanner(System.in);
        String line;
        System.out.println("Enter a line of text");
        Scanner scanLine = new Scanner(scan.nextLine());
        while (scanLine.hasNext()){
            try {
                val = Integer.parseInt(scanLine.next());
                sum += val;
            } catch (NumberFormatException e) {
                //exception tidak melakukan apa apa dan melanjutkan loop
            }
        }
        System.out.println("The sum of the integers on this line is " + sum);
    }
}

