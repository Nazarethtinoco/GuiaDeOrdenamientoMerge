import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {10, 6, 8, 5, 7, 3, 4};
        mergeSort(array, array.length);
        System.out.println("Resultado: " + Arrays.toString(array));
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return; // Caso base: si el tamaño del arreglo es 1 o menos, no es necesario ordenar
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        // Copiamos los elementos a los subarreglos izquierdo y derecho
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }

        // Llamada recursiva para ordenar los subarreglos
        mergeSort(left, mid);
        mergeSort(right, n - mid);

        // Combinamos los subarreglos ordenados
        merge(a, left, right, mid, n - mid);
    }

    public static void merge(int[] a, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        // Comparamos los elementos de los subarreglos y los fusionamos en el arreglo original
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        // Copiamos los elementos restantes de los subarreglos
        while (i < leftSize) {
            a[k++] = left[i++];
        }
        while (j < rightSize) {
            a[k++] = right[j++];
        }
    }
}

