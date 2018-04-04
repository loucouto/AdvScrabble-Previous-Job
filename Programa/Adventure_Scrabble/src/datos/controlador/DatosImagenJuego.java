/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosImagenJuego;
import datos.util.DatosConstantes;
import entidades_compartidas.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public class DatosImagenJuego implements IDatosImagenJuego {
    
    public DatosImagenJuego()
    {
    
    }
    
//    public int AltaImagenJuego(ImagenJuego pImagenJuego) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaImagenJuego(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pImagenJuego.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pImagenJuego.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pImagenJuego.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pImagenJuego.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pImagenJuego.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarImagenJuego(ImagenJuego pImagenJuego) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarImagenJuego(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pImagenJuego.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pImagenJuego.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pImagenJuego.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pImagenJuego.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pImagenJuego.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pImagenJuego.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaImagenJuego(ImagenJuego pImagenJuego) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarImagenJuego(?)");
//             _comando.setObject(1, pImagenJuego.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<ImagenJuego> ListarImagenJuego() throws SQLException
//    {
//        ArrayList<ImagenJuego> _listaImagenJuego = new ArrayList<ImagenJuego>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spObtenerListadoImagenJuego");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 ImagenJuego i = new ImagenJuego();
//                 
//                 i.setId(_resultado.getInt(2));
//                 i.setNombre(_resultado.getString(3));
//                 i.setDescripcion(_resultado.getString(4));
//                 i.setUbicacion(_resultado.getString(5));
//                 i.setArchivo(_resultado.getString(6));
//                 i.setFecha_hecho(_resultado.getDate(7));
//                 i.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaImagenJuego.add(i);            
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
//        return _listaImagenJuego;
//        
//    }
//    
//    
//    public ArrayList<ImagenJuego> BuscarImagenJuegoPorId(int pIdImagenJuego) throws SQLException
//    {
//        ArrayList<ImagenJuego> _listaImagenJuego = new ArrayList<ImagenJuego>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spObtenerListadoImagenJuegoPorId(?)");
//             _comando.setObject(1, pIdImagenJuego, java.sql.Types.INTEGER);
//             _resultado = _comando.executeQuery();
//            
//             
//             while(_resultado.next())
//             {
//                 ImagenJuego i = new ImagenJuego();
//                 
//                 i.setId(_resultado.getInt(2));
//                 i.setNombre(_resultado.getString(3));
//                 i.setDescripcion(_resultado.getString(4));
//                 i.setUbicacion(_resultado.getString(5));
//                 i.setArchivo(_resultado.getString(6));
//                 i.setFecha_hecho(_resultado.getDate(7));
//                 i.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaImagenJuego.add(i);            
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
//        return _listaImagenJuego;
//        
//    }
//    
//    public ArrayList<ImagenJuego> ListarImagenJuegoEliminados() throws SQLException
//    {
//        ArrayList<ImagenJuego> _listaImagenJuego = new ArrayList<ImagenJuego>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoImagenJuegoEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                ImagenJuego i = new ImagenJuego();
//                 
//                 i.setId(_resultado.getInt(2));
//                 i.setNombre(_resultado.getString(3));
//                 i.setDescripcion(_resultado.getString(4));
//                 i.setUbicacion(_resultado.getString(5));
//                 i.setArchivo(_resultado.getString(6));
//                 i.setFecha_hecho(_resultado.getDate(7));
//                 i.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaImagenJuego.add(i);           
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
//        return _listaImagenJuego;
//        
//    }
//    
//    public int ReingresarImagenJuego(ImagenJuego pImagenJuego) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarImagenJuego(?)");
//             _comando.setObject(1, pImagenJuego.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarImagenJuegoDefinitivo(ImagenJuego pImagenJuego) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarImagenJuegoDefinitivo(?)");
//             _comando.setObject(1, pImagenJuego.getNombre(), java.sql.Types.VARCHAR);
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
//    public int EliminarListaImagenJuegoDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaImagenJueogDefinitivo");
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
    public int AltaImagenJuego(ImagenJuego pImagenJuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarImagenJuego(ImagenJuego pImagenJuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaImagenJuego(ImagenJuego pImagenJuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ImagenJuego> ListarImagenJuego() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ImagenJuego> BuscarImagenJuegoPorId(int pIdImagenJuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ImagenJuego> ListarImagenJuegoEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarImagenJuego(ImagenJuego pImagenJuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarImagenJuegoDefinitivo(ImagenJuego pImagenJuego) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaImagenJuegoDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
