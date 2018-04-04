/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;
import datos.fachada.FabricaDatos;
import entidades_compartidas.TipoOferta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaTipoOferta;
/**
 *
 * @author ubuntulourdes
 */
public class LogicaTipoOferta implements ILogicaTipoOferta{

    @Override
    public int AltaTipoOferta(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoOferta(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoOferta(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoOferta> ListarTipoOferta() {
         
            ArrayList<TipoOferta> lista_tipo_oferta = new ArrayList();
            try
            {
                 lista_tipo_oferta = FabricaDatos.getControladorTipoOferta().ListarTipoOferta();
            }
            catch(Exception ex)
            {
                Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return lista_tipo_oferta;
    }

    @Override
    public TipoOferta BuscarTipoOfertaPorId(int pIdTipoOferta) {
            
            TipoOferta tipo_oferta = new TipoOferta();
            try
            {
                 tipo_oferta = FabricaDatos.getControladorTipoOferta().BuscarTipoOfertaPorId(pIdTipoOferta);
            }
            catch(Exception ex)
            {
                Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return tipo_oferta;
    }

    @Override
    public ArrayList<TipoOferta> ListarTipoOfertaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoOferta(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoOfertaDefinitivo(TipoOferta pTipoOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoOfertaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
