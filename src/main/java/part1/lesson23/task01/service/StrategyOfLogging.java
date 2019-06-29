package part1.lesson23.task01.service;

import org.apache.logging.log4j.Logger;

public abstract class StrategyOfLogging {

    public abstract void log(Logger logger, String msg);
}
