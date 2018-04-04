/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosTablero;
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
public class DatosTablero implements IDatosTablero{
  
    
    public DatosTablero()
    {
    
    }
    
//   public int AltaTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaTablero(?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(3, pTablero.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTablero.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTablero.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pTablero.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pTablero.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(8, java.sql.Types.INTEGER);
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
//    public int ModificarTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarTablero(?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(3, pTablero.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(4, pTablero.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTablero.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pTablero.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pTablero.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(8, pTablero.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTablero(?)");
//             _comando.setObject(1, pTablero.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
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
//    public ArrayList<Tablero> ListarTablero() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<Tablero> BuscarTableroPorId(int pIdMapa, int pIdPantalla, int pIdTablero) throws SQLException
//    {

//    }
//    
//    public ArrayList<Tablero> ListarTablerosEliminados() throws SQLException
//    {
//        ArrayList<Tablero> _listaTablero = new ArrayList<Tablero>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoTableroEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 Tablero t = new Tablero();
//                 
//                  t.setId(_resultado.getInt(2));
//                 t.setNombre(_resultado.getString(3));
//                 t.setDescripcion(_resultado.getString(4));
//                 t.setUbicacion(_resultado.getString(5));
//                 t.setArchivo(_resultado.getString(6));
//                 t.setFecha_hecho(_resultado.getDate(7));
//                 t.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaTablero.add(t);            
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
//        return _listaTablero;
//        
//    }
//    
//    public int ReingresarTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarTablero(?, ?, ?)");
//            _comando.setObject(1, pTablero.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
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
//    public int EliminarTableroDefinitivo(int pIdMapa, int pIdPantalla, Tablero pTablero) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTableroDefinitivo(?, ?, ?)");
//             _comando.setObject(1, pTablero.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
//              /*_comando.registerOutParameter(6, java.sql.Types.INTEGER);*/
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
//    public int EliminarListaTableroDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaTableroDefinitivo");
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
    public int AltaTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tablero> ListarTablero() {
            ArrayList<Tablero> _listaTablero = new ArrayList<Tablero>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTablero()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     Tablero t = new Tablero();
                     
                     t.setId(_resultado.getInt(4));
                     t.setNombre(_resultado.getString(5));
                     t.setDescripcion(_resultado.getString(6));
                     t.setUbicacion(_resultado.getString(7));
                     t.setArchivo(_resultado.getString(8));
                     t.setFecha_hecho(_resultado.getDate(9));
                     t.setFecha_baja(_resultado.getDate(10));

                     _listaTablero.add(t);            
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
                    Logger.getLogger(DatosTablero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _listaTablero;

    }

    @Override
    public Tablero BuscarTableroPorId(int pIdMapa, int pIdPantalla, int pIdTablero) {
            Tablero t = null;

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTableroPorId(?,?,?)");
                 _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
                 _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
                 _comando.setObject(3, pIdTablero, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     t = new Tablero();

                     t.setId(_resultado.getInt(4));
                     t.setNombre(_resultado.getString(5));
                     t.setDescripcion(_resultado.getString(6));
                     t.setUbicacion(_resultado.getString(7));
                     t.setArchivo(_resultado.getString(8));
                     t.setFecha_hecho(_resultado.getDate(9));
                     t.setFecha_baja(_resultado.getDate(10));
                     t.setLista_cuadrado(new DatosCuadrado().BuscarCuadradoPorIdTablero(pIdMapa, pIdPantalla, pIdTablero));
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
                    Logger.getLogger(DatosTablero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return t;

    }

    @Override
    public ArrayList<Tablero> ListarTablerosEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTableroDefinitivo(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTableroDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
