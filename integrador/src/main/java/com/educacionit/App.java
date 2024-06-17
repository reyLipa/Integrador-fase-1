package com.educacionit;


import DAO.ArticuloDAO;
import DAO.ExcepcionArticuloNoExiste;
import conexion.Conexion;
import modelos.Articulo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ExcepcionArticuloNoExiste {
        Conexion con=new Conexion();
        con.conectar();
        Scanner leer=new Scanner(System.in);
        ArticuloDAO articuloDAO=new ArticuloDAO();
        int opcion;
        do {

            System.out.println("***********ALMACEN***********");

            System.out.println("1. Agregar artículos");
            System.out.println("2. Actualizar precio del artículos");
            System.out.println("3. Eliminar artículos");
            System.out.println("4. Ver lista de artículos");
            System.out.println("5. Incrementar stock");
            System.out.println("6. Decrementar stock");
            System.out.println("7. Salir");
            System.out.println("Elija la opcion del menu");
            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion){
                case 1:
                    try {
                        System.out.println("Ingrese codigo de artículos ");
                        System.out.print("Código: ");
                        int idArticulo = leer.nextInt();
                        System.out.print("Descripción: ");
                        String descripcion = leer.next();
                        System.out.print("Precio de venta: ");
                        double precioVenta = leer.nextDouble();
                        System.out.print("Stock: ");
                        int stock = leer.nextInt();
                        articuloDAO.ingresarArticulo(new Articulo(idArticulo, descripcion, precioVenta, stock));
                    }catch (InputMismatchException e) {
                        System.out.println("error tipo de dato incorrecto " + e.getMessage() + e.getClass());}
                    break;
                case 2:
                    try {
                        System.out.println("Ingrese codigo artículos");
                        System.out.println("Codigo: ");
                        int codigo = leer.nextInt();
                        System.out.println("Nuevo precio del artículos ");
                        double nuevoPrecio = leer.nextDouble();
                        articuloDAO.actualizarPrecio(codigo, nuevoPrecio);
                    }catch (InputMismatchException e) {
                        System.out.println("error tipo de dato incorrecto " + e.getMessage() + e.getClass());}
                    break;
                case 3:
                    try {

                        System.out.println("Ingrese codigo artículos");
                        System.out.println("Codigo: ");
                        int codigo1 = leer.nextInt();
                        articuloDAO.eliminarArticulo(codigo1);
                    }catch (InputMismatchException e) {
                        System.out.println("error tipo de dato incorrecto " + e.getMessage() + e.getClass());}
                    break;
                case 4:
                        System.out.println("Lista de artículos");
                        List<Articulo> articulos = articuloDAO.listar();
                        System.out.println(articulos);
                        /*for (Articulo articulo : articulos) {
                            System.out.println(articulos);
                        }*/
                    break;
                case 5:
                    try {
                        System.out.println("Ingrese codigo artículos");
                        System.out.println("Codigo: ");
                        int codigo2 = leer.nextInt();
                        System.out.println("Cantidad incremento al stock: ");
                        int cantidad = leer.nextInt();
                        articuloDAO.incrementoStock(codigo2, cantidad);
                    }catch (InputMismatchException e){
                        System.out.println("error tipo de dato incorrecto " + e.getMessage() + e.getClass());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Ingrese codigo artículos");
                        System.out.println("Codigo: ");
                        int codigo3 = leer.nextInt();
                        System.out.println("Cantidad incremento al stock: ");
                        int cantidad1 = leer.nextInt();
                        articuloDAO.decrementoStock(codigo3, cantidad1);
                    }catch (InputMismatchException e){
                        System.out.println("error tipo de dato incorrecto " + e.getMessage() + e.getClass());
                    }
                    break;
                case 7:
                    System.out.println("Salir");
                default:
                    System.out.println("Opción incorrecta");
            }


        }while(opcion!=7);




















       /* Articulo articulo=new Articulo("galletas", 100,30);
        Articulo articulo2=new Articulo("cereales", 100,70);*/
        //articuloDAO.ingresarArticulo(articulo);
       // articuloDAO.eliminarArticulo(3);
        //articuloDAO.incrementoStock(4,20);
        //articuloDAO.actualizarPrecio(4,5000);
        //System.out.println(articuloDAO.listar());
        //articuloDAO.decrementoStock(4,20);
    }
}
