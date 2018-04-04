/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;


import datos.interfaces.IDatosPantalla;
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
public class DatosPantalla implements IDatosPantalla{
    
    
    public DatosPantalla()
    {
    
    }
      
//    public int AltaPantalla(Pantalla pPantalla, int pIdMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaPantalla(?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.VARCHAR);
//             _comando.setObject(2, pPantalla.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pPantalla.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pPantalla.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pPantalla.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pPantalla.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(7, java.sql.Types.INTEGER);
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
//    public int ModificarPantalla(Pantalla pPantalla, int pIdMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarPantalla(?, ?, ?, ?, ?, ?, ?)");
//            
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pPantalla.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(3, pPantalla.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pPantalla.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pPantalla.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pPantalla.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pPantalla.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaPantalla(Pantalla pPantalla, int pIdMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarPantalla(?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pPantalla.getId(), java.sql.Types.INTEGER);
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
//    
//        return _resultado;
//        
//    }
//        
//    public ArrayList<Pantalla> ListarPantalla() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<Pantalla> BuscarPantallaPorId(int pIdMapa, int pIdPantalla) throws SQLException
//    {

//    }
//    
//    public ArrayList<Pantalla> ListadoPantallasEliminadas() throws SQLException
//    {
//        ArrayList<Pantalla> _listaPantalla = new ArrayList<Pantalla>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("call spObtenerListadoPantallasEliminadas");
//             _resultado = _comando.executeQuery();
//              
//             while(_resultado.next())
//             {
//                 Pantalla p = new Pantalla();
//                 
//                 p.setId(_resultado.getInt(3));
//                 p.setNombre(_resultado.getString(4));
//                 p.setDescripcion(_resultado.getString(5));
//                 p.setUbicacion(_resultado.getString(6));
//                 p.setArchivo(_resultado.getString(7));
//                 p.setFecha_hecho(_resultado.getDate(8));
//                 p.setFecha_baja(_resultado.getDate(9));
//                 
//                 _listaPantalla.add(p);            
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
//        return _listaPantalla;
//        
//    }
//    
//    public int ReingresarPantalla(int pIdMapa , Pantalla pPantalla) throws SQLException
//    {
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
//             _comando = _conexion.prepareCall("call spEliminarPantalla(?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pPantalla.getId(), java.sql.Types.INTEGER);
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
//    
//        return _resultado;
//        
//    }
//    
//    public int EliminarPantallaDefinitivo(Pantalla pPantalla, int pIdMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarPantallaDefinitivo(?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pPantalla.getId(), java.sql.Types.INTEGER);
//             /*_comando.registerOutParameter(7, java.sql.Types.INTEGER);*/
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
//    public int EliminarListaPantallaDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaPantallaDefinitivo");
//             /*_comando.registerOutParameter(7, java.sql.Types.INTEGER);*/
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
//    }

    @Override
    public int AltaPantalla(Pantalla pPantalla, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarPantalla(Pantalla pPantalla, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaPantalla(Pantalla pPantalla, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pantalla> ListarPantalla() {
            ArrayList<Pantalla> _listaPantalla = new ArrayList<Pantalla>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoPantalla()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     Pantalla p = new Pantalla();

                     p.setId(_resultado.getInt(3));
                     p.setNombre(_resultado.getString(4));
                     p.setDescripcion(_resultado.getString(5));
                     p.setUbicacion(_resultado.getString(6));
                     p.setArchivo(_resultado.getString(7));
                     p.setFecha_hecho(_resultado.getDate(8));
                     p.setFecha_baja(_resultado.getDate(9));

                     _listaPantalla.add(p);            
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
                    Logger.getLogger(DatosPantalla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _listaPantalla;

    }

    @Override
    public Pantalla BuscarPantallaPorId(int pIdMapa, int pIdPantalla) {
                  Pantalla p = null;
            
            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;
            
            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoPantallaPorId(?, ?)");
                 _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
                 _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();
                
                 while(_resultado.next())
                 {
                     p = new Pantalla();
                     
                     p.setId(_resultado.getInt(3));
                     p.setNombre(_resultado.getString(4));
                     p.setDescripcion(_resultado.getString(5));
                     p.setUbicacion(_resultado.getString(6));
                     p.setArchivo(_resultado.getString(7));
                     p.setFecha_hecho(_resultado.getDate(8));
                     p.setFecha_baja(_resultado.getDate(9));
                               
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
                          Logger.getLogger(DatosPantalla.class.getName()).log(Level.SEVERE, null, ex);
                      }
            }
            
            return p;
            
    }

    @Override
    public ArrayList<Pantalla> ListadoPantallasEliminadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarPantalla(int pIdMapa, Pantalla pPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarPantallaDefinitivo(Pantalla pPantalla, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaPantallaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
