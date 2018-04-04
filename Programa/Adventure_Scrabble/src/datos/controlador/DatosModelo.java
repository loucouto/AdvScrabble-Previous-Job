/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosModelo;
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
public class DatosModelo implements IDatosModelo {

    public DatosModelo()
    {
    
    }
    
//    public int AltaModelo(Modelo pModelo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaModelo(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pModelo.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(2, pModelo.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pModelo.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pModelo.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pModelo.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int ModificarModelo(Modelo pModelo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarModelo(?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pModelo.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pModelo.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(3, pModelo.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(4, pModelo.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pModelo.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pModelo.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaModelo(Modelo pModelo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarModelo(?)");
//             _comando.setObject(1, pModelo.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<Modelo> ListarModelo() throws SQLException
//    {
//        
//    }
//    
//    
//    public ArrayList<Modelo> BuscarModeloPorId(int pIdModelo) throws SQLException
//    {
//    }
//    
//    public ArrayList<Modelo> ListarModeloEliminados() throws SQLException
//    {
//        ArrayList<Modelo> _listaModelo = new ArrayList<Modelo>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoModeloEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 Modelo m = new Modelo();
//                 
//                 m.setId(_resultado.getInt(2));
//                 m.setNombre(_resultado.getString(3));
//                 m.setDescripcion(_resultado.getString(4));
//                 m.setUbicacion(_resultado.getString(5));
//                 m.setArchivo(_resultado.getString(6));
//                 m.setFecha_hecho(_resultado.getDate(7));
//                 m.setFecha_baja(_resultado.getDate(8));
//                 
//                 _listaModelo.add(m);            
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
//        return _listaModelo;
//        
//    }
//    
//    public int ReingresarModelo(Modelo pModelo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarModelo(?)");
//             _comando.setObject(1, pModelo.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarModeloDefinitivo(Modelo pModelo) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarModeloDefinitivo(?)");
//             _comando.setObject(1, pModelo.getId(), java.sql.Types.VARCHAR);
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
//    public int EliminarListaModeloDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaModeloDefinitivo");
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

    @Override
    public int AltaModelo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarModelo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaModelo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Modelo> ListarModelo() {
                       ArrayList<Modelo> _listaModelo = new ArrayList<Modelo>();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoModelo()");
                     _resultado = _comando.executeQuery();
                     
                     while(_resultado.next())
                     {
                         Modelo m = new Modelo();
                         
                         m.setId(_resultado.getInt(1));
                         m.setNombre(_resultado.getString(2));
                         m.setDescripcion(_resultado.getString(3));
                         m.setUbicacion(_resultado.getString(4));
                         m.setArchivo(_resultado.getString(5));
                         m.setFecha_hecho(_resultado.getDate(6));
                         m.setFecha_baja(_resultado.getDate(7));
                         
                         _listaModelo.add(m);            
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
                               Logger.getLogger(DatosModelo.class.getName()).log(Level.SEVERE, null, ex);
                           }
                }
                
                return _listaModelo;

    }

    @Override
    public Modelo BuscarModeloPorId(int pIdModelo) {
            Modelo m = new Modelo();

            Connection _conexion = null;
            CallableStatement _comando = null;
            ResultSet _resultado;

            try
            {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                 _comando = _conexion.prepareCall("call spObtenerListadoModeloPorId(?)");
                 _comando.setObject(1, pIdModelo, java.sql.Types.INTEGER);
                 _resultado = _comando.executeQuery();


                 while(_resultado.next())
                 {
                         m = new Modelo();

                         m.setId(_resultado.getInt(1));
                         m.setNombre(_resultado.getString(2));
                         m.setDescripcion(_resultado.getString(3));
                         m.setUbicacion(_resultado.getString(4));
                         m.setArchivo(_resultado.getString(5));
                         m.setFecha_hecho(_resultado.getDate(6));
                         m.setFecha_baja(_resultado.getDate(7));

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
                           Logger.getLogger(DatosModelo.class.getName()).log(Level.SEVERE, null, ex);
                       }
            }

            return m;
    }

    @Override
    public ArrayList<Modelo> ListarModeloEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarModelo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarModeloDefinitivo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaModeloDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
