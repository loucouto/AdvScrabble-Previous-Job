/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.PuntajePantalla;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaPuntajePantalla;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaPuntajePantalla implements ILogicaPuntajePantalla{

    @Override
    public int AltaPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PuntajePantalla> ListarPuntajePantalla() {
        
        ArrayList<PuntajePantalla> lista_puntaje_pantalla = new ArrayList();
        try
        {
            lista_puntaje_pantalla = FabricaDatos.getControladorPuntajePantalla().ListarPuntajePantalla();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_puntaje_pantalla;
    }

    @Override
    public PuntajePantalla BuscarPuntajePantallaPorId(int pIdMapa, int pIdPantalla, int pIdEstrella, int pIdPuntajePantalla) {
        PuntajePantalla puntaje_pantalla = new PuntajePantalla();
        try
        {
            puntaje_pantalla = FabricaDatos.getControladorPuntajePantalla().BuscarPuntajePantallaPorId(pIdMapa, pIdPantalla, pIdPuntajePantalla);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puntaje_pantalla;
    }

    @Override
    public ArrayList<PuntajePantalla> ListarPuntajePantallaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarPuntajePantallaDefinitivo(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaMapaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
