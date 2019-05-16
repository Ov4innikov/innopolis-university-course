package part1.lesson10.task01.service;

import part1.lesson10.task01.model.Connection;
import part1.lesson10.task01.model.ConnectionMode;

import java.time.Instant;
import java.util.concurrent.ConcurrentMap;

public class ConnectionService implements Runnable {

    private ConcurrentMap<String, Connection> connectionMap;
    private ConcurrentMap<String, Instant> instantMap;


    @Override
    public void run() {

    }
}
