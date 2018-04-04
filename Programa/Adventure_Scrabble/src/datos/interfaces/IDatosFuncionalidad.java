/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.*;
import java.util.ArrayList;


/**
 *
 * @author ubuntulourdes
 */
public interface IDatosFuncionalidad {
    
    int AltaFuncionalidad(Funcionalidad pFuncionalidad); 
     
    int ModificarFuncionalidad(Funcionalidad pFuncionalidad);
     
    int BajaFuncionalidad(Funcionalidad pFuncionalidad);
    
    ArrayList<Funcionalidad> ListarFuncionalidad(); 
    
    Funcionalidad BuscarFuncionalidadConSubFuncionalidadEliminados(int pIdFuncionalidad);
    
    Funcionalidad BuscarFuncionalidadPorId(int pIdFuncionalidad); 
    
    ArrayList<Funcionalidad> ListarFuncionalidadEliminados(); 
    
    Funcionalidad BuscarFuncionalidadEliminadaPorId(int pIdFuncionalidad);
    
    int ReingresarFuncionalidad(Funcionalidad pFuncionalidad);
            
    int EliminarFuncionalidadDefinitivo(Funcionalidad pFuncionalidad);
    
    int EliminarListaFuncionalidadDefinitivo(); 
    
    int VerSiguienteIdFuncionalidad();
}
