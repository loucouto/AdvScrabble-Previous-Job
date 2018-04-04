/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosObjetivo;
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
public class DatosObjetivo implements IDatosObjetivo {
    
    
    public DatosObjetivo()
    {
    
    }
    
//    public int AltaObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaObjetivo(?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(3, pObjetivo.getTipo_Objetivo().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(4, pObjetivo.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pObjetivo.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pObjetivo.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarObjetivo(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pObjetivo.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(4, pObjetivo.getTipo_Objetivo().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(5, pObjetivo.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pObjetivo.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pObjetivo.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarObjetivo(?, ?, ?)");
//             _comando.setObject(1, pObjetivo.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
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
//    public ArrayList<Objetivo> ListarObjetivo() throws SQLException
//    {
//        
//    }
//    
//    
//    public ArrayList<Objetivo> BuscarObjetivoPorId(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) throws SQLException
//    {
//        
//    }
//    
//    public ArrayList<Objetivo> ListarObjetivoEliminados() throws SQLException
//    {
//        ArrayList<Objetivo> _listaObjetivo = new ArrayList<Objetivo>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoObjetivoEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 Objetivo o = new Objetivo();
//                 
//                 o.setId(_resultado.getInt(3));
//                 //o.setTipo_Objetivo(DatosTipoObjetivo.BuscarTipoObjetivoPorId(_resultado.getInt(4)))
//                 o.setNombre(_resultado.getString(5));
//                 o.setDescripcion(_resultado.getString(6));
//                 o.setFecha_hecho(_resultado.getDate(7));
//                 o.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaObjetivo.add(o);                
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
//        return _listaObjetivo;
//        
//    }
//    
//    public int ReingresarObjetivo(int pIdMapa , int pIdPantalla, Objetivo pObjetivo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarObjetivo(?, ?, ?)");
//             _comando.setObject(1, pObjetivo.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
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
//    public int EliminarObjetivoDefinitivo(int pIdMapa , int pIdPantalla, Objetivo pObjetivo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarObjetivoDefinitivo(?, ?, ?)");
//             _comando.setObject(1, pObjetivo.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
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
//    public int EliminarListaObjetivoDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaObjetivoDefinitivo");
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
    public int AltaObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Objetivo> ListarObjetivo() {
                        ArrayList<Objetivo> _listaObjetivo = new ArrayList<Objetivo>();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoObjetivo()");
                     _resultado = _comando.executeQuery();
                     
                     while(_resultado.next())
                     {
                        Objetivo o = new Objetivo();
                         
                         o.setId(_resultado.getInt(4));
                         //o.setTipo_Condicionante(DatosTipoCondicionante.BuscarTipoCondicionantePorId(_resultado.getInt(4)))
                         o.setNombre(_resultado.getString(6));
                         o.setDescripcion(_resultado.getString(7));
                         o.setFecha_hecho(_resultado.getDate(8));
                         o.setFecha_baja(_resultado.getDate(9));
                         
                         _listaObjetivo.add(o);          
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
                                Logger.getLogger(DatosObjetivo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                }
                
                return _listaObjetivo;

    }

    @Override
    public Objetivo BuscarObjetivoPorId(int pIdMapa, int pIdPantalla, int pIdObjetivo) {
                Objetivo o = null;
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoObjetivoPorId(?, ?, ?)");
                     _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
                     _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
                     _comando.setObject(3, pIdObjetivo, java.sql.Types.INTEGER);
                     
                     _resultado = _comando.executeQuery();
                    
                     while(_resultado.next())
                     {
                         o = new Objetivo();
                         
                         o.setId(_resultado.getInt(4));
                         //o.setTipo_Condicionante(DatosTipoCondicionante.BuscarTipoCondicionantePorId(_resultado.getInt(4)))
                         o.setNombre(_resultado.getString(6));
                         o.setDescripcion(_resultado.getString(7));
                         o.setFecha_hecho(_resultado.getDate(8));
                         o.setFecha_baja(_resultado.getDate(9));
       
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
                                Logger.getLogger(DatosObjetivo.class.getName()).log(Level.SEVERE, null, ex);
                            }
                }
                
                return o;

    }

    @Override
    public ArrayList<Objetivo> ListarObjetivoEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarObjetivoDefinitivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaObjetivoDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
