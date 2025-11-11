package predicate;

import filesystem.File;

import java.util.List;

public class NotPredicate implements Predicate {

    private final Predicate predicate;

    public NotPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean isMatch(File inputFile) {
        return !predicate.isMatch(inputFile);
    }
}
