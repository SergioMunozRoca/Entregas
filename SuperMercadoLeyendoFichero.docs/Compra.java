package ejEduardo.pooAlmacenSupremo;

class Compra {
    private Producto producto;
    private int cantidad;

    public Compra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void aumentarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}
