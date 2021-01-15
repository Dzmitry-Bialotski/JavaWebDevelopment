package by.belotskiy.composite.reader;

import by.belotskiy.composite.exception.ReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReader {
    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_PATH = "src/main/resources/data/default.txt";

    public String read(String path) throws ReaderException {
        if (path == null) {
            path = DEFAULT_PATH;
        }
        Path filePath = Paths.get(path);
        try {
            if (!(Files.exists(filePath) && Files.size(filePath) > 0)) {
                filePath = Paths.get(DEFAULT_PATH);
            }
        } catch (Exception e) {
            logger.log(Level.ERROR, e);
        }
        List<String> lines;
        try (Stream<String> lineStream = Files.lines(filePath)) {
            lines = lineStream.collect(Collectors.toList());
        } catch (Exception e) {
            logger.log(Level.ERROR, e);
            throw new ReaderException(e.getMessage());
        }
        StringBuilder text = new StringBuilder();
        for (String line : lines) {
            text.append(line);
        }
        return text.toString();
    }
}
