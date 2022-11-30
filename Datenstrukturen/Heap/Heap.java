class Heap {
    public int size;

    public static void main(String[] args) {

    }

    // testet die Existenz des linken SOhnes
    public boolean hasLeftChild(int i) {
        return (i <= size / 2 - 1);
    }

    // testet die Existenz des rechten Sohnes
    public boolean hasRightChild(int i) {
        return (i <= (size + 1) / 2 - 2);
    }

    // liefert den Index des linken SOgns vom Knoten mit Nummer i
    // Vorbedingung: der linke Sohn existiert
    public int leftChild(int i) {
        if (2 * i + 1 <= size) {
            return 2 * i + 1;
        }
        return 0;
    }

    // liefert den Index des rechten Sohns vom Knoten mit Nummer i
    // Vorbedingung: der rechte Sohn existiert
    public int rightChild(int i) {
        if (2 * i + 2 <= size) {
            return 2 * i + 2;
        }
        return -1;
    }

    // Liefert den Index des Vaters vom Knoten mit nUmmer i
    // Vorbedingung: i>0
    public int parent(int i) {
        if (i > 0) {
            return (i - 1) / 2;
        }
        return -1;
    }

    // Fügt ein Element im Heap ein
    public void insertNode() {

    }

    /*
     * public void createHeap(int[] array) {
     * int n = array.size;
     * for (int i = n / 2 - 1; i >= 0; i--) {
     * heapify(array, n, i);
     * }
     * 
     * }
     */

    public boolean heapify(int[] array, int n, int i) {

        // TODO: Algorithmus bricht nicht ab, wenn keine Kinder existieren
        int childIndex = -1;
        // Schritt 1 : Ermittle Index child des Sohnes A[i] mit größerem Schlüssel
        if (hasLeftChild(i) == false && hasRightChild(i) == false) {
            System.out.println("NOPE");
            return true;
        }
        if (hasLeftChild(i) && hasRightChild(i) == false) {
            childIndex = leftChild(i);
        }
        if (hasLeftChild(i) == false && hasRightChild(i) == true) {
            childIndex = rightChild(i);
        }
        if (hasLeftChild(i) && hasRightChild(i)) {
            if (leftChild(i) > rightChild(i)) {
                childIndex = leftChild(i);
            } else {
                childIndex = rightChild(i);
            }
        }

        // Schritt 2: Falls A[child] > A[i]: vertasuche und WEnde HEAPIFY rekursiv an
        if (array[childIndex] > array[i]) {
            int temp = array[i];
            array[i] = array[childIndex];
            array[childIndex] = temp;
        }

        heapify(array, n, childIndex);
        return false;

    }
}