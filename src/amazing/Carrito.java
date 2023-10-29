package amazing;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int id;
    private List<Paquete> paquetesAEntregar; // Usaremos una lista para mantener varios paquetes

    public Carrito(int id) {
        this.id = id;
        paquetesAEntregar = new ArrayList<>(); // Inicializamos la lista en el constructor
    }

    public void agregarPaquete(Paquete paquete) {
        paquetesAEntregar.add(paquete); // Agregamos el paquete a la lista del carrito
    }

    public void eliminarPaquete(Paquete paquete) {
        paquetesAEntregar.remove(paquete); // Eliminamos el paquete de la lista del carrito
    }

    public List<Paquete> obtenerPaquetes() {
        return paquetesAEntregar; // Devolvemos la lista de paquetes del carrito
    }
}
