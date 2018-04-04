/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.Condicionante;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosCondicionante {
    
    int AltaCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante); 
     
    int ModificarCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante);
  
    int BajaCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante); 
    
    ArrayList<Condicionante> ListarCondicionante();
    
    Condicionante BuscarCondicionantePorId(int pIdMapa, int pIdPantalla, int pIdCondicionante);
   
    ArrayList<Condicionante> ListarCondicionanteEliminados(); 
    
    public int ReingresarCondicionante(int pIdMapa, int pIdPantalla, Condicionante pCondicionante); 
    
    public int EliminarCondicionanteDefinitivo(int pIdMapa, int pIdPantalla, Condicionante pCondicionante); 
    
    public int EliminarListaCondicionanteDefinitivo();
    
}
