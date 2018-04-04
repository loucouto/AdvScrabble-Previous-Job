/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosRegistroPantalla;
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
public class DatosRegistroPantalla implements IDatosRegistroPantalla {
    
    public DatosRegistroPantalla()
    {
    
    }
//    
//    public int AltaRegistroPantalla(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaRegistroPantalla(?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdRegistroMapa, java.sql.Types.INTEGER);
//             _comando.setObject(3, pRegistroPantalla.getPantalla().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(4, pRegistroPantalla.getTitulo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pRegistroPantalla.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pRegistroPantalla.getPuntos_pantalla(), java.sql.Types.INTEGER);
//             _comando.setObject(7, pRegistroPantalla.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarRegistroPantalla(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarRegistroPantalla(?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pRegistroPantalla.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdRegistroMapa, java.sql.Types.INTEGER);
//             _comando.setObject(4, pRegistroPantalla.getPantalla().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(5, pRegistroPantalla.getTitulo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pRegistroPantalla.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pRegistroPantalla.getPuntos_pantalla(), java.sql.Types.INTEGER);
//             _comando.setObject(8, pRegistroPantalla.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaRegistroPantalla(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarRegistroPantalla(?, ?)");
//             _comando.setObject(1, pRegistroPantalla.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdRegistroMapa, java.sql.Types.INTEGER);
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
//    public ArrayList<RegistroPantalla> ListarRegistroPantalla() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<RegistroPantalla> BuscarRegistroPantallaPorId(int pIdUsuario, int pIdRegistroMapa, int pIdRegistroPantalla) throws SQLException
//    {

//        
//    }
//    
//    public ArrayList<RegistroPantalla> ListarRegistroPantallaEliminados() throws SQLException
//    {
//        ArrayList<RegistroPantalla> _listaRegistroPantalla = new ArrayList<RegistroPantalla>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoRegistroPantallaEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                  RegistroPantalla r = new RegistroPantalla();
//                 
//                 r.setId(_resultado.getInt(2));
//                 // r.setMapa(DatosMapa.BuscarMapaPorId(_resultado.getInt(4)));
//                // r.setPantalla(DatosMapa.BuscarPantallaPorId(_resultado.getInt(4)));
//                 r.setTitulo(_resultado.getString(5));
//                 r.setDescripcion(_resultado.getString(6));
//                 r.setPuntos_pantalla(_resultado.getInt(7));
//                 r.setFecha_hecho(_resultado.getDate(8));
//                 r.setFecha_baja(_resultado.getDate(9));
//                 
//                 _listaRegistroPantalla.add(r);               
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
//        return _listaRegistroPantalla;
//        
//    }
//    
//    public int ReingresarRegistroPantalla(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarRegistroPantalla(?, ?)");
//             _comando.setObject(1, pRegistroPantalla.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdRegistroMapa, java.sql.Types.INTEGER);
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
//    public int EliminarRegistroPantallaDefinitivo(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarRegistroPantallaDefinitivo(?, ?)");
//             _comando.setObject(1, pRegistroPantalla.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(3, pIdRegistroMapa, java.sql.Types.INTEGER);
//             /*_comando.registerOutParameter(6, java.sql.Types.INTEGER);*/
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
//    public int EliminarListaRegistroPantallaDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaRegistroPantallaDefinitivo");
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
    public int AltaRegistroPantalla(int pIdUsuario, int pIdRegistroMapa, RegistroPantalla pRegistroPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarRegistroPantalla(int pIdUsuario, int pIdRegistroMapa, RegistroPantalla pRegistroPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaRegistroPantalla(int pIdUsuario, int pIdRegistroMapa, RegistroPantalla pRegistroPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RegistroPantalla> ListarRegistroPantalla() {
            ArrayList<RegistroPantalla> _listaRegistroPantalla = new ArrayList<RegistroPantalla>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoRegistroPantalla()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     RegistroPantalla r = new RegistroPantalla();

                     r.setId(_resultado.getInt(2));
                     // r.setMapa(DatosMapa.BuscarMapaPorId(_resultado.getInt(4)));
                    // r.setPantalla(DatosMapa.BuscarPantallaPorId(_resultado.getInt(4)));
                     r.setTitulo(_resultado.getString(5));
                     r.setDescripcion(_resultado.getString(6));
                     r.setPuntos_pantalla(_resultado.getInt(7));
                     r.setFecha_hecho(_resultado.getDate(8));
                     r.setFecha_baja(_resultado.getDate(9));

                     _listaRegistroPantalla.add(r);            
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
                            Logger.getLogger(DatosRegistroPantalla.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }

            return _listaRegistroPantalla;

    }

    @Override
    public RegistroPantalla BuscarRegistroPantallaPorId(int pIdUsuario, int pIdRegistroMapa, int pIdRegistroPantalla) {
            RegistroPantalla r = new  RegistroPantalla();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoRegistroPantallaPorId(?, ?, ?)");
                 _comando.setObject(1, pIdRegistroPantalla, java.sql.Types.INTEGER);
                 _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
                 _comando.setObject(3, pIdRegistroMapa, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     r = null;

                     r.setId(_resultado.getInt(2));
                     // r.setMapa(DatosMapa.BuscarMapaPorId(_resultado.getInt(4)));
                    // r.setPantalla(DatosMapa.BuscarPantallaPorId(_resultado.getInt(4)));
                     r.setTitulo(_resultado.getString(5));
                     r.setDescripcion(_resultado.getString(6));
                     r.setPuntos_pantalla(_resultado.getInt(7));
                     r.setFecha_hecho(_resultado.getDate(8));
                     r.setFecha_baja(_resultado.getDate(9));        

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
                    Logger.getLogger(DatosRegistroPantalla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return r;
    }

    @Override
    public ArrayList<RegistroPantalla> ListarRegistroPantallaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarRegistroPantalla(int pIdUsuario, int pIdRegistroMapa, RegistroPantalla pRegistroPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarRegistroPantallaDefinitivo(int pIdUsuario, int pIdRegistroMapa, RegistroPantalla pRegistroPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaRegistroPantallaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
