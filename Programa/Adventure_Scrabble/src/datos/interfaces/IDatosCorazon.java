/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.Corazon;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosCorazon {
    
    int AltaCorazon(int pIdUsuario,  Corazon pCorazon);
     
    int ModificarCorazon(int pIdUsuario,  Corazon pCorazon); 
     
    int BajaCorazon(int pIdUsuario, Corazon pCorazon); 
    
    ArrayList<Corazon> ListarCorazon();
    
    Corazon BuscarCorazonPorId(int pIdUsuario, int pIdCorazon); 
    
    ArrayList<Corazon> ListarCorazonEliminados();
    
    public int ReingresarCorazon(int pIdUsuario, Corazon pCorazon); 
    
    public int EliminarDefinitivo(int pIdUsuario, Corazon pCorazon); 
    
    public int EliminarListaCorazonDefinitivo(); 
    
    
}
