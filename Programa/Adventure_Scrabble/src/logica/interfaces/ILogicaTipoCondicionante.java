/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.TipoBonus;
import entidades_compartidas.TipoCondicionante;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaTipoCondicionante {
    
     int AltaTipoCondicionante(TipoCondicionante pTipoCondicionante);

     int ModificarTipoCondicionante(TipoCondicionante pTipoCondicionante);

     int BajaTipoCondicionante(TipoCondicionante pTipoCondicionante); 

     ArrayList<TipoCondicionante> ListarTipoCondicionante();

     TipoCondicionante BuscarTipoCondicionantePorId(int pIdTipoCondicionante); 

     ArrayList<TipoCondicionante> ListarTipoCondicionanteEliminados(); 

     int ReingresarTipoCondicionante(TipoCondicionante pTipoCondicionante);

     int EliminarTipoCondicionanteDefinitivo(TipoCondicionante pTipoCondicionante);

     int EliminarListaTipoCondicionanteDefinitivo();

}
