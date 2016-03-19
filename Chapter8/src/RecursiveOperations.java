import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecursiveOperations {
    public static void delete(Path source) throws IOException {
        if (Files.isDirectory(source)) {
            for (Path file : getFiles(source)) {
                delete(file);
            }
        }
    }

    public static List<Path> getFiles(Path dir) {
        // gets all files, but puts directories first
        List<Path> files = new ArrayList<>();
        if (!Files.isDirectory(dir)) {
            return files;
        }

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    files.add(entry);
                }
            }
        } catch (IOException | DirectoryIteratorException x) {

        }

        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                if (!Files.isDirectory(entry)) {
                    files.add(entry);
                }
            }
        } catch (IOException | DirectoryIteratorException x) {

        }

        return files;
    }

    public static void copy(Path source, Path target) throws IOException {
        if (Files.exists(target) && Files.isSameFile(source, target)) {
            return;
        }

        if (Files.isDirectory(source)) {
            Files.createDirectory(target);
            System.out.println("CREATED " + target.toString());
            for (Path file : getFiles(source)) {
                copy(file, target.resolve(file.getFileName()));
            }
        } else {
            Files.copy(source, target);
            System.out.println("COPIED " + source.toString()
                + " -> " + target.toString());
        }
    }

    public static void move(Path source, Path target) throws IOException {
        if (Files.exists(target) && Files.isSameFile(source, target)) {
            return;
        }

        copy(source, target);
        delete(source);
    }

    public static Set<Path> search(Path start, String glob,
                                   boolean includeDirectories,
                                   boolean includeFiles) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
        Set<Path> results = new HashSet<>();
        search(start, matcher, includeDirectories, includeFiles, results);
        return results;
    }

    private static void search(Path path, PathMatcher matcher,
                               boolean includeDirectories,
                               boolean includeFiles, Set<Path> results) {
        if (matcher.matches(path.getFileName())
                && ((includeDirectories && Files.isDirectory(path))
                    || (includeFiles && !Files.isDirectory(path)))) {
            results.add(path);
        }

        for (Path next : getFiles(path)) {
            search(next, matcher, includeDirectories, includeFiles, results);
        }
    }

    public static void main(String[] args) throws IOException {
        // warning: take care when testing these function on
        // exists folders on your system

        // set up test directory
        try {
            delete(Paths.get("C:\\javatest"));
            delete(Paths.get("C:\\javatest2"));
        } catch (NoSuchFileException e) {

        }

        Files.createDirectory(Paths.get("C:\\javatest"));
        Files.createDirectory(Paths.get("C:\\javatest\\subdir\\"));
        Files.createFile(Paths.get("C:\\javatest\\text1.txt"));
        Files.createFile(Paths.get("C:\\javatest\\text2.txt"));
        Files.createFile(Paths.get("C:\\javatest\\other.txt"));
        Files.createFile(Paths.get("C:\\javatest\\subdir\\text3.txt"));
        Files.createFile(Paths.get("C:\\javatest\\subdir\\other.txt"));

        // Test our methods
        copy(Paths.get("C:\\javatest\\subdir"), Paths.get("C:\\javatest\\subdircopy\\"));;
        System.out.println(search(Paths.get("C:\\javatest"),
                "text*.txt", true, true));
        move(Paths.get("C:\\javatest\\subdircopy\\"),
                Paths.get("C:\\javatest\\subdircopy2\\"));
        System.out.println(search(Paths.get("C:\\javatest\\"),
                "text*.txt", true, true));
        copy(Paths.get("C:\\javatest\\"), Paths.get("C:\\javatest2\\"));
    }
}
