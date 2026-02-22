//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
import ListaProductos.Producto;
import ListaProductos.ListadeProductos;

    public class Main {

        public static void menu() {

            ListadeProductos lista = new ListadeProductos();
            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n=== TIENDA DE ZAPATOS ===");
                System.out.println("1. Insertar producto al inicio");
                System.out.println("2. Insertar producto al final");
                System.out.println("3. Modificar producto");
                System.out.println("4. Eliminar producto");
                System.out.println("5. Mostrar productos");
                System.out.println("6. Reporte de costos");
                System.out.println("0. Salir");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:
                    case 2:
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();

                        System.out.println("Categorías disponibles:");
                        System.out.println("1. Zapatos Deportivos");
                        System.out.println("2. Zapatos Formales");
                        System.out.println("3. Sandalias");
                        System.out.println("4. Botas");

                        int opcionCategoria = sc.nextInt();
                        sc.nextLine();

                        String categoria = "";

                        switch (opcionCategoria) {
                            case 1: categoria = Producto.DEPORTIVO; break;
                            case 2: categoria = Producto.FORMAL; break;
                            case 3: categoria = Producto.SANDALIA; break;
                            case 4: categoria = Producto.BOTA; break;
                            default:
                                System.out.println("Categoría inválida.");
                                continue;
                        }

                        System.out.print("Cantidad: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();

                        Producto nuevo = new Producto(nombre, precio, categoria, cantidad);

                        if (opcion == 1)
                            lista.insertarInicio(nuevo);
                        else
                            lista.insertarFinal(nuevo);

                        System.out.println("Producto agregado correctamente.");
                        break;

                    case 3:
                        System.out.print("Nombre del producto a modificar: ");
                        String nombreMod = sc.nextLine();

                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = sc.nextDouble();

                        System.out.print("Nueva cantidad: ");
                        int nuevaCantidad = sc.nextInt();
                        sc.nextLine();

                        lista.modificar(nombreMod, nuevoPrecio, nuevaCantidad);
                        break;

                    case 4:
                        System.out.print("Nombre del producto a eliminar: ");
                        lista.eliminar(sc.nextLine());
                        break;

                    case 5:
                        lista.mostrarLista();
                        break;

                    case 6:
                        lista.reporteCostos();
                        break;

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } while (opcion != 0);
        }

        public static void main(String[] args) {
            menu();
        }
    }

