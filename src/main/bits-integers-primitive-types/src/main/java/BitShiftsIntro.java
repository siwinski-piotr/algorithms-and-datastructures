public class BitShiftsIntro {
    public static void main(String[] args) {
        int number = 14;

        System.out.println("Left shift << 1 acts as multiplication times 2");
        System.out.println("14 << 1");
        System.out.println(number << 1);
        System.out.println();
        System.out.println("14 << 2 = 56");
        System.out.println(number << 2);

        System.out.println("14 in binary: " + Integer.toBinaryString(14));
        System.out.println("56 in binary: " + Integer.toBinaryString(56));

        System.out.println("----------");
        System.out.println("Right shift is division by 2 rounded down to integer");

        System.out.println("56 >> 1 = 28");
        System.out.println(56 >> 1);

        System.out.println("9 >> 1 = 4");
        System.out.println(9 >> 1);

        System.out.println("56 >> 2 = 14");
        System.out.println(56 >> 2);


        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Check k bit");

        System.out.println("Read first bit of number");
        System.out.println("7 & 1");
        number = 7 & 1;
        System.out.println(number);

        System.out.println("Read third bit of number");
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toBinaryString(1 << 3));
        number = 15 & (1 << 3);
        System.out.println(number); // this will return 8
        // 1111 and
        // 1000
        // 1000 = 8
        // one solution
        int bit = (15 & (1 << 3)) != 0 ? 1 : 0;
        System.out.println(bit);

        int x = 13;      // 1101
        int k = 2;
        bit = (x >> k) & 1;
        System.out.println(bit); // 1


        System.out.println();
        System.out.println("--------------------------");
        System.out.println("Set k bit to 1");

        System.out.println("0 | (1 << 2)");
        number = 0 | (1 << 2);
        System.out.println(number + ", binary: " + Integer.toBinaryString(number));



    }
}
