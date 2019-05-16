package part1.lesson10.task01;

import part1.lesson10.task01.model.Connection;
import part1.lesson10.task01.service.MessageService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Класс реализующий сервер, который может работать в нескольких режимах:
 * unicast;
 * broadcast.
 * Комманды воспринимаемые сервером:
 * unicast - переход в режим личных сообщений, формат сообщений(имя_пользователя_без_пробелов:текст сообщения);
 * broadcast - переход в режим массовых сообщений;
 * stop - остановка сессии, так же останавливается при бездействии определенное время;
 *
 * @author Овчинников Евгений
 */
public class ServerChat implements AutoCloseable {

    private ServerSocket serverSocket;
    private Socket socket;
    private ConcurrentMap<String, Connection> connectionMap;
    private ExecutorService executorService;
    private ConcurrentMap<String, Instant> instantMap;
    private MessageService messageService;

    public ServerChat() throws IOException {
        serverSocket = new ServerSocket(9999);
        connectionMap = new ConcurrentHashMap<String, Connection>();
        executorService = Executors.newFixedThreadPool(100);
        instantMap = new ConcurrentHashMap<String, Instant>();
        messageService = new MessageService();
    }

    /**
     * Метод для запуска сервера.
     */
    public void start() throws IOException {
        try {
            while (true) {
                socket = serverSocket.accept();
                Connection connection = new Connection(instantMap, socket);
                executorService.execute(connection);
            }
        } finally {
            try {
                close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopConnection(Connection connection) throws IOException {
        connection.getClientSocket().close();

    }

    @Override
    public void close() throws Exception {
        serverSocket.close();
        Iterator iterator = connectionMap.values().iterator();
        while (iterator.hasNext()) {
            ((Connection) iterator.next()).getClientSocket().close();
        }
        executorService.shutdown();
    }
}
