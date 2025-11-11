package filesystem;

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

    // Extracts the value of a specified file attribute
    public Object extract(final FileAttribute attributeName) {
        switch (attributeName) {
            case SIZE -> {
                return size;
            }
            case OWNER -> {
                return owner;
            }
            case IS_DIRECTORY -> {
                return isDirectory;
            }
            case FILENAME -> {
                return fileName;
            }
        }
        throw new IllegalArgumentException("invalid filter criteria type");
    }
}
