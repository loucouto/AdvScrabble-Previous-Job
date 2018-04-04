/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Funcionalidad;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaFuncionalidad;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaFuncionalidad implements ILogicaFuncionalidad{

    @Override
    public int AltaFuncionalidad(Funcionalidad pFuncionalidad) {
        
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorFuncionalidad().AltaFuncionalidad(pFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int ModificarFuncionalidad(Funcionalidad pFuncionalidad) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorFuncionalidad().ModificarFuncionalidad(pFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int BajaFuncionalidad(Funcionalidad pFuncionalidad) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorFuncionalidad().BajaFuncionalidad(pFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<Funcionalidad> ListarFuncionalidad() {
        ArrayList<Funcionalidad> lista_funcionalidad = new ArrayList();
        try
        {
            lista_funcionalidad = FabricaDatos.getControladorFuncionalidad().ListarFuncionalidad();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_funcionalidad;
    }

    @Override
    public Funcionalidad BuscarFuncionalidadPorId(int pIdFuncionalidad) {
        Funcionalidad retorno = new Funcionalidad();
        try
        {
            retorno = FabricaDatos.getControladorFuncionalidad().BuscarFuncionalidadPorId(pIdFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<Funcionalidad> ListarFuncionalidadEliminados() {
        
        ArrayList<Funcionalidad> lista_funcionalidad = new ArrayList();
        try
        {
            lista_funcionalidad = FabricaDatos.getControladorFuncionalidad().ListarFuncionalidadEliminados();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_funcionalidad;
    }

    @Override
    public int ReingresarFuncionalidad(Funcionalidad pFuncionalidad) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorFuncionalidad().ReingresarFuncionalidad(pFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int EliminarFuncionalidadDefinitivo(Funcionalidad pFuncionalidad) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorFuncionalidad().EliminarFuncionalidadDefinitivo(pFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int EliminarListaFuncionalidadDefinitivo() {
       int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorFuncionalidad().EliminarListaFuncionalidadDefinitivo();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int VerSiguienteIdFuncionalidad() {
       int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorFuncionalidad().VerSiguienteIdFuncionalidad();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public Funcionalidad BuscarFuncionalidadEliminadaPorId(int pIdFuncionalidad) {
       Funcionalidad funcionalidad = new Funcionalidad();
        try
        {
            funcionalidad = FabricaDatos.getControladorFuncionalidad().BuscarFuncionalidadEliminadaPorId(pIdFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionalidad;
    }

    @Override
    public Funcionalidad BuscarFuncionalidadConSubFuncionalidadEliminados(int pIdFuncionalidad) {
        Funcionalidad retorno = new Funcionalidad();
        try
        {
            retorno = FabricaDatos.getControladorFuncionalidad().BuscarFuncionalidadConSubFuncionalidadEliminados(pIdFuncionalidad);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
}
