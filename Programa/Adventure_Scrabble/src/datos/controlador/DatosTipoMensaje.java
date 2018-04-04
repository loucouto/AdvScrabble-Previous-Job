/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosTipoMensaje;
import datos.util.DatosConstantes;
import entidades_compartidas.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class DatosTipoMensaje implements IDatosTipoMensaje{
    
    public DatosTipoMensaje()
    {
    
    }
    
//   public int AltaTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaTipoMensaje(?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pTipoMensaje.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoMensaje.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoMensaje.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTipoMensaje.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pTipoMensaje.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(7, java.sql.Types.INTEGER);
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
//    public int ModificarTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarTipoMensaje(?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1,pTipoMensaje.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(3, pTipoMensaje.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoMensaje.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTipoMensaje.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pTipoMensaje.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pTipoMensaje.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoMensaje(?, ?)");
//             _comando.setObject(1, pTipoMensaje.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
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
//    public ArrayList<TipoMensaje> ListarTipoMensaje() throws SQLException
//    {

//        
//    }
//    
//    
//    public ArrayList<TipoMensaje> BuscarTipoMensajePorId(int pIdTipoMensaje, int pIdUsuario) throws SQLException
//    {

//    }
//    
//    public ArrayList<TipoMensaje> ListarTipoMensajeEliminados() throws SQLException
//    {
//        ArrayList<TipoMensaje> _listaTipoMensaje = new ArrayList<TipoMensaje>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoTipoMensajeEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//               TipoMensaje t = new TipoMensaje();
//                 
//                 t.setId(_resultado.getInt(2));
//                 t.setNombre(_resultado.getString(3));
//                 t.setDescripcion(_resultado.getString(4));
//                 t.setUbicacion(_resultado.getString(5));
//                 t.setArchivo(_resultado.getString(6));
//                 t.setFecha_hecho(_resultado.getDate(7));
//                 t.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaTipoMensaje.add(t);              
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
//        return _listaTipoMensaje;
//        
//    }
//    
//    public int ReingresarTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarTipoMensaje(?, ?)");
//             _comando.setObject(1, pTipoMensaje.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
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
//    public int EliminarTipoMensajeDefinitivo(int pIdUsuario, TipoMensaje pTipoMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoMensajeDefinitivo(?, ?)");
//             _comando.setObject(1, pTipoMensaje.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             
//             /*_comando.registerOutParameter(6, java.sql.Types.INTEGER);*/
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
//    public int EliminarListaTipoMensajeDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaTipoMensajeDefinitivo");
//            /* _comando.registerOutParameter(6, java.sql.Types.INTEGER);*/
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

    @Override
    public int AltaTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoMensaje> ListarTipoMensaje() {
                ArrayList<TipoMensaje> _listaTipoMensaje = new ArrayList<TipoMensaje>();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoTipoMensaje()");
                     _resultado = _comando.executeQuery();
                     
                     while(_resultado.next())
                     {
                         TipoMensaje t = new TipoMensaje();
                         
                         t.setId(_resultado.getInt(2));
                         t.setNombre(_resultado.getString(3));
                         t.setDescripcion(_resultado.getString(4));
                         t.setUbicacion(_resultado.getString(5));
                         t.setArchivo(_resultado.getString(6));
                         t.setFecha_hecho(_resultado.getDate(7));
                         t.setFecha_baja(_resultado.getDate(8));
                         
                         _listaTipoMensaje.add(t);            
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
                        Logger.getLogger(DatosTipoMensaje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                return _listaTipoMensaje;
    }

    @Override
    public TipoMensaje BuscarTipoMensajePorId(int pIdTipoMensaje, int pIdUsuario) {
                TipoMensaje t = null;
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoTipoMensajePorId(?, ?)");
                     _comando.setObject(1, pIdTipoMensaje, java.sql.Types.INTEGER);
                     _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
                     _resultado = _comando.executeQuery();
                    
                     
                     while(_resultado.next())
                     {
                         t = new TipoMensaje();
                         
                         t.setId(_resultado.getInt(2));
                         t.setNombre(_resultado.getString(3));
                         t.setDescripcion(_resultado.getString(4));
                         t.setUbicacion(_resultado.getString(5));
                         t.setArchivo(_resultado.getString(6));
                         t.setFecha_hecho(_resultado.getDate(7));
                         t.setFecha_baja(_resultado.getDate(8));
                                       
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
                        Logger.getLogger(DatosTipoMensaje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                return t;
                
    }

    @Override
    public ArrayList<TipoMensaje> ListarTipoMensajeEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoMensajeDefinitivo(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoMensajeDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
