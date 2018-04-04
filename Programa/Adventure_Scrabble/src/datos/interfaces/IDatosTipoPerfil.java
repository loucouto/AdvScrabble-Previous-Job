/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import datos.util.DatosConstantes;
import entidades_compartidas.TipoPerfil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosTipoPerfil {
    
    public int AltaTipoPerfil(TipoPerfil pTipoPerfil); 
     
    public int ModificarTipoPerfil(TipoPerfil pTipoPerfil); 
     
    public int BajaTipoPerfil(TipoPerfil pTipoPerfil); 
    
    public ArrayList<TipoPerfil> ListarTipoPerfil(); 
    
    public TipoPerfil BuscarTipoPerfilPorId(int pIdTipoPerfil); 
    
    public ArrayList<TipoPerfil> ListarTipoPerfilEliminados(); 
    
    public TipoPerfil BuscarTipoPerfilEliminadoPorId(int pIdTipoPerfil);
    
    public int ReingresarTipoPerfil(TipoPerfil pTipoPerfil); 
    
    public int EliminarTipoPerfliDefinitivo(TipoPerfil pTipoPerfil);
    
    public int EliminarListaTipoPerfilDefinitivo(); 
    
    public int VerSiguienteId();
    
}
