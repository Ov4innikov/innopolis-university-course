package part1.lesson10.task01;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        ServerChat serverChat = new ServerChat();
        serverChat.start();
    }
}
