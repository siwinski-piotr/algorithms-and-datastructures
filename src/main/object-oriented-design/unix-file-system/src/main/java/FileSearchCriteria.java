import filesystem.File;
import predicate.Predicate;

/*
Criteria takes predicate.
Predicate takes attribute, expected value and operator (equals, greater than etc)

 */
public class FileSearchCriteria {

    private final Predicate predicate;

    public FileSearchCriteria(Predicate predicate) {
        this.predicate = predicate;
    }

    public boolean isMatch(File inputFile) {
        return predicate.isMatch(inputFile);
    }
}
