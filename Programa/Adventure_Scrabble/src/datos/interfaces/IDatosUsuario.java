/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosUsuario {
 
    int AltaUsuario(Usuario pUsuario); 
     
    int ModificarUsuario(Usuario pUsuario); 
     
    int BajaUsuario(Usuario pUsuario);
    
    ArrayList<Usuario> ListarUsuario(); 
    
    Usuario BuscarUsuarioPorId(int pIdUsuario); 
   
    ArrayList<Usuario> ListarUsuarioEliminados(); 
    
    Usuario BuscarUsuarioEliminadoPorId(int pIdUsuario);
    
    int ReingresarUsuario(Usuario pUsuario); 
    
    int EliminarUsuarioDefinitivo(Usuario pUsuario); 
    
    int EliminarListaUsuarioDefinitivo(); 
    
    int VerSiguienteId();
   
}
