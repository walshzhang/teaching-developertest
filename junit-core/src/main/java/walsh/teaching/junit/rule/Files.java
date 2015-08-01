package walsh.teaching.junit.rule;

import java.io.*;

public class Files {
    public static void copy(File from, File to) throws IOException {
        try (InputStream instream = new FileInputStream(from);
             OutputStream outstream = new FileOutputStream(to)) {
            copy(instream, outstream);
        }
    }

    public static void copy(InputStream instream, OutputStream outstream) throws IOException {
        int result = instream.read();
        while (result != -1) {
            outstream.write(result);
            result = instream.read();
        }
    }

    public static void write(File file, String content) throws IOException {
        try (PrintStream stream = new PrintStream(new FileOutputStream(file))) {
            stream.print(content);
        }
    }

    public static String read(File file) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (InputStream stream = new FileInputStream(file)) {
            int result = stream.read();
            while (result != -1) {
                builder.append((char) result);
                result = stream.read();
            }
        }
        return builder.toString();
    }
}
