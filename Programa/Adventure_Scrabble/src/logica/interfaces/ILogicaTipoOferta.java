/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.TipoOferta;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaTipoOferta {
    
    int AltaTipoOferta(TipoOferta pTipoOferta); 
     
    int ModificarTipoOferta(TipoOferta pTipoOferta); 

    int BajaTipoOferta(TipoOferta pTipoOferta); 

    ArrayList<TipoOferta> ListarTipoOferta(); 

    TipoOferta BuscarTipoOfertaPorId(int pIdTipoOferta); 

    ArrayList<TipoOferta> ListarTipoOfertaEliminados(); 

    int ReingresarTipoOferta(TipoOferta pTipoOferta); 

    int EliminarTipoOfertaDefinitivo(TipoOferta pTipoOferta); 

    int EliminarListaTipoOfertaDefinitivo(); 

}
