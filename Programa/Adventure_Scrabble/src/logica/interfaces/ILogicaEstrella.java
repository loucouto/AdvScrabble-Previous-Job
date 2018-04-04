/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Estrella;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaEstrella {
    
    public int AltaEstrella(Estrella pEstrella);
    
    public int ModificarEstrella(Estrella pEstrella);
     
    public int BajaEstrella(Estrella pEstrella); 
    
    public ArrayList<Estrella> ListarEstrella(); 
    
    Estrella BuscarEstrellaPorId(int pIdEstrella); 
    
    public ArrayList<Estrella> ListarEstrellaEliminados(); 
    
    public int ReingresarEstrella(Estrella pEstrella);
    
    public int EliminarEstrellaDefinitivo(Estrella pEstrella); 
    
    public int EliminarListaEstrellaDefinitivo();
}
