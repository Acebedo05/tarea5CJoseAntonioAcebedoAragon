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

    public Catalogo() {
        this.listaProductos = new ArrayList<>();
    }

    public int numeroElementos() {
        return listaProductos.size();
    }

    public boolean estaVacio() {
        return listaProductos.isEmpty();
    }

    public Producto verElemento(int posicion) {
        if (posicion >= 0 && posicion < listaProductos.size()) {
            return listaProductos.get(posicion);
        } else {
            return null;
        }
    }

    public void cambiarElemento(int posicion, Producto nuevoProducto) {
        if (posicion >= 0 && posicion < listaProductos.size()) {
            listaProductos.set(posicion, nuevoProducto);
        }
    }

    public void guardarElemento(Producto nuevoProducto) {
        listaProductos.add(nuevoProducto);
    }

    public void eliminarElemento(int posicion) {
        if (posicion >= 0 && posicion < listaProductos.size()) {
            listaProductos.remove(posicion);
        }
    }

    public void eliminaElemento(Producto producto) {
        listaProductos.remove(producto);
    }

    public void eliminarElementos(List<Producto> elementosABorrar) {
        listaProductos.removeAll(elementosABorrar);
    }

    public void eliminarTodos() {
        listaProductos.clear();
    }

    public void imprimirCatalogo() {
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
    }

    public int buscarElemento(Producto producto) {
        return listaProductos.indexOf(producto);
    }

    public void ordenarPorNombre() {
        Collections.sort(listaProductos, (p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
    }

    public void ordenarPorPrecio() {
        Collections.sort(listaProductos, (p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
    }

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
