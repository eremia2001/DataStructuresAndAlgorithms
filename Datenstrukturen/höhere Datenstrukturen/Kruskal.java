import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Kruskal {
    public static void main(String[] args) {

        ArrayList<String> graph = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                graph.add(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found.");
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        long erg = end - start;
        // Das Programm erzeugt keine Ausgabe -1
        System.out.println("Operation took " + erg + " ms.");

    }
}