/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.PermisoFuncionalidad;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaPermisoFuncionalidad {
    
    int AltaPermisoFuncionalidad(int pIdFuncionalidad, int pIdSubFuncionalidad, int pIdTipoPermiso ,PermisoFuncionalidad pPermisoFuncionalidad);
      
    int ModificarPermisoFuncionalidad(int pIdFuncionalidad, int pIdSubFuncionalidad, int pIdTipoPermiso ,PermisoFuncionalidad pPermisoFuncionalidad);
    
    int BajaPermisoFuncionalidad(int pIdFuncionalidad, int pIdSubFuncionalidad, int pIdTipoPermiso ,PermisoFuncionalidad pPermisoFuncionalidad); 
    
    ArrayList<PermisoFuncionalidad> ListarPermisoFuncionalidad();
     
    PermisoFuncionalidad BuscarPermisoFuncionalidadPorId(int pIdFuncionalidad, int pIdSubFuncionalidad, int pIdTipoPermiso ,int pIdPermisoFuncionalidad); 
    
    ArrayList<PermisoFuncionalidad> ListarPermisoFuncionalidadEliminados(); 
    
    int ReingresarPermisoFuncionalidad(int pIdFuncionalidad, int pIdSubFuncionalidad, PermisoFuncionalidad pPermisoFuncionalidad); 
    
    int EliminarPermisoFuncionalidadDefinitivo(int pIdFuncionalidad, int pIdSubFuncionalidad, PermisoFuncionalidad pPermisoFuncionalidad); 
    
    int EliminarListaPermisoFuncionalidadDefinitivo(); 
    
}
