/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosSubFuncionalidad;
import datos.util.DatosConstantes;
import entidades_compartidas.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class DatosSubFuncionalidad implements IDatosSubFuncionalidad {
        
    public DatosSubFuncionalidad()
    {
    
    }
   
    @Override
    public int AltaSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spAltaSubFuncionalidad(?, ?, ?, ?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(2, pSubFuncionalidad.getTitulo(), java.sql.Types.VARCHAR);
             _comando.setObject(3, pSubFuncionalidad.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(4, pSubFuncionalidad.getFecha_hecho(), java.sql.Types.DATE);
                
           _resultado = _comando.executeUpdate();
        }
        catch (Exception ex)
        {
           Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                    try {
                        _comando.close();
                        _conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }

    @Override
    public int ModificarSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spModificarSubFuncionalidad(?, ?, ?, ?, ?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(2, pSubFuncionalidad.getId(), java.sql.Types.INTEGER);
             _comando.setObject(3, pSubFuncionalidad.getTitulo(), java.sql.Types.VARCHAR);
             _comando.setObject(4, pSubFuncionalidad.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(5, pSubFuncionalidad.getFecha_hecho(), java.sql.Types.DATE);
             
             _resultado = _comando.executeUpdate();
            
        }
        catch (Exception ex)
        {
            Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                    try {
                        _comando.close();
                        _conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }

    @Override
    public int BajaSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarSubFuncionalidad(?, ?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(2, pSubFuncionalidad.getId(), java.sql.Types.INTEGER);
            
             _resultado = _comando.executeUpdate();
            
        }
        catch (Exception ex)
        {
            Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                    try {
                        _comando.close();
                        _conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }

    @Override
    public ArrayList<SubFuncionalidad> ListarSubFuncionalidad() {
                ArrayList<SubFuncionalidad> _listaSubFuncionalidad = new ArrayList<SubFuncionalidad>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoSubFuncionalidad()");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 SubFuncionalidad s = new SubFuncionalidad();
                 
                 s.setId(_resultado.getInt(3));
                 s.setTitulo(_resultado.getString(4));
                 s.setDescripcion(_resultado.getString(5));
                 s.setFecha_hecho(_resultado.getDate(6));
                 s.setFecha_baja(_resultado.getDate(7));
                 
                 _listaSubFuncionalidad.add(s);            
             }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                    try {
                        _comando.close();
                        _conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _listaSubFuncionalidad;
        
    }

    @Override
    public SubFuncionalidad BuscarSubFuncionalidadPorId(int pIdFuncionalidad, int pIdSubFuncionalidad) {
         SubFuncionalidad _sub_funcionalidad = new SubFuncionalidad();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoSubFuncionalidadPorId(?, ?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(2, pIdSubFuncionalidad, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
            
                 _sub_funcionalidad.setId(_resultado.getInt(3));
                 _sub_funcionalidad.setTitulo(_resultado.getString(4));
                 _sub_funcionalidad.setDescripcion(_resultado.getString(5));
                 _sub_funcionalidad.setFecha_hecho(_resultado.getDate(6));
                 _sub_funcionalidad.setFecha_baja(_resultado.getDate(7));
          
             }
        }
        catch (Exception ex)
        {
           Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                   try {
                       _comando.close();
                       _conexion.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _sub_funcionalidad;
        
    }

    @Override
    public ArrayList<SubFuncionalidad> ListarSubFuncionalidadEliminados() {
               ArrayList<SubFuncionalidad> _listaSubFuncionalidad = new ArrayList<SubFuncionalidad>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoSubFuncionalidadEliminados()");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                SubFuncionalidad s = new SubFuncionalidad();
                 
                 s.setId(_resultado.getInt(3));
                 s.setTitulo(_resultado.getString(4));
                 s.setDescripcion(_resultado.getString(5));
                 s.setFecha_hecho(_resultado.getDate(6));
                 s.setFecha_baja(_resultado.getDate(7));
                 
                 _listaSubFuncionalidad.add(s);         
             }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                   try {
                       _comando.close();
                       _conexion.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _listaSubFuncionalidad;
    }

    @Override
    public int ReingresarSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
               boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spReingresarSubFuncionalidad(?, ?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(2, pSubFuncionalidad.getId(), java.sql.Types.INTEGER);
             
             _resultado = _comando.executeUpdate();
            
        }
        catch (Exception ex)
        {
            Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                   try {
                       _comando.close();
                       _conexion.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _resultado;
    }

    @Override
    public int EliminarSubFuncionalidadDefinitivo(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarSubFuncionalidadDefinitivo(?, ?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _comando.setObject(2, pSubFuncionalidad.getId(), java.sql.Types.INTEGER);
            
            _resultado = _comando.executeUpdate();
        }
        catch (Exception ex)
        {
          Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                    try {
                        _comando.close();
                        _conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }

    @Override
    public int EliminarListaSubFuncionalidadDefinitivo() {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarListaSubFuncionalidadDefinitivo()");
            
             _resultado = _comando.executeUpdate();
        }
        catch (Exception ex)
        {
            Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                    try {
                        _comando.close();
                        _conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }


    @Override
    public int VerSiguienteIdSubFuncionalidad(int pIdFuncionalidad) {
        int _retorno = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spVerSiguienteIdSubFuncionalidad(?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 _retorno = _resultado.getInt(1);        
             }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<SubFuncionalidad> ListarSubFuncionalidadPorId(int pIdFuncionalidad) {
       
     ArrayList<SubFuncionalidad> _listaSubFuncionalidad = new ArrayList();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoSubFuncionalidadPorIdDos(?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
                 SubFuncionalidad s = new SubFuncionalidad();
                 
                 s.setId(_resultado.getInt(3));
                 s.setTitulo(_resultado.getString(4));
                 s.setDescripcion(_resultado.getString(5));
                 s.setFecha_hecho(_resultado.getDate(6));
                 s.setFecha_baja(_resultado.getDate(7));
                 
                 _listaSubFuncionalidad.add(s);  
             }
        }
        catch (Exception ex)
        {
           Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                   try {
                       _comando.close();
                       _conexion.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _listaSubFuncionalidad;
        
    }

    @Override
    public ArrayList<SubFuncionalidad> ListarSubFuncionalidadEliminadosPorId(int pIdFuncionalidad) {
         ArrayList<SubFuncionalidad> _listaSubFuncionalidad = new ArrayList();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoSubFuncionalidadEliminadosPorId(?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
                 SubFuncionalidad s = new SubFuncionalidad();
                 
                 s.setId(_resultado.getInt(3));
                 s.setTitulo(_resultado.getString(4));
                 s.setDescripcion(_resultado.getString(5));
                 s.setFecha_hecho(_resultado.getDate(6));
                 s.setFecha_baja(_resultado.getDate(7));
                 
                 _listaSubFuncionalidad.add(s);  
             }
        }
        catch (Exception ex)
        {
           Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                   try {
                       _comando.close();
                       _conexion.close();
                   } catch (SQLException ex) {
                       Logger.getLogger(DatosSubFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _listaSubFuncionalidad;
        
    }
    
}
