/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;


import entidades_compartidas.Lingote;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosLingote {
    
    int AltaLingote(int pIdUsuario ,Lingote pLingote); 
     
    int ModificarLingote(int pIdUsuario ,Lingote pLingote);
    
    int BajaLingote(int pIdUsuario ,Lingote pLingote);
    
    ArrayList<Lingote> ListarLingote(); 
    
    Lingote BuscarLingotePorId(int pIdUsuario, int pIdLingote);
    
    ArrayList<Lingote> ListarLingoteEliminados(); 
    
    int ReingresarLingote(int pIdUsuario ,Lingote pLingote);
    
    int EliminarLingoteDefinitivo(int pIdUsuario ,Lingote pLingote);
    
    int EliminarLingoteLingoteDefinitivo();
    
}
