/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosMapa;
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
public class DatosMapa implements IDatosMapa {
 
    //private Connection conexion;
    //private CallableStatement cs;
    //private ResultSet rs;
     
    public DatosMapa()
    {
    
    }
    
//    public int AltaMapa(Mapa pMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaMapa(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pMapa.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pMapa.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pMapa.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pMapa.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pMapa.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarMapa(Mapa pMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarMapa(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pMapa.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pMapa.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pMapa.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pMapa.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pMapa.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pMapa.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaMapa(Mapa pMapa) throws SQLException
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
//             _comando.setObject(1, pMapa.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<Mapa> ListarMapa() throws SQLException
//    {

//        
//    }
//    
//    
//    public ArrayList<Mapa> BuscarMapaPorId(int pIdMapa) throws SQLException
//    {

//    }
//    
//    public ArrayList<Mapa> ListarMapaEliminados() throws SQLException
//    {
//        ArrayList<Mapa> _listaMapa = new ArrayList<Mapa>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoMapasEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 Mapa m = new Mapa();
//                 
//                 m.setId(_resultado.getInt(2));
//                 m.setNombre(_resultado.getString(3));
//                 m.setDescripcion(_resultado.getString(4));
//                 m.setUbicacion(_resultado.getString(5));
//                 m.setArchivo(_resultado.getString(6));
//                 m.setFecha_hecho(_resultado.getDate(7));
//                 m.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaMapa.add(m);            
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
//        return _listaMapa;
//        
//    }
//    
//    public int ReingresarMapa(Mapa pMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarMapa(?)");
//             _comando.setObject(1, pMapa.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarMapaDefinitivo(Mapa pMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarMapaDefinitivo(?)");
//             _comando.setObject(1, pMapa.getNombre(), java.sql.Types.VARCHAR);
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
//    public int EliminarListaMapaDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaMapaDefinitivo");
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

    @Override
    public int AltaMapa(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarMapa(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaMapa(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Mapa> ListarMapa() {
                ArrayList<Mapa> _listaMapa = new ArrayList<Mapa>();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoMapa");
                     _resultado = _comando.executeQuery();
                     
                     while(_resultado.next())
                     {
                         Mapa m = new Mapa();
                         
                         m.setId(_resultado.getInt(2));
                         m.setNombre(_resultado.getString(3));
                         m.setDescripcion(_resultado.getString(4));
                         m.setUbicacion(_resultado.getString(5));
                         m.setArchivo(_resultado.getString(6));
                         m.setFecha_hecho(_resultado.getDate(7));
                         m.setFecha_baja(_resultado.getDate(8));
                         
                         _listaMapa.add(m);            
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
                        Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                return _listaMapa;
    }

    @Override
    public Mapa BuscarMapaPorId(int pIdMapa) {
                Mapa m = null;
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoMapaPorId(?)");
                     _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
                     _resultado = _comando.executeQuery();
                    
                     
                     while(_resultado.next())
                     {
                         m = new Mapa();
                         
                         m.setId(_resultado.getInt(2));
                         m.setNombre(_resultado.getString(3));
                         m.setDescripcion(_resultado.getString(4));
                         m.setUbicacion(_resultado.getString(5));
                         m.setArchivo(_resultado.getString(6));
                         m.setFecha_hecho(_resultado.getDate(7));
                         m.setFecha_baja(_resultado.getDate(8));
                        
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
                        Logger.getLogger(DatosMapa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                return m;
                
    }

    @Override
    public ArrayList<Mapa> ListarMapaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarMapa(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarMapaDefinitivo(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaMapaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
