/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.SubFuncionalidad;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosSubFuncionalidad {
    
    int AltaSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad);
     
    int ModificarSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad);
    
    int BajaSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad);
    
    ArrayList<SubFuncionalidad> ListarSubFuncionalidad();
    
    ArrayList<SubFuncionalidad> ListarSubFuncionalidadPorId(int pIdFuncionalidad);
    
    SubFuncionalidad BuscarSubFuncionalidadPorId(int pIdFuncionalidad, int pIdSubFuncionalidad);
   
    ArrayList<SubFuncionalidad> ListarSubFuncionalidadEliminados();
  
    ArrayList<SubFuncionalidad> ListarSubFuncionalidadEliminadosPorId(int pIdFuncionalidad);
    
    int ReingresarSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad); 
    
    int EliminarSubFuncionalidadDefinitivo(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad); 
    
    int EliminarListaSubFuncionalidadDefinitivo();
    
    int VerSiguienteIdSubFuncionalidad(int pIdFuncionalidad);
    
    
}
