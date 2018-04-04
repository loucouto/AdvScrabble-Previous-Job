/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.RegistroPantalla;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaRegistroPantalla {
    
    int AltaRegistroPantalla(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla);
    
    int ModificarRegistroPantalla(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla);
     
    int BajaRegistroPantalla(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla);
    
    ArrayList<RegistroPantalla> ListarRegistroPantalla();
    
    RegistroPantalla BuscarRegistroPantallaPorId(int pIdUsuario, int pIdRegistroMapa, int pIdRegistroPantalla); 
    
    ArrayList<RegistroPantalla> ListarRegistroPantallaEliminados(); 
    
    int ReingresarRegistroPantalla(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla);
    
    int EliminarRegistroPantallaDefinitivo(int pIdUsuario, int pIdRegistroMapa ,RegistroPantalla pRegistroPantalla);
    
    int EliminarListaRegistroPantallaDefinitivo(); 
    
}
