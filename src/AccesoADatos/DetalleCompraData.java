package AccesoADatos;

import Entidades.Compras;
import Entidades.Producto;
import Entidades.detalleCompra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleCompraData {

    private Connection connection = null;
    private ProductoData ProdData;
    private ComprasData ComData;

    public DetalleCompraData() { //// const
        Connection connection = Conexion.getConexion();
        ProdData = new ProductoData();
        ComData = new ComprasData();
    }

    public List<detalleCompra> obtenerDetalle(int idDetalle) {

        List<detalleCompra> detalles = new ArrayList<>();
        Connection connection = Conexion.getConexion();

        try {
            String sql = "SELECT datellecompra.idCompras,cantidad,precioCosto,datellecompra.idProducto,idDetalle,producto.nombreProducto FROM "
                    + "datellecompra INNER JOIN compras ON datellecompra.idCompras= compras.idCompras JOIN producto ON "
                    + "datellecompra.idProducto=producto.idProducto WHERE datellecompra.idDetalle=?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idDetalle);
            ResultSet rs = ps.executeQuery();
            Producto producto1 = new Producto();
            while (rs.next()) {

                int idpro = rs.getInt("idDetalle");
                int cant = rs.getInt("cantidad");
                int idComp = rs.getInt("idCompras");

                double preco = rs.getDouble("precioCosto");
                String date = rs.getString("detalleCompra");

                // String nompro=rs.getString("nombreProducto");
                detalleCompra producto = new detalleCompra(idpro, cant, preco, null, null);
       
    // ps.close();
           }
       } catch (SQLException ex){
    JOptionPane.showMessageDialog(null,"error al obtener detalles de la compra:"+ex.getMessage());
   }
   return detalles;
        }
    }

