/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.TipoJugador;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaTipoJugador;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaTipoJugador implements ILogicaTipoJugador{

    @Override
    public int AltaTipoJugador(TipoJugador pTipoJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoJugador(TipoJugador pTipoJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoJugador(TipoJugador pTipoJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoJugador> ListarTipoJugador() {
        
        ArrayList<TipoJugador> lista_tipo_jugador = new ArrayList();
        try
        {
             lista_tipo_jugador = FabricaDatos.getControladorTipoJugador().ListarTipoJugador();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista_tipo_jugador;
    }

    @Override
    public TipoJugador BuscarTipoJugadorPorId(int pIdTipoJugador) {
        
        TipoJugador jugador = new TipoJugador();
        
        try
        {
             jugador = FabricaDatos.getControladorTipoJugador().BuscarTipoJugadorPorId(pIdTipoJugador);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jugador;
    }

    @Override
    public ArrayList<TipoJugador> ListarTipoJugadorEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoJugador(TipoJugador pTipoJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoJugadorDefinitivo(TipoJugador pTipoJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoJugadorDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
