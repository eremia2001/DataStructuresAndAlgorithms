import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Quicksort
{
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

        System.out.println("\n unsortiertes Feld: ");
        for (int a : arr) {
            System.out.println(a);
        }

        long start = System.currentTimeMillis();

        quicksort(arr,0,arr.length-1);

        long end = System.currentTimeMillis();
        long erg = end - start;
        System.out.println("\n sortiertes Feld: ");
        for (int a : arr) {
            System.out.println(a);
        }
        System.out.println("Operation took " + erg + " ms.");

    }


    // Zerlegung des Teilfeldes
    // Rückgabewert : der Index q des Pivotelements ( nach der Partitionierung )
    public static void quicksort(int[] array ,int low, int high)
    {
        int lowPointer = low;
        int highPointer = high;
        // Wenn das Array aus einem Element besteht..ist es schon sortiert
        if(lowPointer >= highPointer) 
        {
            return ;
        }
        // Auswahl des Pivotelements
        int pivot = array[high];

        // Sortieren der Zahlen
        while(lowPointer < highPointer)
        {
            // sucht eine Zahl die größer ist als Pivot
            while(array[lowPointer] <= pivot && lowPointer < highPointer)
            {
                lowPointer++;
            }
            // Sucht eine Zahl die kleiner ist als Pivot
            while(array[highPointer] >= pivot && lowPointer < highPointer)
            {
                highPointer--;
            }

            swap(array, lowPointer, highPointer);
        }
        
        swap(array, lowPointer, high);
        
        quicksort(array, low, lowPointer-1); // linkes Teilfeld
        quicksort(array, lowPointer+1, high); // rechtes Teilfeld
        
      
    }

    private static void swap(int[] array, int index1, int index2)
    {
              // vertausche die Pivotelement mit dem letzem Element
              int temp = array[index1];
              array[index1] = array[index2];
              array[index2] = temp;
    }
}