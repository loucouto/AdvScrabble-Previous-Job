/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Jugador;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaJugador;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaJugador implements ILogicaJugador{

    @Override
    public int AltaJugador(Jugador pJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarJugador(Jugador pJugador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Jugador> ListarJugador() {
        ArrayList<Jugador> lista_jugador = new ArrayList();
        try
        {
            lista_jugador = FabricaDatos.getControladorJugador().ListarJugador();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_jugador;
    }

    @Override
    public Jugador BuscarJugadorPorId(int pIdUsuario) {
        Jugador jugador = new Jugador();
        try
        {
            jugador = FabricaDatos.getControladorJugador().BuscarJugadorPorId(pIdUsuario);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jugador;
    }

    @Override
    public ArrayList<Jugador> ListarJugadorEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
