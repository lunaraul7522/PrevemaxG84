/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Vistas.Compras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;




public class ComprasData {
   
    private Connection con=null;
    private ProveedorData provData;
    private DetalleCompraData detdData;

    public ComprasData() {
        
        con= Conexion.getConexion();
        provData=new ProveedorData();
        detdData=new DetalleCompraData();
        
    }
   
    public void GuardarCompra(Entidades.Compras compras) {
    
    Connection connection = Conexion.getConexion();
   

        if (connection == null) {
            // Manejar la falta de conexión a la base de datos
            return;
        }

        try {
            String sql = "INSERT INTO compras (idCompras, idProveedor, fecha, estadoCompra)"
                    + " VALUES (?, ?, ?, ?)";

            // Crear una sentencia preparada para ejecutar la consulta
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1,compras.getIdCompras() );
            ps.setInt(2, compras.getProveedor().getIdProveedor());
            ps.setDate(3, java.sql.Date.valueOf(compras.getFecha()));
            ps.setBoolean(4, compras.isEstadoCompra());

            // Ejecutar la consulta para insertar la compra
            int exito = ps.executeUpdate();
if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Compra agregada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar la compra.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compras. " + ex.getMessage());
        } 
      
    } 

    public void GuardarCompra(Vistas.Compras compras) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
 
            

}