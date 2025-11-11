package predicate;

import java.util.List;

import filesystem.File;

public class AndPredicate implements Predicate {

    private final List<Predicate> operands;

    public AndPredicate(List<Predicate> operands) {
        this.operands = operands;
    }

    @Override
    public boolean isMatch(File inputFile) {
        return operands.stream().allMatch(it -> it.isMatch(inputFile));
    }
}
