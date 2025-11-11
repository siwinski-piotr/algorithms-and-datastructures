package predicate;

import filesystem.File;
import filesystem.FileAttribute;
import operator.ComparisonOperator;

public class SimplePredicate<T> implements Predicate {

    private final ComparisonOperator<T> operator;
    private final FileAttribute attribute;
    T expectedValue;

    public SimplePredicate(FileAttribute attribute, ComparisonOperator<T> operator, T expectedValue) {
        this.operator = operator;
        this.attribute = attribute;
        this.expectedValue = expectedValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isMatch(File inputFile) {
        Object actualValue = inputFile.extract(attribute);
        if (expectedValue.getClass().isInstance(actualValue)) {
            return operator.isMatch((T) actualValue, expectedValue);
        } else {
            return false;
        }
    }
}
