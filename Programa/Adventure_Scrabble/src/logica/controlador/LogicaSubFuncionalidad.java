/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.SubFuncionalidad;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaSubFuncionalidad;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaSubFuncionalidad implements ILogicaSubFuncionalidad{

    @Override
    public int AltaSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
          int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorSubFuncionalidad().AltaSubFuncionalidad(pIdFuncionalidad, pSubFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int ModificarSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
         int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorSubFuncionalidad().ModificarSubFuncionalidad(pIdFuncionalidad, pSubFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int BajaSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorSubFuncionalidad().BajaSubFuncionalidad(pIdFuncionalidad, pSubFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<SubFuncionalidad> ListarSubFuncionalidad() {
        ArrayList<SubFuncionalidad> lista_sub_funcionalidad = new ArrayList();
        try
        {
            lista_sub_funcionalidad = FabricaDatos.getControladorSubFuncionalidad().ListarSubFuncionalidad();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_sub_funcionalidad;
    }

    @Override
    public SubFuncionalidad BuscarSubFuncionalidadPorId(int pIdFuncionalidad, int pIdSubFuncionalidad) {
         SubFuncionalidad retorno = new SubFuncionalidad();
        try
        {
            retorno = FabricaDatos.getControladorSubFuncionalidad().BuscarSubFuncionalidadPorId(pIdFuncionalidad, pIdSubFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<SubFuncionalidad> ListarSubFuncionalidadEliminados() {
          ArrayList<SubFuncionalidad> lista_sub_funcionalidad = new ArrayList();
        try
        {
            lista_sub_funcionalidad = FabricaDatos.getControladorSubFuncionalidad().ListarSubFuncionalidadEliminados();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_sub_funcionalidad;
    }

    @Override
    public int ReingresarSubFuncionalidad(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorSubFuncionalidad().ReingresarSubFuncionalidad(pIdFuncionalidad, pSubFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int EliminarSubFuncionalidadDefinitivo(int pIdFuncionalidad, SubFuncionalidad pSubFuncionalidad) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorSubFuncionalidad().EliminarSubFuncionalidadDefinitivo(pIdFuncionalidad, pSubFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int EliminarListaSubFuncionalidadDefinitivo() {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorSubFuncionalidad().EliminarListaSubFuncionalidadDefinitivo();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int VerSiguienteIdSubFuncionalidad(int pIdFuncionalidad) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorSubFuncionalidad().VerSiguienteIdSubFuncionalidad(pIdFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<SubFuncionalidad> ListarSubFuncionalidadPorId(int pIdFuncionalidad) {
       ArrayList<SubFuncionalidad> lista_sub_funcionalidad = new ArrayList();
        try
        {
            lista_sub_funcionalidad = FabricaDatos.getControladorSubFuncionalidad().ListarSubFuncionalidadPorId(pIdFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_sub_funcionalidad;
    }

    @Override
    public ArrayList<SubFuncionalidad> ListarSubFuncionalidadEliminadosPorId(int pIdFuncionalidad) {
         ArrayList<SubFuncionalidad> lista_sub_funcionalidad = new ArrayList();
        try
        {
            lista_sub_funcionalidad = FabricaDatos.getControladorSubFuncionalidad().ListarSubFuncionalidadEliminadosPorId(pIdFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_sub_funcionalidad;
    }
    
}
