package listadoblenumerosejercicio1;

public class ListaDobleNumerosejercicio1 {
    
    // Clase interna Nodo
    static class Nodo {
        int dato;
        Nodo anterior;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
        }
    }

    // Referencias principales
    Nodo cabeza = null;
    Nodo cola = null;

    // Insertar al final
    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // Insertar antes de un nodo con valor específico
    public void insertarAntesDe(int valorReferencia, int nuevoValor) {
        Nodo actual = cabeza;
        while (actual != null && actual.dato != valorReferencia) {
            actual = actual.siguiente;
        }

        if (actual != null) {
            Nodo nuevo = new Nodo(nuevoValor);
            nuevo.siguiente = actual;
            nuevo.anterior = actual.anterior;

            if (actual.anterior != null) {
                actual.anterior.siguiente = nuevo;
            } else {
                cabeza = nuevo; // insertar al inicio
            }
            actual.anterior = nuevo;
        } else {
            System.out.println("Valor " + valorReferencia + " no encontrado en la lista.");
        }
    }

    // Eliminar un nodo con un valor dado
    public void eliminar(int valor) {
        Nodo actual = cabeza;
        while (actual != null && actual.dato != valor) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Nodo con valor " + valor + " no encontrado.");
            return;
        }

        if (actual.anterior != null) {
            actual.anterior.siguiente = actual.siguiente;
        } else {
            cabeza = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual.anterior;
        } else {
            cola = actual.anterior;
        }
    }

    // Mostrar lista de inicio a fin
    public void mostrar() {
        Nodo actual = cabeza;
        System.out.print("Lista: ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "] ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Recorrer la lista en reversa
    public void recorrerReversa() {
        Nodo actual = cola;
        System.out.print("Lista en reversa: ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "] ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    // Método principal
    public static void main(String[] args) {
        ListaDobleNumerosejercicio1 lista = new ListaDobleNumerosejercicio1();

        // Crear lista inicial [3] ⇔ [7] ⇔ [9] ⇔ [12] ⇔ [15]
        lista.insertar(3);
        lista.insertar(7);
        lista.insertar(9);
        lista.insertar(12);
        lista.insertar(15);

        System.out.println("Lista inicial:");
        lista.mostrar();

        // Insertar 10 antes de 12
        System.out.println("\nInsertando 10 antes de 12...");
        lista.insertarAntesDe(12, 10);
        lista.mostrar();

        // Eliminar nodo con valor 7
        System.out.println("\nEliminando nodo con valor 7...");
        lista.eliminar(7);
        lista.mostrar();

        // Mostrar lista en reversa
        System.out.println("\nRecorriendo lista en reversa:");
        lista.recorrerReversa();
    }
}
