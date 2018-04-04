/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.Jugador;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosJugador {
    
    int AltaJugador(Jugador pJugador);
     
    int ModificarJugador(Jugador pJugador);
         
    ArrayList<Jugador> ListarJugador();
    
    Jugador BuscarJugadorPorId(int pIdUsuario); 
    
    ArrayList<Jugador> ListarJugadorEliminados(); 
    
}
