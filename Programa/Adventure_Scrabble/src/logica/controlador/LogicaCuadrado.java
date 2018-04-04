/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaCuadrado;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaCuadrado implements ILogicaCuadrado{

    @Override
    public int AltaCuadrado(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarCuadrado(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaCuadrado(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cuadrado> ListarCuadrado() {
        ArrayList<Cuadrado> lista_cuadrado = new ArrayList();
        try
        {
            lista_cuadrado = FabricaDatos.getControladorCuadrado().ListarCuadrado();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_cuadrado;
    }

    @Override
    public Cuadrado BuscarCuadradoPorId(int pIdMapa, int pIdPantalla, int pIdTablero, int pIdCuadrado) {
        
        Cuadrado c = new Cuadrado();
        try
        {
            c = FabricaDatos.getControladorCuadrado().BuscarCuadradoPorId(pIdMapa, pIdPantalla, pIdTablero, pIdCuadrado);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public ArrayList<Cuadrado> ListarCuadradosEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarCuadrado(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarCuadradoDefinitivo(int pIdMapa, int pIdPantalla, int pIdTablero, Cuadrado pCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaCuadradoDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cuadrado> BuscarCuadradoPorIdTablero(int pIdMapa, int pIdPantalla, int pIdTablero) {
       
        ArrayList<Cuadrado> lista_cuadrado = new ArrayList();
        
        try
        {
            lista_cuadrado = FabricaDatos.getControladorCuadrado().BuscarCuadradoPorIdTablero(pIdMapa, pIdPantalla, pIdTablero);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_cuadrado;
    }
    
}
