package sk.itvkurze.Lekcia_19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class LibraryAppHelper {
    public static boolean searchInFile(String filePath, String searchedText) {
        Path path = Paths.get(filePath);

        try {
            Stream<String> lines = Files.lines(path);
            List<String> lineList = lines.toList();

            for (String line : lineList)
                if (line.contains(searchedText)) {
                    return true;
                }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return false;
    }
}
