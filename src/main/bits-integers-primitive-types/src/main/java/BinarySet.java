public class BinarySet {

    private static int addToSet(int set, char element) {
        set |= (1 << element - 'a');
        return set;
    }

    private static void printSet(int set) {
        for (int i = 0; i < 32; i++) {
            int currentBit = (set & (1 << i)); // read bit from position i
            if (currentBit > 0) { // check if 1 then element is present
                System.out.println((char) ('a' + i));
            }
        }
    }

    private static int removeFromSet(int set, char element) {
        set = set & ~(1 << element - 'a');
        return set;
    }

    public static void main(String[] args) {
        int set = 0;

        System.out.println("Adding a, b, z to set:");
        // add letter 'a' - index 0
//        set |= (1 << element - 'a');
        set = addToSet(set, 'a');

        // add letter 'b' - index
        set |= 1 << 'b' - 'a';

        // dodaj literę 'z'
        set = set | 1 << 'z' - 'a';

        System.out.println(Integer.toBinaryString(set));
        System.out.println();
        // 10000000000000000000000011

        // print all elements of set
        System.out.println("Print all elements of set:");
        printSet(set);

        // print size of set

        System.out.println("Size of set: " + Integer.bitCount(set));

        // remove element from set
        System.out.println("Remove 'b' from set");
        // remove b
        // flip 1st bit to 0
        set = set & ~(1 << 'b' - 'a');


        //
        System.out.println();
        System.out.println(Integer.toBinaryString(set));
        // 10000000000000000000000001

        System.out.println("\nRemove 'a'");
        System.out.println(Integer.toBinaryString(set));
        set = removeFromSet(set, 'a');

        System.out.println("\nRemove 'z'");
        set = removeFromSet(set, 'z');


        System.out.println(Integer.toBinaryString(set));

        System.out.println();

        System.out.println("-------------------- SET OPERATIONS -----------");

        set = addToSet(set, 'a');
        set = addToSet(set, 'b');
        set = addToSet(set, 'p');
        set = addToSet(set, 'z');


        int setB = 63; // set with 1111 1111 -> set with a-f elements


        System.out.println("Union = a | b");
        int unionSet = set | setB;

        System.out.println("Result: ");
        printSet(unionSet);

    }
}
