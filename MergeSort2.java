import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class MergeSort2 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Integer> arrList = new ArrayList<Integer>();

		/*
		 * try {
		 * Scanner scanner = new Scanner(new File(args[0]));
		 * while (scanner.hasNextInt()) {
		 * String data = scanner.nextLine();
		 * arrList.add(Integer.parseInt(data));
		 * }
		 * } catch (FileNotFoundException e) {
		 * System.out.println("An Error occoured!");
		 * e.printStackTrace();
		 * }
		 * 
		 * int[] arr = new int[arrList.size()];
		 * for (int i = 0; i < arrList.size(); i++) {
		 * arr[i] = arrList.get(i);
		 * }
		 * 
		 * long start = System.currentTimeMillis();
		 * 
		 * // sort(arr, 0, arrList.size() - 1);
		 * int[] array = { 2, 6, 4, 8, 9, 1, 2 };
		 * sort(array, 0, arr.length);
		 * long stop = System.currentTimeMillis();
		 * long erg = stop - start;
		 * 
		 * for (int i : arr) {
		 * System.out.println(i);
		 * }
		 * 
		 * System.out.println("Time ellapsed: " + erg);
		 */
		int[] array = { 2, 6, 4, 8, 9, 1, 2 };
		sort(array, 0, array.length - 1);
	}

	public static void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	public static void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}
}
