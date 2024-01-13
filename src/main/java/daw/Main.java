package daw;

import daw.pojo.Producto;

/**
 *
 * @author acebedo
 */
public class Main {

    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        // Crear los productos
        Producto producto1 = new Producto("Producto1", 10.0);
        Producto producto2 = new Producto("Producto2", 20.0);
        Producto producto3 = new Producto("Producto3", 15.0);

        // Meter los productos en la lista
        catalogo.guardarElemento(producto1);
        catalogo.guardarElemento(producto2);
        catalogo.guardarElemento(producto3);

        // Mostrar el catalogo original
        System.out.println("Catálogo original:");
        catalogo.imprimirCatalogo();

        System.out.println("----------------------------------------");

        System.out.println("Número de elementos: " + catalogo.numeroElementos());
        System.out.println("¿Está vacío el catálogo? " + catalogo.estaVacio());

        System.out.println("----------------------------------------");

        Producto nuevoProducto = new Producto("NuevoProducto", 25.0);
        catalogo.cambiarElemento(1, nuevoProducto);

        System.out.println("Catálogo después de cambiar un elemento:");
        catalogo.imprimirCatalogo();

        System.out.println("----------------------------------------");

        System.out.println("Posición del producto2: " + catalogo.buscarElemento(producto2));

        System.out.println("----------------------------------------");

        catalogo.ordenarPorPrecio();
        System.out.println("Catálogo ordenado por precio:");
        catalogo.imprimirCatalogo();

        System.out.println("----------------------------------------");

        // Buscar un elemento por precio usando búsqueda binaria
        double precioBuscado = 15.0;
        int posicionProducto = catalogo.buscarElementoBinario(precioBuscado);
        if (posicionProducto != -1) {
            System.out.println("Posición del producto con el precio " + precioBuscado + ": " + posicionProducto);
        } else {
            System.out.println("El producto con precio " + precioBuscado + " no se encuentra en el catálogo.");
        }

    }

}
