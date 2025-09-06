package Interfaz;

public class Registro {

private String nombre;
private double precio;
private int stock;

public Registro(String nombre, double precio, int stock) {
	super();
	this.nombre = nombre;
	this.precio = precio;
	this.stock = stock;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}

}
