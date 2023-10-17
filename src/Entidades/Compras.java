/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;


public class Compras extends Proveedor{

private int idCompras;
private Proveedor proveedor;
private LocalDate fecha;
private boolean estadoCompra;
private Producto producto;
private int idproveedor;

    public Compras() {
    }

    public Compras(int idCompras, int idproveedor, LocalDate fecha, boolean estadoCompra) {
        this.idCompras = idCompras;
        this.idproveedor=idproveedor;
//        this.proveedor = proveedor;
        this.fecha = fecha;
        this.estadoCompra = estadoCompra;
    }

    public Compras(Proveedor proveedor, LocalDate fecha, boolean estadoCompra) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.estadoCompra = estadoCompra;
    }
     public Compras(int idCompras, LocalDate fecha, boolean estadoCompra, int idProveedor, String razonSocial, String domicilio, String telefono, boolean estado) {
        super(idProveedor, razonSocial, domicilio, telefono, estado);
        this.idCompras = idCompras;
        this.fecha = fecha;
        this.estadoCompra = estadoCompra;
    }

    public int getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(int idCompras) {
        this.idCompras = idCompras;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(boolean estadoCompra) {
        this.estadoCompra = estadoCompra;
    }
    
     public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Compras{" + "idCompras=" + idCompras + ", proveedor=" + proveedor + ", fecha=" + fecha + ", estadoCompra=" + estadoCompra + '}';
    }




    
}
