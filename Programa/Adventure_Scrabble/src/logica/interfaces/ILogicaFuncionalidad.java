/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Funcionalidad;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaFuncionalidad {
    
    int AltaFuncionalidad(Funcionalidad pFuncionalidad); 
     
    int ModificarFuncionalidad(Funcionalidad pFuncionalidad);
     
    int BajaFuncionalidad(Funcionalidad pFuncionalidad);
    
    ArrayList<Funcionalidad> ListarFuncionalidad(); 
    
    Funcionalidad BuscarFuncionalidadPorId(int pIdFuncionalidad); 
    
    ArrayList<Funcionalidad> ListarFuncionalidadEliminados(); 
    
    Funcionalidad BuscarFuncionalidadConSubFuncionalidadEliminados(int pIdFuncionalidad);
    
    int ReingresarFuncionalidad(Funcionalidad pFuncionalidad);
            
    int EliminarFuncionalidadDefinitivo(Funcionalidad pFuncionalidad);
    
    int EliminarListaFuncionalidadDefinitivo(); 
    
    int VerSiguienteIdFuncionalidad();
    
    Funcionalidad BuscarFuncionalidadEliminadaPorId(int pIdFuncionalidad);
}
