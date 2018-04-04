/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosTipoPerfil;
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
public class DatosTipoPerfil implements IDatosTipoPerfil {
    
    public DatosTipoPerfil()
    {
    
    }
    
    @Override
    public int AltaTipoPerfil(TipoPerfil pTipoPerfil) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spAltaTipoPerfil(?, ?, ?, ?, ?)");
             _comando.setObject(1, pTipoPerfil.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(2, pTipoPerfil.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(3, pTipoPerfil.getDesc_abreviada(), java.sql.Types.VARCHAR);
             _comando.setObject(4, pTipoPerfil.getFecha_hecho(), java.sql.Types.DATE);
              
              _resultado = _comando.executeUpdate();
             
////             if(_resultado > 0 && pTipoPerfil.getPermiso_funcionalidad().size() > 0)
////             {
////                 for(PermisoFuncionalidad sf : pTipoPerfil.getPermiso_funcionalidad())
////                 {
////                     _comando = null;
////                     _comando = _conexion.prepareCall("call spAltaPermisoFuncionalidad(?, ?, ?, ?, ?, ?, ?, ?)");
////                     _comando.setObject(1, pTipoPerfil.getPermiso_funcionalidad(), java.sql.Types.INTEGER);
////                     _comando.setObject(2, pIdSubFuncionalidad, java.sql.Types.INTEGER);
////                     _comando.setObject(3, pPermisoFuncionalidad.getTipo_permiso().getId(), java.sql.Types.INTEGER);
////                     _comando.setObject(4, pIdTipoPermiso, java.sql.Types.INTEGER);
////                     _comando.setObject(5, pPermisoFuncionalidad.getNombre(), java.sql.Types.VARCHAR);
////                     _comando.setObject(6, pPermisoFuncionalidad.getDescripcion(), java.sql.Types.VARCHAR);
////                     _comando.setObject(7, pPermisoFuncionalidad.getFecha_hecho(), java.sql.Types.DATE);
////                     
////                     _resultado = _comando.executeUpdate();
////                 }
////             }
             
             _conexion.commit();
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
                Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
    }

    @Override
    public int ModificarTipoPerfil(TipoPerfil pTipoPerfil) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spModificarTipoPerfil(?, ?, ?, ?, ?)");
             _comando.setObject(1, pTipoPerfil.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pTipoPerfil.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(3, pTipoPerfil.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(4, pTipoPerfil.getDesc_abreviada(), java.sql.Types.VARCHAR);
             _comando.setObject(5, pTipoPerfil.getFecha_hecho(), java.sql.Types.DATE);
             
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
                Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
        
    }

    @Override
    public int BajaTipoPerfil(TipoPerfil pTipoPerfil) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarTipoPerfil(?)");
             _comando.setObject(1, pTipoPerfil.getId(), java.sql.Types.INTEGER);
            
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
                Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
        
    }

    @Override
    public ArrayList<TipoPerfil> ListarTipoPerfil() {
        ArrayList<TipoPerfil> _listaTipoPerfil = new ArrayList<TipoPerfil>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoTipoPerfil");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 TipoPerfil t = new TipoPerfil();
                 
                 t.setId(_resultado.getInt(1));
                 t.setNombre(_resultado.getString(2));
                 t.setDescripcion(_resultado.getString(3));
                 t.setDesc_abreviada(_resultado.getString(4));
                 t.setFecha_hecho(_resultado.getDate(5));
                 t.setFecha_baja(_resultado.getDate(6));
                 
                 _listaTipoPerfil.add(t);            
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
                Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _listaTipoPerfil;
    }

    @Override
    public TipoPerfil BuscarTipoPerfilPorId(int pIdTipoPerfil) {
      TipoPerfil _tipoPerfil = null;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoTipoPerfilPorId(?)");
             _comando.setObject(1, pIdTipoPerfil, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
                
             while(_resultado.next())
             {
                _tipoPerfil = new TipoPerfil();
                 
                 _tipoPerfil.setId(_resultado.getInt(1));
                 _tipoPerfil.setNombre(_resultado.getString(2));
                 _tipoPerfil.setDescripcion(_resultado.getString(3));
                 _tipoPerfil.setDesc_abreviada(_resultado.getString(4));
                 _tipoPerfil.setFecha_hecho(_resultado.getDate(5));
                 _tipoPerfil.setFecha_baja(_resultado.getDate(6));
                  
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
              Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        return _tipoPerfil;
    }

    @Override
    public ArrayList<TipoPerfil> ListarTipoPerfilEliminados() {
        ArrayList<TipoPerfil> _listaTipoPerfil = new ArrayList<TipoPerfil>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoTipoPerfilEliminados()");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
               TipoPerfil t = new TipoPerfil();
                 
                 t.setId(_resultado.getInt(1));
                 t.setNombre(_resultado.getString(2));
                 t.setDescripcion(_resultado.getString(3));
                 t.setDesc_abreviada(_resultado.getString(4));
                 t.setFecha_hecho(_resultado.getDate(5));
                 t.setFecha_baja(_resultado.getDate(6));
                 
                 _listaTipoPerfil.add(t);            
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
                Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _listaTipoPerfil;
        
    }

    @Override
    public int ReingresarTipoPerfil(TipoPerfil pTipoPerfil) {
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spReingresarTipoPerfil(?)");
             _comando.setObject(1, pTipoPerfil.getId(), java.sql.Types.INTEGER);
             
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
                Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
        
    }

    @Override
    public int EliminarTipoPerfliDefinitivo(TipoPerfil pTipoPerfil) {
      
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarTipoPerfilDefinitivo(?)");
             _comando.setObject(1, pTipoPerfil.getId(), java.sql.Types.INTEGER);
             
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
                Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
    }

    @Override
    public int EliminarListaTipoPerfilDefinitivo() {
            boolean _retorno = false;

            int _resultado = 0;

            Connection _conexion = null;
            CallableStatement _comando = null;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spEliminarListaTipoPerfilDefinitivo()");
                
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
                    Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _resultado;
    }

    @Override
    public TipoPerfil BuscarTipoPerfilEliminadoPorId(int pIdTipoPerfil) {
         TipoPerfil _tipoPerfil = null;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoTipoPerfilEliminadosPorId(?)");
             _comando.setObject(1, pIdTipoPerfil, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
                
             while(_resultado.next())
             {
                _tipoPerfil = new TipoPerfil();
                 
                 _tipoPerfil.setId(_resultado.getInt(1));
                 _tipoPerfil.setNombre(_resultado.getString(2));
                 _tipoPerfil.setDescripcion(_resultado.getString(3));
                 _tipoPerfil.setDesc_abreviada(_resultado.getString(4));
                 _tipoPerfil.setFecha_hecho(_resultado.getDate(5));
                 _tipoPerfil.setFecha_baja(_resultado.getDate(6));
                  
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
                  Logger.getLogger(DatosTipoPerfil.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
        
        return _tipoPerfil;
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
             _comando = _conexion.prepareCall("call spVerSiguienteIdTipoPerfil()");
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
