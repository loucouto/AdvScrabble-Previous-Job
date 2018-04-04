/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosTipoObjetivo;
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
public class DatosTipoObjetivo implements IDatosTipoObjetivo{
    
   
    public DatosTipoObjetivo()
    {
    
    }
    
//   public int AltaTipoObjetivo(TipoObjetivo pTipoObjetivo) throws SQLException
//   {
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
//             _comando = _conexion.prepareCall("call spAltaTipoObjetivo(?, ?, ?, ?)");
//             _comando.setObject(1, pTipoObjetivo.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pTipoObjetivo.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoObjetivo.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(4, java.sql.Types.INTEGER);
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
//    public int ModificarTipoObjetivo(TipoObjetivo pTipoObjetivo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarTipoObjetivo(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pTipoObjetivo.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pTipoObjetivo.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoObjetivo.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoObjetivo.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaTipoObjetivo(TipoObjetivo pTipoObjetivo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoObjetivo(?)");
//             _comando.setObject(1, pTipoObjetivo.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<TipoObjetivo> ListarTipoObjetivo() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<TipoObjetivo> BuscarTipoObjetivoPorId(int pIdTipoObjetivo) throws SQLException
//    {

//    }
//    
//    public ArrayList<TipoObjetivo> ListarTipoObjetivoEliminados() throws SQLException
//    {
//        ArrayList<TipoObjetivo> _listaTipoObjetivo = new ArrayList<TipoObjetivo>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoTipoObjetivoEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                  TipoObjetivo t = new TipoObjetivo();
//                 
//                 t.setId(_resultado.getInt(1));
//                 t.setNombre(_resultado.getString(2));
//                 t.setDescripcion(_resultado.getString(3));
//                 t.setFecha_hecho(_resultado.getDate(4));
//                 t.setFecha_baja(_resultado.getDate(5));
//                 
//                 _listaTipoObjetivo.add(t);  
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
//        return _listaTipoObjetivo;
//        
//    }
//    
//    public int ReingresarTipoObjetivo(TipoObjetivo pTipoObjetivo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarTipoObjetivo(?)");
//             _comando.setObject(1, pTipoObjetivo.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarTipoObjetivoDefinitivo(TipoObjetivo pTipoObjetivo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoObjetivoDefinitivo(?)");
//             _comando.setObject(1, pTipoObjetivo.getId(), java.sql.Types.VARCHAR);
//            /* _comando.registerOutParameter(6, java.sql.Types.INTEGER);*/
//             
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
//    public int EliminarListaTipoObjetivoDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaTipoObjetivoDefinitivo");
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
    public int AltaTipoObjetivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoObjetivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoObjetivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoObjetivo> ListarTipoObjetivo() {
                ArrayList<TipoObjetivo> _listaTipoObjetivo = new ArrayList<TipoObjetivo>();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoTipoObjetivo");
                     _resultado = _comando.executeQuery();
                     
                     while(_resultado.next())
                     {
                         TipoObjetivo t = new TipoObjetivo();
                         
                         t.setId(_resultado.getInt(1));
                         t.setNombre(_resultado.getString(2));
                         t.setDescripcion(_resultado.getString(3));
                         t.setFecha_hecho(_resultado.getDate(4));
                         t.setFecha_baja(_resultado.getDate(5));
                         
                         _listaTipoObjetivo.add(t);               
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
                        Logger.getLogger(DatosTipoObjetivo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                return _listaTipoObjetivo;
                
    }

    @Override
    public TipoObjetivo BuscarTipoObjetivoPorId(int pIdTipoObjetivo) {
            TipoObjetivo t = null;

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTipoObjetivoPorId(?)");
                 _comando.setObject(1, pIdTipoObjetivo, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();


                 while(_resultado.next())
                 {
                     t = new TipoObjetivo();

                     t.setId(_resultado.getInt(1));
                     t.setNombre(_resultado.getString(2));
                     t.setDescripcion(_resultado.getString(3));
                     t.setFecha_hecho(_resultado.getDate(4));
                     t.setFecha_baja(_resultado.getDate(5));

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
                    Logger.getLogger(DatosTipoObjetivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return t;

    }

    @Override
    public ArrayList<TipoObjetivo> ListarTipoObjetivoEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoObjetivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoObjetivoDefinitivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoObjetivoDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
