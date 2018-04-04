/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Mensaje;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaMensaje {
    
    int AltaMensaje(Mensaje pMensaje);
     
    int ModificarMensaje(Mensaje pMensaje); 
     
    int BajaMensaje(Mensaje pMensaje);
    
    ArrayList<Mensaje> ListaMensaje();
    
    Mensaje BuscarMensajePorId(int pIdMensaje);
    
    ArrayList<Mensaje> ListarMensajeEliminados(); 
    
    int ReingresarMensaje(Mensaje pMensaje);
    
    int EliminarMensajeDefinitivo(Mensaje pMensaje);
    
    int EliminarListaMensajeDefinitivo();
}
