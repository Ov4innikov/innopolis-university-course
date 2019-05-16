package part1.lesson10.task01.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.Instant;
import java.util.Map;

public class Connection implements Runnable {

    private String user;
    private Map<String, Socket> socketMap;
    private Map<String, Instant> instantMap;
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;
    private ConnectionMode connectionMode = ConnectionMode.BROADCAST;

    public Connection(Map<String, Instant> instantMap, Socket clientSocket) {
        this.socketMap = socketMap;
        this.instantMap = instantMap;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        //считывание имени и его регистрация


        //цикл получения от клиента сообщений
        while (connectionMode != ConnectionMode.STOP) {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String s = in.readLine();
                if (s != null) {
                    if (s.equals("broadcast\n")) {
                        connectionMode = ConnectionMode.BROADCAST;
                        continue;
                    } else if (s.equals("unicast\n")) {
                        connectionMode = ConnectionMode.UNICAST;
                        continue;
                    } else if (s.equals("stop\n")) {
                        connectionMode = ConnectionMode.STOP;
                        continue;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        connectionMode = ConnectionMode.STOP;
    }

    public Map<String, Socket> getSocketMap() {
        return socketMap;
    }

    public Map<String, Instant> getInstantMap() {
        return instantMap;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public BufferedReader getIn() {
        return in;
    }

    public BufferedWriter getOut() {
        return out;
    }

    public ConnectionMode getConnectionMode() {
        return connectionMode;
    }

    public String getUser() {
        return user;
    }
}
