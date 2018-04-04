/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Bonus;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaBonus;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaBonus implements ILogicaBonus{

    @Override
    public int AltaBonus(int pIdUsuario, Bonus pBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarBonus(int pIdUsuario, Bonus pBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaBonus(int pIdUsuario, Bonus pBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bonus BuscarBonusPorId(int pIdUsuario, int pIdBonus) {
        Bonus bonus = new Bonus();
        try
        {
            bonus = FabricaDatos.getControladorBonus().BuscarBonusPorId(pIdUsuario, pIdBonus);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bonus;
    }

    @Override
    public ArrayList<Bonus> ListarBonusEliminados() {
       ArrayList<Bonus> lista_bonus = new ArrayList();
        try
        {
            lista_bonus = FabricaDatos.getControladorBonus().ListarBonus();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_bonus;
    }

    @Override
    public int ReingresarBonus(int pIdUsuario, Bonus pBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarBonusDefinitivo(int pIdUsuario, Bonus pBonus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaBonusDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Bonus> BuscarBonusPorIdUsuario(int pIdUsuario) {
        
       ArrayList<Bonus> lista_bonus = new ArrayList();
        try
        {
            lista_bonus = FabricaDatos.getControladorBonus().BuscarBonusPorIdUsuario(pIdUsuario);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_bonus;
    }
    
}
