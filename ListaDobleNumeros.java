package listadoblenumeros4;

public class ListaDobleNumeros {

    // Clase interna Nodo
    static class Nodo {
        int valor;
        Nodo anterior;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    Nodo cabeza = null;
    Nodo cola = null;

    // Método para insertar un número al final de la lista
    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        System.out.println("Se inserto el numero: " + valor);
    }

    // Método para eliminar un número de la lista
    public void eliminar(int valor) {
        Nodo actual = cabeza;

        while (actual != null && actual.valor != valor) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("El numero " + valor + " no se encuentra en la lista.");
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

        System.out.println("Se elimino el numero: " + valor);
    }

    // Método para recorrer la lista de inicio a fin
    public void recorrerAdelante() {
        Nodo actual = cabeza;
        System.out.print("Recorrido de inicio a fin: ");
        while (actual != null) {
            System.out.print("[" + actual.valor + "] ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para recorrer la lista en sentido inverso
    public void recorrerAtras() {
        Nodo actual = cola;
        System.out.print("Recorrido de fin a inicio: ");
        while (actual != null) {
            System.out.print("[" + actual.valor + "] ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    // Método principal
    public static void main(String[] args) {
        ListaDobleNumeros lista = new ListaDobleNumeros();

        // Inserciones iniciales
        lista.insertar(5);
        lista.insertar(15);
        lista.insertar(25);
        lista.insertar(35);

        // Mostrar lista
        System.out.println("\nLista actual:");
        lista.recorrerAdelante();

        // Eliminar un número
        System.out.println("\nEliminando el número 15...");
        lista.eliminar(15);
        lista.recorrerAdelante();

        // Recorrer en sentido inverso
        System.out.println("\nRecorrido inverso:");
        lista.recorrerAtras();
    }
}
