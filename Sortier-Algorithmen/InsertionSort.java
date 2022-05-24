import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class InsertionSort {
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
        // Das Programm erzeugt keine Ausgabe -1
        System.out.println("Operation took " + erg + " ms.");

    }

    public static void sort(int[] A) {
        int prevNumber;
        int currentNumber;

        for (int i = 1; i < A.length; i++) {
            currentNumber = A[i];
            prevNumber = i - 1;

            while (prevNumber >= 0 && A[prevNumber] > currentNumber) {
                A[prevNumber + 1] = A[prevNumber];
                prevNumber = prevNumber - 1;
            }
            A[prevNumber + 1] = currentNumber;
        }
    }
}
