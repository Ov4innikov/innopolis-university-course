package part1.lesson23.task01.service;

import org.apache.logging.log4j.Logger;

public class DebugStrategyOfLoging extends  StrategyOfLogging {

    @Override
    public void log(Logger logger, String msg) {
        logger.debug(msg);
    }
}
