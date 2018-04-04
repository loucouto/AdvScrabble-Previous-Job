/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosPuntajePantalla;
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
public class DatosPuntajePantalla implements IDatosPuntajePantalla {
    
   
    
    public DatosPuntajePantalla()
    {
    
    }
    
//     public int AltaPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaPuntajePantalla(?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdEstrella, java.sql.Types.INTEGER);
//             _comando.setObject(4, pPuntajePantalla.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pPuntajePantalla.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pPuntajePantalla.getNivel(), java.sql.Types.INTEGER);
//             _comando.setObject(7, pPuntajePantalla.getPuntaje(), java.sql.Types.INTEGER);
//             _comando.setObject(8, pPuntajePantalla.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(9, java.sql.Types.INTEGER);
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
//    public int ModificarPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarPuntajePantalla(?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pPuntajePantalla.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(4, pIdEstrella, java.sql.Types.INTEGER);
//             _comando.setObject(5, pPuntajePantalla.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pPuntajePantalla.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pPuntajePantalla.getNivel(), java.sql.Types.INTEGER);
//             _comando.setObject(8, pPuntajePantalla.getPuntaje(), java.sql.Types.INTEGER);
//             _comando.setObject(9, pPuntajePantalla.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarPuntajePantalla(?, ?, ?, ?)");
//             _comando.setObject(1, pPuntajePantalla.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(4, pIdEstrella, java.sql.Types.INTEGER);
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
//    public ArrayList<PuntajePantalla> ListarPuntajePantalla() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<PuntajePantalla> BuscarPuntajePantallaPorId(int pIdMapa, int pIdPantalla, int pIdEstrella, int pIdPuntajePantalla) throws SQLException
//    {

//    }
//    
//    public ArrayList<PuntajePantalla> ListarPuntajePantallaEliminados() throws SQLException
//    {
//        ArrayList<PuntajePantalla> _listaPuntajePantalla = new ArrayList<PuntajePantalla>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoPuntajePantallaEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                PuntajePantalla p = new PuntajePantalla();
//                 
//                 //p.setEstrella(DatosEstrella.BuscarEstrellaPorId(_resultado.getInt(3)))
//                 p.setId(_resultado.getInt(4));
//                 p.setNombre(_resultado.getString(5));
//                 p.setDescripcion(_resultado.getString(6));
//                 p.setNivel(_resultado.getInt(7));
//                 p.setPuntaje(_resultado.getInt(8));
//                 p.setFecha_hecho(_resultado.getDate(9));
//                 p.setFecha_baja(_resultado.getDate(10));
//                 
//                 _listaPuntajePantalla.add(p);             
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
//        return _listaPuntajePantalla;
//        
//    }
//    
//    public int ReingresarPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarPuntajePantalla(?, ?, ?, ?)");
//             _comando.setObject(1, pPuntajePantalla.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(4, pIdEstrella, java.sql.Types.INTEGER);
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
//    public int EliminarPuntajePantallaDefinitivo(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarPuntajePantallaDefinitivo(?, ?, ?, ?)");
//             _comando.setObject(1, pPuntajePantalla.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdPantalla, java.sql.Types.INTEGER);
//             _comando.setObject(4, pIdEstrella, java.sql.Types.INTEGER);
//            
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
//    public int EliminarListaMapaDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaPuntajePantallaDefinitivo");
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

    @Override
    public int AltaPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PuntajePantalla> ListarPuntajePantalla() {
                ArrayList<PuntajePantalla> _listaPuntajePantalla = new ArrayList<PuntajePantalla>();

                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;

                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoPuntajePantalla()");

                     _resultado = _comando.executeQuery();

                     while(_resultado.next())
                     {
                         PuntajePantalla p = new PuntajePantalla();

                         //p.setEstrella(DatosEstrella.BuscarEstrellaPorId(_resultado.getInt(3)))
                         p.setId(_resultado.getInt(4));
                         p.setNombre(_resultado.getString(6));
                         p.setDescripcion(_resultado.getString(7));
                         p.setNivel(_resultado.getInt(8));
                         p.setPuntaje(_resultado.getInt(9));
                         p.setFecha_hecho(_resultado.getDate(10));
                         p.setFecha_baja(_resultado.getDate(11));

                         _listaPuntajePantalla.add(p);   

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
                        Logger.getLogger(DatosPuntajePantalla.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                return _listaPuntajePantalla;

    }

    @Override
    public PuntajePantalla BuscarPuntajePantallaPorId(int pIdMapa, int pIdPantalla, int pIdPuntajePantalla) {
            PuntajePantalla p = null;

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoPuntajePantallaPorId(?, ?, ?)");
                 _comando.setObject(1, pIdMapa, java.sql.Types.INTEGER);
                 _comando.setObject(2, pIdPantalla, java.sql.Types.INTEGER);
                 _comando.setObject(3, pIdPuntajePantalla, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();


                 while(_resultado.next())
                 {
                     p = new PuntajePantalla();

                       //p.setEstrella(DatosEstrella.BuscarEstrellaPorId(_resultado.getInt(3)))
                         p.setId(_resultado.getInt(4));
                         p.setNombre(_resultado.getString(6));
                         p.setDescripcion(_resultado.getString(7));
                         p.setNivel(_resultado.getInt(8));
                         p.setPuntaje(_resultado.getInt(9));
                         p.setFecha_hecho(_resultado.getDate(10));
                         p.setFecha_baja(_resultado.getDate(11));
       
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
                    Logger.getLogger(DatosPuntajePantalla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return p;

    }

    @Override
    public ArrayList<PuntajePantalla> ListarPuntajePantallaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarPuntajePantallaDefinitivo(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaMapaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
