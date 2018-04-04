/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosTipoPermiso;
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
public class DatosTipoPermiso implements IDatosTipoPermiso{
    
    public DatosTipoPermiso()
    {
    
    }
    
    @Override
    public int AltaTipoPermiso(TipoPermiso pTipoPermiso) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spAltaTipoPermiso(?, ?, ?, ?)");
             _comando.setObject(1, pTipoPermiso.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(2, pTipoPermiso.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(3, pTipoPermiso.getDesc_abreviada(), java.sql.Types.VARCHAR);
             _comando.setObject(4, pTipoPermiso.getFecha_hecho(), java.sql.Types.DATE);
             
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
                        Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
    }

    @Override
    public int ModificarTipoPermiso(TipoPermiso pTipoPermiso) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spModificarTipoPermiso(?, ?, ?, ?, ?)");
             _comando.setObject(1, pTipoPermiso.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pTipoPermiso.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(3, pTipoPermiso.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(4, pTipoPermiso.getDesc_abreviada(), java.sql.Types.VARCHAR);
             _comando.setObject(5, pTipoPermiso.getFecha_hecho(), java.sql.Types.DATE);
             
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
                        Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }

    @Override
    public int BajaTipoPermiso(TipoPermiso pTipoPermiso) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarTipoPermiso(?)");
             _comando.setObject(1, pTipoPermiso.getId(), java.sql.Types.INTEGER);
            
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
                        Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }

    @Override
    public ArrayList<TipoPermiso> ListarTipoPermiso() {
        ArrayList<TipoPermiso> _listaTipoPermiso = new ArrayList<TipoPermiso>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoTipoPermiso()");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 TipoPermiso t = new TipoPermiso();
                 
                 t.setId(_resultado.getInt(1));
                 t.setNombre(_resultado.getString(2));
                 t.setDescripcion(_resultado.getString(3));
                 t.setDesc_abreviada(_resultado.getString(4));
                 t.setFecha_hecho(_resultado.getDate(5));
                 t.setFecha_baja(_resultado.getDate(6));
                 
                 _listaTipoPermiso.add(t);         
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
                       Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _listaTipoPermiso;
    }

    
    
    @Override
    public ArrayList<TipoPermiso> ListarTipoPermisoEliminados() {
                ArrayList<TipoPermiso> _listaTipoPermiso = new ArrayList<TipoPermiso>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoTipoPermisoEliminados()");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 TipoPermiso t = new TipoPermiso();
                 
                 t.setId(_resultado.getInt(1));
                 t.setNombre(_resultado.getString(2));
                 t.setDescripcion(_resultado.getString(3));
                 t.setDesc_abreviada(_resultado.getString(4));
                 t.setFecha_hecho(_resultado.getDate(5));
                 t.setFecha_baja(_resultado.getDate(6));
                 
                 _listaTipoPermiso.add(t);                
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
                        Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _listaTipoPermiso;
        
    }

    @Override
    public int ReingresarTipoPermiso(TipoPermiso pTipoPermiso) {
               boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spReingresarTipoPermiso(?)");
             _comando.setObject(1, pTipoPermiso.getId(), java.sql.Types.INTEGER);
             
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
                       Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _resultado;
        
    }

    @Override
    public int EliminarTipoPermisoDefinitivo(TipoPermiso pTipoPermiso) {

        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarTipoPermisoDefinitivo(?)");
             _comando.setObject(1, pTipoPermiso.getId(), java.sql.Types.VARCHAR);
             
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
                       Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
       
        return _resultado;
        
    }

    @Override
    public int EliminarListaTipoPermisoDefinitivo() {
            
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarListaTipoPermisoDefinitivo()");
             
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
                       Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _resultado;
        
    }

    @Override
    public TipoPermiso BuscarTipoPermisoPorId(int pIdTipoPermiso) {
              TipoPermiso _tipoPermiso = null;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoTipoPermisoPorId(?)");
             _comando.setObject(1, pIdTipoPermiso, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             { 
                 _tipoPermiso = new TipoPermiso();
                 
                 _tipoPermiso.setId(_resultado.getInt(1));
                 _tipoPermiso.setNombre(_resultado.getString(2));
                 _tipoPermiso.setDescripcion(_resultado.getString(3));
                 _tipoPermiso.setDesc_abreviada(_resultado.getString(4));
                 _tipoPermiso.setFecha_hecho(_resultado.getDate(5));
                 _tipoPermiso.setFecha_baja(_resultado.getDate(6));
                         
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
                        Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _tipoPermiso;
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
             _comando = _conexion.prepareCall("call spVerSiguienteIdTipoPermiso()");
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


    @Override
    public TipoPermiso BuscarTipoPermisoEliminadosPorId(int pIdTipoPermiso) {
            TipoPermiso _tipoPermiso = null;

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTipoPermisoEliminadosPorId(?)");
                 _comando.setObject(1, pIdTipoPermiso, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 { 
                     _tipoPermiso = new TipoPermiso();
                     
                     _tipoPermiso.setId(_resultado.getInt(1));
                     _tipoPermiso.setNombre(_resultado.getString(2));
                     _tipoPermiso.setDescripcion(_resultado.getString(3));
                     _tipoPermiso.setDesc_abreviada(_resultado.getString(4));
                     _tipoPermiso.setFecha_hecho(_resultado.getDate(5));
                     _tipoPermiso.setFecha_baja(_resultado.getDate(6));
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
                            Logger.getLogger(DatosTipoPermiso.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }

            return _tipoPermiso;
    }
    
    
    
}
