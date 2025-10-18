package listadobletransmilenio;

public class RutaTransmilenio {
    
    // Clase interna Nodo (representa una estación)
    static class Estacion {
        String nombre;
        Estacion anterior;
        Estacion siguiente;

        Estacion(String nombre) {
            this.nombre = nombre;
        }
    }

    // Referencias principales
    Estacion cabeza = null;
    Estacion cola = null;

    // Agregar estación al final de la ruta
    public void agregar(String nombre) {
        Estacion nueva = new Estacion(nombre);
        if (cabeza == null) {
            cabeza = cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
    }

    // Insertar estación antes de otra existente
    public void insertarAntesDe(String estacionReferencia, String nuevaEstacion) {
        Estacion actual = cabeza;
        while (actual != null && !actual.nombre.equals(estacionReferencia)) {
            actual = actual.siguiente;
        }

        if (actual != null) {
            Estacion nueva = new Estacion(nuevaEstacion);
            nueva.siguiente = actual;
            nueva.anterior = actual.anterior;

            if (actual.anterior != null) {
                actual.anterior.siguiente = nueva;
            } else {
                cabeza = nueva;
            }

            actual.anterior = nueva;
        } else {
            System.out.println("Estación '" + estacionReferencia + "' no encontrada.");
        }
    }

    // Eliminar una estación
    public void eliminar(String nombre) {
        Estacion actual = cabeza;
        while (actual != null && !actual.nombre.equals(nombre)) {
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Estación '" + nombre + "' no encontrada.");
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

    // Recorrer la ruta de inicio a fin
    public void recorrerAdelante() {
        Estacion actual = cabeza;
        System.out.print("Ruta de inicio a fin: ");
        while (actual != null) {
            System.out.print("[" + actual.nombre + "] ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Recorrer la ruta en reversa
    public void recorrerReversa() {
        Estacion actual = cola;
        System.out.print("Ruta en reversa: ");
        while (actual != null) {
            System.out.print("[" + actual.nombre + "] ");
            actual = actual.anterior;
        }
        System.out.println();
    }

    // Método principal
    public static void main(String[] args) {
        RutaTransmilenio ruta = new RutaTransmilenio();

        // Crear ruta inicial
        ruta.agregar("Las Aguas");
        ruta.agregar("Museo del Oro");
        ruta.agregar("Av. Jiménez");
        ruta.agregar("San Victorino");
        ruta.agregar("Tercer Milenio");

        System.out.println("Ruta inicial:");
        ruta.recorrerAdelante();

        // Insertar "Universidades" antes de "Las Aguas"
        System.out.println("\nInsertando 'Universidades' antes de 'Las Aguas'...");
        ruta.insertarAntesDe("Las Aguas", "Universidades");
        ruta.recorrerAdelante();

        // Eliminar "San Victorino"
        System.out.println("\nEliminando estación 'San Victorino'...");
        ruta.eliminar("San Victorino");
        ruta.recorrerAdelante();

        // Recorrer en reversa
        System.out.println("\nRecorriendo la ruta en reversa:");
        ruta.recorrerReversa();
    }
}
