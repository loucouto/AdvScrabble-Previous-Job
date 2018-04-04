/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.TipoPerfil;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaTipoPerfil {
    
    public int AltaTipoPerfil(TipoPerfil pTipoPerfil); 
     
    public int ModificarTipoPerfil(int pIdUsuario, TipoPerfil pTipoPerfil); 
     
    public int BajaTipoPerfil(TipoPerfil pTipoPerfil); 
    
    public ArrayList<TipoPerfil> ListarTipoPerfil(); 
    
    TipoPerfil BuscarTipoPerfilPorId(int pIdTipoPerfil); 
    
    public ArrayList<TipoPerfil> ListarTipoPerfilEliminados(); 
    
    public int ReingresarTipoPerfil(TipoPerfil pTipoPerfil); 
    
    public int EliminarTipoPerfliDefinitivo(TipoPerfil pTipoPerfil);
    
    public int EliminarListaTipoPerfilDefinitivo(); 
    
}
