package ListaProductos;

 public class ListadeProductos {

    private Nodo cabeza;

    public ListadeProductos() {
        cabeza = null;
    }

    // Agregar al inicio
    public void insertarInicio(Producto producto) {
        Nodo nuevo = new Nodo(producto);
        nuevo.setSiguiente(cabeza);
        cabeza = nuevo;
    }

    // Agregar al final
    public void insertarFinal(Producto producto) {
        Nodo nuevo = new Nodo(producto);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    // Buscar producto
    public Producto buscar(String nombre) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.getProducto().getNombre().equalsIgnoreCase(nombre)) {
                return actual.getProducto();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Modificar producto
    public void modificar(String nombre, double nuevoPrecio, int nuevaCantidad) {
        Producto producto = buscar(nombre);

        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            producto.setCantidad(nuevaCantidad);
            System.out.println("Producto modificado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Eliminar el producto
    public void eliminar(String nombre) {

        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }

        if (cabeza.getProducto().getNombre().equalsIgnoreCase(nombre)) {
            cabeza = cabeza.getSiguiente();
            System.out.println("Producto eliminado.");
            return;
        }

        Nodo actual = cabeza;

        while (actual.getSiguiente() != null &&
                !actual.getSiguiente().getProducto().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getSiguiente();
        }

        if (actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Mostrar todos los productos
    public void mostrarLista() {
        Nodo actual = cabeza;

        if (actual == null) {
            System.out.println("No hay productos registrados.");
            return;
        }

        while (actual != null) {
            actual.getProducto().mostrarProducto();
            System.out.println("---------------------------");
            actual = actual.getSiguiente();
        }
    }

    // Reporte de costos
    public void reporteCostos() {
        Nodo actual = cabeza;
        double totalAcumulado = 0;

        if (actual == null) {
            System.out.println("Lista vacía.");
            return;
        }

        while (actual != null) {
            double costo = actual.getProducto().calcularCostoTotal();
            System.out.println("Producto: " + actual.getProducto().getNombre());
            System.out.println("Costo total: ₡" + costo);
            System.out.println("---------------------------");

            totalAcumulado += costo;
            actual = actual.getSiguiente();
        }

        System.out.println("TOTAL ACUMULADO DEL INVENTARIO: ₡" + totalAcumulado);
    }
}

