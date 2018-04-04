/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.TipoPermiso;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaTipoPermiso;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaTipoPermiso implements ILogicaTipoPermiso{

    @Override
    public int AltaTipoPermiso(TipoPermiso pTipoPermiso) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().AltaTipoPermiso(pTipoPermiso);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int ModificarTipoPermiso(TipoPermiso pTipoPermiso) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().ModificarTipoPermiso(pTipoPermiso);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int BajaTipoPermiso(TipoPermiso pTipoPermiso) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().BajaTipoPermiso(pTipoPermiso);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<TipoPermiso> ListarTipoPermiso() {
        ArrayList<TipoPermiso> retorno = new ArrayList();
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().ListarTipoPermiso();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public TipoPermiso BuscarTipoPermisoPorId(int pIdTipoPermiso) {
         TipoPermiso retorno = new TipoPermiso();
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().BuscarTipoPermisoPorId(pIdTipoPermiso);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public ArrayList<TipoPermiso> ListarTipoPermisoEliminados() {
       ArrayList<TipoPermiso> retorno = new ArrayList();
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().ListarTipoPermisoEliminados();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int ReingresarTipoPermiso(TipoPermiso pTipoPermiso) {
       int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().ReingresarTipoPermiso(pTipoPermiso);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int EliminarTipoPermisoDefinitivo(TipoPermiso pTipoPermiso) {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().EliminarTipoPermisoDefinitivo(pTipoPermiso);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int EliminarListaTipoPermisoDefinitivo() {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().EliminarListaTipoPermisoDefinitivo();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public int VerSiguienteId() {
        int retorno = 0;
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().VerSiguienteId();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    @Override
    public TipoPermiso BuscarTipoPermisoEliminadosPorId(int pIdTipoPermiso) {
        TipoPermiso retorno = new TipoPermiso();
        try
        {
            retorno = FabricaDatos.getControladorTipoPermiso().BuscarTipoPermisoEliminadosPorId(pIdTipoPermiso);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
   
}
