/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosRegistroMapa;
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
public class DatosRegistroMapa implements IDatosRegistroMapa {
    
 
    public DatosRegistroMapa()
    {
    
    }
    
//   public int AltaRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaRegistroMapa(?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pRegistroMapa.getMapa().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(3, pRegistroMapa.getTitulo(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pRegistroMapa.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pRegistroMapa.getPuntos_mapa(), java.sql.Types.INTEGER);
//             _comando.setObject(6, pRegistroMapa.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarRegistroMapa(?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pRegistroMapa.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(3, pRegistroMapa.getMapa().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(4, pRegistroMapa.getTitulo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pRegistroMapa.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pRegistroMapa.getPuntos_mapa(), java.sql.Types.INTEGER);
//             _comando.setObject(7, pRegistroMapa.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarRegistroMapa(?, ?)");
//             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pRegistroMapa.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<RegistroMapa> ListarRegistroMapa() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<RegistroMapa> BuscarRegistroMapaPorId(int pIdUsuario ,int pIdRegistroMapa) throws SQLException
//    {

//    }
//    
//    public ArrayList<RegistroMapa> ListarRegistroMapaEliminados() throws SQLException
//    {
//        ArrayList<RegistroMapa> _listaRegistroMapa = new ArrayList<RegistroMapa>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoRegistroMapasEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 RegistroMapa r = new RegistroMapa();
//                 
//                 r.setId(_resultado.getInt(2));
//                // r.setMapa(DatosMapa.BuscarMapaPorId(_resultado.getInt(4)));
//                 r.setTitulo(_resultado.getString(5));
//                 r.setDescripcion(_resultado.getString(6));
//                 r.setPuntos_mapa(_resultado.getInt(7));
//                 r.setFecha_hecho(_resultado.getDate(8));
//                 r.setFecha_baja(_resultado.getDate(9));
//                 
//                 _listaRegistroMapa.add(r);            
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
//        return _listaRegistroMapa;
//        
//    }
//    
//    public int ReingresarRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarRegistroMapa(?, ?)");
//            _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pRegistroMapa.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarRegistroMapaDefinitivo(int pIdUsuario, RegistroMapa pRegistroMapa) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarRegistroMapaDefinitivo(?, ?)");
//             _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
//             _comando.setObject(2, pRegistroMapa.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarListaRegistroMapaDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaRegistroMapaDefinitivo");
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
    public int AltaRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RegistroMapa> ListarRegistroMapa() {
            ArrayList<RegistroMapa> _listaRegistroMapa = new ArrayList<RegistroMapa>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoRegistroMapa()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     RegistroMapa r = new RegistroMapa();

                     r.setId(_resultado.getInt(2));
                    // r.setMapa(DatosMapa.BuscarMapaPorId(_resultado.getInt(4)));
                     r.setTitulo(_resultado.getString(5));
                     r.setDescripcion(_resultado.getString(6));
                     r.setPuntos_mapa(_resultado.getInt(7));
                     r.setFecha_hecho(_resultado.getDate(8));
                     r.setFecha_baja(_resultado.getDate(9));

                     _listaRegistroMapa.add(r);            
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
                           Logger.getLogger(DatosRegistroMapa.class.getName()).log(Level.SEVERE, null, ex);
                       }
            }

            return _listaRegistroMapa;

    }

    @Override
    public RegistroMapa BuscarRegistroMapaPorId(int pIdUsuario, int pIdRegistroMapa) {
                    RegistroMapa r = null;

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoRegistroMapaPorId(?)");
                 _comando.setObject(1, pIdUsuario, java.sql.Types.INTEGER);
                 _comando.setObject(2, pIdRegistroMapa, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();


                 while(_resultado.next())
                 {
                     r = new RegistroMapa();

                     r.setId(_resultado.getInt(2));
                    // r.setMapa(DatosMapa.BuscarMapaPorId(_resultado.getInt(4)));
                     r.setTitulo(_resultado.getString(5));
                     r.setDescripcion(_resultado.getString(6));
                     r.setPuntos_mapa(_resultado.getInt(7));
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
                            Logger.getLogger(DatosRegistroMapa.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }

            return r;
    }

    @Override
    public ArrayList<RegistroMapa> ListarRegistroMapaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarRegistroMapaDefinitivo(int pIdUsuario, RegistroMapa pRegistroMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaRegistroMapaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
