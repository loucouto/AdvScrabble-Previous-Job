/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosTipoOferta;
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
public class DatosTipoOferta implements IDatosTipoOferta{
    
    public DatosTipoOferta()
    {
    
    }
    
//   public int AltaTipoOferta(TipoOferta pTipoOferta) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaTipoOferta(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pTipoOferta.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pTipoOferta.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoOferta.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoOferta.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTipoOferta.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarTipoOferta(TipoOferta pTipoOferta) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarTipoOferta(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pTipoOferta.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pTipoOferta.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pTipoOferta.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pTipoOferta.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pTipoOferta.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pTipoOferta.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaTipoOferta(TipoOferta pTipoOferta) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoOferta(?)");
//             _comando.setObject(1, pTipoOferta.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<TipoOferta> ListarTipoOferta() throws SQLException
//    {

//        
//    }
//    
//    
//    public ArrayList<TipoOferta> BuscarTipoOfertaPorId(int pIdTipoOferta) throws SQLException
//    {

//    }
//    
//    public ArrayList<TipoOferta> ListarTipoOfertaEliminados() throws SQLException
//    {
//        ArrayList<TipoOferta> _listaTipoOferta = new ArrayList<TipoOferta>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoTipoOfertaEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                TipoOferta t = new TipoOferta();
//                 
//                 t.setId(_resultado.getInt(2));
//                 t.setNombre(_resultado.getString(3));
//                 t.setDescripcion(_resultado.getString(4));
//                 t.setUbicacion(_resultado.getString(5));
//                 t.setArchivo(_resultado.getString(6));
//                 t.setFecha_hecho(_resultado.getDate(7));
//                 t.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaTipoOferta.add(t);            
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
//        return _listaTipoOferta;
//        
//    }
//    
//    public int ReingresarTipoOferta(TipoOferta pTipoOferta) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarTipoOferta(?)");
//             _comando.setObject(1, pTipoOferta.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarTipoOfertaDefinitivo(TipoOferta pTipoOferta) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarTipoOfertaDefinitivo(?)");
//             _comando.setObject(1, pTipoOferta.getId(), java.sql.Types.VARCHAR);
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
//    public int EliminarListaTipoOfertaDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaTipoOfertaDefinitivo");
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
    public int AltaTipoOferta(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoOferta(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoOferta(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoOferta> ListarTipoOferta() {
            ArrayList<TipoOferta> _listaTipoOferta = new ArrayList<TipoOferta>();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoTipoOferta()");
                 _resultado = _comando.executeQuery();

                 while(_resultado.next())
                 {
                     TipoOferta t = new TipoOferta();

                     t.setId(_resultado.getInt(1));
                     t.setNombre(_resultado.getString(2));
                     t.setDescripcion(_resultado.getString(3));
                     t.setUbicacion(_resultado.getString(4));
                     t.setArchivo(_resultado.getString(5));
                     t.setFecha_hecho(_resultado.getDate(6));
                     t.setFecha_baja(_resultado.getDate(7));

                     _listaTipoOferta.add(t);            
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
                    Logger.getLogger(DatosTipoOferta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return _listaTipoOferta;
    }

    @Override
    public TipoOferta BuscarTipoOfertaPorId(int pIdTipoOferta) {
                TipoOferta t = new TipoOferta();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoTipoOfertaPorId(?)");
                     _comando.setObject(1, pIdTipoOferta, java.sql.Types.INTEGER);
                     _resultado = _comando.executeQuery();
                    
                     
                     while(_resultado.next())
                     {
                        t = new TipoOferta();
                         
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
                        Logger.getLogger(DatosTipoOferta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                return t;
                
    }

    @Override
    public ArrayList<TipoOferta> ListarTipoOfertaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoOferta(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoOfertaDefinitivo(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoOfertaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
