/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Modelo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaModelo;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaModelo implements ILogicaModelo{

    @Override
    public int AltaModelo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarModelo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaModelo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Modelo> ListarModelo() {
        ArrayList<Modelo> lista_modelo = new ArrayList();
        try
        {
            lista_modelo = FabricaDatos.getControladorModelo().ListarModelo();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_modelo;
    }

    @Override
    public Modelo BuscarModeloPorId(int pIdModelo) {
        Modelo modelo = new Modelo();
        try
        {
            modelo = FabricaDatos.getControladorModelo().BuscarModeloPorId(pIdModelo);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    @Override
    public ArrayList<Modelo> ListarModeloEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarModelo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarModeloDefinitivo(Modelo pModelo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaModeloDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
