import filesystem.File;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {

    public List<File> search(final File root, FileSearchCriteria fileSearchCriteria) {


        final List<File> list = new ArrayList<>();
        final ArrayDeque<File> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            File node = stack.pop();

            if (fileSearchCriteria.isMatch(node)) {
                list.add(node);
            }

            for (File entry : node.getEntries()) {
                stack.add(entry);
            }
        }
        return list;
    }
}
