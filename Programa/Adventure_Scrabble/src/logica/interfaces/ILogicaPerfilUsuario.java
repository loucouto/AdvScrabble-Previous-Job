/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.PerfilUsuario;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaPerfilUsuario {
    
    int AltaPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario); 
    
    int ModificarPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario); 
    
    int BajaPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario);
    
    ArrayList<PerfilUsuario> ListarPerfilUsuario(); 
    
    PerfilUsuario BuscarPerfilUsuarioPorId(int pIdUsuario, int pIdPerfilUsuario);
    
    ArrayList<PerfilUsuario> ListarPerfilUsuarioEliminados(); 
    
    int ReingresarPerfilUsuario(int pIdUsuario, PerfilUsuario pPerfilUsuario);
    
    int EliminarPerfilUsuarioDefinitivo(int pIdUsuario, PerfilUsuario pPerfilUsuario);
    
    int EliminarListaPerfilUsuarioDefinitivo(); 
    
}