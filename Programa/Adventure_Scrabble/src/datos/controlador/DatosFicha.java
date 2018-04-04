/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.controlador;

import datos.interfaces.IDatosFicha;
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
public class DatosFicha implements IDatosFicha {
    
    public DatosFicha()
    {
    
    }
    
//    public int AltaFicha(Ficha pFicha) throws SQLException
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
//             _comando = _conexion.prepareCall("call spAltaFicha(?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1,pFicha.getModelo().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pFicha.getNumero_ficha(), java.sql.Types.INTEGER);
//             _comando.setObject(3, pFicha.getPuntaje_ficha(), java.sql.Types.INTEGER);
//             _comando.setObject(4, pFicha.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(5, pFicha.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pFicha.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pFicha.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(8, pFicha.getFecha_hecho(), java.sql.Types.DATE);
//             _comando.registerOutParameter(9, java.sql.Types.INTEGER);
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
//    public int ModificarFicha(Ficha pFicha) throws SQLException
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
//             _comando = _conexion.prepareCall("call spModificarFicha(?, ?, ?, ?, ?, ?, ?, ?, ?)");
//             _comando.setObject(1, pFicha.getId(), java.sql.Types.INTEGER);
//             _comando.setObject(2, pFicha.getModelo().getId(), java.sql.Types.INTEGER);
//             _comando.setObject(3, pFicha.getNumero_ficha(), java.sql.Types.INTEGER);
//             _comando.setObject(4, pFicha.getPuntaje_ficha(), java.sql.Types.INTEGER);
//             _comando.setObject(5, pFicha.getNombre(), java.sql.Types.VARCHAR);
//             _comando.setObject(6, pFicha.getDescripcion(), java.sql.Types.VARCHAR);
//             _comando.setObject(7, pFicha.getUbicacion(), java.sql.Types.VARCHAR);
//             _comando.setObject(8, pFicha.getArchivo(), java.sql.Types.VARCHAR);
//             _comando.setObject(9, pFicha.getFecha_hecho(), java.sql.Types.DATE);
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
//    public int BajaFicha(Ficha pFicha) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarFicha(?)");
//             _comando.setObject(1, pFicha.getId(), java.sql.Types.INTEGER);
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
//    public ArrayList<Ficha> ListarFicha() throws SQLException
//    {
       
//    }
//    
//    
//    public ArrayList<Ficha> BuscarFichaPorId(int pIdFicha) throws SQLException
//    {

//        
//    }
//    
//    public ArrayList<Ficha> ListarFichaEliminados() throws SQLException
//    {
//        ArrayList<Ficha> _listaFicha = new ArrayList<Ficha>();
//        
//        Connection _conexion = null;
//        CallableStatement _comando = null;
//        ResultSet _resultado;
//        
//        try
//        {
//             Class.forName("com.mysql.jdbc.Driver").newInstance();
//             _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
//             _comando = _conexion.prepareCall("spObtenerListadoFichaEliminados");
//             _resultado = _comando.executeQuery();
//             
//             while(_resultado.next())
//             {
//                 Ficha f = new Ficha();
//                     
//                f.setId(_resultado.getInt(2));
//                // f.setModelo(DatosModelo.BuscarModeloPorId(_resultado.getString(3)));
//                 f.setNumero_ficha(_resultado.getInt(4));
//                 f.setPuntaje_ficha(_resultado.getInt(5));
//                 f.setNombre(_resultado.getString(6));
//                 f.setDescripcion(_resultado.getString(7));
//                 f.setArchivo(_resultado.getString(8));
//                 f.setUbicacion(_resultado.getString(9));
//                 f.setArchivo(_resultado.getString(10));
//                 f.setFecha_hecho(_resultado.getDate(11));
//                 f.setFecha_baja(_resultado.getDate(12));
//                 
//                 _listaFicha.add(f);          
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
//        return _listaFicha;
//        
//    }
//    
//    public int ReingresarFicha(Ficha pFicha) throws SQLException
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
//             _comando = _conexion.prepareCall("call spReingresarFicha(?)");
//             _comando.setObject(1, pFicha.getId(), java.sql.Types.INTEGER);
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
//    public int EliminarFichaDefinitivo(Ficha pFicha) throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarFichaDefinitivo(?)");
//             _comando.setObject(1, pFicha.getId(), java.sql.Types.VARCHAR);
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
//    public int EliminarListaFichaDefinitivo() throws SQLException
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
//             _comando = _conexion.prepareCall("call spEliminarListaFichaDefinitivo");
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
    public int AltaFicha(Ficha pFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarFicha(Ficha pFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaFicha(Ficha pFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Ficha> ListarFicha() {
                        ArrayList<Ficha> _listaFicha = new ArrayList<Ficha>();
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoFicha()");
                     _resultado = _comando.executeQuery();
                     
                     while(_resultado.next())
                     {
                        Ficha f = new Ficha();
                             
                        f.setId(_resultado.getInt(2));
                        // f.setModelo(DatosModelo.BuscarModeloPorId(_resultado.getString(3)));
                         f.setNumero_ficha(_resultado.getInt(4));
                         f.setPuntaje_ficha(_resultado.getInt(5));
                         f.setNombre(_resultado.getString(6));
                         f.setDescripcion(_resultado.getString(7));
                         f.setUbicacion(_resultado.getString(8));
                         f.setArchivo(_resultado.getString(9));
                         f.setFecha_hecho(_resultado.getDate(10));
                         f.setFecha_baja(_resultado.getDate(11));
                         
                         _listaFicha.add(f);            
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
                                Logger.getLogger(DatosFicha.class.getName()).log(Level.SEVERE, null, ex);
                            }
                }
                
                return _listaFicha;
         
    }

    @Override
    public Ficha BuscarFichaPorId(int pIdFicha) {
                Ficha f = null;
                
                Connection _conexion = null;
                CallableStatement _comando = null;
                ResultSet _resultado;
                
                try
                {
                     Class.forName("com.mysql.jdbc.Driver").newInstance();
                     _conexion = DriverManager.getConnection(DatosConstantes.servidor + DatosConstantes.bd,DatosConstantes.usuario,DatosConstantes.password);
                     _comando = _conexion.prepareCall("call spObtenerListadoFichaPorId(?)");
                     _comando.setObject(1, pIdFicha, java.sql.Types.INTEGER);
                     _resultado = _comando.executeQuery();
                    
                     while(_resultado.next())
                     {
                        f = new Ficha();
                             
                         f.setId(_resultado.getInt(2));
                        // f.setModelo(DatosModelo.BuscarModeloPorId(_resultado.getString(3)));
                         f.setNumero_ficha(_resultado.getInt(4));
                         f.setPuntaje_ficha(_resultado.getInt(5));
                         f.setNombre(_resultado.getString(6));
                         f.setDescripcion(_resultado.getString(7));
                         f.setUbicacion(_resultado.getString(8));
                         f.setArchivo(_resultado.getString(9));
                         f.setFecha_hecho(_resultado.getDate(10));
                         f.setFecha_baja(_resultado.getDate(11));
            
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
                               Logger.getLogger(DatosFicha.class.getName()).log(Level.SEVERE, null, ex);
                           }
                }
                
                return f;
    }

    @Override
    public ArrayList<Ficha> ListarFichaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarFicha(Ficha pFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarFichaDefinitivo(Ficha pFicha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaFichaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
