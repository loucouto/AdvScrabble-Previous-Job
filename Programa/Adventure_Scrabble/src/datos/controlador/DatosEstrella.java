/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosEstrella;
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
public class DatosEstrella implements IDatosEstrella {
    
    public DatosEstrella()
    {
    
    }
    
//    public int AltaEstrella(Estrella pEstrella) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaEstrella(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pEstrella.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pEstrella.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pEstrella.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pEstrella.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pEstrella.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarEstrella(Estrella pEstrella) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarPuntajePantalla(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pEstrella.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(1, pEstrella.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pEstrella.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pEstrella.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pEstrella.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pEstrella.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaEstrella(Estrella pEstrella) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarEstrella(?)");
//             _comando.setObject(1, pEstrella.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<Estrella> ListarEstrella() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<Estrella> BuscarEstrellaPorId(int pIdEstrella) throws SQLException
//    {

//    }
//    
//    public ArrayList<Estrella> ListarEstrellaEliminados() throws SQLException
//    {
//        ArrayList<Estrella> _listaEstrella = new ArrayList<Estrella>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoEstrellaEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 Estrella es = new Estrella();
//                 
//                 es.setId(_resultado.getInt(1));
//                 es.setNombre(_resultado.getString(2));
//                 es.setDescripcion(_resultado.getString(3));
//                 es.setUbicacion(_resultado.getString(4));
//                 es.setArchivo(_resultado.getString(5));
//                 es.setFecha_hecho(_resultado.getDate(6));
//                 es.setFecha_baja(_resultado.getDate(7));
//                 
//                 _listaEstrella.add(es);  
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
//        return _listaEstrella;
//        
//    }
//    
//    public int ReingresarEstrella(Estrella pEstrella) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarEstrella(?)");
//             _comando.setObject(1, pEstrella.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarEstrellaDefinitivo(Estrella pEstrella) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarEstrellaDefinitivo(?)");
//             _comando.setObject(1, pEstrella.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarListaEstrellaDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaEstrellaDefinitivo");
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

    @Override
    public int AltaEstrella(Estrella pEstrella) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarEstrella(Estrella pEstrella) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaEstrella(Estrella pEstrella) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Estrella> ListarEstrella() {
                        ArrayList<Estrella> _listaEstrella = new ArrayList<Estrella>();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoEstrella");
                     _resultado = _comando.executeQuery();
                     
                     while(_resultado.next())
                     {
                         Estrella es = new Estrella();
                         
                         es.setId(_resultado.getInt(1));
                         es.setNombre(_resultado.getString(2));
                         es.setDescripcion(_resultado.getString(3));
                         es.setUbicacion(_resultado.getString(4));
                         es.setArchivo(_resultado.getString(5));
                         es.setFecha_hecho(_resultado.getDate(6));
                         es.setFecha_baja(_resultado.getDate(7));
                         
                         _listaEstrella.add(es);            
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
                                Logger.getLogger(DatosEstrella.class.getName()).log(Level.SEVERE, null, ex);
                            }
                }
                
                return _listaEstrella;
                
    }

    @Override
    public Estrella BuscarEstrellaPorId(int pIdEstrella) {
                Estrella estrella = new Estrella();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoEstrellaPorId(?)");
                     _comando.setObject(1, pIdEstrella, java.sql.Types.INTEGER);
                     _resultado = _comando.executeQuery();
                    
                     
                     while(_resultado.next())
                     {
                         estrella = new Estrella();
                         
                         estrella.setId(_resultado.getInt(1));
                         estrella.setNombre(_resultado.getString(2));
                         estrella.setDescripcion(_resultado.getString(3));
                         estrella.setUbicacion(_resultado.getString(4));
                         estrella.setArchivo(_resultado.getString(5));
                         estrella.setFecha_hecho(_resultado.getDate(6));
                         estrella.setFecha_baja(_resultado.getDate(7));
                          
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
                               Logger.getLogger(DatosEstrella.class.getName()).log(Level.SEVERE, null, ex);
                           }
                }
                
                return estrella;
    }

    @Override
    public ArrayList<Estrella> ListarEstrellaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarEstrella(Estrella pEstrella) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarEstrellaDefinitivo(Estrella pEstrella) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaEstrellaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
