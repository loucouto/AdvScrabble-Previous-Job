/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosOferta;
import datos.util.DatosConstantes;
import entidades_compartidas.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class DatosOferta implements  IDatosOferta {
    
     
    
    public DatosOferta()
    {
    
    }
    
//    public int AltaOferta(Oferta pOferta) throws SQLException
//    {
//        boolean _retorno = false;
//        
//        int _resultado = 0;
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//       
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spAltaOferta(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pOferta.getTipo_oferta().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(1, pOferta.getTitulo(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pOferta.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pOferta.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pOferta.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pOferta.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(6, java.sql.Types.INTEGER);
//                    
//             _retorno = _comando.execute();
//             _resultado = _comando.getInt("pId");
//        }
//        catch (Exception ex)
//        {
//           //Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
//        System.out.println(ex);
//        }
//        finally
//        {
//            _comando.close();
//            _conexion.close();
//        }
//        
//        return _resultado;
//        
//    }
//     
//    public int ModificarOferta(Oferta pOferta) throws SQLException
//    {
//        boolean _retorno = false;
//        
//        int _resultado = 0;
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//      
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spModificarOferta(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pOferta.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pOferta.getTitulo(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pOferta.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pOferta.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pOferta.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pOferta.getFecha_hecho(), java.sql.Types.DATE);
//             
//             _resultado = _comando.executeUpdate();
//            
//        }
//        catch (Exception ex)
//        {
//           //Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
//        System.out.println(ex);
//        }
//        finally
//        {
//            _comando.close();
//            _conexion.close();
//        }
//        
//        return _resultado;
//        
//    }
//     
//    public int BajaOferta(Oferta pOferta) throws SQLException
//    {
//        boolean _retorno = false;
//        
//        int _resultado = 0;
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//      
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spEliminarMapa(?)");
//             _comando.setObject(1, pOferta.getId(), java.sql.Types.INTEGER);
//            
//             _resultado = _comando.executeUpdate();
//            
//        }
//        catch (Exception ex)
//        {
//           //Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
//        System.out.println(ex);
//        }
//        finally
//        {
//            _comando.close();
//            _conexion.close();
//        }
//        
//        return _resultado;
//        
//    }
//    
//    
//    public ArrayList<Oferta> ListarOferta() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<Oferta> BuscarOfertaPorId(int pIdOferta) throws SQLException
//    {

//    }
//    
//    public ArrayList<Oferta> ListarOfertaEliminados() throws SQLException
//    {
//        ArrayList<Oferta> _listaOferta = new ArrayList<Oferta>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoOfertaEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                Oferta o = new Oferta();
//                 
//                 o.setId(_resultado.getInt(2));
//                 //o.setTipo_oferta(DatosTipoOferta.BuscarTipoOfertaPorId(3));
//                 o.setTitulo(_resultado.getString(4));
//                 o.setDescripcion(_resultado.getString(5));
//                 o.setUbicacion(_resultado.getString(6));
//                 o.setArchivo(_resultado.getString(7));
//                 o.setFecha_hecho(_resultado.getDate(8));
//                 o.setFecha_baja(_resultado.getDate(9));
//                 
//                 _listaOferta.add(o);                         
//             }
//        }
//        catch (Exception ex)
//        {
//           //Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
//        System.out.println(ex);
//        }
//        finally
//        {
//            _comando.close();
//            _conexion.close();
//        }
//        
//        return _listaOferta;
//        
//    }
//    
//    public int ReingresarOferta(Oferta pOferta) throws SQLException
//    {
//        boolean _retorno = false;
//        
//        int _resultado = 0;
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//      
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spReingresarOferta(?)");
//             _comando.setObject(1, pOferta.getId(), java.sql.Types.INTEGER);
//             
//             _resultado = _comando.executeUpdate();
//            
//        }
//        catch (Exception ex)
//        {
//           //Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
//        System.out.println(ex);
//        }
//        finally
//        {
//            _comando.close();
//            _conexion.close();
//        }
//        
//        return _resultado;
//        
//    }
//    
//    public int EliminarOfertaDefinitivo(Oferta pOferta) throws SQLException
//    {
//        boolean _retorno = false;
//        
//        int _resultado = 0;
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//       
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spEliminarOfertaDefinitivo(?)");
//             _comando.setObject(1, pOferta.getId(), java.sql.Types.VARCHAR);
//             _comando.registerOutParameter(6, java.sql.Types.INTEGER);
//             
//            
//             _retorno = _comando.execute();
//             _resultado = _comando.getInt("pId");
//        }
//        catch (Exception ex)
//        {
//           //Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
//        System.out.println(ex);
//        }
//        finally
//        {
//            _comando.close();
//            _conexion.close();
//        }
//        
//        return _resultado;
//        
//    }
//    
//    public int EliminarListaOfertaDefinitivo() throws SQLException
//    {
//        boolean _retorno = false;
//        
//        int _resultado = 0;
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//       
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spEliminarListaOfertaDefinitivo");
//             _comando.registerOutParameter(6, java.sql.Types.INTEGER);
//             
//             _retorno = _comando.execute();
//             _resultado = _comando.getInt("pId");
//        }
//        catch (Exception ex)
//        {
//           //Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
//        System.out.println(ex);
//        }
//        finally
//        {
//            _comando.close();
//            _conexion.close();
//        }
//        
//        return _resultado;
//        
//    }
//    

    @Override
    public int AltaOferta(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarOferta(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaOferta(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Oferta> ListarOferta() {
            ArrayList<Oferta> _listaOferta = new ArrayList<Oferta>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoOferta()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     Oferta o = new Oferta();

                     o.setId(_resultado.getInt(2));
                     //o.setTipo_oferta(DatosTipoOferta.BuscarTipoOfertaPorId(3));
                     o.setTitulo(_resultado.getString(4));
                     o.setDescripcion(_resultado.getString(5));
                     o.setPrecio(_resultado.getDouble(6));
                     o.setMoneda(_resultado.getString(7));
                     o.setSimbolo(_resultado.getString(8));
                     o.setFecha_hecho(_resultado.getDate(9));
                     o.setFecha_baja(_resultado.getDate(10));

                     _listaOferta.add(o);            
                 }
            }
            catch (Exception ex)
            {
               //Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            }
            finally
            {
                try {
                    _comando.close();
                    _conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DatosOferta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _listaOferta;


    }

    @Override
    public Oferta BuscarOfertaPorId(int pIdOferta) {
           Oferta o = null;

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoOfertaPorId(?)");
                 _comando.setObject(1, pIdOferta, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     o = new Oferta();

                     o.setId(_resultado.getInt(2));
                     //o.setTipo_oferta(DatosTipoOferta.BuscarTipoOfertaPorId(3));
                     o.setTitulo(_resultado.getString(4));
                     o.setDescripcion(_resultado.getString(5));
                     o.setPrecio(_resultado.getDouble(6));
                     o.setMoneda(_resultado.getString(7));
                     o.setSimbolo(_resultado.getString(8));
                     o.setFecha_hecho(_resultado.getDate(9));
                     o.setFecha_baja(_resultado.getDate(10));
                 }
            }
            catch (Exception ex)
            {
               //Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            }
            finally
            {
               try {
                   _comando.close();
                   _conexion.close();
               } catch (SQLException ex) {
                   Logger.getLogger(DatosOferta.class.getName()).log(Level.SEVERE, null, ex);
               }
            }

            return o;

    }

    @Override
    public ArrayList<Oferta> ListarOfertaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarOferta(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarOfertaDefinitivo(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaOfertaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
