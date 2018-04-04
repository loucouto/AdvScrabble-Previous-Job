/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosLingote;
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
public class DatosLingote implements IDatosLingote {
    
    public DatosLingote()
    {
    
    }
    
//    public int AltaLingote(int pIdUsuario ,Lingote pLingote) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaLingote(?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pLingote.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pLingote.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pLingote.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pLingote.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pLingote.getCant_monedas(), java.sql.Types.INTEGER);
//             _comando.setObject(7, pLingote.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarLingote(int pIdUsuario ,Lingote pLingote) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarLingote(?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pLingote.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(3, pLingote.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pLingote.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pLingote.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pLingote.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pLingote.getCant_monedas(), java.sql.Types.INTEGER);
//             _comando.setObject(8, pLingote.getFecha_hecho(), java.sql.Types.DATE);
//             
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
//    public int BajaLingote(int pIdUsuario ,Lingote pLingote) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarLingote(?, ?)");
//             _comando.setObject(1, pLingote.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<Lingote> ListarLingote() throws SQLException
    
//    }
//    
//    
//    public ArrayList<Lingote> BuscarLingotePorId(int pIdUsuario, int pIdLingote) throws SQLException
//    {
//    }
//    
//    public ArrayList<Lingote> ListarLingoteEliminados() throws SQLException
//    {
//        ArrayList<Lingote> _listaLingote = new ArrayList<Lingote>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoLingoteEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//               Lingote l = new Lingote();
//                 
//                 l.setId(_resultado.getInt(2));
//                 l.setNombre(_resultado.getString(3));
//                 l.setDescripcion(_resultado.getString(4));
//                 l.setUbicacion(_resultado.getString(5));
//                 l.setArchivo(_resultado.getString(6));
//                 l.setFecha_hecho(_resultado.getDate(7));
//                 l.setCant_monedas(_resultado.getInt(8));
//                 l.setFecha_baja(_resultado.getDate(9));
//                 
//                 _listaLingote.add(l);      
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
//        return _listaLingote;
//        
//    }
//    
//    public int ReingresarLingote(int pIdUsuario ,Lingote pLingote) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarLingote(?, ?)");
//             _comando.setObject(1, pLingote.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarLingoteDefinitivo(int pIdUsuario ,Lingote pLingote) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarLingoteDefinitivo(?, ?)");
//             _comando.setObject(1, pLingote.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarLingoteLingoteDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaLingoteDefinitivo");
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
    public int AltaLingote(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarLingote(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaLingote(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Lingote> ListarLingote() {
                    ArrayList<Lingote> _listaLingote = new ArrayList<Lingote>();
                    
                    Connection _conexion = null;
                    CallableStatement _comando = null;
                    ResultSet _resultado;
                    
                    try
                    {
                         Class.forName("com.mysql.jdbc.Driver").newInstance();
                         _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                         _comando = _conexion.prepareCall("call spObtenerListadoLingote()");
                         _resultado = _comando.executeQuery();
                         
                         while(_resultado.next())
                         {
                             Lingote l = new Lingote();
                             
                             l.setId(_resultado.getInt(2));
                             l.setUbicacion(_resultado.getString(3));
                             l.setDescripcion(_resultado.getString(4));
                             l.setArchivo(_resultado.getString(5));
                             l.setFecha_hecho(_resultado.getDate(6));
                             l.setFecha_baja(_resultado.getDate(7));
                             l.setCant_monedas(_resultado.getInt(8));
                            
                             _listaLingote.add(l);            
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
                            Logger.getLogger(DatosLingote.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    return _listaLingote;
                
    }

    @Override
    public Lingote BuscarLingotePorId(int pIdUsuario, int pIdLingote) {
                Lingote l = null;
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoLingotePorId(?, ?)");
                     _comando.setObject(1, pIdLingote, java.sql.Types.INTEGER);
                     _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
                     _resultado = _comando.executeQuery();
                    
                     
                     while(_resultado.next())
                     {
                             l = new Lingote();
                             
                             l.setId(_resultado.getInt(2));
                             l.setUbicacion(_resultado.getString(3));
                             l.setDescripcion(_resultado.getString(4));
                             l.setArchivo(_resultado.getString(5));
                             l.setFecha_hecho(_resultado.getDate(6));
                             l.setFecha_baja(_resultado.getDate(7));
                             l.setCant_monedas(_resultado.getInt(8));
       
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
                               Logger.getLogger(DatosLingote.class.getName()).log(Level.SEVERE, null, ex);
                           }
                }
                
                return l;
               
    }

    @Override
    public ArrayList<Lingote> ListarLingoteEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarLingote(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarLingoteDefinitivo(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarLingoteLingoteDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
