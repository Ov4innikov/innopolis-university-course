package part1.lesson06.task02;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RandomTextFileGenerator {

    @Test
    public void testGenerateWord() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = TextFileGenerator.class.getDeclaredMethod("generateWord");
        method.setAccessible(true);
        System.out.println(method.invoke(TextFileGenerator.class));
    }

    @Test
    public void testGenerateProposal() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = TextFileGenerator.class.getDeclaredMethod("generateProposal", String[].class, int.class);
        method.setAccessible(true);
        System.out.println(method.invoke(TextFileGenerator.class, TextFileGenerator.WORDS_DICTIONARY, 50));
    }

    @Test
    public void testGenerateParagraph() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = TextFileGenerator.class.getDeclaredMethod("generateParagraph", String[].class, int.class);
        method.setAccessible(true);
        System.out.println(method.invoke(TextFileGenerator.class, TextFileGenerator.WORDS_DICTIONARY, 50).toString() + method.invoke(TextFileGenerator.class, TextFileGenerator.WORDS_DICTIONARY, 50));
    }

    @Test
    public void testGenerteFile() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = TextFileGenerator.class.getDeclaredMethod("generteFile", String.class, int.class, String[].class, int.class);
        method.setAccessible(true);
        method.invoke(TextFileGenerator.class, "", 5, TextFileGenerator.WORDS_DICTIONARY, 50);
    }
}
