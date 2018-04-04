/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosMensaje;
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
public class DatosMensaje implements IDatosMensaje {
    
    public DatosMensaje()
    {
    
    }
    
//    public int AltaMensaje(Mensaje pMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaMensaje(?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pMensaje.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pMensaje.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pMensaje.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pMensaje.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pMensaje.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.setObject(6, pMensaje.getFecha_desde(), java.sql.Types.DATE);
//             _comando.setObject(7, pMensaje.getFecha_hasta(), java.sql.Types.DATE);
//             _comando.registerOutParameter(8, java.sql.Types.INTEGER);
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
//    public int ModificarMensaje(Mensaje pMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarMensaje(?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pMensaje.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pMensaje.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pMensaje.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pMensaje.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pMensaje.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pMensaje.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.setObject(7, pMensaje.getFecha_desde(), java.sql.Types.DATE);
//             _comando.setObject(8, pMensaje.getFecha_hasta(), java.sql.Types.DATE);
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
//    public int BajaMensaje(Mensaje pMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarMensaje(?)");
//              _comando.setObject(1, pMensaje.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<Mensaje> ListaMensaje() throws SQLException
//    {
//        
//    }
//    
//    
//    public ArrayList<Mensaje> BuscarMensajePorId(int pIdMensaje) throws SQLException
//    {
//        
//    }
//    
//    public ArrayList<Mensaje> ListarMensajeEliminados() throws SQLException
//    {
//        ArrayList<Mensaje> _listaMensaje = new ArrayList<Mensaje>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoMensajeEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                Mensaje m = new Mensaje();
//                 
//                 m.setId(_resultado.getInt(2));
//                 m.setNombre(_resultado.getString(3));
//                 m.setDescripcion(_resultado.getString(4));
//                 m.setUbicacion(_resultado.getString(5));
//                 m.setArchivo(_resultado.getString(6));
//                 m.setFecha_hecho(_resultado.getDate(7));
//                 m.setFecha_baja(_resultado.getDate(8));
//                  m.setFecha_desde(_resultado.getDate(9));
//                 m.setFecha_hasta(_resultado.getDate(10));
//                 
//                 _listaMensaje.add(m);          
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
//        return _listaMensaje;
//        
//    }
//    
//    public int ReingresarMensaje(Mensaje pMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarMensaje(?)");
//             _comando.setObject(1, pMensaje.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarMensajeDefinitivo(Mensaje pMensaje) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarMensajeDefinitivo(?)");
//             _comando.setObject(1, pMensaje.getNombre(), java.sql.Types.VARCHAR);
//             /*_comando.registerOutParameter(6, java.sql.Types.INTEGER);*/
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
//    public int EliminarListaMensajeDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaMensajeDefinitivo");
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

    @Override
    public int AltaMensaje(Mensaje pMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarMensaje(Mensaje pMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaMensaje(Mensaje pMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Mensaje> ListaMensaje() {
                            ArrayList<Mensaje> _listaMensaje = new ArrayList<Mensaje>();
                    
                    Connection _conexion = null;
                    CallableStatement _comando = null;
                    ResultSet _resultado;
                    
                    try
                    {
                         Class.forName("com.mysql.jdbc.Driver").newInstance();
                         _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                         _comando = _conexion.prepareCall("call spObtenerListadoMensaje()");
                         _resultado = _comando.executeQuery();
                         
                         while(_resultado.next())
                         {
                             Mensaje m = new Mensaje();
                             
                             m.setId(_resultado.getInt(3));
                             m.setNombre(_resultado.getString(4));
                             m.setDescripcion(_resultado.getString(5));
                             m.setUbicacion(_resultado.getString(6));
                             m.setArchivo(_resultado.getString(7));
                             m.setFecha_hecho(_resultado.getDate(8));
                             m.setFecha_baja(_resultado.getDate(9));
                             m.setFecha_desde(_resultado.getDate(10));
                             m.setFecha_hasta(_resultado.getDate(11));
                             
                             _listaMensaje.add(m);            
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
                                    Logger.getLogger(DatosMensaje.class.getName()).log(Level.SEVERE, null, ex);
                                }
                    }
                    
                    return _listaMensaje;

    }

    @Override
    public Mensaje BuscarMensajePorId(int pIdUsuario, int pIdTipoMensaje, int pIdMensaje) {
                
                Mensaje m = null;

                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;

                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoMensajePorId(?, ?, ?)");
                     _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
                     _comando.setObject(2, pIdTipoMensaje, java.sql.Types.INTEGER);
                     _comando.setObject(3, pIdMensaje, java.sql.Types.INTEGER);
                     _resultado = _comando.executeQuery();

                     while(_resultado.next())
                     {
                         m = new Mensaje();

                         m.setId(_resultado.getInt(3));
                         m.setNombre(_resultado.getString(4));
                         m.setDescripcion(_resultado.getString(5));
                         m.setUbicacion(_resultado.getString(6));
                         m.setArchivo(_resultado.getString(7));
                         m.setFecha_hecho(_resultado.getDate(8));
                         m.setFecha_baja(_resultado.getDate(9));
                         m.setFecha_desde(_resultado.getDate(10));
                         m.setFecha_hasta(_resultado.getDate(11));
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
                                Logger.getLogger(DatosMensaje.class.getName()).log(Level.SEVERE, null, ex);
                            }
                }

                return m;

    }

    @Override
    public ArrayList<Mensaje> ListarMensajeEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarMensaje(Mensaje pMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarMensajeDefinitivo(Mensaje pMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaMensajeDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
