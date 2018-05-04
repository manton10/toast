package code.clients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AClientList implements IClientsList {

    private Map<String, IClient> clients = new LinkedHashMap<>();

    public AClientList() {}

    protected void addClient(IClient newClient) {
        clients.put(newClient.getName(), newClient);
    }

    @Override
    public IClient getCustomerByName(String name) {
        return clients.get(name);
    }


    public void writeToFile(String FileName) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, IClient> client : clients.entrySet()) {
            stringBuffer.append(client.getValue().toString());
            stringBuffer.append("\r\n");
        }
        try(FileOutputStream fos=new FileOutputStream(FileName))
        {
            byte[] buffer = stringBuffer.toString().getBytes();
            fos.write(buffer, 0, buffer.length);
        }
    }

}
