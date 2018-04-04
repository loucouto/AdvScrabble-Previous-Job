/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosImagenMapa;
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
public class DatosImagenMapa implements IDatosImagenMapa {
    
    public DatosImagenMapa()
    {
    
    }
    
//    public int AltaImagenMapa(ImagenMapa pImagenMapa, int pIdMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaImagenMapa(?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pImagenMapa.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pImagenMapa.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pImagenMapa.getUbicacion_imagen(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pImagenMapa.getArchivo_imagen(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pImagenMapa.getUbicacion_texto(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pImagenMapa.getArchivo_texto(), java.sql.Types.VARCHAR);
//             _comando.setObject(8, pImagenMapa.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(9, java.sql.Types.INTEGER);
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
//    public int ModificarImagenMapa(ImagenMapa pImagenMapa, int pIdMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarMapa(?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pImagenMapa.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pImagenMapa.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pImagenMapa.getUbicacion_imagen(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pImagenMapa.getArchivo_imagen(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pImagenMapa.getUbicacion_texto(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pImagenMapa.getArchivo_texto(), java.sql.Types.VARCHAR);
//             _comando.setObject(8, pImagenMapa.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaImagenMapa(ImagenMapa pImagenMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarImagenMapa(?, ?)");
//             _comando.setObject(1, pImagenMapa.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<ImagenMapa> ListarImagenMapa() throws SQLException
//    {
//        ArrayList<ImagenMapa> _listaImagenMapa = new ArrayList<ImagenMapa>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spObtenerListadoImagenMapa");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 ImagenMapa im = new ImagenMapa();
//                 
//                 im.setId(_resultado.getInt(2));
//                 im.setNombre(_resultado.getString(3));
//                 im.setDescripcion(_resultado.getString(4));
//                 im.setUbicacion_imagen(_resultado.getString(5));
//                 im.setArchivo_imagen(_resultado.getString(6));
//                 im.setUbicacion_texto(_resultado.getString(5));
//                 im.setArchivo_texto(_resultado.getString(6));
//                 im.setFecha_hecho(_resultado.getDate(7));
//                 im.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaImagenMapa.add(im);            
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
//        return _listaImagenMapa;
//    }
//    
//    
//    public ArrayList<ImagenMapa> BuscarImagenMapaPorId(int pIdImagenMapa, int pIdMapa) throws SQLException
//    {
//        ArrayList<ImagenMapa> _listaImagenMapa = new ArrayList<ImagenMapa>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spObtenerListadoImagenMapaPorId(?,?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(1, pIdImagenMapa, java.sql.Types.INTEGER);
//             _resultado = _comando.executeQuery();
//            
//             
//             while(_resultado.next())
//             {
//                ImagenMapa im = new ImagenMapa();
//                 
//                 im.setId(_resultado.getInt(2));
//                 im.setNombre(_resultado.getString(3));
//                 im.setDescripcion(_resultado.getString(4));
//                 im.setUbicacion_imagen(_resultado.getString(5));
//                 im.setArchivo_imagen(_resultado.getString(6));
//                 im.setUbicacion_texto(_resultado.getString(5));
//                 im.setArchivo_texto(_resultado.getString(6));
//                 im.setFecha_hecho(_resultado.getDate(7));
//                 im.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaImagenMapa.add(im);                
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
//        return _listaImagenMapa;
//        
//    }
//    
//    public ArrayList<ImagenMapa> ListarImagenMapaEliminados() throws SQLException
//    {
//         ArrayList<ImagenMapa> _listaImagenMapa = new ArrayList<ImagenMapa>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spObtenerListadoImagenMapasEliminados");
//             _resultado = _comando.executeQuery();
//            
//             
//             while(_resultado.next())
//             {
//                ImagenMapa im = new ImagenMapa();
//                 
//                 im.setId(_resultado.getInt(2));
//                 im.setNombre(_resultado.getString(3));
//                 im.setDescripcion(_resultado.getString(4));
//                 im.setUbicacion_imagen(_resultado.getString(5));
//                 im.setArchivo_imagen(_resultado.getString(6));
//                 im.setUbicacion_texto(_resultado.getString(5));
//                 im.setArchivo_texto(_resultado.getString(6));
//                 im.setFecha_hecho(_resultado.getDate(7));
//                 im.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaImagenMapa.add(im);                
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
//        return _listaImagenMapa;
//    }
//    
//    public int ReingresarImagenMapa(Mapa pImagenMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarImagenMapa(?)");
//             _comando.setObject(1, pImagenMapa.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarImagenMapaDefinitivo(int pIdMapa, ImagenMapa pImagenMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarImagenMapaDefinitivo(?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pImagenMapa.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarListaImagenMapaDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaImagenMapaDefinitivo");
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
    public int AltaImagenMapa(ImagenMapa pImagenMapa, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarImagenMapa(ImagenMapa pImagenMapa, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaImagenMapa(ImagenMapa pImagenMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ImagenMapa> ListarImagenMapa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ImagenMapa> BuscarImagenMapaPorId(int pIdImagenMapa, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ImagenMapa> ListarImagenMapaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarImagenMapa(Mapa pImagenMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarImagenMapaDefinitivo(int pIdMapa, ImagenMapa pImagenMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaImagenMapaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
