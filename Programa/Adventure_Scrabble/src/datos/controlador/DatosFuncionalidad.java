/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosFuncionalidad;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class DatosFuncionalidad implements IDatosFuncionalidad {
        
    public DatosFuncionalidad()
    {
    
    }

    @Override
    public int AltaFuncionalidad(Funcionalidad pFuncionalidad) {
      
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _conexion.setAutoCommit(false);
             _comando = _conexion.prepareCall("call spAltaFuncionalidad(?, ?, ?)");
             _comando.setObject(1, pFuncionalidad.getTitulo(), java.sql.Types.VARCHAR);
             _comando.setObject(2, pFuncionalidad.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(3, pFuncionalidad.getFecha_hecho(), java.sql.Types.DATE);
             
             _resultado = _comando.executeUpdate();
             
             if(_resultado > 0 && pFuncionalidad.getSub_funcionalidad().size() > 0)
             {
                 for(SubFuncionalidad sf : pFuncionalidad.getSub_funcionalidad())
                 {
                     _comando = null;
                     _comando = _conexion.prepareCall("call spAltaSubFuncionalidad(?, ?, ?, ?)");
                     _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
                     _comando.setObject(2, sf.getTitulo(), java.sql.Types.VARCHAR);
                     _comando.setObject(3, sf.getDescripcion(), java.sql.Types.VARCHAR);
                     _comando.setObject(4, sf.getFecha_hecho(), java.sql.Types.DATE);
                     
                     _resultado = _comando.executeUpdate();
                 }
             }
             
             _conexion.commit();
            
        }
        catch (Exception ex)
        {
            try {
                _conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DatosFuncionalidad.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
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
        
        return _resultado;
    }

    @Override
    public int ModificarFuncionalidad(Funcionalidad pFuncionalidad) {
        
        boolean _retorno = false;
      //  boolean _esAlta = false;
        int _resultado = 0;
        ResultSet _busqueda;
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _conexion.setAutoCommit(false);
             _comando = _conexion.prepareCall("call spModificarFuncionalidad(?, ?, ?, ?)");
             _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pFuncionalidad.getTitulo(), java.sql.Types.VARCHAR);
             _comando.setObject(3, pFuncionalidad.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(4, pFuncionalidad.getFecha_hecho(), java.sql.Types.DATE);
             
             _resultado = _comando.executeUpdate();
            
             if(_resultado > 0 )
             {
                 _comando = _conexion.prepareCall("call spEliminarSubFuncionalidadPorIdFuncionalidad(?)");
                 _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
                 
                 _resultado = _comando.executeUpdate();
                 
                 if(_resultado>0 && pFuncionalidad.getSub_funcionalidad().size() > 0)
                 {
                        for(SubFuncionalidad sf : pFuncionalidad.getSub_funcionalidad())
                        {
                             _comando = null;
                             _comando = _conexion.prepareCall("call spBuscarSubFuncionalidadEliminada(?, ?)");
                             _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
                             _comando.setObject(2, sf.getId(), java.sql.Types.INTEGER);  

                             _busqueda = _comando.executeQuery();

                             if(_busqueda.next())
                             {     
                                 _comando = null;
                                 _comando = _conexion.prepareCall("call spReingresarSubFuncionalidad(?, ?)");
                                 _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
                                 _comando.setObject(2, sf.getId(), java.sql.Types.INTEGER);
                                 
                                 _resultado = _comando.executeUpdate();
                                 
                                 if(_resultado>0)
                                 {
                                     _comando = _conexion.prepareCall("call spModificarSubFuncionalidad(?, ?, ?, ?, ?)");
                                     _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
                                     _comando.setObject(2, sf.getId(), java.sql.Types.INTEGER);
                                     _comando.setObject(3, sf.getTitulo(), java.sql.Types.VARCHAR);
                                     _comando.setObject(4, sf.getDescripcion(), java.sql.Types.VARCHAR);
                                     _comando.setObject(5, sf.getFecha_hecho(), java.sql.Types.DATE);

                                     _resultado = _comando.executeUpdate();    
                                 
                                 }
                             }
                             else
                             {
                                 _comando = _conexion.prepareCall("call spAltaSubFuncionalidad(?, ?, ?, ?)");
                                 _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
                                 _comando.setObject(2, sf.getTitulo(), java.sql.Types.VARCHAR);
                                 _comando.setObject(3, sf.getDescripcion(), java.sql.Types.VARCHAR);
                                 _comando.setObject(4, sf.getFecha_hecho(), java.sql.Types.DATE);
                                 _resultado = _comando.executeUpdate();
                             } 
                          
                       }
                 }
            }
             
              _conexion.commit();
        }
        catch (Exception ex)
        {
             try {
                _conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DatosFuncionalidad.class.getName()).log(Level.SEVERE, null, ex1);
            }
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
        
        return _resultado;
        
    }

    @Override
    public int BajaFuncionalidad(Funcionalidad pFuncionalidad) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _conexion.setAutoCommit(false);
             _comando = _conexion.prepareCall("call spEliminarFuncionalidad(?)");
             _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
            
             _resultado = _comando.executeUpdate();
             
               if(_resultado > 0 && pFuncionalidad.getSub_funcionalidad().size() > 0)
               {
                  for(SubFuncionalidad sf : pFuncionalidad.getSub_funcionalidad())
                 {
                     _comando = null;
                     _comando = _conexion.prepareCall("call spEliminarSubFuncionalidad(?, ?)");
                     _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
                     _comando.setObject(2, sf.getId(), java.sql.Types.INTEGER);
            
                    _resultado = _comando.executeUpdate();
                 }
               
               }
               
             _conexion.commit();  
        }
        catch (Exception ex)
        {
            try {
                _conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DatosFuncionalidad.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
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
        
        return _resultado;
        
    }

    @Override
    public ArrayList<Funcionalidad> ListarFuncionalidad() {
        
        ArrayList<Funcionalidad> _listaFuncionalidad = new ArrayList<Funcionalidad>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoFuncionalidad()");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 Funcionalidad f = new Funcionalidad();
                 
                 f.setId(_resultado.getInt(2));
                 f.setTitulo(_resultado.getString(3));
                 f.setDescripcion(_resultado.getString(4));
                 f.setFecha_hecho(_resultado.getDate(5));
                 f.setFecha_baja(_resultado.getDate(6));
                 f.setSub_funcionalidad(new DatosSubFuncionalidad().ListarSubFuncionalidadPorId(_resultado.getInt(2)));
                 
                 _listaFuncionalidad.add(f);            
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
        
        return _listaFuncionalidad;
        
    }

    @Override
    public Funcionalidad BuscarFuncionalidadPorId(int pIdFuncionalidad) {
        Funcionalidad _funcionalidad = null;
               
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoFuncionalidadPorId(?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
                _funcionalidad = new Funcionalidad();
                 
                 _funcionalidad.setId(_resultado.getInt(2));
                 _funcionalidad.setTitulo(_resultado.getString(3));
                 _funcionalidad.setDescripcion(_resultado.getString(4));
                 _funcionalidad.setFecha_hecho(_resultado.getDate(5));
                 _funcionalidad.setFecha_baja(_resultado.getDate(6));
                 _funcionalidad.setSub_funcionalidad(new DatosSubFuncionalidad().ListarSubFuncionalidadPorId(pIdFuncionalidad));
                                   
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
        
        return _funcionalidad;
        
    }

    @Override
    public ArrayList<Funcionalidad> ListarFuncionalidadEliminados() {
                
        ArrayList<Funcionalidad> _listaFuncionalidad = new ArrayList<Funcionalidad>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoFuncionalidadEliminados()");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 Funcionalidad f = new Funcionalidad();
                 
                 f.setId(_resultado.getInt(2));
                 f.setTitulo(_resultado.getString(3));
                 f.setDescripcion(_resultado.getString(4));
                 f.setFecha_hecho(_resultado.getDate(5));
                 f.setFecha_baja(_resultado.getDate(6));
                 f.setSub_funcionalidad(new DatosSubFuncionalidad().ListarSubFuncionalidadPorId(_resultado.getInt(2)));
                 
                 _listaFuncionalidad.add(f);                         
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
        
        return _listaFuncionalidad;
        
    }

    @Override
    public int ReingresarFuncionalidad(Funcionalidad pFuncionalidad) {
              
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _conexion.setAutoCommit(false);
             _comando = _conexion.prepareCall("call spReingresarFuncionalidad(?)");
             _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
             
             _resultado = _comando.executeUpdate();
            
             if(_resultado > 0 && pFuncionalidad.getSub_funcionalidad().size() > 0)
               {
                  for(SubFuncionalidad sf : pFuncionalidad.getSub_funcionalidad())
                 {
                     _comando = null;
                    _comando = _conexion.prepareCall("call spReingresarSubFuncionalidad(?, ?)");
                    _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.INTEGER);
                    _comando.setObject(2, sf.getId(), java.sql.Types.INTEGER);
             
                    _resultado = _comando.executeUpdate();
                 }
               
               }
               
             _conexion.commit();  
             
        }
        catch (Exception ex)
        {
            try {
                _conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DatosFuncionalidad.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
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
        
        return _resultado;
        
    }

    @Override
    public int EliminarFuncionalidadDefinitivo(Funcionalidad pFuncionalidad) {
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarFuncionalidadDefinitivo(?)");
             _comando.setObject(1, pFuncionalidad.getId(), java.sql.Types.VARCHAR);
             
            _resultado = _comando.executeUpdate();
       
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
        
        return _resultado;
        
    }

    @Override
    public int EliminarListaFuncionalidadDefinitivo() {
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarListaFuncionalidadDefinitivo()");
             
             _resultado = _comando.executeUpdate();
             
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
        
        return _resultado;
        
    }

    @Override
    public int VerSiguienteIdFuncionalidad() {
       
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
    public Funcionalidad BuscarFuncionalidadEliminadaPorId(int pIdFuncionalidad) {
        Funcionalidad _funcionalidad = null;
               
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
                _funcionalidad = new Funcionalidad();
                 
                 _funcionalidad.setId(_resultado.getInt(2));
                 _funcionalidad.setTitulo(_resultado.getString(3));
                 _funcionalidad.setDescripcion(_resultado.getString(4));
                 _funcionalidad.setFecha_hecho(_resultado.getDate(5));
                 _funcionalidad.setFecha_baja(_resultado.getDate(6));
                 _funcionalidad.setSub_funcionalidad(new DatosSubFuncionalidad().ListarSubFuncionalidadEliminadosPorId(pIdFuncionalidad));
                                   
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
        
        return _funcionalidad;
        
    }

    @Override
    public Funcionalidad BuscarFuncionalidadConSubFuncionalidadEliminados(int pIdFuncionalidad) {
     Funcionalidad _funcionalidad = null;
               
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoFuncionalidadPorId(?)");
             _comando.setObject(1, pIdFuncionalidad, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
                _funcionalidad = new Funcionalidad();
                 
                 _funcionalidad.setId(_resultado.getInt(2));
                 _funcionalidad.setTitulo(_resultado.getString(3));
                 _funcionalidad.setDescripcion(_resultado.getString(4));
                 _funcionalidad.setFecha_hecho(_resultado.getDate(5));
                 _funcionalidad.setFecha_baja(_resultado.getDate(6));
                 _funcionalidad.setSub_funcionalidad(new DatosSubFuncionalidad().ListarSubFuncionalidadEliminadosPorId(pIdFuncionalidad));
                                   
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
        
        return _funcionalidad;
    }
    
}

