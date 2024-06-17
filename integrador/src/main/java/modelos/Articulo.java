package modelos;

public class Articulo {
    private int idArticulo;
    private String descripcion;
    private double precioVenta;
    private int stock;

    public Articulo() {
    }

    public Articulo(String descripcion, double precioVenta, int stock) {
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public Articulo(int idArticulo, String descripcion, double precioVenta, int stock) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "idArticulo=" + idArticulo +
                ", descripcion='" + descripcion + '\'' +
                ", precioVenta=" + precioVenta +
                ", stock=" + stock +
                '}';
    }
}
