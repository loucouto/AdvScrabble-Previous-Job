/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Condicionante;
import java.util.ArrayList;
import logica.interfaces.ILogicaCondicionante;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaCondicionante implements ILogicaCondicionante {

    @Override
    public int AltaCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Condicionante> ListarCondicionante() {
          
        ArrayList<Condicionante> lista_condicionante = new ArrayList();
        
        try
        {
            lista_condicionante = FabricaDatos.getControladorCondicionante().ListarCondicionante();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_condicionante;
        
    }

    @Override
    public Condicionante BuscarCondicionantePorId(int pIdMapa, int pIdPantalla, int pIdCondicionante) {
        
        Condicionante retorno = new Condicionante();
        try
        {
            retorno = FabricaDatos.getControladorCondicionante().BuscarCondicionantePorId(1, 1, 1);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<Condicionante> ListarCondicionanteEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarCondicionanteDefinitivo(int pIdMapa, int pIdPantalla, Condicionante pCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaCondicionanteDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
