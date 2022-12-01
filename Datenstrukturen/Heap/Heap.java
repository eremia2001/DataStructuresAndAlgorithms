class Heap {
<<<<<<< HEAD
    public int size;
=======
    int[] array;
    public int length;

    public static void main(String[] args) {

        int[] array = { 65, 24, 13, 56, 69, 17, 42, 37 };

        Heap newHeap = new Heap(array);

        newHeap.createHeap(array);

        for (int i : array) {
>>>>>>> 2f551549a48acae88bd24deea2cd35dff2985d5b

    public static void main(String[] args) {

<<<<<<< HEAD
=======
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
>>>>>>> 2f551549a48acae88bd24deea2cd35dff2985d5b
    }

    // testet die Existenz des linken SOhnes
    public boolean hasLeftChild(int i) {
<<<<<<< HEAD
        return (i <= size / 2 - 1);
=======
        return (i <= length / 2 - 1);
>>>>>>> 2f551549a48acae88bd24deea2cd35dff2985d5b
    }

    // testet die Existenz des rechten Sohnes
    public boolean hasRightChild(int i) {
<<<<<<< HEAD
        return (i <= (size + 1) / 2 - 2);
=======
        return (i <= (length + 1) / 2 - 2);
>>>>>>> 2f551549a48acae88bd24deea2cd35dff2985d5b
    }

    // liefert den Index des linken Sohns vom Knoten mit Nummer i
    // Vorbedingung: der linke Sohn existiert
    public int leftChild(int i) {
<<<<<<< HEAD
        if (2 * i + 1 <= size) {
=======
        if (2 * i + 1 <= length) {
>>>>>>> 2f551549a48acae88bd24deea2cd35dff2985d5b
            return 2 * i + 1;
        }
        return 0;
    }

    // liefert den Index des rechten Sohns vom Knoten mit Nummer i
    // Vorbedingung: der rechte Sohn existiert
    public int rightChild(int i) {
<<<<<<< HEAD
        if (2 * i + 2 <= size) {
=======
        if (2 * i + 2 <= length) {
>>>>>>> 2f551549a48acae88bd24deea2cd35dff2985d5b
            return 2 * i + 2;
        }
        return -1;
    }

<<<<<<< HEAD
    // Liefert den Index des Vaters vom Knoten mit nUmmer i
=======
    // Liefert den Index des Vaters vom Knoten mit Nummer i
>>>>>>> 2f551549a48acae88bd24deea2cd35dff2985d5b
    // Vorbedingung: i>0
    public int parent(int i) {
        if (i > 0) {
            return (i - 1) / 2;
        }
        return -1;
    }

<<<<<<< HEAD
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

=======
    public void createHeap(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

    }

>>>>>>> 2f551549a48acae88bd24deea2cd35dff2985d5b
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

<<<<<<< HEAD
        // Schritt 2: Falls A[child] > A[i]: vertasuche und WEnde HEAPIFY rekursiv an
=======
        // Schritt 2: Falls A[child] > A[i]: vertasuche und Wende HEAPIFY rekursiv an
>>>>>>> 2f551549a48acae88bd24deea2cd35dff2985d5b
        if (array[childIndex] > array[i]) {
            int temp = array[i];
            array[i] = array[childIndex];
            array[childIndex] = temp;
        }

        heapify(array, n, childIndex);
        return false;

    }
}