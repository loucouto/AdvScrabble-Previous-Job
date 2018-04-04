/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.ImagenMapa;
import entidades_compartidas.Mapa;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaImagenMapa {
    
    int AltaImagenMapa(ImagenMapa pImagenMapa, int pIdMapa);
     
    int ModificarImagenMapa(ImagenMapa pImagenMapa, int pIdMapa);
     
    int BajaImagenMapa(ImagenMapa pImagenMapa); 
    
    ArrayList<ImagenMapa> ListarImagenMapa();
    
    ImagenMapa BuscarImagenMapaPorId(int pIdImagenMapa, int pIdMapa);
    
    ArrayList<ImagenMapa> ListarImagenMapaEliminados(); 
    
    int ReingresarImagenMapa(Mapa pImagenMapa);
    
    int EliminarImagenMapaDefinitivo(int pIdMapa, ImagenMapa pImagenMapa);
    
    int EliminarListaImagenMapaDefinitivo(); 
    
    
}
