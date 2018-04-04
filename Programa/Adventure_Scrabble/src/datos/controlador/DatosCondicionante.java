/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosCondicionante;
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
public class DatosCondicionante implements IDatosCondicionante {
    
    public DatosCondicionante()
    {
    
    }
   
    @Override
    public int AltaCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spAltaCondicionante(?, ?, ?, ?, ?, ?, ?)");
             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
             _comando.setObject(3, pCondicionante.getTipo_condicionante().getId(), java.sql.Types.INTEGER);
             _comando.setObject(4, pCondicionante.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(5, pCondicionante.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(6, pCondicionante.getFecha_hecho(), java.sql.Types.DATE);
             _comando.registerOutParameter(7, java.sql.Types.INTEGER);
                          
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
                        Logger.getLogger(DatosCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }

    @Override
    public int ModificarCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spModificarCondicionante(?, ?, ?, ?, ?, ?, ?)");
             _comando.setObject(1, pCondicionante.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
             _comando.setObject(4, pCondicionante.getTipo_condicionante().getId(), java.sql.Types.VARCHAR);
             _comando.setObject(5, pCondicionante.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(6, pCondicionante.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(7, pCondicionante.getFecha_hecho(), java.sql.Types.DATE);
            
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
                        Logger.getLogger(DatosCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;

    }

    @Override
    public int BajaCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarCondicionante(?)");
             _comando.setObject(1, pCondicionante.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
            
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
                        Logger.getLogger(DatosCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        

    }

    @Override
    public ArrayList<Condicionante> ListarCondicionante() {
               ArrayList<Condicionante> _listaCondicionante = new ArrayList<Condicionante>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoCondicionante()");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 Condicionante c = new Condicionante();
                 
                 c.setId(_resultado.getInt(3));
                 //c.setTipo_Condicionante(DatosTipoCondicionante.BuscarTipoCondicionantePorId(_resultado.getInt(4)))
                 c.setNombre(_resultado.getString(5));
                 c.setDescripcion(_resultado.getString(6));
                 c.setFecha_hecho(_resultado.getDate(7));
                 c.setFecha_baja(_resultado.getDate(8));
                 
                 _listaCondicionante.add(c);            
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
                       Logger.getLogger(DatosCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _listaCondicionante;
        
    }

    @Override
    public Condicionante BuscarCondicionantePorId(int pIdMapa, int pIdPantalla, int pIdCondicionante) {
        Condicionante c = null;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoCondicionantePorId(?,?,?)");
             _comando.setObject(1, pIdCondicionante, java.sql.Types.INTEGER);
             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
                 c = new Condicionante();
                 
                 c.setId(_resultado.getInt(3));
                 //c.setTipo_Condicionante(DatosTipoCondicionante.BuscarTipoCondicionantePorId(_resultado.getInt(4)))
                 c.setNombre(_resultado.getString(5));
                 c.setDescripcion(_resultado.getString(6));
                 c.setFecha_hecho(_resultado.getDate(7));
                 c.setFecha_baja(_resultado.getDate(8));
                           
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
                       Logger.getLogger(DatosCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return c;
        
    }

    @Override
    public ArrayList<Condicionante> ListarCondicionanteEliminados() {
               ArrayList<Condicionante> _listaCondicionante = new ArrayList<Condicionante>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("spObtenerListadoCondicionanteEliminados");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 Condicionante c = new Condicionante();
                 
                 c.setId(_resultado.getInt(3));
                 //c.setTipo_Condicionante(DatosTipoCondicionante.BuscarTipoCondicionantePorId(_resultado.getInt(4)))
                 c.setNombre(_resultado.getString(5));
                 c.setDescripcion(_resultado.getString(6));
                 c.setFecha_hecho(_resultado.getDate(7));
                 c.setFecha_baja(_resultado.getDate(8));
                 
                 _listaCondicionante.add(c);           
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
                       Logger.getLogger(DatosCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _listaCondicionante;
        
    }

    @Override
    public int ReingresarCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
               boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spReingresarCondicionante(?)");
             _comando.setObject(1, pCondicionante.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
             
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
                       Logger.getLogger(DatosCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _resultado;
    }

    @Override
    public int EliminarCondicionanteDefinitivo(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarCondicionanteDefinitivo(?, ?, ?)");
             _comando.setObject(1, pCondicionante.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
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
                        Logger.getLogger(DatosCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
    }

    @Override
    public int EliminarListaCondicionanteDefinitivo() {
              boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarListaCondicionanteDefinitivo");
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
                      Logger.getLogger(DatosCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                  }
        }
        
        return _resultado;
        
    }
    
}
