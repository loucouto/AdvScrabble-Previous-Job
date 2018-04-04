/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Objetivo;
import java.util.ArrayList;
import logica.interfaces.ILogicaObjetivo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaObjetivo implements ILogicaObjetivo{

    @Override
    public int AltaObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Objetivo> ListarObjetivo() {
       ArrayList<Objetivo> lista_objetivo = new ArrayList();
        try
        {
            lista_objetivo = FabricaDatos.getControladorObjetivo().ListarObjetivo();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_objetivo;
    }

    @Override
    public Objetivo BuscarObjetivoPorId(int pIdMapa, int pIdPantalla, int pIdObjetivo) {
        Objetivo objetivo = new Objetivo();
        try
        {
            objetivo = FabricaDatos.getControladorObjetivo().BuscarObjetivoPorId(pIdMapa, pIdPantalla, pIdObjetivo);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetivo;
    }

    @Override
    public ArrayList<Objetivo> ListarObjetivoEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarObjetivoDefinitivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaObjetivoDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
