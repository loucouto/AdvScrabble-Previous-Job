/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.Mensaje;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosMensaje {
    
    int AltaMensaje(Mensaje pMensaje);
     
    int ModificarMensaje(Mensaje pMensaje); 
     
    int BajaMensaje(Mensaje pMensaje);
    
    ArrayList<Mensaje> ListaMensaje();
    
    Mensaje BuscarMensajePorId(int pIdUsuario,int pIdTipoMensaje, int pIdMensaje);
    
    ArrayList<Mensaje> ListarMensajeEliminados(); 
    
    int ReingresarMensaje(Mensaje pMensaje);
    
    int EliminarMensajeDefinitivo(Mensaje pMensaje);
    
    int EliminarListaMensajeDefinitivo();
    
}
