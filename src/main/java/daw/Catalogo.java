package daw;

import daw.pojo.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author acebedo
 */
public class Catalogo {

    private List<Producto> listaProductos;

    // Crear una lista.
    public Catalogo() {
        this.listaProductos = new ArrayList<>();
    }

    // Ver el numero de elementos de la lista.
    public int numeroElementos() {
        return listaProductos.size();
    }

    // Ver si la lista esta vacía.
    public boolean estaVacio() {
        return listaProductos.isEmpty();
    }

    // Ver el elemento que se encuentre en la posición dada.
    public Producto verElemento(int posicion) {
        if (posicion >= 0 && posicion < listaProductos.size()) {
            return listaProductos.get(posicion);
        } else {
            return null;
        }
    }

    // Cambiar el elemento de la posición indicada, por otro elemento nuevo.
    public void cambiarElemento(int posicion, Producto nuevoProducto) {
        if (posicion >= 0 && posicion < listaProductos.size()) {
            listaProductos.set(posicion, nuevoProducto);
        }
    }

    // Agregar al final de la lista un elemento nuevo.
    public void guardarElemento(Producto nuevoProducto) {
        listaProductos.add(nuevoProducto);
    }

    // Elimina el elemento que se encuentra en la posición dada.
    public void eliminarElemento(int posicion) {
        if (posicion >= 0 && posicion < listaProductos.size()) {
            listaProductos.remove(posicion);
        }
    }

    // Elimina el elemento indicado si se encuentra en la lista.
    public void eliminaElemento(Producto producto) {
        listaProductos.remove(producto);
    }

    // Recibe la lista de objetos a borrar del catálogo original.
    public void eliminarElementos(List<Producto> elementosABorrar) {
        listaProductos.removeAll(elementosABorrar);
    }

    // Borra todos los elementos de la lista.
    public void eliminarTodos() {
        listaProductos.clear();
    }

    // Imprime todos los elementos de la lista
    public void imprimirCatalogo() {
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
    }

    // Busca el elemento indicado en la lista y devuelve su posición.
    public int buscarElemento(Producto producto) {
        return listaProductos.indexOf(producto);
    }

    // Ordena los elementos de la lista por nombre.
    public void ordenarPorNombre() {
        Collections.sort(listaProductos, (p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
    }

    // Ordena los elementos de la lista por precio.
    public void ordenarPorPrecio() {
        Collections.sort(listaProductos, (p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
    }

    // Busca el elemento que tenga el precio indicado.
    public int buscarElementoBinario(double precioBuscado) {
        ordenarPorPrecio();
        Producto productoBuscado = new Producto("", precioBuscado);
        int posicion = Collections.binarySearch(listaProductos, productoBuscado, (p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));

        if (posicion >= 0) {
            return posicion;
        } else {
            return -1;
        }
    }

}
