package part1.lesson09.task01;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс для запуска моего класслоадера.
 *
 * @author Овчинников Евгений
 */
public class ApplicationForMyClassLoader {

    private static final ClassLoader cl = new MyClassLoader();

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> kindClass = cl.loadClass("part1.lesson09.task01.Runner");
        Running runner = (Running) kindClass.newInstance();
        runner.run();
    }
}
