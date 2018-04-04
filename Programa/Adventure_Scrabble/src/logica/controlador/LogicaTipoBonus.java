/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;
import datos.fachada.FabricaDatos;
import entidades_compartidas.TipoBonus;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaTipoBonus;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaTipoBonus implements ILogicaTipoBonus{

    @Override
    public int AltaTipoBonus(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoBonus(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoBonus(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoBonus> ListarTipoBonus() {
        
        ArrayList<TipoBonus> lista_tipo_bonus = new ArrayList();
        try
        {
            lista_tipo_bonus = FabricaDatos.getControladorTipoBonus().ListarTipoBonus();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_tipo_bonus;
    }

    @Override
    public TipoBonus BuscarTipoBonusPorId(int pIdTipoBonus) {
        
        TipoBonus tipo_bonus = new TipoBonus();
        try
        {
            tipo_bonus = FabricaDatos.getControladorTipoBonus().BuscarTipoBonusPorId(pIdTipoBonus);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipo_bonus;
    }

    @Override
    public ArrayList<TipoBonus> ListarTipoBonusEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoBonus(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoBonusDefinitivo(TipoBonus pTipoBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoBonusDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
