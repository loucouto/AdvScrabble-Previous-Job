/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Mapa;
import java.util.ArrayList;
import logica.interfaces.ILogicaMapa;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaMapa implements ILogicaMapa{

    @Override
    public int AltaMapa(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarMapa(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaMapa(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Mapa> ListarMapa() {
        ArrayList<Mapa> lista_mapa = new ArrayList();
        try
        {
            lista_mapa = FabricaDatos.getControladorMapa().ListarMapa();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_mapa;
    }

    @Override
    public Mapa BuscarMapaPorId(int pIdMapa) {
        Mapa mapa = new Mapa();
        try
        {
            mapa = FabricaDatos.getControladorMapa().BuscarMapaPorId(pIdMapa);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;
    }

    @Override
    public ArrayList<Mapa> ListarMapaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarMapa(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarMapaDefinitivo(Mapa pMapa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaMapaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
