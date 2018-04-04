/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Oferta;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaOferta {
    
    public int AltaOferta(Oferta pOferta);
     
    public int ModificarOferta(Oferta pOferta);
     
    public int BajaOferta(Oferta pOferta); 
    
    public ArrayList<Oferta> ListarOferta();
    
    public Oferta BuscarOfertaPorId(int pIdOferta);
    
    public ArrayList<Oferta> ListarOfertaEliminados(); 
    
    public int ReingresarOferta(Oferta pOferta);
    
    public int EliminarOfertaDefinitivo(Oferta pOferta);
    
    public int EliminarListaOfertaDefinitivo(); 
    
}
