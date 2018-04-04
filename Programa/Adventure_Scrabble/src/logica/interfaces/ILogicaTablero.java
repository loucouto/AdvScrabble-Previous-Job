/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Tablero;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaTablero {
    
    int AltaTablero(int pIdMapa, int pIdPantalla, Tablero pTablero);
    
    int ModificarTablero(int pIdMapa, int pIdPantalla, Tablero pTablero);
    
    int BajaTablero(int pIdMapa, int pIdPantalla, Tablero pTablero); 
    
    ArrayList<Tablero> ListarTablero();
    
    Tablero BuscarTableroPorId(int pIdMapa, int pIdPantalla, int pIdTablero);
    
    ArrayList<Tablero> ListarTablerosEliminados(); 
    
    int ReingresarTablero(int pIdMapa, int pIdPantalla, Tablero pTablero); 
    
    int EliminarTableroDefinitivo(int pIdMapa, int pIdPantalla, Tablero pTablero); 
    
    int EliminarListaTableroDefinitivo(); 
    
    
}
