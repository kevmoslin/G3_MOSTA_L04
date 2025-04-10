package ejercicios;
import java.util.*;


public class SubconjuntoPotenciasRestringidas {
    public static boolean esPotenciaDeDos(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
