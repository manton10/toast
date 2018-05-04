package code.clients;

import java.io.IOException;

public interface IClientsList {
    IClient getCustomerByName(String name);
    void writeToFile(String FileName) throws IOException;
}
