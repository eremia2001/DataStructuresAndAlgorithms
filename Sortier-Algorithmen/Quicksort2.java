    public class Quicksort2 {

        public static int[] intArr = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19 };
    
        public static int[] sort(int l, int r) {
            int q;
            if (l < r) {
                q = partition(l, r);
                sort(l, q);
                sort(q + 1, r);
            }
            return intArr;
        }
    
        private static int partition(int l, int r) {
            int i, j, x = intArr[r-1];
            i = l - 1;
            j = r + 1;
    
            do {
                i++;
            } while (intArr[i] < x);
    
            do {
                j--;
            } while (intArr[j] > x);
    
            if (i < j) {
                int k = intArr[i];
                intArr[i] = intArr[j];
                intArr[j] = k;
            } else {
                return j;
            }
            return -1;
        }
    
        public static void main(String[] args) {
            int[] arr = sort(0, intArr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(i + 1 + ": " + arr[i]);
            }
        }
    }

