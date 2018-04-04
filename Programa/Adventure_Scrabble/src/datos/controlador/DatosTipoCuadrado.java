/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosTipoCuadrado;
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
public class DatosTipoCuadrado implements IDatosTipoCuadrado {
   
    public DatosTipoCuadrado()
    {
    
    }
    
//   public int AltaTipoCuadrado(TipoCuadrado pTipoCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaTipoCuadrado(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pTipoCuadrado.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pTipoCuadrado.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoCuadrado.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoCuadrado.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTipoCuadrado.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarTipoCuadrado(TipoCuadrado pTipoCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarTipoCuadrado(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pTipoCuadrado.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pTipoCuadrado.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoCuadrado.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoCuadrado.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTipoCuadrado.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pTipoCuadrado.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaTipoCuadrado(TipoCuadrado pTipoCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoCuadrado(?)");
//             _comando.setObject(1, pTipoCuadrado.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<TipoCuadrado> ListarTipoCuadrado() throws SQLException
//    {

//        
//    }
//    
//    
//    public ArrayList<TipoCuadrado> BuscarTipoCuadradoPorId(int pIdTipoCuadrado) throws SQLException
//    {

//        
//    }
//    
//    public ArrayList<TipoCuadrado> ListarTipoCuadradoEliminados() throws SQLException
//    {
//        ArrayList<TipoCuadrado> _listaTipoCuadrado = new ArrayList<TipoCuadrado>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoTipoCuadradoEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//               TipoCuadrado t = new TipoCuadrado();
//                 
//                 t.setId(_resultado.getInt(2));
//                 t.setNombre(_resultado.getString(3));
//                 t.setDescripcion(_resultado.getString(4));
//                 t.setUbicacion(_resultado.getString(5));
//                 t.setArchivo(_resultado.getString(6));
//                 t.setFecha_hecho(_resultado.getDate(7));
//                 t.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaTipoCuadrado.add(t);           
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
//        return _listaTipoCuadrado;
//        
//    }
//    
//    public int ReingresarTipoCuadrado(TipoCuadrado pTipoCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarTipoCuadrado(?)");
//             _comando.setObject(1, pTipoCuadrado.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarTipoCuadradoDefinitivo(TipoCuadrado pTipoCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoCuadradoDefinitivo(?)");
//             _comando.setObject(1, pTipoCuadrado.getId(), java.sql.Types.VARCHAR);
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
//    public int EliminarListaTipoCuadradoDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaTipoCuadradoDefinitivo");
//            /* _comando.registerOutParameter(6, java.sql.Types.INTEGER);*/
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
    public int AltaTipoCuadrado(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoCuadrado(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoCuadrado(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoCuadrado> ListarTipoCuadrado() {
            ArrayList<TipoCuadrado> _listaTipoCuadrado = new ArrayList<TipoCuadrado>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTipoCuadrado()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     TipoCuadrado t = new TipoCuadrado();

                     t.setId(_resultado.getInt(1));
                     t.setNombre(_resultado.getString(2));
                     t.setDescripcion(_resultado.getString(3));
                     t.setUbicacion(_resultado.getString(4));
                     t.setArchivo(_resultado.getString(5));
                     t.setFecha_hecho(_resultado.getDate(6));
                     t.setFecha_baja(_resultado.getDate(7));

                     _listaTipoCuadrado.add(t);            
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
                    Logger.getLogger(DatosTipoCuadrado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _listaTipoCuadrado;
    }

    @Override
    public TipoCuadrado BuscarTipoCuadradoPorId(int pIdTipoCuadrado) {
                TipoCuadrado t = null;

                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;

                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoTipoCuadradoPorId(?)");
                     _comando.setObject(1, pIdTipoCuadrado, java.sql.Types.INTEGER);
                     _resultado = _comando.executeQuery();

                     while(_resultado.next())
                     {
                         t = new TipoCuadrado();

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
                        Logger.getLogger(DatosTipoCuadrado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                return t;
    }

    @Override
    public ArrayList<TipoCuadrado> ListarTipoCuadradoEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoCuadrado(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoCuadradoDefinitivo(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoCuadradoDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
