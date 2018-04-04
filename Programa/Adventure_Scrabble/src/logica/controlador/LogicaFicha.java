/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.*;
import entidades_compartidas.Ficha;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaFicha;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaFicha implements ILogicaFicha{

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
        ArrayList<Ficha> lista_ficha = new ArrayList();
        try
        {
            lista_ficha = FabricaDatos.getControladorFicha().ListarFicha();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_ficha;
    }

    @Override
    public Ficha BuscarFichaPorId(int pIdFicha) {
        Ficha ficha = new Ficha();
        try
        {
            ficha = FabricaDatos.getControladorFicha().BuscarFichaPorId(pIdFicha);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ficha;
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
