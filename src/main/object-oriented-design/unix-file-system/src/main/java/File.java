import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class File {
    private final boolean isDirectory;
    private final int size;
    private final String fileName;
    private final String owner;
    private Set<File> entries = new HashSet<>();

    public File(boolean isDirectory, int size, String fileName, String owner) {
        this.isDirectory = isDirectory;
        this.size = size;
        this.fileName = fileName;
        this.owner = owner;
    }

    public String getFileName() {
        return fileName;
    }

    public void addEntry(File file) {
        this.entries.add(file);
    }

    public Set<File> getEntries() {
        return Collections.unmodifiableSet(entries);
    }

}
