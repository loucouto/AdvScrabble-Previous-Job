/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.TipoPermiso;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosTipoPermiso {
    
    public int AltaTipoPermiso(TipoPermiso pTipoPermiso);
     
    public int ModificarTipoPermiso(TipoPermiso pTipoPermiso); 
     
    public int BajaTipoPermiso(TipoPermiso pTipoPermiso); 
    
    public ArrayList<TipoPermiso> ListarTipoPermiso(); 
   
    public ArrayList<TipoPermiso> ListarTipoPermisoEliminados(); 
    
    public int ReingresarTipoPermiso(TipoPermiso pTipoPermiso); 
    
    public int EliminarTipoPermisoDefinitivo(TipoPermiso pTipoPermiso); 
    
    public int EliminarListaTipoPermisoDefinitivo(); 
    
    public int VerSiguienteId();
    
    public TipoPermiso BuscarTipoPermisoPorId(int pIdTipoPermiso); 
    
    public TipoPermiso BuscarTipoPermisoEliminadosPorId(int pIdTipoPermiso);
}
