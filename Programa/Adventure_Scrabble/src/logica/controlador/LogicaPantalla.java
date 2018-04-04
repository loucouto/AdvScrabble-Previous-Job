/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Pantalla;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaPantalla;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaPantalla implements ILogicaPantalla{

    @Override
    public int AltaPantalla(Pantalla pPantalla, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarPantalla(Pantalla pPantalla, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaPantalla(Pantalla pPantalla, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pantalla> ListarPantalla() {
        ArrayList<Pantalla> lista_pantalla = new ArrayList();
        try
        {
            lista_pantalla = FabricaDatos.getControladorPantalla().ListarPantalla();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_pantalla;
    }

    @Override
    public Pantalla BuscarPantallaPorId(int pIdMapa, int pIdPantalla) {
        Pantalla pantalla = new Pantalla();
        try
        {
            pantalla = FabricaDatos.getControladorPantalla().BuscarPantallaPorId(pIdMapa, pIdPantalla);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pantalla;
    }

    @Override
    public ArrayList<Pantalla> ListadoPantallasEliminadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarPantalla(int pIdMapa, Pantalla pPantalla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarPantallaDefinitivo(Pantalla pPantalla, int pIdMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaPantallaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
