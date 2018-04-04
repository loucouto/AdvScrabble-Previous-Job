/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosTipoCondicionante;
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
public class DatosTipoCondicionante implements IDatosTipoCondicionante{
    
    public DatosTipoCondicionante()
    {
    
    }
    
//   public int AltaTipoCondicionante(TipoCondicionante pTipoCondicionante) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaTipoCondicionante(?, ?, ?, ?)");
//             _comando.setObject(1, pTipoCondicionante.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pTipoCondicionante.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoCondicionante.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarTipoCondicionante(TipoCondicionante pTipoCondicionante) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarTipoCondicionante(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pTipoCondicionante.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pTipoCondicionante.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoCondicionante.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoCondicionante.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaTipoCondicionante(TipoCondicionante pTipoCondicionante) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoCondicionante(?)");
//             _comando.setObject(1, pTipoCondicionante.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<TipoCondicionante> ListarTipoCondicionante() throws SQLException
//    {

//    }
//    
//    
//    public ArrayList<TipoCondicionante> BuscarTipoCondicionantePorId(int pIdTipoCondicionante) throws SQLException
//    {

//    }
//    
//    public ArrayList<TipoCondicionante> ListarTipoCondicionanteEliminados() throws SQLException
//    {
//        ArrayList<TipoCondicionante> _listaTipoCondicionante = new ArrayList<TipoCondicionante>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoTipoCondicionanteEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                TipoCondicionante t = new TipoCondicionante();
//                 
//                 t.setId(_resultado.getInt(1));
//                 t.setNombre(_resultado.getString(2));
//                 t.setDescripcion(_resultado.getString(3));
//                 t.setFecha_hecho(_resultado.getDate(4));
//                 t.setFecha_baja(_resultado.getDate(5));
//                 
//                 _listaTipoCondicionante.add(t);       
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
//        return _listaTipoCondicionante;
//        
//    }
//    
//    public int ReingresarTipoCondicionante(TipoCondicionante pTipoCondicionante) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarTipoCondicionante(?)");
//             _comando.setObject(1, pTipoCondicionante.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarTipoCondicionanteDefinitivo(TipoCondicionante pTipoCondicionante) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoCondicionanteDefinitivo(?)");
//             _comando.setObject(1, pTipoCondicionante.getId(), java.sql.Types.VARCHAR);
//             _comando.registerOutParameter(6, java.sql.Types.INTEGER);
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
//    public int EliminarListaTipoCondicionanteDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaTipoCondicionanteDefinitivo");
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

    @Override
    public int AltaTipoCondicionante(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoCondicionante(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoCondicionante(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoCondicionante> ListarTipoCondicionante() {
            ArrayList<TipoCondicionante> _listaTipoCondicionante = new ArrayList<TipoCondicionante>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTipoCondicionante");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     TipoCondicionante t = new TipoCondicionante();

                     t.setId(_resultado.getInt(1));
                     t.setNombre(_resultado.getString(2));
                     t.setDescripcion(_resultado.getString(3));
                     t.setFecha_hecho(_resultado.getDate(4));
                     t.setFecha_baja(_resultado.getDate(5));

                     _listaTipoCondicionante.add(t);            
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
                    Logger.getLogger(DatosTipoCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _listaTipoCondicionante;
                    
    }

    @Override
    public TipoCondicionante BuscarTipoCondicionantePorId(int pIdTipoCondicionante) {
            TipoCondicionante t = new TipoCondicionante();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTipoCondicionantePorId(?)");
                 _comando.setObject(1, pIdTipoCondicionante, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     t = new TipoCondicionante();

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
                    Logger.getLogger(DatosTipoCondicionante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return t;

    }

    @Override
    public ArrayList<TipoCondicionante> ListarTipoCondicionanteEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoCondicionante(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoCondicionanteDefinitivo(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoCondicionanteDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
