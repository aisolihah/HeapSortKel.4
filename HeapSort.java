import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array sebelum sorting: " + Arrays.toString(arr));

        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);

        System.out.println("Array setelah sorting: " + Arrays.toString(arr));
    }

    public void sort(int[] arr) {  
        int n = arr.length;

        // Membangun max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Menghapus elemen satu per satu dari heap
        for (int i = n - 1; i >= 0; i--) {
            // Pindahkan root (elemen terbesar) ke akhir array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Panggil max heapify pada array yang baru disusun
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i; // Inisialisasi largest sebagai root
        int leftChild = 2 * i + 1; // Indeks anak kiri dalam array
        int rightChild = 2 * i + 2; // Indeks anak kanan dalam array

        // Jika anak kiri lebih besar dari root
        if (leftChild < n && arr[leftChild] > arr[largest])
            largest = leftChild;

        // Jika anak kanan lebih besar dari largest yang sekarang
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;

        // Jika largest tidak berada pada root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Rekursif untuk memastikan sub-pohon yang terkena pengaruh juga memenuhi sifat heap
            heapify(arr, n, largest);
        }
    }
}