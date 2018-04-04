/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosTipoBonus;
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
public class DatosTipoBonus implements IDatosTipoBonus {
    
    public DatosTipoBonus()
    {
    
    }
    
//   public int AltaTipoBonus(TipoBonus pTipoBonus) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaTipoBonus(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pTipoBonus.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pTipoBonus.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoBonus.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoBonus.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTipoBonus.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarTipoBonus(TipoBonus pTipoBonus) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarMapa(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pTipoBonus.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pTipoBonus.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoBonus.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoBonus.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTipoBonus.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pTipoBonus.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaTipoBonus(TipoBonus pTipoBonus) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoBonus(?)");
//             _comando.setObject(1, pTipoBonus.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<TipoBonus> ListarTipoBonus() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<TipoBonus> BuscarTipoBonusPorId(int pIdTipoBonus) throws SQLException
//    {

//    }
//    
//    public ArrayList<TipoBonus> ListarTipoBonusEliminados() throws SQLException
//    {
//        ArrayList<TipoBonus> _listaTipoBonus = new ArrayList<TipoBonus>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoTipoBonusEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                  TipoBonus t = new TipoBonus();
//                 
//                 t.setId(_resultado.getInt(2));
//                 t.setNombre(_resultado.getString(3));
//                 t.setDescripcion(_resultado.getString(4));
//                 t.setUbicacion(_resultado.getString(5));
//                 t.setArchivo(_resultado.getString(6));
//                 t.setFecha_hecho(_resultado.getDate(7));
//                 t.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaTipoBonus.add(t);            
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
//        return _listaTipoBonus;
//        
//    }
//    
//    public int ReingresarTipoBonus(TipoBonus pTipoBonus) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarTipoBonus(?)");
//             _comando.setObject(1, pTipoBonus.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarTipoBonusDefinitivo(TipoBonus pTipoBonus) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoBonusDefinitivo(?)");
//             _comando.setObject(1, pTipoBonus.getNombre(), java.sql.Types.VARCHAR);
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
//    public int EliminarListaTipoBonusDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaTipoBonusDefinitivo");
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

    @Override
    public int AltaTipoBonus(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoBonus(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoBonus(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoBonus> ListarTipoBonus() {
            ArrayList<TipoBonus> _listaTipoBonus = new ArrayList<TipoBonus>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTipoBonus()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     TipoBonus t = new TipoBonus();

                     t.setId(_resultado.getInt(1));
                     t.setNombre(_resultado.getString(2));
                     t.setDescripcion(_resultado.getString(3));
                     t.setUbicacion(_resultado.getString(4));
                     t.setArchivo(_resultado.getString(5));
                     t.setFecha_hecho(_resultado.getDate(6));
                     t.setFecha_baja(_resultado.getDate(7));

                     _listaTipoBonus.add(t);            
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
                    Logger.getLogger(DatosTipoBonus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _listaTipoBonus;

    }

    @Override
    public TipoBonus BuscarTipoBonusPorId(int pIdTipoBonus) {
            TipoBonus t= null;

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTipoBonusPorId(?)");
                 _comando.setObject(1, pIdTipoBonus, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();


                 while(_resultado.next())
                 {
                     t = new TipoBonus();

                     t.setId(_resultado.getInt(1));
                     t.setNombre(_resultado.getString(2));
                     t.setDescripcion(_resultado.getString(3));
                     t.setUbicacion(_resultado.getString(4));
                     t.setArchivo(_resultado.getString(5));
                     t.setFecha_hecho(_resultado.getDate(6));
                     t.setFecha_baja(_resultado.getDate(7));
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
                    Logger.getLogger(DatosTipoBonus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return t;

    }

    @Override
    public ArrayList<TipoBonus> ListarTipoBonusEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoBonus(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoBonusDefinitivo(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoBonusDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
