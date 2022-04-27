import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {

        ArrayList<Integer> toSort = new ArrayList<Integer>();
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNextInt()) {
                String data = scanner.nextLine();
                toSort.add(Integer.parseInt(data));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found.");
            e.printStackTrace();
        }

        int[] arr = new int[toSort.size()];
        for (int i = 0; i < toSort.size(); i++) {
            arr[i] = toSort.get(i);
        }

        long start = System.currentTimeMillis();

        sort(arr);

        long end = System.currentTimeMillis();
        long erg = end - start;
        System.out.println("\n sortiertes Feld: ");
        for (int a : arr) {
            System.out.println(a);
        }
        System.out.println("Operation took " + erg + " ms.");

    }

    public static void merge(int[] arr, int[] leftarr, int[] rightarr) {

        // Zählvariablen für die beiden Hilfsarrays
        int x = 0;
        int y = 0;
        int i = 0;
        // Merge
        // Vergleich zwischen beide Hälfte
        while (x < leftarr.length && y < rightarr.length) {
            if (leftarr[x] <= rightarr[y]) {
                arr[i] = leftarr[x];
                x++;
            } else {
                arr[i] = rightarr[y];
                y++;
            }
            i++;
        }
        // Wenn ein Feld leer ist soll das andere übernommen werden
        while (x < leftarr.length) {
            arr[i] = leftarr[x];
            x++;
            i++;
        }
        while (y < rightarr.length) {
            arr[i] = rightarr[y];
            y++;
            i++;
        }

    }

    public static void sort(int[] arr) {
        int inputLength = arr.length;
        if (inputLength < 2) // Prüfe ob Rekursion abbricht
        {
            return;
        }
        int midIndex = inputLength / 2; // Zerlege -> finde Mitte

        int[] leftarr = new int[midIndex];
        int[] rightarr = new int[inputLength - midIndex]; // Damit auch Ungerade Anzahl an Zahlen richtig sortiert
                                                          // werden

        // erzeuge Hilfsfelder ( Left )
        for (int i = 0; i < midIndex; i++) {
            leftarr[i] = arr[i];
        }
        // erzeuge Hilfsfelder ( Right )
        for (int i = midIndex; i < inputLength; i++) {
            rightarr[i - midIndex] = arr[i];
        }

        sort(leftarr); // Sortiere linkes Teilfeld
        sort(rightarr); // Sortiere rechtes Teilfeld

        merge(arr, leftarr, rightarr); // Füge Teilfelder Zusammen

    }

}
