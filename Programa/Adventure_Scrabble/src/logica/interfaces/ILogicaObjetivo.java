/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Objetivo;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaObjetivo {
    
    int AltaObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo);
     
    int ModificarObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo);
     
    int BajaObjetivo(int pIdMapa, int pIdPantalla, Objetivo pObjetivo); 
    
    ArrayList<Objetivo> ListarObjetivo();
    
    Objetivo BuscarObjetivoPorId(int pIdMapa, int pIdPantalla, int pIdObjetivo); 
    
    ArrayList<Objetivo> ListarObjetivoEliminados(); 
    
    int ReingresarObjetivo(int pIdMapa , int pIdPantalla, Objetivo pObjetivo); 
    
    int EliminarObjetivoDefinitivo(int pIdMapa , int pIdPantalla, Objetivo pObjetivo); 
    
    int EliminarListaObjetivoDefinitivo();
    
}
