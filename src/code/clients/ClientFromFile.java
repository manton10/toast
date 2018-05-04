package code.clients;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ClientFromFile extends AClientList {

    public ClientFromFile(String fileNameClients) throws IOException {
        super();
        try (Stream<String> stream = Files.lines(Paths.get(fileNameClients))) {
            stream.forEach(item -> this.addClient(new Client(item)));
        }
    }

}
