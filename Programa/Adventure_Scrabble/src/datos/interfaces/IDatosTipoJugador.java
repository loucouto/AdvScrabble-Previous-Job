/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.TipoJugador;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosTipoJugador {
    
    public int AltaTipoJugador(TipoJugador pTipoJugador); 
     
    public int ModificarTipoJugador(TipoJugador pTipoJugador);
     
    public int BajaTipoJugador(TipoJugador pTipoJugador);
    
    public ArrayList<TipoJugador> ListarTipoJugador(); 
    
    public TipoJugador BuscarTipoJugadorPorId(int pIdTipoJugador); 
    
    public ArrayList<TipoJugador> ListarTipoJugadorEliminados();
    
    public int ReingresarTipoJugador(TipoJugador pTipoJugador);
    
    public int EliminarTipoJugadorDefinitivo(TipoJugador pTipoJugador);
    
    public int EliminarListaTipoJugadorDefinitivo();
    
}
