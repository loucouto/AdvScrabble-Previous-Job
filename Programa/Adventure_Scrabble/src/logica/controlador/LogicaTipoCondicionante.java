/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.TipoCondicionante;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaTipoCondicionante;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaTipoCondicionante implements ILogicaTipoCondicionante {

    @Override
    public int AltaTipoCondicionante(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoCondicionante(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoCondicionante(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoCondicionante> ListarTipoCondicionante() {
       
        ArrayList<TipoCondicionante> lista_tipo_condicionante = new ArrayList();
        
        try
        {
            lista_tipo_condicionante = FabricaDatos.getControladorTipoCondicionante().ListarTipoCondicionante();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista_tipo_condicionante;
    }

    @Override
    public TipoCondicionante BuscarTipoCondicionantePorId(int pIdTipoCondicionante) {
        
        TipoCondicionante condicionante = new TipoCondicionante();
        
        try
        {
             condicionante = FabricaDatos.getControladorTipoCondicionante().BuscarTipoCondicionantePorId(pIdTipoCondicionante);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return condicionante;
    }

    @Override
    public ArrayList<TipoCondicionante> ListarTipoCondicionanteEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoCondicionante(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoCondicionanteDefinitivo(TipoCondicionante pTipoCondicionante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoCondicionanteDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
