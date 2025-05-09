package ejercicios;
import java.util.*;

public class QuickSelect {
    
    //Metodo principal qu encuentra el k-esimo numero
    public static int hallarMenor(int[] arr, int k){
        //Ajusta k a indice de arreglo este empieza desde 0
        return quickSelect(arr, 0, arr.length - 1, k -1);
    }
    
    //Metodo que implementa QuickSelect de forma Recursiva
    private static int quickSelect(int[] arr, int left, int rigth, int k){
        //caso base
        if (left == rigth) {
            return arr[left];
        }

        //seleccion de pivote aleatorio
        Random random = new Random();
        int pivote = left + random.nextInt(rigth - left + 1);
        //Reorganiza el arreglo 
        pivote = dividir(arr, left, rigth, pivote);

        //casos para encontrar el numero
        if (k == pivote) {
            return arr[k];
        } else if (k < pivote) {
            return quickSelect(arr, left, pivote -1, k);
        } else {
            return quickSelect(arr, pivote + 1, rigth, k);
        }
    }

    //Metodo pa intercambiar posiciones
    private static void cambio(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Método que organiza los elementos del arreglo alrededor del pivote
    private static int dividir(int[] arr, int left, int rigth, int pivote){
        int valorPivote = arr[pivote];
        // Mueve el pivote al final
        cambio(arr, pivote, rigth);
        int almacen = left;

         // Recorre los elementos, colocando los menores al pivote a la izquierda
        for(int i = left; i < rigth; i++){
            if (arr[i] < valorPivote) {
                cambio(arr, almacen, i);
                almacen++;
            }
        }

        // Coloca el pivote en su posición final
        cambio(arr, rigth, almacen);

        return almacen;
    }


    public static void main(String[] args) {
        int[] arr1 = {4,2,7,10,4,17};

        int k = 5;

        int resultado = hallarMenor(arr1, k);
        System.out.println("El " + k + "-enesimo numero es " + resultado);
    }
}
