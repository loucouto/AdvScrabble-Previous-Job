/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.Mapa;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosMapa {
    
    public int AltaMapa(Mapa pMapa); 
     
    public int ModificarMapa(Mapa pMapa); 
     
    public int BajaMapa(Mapa pMapa);
    
    public ArrayList<Mapa> ListarMapa(); 
   
    public Mapa BuscarMapaPorId(int pIdMapa); 
    
    public ArrayList<Mapa> ListarMapaEliminados(); 
    
    public int ReingresarMapa(Mapa pMapa);
    
    public int EliminarMapaDefinitivo(Mapa pMapa); 
    
    public int EliminarListaMapaDefinitivo(); 
    
}
