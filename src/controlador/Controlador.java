package controlador;

import modelo.DetalleVentas;
import modelo.Producto;
import modelo.Vendedor;
import modelo.Ventas;

import java.util.Scanner;

public class Controlador {

    DetalleVentas arrayDetVenta[] = new DetalleVentas[50];

    public String ListarProductos(Producto[] productos){
        String s ="";
        try {
            for (int i = 0; i < productos.length; i++) {
                if (productos[i] != null) {
                    s += " -Producto ";
                    s += productos[i].getNom();
                    s += " Categoria " + productos[i].getCat();
                    s += " Precio " + productos[i].getPre() +"\n";
                }
            }
        }catch (ArrayIndexOutOfBoundsException exc){
            System.out.println("Índice fuera de los límites!");
        }
        return s;
        }


    public String ListarVendedores(Vendedor[] vendedores){
        String s ="";
        try {
            for (int i = 0; i < vendedores.length; i++) {
                if (vendedores[i] != null) {
                    s += " -Vendedor ";
                    s += vendedores[i].getNom();
                    s += " sueldo " + vendedores[i].getSuel()+"\n";
                }
            }

        }catch (ArrayIndexOutOfBoundsException exc){
            System.out.println("Índice fuera de los límites!");
        }
        return s;
    }

    public String ListarVentas(Ventas[] ventas){
        String s ="";
        try {
            for (int i=0; i<ventas.length;i++){
                if (ventas[i] != null) {
                    s += " -Venta ";
                    s += " Fecha " + ventas[i].getFecha();
                    s+= " Monto " + ventas[i].getMonto();
                    s+= " Vendedor " + ventas[i].getIdVendedor()+"\n";
                }
            }
        }catch (ArrayIndexOutOfBoundsException exc){
            System.out.println("Índice fuera de los límites!");
        }

        return s;
    }

    public String ListarDetalleVentas(){
        String s ="";
        try {
            for (int i = 0; i < arrayDetVenta.length; i++) {
                if (arrayDetVenta[i] != null) {
                    s += " - detalle Venta ";
                    s += " Venta " + arrayDetVenta[i].getIdVentas();
                    s += " Producto " + arrayDetVenta[i].getIdProducto();
                    s += " Precio " + arrayDetVenta[i].getPreVenta()+"\n";
                }
            }
        }catch (ArrayIndexOutOfBoundsException exc){
            System.out.println("Índice fuera de los límites!");
        }
        return s;
    }

    public Producto NuevoProducto(int size){
        @SuppressWarnings("resource")

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese Nombre");
        String nombre = teclado.next();
        System.out.println("Ingrese Categoria");
        String categoria = teclado.next();
        System.out.println("Ingrese precio");
        int precio = teclado.nextInt();

        Producto p = new Producto(size,nombre,precio,categoria);
        return p;
    }

    public Vendedor NuevoVendedor(int size){
        @SuppressWarnings("resource")
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese Nombre");
        String nombre = teclado.next();
        System.out.println("Ingrese sueldo");
        double sueldo = teclado.nextDouble();

        Vendedor p = new Vendedor(size,nombre,sueldo);
        return p;
    }

    public int ultimoProducto(Producto[] productos){
        for (int i=0; i<productos.length;i++){
            if ((productos[i] == null) && (i != 0)) {
                int num = i-1;
                return num;
            }
        }
        return 0;
    }

    public int ultimoVendedor(Vendedor[] vendedores){
        for (int i=0; i<vendedores.length;i++){
            if ((vendedores[i] == null) && (i != 0)) {
                int num = i-1;
                return num;
            }
        }
        return 0;
    }

    public Ventas NuevaVenta(int size, Producto[] productos, Vendedor[] vendedores, Ventas[] ventas) {

        double monto = 0;
        @SuppressWarnings("resource")
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese vendedor");
        String nombreVendedor = teclado.next();
        int id_vendedor = buscarVendedor(nombreVendedor, vendedores);
        if (id_vendedor != -1) {
            System.out.println("Ingrese fecha");
            String fecha = teclado.next();
            int s = 1;
            while (s != 0) {
                System.out.println("Ingrese 1 si desea agregar producto, 0 para salir");
                s = teclado.nextInt();
                if (s == 1) {
                    System.out.println("Ingrese producto");
                    String nombre = teclado.next();
                    int id_prod = buscarProducto(nombre, productos);
                    if (id_prod != -1) {
                        double precio = obtenerPrecio(id_prod, productos);
                        System.out.println("Ingrese cantidad");
                        int cantidad = teclado.nextInt();
                        monto += (precio * cantidad);

                        int id_ventas = ultimaVenta(ventas);
                        int id = ultimoDetVenta(arrayDetVenta);
                        arrayDetVenta[id + 1] = new DetalleVentas(id, id_ventas, id_prod, cantidad, precio * cantidad);
                    }
                }
            }
            //agregar a venta
            Ventas v = new Ventas(size, id_vendedor, fecha, monto);
            return v;
        }else{
            System.out.println("no existe ese vendedor");
            return null;

        }

    }



    public int ultimaVenta(Ventas[] ventas){
        for (int i=0; i<ventas.length;i++){
            if ((ventas[i] == null) && (i != 0)) {
                int num = i-1;
                return num;
            }
        }
        return 0;
    }

    public int ultimoDetVenta(DetalleVentas[] detVentas){
        for (int i=0; i<detVentas.length;i++){
            if ((detVentas[i] == null) && (i != 0)) {
                int num = i-1;
                return num;
            }
        }
        return 0;
    }
    public int buscarVendedor(String nombre, Vendedor[] vendedores){
        for (int i=0; i<vendedores.length;i++){
            if (vendedores[i] != null) {
                if (vendedores[i].getNom().equals(nombre)){
                    return i;
                }
            }
        }
        return -1;
    }

    public int buscarProducto(String nombre, Producto[] productos){
        for (int i=0; i<productos.length;i++){
            if (productos[i] != null) {
                if (productos[i].getNom().equals(nombre)){
                    return i;
                }
            }
        }
        return -1;
    }

    public double obtenerPrecio(int id,Producto[] productos ){
        for (int i=0; i<productos.length;i++){
            if (productos[i] != null) {
                if (productos[i].getId() == id){
                    return productos[i].getPre();
                }
            }
        }
        return 0;
    }

    public void filtrarProductos(Producto[] productos){
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Seleccione el filtro que desea");
            System.out.println("1. Buscar por nombre");
            System.out.println("2. Buscar por categoria");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                System.out.println("Ingrese Nombre");
                String nombre = teclado.next();
                String s = filtrarNombre(nombre, productos);
                System.out.println(s);
            } else if (opcion == 2) {
                System.out.println("Ingrese categoria");
                String cat = teclado.next();
                String s = filtrarCategoria(cat, productos);
                System.out.println(s);
            }
        }
    }

    public String filtrarNombre(String nombre, Producto[] productos){
        String s = "";
        for (int i=0; i<productos.length;i++){
            if (productos[i] != null) {
                if (productos[i].getNom().equals(nombre)){
                    s+= " nombre= " + productos[i].getNom() + " precio= " + productos[i].getPre() + " categoria= " + productos[i].getCat();

                }
            }
        }
        if (s.equals("")){
            s= "no se encuentra";
        }
        return s;

    }
    public String filtrarCategoria(String nombre, Producto[] productos){
        String s = "";
        for (int i=0; i<productos.length;i++){
            if (productos[i] != null) {
                if (productos[i].getCat().equals(nombre)){
                    s+= " nombre= " + productos[i].getNom() + " precio= " + productos[i].getPre() + " categoria= " + productos[i].getCat() + "\n";
                }
            }
        }
        if (s == ""){
            s+="no se encuentra";
        }
        return s;
    }

    public void obtenerComision(Ventas[] ventas, Vendedor[] vendedores){
        double comision = 0;
        int cant_prod = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("indique el nombre del vendedor");
        String nombre = teclado.next();
        int id = buscarVendedor(nombre,vendedores);
        for (int i=0; i<ventas.length;i++){
            if ((ventas[i] != null)) {
                if (ventas[i].getIdVendedor() == id){
                    for (int j=0;j<arrayDetVenta.length; j++){
                        if (arrayDetVenta[j] != null){
                            if (arrayDetVenta[j].getIdVentas() == ventas[i].getId()){
                                cant_prod+=arrayDetVenta[j].getCantidad();
                            }
                        }
                    }
                }
                comision+= ventas[i].getMonto();
            }
        }
        if (cant_prod>2){
            comision = comision*0.1;
            System.out.println(comision);
        }else{
            comision = comision*0.05;
            System.out.println(comision);
        }
    }

}
