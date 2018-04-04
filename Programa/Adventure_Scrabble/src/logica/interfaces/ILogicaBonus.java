/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Bonus;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaBonus {
    
    int AltaBonus(int pIdUsuario, Bonus pBonus);
     
    int ModificarBonus(int pIdUsuario, Bonus pBonus); 
     
    int BajaBonus(int pIdUsuario, Bonus pBonus);  
    
    Bonus BuscarBonusPorId(int pIdUsuario, int pIdBonus);
    
    ArrayList<Bonus> BuscarBonusPorIdUsuario(int pIdUsuario); 
    
    ArrayList<Bonus> ListarBonusEliminados(); 
    
    int ReingresarBonus(int pIdUsuario, Bonus pBonus);
    
    int EliminarBonusDefinitivo(int pIdUsuario, Bonus pBonus); 
    
    int EliminarListaBonusDefinitivo(); 
    
}
