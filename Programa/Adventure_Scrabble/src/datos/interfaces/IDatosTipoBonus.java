/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.TipoBonus;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosTipoBonus {
    
    int AltaTipoBonus(TipoBonus pTipoBonus); 
     
    int ModificarTipoBonus(TipoBonus pTipoBonus);
     
    int BajaTipoBonus(TipoBonus pTipoBonus);
    
    ArrayList<TipoBonus> ListarTipoBonus();
    
    TipoBonus BuscarTipoBonusPorId(int pIdTipoBonus);
    
    ArrayList<TipoBonus> ListarTipoBonusEliminados();
    
    int ReingresarTipoBonus(TipoBonus pTipoBonus);
    
    int EliminarTipoBonusDefinitivo(TipoBonus pTipoBonus);
    
    int EliminarListaTipoBonusDefinitivo();
    
}
