/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Ficha;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaFicha {
    
    int AltaFicha(Ficha pFicha); 
     
    int ModificarFicha(Ficha pFicha);
    
    int BajaFicha(Ficha pFicha); 
    
    ArrayList<Ficha> ListarFicha(); 
    
    Ficha BuscarFichaPorId(int pIdFicha);
    
    public ArrayList<Ficha> ListarFichaEliminados();
    
    public int ReingresarFicha(Ficha pFicha);
    
    public int EliminarFichaDefinitivo(Ficha pFicha); 
    
    public int EliminarListaFichaDefinitivo(); 
    
}
