package DAO;

import conexion.Conexion;
import modelos.Articulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticuloDAO implements ProductosDAO {
    Connection con=null;


    @Override
    public void ingresarArticulo(Articulo articulo) {
            try {

                con= Conexion.conectar();
                con.setAutoCommit(false);

                String st="INSERT INTO articulo(descripcion, precioVenta, stock) VALUES(?,?,?)";
                PreparedStatement ps= con.prepareStatement(st);
                ps.setString(1,articulo.getDescripcion());
                ps.setDouble(2,articulo.getPrecioVenta());
                ps.setInt(3,articulo.getStock());


                ps.execute();
                // System.out.println("datos preparados para insertar ");
                con.commit();
                ps.close();
                con.close();

            }catch (Exception e){

                System.out.println("Error "+e.getMessage());
                try {
                    con.rollback();
                }catch (SQLException e2){
                    System.out.println("error rollback");
                }
            }

    }

    @Override
    public void eliminarArticulo(int idArticulo){
        try {
            con = Conexion.conectar();
           // con.setAutoCommit(false);

            String st = "DELETE FROM  articulo WHERE idArticulo=?";
            PreparedStatement ps = con.prepareStatement(st);
            ps.setInt(1,idArticulo);
            ps.execute();

            int filas=ps.executeUpdate();
            if (filas>0){
                System.out.println(" articulo  eliminado");

            }else {
                throw new ExcepcionArticuloNoExiste(" El articulo no existe");
                        //System.out.println((" no existe articulo"));
            }


            ps.close();
            con.close();
        }catch (Exception e){
            System.out.println("error "+e.getMessage()+e.getClass());
        }
    }
    @Override
    public void incrementoStock(int idArticulo, int stock) {
        try{
            con= Conexion.conectar();
            String st="UPDATE articulo SET stock = stock + ? WHERE idArticulo=?";
            PreparedStatement ps=con.prepareStatement(st);

            ps.setInt(1,stock);
            ps.setInt(2,idArticulo);
            ps.executeUpdate();
            System.out.println("stock agregado correctamente");
            ps.close();
            con.close();
        }catch (Exception e){
            System.out.println("error conexion "+e.getMessage());
        }


    }

    @Override
    public void actualizarPrecio(int idArticulo, double precioVenta) {
        try {
            con=Conexion.conectar();
            String st="UPDATE articulo SET precioVenta=? WHERE idArticulo=?";
            PreparedStatement ps=con.prepareStatement(st);
            ps.setDouble(1,precioVenta);
            ps.setInt(2,idArticulo);
            ps.executeUpdate();
            System.out.println("Precio actualizado correctamente");
            ps.close();
            con.close();

        }catch (Exception e){
            System.out.println("error conexion "+e.getMessage());
        }

    }

    @Override
    public ArrayList<Articulo> listar() {
        con=Conexion.conectar();
        ArrayList<Articulo> articulos=null;
        try {

            String st="SELECT * FROM articulo";
            PreparedStatement ps=con.prepareStatement(st);

            ResultSet rs=ps.executeQuery();
            articulos=new ArrayList<>();
            while (rs.next()){
            Articulo articulo=new Articulo(rs.getString("descripcion"), rs.getDouble("precioVenta"),
            rs.getInt("stock"));
            articulos.add(articulo);


            }
            ps.close();
            con.close();

        }catch (Exception e){
            System.out.println("error conexion "+e.getMessage());
        }
        return articulos;
    }


    @Override
    public void decrementoStock(int idArticulo, int stock) {
        try{
            con= Conexion.conectar();
            String st="UPDATE articulo SET stock = stock - ? WHERE idArticulo=?";
            PreparedStatement ps=con.prepareStatement(st);

            ps.setInt(1,stock);
            ps.setInt(2,idArticulo);
            ps.executeUpdate();
            System.out.println("stock restado correctamente");
            ps.close();
            con.close();
        }catch (Exception e){
            System.out.println("error conexion "+e.getMessage());
        }
    }
}
