package ejercicios;

import java.util.*;

public class QuickSlect {
    private static int quickSelect(int[] arr, int left, int rigth, int k){
        if (left == rigth) {
            return arr[left];
        }

        Random random = new Random();
        int pivote = left + random.nextInt(rigth - left + 1);
        pivote = dividir(arr, left, rigth, pivote);

        if (k == pivote) {
            return arr[k];
        } else if (k < pivote) {
            return quickSelect(arr, left, pivote -1, k);
        } else {
            return quickSelect(arr, pivote + 1, rigth, k);
        }
    }

    
}
