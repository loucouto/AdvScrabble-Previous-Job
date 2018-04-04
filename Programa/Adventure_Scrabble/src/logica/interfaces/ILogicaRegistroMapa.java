/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.RegistroMapa;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaRegistroMapa {
    
    int AltaRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa);
     
    int ModificarRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa);
    
    int BajaRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa);
    
    ArrayList<RegistroMapa> ListarRegistroMapa(); 
    
    RegistroMapa BuscarRegistroMapaPorId(int pIdUsuario ,int pIdRegistroMapa); 
    
    ArrayList<RegistroMapa> ListarRegistroMapaEliminados();
    
    int ReingresarRegistroMapa(int pIdUsuario, RegistroMapa pRegistroMapa); 
            
    int EliminarRegistroMapaDefinitivo(int pIdUsuario, RegistroMapa pRegistroMapa);
    
    int EliminarListaRegistroMapaDefinitivo(); 
}
