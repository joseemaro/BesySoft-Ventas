package modelo;

import controlador.Controlador;
import java.util.Scanner;
/**Deberá implementarse la funcionalidad básica de una tienda de productos:

 - Se podrán almacenar productos (código, nombre, precio, categoría), vendedor (código, nombre, sueldo).

 - Al registrar una venta, se tendrá que relacionar el producto con el vendedor que realizo la venta.

 - Se debe de poder calcular la comisión de ventas por cada vendedor, el cual se obtiene de un 5% de las ventas realizadas en el caso de vender hasta dos productos y un 10% al vender más de dos productos.

 - Debe implementarse distintos tipos de buscadores de productos, por ejemplo el buscar por categoría.*/
public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de ventas.");
        Controlador c = new Controlador();

        Producto arrayProductos[]= new Producto[25];
        arrayProductos[0] = new Producto(1, "lechuga", 150, "verdura");
        arrayProductos[1] = new Producto(2, "manzana", 200, "fruta");
        arrayProductos[2] = new Producto(3, "tomate", 250, "verdura");

        Vendedor arrayVendedor[]= new Vendedor[25];
        arrayVendedor[0] = new Vendedor(1, "federico", 25000);
        arrayVendedor[1] = new Vendedor(2, "juan", 26000);
        arrayVendedor[2] = new Vendedor(3, "carlos", 29000);

        Ventas arrayVentas[]= new Ventas[25];

        @SuppressWarnings("resource")
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Seleccione su opcion deseada.");
            System.out.println("1. Listar Productos");
            System.out.println("2. Listar vendedores");
            System.out.println("3. Nuevo Producto");
            System.out.println("4. Nuevo Vendedor");
            System.out.println("5. Nueva Venta");
            System.out.println("6. Listar ventas");
            System.out.println("7. Listar detalle ventas");
            System.out.println("8. Buscar Productos");
            System.out.println("9. Calcular Comision");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                String s = c.ListarProductos(arrayProductos);
                System.out.println(s);
            } else if (opcion == 2) {
                String s = c.ListarVendedores(arrayVendedor);
                System.out.println(s);
            } else if (opcion == 3) {
                int size = c.ultimoProducto(arrayProductos);
                arrayProductos[size + 1] = c.NuevoProducto(size);
                System.out.println("Producto Agregado");
            } else if (opcion == 4) {
                int size = c.ultimoVendedor(arrayVendedor);
                arrayVendedor[size + 1] = c.NuevoVendedor(size);
                System.out.println("Vendedor Agregado");
            } else if (opcion == 5) {
                int size = c.ultimaVenta(arrayVentas);
                Ventas v = c.NuevaVenta(size, arrayProductos, arrayVendedor, arrayVentas);
                if (v != null) {
                    arrayVentas[size] = v;
                    System.out.println("Venta agregada");
                }else{
                    System.out.println("fallo el registro de la venta");
                }
            }else if (opcion == 6) {
                String s = c.ListarVentas(arrayVentas);
                System.out.println(s);

            }else if (opcion ==7){
                String s = c.ListarDetalleVentas();
                System.out.println(s);
            }else if (opcion ==8){
                c.filtrarProductos(arrayProductos);
            }
            else if (opcion ==9){
                c.obtenerComision(arrayVentas, arrayVendedor);
            }
        }

    }

}
