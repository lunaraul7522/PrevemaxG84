/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoData {
    
    

    public static void agregarProducto(Producto producto) {
        Connection connection = Conexion.getConexion();

        try {
            String sql = "INSERT INTO producto (nombreProducto, descripcion, precioActual, Stock, estado)"
                    + " VALUES (?, ?, ?, ?, ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());

            int exito = ps.executeUpdate();

            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Producto Agregado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
//   

    public static List<Producto> obtenerProductosXDebajoStockMinimo(int stockMinimo) {
        Connection connection = Conexion.getConexion();
        List<Producto> productos = new ArrayList<>();

        if (connection == null) {

            return productos;
        }

        try {
            String sql = "SELECT * FROM producto WHERE Stock < ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, stockMinimo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombreProducto = rs.getString("nombreProducto");
                String descripcion = rs.getString("descripcion");
                double precioActual = rs.getDouble("precioActual");
                int stock = rs.getInt("Stock");
                boolean estado = rs.getBoolean("estado");

                Producto producto = new Producto(idProducto, nombreProducto, descripcion, precioActual, stock, estado);
                productos.add(producto);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }

        return productos;
    }

    public static List<Producto> listarProductos() {
        Connection connection = Conexion.getConexion();
        List<Producto> productos = new ArrayList<>();

        if (connection == null) {
            return productos;
        }

        try {
            String sql = "SELECT * FROM producto";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombreProducto = rs.getString("nombreProducto");
                String descripcion = rs.getString("descripcion");
                double precioActual = rs.getDouble("precioActual");
                int stock = rs.getInt("Stock");
                boolean estado = rs.getBoolean("estado");

                Producto producto = new Producto(idProducto, nombreProducto, descripcion, precioActual, stock, estado);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto. " + ex.getMessage());
        }

        return productos;

    }
}
