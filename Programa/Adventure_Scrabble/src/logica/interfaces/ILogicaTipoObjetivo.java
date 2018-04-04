/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.TipoObjetivo;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaTipoObjetivo {
    
    int AltaTipoObjetivo(TipoObjetivo pTipoObjetivo);
     
    int ModificarTipoObjetivo(TipoObjetivo pTipoObjetivo);

    int BajaTipoObjetivo(TipoObjetivo pTipoObjetivo); 

    ArrayList<TipoObjetivo> ListarTipoObjetivo(); 

    TipoObjetivo BuscarTipoObjetivoPorId(int pIdTipoObjetivo); 

    ArrayList<TipoObjetivo> ListarTipoObjetivoEliminados(); 

    int ReingresarTipoObjetivo(TipoObjetivo pTipoObjetivo); 

    int EliminarTipoObjetivoDefinitivo(TipoObjetivo pTipoObjetivo); 

    int EliminarListaTipoObjetivoDefinitivo();

    
}
