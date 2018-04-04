/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.TipoMensaje;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaTipoMensaje;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaTipoMensaje implements ILogicaTipoMensaje{

    @Override
    public int AltaTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoMensaje> ListarTipoMensaje() {
        
        ArrayList<TipoMensaje> lista_tipo_mensaje = new ArrayList();
        
        try
        {
             lista_tipo_mensaje = FabricaDatos.getControladorTipoMensaje().ListarTipoMensaje();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista_tipo_mensaje;
    }

    @Override
    public TipoMensaje BuscarTipoMensajePorId(int pIdTipoMensaje, int pIdUsuario) {
        
        TipoMensaje tipo_mensaje = new TipoMensaje();
        
        try
        {
             tipo_mensaje = FabricaDatos.getControladorTipoMensaje().BuscarTipoMensajePorId(pIdTipoMensaje, pIdUsuario);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipo_mensaje;
    }

    @Override
    public ArrayList<TipoMensaje> ListarTipoMensajeEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoMensajeDefinitivo(int pIdUsuario, TipoMensaje pTipoMensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoMensajeDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
