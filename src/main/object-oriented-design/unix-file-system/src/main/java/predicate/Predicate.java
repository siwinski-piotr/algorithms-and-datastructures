package predicate;

import filesystem.File;

public interface Predicate {
    boolean isMatch(File inputFile);
}
