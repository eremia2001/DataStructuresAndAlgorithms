import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Kruskal {
    // TODO: Union - Methoden implementieren

    public static Graph graph;

    public static void main(String[] args) {
        // Deklarieren der Variablen
        String data = "";
        String trimmedData = "";
        String[] itemStringData = new String[2];

        int edgesQuant = 0; // Anzahl an Kanten
        int nodeQuant = 0; // Anzahl an Knoten
        Node startNode;
        Node endNode;
        int edgeCost = 0;
        ArrayList<Edge> Mst; // Spannbaum
        // Datei lesen
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNext()) {
                data = scanner.nextLine();
                switch (data.charAt(0)) // Das erste Zeichen in Jeder Zeile
                {
                    case 'p':
                        trimmedData = data.substring(5); // unnötige Informationen werden gelöscht
                        ; // Bsp.: p edge N E
                        itemStringData = trimmedData.split(" "); // String wird beim " " in Array gesplittet
                        nodeQuant = Integer.parseInt(itemStringData[1]);
                        graph = new Graph(nodeQuant);
                        graph.initNodes(graph);
                        edgesQuant = Integer.parseInt(itemStringData[0]);
                        graph.nodeQuant = nodeQuant;
                        break;

                    case 'a': // Das ist eine Kante
                        trimmedData = data.substring(2);
                        itemStringData = trimmedData.split(" ");
                        // System.out.println(itemStringData[0] + " " + itemStringData[1]);
                        startNode = graph.findNode(Integer.parseInt(itemStringData[0]));
                        endNode = graph.findNode(Integer.parseInt(itemStringData[1]));
                        edgeCost = Integer.parseInt(itemStringData[2]);
                        graph.allEdges.add(new Edge(startNode, endNode, edgeCost));
                        break;
                }

            }
            System.out.println("NODEQUANT : " + nodeQuant);

            // Error Handling, falls keine Datei gefunden worden ist.
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found.");
            e.printStackTrace();
        }
        // TODO: gerichteter Graph in ungerichteter erstellen ?

        // Schritt 1: Sortiere aufsteigend
        Collections.sort(graph.allEdges);
        // Schritt 2 : Initialisiere MST mit leere Menge
        Mst = new ArrayList<>();
        // Kante einfügen. wenn kein Kreis entsteht
        UnionFindArray uFindArray = new UnionFindArray(graph);

        // System.out.println(graph.allEdges.get(0));
        for (Edge edge : graph.allEdges) {
            if (uFindArray.union(edge)) {
                Mst.add(edge);
            }
        }

        for (Edge edge : Mst) {
            System.out.println(edge);
        }

        // System.out.println("Sets : " + uFindArray.setList);
        // System.out.println(graph.allEdges);
        // System.out.println(graph.allNodes);
    }

}