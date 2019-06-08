package part1.lesson12.task02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Реализация моего класслодера.
 */
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("part1.lesson09.task01.DynamicWorker".equals(name) || "part1.lesson09.task01.Runner".equals(name)) {
            return findClass(name);
        }
        return super.loadClass(name); // механизм загрузки
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass starts work: " + name);
        if ("part1.lesson09.task01.DynamicWorker".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("DynamicWorker.class"));
                return defineClass(name, bytes, 0, bytes.length); // мапит byte[] в Class
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("part1.lesson09.task01.Runner".equals(name)) {
            try {
                byte[] bytes = Files.readAllBytes(Paths.get("Runner.class"));
                return defineClass(name, bytes, 0, bytes.length); // мапит byte[] в Class
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
