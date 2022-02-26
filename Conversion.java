import java.io.*;
import java.util.*;

public class Conversion {
    static int result = 0;
    static int loop = 0;

    public static String value;

    public static void main(String args[]) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your data");
        value = reader.readLine();

        boolean isNumeric =  value.matches("[+-]?\\d*(\\.\\d+)?");

        if (isNumeric == true) {
            System.out.println("Your data is Number");
            System.out.println("Converting it to Roman Numerals..");
            String result = integerToRoman(Integer.parseInt(value));
            System.out.println(result);
        } else {
            System.out.println("Your data is Roman Numerals");
            System.out.println("Converting it to Numbers..");
            int result = romanToInteger(value);
            System.out.println(result);
        }
    }

    public static int romanToInteger(String roman) {
        Map <Character,Integer> numbersMap = new HashMap<>();
        
        numbersMap.put('I',1);
        numbersMap.put('V',5);
        numbersMap.put('X',10);
        numbersMap.put('L',50);
        numbersMap.put('C',100);   
        numbersMap.put('D',500);
        numbersMap.put('M',1000);  

       for (loop = 0; loop < roman.length(); loop++) {
            char ch = roman.charAt(loop);
        if (loop > 0 && numbersMap.get(ch) > numbersMap.get(roman.charAt(loop-1))) {
            result += numbersMap.get(ch) - 2 * numbersMap.get(roman.charAt(loop-1));
         } else
            result += numbersMap.get(ch);
       }

       return result;
    }

    public static String integerToRoman(int number) {
        TreeMap <Integer, String> numbersMap = new TreeMap <Integer, String>();

        numbersMap.put(1000, "M");
        numbersMap.put(900, "CM");
        numbersMap.put(500, "D");
        numbersMap.put(400, "CD");
        numbersMap.put(100, "C");
        numbersMap.put(90, "XC");
        numbersMap.put(50, "L");
        numbersMap.put(40, "XL");
        numbersMap.put(10, "X");
        numbersMap.put(9, "IX");
        numbersMap.put(5, "V");
        numbersMap.put(4, "IV");
        numbersMap.put(1, "I");

        int value = numbersMap.floorKey(number);

        if (number == value) {
            return numbersMap.get(number);

        }
        return numbersMap.get(value) + integerToRoman(number - value);
    }
    
}

