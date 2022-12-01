import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Kruskal {

    public static void main(String[] args) {
        // Deklarieren der Variablen
        String data = "";
        String trimmedData = "";
        String[] itemStringData = new String[2];
        ArrayList<Integer> nodes = new ArrayList<>(); // Knoten
        ArrayList<Integer> edges = new ArrayList<>(); // Kanten

        int edgesQuant = 0; // Anzahl an Kanten
        int nodeQuant = 0; // Anzahl an Knoten
        int startNode = 0;
        int endNode = 0;
        int edgeCost = 0;
        Graph graph = new Graph();

        // Datei lesen
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNext()) {
                data = scanner.nextLine();
                switch (data.charAt(0)) // Das erste Zeichen in Jeder Zeile
                {
                    case 'p':
                        trimmedData = data.substring(7); // unnötige Informationen werden gelöscht
                        ; // Bsp.: p edge N E
                        itemStringData = trimmedData.split(" "); // String wird beim " " in Array gesplittet
                        nodeQuant = Integer.parseInt(itemStringData[0]);
                        edgesQuant = Integer.parseInt(itemStringData[1]);
                        break;

                    case 'e':
                        trimmedData = data.substring(2);
                        itemStringData = trimmedData.split(" ");
                        // System.out.println(itemStringData[0] + " " + itemStringData[1]);
                        startNode = Integer.parseInt(itemStringData[0]);
                        endNode = Integer.parseInt(itemStringData[1]);
                        edgeCost = Integer.parseInt(itemStringData[2]);
                        graph.allEdges.add(new Edge(startNode, endNode, edgeCost));
                        break;
                }

            }

            // Error Handling, falls keine Datei gefunden worden ist.
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found.");
            e.printStackTrace();
        }

        // Schritt 1: Sortiere aufsteigend
        Collections.sort(graph.allEdges);
        System.out.println(graph.allEdges);
    }
}