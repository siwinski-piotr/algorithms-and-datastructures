import filesystem.File;
import filesystem.FileAttribute;
import operator.EqualsOperator;
import operator.GreaterThanOperator;
import predicate.AndPredicate;
import predicate.SimplePredicate;

import java.util.List;

public class Program {

    public static void main(String[] args) {
        System.out.println("\n=== Testing File Search System ===");

        System.out.println("\n--- Creating File System Structure ---");
        final File root = new File(true, 0, "adam", "root");
        final File a = new File(false, 2000, "adam", "a");
        final File b = new File(false, 3000, "george", "b");
        System.out.println("✓ Created root directory: 'root' (owner: adam, size: 0)");
        System.out.println("✓ Created file 'a': (owner: adam, size: 2000, isDirectory: false)");
        System.out.println("✓ Created file 'b': (owner: george, size: 3000, isDirectory: false)");

        root.addEntry(a);
        root.addEntry(b);
        System.out.println("✓ Added files 'a' and 'b' to root directory");

        System.out.println("\n--- Building Search Criteria ---");
        System.out.println("✓ Creating simple predicate with one condition:");
        System.out.println("  1. Owner name must be equal to 'adam'");

        var searchCriteria = new FileSearchCriteria(
                new SimplePredicate<>(
                        FileAttribute.OWNER,
                        new EqualsOperator<>(),
                        "a"
                )
        );

        System.out.println("✓ Search criteria created successfully");

        System.out.println("\n--- Executing File Search ---");
        final FileSearch fileSearch = new FileSearch();
        final List<File> result = fileSearch.search(root, searchCriteria);

        System.out.println("✓ Search completed");
        System.out.println("✓ Found " + result.size() + " file(s) matching criteria");


        System.out.println("\n--- Building Another Search Criteria ---");
        System.out.println("✓ Creating AND predicate with two conditions:");
        System.out.println("  1. File must NOT be a directory (isDirectory = false)");
        System.out.println("  2. File size must be greater than '1000' ");


        var criteria = new FileSearchCriteria(
                new AndPredicate(List.of(
                        new SimplePredicate<>(FileAttribute.IS_DIRECTORY, new EqualsOperator<>(), false),
                        new SimplePredicate<>(FileAttribute.SIZE, new GreaterThanOperator<>(), 1000)
                )));
        List<File> search = fileSearch.search(root, criteria);

        System.out.println("  Expected result is 2. Actual: " + search.size());
        assert search.size() == 2;


    }
}
