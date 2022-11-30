class Heap {
    int[] array;
    public int length;

    public static void main(String[] args) {

        int[] array = { 65, 24, 13, 56, 69, 17, 42, 37 };

        Heap newHeap = new Heap(array);

        newHeap.createHeap(array);

        for (int i : array) {

            System.out.println(i);
        }

    }

    // Wurzel an Stelle A[0]
    // linke Sohn von A[i] ist : A[2i+1]
    // rechte Sohn von A[i] ist : A[2i+2]
    // Vater von A[i] ist : A[(i-1)/2] -> abgerundet
    // Welche Knoten haben Söhne ? :
    // -> Nur Knoten A[i] mit 0 <= i <= Math.ceil(n/2) -1

    // Konstruktor
    public Heap(int[] array) {
        this.array = array;
        this.length = array.length;
    }

    // testet die Existenz des linken SOhnes
    public boolean hasLeftChild(int i) {
        return (i <= length / 2 - 1);
    }

    // testet die Existenz des rechten Sohnes
    public boolean hasRightChild(int i) {
        return (i <= (length + 1) / 2 - 2);
    }

    // liefert den Index des linken Sohns vom Knoten mit Nummer i
    // Vorbedingung: der linke Sohn existiert
    public int leftChild(int i) {
        if (2 * i + 1 <= length) {
            return 2 * i + 1;
        }
        return 0;
    }

    // liefert den Index des rechten Sohns vom Knoten mit Nummer i
    // Vorbedingung: der rechte Sohn existiert
    public int rightChild(int i) {
        if (2 * i + 2 <= length) {
            return 2 * i + 2;
        }
        return -1;
    }

    // Liefert den Index des Vaters vom Knoten mit Nummer i
    // Vorbedingung: i>0
    public int parent(int i) {
        if (i > 0) {
            return (i - 1) / 2;
        }
        return -1;
    }

    public void createHeap(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

    }

    public boolean heapify(int[] array, int n, int i) {

        // TODO: Algorithmus bricht nicht ab, wenn keine Kinder existieren
        int childIndex = -1;
        // Schritt 1 : Ermittle Index child des Sohnes A[i] mit größerem Schlüssel
        if (hasLeftChild(i) == false && hasRightChild(i) == false) {
            System.out.println("NOPE");
            return false;
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

        // Schritt 2: Falls A[child] > A[i]: vertasuche und Wende HEAPIFY rekursiv an
        if (array[childIndex] > array[i]) {
            int temp = array[i];
            array[i] = array[childIndex];
            array[childIndex] = temp;
        }

        heapify(array, n, childIndex);
        return false;

    }
}