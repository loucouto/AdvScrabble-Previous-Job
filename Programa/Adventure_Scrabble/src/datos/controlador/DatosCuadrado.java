/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosCuadrado;
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
public class DatosCuadrado implements IDatosCuadrado{

    
    public DatosCuadrado()
    {
    
    }
    
//    public int AltaCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaCuadrado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdTablero, java.sql.Types.INTEGER);
//             _comando.setObject(4, pCuadrado.getTipo_cuadrado().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(5, pCuadrado.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pCuadrado.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pCuadrado.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(8, pCuadrado.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(9, pCuadrado.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(10, java.sql.Types.INTEGER);
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
//    public int ModificarCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarCuadrado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdTablero, java.sql.Types.INTEGER);
//             _comando.setObject(4, pCuadrado.getTipo_cuadrado().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(5, pCuadrado.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(6, pCuadrado.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pCuadrado.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(8, pCuadrado.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(9, pCuadrado.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(10, pCuadrado.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(11, java.sql.Types.INTEGER);
//               
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
//    public int BajaCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarCuadrado(?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdTablero, java.sql.Types.INTEGER);
//             _comando.setObject(4, pCuadrado.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<Cuadrado> ListarCuadrado() throws SQLException
//    {

//        
//    }
//    
//    
//    public ArrayList<Cuadrado> BuscarCuadradoPorId(int pIdMapa , int pIdPantalla, int pIdTablero, int pIdCuadrado) throws SQLException
//    {

//        
//    }
//    
//    public ArrayList<Cuadrado> ListarCuadradosEliminados() throws SQLException
//    {
//        ArrayList<Cuadrado> _listaCuadrado = new ArrayList<Cuadrado>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoCuadradoEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                Cuadrado c = new Cuadrado();
//                 
//                 c.setId(_resultado.getInt(5));
//                 // c.setId(DatosTipoCuadrado.BuscarTipoCuadradoPorId(_resultado.getInt(6)));
//                 c.setNombre(_resultado.getString(7));
//                 c.setDescripcion(_resultado.getString(8));
//                 c.setUbicacion(_resultado.getString(9));
//                 c.setArchivo(_resultado.getString(10));
//                 c.setFecha_hecho(_resultado.getDate(11));
//                 c.setFecha_baja(_resultado.getDate(12));
//                 
//                 _listaCuadrado.add(c);                
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
//        return _listaCuadrado;
//        
//    }
//    
//    public int ReingresarCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarCuadrado(?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdTablero, java.sql.Types.INTEGER);
//             _comando.setObject(4, pCuadrado.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarCuadradoDefinitivo(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarCuadradoDefinitivo(?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdTablero, java.sql.Types.INTEGER);
//             _comando.setObject(4, pCuadrado.getId(), java.sql.Types.INTEGER);
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
//    
//    public int EliminarListaCuadradoDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaCuadradoDefinitivo");
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
//    

    @Override
    public int AltaCuadrado(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarCuadrado(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaCuadrado(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cuadrado> ListarCuadrado() {
       ArrayList<Cuadrado> _listaCuadrado = new ArrayList<Cuadrado>();

        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;

        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoCuadrado()");
             _resultado = _comando.executeQuery();

             while(_resultado.next())
             {
                 Cuadrado c = new Cuadrado();

                 c.setId(_resultado.getInt(5));
                 c.setTipo_cuadrado(new DatosTipoCuadrado().BuscarTipoCuadradoPorId(_resultado.getInt(5)));
                 c.setNombre(_resultado.getString(7));
                 c.setDescripcion(_resultado.getString(8));
                 c.setUbicacion(_resultado.getString(9));
                 c.setArchivo(_resultado.getString(10));
                 c.setFecha_hecho(_resultado.getDate(11));
                 c.setFecha_baja(_resultado.getDate(12));
                 c.setCoordenada_x(_resultado.getInt(13));
                 c.setCoordenada_y(_resultado.getInt(14));

                 _listaCuadrado.add(c);            
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
                        Logger.getLogger(DatosCuadrado.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }

        return _listaCuadrado;
    }

    @Override
    public Cuadrado BuscarCuadradoPorId(int pIdMapa, int pIdPantalla, int pIdTablero, int pIdCuadrado) {
                Cuadrado c = null;
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoCuadradoPorId(?, ?, ?, ?)");
                     _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
                     _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
                     _comando.setObject(3, pIdTablero, java.sql.Types.INTEGER);
                     _comando.setObject(4, pIdCuadrado, java.sql.Types.INTEGER);
                     
                     _resultado = _comando.executeQuery();
                    
                     while(_resultado.next())
                     {
                         c = new Cuadrado();
                         
                          c.setId(_resultado.getInt(5));
                          c.setTipo_cuadrado(new DatosTipoCuadrado().BuscarTipoCuadradoPorId(_resultado.getInt(6)));
                          c.setNombre(_resultado.getString(7));
                          c.setDescripcion(_resultado.getString(8));
                          c.setUbicacion(_resultado.getString(9));
                          c.setArchivo(_resultado.getString(10));
                          c.setFecha_hecho(_resultado.getDate(11));
                          c.setFecha_baja(_resultado.getDate(12));
                          c.setCoordenada_x(_resultado.getInt(13));
                          c.setCoordenada_y(_resultado.getInt(14));
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
                                Logger.getLogger(DatosCuadrado.class.getName()).log(Level.SEVERE, null, ex);
                            }
                }
                
                return c;
    }

    @Override
    public ArrayList<Cuadrado> ListarCuadradosEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarCuadrado(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarCuadradoDefinitivo(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaCuadradoDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cuadrado> BuscarCuadradoPorIdTablero(int pIdMapa, int pIdPantalla, int pIdTablero) {
        ArrayList<Cuadrado> _listaCuadrado = new ArrayList<Cuadrado>();

        Connection _conexion = null;
        CallableStatement _comando = null;
        ResultSet _resultado;

        try
        {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
             _comando = _conexion.prepareCall("call spObtenerListadoCuadradoPorIdTablero(?, ?, ?)");
             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
             _comando.setObject(3, pIdTablero, java.sql.Types.INTEGER);
             _resultado = _comando.executeQuery();

             while(_resultado.next())
             {
                 Cuadrado c = new Cuadrado();

                  c.setId(_resultado.getInt(5));
                  c.setTipo_cuadrado(new DatosTipoCuadrado().BuscarTipoCuadradoPorId(_resultado.getInt(6)));
                  c.setNombre(_resultado.getString(7));
                  c.setDescripcion(_resultado.getString(8));
                  c.setUbicacion(_resultado.getString(9));
                  c.setArchivo(_resultado.getString(10));
                  c.setFecha_hecho(_resultado.getDate(11));
                  c.setFecha_baja(_resultado.getDate(12));
                  c.setCoordenada_x(_resultado.getInt(13));
                  c.setCoordenada_y(_resultado.getInt(14));

                 _listaCuadrado.add(c);            
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
                        Logger.getLogger(DatosCuadrado.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }

        return _listaCuadrado;
    }
    
}
