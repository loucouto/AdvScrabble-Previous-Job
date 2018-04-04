/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosPerfilUsuario;
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
public class DatosPerfilUsuario implements IDatosPerfilUsuario {
    
       
    public DatosPerfilUsuario()
    {
    
    }
    
//     public int AltaPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaPerfilUsuario(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pPerfilUsuario.getTipo_perfil().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(3, pPerfilUsuario.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pPerfilUsuario.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pPerfilUsuario.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarPerfilUsuario(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pPerfilUsuario.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(3, pPerfilUsuario.getTipo_perfil().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(4, pPerfilUsuario.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pPerfilUsuario.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pPerfilUsuario.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarMapa(?, ?)");
//             _comando.setObject(1, pPerfilUsuario.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<PerfilUsuario> ListarPerfilUsuario() throws SQLException
//    {
//        ArrayList<PerfilUsuario> _listaPerfilUsuario = new ArrayList<PerfilUsuario>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spObtenerListadoPerfilUsuario");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 PerfilUsuario p = new PerfilUsuario();
//                 
//                 p.setId(_resultado.getInt(3));
//                 //p.setTipoPerfil(DatosTipoPerfil.BuscarTipoPerfilPorId(_resultado.getInt(4)));
//                 p.setNombre(_resultado.getString(5));
//                 p.setDescripcion(_resultado.getString(6));
//                 p.setFecha_hecho(_resultado.getDate(7));
//                 p.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaPerfilUsuario.add(p);            
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
//        return _listaPerfilUsuario;
//        
//    }
//    
//    
//    public ArrayList<PerfilUsuario> BuscarPerfilUsuarioPorId(int pIdUsuario, int pIdPerfilUsuario) throws SQLException
//    {
//        ArrayList<PerfilUsuario> _listaPerfilUsuario = new ArrayList<PerfilUsuario>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spObtenerListadoPerfilUsuarioPorId(?)");
//             _comando.setObject(1, pIdPerfilUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _resultado = _comando.executeQuery();
//            
//             while(_resultado.next())
//             {
//                PerfilUsuario p = new PerfilUsuario();
//                 
//                 p.setId(_resultado.getInt(3));
//                 //p.setTipoPerfil(DatosTipoPerfil.BuscarTipoPerfilPorId(_resultado.getInt(4)));
//                 p.setNombre(_resultado.getString(5));
//                 p.setDescripcion(_resultado.getString(6));
//                 p.setFecha_hecho(_resultado.getDate(7));
//                 p.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaPerfilUsuario.add(p);           
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
//        return _listaPerfilUsuario;
//        
//    }
//    
//    public ArrayList<PerfilUsuario> ListarPerfilUsuarioEliminados() throws SQLException
//    {
//        ArrayList<PerfilUsuario> _listaPerfilUsuario = new ArrayList<PerfilUsuario>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoPerfilUsuarioEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 PerfilUsuario p = new PerfilUsuario();
//                 
//                 p.setId(_resultado.getInt(3));
//                 //p.setTipoPerfil(DatosTipoPerfil.BuscarTipoPerfilPorId(_resultado.getInt(4)));
//                 p.setNombre(_resultado.getString(5));
//                 p.setDescripcion(_resultado.getString(6));
//                 p.setFecha_hecho(_resultado.getDate(7));
//                 p.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaPerfilUsuario.add(p);                
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
//        return _listaPerfilUsuario;
//        
//    }
//    
//    public int ReingresarPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarPerfilUsuario(?)");
//             _comando.setObject(1, pPerfilUsuario.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarPerfilUsuarioDefinitivo(int pIdUsuario, PerfilUsuario pPerfilUsuario) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarPerfilUsuarioDefinitivo(?)");
//             _comando.setObject(1, pPerfilUsuario.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
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
//    public int EliminarListaPerfilUsuarioDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaPerfilUsuarioDefinitivo");
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
    public int AltaPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PerfilUsuario> ListarPerfilUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PerfilUsuario> BuscarPerfilUsuarioPorId(int pIdUsuario, int pIdPerfilUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PerfilUsuario> ListarPerfilUsuarioEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarPerfilUsuarioDefinitivo(int pIdUsuario, PerfilUsuario pPerfilUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaPerfilUsuarioDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
