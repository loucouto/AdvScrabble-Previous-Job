/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosPermisoFuncionalidad;
import datos.util.DatosConstantes;
import entidades_compartidas.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class DatosPermisoFuncionalidad implements IDatosPermisoFuncionalidad{
    
    public DatosPermisoFuncionalidad()
    {
    
    }
    
    @Override
    public int AltaPermisoFuncionalidad(int pIdFuncionalidad, int pIdSubFuncionalidad, int pIdTipoPermiso, PermisoFuncionalidad pPermisoFuncionalidad) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spAltaPermisoFuncionalidad(?, ?, ?, ?, ?, ?, ?, ?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(2, pIdSubFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(3, pPermisoFuncionalidad.getTipo_permiso().getId(), java.sql.Types.INTEGER);
             _comando.setObject(4, pIdTipoPermiso, java.sql.Types.INTEGER);
             _comando.setObject(5, pPermisoFuncionalidad.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(6, pPermisoFuncionalidad.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(7, pPermisoFuncionalidad.getFecha_hecho(), java.sql.Types.DATE);
             
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
                Logger.getLogger(DatosPermisoFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
        
    }

    @Override
    public int ModificarPermisoFuncionalidad(int pIdFuncionalidad, int pIdSubFuncionalidad, int pIdTipoPermiso, PermisoFuncionalidad pPermisoFuncionalidad) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spModificarPermisoFuncionalidad(?, ?, ?, ?, ?, ?, ?, ?)");
             _comando.setObject(1, pPermisoFuncionalidad.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdSubFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(4, pPermisoFuncionalidad.getTipo_permiso().getId(), java.sql.Types.INTEGER);
             _comando.setObject(5, pIdTipoPermiso, java.sql.Types.INTEGER);
             _comando.setObject(6, pPermisoFuncionalidad.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(7, pPermisoFuncionalidad.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(8, pPermisoFuncionalidad.getFecha_hecho(), java.sql.Types.DATE);
             
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
                Logger.getLogger(DatosPermisoFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
    }

    @Override
    public int BajaPermisoFuncionalidad(int pIdFuncionalidad, int pIdSubFuncionalidad, int pIdTipoPermiso, PermisoFuncionalidad pPermisoFuncionalidad) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarPermisoFuncionalidad(?, ?, ?, ?)");
             _comando.setObject(1, pPermisoFuncionalidad.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdSubFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(4, pPermisoFuncionalidad.getTipo_permiso().getId(), java.sql.Types.INTEGER);
            
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
                Logger.getLogger(DatosPermisoFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
    }

    @Override
    public ArrayList<PermisoFuncionalidad> ListarPermisoFuncionalidad() {
        ArrayList<PermisoFuncionalidad> _listaPermisoFuncionalidad = new ArrayList<PermisoFuncionalidad>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoPermisoFuncionalidad");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 PermisoFuncionalidad p = new PermisoFuncionalidad();
                 
                 p.setId(_resultado.getInt(4));
                 //p.setTipoPermiso(DatosPermisoFuncionalidad(_resultado.getInt(5)));
                 
                 p.setNombre(_resultado.getString(7));
                 p.setDescripcion(_resultado.getString(8));
                 p.setFecha_hecho(_resultado.getDate(9));
                 p.setFecha_baja(_resultado.getDate(10));
                 
                 _listaPermisoFuncionalidad.add(p);            
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
                Logger.getLogger(DatosPermisoFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _listaPermisoFuncionalidad;
    }

    @Override
    public ArrayList<PermisoFuncionalidad> BuscarPermisoFuncionalidadPorId(int pIdFuncionalidad, int pIdSubFuncionalidad, int pIdTipoPermiso, int pIdPermisoFuncionalidad) {
        ArrayList<PermisoFuncionalidad> _listaPermisoFuncionalidad = new ArrayList<PermisoFuncionalidad>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoMapaPorId(?)");
             _comando.setObject(1, pIdPermisoFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(2, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdSubFuncionalidad, java.sql.Types.INTEGER);
           
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
                 PermisoFuncionalidad p = new PermisoFuncionalidad();
                 
                 p.setId(_resultado.getInt(4));
                 //p.setTipoPermiso(DatosPermisoFuncionalidad(_resultado.getInt(5)));
                 
                 p.setNombre(_resultado.getString(7));
                 p.setDescripcion(_resultado.getString(8));
                 p.setFecha_hecho(_resultado.getDate(9));
                 p.setFecha_baja(_resultado.getDate(10));
                 
                 _listaPermisoFuncionalidad.add(p);               
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
                Logger.getLogger(DatosPermisoFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _listaPermisoFuncionalidad;
    }

    @Override
    public ArrayList<PermisoFuncionalidad> ListarPermisoFuncionalidadEliminados() {
        ArrayList<PermisoFuncionalidad> _listaPermisoFuncionalidad = new ArrayList<PermisoFuncionalidad>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("spObtenerListadoPermisoFuncionalidadEliminados");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 PermisoFuncionalidad p = new PermisoFuncionalidad();
                 
                 p.setId(_resultado.getInt(4));
                 //p.setTipoPermiso(DatosPermisoFuncionalidad(_resultado.getInt(5)));
                 
                 p.setNombre(_resultado.getString(7));
                 p.setDescripcion(_resultado.getString(8));
                 p.setFecha_hecho(_resultado.getDate(9));
                 p.setFecha_baja(_resultado.getDate(10));
                 
                 _listaPermisoFuncionalidad.add(p);            
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
                Logger.getLogger(DatosPermisoFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _listaPermisoFuncionalidad;
        
    }

    @Override
    public int ReingresarPermisoFuncionalidad(int pIdFuncionalidad, int pIdSubFuncionalidad, PermisoFuncionalidad pPermisoFuncionalidad) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spReingresarMapa(?)");
             _comando.setObject(1, pPermisoFuncionalidad.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdSubFuncionalidad, java.sql.Types.INTEGER);
           
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
                Logger.getLogger(DatosPermisoFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
        
    }

    @Override
    public int EliminarPermisoFuncionalidadDefinitivo(int pIdFuncionalidad, int pIdSubFuncionalidad, PermisoFuncionalidad pPermisoFuncionalidad) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarMapaDefinitivo(?)");
             _comando.setObject(1, pPermisoFuncionalidad.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdSubFuncionalidad, java.sql.Types.INTEGER);
           
             /*_comando.registerOutParameter(6, java.sql.Types.INTEGER);*/
             
            
             _retorno = _comando.execute();
             _resultado = _comando.getInt("pId");
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
                Logger.getLogger(DatosPermisoFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
        
    }

    @Override
    public int EliminarListaPermisoFuncionalidadDefinitivo() {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarListaPermisoFuncionalidadDefinitivo");
            /* _comando.registerOutParameter(6, java.sql.Types.INTEGER);*/
             
             _retorno = _comando.execute();
             _resultado = _comando.getInt("pId");
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
                Logger.getLogger(DatosPermisoFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
        
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
             _comando = _conexion.prepareCall("call spVerSiguienteIdFuncionalidad()");
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
    public PermisoFuncionalidad BuscarPermisoFuncionalidadPorIdEliminados(int pIdFuncionalidad, int pIdSubFuncionalidad, int pIdTipoPermiso, int pIdPermisoFuncionalidad) {
        PermisoFuncionalidad  _permiso_funcionalidad = null;
               
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoFuncionalidadEliminadosPorId(?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
                _permiso_funcionalidad = new PermisoFuncionalidad();
                 
                 _permiso_funcionalidad.setId(_resultado.getInt(2));
                 _permiso_funcionalidad.setNombre(_resultado.getString(3));
                 _permiso_funcionalidad.setDescripcion(_resultado.getString(4));
                 _permiso_funcionalidad.setFecha_hecho(_resultado.getDate(5));
                 _permiso_funcionalidad.setFecha_baja(_resultado.getDate(6));
                // _permiso_funcionalidad.setSub_funcionalidad(new DatosSubFuncionalidad().ListarSubFuncionalidadEliminadosPorId(pIdFuncionalidad));
                                   
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
        
        return _permiso_funcionalidad;
    }
 
    
    
}
