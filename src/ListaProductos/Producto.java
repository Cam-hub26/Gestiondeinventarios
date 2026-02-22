package ListaProductos;

import java.util.ArrayList;

    public class Producto {

        // Categorías definidas
        public static final String DEPORTIVO = "Zapatos Deportivos";
        public static final String FORMAL = "Zapatos Formales";
        public static final String SANDALIA = "Sandalias";
        public static final String BOTA = "Botas";

        private String nombre;
        private double precio;
        private String categoria;
        private int cantidad;
        private ArrayList<String> listaImagenes;

        public Producto(String nombre, double precio, String categoria, int cantidad) {

            if (!categoriaValida(categoria)) {
                throw new IllegalArgumentException("Categoría inválida.");
            }

            this.nombre = nombre;
            this.precio = precio;
            this.categoria = categoria;
            this.cantidad = cantidad;
            this.listaImagenes = new ArrayList<>();
        }

        private boolean categoriaValida(String categoria) {
            return categoria.equalsIgnoreCase(DEPORTIVO) ||
                    categoria.equalsIgnoreCase(FORMAL) ||
                    categoria.equalsIgnoreCase(SANDALIA) ||
                    categoria.equalsIgnoreCase(BOTA);
        }

        public double calcularCostoTotal() {
            return precio * cantidad;
        }

        public void agregarImagen(String ruta) {
            listaImagenes.add(ruta);
        }

        public void mostrarProducto() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Categoría: " + categoria);
            System.out.println("Precio: ₡" + precio);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Costo total: ₡" + calcularCostoTotal());
            System.out.println("Imágenes: " + listaImagenes);
        }

        // Getters y Setters
        public String getNombre() { return nombre; }
        public String getCategoria() { return categoria; }
        public void setPrecio(double precio) { this.precio = precio; }
        public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    }

