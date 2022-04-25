import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {

        /*
         * ArrayList<Integer> toSort = new ArrayList<Integer>();
         * try {
         * Scanner scanner = new Scanner(new File(args[0]));
         * while (scanner.hasNextInt()) {
         * String data = scanner.nextLine();
         * toSort.add(Integer.parseInt(data));
         * }
         * 
         * } catch (FileNotFoundException e) {
         * System.out.println("Error! File not found.");
         * e.printStackTrace();
         * }
         * 
         * int[] arr = new int[toSort.size()];
         * for (int i = 0; i < toSort.size(); i++) {
         * arr[i] = toSort.get(i);
         * }
         * 
         * long start = System.currentTimeMillis();
         * 
         * sort(arr, 0, arr.length);
         * 
         * long end = System.currentTimeMillis();
         * long erg = end - start;
         * // Das Programm erzeugt keine Ausgabe -1
         * System.out.println("Operation took " + erg + " ms.");
         */
        int[] arr = { 2, 4, 6, 1, 3, 7 };
        // merge(arr, 0, 3, arr.length);
        sort(arr, 0, arr.length);
        for (int a : arr) {
            System.out.println("sort Array : " + a);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {

        int[] leftarr = new int[q - p + 1];
        int[] rightarr = new int[r - q + 1];
        // + Unendlich am Ende der Arrays reinpacken
        rightarr[rightarr.length - 1] = (int) Double.POSITIVE_INFINITY;
        leftarr[leftarr.length - 1] = (int) Double.POSITIVE_INFINITY;
        // erzeuge Hilfsfelder ( Left )
        for (int i = 0; i <= q - 1; i++) {
            leftarr[i] = arr[i + p];
        }
        // erzeuge Hilfsfelder ( Right )
        for (int i = 0; i < rightarr.length - 1; i++) {
            rightarr[i] = arr[i + q];
        }

        for (int a : leftarr) {
            System.out.println("linkes Array : " + a);
        }
        for (int a : rightarr) {
            System.out.println("rechtes Array : " + a);
        }

        // Zählvariablen für die beiden Hilfsarrays
        int x = 0;
        int y = 0;
        // Merge

        for (int i = 0; i < arr.length; i++) {
            if (leftarr[x] <= rightarr[y]) {
                arr[i] = leftarr[x];
                x++;
            } else {
                arr[i] = rightarr[y];
                y++;
            }
        }

    }

    public static void sort(int[] arr, int p, int r) {

        if (p < r) // Prüfe ob Rekursion abbricht
        {
            int q = (p + r) / 2; // Zerlege -> finde Mitte
            sort(arr, p, q); // Sortiere linkes Teilfeld
            sort(arr, q + 1, r); // Sortiere rechtes Teilfeld
            merge(arr, p, q, r); // Füge Teilfelder Zusammen
        }
    }

}
