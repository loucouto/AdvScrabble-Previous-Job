/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;
import datos.fachada.FabricaDatos;
import entidades_compartidas.TipoObjetivo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaTipoObjetivo;
/**
 *
 * @author ubuntulourdes
 *//**
 *
 * @author ubuntulourdes
 */
public class LogicaTipoObjetivo implements ILogicaTipoObjetivo{

    @Override
    public int AltaTipoObjetivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoObjetivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoObjetivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoObjetivo> ListarTipoObjetivo() {
        
        ArrayList<TipoObjetivo> lista_tipo_objetivo = new ArrayList();
        
        try
        {
             lista_tipo_objetivo = FabricaDatos.getControladorTipoObjetivo().ListarTipoObjetivo();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista_tipo_objetivo;
    }

    @Override
    public TipoObjetivo BuscarTipoObjetivoPorId(int pIdTipoObjetivo) {
        
        TipoObjetivo tipo_objetivo = new TipoObjetivo();
        
        try
        {
             tipo_objetivo = FabricaDatos.getControladorTipoObjetivo().BuscarTipoObjetivoPorId(pIdTipoObjetivo);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipo_objetivo;
    }

    @Override
    public ArrayList<TipoObjetivo> ListarTipoObjetivoEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoObjetivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoObjetivoDefinitivo(TipoObjetivo pTipoObjetivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoObjetivoDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
