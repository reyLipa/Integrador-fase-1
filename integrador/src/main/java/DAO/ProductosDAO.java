package DAO;

import modelos.Articulo;

import java.util.ArrayList;

public interface ProductosDAO {
void ingresarArticulo(Articulo articulo);
void eliminarArticulo(int idArticulo) throws ExcepcionArticuloNoExiste;
void incrementoStock(int idArticulo,int stock);
void actualizarPrecio(int idArticulo, double precioVenta);
ArrayList<Articulo> listar();

void decrementoStock(int idArticulo, int stock);
}
