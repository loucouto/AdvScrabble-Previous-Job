/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosBonus;
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
public class DatosBonus implements IDatosBonus {
        
    public DatosBonus()
    {
    
    }

    @Override
    public int AltaBonus(int pIdUsuario, Bonus pBonus) {
      
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spAltaBonus(?, ?, ?, ?, ?, ?, ?, ?, ?)");
             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
             _comando.setObject(2, pBonus.getTipo_bonus().getId(), java.sql.Types.INTEGER);
             _comando.setObject(3, pBonus.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(4, pBonus.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(5, pBonus.getUbicacion(), java.sql.Types.VARCHAR);
             _comando.setObject(6, pBonus.getArchivo(), java.sql.Types.VARCHAR);
             _comando.setObject(7, pBonus.getCantidad_bonus(), java.sql.Types.INTEGER);
             _comando.setObject(8, pBonus.getFecha_hecho(), java.sql.Types.DATE);
             _comando.registerOutParameter(9, java.sql.Types.INTEGER);
  
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
            } catch (SQLException ex) {
                Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                _conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
        
    }
     
    @Override
    public int ModificarBonus(int pIdUsuario, Bonus pBonus) {


        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spModificarBonus(?, ?, ?, ?, ?, ?, ?, ?, ?)");
             _comando.setObject(1, pBonus.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
             _comando.setObject(3, pBonus.getTipo_bonus().getId(), java.sql.Types.INTEGER);
             _comando.setObject(4, pBonus.getNombre(), java.sql.Types.VARCHAR);
             _comando.setObject(5, pBonus.getDescripcion(), java.sql.Types.VARCHAR);
             _comando.setObject(6, pBonus.getUbicacion(), java.sql.Types.VARCHAR);
             _comando.setObject(7, pBonus.getArchivo(), java.sql.Types.VARCHAR);
             _comando.setObject(8, pBonus.getCantidad_bonus(), java.sql.Types.INTEGER);
             _comando.setObject(9, pBonus.getFecha_hecho(), java.sql.Types.DATE);
            
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
            } catch (SQLException ex) {
                Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                _conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
    }

    @Override
    public int BajaBonus(int pIdUsuario, Bonus pBonus) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarBonus(?)");
             _comando.setObject(1, pBonus.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
            
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
                    } catch (SQLException ex) {
                        Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        _conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }

    @Override
    public Bonus BuscarBonusPorId(int pIdUsuario, int pIdBonus) {
                
        Bonus b = null;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoBonusPorId(?, ?)");
             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
             _comando.setObject(2, pIdBonus, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
                 b = new Bonus();
                 
                 b.setId(_resultado.getInt(2));
                 //b.setTipo_bonus(DatosTipoBonus.BuscarTipoBonusPorId(_resultado.getInt(3)));
                 b.setNombre(_resultado.getString(4));
                 b.setDescripcion(_resultado.getString(5));
                 b.setUbicacion(_resultado.getString(6));
                 b.setArchivo(_resultado.getString(7));
                 b.setCantidad_bonus(_resultado.getInt(8));
                 b.setFecha_hecho(_resultado.getDate(9));
                 b.setFecha_baja(_resultado.getDate(10));
                                 
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
                 Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        return b;
      
    }

    @Override
    public ArrayList<Bonus> ListarBonusEliminados() {
        
               ArrayList<Bonus> _listaBonus = new ArrayList<Bonus>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("spObtenerListadoBonusEliminados");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
              Bonus b = new Bonus();
                 
                 b.setId(_resultado.getInt(2));
                 //b.setTipo_bonus(DatosTipoBonus.BuscarTipoBonusPorId(_resultado.getInt(3)));
                 b.setNombre(_resultado.getString(4));
                 b.setDescripcion(_resultado.getString(5));
                 b.setUbicacion(_resultado.getString(6));
                 b.setArchivo(_resultado.getString(7));
                 b.setCantidad_bonus(_resultado.getInt(8));
                 b.setFecha_hecho(_resultado.getDate(9));
                 b.setFecha_baja(_resultado.getDate(10));
                 
                 _listaBonus.add(b);          
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
                       Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
                   }
        }
        
        return _listaBonus;
        
    }
   
    @Override
    public int ReingresarBonus(int pIdUsuario, Bonus pBonus) {
        boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
      
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spReingresarBonus(?)");
             _comando.setObject(1, pBonus.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
             
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
                Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return _resultado;
    }

    @Override
    public int EliminarBonusDefinitivo(int pIdUsuario, Bonus pBonus) {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarBonusDefinitivo(?)");
             _comando.setObject(1, pBonus.getId(), java.sql.Types.INTEGER);
             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
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
                        Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
        
    }

    @Override
    public int EliminarListaBonusDefinitivo() {
                boolean _retorno = false;
        
        int _resultado = 0;
        
        Connection _conexion = null;
        CallableStatement _comando = null;
       
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spEliminarListaBonusDefinitivo");
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
                        Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _resultado;
    }
    
    @Override
    public ArrayList<Bonus> ListarBonus() {
             ArrayList<Bonus> _listaBonus = new ArrayList<Bonus>();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoBonus");
             _resultado = _comando.executeQuery();
             
             while(_resultado.next())
             {
                 Bonus b = new Bonus();
                 
                 b.setId(_resultado.getInt(2));
                 //b.setTipo_bonus(DatosTipoBonus.BuscarTipoBonusPorId(_resultado.getInt(3)));
                 b.setNombre(_resultado.getString(4));
                 b.setDescripcion(_resultado.getString(5));
                 b.setUbicacion(_resultado.getString(6));
                 b.setArchivo(_resultado.getString(7));
                 b.setCantidad_bonus(_resultado.getInt(8));
                 b.setFecha_hecho(_resultado.getDate(9));
                 b.setFecha_baja(_resultado.getDate(10));
                 
                 _listaBonus.add(b);            
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
                        Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
        
        return _listaBonus;
    }

    @Override
    public ArrayList<Bonus> BuscarBonusPorIdUsuario(int pIdUsuario) {
        ArrayList<Bonus> lista_bonus = new ArrayList();
        
        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;
        
        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoBonusPorIdUsuario(?)");
             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();
            
             
             while(_resultado.next())
             {
                 Bonus b = new Bonus();
                 
                 b.setId(_resultado.getInt(2));
                 b.setTipo_bonus( new DatosTipoBonus().BuscarTipoBonusPorId(_resultado.getInt(3)));
                 b.setNombre(_resultado.getString(4));
                 b.setDescripcion(_resultado.getString(5));
                 b.setUbicacion(_resultado.getString(6));
                 b.setArchivo(_resultado.getString(7));
                 b.setCantidad_bonus(_resultado.getInt(8));
                 b.setFecha_hecho(_resultado.getDate(9));
                 b.setFecha_baja(_resultado.getDate(10));
                  
                 lista_bonus.add(b);
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
                 Logger.getLogger(DatosBonus.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        return lista_bonus;
    }
    
    
    
}
