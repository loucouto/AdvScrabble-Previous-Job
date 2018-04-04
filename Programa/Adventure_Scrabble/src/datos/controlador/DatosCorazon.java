/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosCorazon;
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
public class DatosCorazon implements IDatosCorazon {
    
    public DatosCorazon()
    {
    
    }
    
//    public int AltaCorazon(int pIdUsuario,  Corazon pCorazon) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaCorazon(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pCorazon.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pCorazon.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pCorazon.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pCorazon.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pCorazon.getCant_vidas(), java.sql.Types.INTEGER);
//             
//             if(pCorazon.getEs_infinito() == false)
//             {
//                _comando.setObject(7, 0 , java.sql.Types.BIT);
//             }
//             else
//             {
//                 _comando.setObject(7, 1 , java.sql.Types.BIT);
//             }
//               
//             _comando.setObject(8, pCorazon.getTiempo_prox_vida(), java.sql.Types.DATE);
//             _comando.setObject(9, pCorazon.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(10, java.sql.Types.INTEGER);
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
//    public int ModificarCorazon(int pIdUsuario,  Corazon pCorazon) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarCorazon(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             
//             _comando.setObject(1,pCorazon.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(3, pCorazon.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pCorazon.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pCorazon.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pCorazon.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pCorazon.getCant_vidas(), java.sql.Types.INTEGER);
//             
//             if(pCorazon.getEs_infinito() == false)
//             {
//                _comando.setObject(8, 0 , java.sql.Types.BIT);
//             }
//             else
//             {
//                 _comando.setObject(8, 1 , java.sql.Types.BIT);
//             }
//               
//             _comando.setObject(9, pCorazon.getTiempo_prox_vida(), java.sql.Types.DATE);
//             _comando.setObject(10, pCorazon.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaCorazon(int pIdUsuario, Corazon pCorazon) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarCorazon(?, ?)");
//             _comando.setObject(1,pCorazon.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<Corazon> ListarCorazon() throws SQLException
//    {
//        ArrayList<Corazon> _listaCorazon = new ArrayList<Corazon>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spObtenerListadoCorazon");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 Corazon c = new Corazon();
//                 
//                 c.setId(_resultado.getInt(2));
//                 c.setNombre(_resultado.getString(3));
//                 c.setDescripcion(_resultado.getString(4));
//                 c.setUbicacion(_resultado.getString(5));
//                 c.setArchivo(_resultado.getString(6));
//                 c.setCant_vidas(_resultado.getInt(7));
//                 
//                 if(_resultado.getByte(8) == 1)
//                 {
//                    c.setEs_infinito(true);
//                 }
//                 else
//                 {
//                    c.setEs_infinito(false);
//                 }
//                 c.setTiempo_prox_vida(_resultado.getDate(9));
//                 c.setFecha_hecho(_resultado.getDate(10));
//                 c.setFecha_baja(_resultado.getDate(11));
//                 
//                 _listaCorazon.add(c);            
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
//        return _listaCorazon;
//        
//    }
//    
//    
//    public ArrayList<Corazon> BuscarCorazonPorId(int pIdCorazon) throws SQLException
//    {

//        
//    }
//    
//    public ArrayList<Corazon> ListarCorazonEliminados() throws SQLException
//    {
//        ArrayList<Corazon> _listaCorazon = new ArrayList<Corazon>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoCorazonEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                  Corazon c = new Corazon();
//                 
//                 c.setId(_resultado.getInt(2));
//                 c.setNombre(_resultado.getString(3));
//                 c.setDescripcion(_resultado.getString(4));
//                 c.setUbicacion(_resultado.getString(5));
//                 c.setArchivo(_resultado.getString(6));
//                 c.setCant_vidas(_resultado.getInt(7));
//                 
//                 if(_resultado.getByte(8) == 1)
//                 {
//                    c.setEs_infinito(true);
//                 }
//                 else
//                 {
//                    c.setEs_infinito(false);
//                 }
//                 c.setTiempo_prox_vida(_resultado.getDate(9));
//                 c.setFecha_hecho(_resultado.getDate(10));
//                 c.setFecha_baja(_resultado.getDate(11));
//                 
//                 _listaCorazon.add(c);        
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
//        return _listaCorazon;
//        
//    }
//    
//    public int ReingresarCorazon(int pIdUsuario, Corazon pCorazon) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarCorazon(?)");
//             _comando.setObject(1,pCorazon.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarDefinitivo(int pIdUsuario, Corazon pCorazon) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarCorazonDefinitivo(?)");
//             _comando.setObject(1,pCorazon.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
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
//    public int EliminarListaCorazonDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaCorazonDefinitivo");
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
    public int AltaCorazon(int pIdUsuario, Corazon pCorazon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarCorazon(int pIdUsuario, Corazon pCorazon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaCorazon(int pIdUsuario, Corazon pCorazon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Corazon> ListarCorazon() {
            ArrayList<Corazon> _listaCorazon = new ArrayList<Corazon>();
            
            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;
            
            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoCorazon()");
                 _resultado = _comando.executeQuery();
                 
                 while(_resultado.next())
                 {
                     Corazon c = new Corazon();
                     
                     c.setId(_resultado.getInt(2));
                     c.setNombre(_resultado.getString(3));
                     c.setDescripcion(_resultado.getString(4));
                     c.setUbicacion(_resultado.getString(5));
                     c.setArchivo(_resultado.getString(6));
                     c.setCant_vidas(_resultado.getInt(7));
                     
                     if(_resultado.getByte(8) == 1)
                     {
                        c.setEs_infinito(true);
                     }
                     else
                     {
                        c.setEs_infinito(false);
                     }
                     c.setTiempo_prox_vida(_resultado.getDate(9));
                     c.setFecha_hecho(_resultado.getDate(10));
                     c.setFecha_baja(_resultado.getDate(11));
                     
                     _listaCorazon.add(c);            
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
                    Logger.getLogger(DatosCorazon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            return _listaCorazon;
            
    }

    @Override
    public Corazon BuscarCorazonPorId(int pIdUsuario,int pIdCorazon) {
            Corazon c = null;
            
            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;
            
            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoCorazonPorId(?,?)");
                 _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
                 _comando.setObject(2, pIdCorazon, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();
                
                 
                 while(_resultado.next())
                 {
                     c = new Corazon();
                     
                     c.setId(_resultado.getInt(2));
                     c.setNombre(_resultado.getString(3));
                     c.setDescripcion(_resultado.getString(4));
                     c.setUbicacion(_resultado.getString(5));
                     c.setArchivo(_resultado.getString(6));
                     c.setCant_vidas(_resultado.getInt(7));
                     
                     if(_resultado.getByte(8) == 1)
                     {
                        c.setEs_infinito(true);
                     }
                     else
                     {
                        c.setEs_infinito(false);
                     }
                     c.setTiempo_prox_vida(_resultado.getDate(9));
                     c.setFecha_hecho(_resultado.getDate(10));
                     c.setFecha_baja(_resultado.getDate(11));
                             
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
                    Logger.getLogger(DatosCorazon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            return c;
    }

    @Override
    public ArrayList<Corazon> ListarCorazonEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarCorazon(int pIdUsuario, Corazon pCorazon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarDefinitivo(int pIdUsuario, Corazon pCorazon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaCorazonDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
