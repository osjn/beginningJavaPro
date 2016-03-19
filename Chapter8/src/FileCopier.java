import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileCopier {
    public static void main(String[] args) {
        List<String> groceries = new ArrayList<>();
        try
//        (
//                Reader in = new BufferedReader(new InputStreamReader(
//                        new FileInputStream("groceries.txt")
//                ));
//                Writer out = new BufferedWriter(new OutputStreamWriter(
//                        new FileOutputStream("groceries (copy).txt")
//                ))
//                BufferedReader in = new BufferedReader(new FileReader("groceries.txt"));
//                BufferedWriter out = new BufferedWriter(new FileWriter("groceries (cpry).txt"));
//                Reader in = new FileReader("groceries.txt");
//                Writer out = new FileWriter("groceries (copy).txt");
//                FileInputStream in = new FileInputStream("groceries.txt");
//                FileOutputStream out = new FileOutputStream("groceries (copy).txt");
//        )
        {
            groceries = Files.readAllLines(Paths.get("groceries.txt"),
                                        Charset.defaultCharset());
//            String line;
//            while ((line = in.readLine()) != null) {
//                out.write(line + System.lineSeparator());
//                System.out.println(line);
//            }
//            int c;
//            while ((c = in.read()) != -1) {
//                out.write(c);
//                System.out.println((char) c);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String item : groceries) {
            System.out.println("Don't forget to pickup: " + item);
        }
    }
}
