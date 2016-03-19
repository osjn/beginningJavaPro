import java.io.IOException;
import java.nio.file.*;

public class ShowDirectory {
    public static void main(String[] args) {
        Path folder = Paths.get("C:\\");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
            for (Path entry : stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println("An error occurred");
        }
    }
}
