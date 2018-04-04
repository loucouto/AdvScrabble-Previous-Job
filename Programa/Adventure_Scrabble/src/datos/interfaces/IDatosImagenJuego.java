/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.ImagenJuego;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosImagenJuego {
    
    int AltaImagenJuego(ImagenJuego pImagenJuego);
     
    int ModificarImagenJuego(ImagenJuego pImagenJuego);
     
    int BajaImagenJuego(ImagenJuego pImagenJuego); 
    
    ArrayList<ImagenJuego> ListarImagenJuego(); 
    
    ArrayList<ImagenJuego> BuscarImagenJuegoPorId(int pIdImagenJuego);
    
    ArrayList<ImagenJuego> ListarImagenJuegoEliminados();
    
    int ReingresarImagenJuego(ImagenJuego pImagenJuego);
    
    int EliminarImagenJuegoDefinitivo(ImagenJuego pImagenJuego); 
    
    int EliminarListaImagenJuegoDefinitivo();
    
}
