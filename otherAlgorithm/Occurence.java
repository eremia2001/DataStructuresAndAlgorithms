package otherAlgorithm;

// This algorithm is searching for a Number in an array, that is occuring k-times
class Occurence {
    public static void main(String[] args) {

        int[] array = { 1, 4, 6, 8, 2, 9, 4, 2, 5, 2, 5, 5, 5, 1, 2, 3, 4, 5, 6, 1, 2, 3, 1, 2, 3, 9, 9, 9 };
        int k = 3;
        int[] occArray = new int[array.length];
        int currNumber;
        int count;

        // finding Numbers, that a re occuring more than k times in the array
        for (int i = 0; i < array.length; i++) {
            count = 1;
            currNumber = array[i];
            // checking if the Number we are looking for isnt already being checked by us
            if (isFinished(currNumber, occArray) == true) {
                break;
            }
            // counting the amount of the exact number in the whole array
            for (int j = i + 1; j < array.length; j++) {
                if (currNumber == array[j]) {
                    count++;
                }
            }
            // adding it to the array of occuringNumbers
            if (count >= k) {
                for (int l = 0; l < occArray.length; l++) {
                    if (occArray[l] == 0) {
                        occArray[l] = currNumber;
                        break;
                    }
                }
            }
        }

        for (int i : occArray) {

            System.out.println(i);
        }
    }

    public static boolean isFinished(int number, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return true;
            }
        }
        return false;
    }

}