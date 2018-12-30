package main.java.weather.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

/**
 * @author John Turkson
 */
public class InputReader {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String previous;
    
    /**
     * @return
     * @throws UncheckedIOException
     */
    public static String getInput() {
        try {
            String input = reader.readLine().stripTrailing();
            previous = input;
            return input;
        } catch (IOException x) {
            // ignored - reading console input should be safe
            throw new UncheckedIOException(x);
        }
    }
    
    /**
     * @param prompt
     * @return
     * @throws UncheckedIOException
     */
    public static String getInput(String prompt) {
        System.out.print(prompt);
        return getInput();
    }
    
    /**
     * @param delimiter
     * @return
     * @throws UncheckedIOException
     */
    public static String getMultiLineInput(String delimiter) {
        try {
            StringBuilder lines = new StringBuilder();
            String line;
            while (!(line = reader.readLine()).equals(delimiter)) {
                lines.append(line).append("\n");
            }
            previous = lines.toString().stripTrailing();
            return lines.toString().stripTrailing();
        } catch (IOException x) {
            // ignored - reading console input should be safe
            throw new UncheckedIOException(x);
        }
    }
    
    /**
     * @param prompt
     * @param delimiter
     * @return
     * @throws UncheckedIOException
     */
    public static String getMultiLineInput(String prompt, String delimiter) {
        System.out.print(prompt);
        return getMultiLineInput(delimiter);
    }
    
    /**
     * @return
     */
    public static boolean hasPrevious() {
        return previous != null;
    }
    
    /**
     * @return
     */
    public static String getPrevious() {
        return previous;
    }
    
    /**
     *
     */
    public static void clearPrevious() {
        previous = null;
    }
}
