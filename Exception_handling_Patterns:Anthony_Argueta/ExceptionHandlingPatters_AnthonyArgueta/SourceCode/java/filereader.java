import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader {

    public static String readFile(String filename) throws IOException {
        System.out.println("opening file...");
        FileReader reader = null;

        try {
            reader = new FileReader(filename);
            System.out.println("reading file...");

            StringBuilder sb = new StringBuilder();
            int ch;

            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }

            return sb.toString();`
        }

        finally {
            System.out.println("closing file...");
            if (reader != null) {
                reader.close();
            }
        }

    }

    public static void main(String[] args) {
        try {
            String text = readFile("does_not_exist.txt");
            System.out.println(text);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
        catch (IOException e) {
            System.out.println("Error: I/O error occurred" + e);
        }
        finally {
            System.out.println("Finished java program");
        }
    }
}