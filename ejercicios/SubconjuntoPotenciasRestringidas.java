package ejercicios;
import java.util.*;


public class SubconjuntoPotenciasRestringidas {
    public static boolean esPotenciaDeDos(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static boolean puedeAlcanzarObjetivo(int[] nums, int index, int objetivo, Set<Integer> obligatorios, Set<Integer> excluidos, Map<String, Boolean> memo) {
        if (objetivo == 0) return true;
        if (index == nums.length) return false;

        String key = index + "-" + objetivo;
        if (memo.containsKey(key)) return memo.get(key);

        int actual = nums[index];

        if (excluidos.contains(index)) {
            return puedeAlcanzarObjetivo(nums, index + 1, objetivo, obligatorios, excluidos, memo);
        }
        
        if (obligatorios.contains(index)) {
            return puedeAlcanzarObjetivo(nums, index + 1, objetivo, obligatorios, excluidos, memo);
        }

        boolean sinIncluir = puedeAlcanzarObjetivo(nums, index + 1, objetivo, obligatorios, excluidos, memo);

        boolean incluir = false;
        if (actual <= objetivo) {
            incluir = puedeAlcanzarObjetivo(nums, index + 1, objetivo - actual, obligatorios, excluidos, memo);
        }

        boolean resultado = sinIncluir || incluir;
        memo.put(key, resultado);
        return resultado;
    }

    public static boolean verificar(int[] entrada){
        int n = entrada[0];

        int[] nums = Arrays.copyOfRange(entrada, 1, 1 + n);

        int objetivo = entrada[1 + n];

        Set<Integer> obligatorios = new HashSet<>();
        Set<Integer> excluidos = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (esPotenciaDeDos(nums[i])) {
                obligatorios.add(i);
            }
            if (nums[i] % 5 == 0 && i + 1 < nums.length && nums[i + 1] % 2 == 1) {
                excluidos.add(i);
            }
        }

    int sumaObligatorios = 0;
    for (int idx : obligatorios) {
        if (excluidos.contains(idx)) return false; // Conflicto: obligatorio pero excluido
            sumaObligatorios += nums[idx];
    }

    int nuevoObjetivo = objetivo - sumaObligatorios;
    if (nuevoObjetivo < 0) return false;

    Map<String, Boolean> memo = new HashMap<>();
    return puedeAlcanzarObjetivo(nums, 0, nuevoObjetivo, obligatorios, excluidos, memo);
    }

    public static void main(String[] args) {
        int[][] entradas = {
            {5, 2, 4, 8, 10, 3, 14},  //true
            {5, 4, 8, 10, 3, 5, 27},    //false
            {5, 4, 8, 10, 3, 6, 27},   //false
            {5, 2, 16, 5, 7, 10, 33},   //false
            {5, 2, 16, 5, 3, 10, 33},   //false
            {4, 2, 5, 1, 6, 13}        //false
        };

        for (int[] entrada : entradas) {
            System.out.println(verificar(entrada));
        }
    }
}
