/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosJugador;
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
public class DatosJugador implements IDatosJugador {
       
    public DatosJugador()
    {
    
    }
    
//    public int AltaJugador(Jugador pJugador) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaMapa(?, ?, ?)");
//             _comando.setObject(1, pJugador.getTipo_jugador().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pJugador.getPuntaje_total(), java.sql.Types.INTEGER);
//             _comando.registerOutParameter(3, java.sql.Types.INTEGER);
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
//    public int ModificarJugador(Jugador pJugador) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarJugador(?, ?, ?)");
//             _comando.setObject(1, pJugador.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pJugador.getTipo_jugador().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(3, pJugador.getPuntaje_total(), java.sql.Types.INTEGER);
//             _comando.registerOutParameter(3, java.sql.Types.INTEGER);
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
     
//    public int BajaJugador(Jugador pJugador) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarJ(?)");
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
    
    
//    public ArrayList<Jugador> ListarJugador() throws SQLException
//    {
 
//    }
//    
//    
//    public ArrayList<Jugador> BuscarMapaPorId(int pIdUsuario) throws SQLException
//    {
//        
//    }
//    
//    public ArrayList<Jugador> ListarJugadorEliminados() throws SQLException
//    {
//        ArrayList<Jugador> _listaJugador = new ArrayList<Jugador>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoJugadorEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 Jugador j = new Jugador();
//                 
//                 j.setId(_resultado.getInt(2));
//                 j.setNombre_usuario(_resultado.getString(3));
//                 j.setDescripcion(_resultado.getString(4));
//                 j.setUbicacion(_resultado.getString(5));
//                 j.setArchivo(_resultado.getString(6));
//                 j.setContrasenia(_resultado.getString(7));
//                 j.setNombre_usuario(_resultado.getString(8));
//                 j.setFecha_hecho(_resultado.getDate(9));
//                 j.setFecha_baja(_resultado.getDate(10));
//                 //j.setTipo_jugado(DatosTipoJugador.BuscarTipoJugadorPorId(_resultaod.getInt(11)));
//                 j.setPuntaje_total(_resultado.getInt(12));
//                 
//                 _listaJugador.add(j);            
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
//        return _listaJugador;
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
    public int AltaJugador(Jugador pJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarJugador(Jugador pJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Jugador> ListarJugador() {
                           ArrayList<Jugador> _listaJugador = new ArrayList<Jugador>();
                    
                    Connection _conexion = null;
                    CallableStatement _comando = null;
                    ResultSet _resultado;
                    
                    try
                    {
                         Class.forName("com.mysql.jdbc.Driver").newInstance();
                         _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                         _comando = _conexion.prepareCall("call spObtenerListadoJugador()");
                         _resultado = _comando.executeQuery();
                         
                         while(_resultado.next())
                         {
                            Jugador j = new Jugador();
                             
                             j.setId(_resultado.getInt(2));
                             j.setNombre_usuario(_resultado.getString(3));
                             j.setDescripcion(_resultado.getString(4));
                             j.setUbicacion(_resultado.getString(5));
                             j.setArchivo(_resultado.getString(6));
                             j.setContrasenia(_resultado.getString(7));
                             j.setNombre_usuario(_resultado.getString(8));
                             j.setFecha_hecho(_resultado.getDate(9));
                             j.setFecha_baja(_resultado.getDate(10));
                             //j.setTipo_jugado(DatosTipoJugador.BuscarTipoJugadorPorId(_resultaod.getInt(11)));
                             j.setPuntaje_total(_resultado.getInt(12));
                             
                             _listaJugador.add(j);             
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
                                   Logger.getLogger(DatosJugador.class.getName()).log(Level.SEVERE, null, ex);
                               }
                    }
                    
                    return _listaJugador;
                   
    }

    @Override
    public Jugador BuscarJugadorPorId(int pIdUsuario) {
                Jugador j = new Jugador();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoJugadorPorId(?)");
                     _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
                     _resultado = _comando.executeQuery();
                    
                     
                     while(_resultado.next())
                     {
                         j = new Jugador();
                         
                         j.setId(_resultado.getInt(2));
                         j.setNombre_usuario(_resultado.getString(3));
                         j.setDescripcion(_resultado.getString(4));
                         j.setUbicacion(_resultado.getString(5));
                         j.setArchivo(_resultado.getString(6));
                         j.setContrasenia(_resultado.getString(7));
                         j.setNombre_usuario(_resultado.getString(8));
                         j.setFecha_hecho(_resultado.getDate(9));
                         j.setFecha_baja(_resultado.getDate(10));
                         //j.setTipo_jugado(DatosTipoJugador.BuscarTipoJugadorPorId(_resultaod.getInt(11)));
                         j.setPuntaje_total(_resultado.getInt(12));           
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
                         Logger.getLogger(DatosJugador.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
                
                return j;

    }

    @Override
    public ArrayList<Jugador> ListarJugadorEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
