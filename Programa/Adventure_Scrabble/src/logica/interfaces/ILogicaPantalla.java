/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Pantalla;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaPantalla {
    
    int AltaPantalla(Pantalla pPantalla, int pIdMapa);
     
    int ModificarPantalla(Pantalla pPantalla, int pIdMapa); 
   
    int BajaPantalla(Pantalla pPantalla, int pIdMapa);
  
    ArrayList<Pantalla> ListarPantalla(); 
    
    Pantalla BuscarPantallaPorId(int pIdMapa, int pIdPantalla);
    
    ArrayList<Pantalla> ListadoPantallasEliminadas(); 
    
    int ReingresarPantalla(int pIdMapa , Pantalla pPantalla);
    
    int EliminarPantallaDefinitivo(Pantalla pPantalla, int pIdMapa);
    
    int EliminarListaPantallaDefinitivo(); 
}
