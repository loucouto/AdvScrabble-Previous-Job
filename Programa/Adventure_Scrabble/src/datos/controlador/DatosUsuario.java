/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosUsuario;
import datos.util.DatosConstantes;
import entidades_compartidas.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class DatosUsuario implements IDatosUsuario {
    
    public DatosUsuario()
    {
    
    }
    
    @Override
    public int AltaUsuario(Usuario pUsuario) {
       
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spAltaUsuario(?, ?, ?, ?, ?, ?, ?)");
             _comando.setObject(1, pUsuario.getNombre_completo(), java.sql.Types.VARCHAR);
             _comando.setObject(2, pUsuario.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(3, pUsuario.getUbicacion(), java.sql.Types.VARCHAR);
             _comando.setObject(4, pUsuario.getArchivo(), java.sql.Types.VARCHAR);
             _comando.setObject(5, pUsuario.getContrasenia(), java.sql.Types.VARCHAR);
             _comando.setObject(6, pUsuario.getNombre_usuario(), java.sql.Types.VARCHAR);
             _comando.setObject(7, pUsuario.getFecha_hecho(), java.sql.Types.DATE);
             
             _resultado = _comando.executeUpdate();
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
                Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
    }

    @Override
    public int ModificarUsuario(Usuario pUsuario) {
            boolean _retorno = false;

            int _resultado = 0;

            Connection _conexion = null;
            CallableStatement _comando = null;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spModificarUsuario(?, ?, ?, ?, ?, ?, ?, ?)");
                 _comando.setObject(1, pUsuario.getId(), java.sql.Types.INTEGER);
                 _comando.setObject(2, pUsuario.getNombre_completo(), java.sql.Types.VARCHAR);
                 _comando.setObject(3, pUsuario.getDescripcion(), java.sql.Types.VARCHAR);
                 _comando.setObject(4, pUsuario.getUbicacion(), java.sql.Types.VARCHAR);
                 _comando.setObject(5, pUsuario.getArchivo(), java.sql.Types.VARCHAR);
                 _comando.setObject(6, pUsuario.getContrasenia(), java.sql.Types.VARCHAR);
                 _comando.setObject(7, pUsuario.getNombre_usuario(), java.sql.Types.VARCHAR);
                 _comando.setObject(8, pUsuario.getFecha_hecho(), java.sql.Types.DATE);

                 _resultado = _comando.executeUpdate();

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
                    Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _resultado;

    }

    @Override
    public int BajaUsuario(Usuario pUsuario) {
            boolean _retorno = false;

            int _resultado = 0;

            Connection _conexion = null;
            CallableStatement _comando = null;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spEliminarUsuario(?)");
                 _comando.setObject(1, pUsuario.getId(), java.sql.Types.INTEGER);

                 _resultado = _comando.executeUpdate();

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
                    Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _resultado;

    }

    @Override
    public ArrayList<Usuario> ListarUsuario() {
    ArrayList<Usuario> _listaUsuario = new ArrayList<Usuario>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoUsuario()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     Usuario u = new Usuario();

                     u.setId(_resultado.getInt(2));
                     u.setNombre_usuario(_resultado.getString(3));
                     u.setDescripcion(_resultado.getString(4));
                     u.setUbicacion(_resultado.getString(5));
                     u.setArchivo(_resultado.getString(6));
                     u.setContrasenia(_resultado.getString(7));
                     u.setNombre_usuario(_resultado.getString(8));
                     u.setFecha_hecho(_resultado.getDate(9));
                     u.setFecha_baja(_resultado.getDate(10));

                     _listaUsuario.add(u);

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
                    Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _listaUsuario;
    }

    @Override
    public Usuario BuscarUsuarioPorId(int pIdUsuario) {
            
            Usuario u = null;

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoUsuarioPorId(?)");
                 _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();


                 while(_resultado.next())
                 {
                     u = new Usuario();

                     u.setId(_resultado.getInt(2));
                     u.setNombre_usuario(_resultado.getString(3));
                     u.setDescripcion(_resultado.getString(4));
                     u.setUbicacion(_resultado.getString(5));
                     u.setArchivo(_resultado.getString(6));
                     u.setContrasenia(_resultado.getString(7));
                     u.setNombre_usuario(_resultado.getString(8));
                     u.setFecha_hecho(_resultado.getDate(9));
                     u.setFecha_baja(_resultado.getDate(10));

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
                    Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return u;
    }

    @Override
    public ArrayList<Usuario> ListarUsuarioEliminados() {
            ArrayList<Usuario> _listaUsuario = new ArrayList<Usuario>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoUsuarioEliminados()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                   Usuario u = new Usuario();

                     u.setId(_resultado.getInt(2));
                     u.setNombre_usuario(_resultado.getString(3));
                     u.setDescripcion(_resultado.getString(4));
                     u.setUbicacion(_resultado.getString(5));
                     u.setArchivo(_resultado.getString(6));
                     u.setContrasenia(_resultado.getString(7));
                     u.setNombre_usuario(_resultado.getString(8));
                     u.setFecha_hecho(_resultado.getDate(9));
                     u.setFecha_baja(_resultado.getDate(10));

                     _listaUsuario.add(u);    
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
                    Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _listaUsuario;

    }

    @Override
    public int ReingresarUsuario(Usuario pUsuario) {
            boolean _retorno = false;

            int _resultado = 0;

            Connection _conexion = null;
            CallableStatement _comando = null;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spReingresarUsuario(?)");
                 _comando.setObject(1, pUsuario.getId(), java.sql.Types.INTEGER);

                 _resultado = _comando.executeUpdate();

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
                    Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _resultado;

    }

    @Override
    public int EliminarUsuarioDefinitivo(Usuario pUsuario) {
    
            int _resultado = 0;

            Connection _conexion = null;
            CallableStatement _comando = null;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spEliminarUsuarioDefinitivo(?)");
                 _comando.setObject(1, pUsuario.getId(), java.sql.Types.VARCHAR);
                 
                 _resultado = _comando.executeUpdate();
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
                    Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _resultado;
    }

    @Override
    public int EliminarListaUsuarioDefinitivo() {
        
            int _resultado = 0;

            Connection _conexion = null;
            CallableStatement _comando = null;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spEliminarListaUsuarioDefinitivo()");

                  _resultado = _comando.executeUpdate();
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
                    Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _resultado;

    }

    @Override
    public Usuario BuscarUsuarioEliminadoPorId(int pIdUsuario) {
        Usuario _usuario = new Usuario();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoUsuarioEliminadosPorId(?)");
                 _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     _usuario = new Usuario();

                     _usuario.setId(_resultado.getInt(2));
                     _usuario.setNombre_usuario(_resultado.getString(3));
                     _usuario.setDescripcion(_resultado.getString(4));
                     _usuario.setUbicacion(_resultado.getString(5));
                     _usuario.setArchivo(_resultado.getString(6));
                     _usuario.setContrasenia(_resultado.getString(7));
                     _usuario.setNombre_usuario(_resultado.getString(8));
                     _usuario.setFecha_hecho(_resultado.getDate(9));
                     _usuario.setFecha_baja(_resultado.getDate(10));
                     
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
                    Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _usuario;
    }

    @Override
    public int VerSiguienteId() {
        int _retorno = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spVerSiguienteIdUsuario()");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 _retorno = _resultado.getInt(1);        
             }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DatosFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                    try {
                        _comando.close();
                        _conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DatosFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _retorno;
    }
    
}
