package actividades;
import java.util.*;

public class Moda3 {
    static class Limits {
        int[] a;
        int prim, ult;

        Limits(int[] a, int prim, int ult) {
            this.a = a;
            this.prim = prim;
            this.ult = ult;
        }

        int length() {
            return ult - prim + 1;
        }
    }

    static class SetVectors {
        PriorityQueue<Limits> conjunto;

        SetVectors() {
            // Orden descendente por longitud
            conjunto = new PriorityQueue<>((l1, l2) -> Integer.compare(l2.length(), l1.length()));
        }

        void insertar(Limits l) {
            conjunto.offer(l);
        }

        Limits mayor() {
            return conjunto.poll();
        }

        boolean esVacio() {
            return conjunto.isEmpty();
        }

        int longMayor() {
            return conjunto.isEmpty() ? 0 : conjunto.peek().length();
        }

        void destruir() {
            conjunto.clear();
        }
    }

    public static int moda3(int[] a, int prim, int ult) {
        SetVectors heterogeneo = new SetVectors();
        SetVectors homogeneo = new SetVectors();

        Limits p = new Limits(a, prim, ult);
        heterogeneo.insertar(p);

        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            p = heterogeneo.mayor();
            int mediana = p.a[(p.prim + p.ult) / 2];

            int izq = p.prim;
            int der = p.ult + 1;

            // Pivote2: divide en tres partes
            for (int i = p.prim; i < der; ) {
                if (p.a[i] < mediana) {
                    swap(p.a, i++, izq++);
                } else if (p.a[i] > mediana) {
                    swap(p.a, i, --der);
                } else {
                    i++;
                }
            }

            Limits p1 = new Limits(p.a, p.prim, izq - 1);
            Limits p2 = new Limits(p.a, izq, der - 1);
            Limits p3 = new Limits(p.a, der, p.ult);

            if (p1.prim < p1.ult) heterogeneo.insertar(p1);
            if (p3.prim < p3.ult) heterogeneo.insertar(p3);
            if (p2.prim < p2.ult) homogeneo.insertar(p2);
        }

        if (homogeneo.esVacio()) return a[prim];

        p = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();

        return p.a[p.prim];
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 4, 4, 5, 6, 4, 3, 2, 1};
        int moda = moda3(arr, 0, arr.length - 1);
        System.out.println("La moda es: " + moda);
    }
}
