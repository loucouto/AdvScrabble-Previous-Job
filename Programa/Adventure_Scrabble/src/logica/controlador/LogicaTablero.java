/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Tablero;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaTablero;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaTablero implements ILogicaTablero{

    @Override
    public int AltaTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tablero> ListarTablero() {
        
        ArrayList<Tablero> lista_tablero = new ArrayList();
        try
        {
            lista_tablero = FabricaDatos.getControladorTablero().ListarTablero();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_tablero;
    }

    @Override
    public Tablero BuscarTableroPorId(int pIdMapa, int pIdPantalla, int pIdTablero) {
        
        Tablero tablero = new Tablero();
        try
        {
            tablero = FabricaDatos.getControladorTablero().BuscarTableroPorId(pIdMapa, pIdPantalla, pIdTablero);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablero;
    }

    @Override
    public ArrayList<Tablero> ListarTablerosEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTablero(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTableroDefinitivo(int pIdMapa, int pIdPantalla, Tablero pTablero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTableroDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
