package part1.lesson10.task01.service;

import part1.lesson10.task01.model.Connection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.ConcurrentMap;

public class MessageService {

    private ConcurrentMap<String, Connection> connectionMap;

    public MessageService(ConcurrentMap<String, Connection> connectionMap) {
        this.connectionMap = connectionMap;
    }

    public void sendBroacastMessage(String message) {
        System.out.println("Send broadcast");
        connectionMap.entrySet().parallelStream().forEach(con -> {
            try {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(con.getValue().getClientSocket().getOutputStream()));
                out.write(message);
                out.newLine();
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void sendUnicastMessage(String name, String message) {
        System.out.println("Send message to " + name);
        Connection connection = connectionMap.get(name);
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getClientSocket().getOutputStream()));
            out.write(message);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
