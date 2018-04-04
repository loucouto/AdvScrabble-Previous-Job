/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.Modelo;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosModelo {
    
    int AltaModelo(Modelo pModelo); 
     
    int ModificarModelo(Modelo pModelo); 
     
    int BajaModelo(Modelo pModelo);
    
    ArrayList<Modelo> ListarModelo(); 
    
    Modelo BuscarModeloPorId(int pIdModelo); 
    
    ArrayList<Modelo> ListarModeloEliminados(); 
    
    int ReingresarModelo(Modelo pModelo); 
    
    int EliminarModeloDefinitivo(Modelo pModelo);
    
    int EliminarListaModeloDefinitivo(); 
    
}
