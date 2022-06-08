class Heap 
{
    public static void main(String[] args) {
        

    }

    public void createHeap(int[] array)
    {
        int n = array.length;
        for(int i = n/2-1; i >= 0 ; i--)
        {
            Heapify(array, n, i);
        }

    }

    public void Heapify(int[] array, int n, int i)
    {

    }
}