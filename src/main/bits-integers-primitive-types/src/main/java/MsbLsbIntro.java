public class MsbLsbIntro {
    public static void main(String[] args) {


        int number = 5;
        System.out.println("Read Least Significant Bit (LSB)");

        System.out.println("Binary representation: " + Integer.toBinaryString(number));

        int lsb = number & 1;
        System.out.println("Least Significant Bit: " + lsb);

        System.out.println("------------------------------\n\n");
        System.out.println("Is even or odd?");
        System.out.println("LSB == 0 -> number is even: 4 & 1 = " + (4 & 1) + ", binary: " + Integer.toBinaryString(4));
        System.out.println("LSB == 1 -> number is odd: 5 & 1 = " + (5 & 1) + ", binary: " + Integer.toBinaryString(5));


        System.out.println("----------------------------\n\n");

        System.out.println("READ MSB - tells whether number is positive or negative");
        number = 127;
        System.out.println(Integer.toBinaryString(number));
        int msb = number >> 31 & 1;
        System.out.println("MSB of " + number + " is " + msb + "\n");


        number = -127;
        System.out.println(Integer.toBinaryString(number));
        msb = number >> 31 & 1;
        System.out.println("MSB of " + number + " is " + msb);


        System.out.println("----------------------------\n\n");
        System.out.println("NOT OPERATION");
        System.out.println("The not operation ~x produces a number where all the bits of x have been\n" +
                "inverted. The formula ~x = −x−1 holds, for example, ~29 = −30.");


        System.out.println("How to get opposite number?");
        System.out.println("Example number: " + 29);
        System.out.println("~29 is: " + (~29) );
        System.out.println("~29 + 1 is: -29. Result: " + (~29 + 1) );

        System.out.println("\nConvert from positive to negative");
        number = 29;
        System.out.println("Original: " + number);
        System.out.println("Reversed: "+ (~number + 1));


        System.out.println("\nHow to convert from negative number to positive?");
        number = -29;
        System.out.println("Original: " + number);
        System.out.println("Reversed: "+ (~number + 1));

        System.out.println("NOTE!!! You always negate and add one. In both scenarios! (~number + 1) " );
    }
}
