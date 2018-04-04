/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.fachada;

import datos.controlador.*;
import datos.interfaces.*;

/**
 *
 * @author Lourdes Couto
 */
public class FabricaDatos {
    
    private static IDatosBonus IDatBonus; 
    private static IDatosCondicionante IDatCondicionante;
    private static IDatosCorazon IDatCorazon;
    private static IDatosCuadrado IDatCuadrado;
    private static IDatosEstrella IDatEstrella;
    private static IDatosFicha IDatFicha;
    private static IDatosFuncionalidad IDatFuncionalidad;
    private static IDatosImagenJuego IDatImagenJuego;
    private static IDatosImagenMapa IDatImagenMapa;
    private static IDatosJugador IDatJugador;
    private static IDatosLingote IDatLingote;
    private static IDatosMapa IDatMapa;
    private static IDatosMensaje IDatMensaje;
    private static IDatosModelo  IDatModelo;
    private static IDatosObjetivo IDatObjetivo;
    private static IDatosOferta IDatOferta;
    private static IDatosPantalla IDatPantalla;
    private static IDatosPerfilUsuario IDatUsuario;
    private static IDatosPermisoFuncionalidad IDatPermisoFuncionalidad;
    private static IDatosPuntajePantalla IDatPuntajePantalla;
    private static IDatosSubFuncionalidad IDatSubFuncionalidad;
    private static IDatosTablero IDatTablero;
    private static IDatosTipoBonus IDatTipoBonus;
    private static IDatosTipoCondicionante IDatTipoCondicionante;
    private static IDatosTipoCuadrado IDatTipoCuadrado;
    private static IDatosTipoJugador  IDatTipoJugador;
    private static IDatosTipoMensaje IDatTipoMensaje;
    private static IDatosTipoObjetivo IDatTipoObjetivo;
    private static IDatosTipoOferta IDatTipoOferta;
    private static IDatosTipoPerfil IDatTipoPerfil;
    private static IDatosTipoPermiso IDatTipoPermiso;
    private static IDatosUsuario IDatTipoUsuario;
    
    public static IDatosBonus getControladorBonus()
    {
        if (IDatBonus == null)
        {
            IDatBonus = new DatosBonus();
        }
        return IDatBonus;
    }
    
    public static IDatosCondicionante getControladorCondicionante()
    {
        if (IDatCondicionante == null)
        {
            IDatCondicionante = new DatosCondicionante();
        }
        return IDatCondicionante;
    }
    
    public static IDatosCorazon getControladorCorazon()
    {
        if (IDatCorazon == null)
        {
            IDatCorazon = new DatosCorazon();
        }
        return IDatCorazon;
    }
        
    public static IDatosCuadrado getControladorCuadrado()
    {
        if (IDatCuadrado == null)
        {
            IDatCuadrado = new DatosCuadrado();
        }
        return IDatCuadrado;
    }
        
        
    public static IDatosEstrella getControladorEstrella()
    {
        if (IDatEstrella == null)
        {
            IDatEstrella = new DatosEstrella();
        }
        return IDatEstrella;
    }
            
    public static IDatosFicha getControladorFicha()
    {
        if (IDatFicha == null)
        {
            IDatFicha = new DatosFicha();
        }
        return IDatFicha;
    }
                
    public static IDatosJugador getControladorJugador()
    {
        if (IDatJugador == null)
        {
            IDatJugador = new DatosJugador();
        }
        return IDatJugador;
    }
                    
    public static IDatosLingote getControladorLingote()
    {
        if (IDatLingote == null)
        {
            IDatLingote = new DatosLingote();
        }
        return IDatLingote;
    }
                        
    public static IDatosMapa getControladorMapa()
    {
        if (IDatMapa == null)
        {
            IDatMapa = new DatosMapa();
        }
        return IDatMapa;
    }
                            
   public static IDatosMensaje getControladorMensaje()
    {
        if (IDatMensaje == null)
        {
            IDatMensaje = new DatosMensaje();
        }
        return IDatMensaje;
    }
                                
   public static IDatosModelo getControladorModelo()
    {
        if (IDatModelo == null)
        {
            IDatModelo = new DatosModelo();
        }
        return IDatModelo;
    }
                                    
    public static IDatosObjetivo getControladorObjetivo()
    {
        if (IDatObjetivo == null)
        {
            IDatObjetivo = new DatosObjetivo();
        }
        return IDatObjetivo;
    }
                                        
    public static IDatosOferta getControladorOferta()
    {
        if (IDatOferta == null)
        {
            IDatOferta = new DatosOferta();
        }
        return IDatOferta;
    }
                                            
    public static IDatosPantalla getControladorPantalla()
    {
        if (IDatPantalla == null)
        {
            IDatPantalla = new DatosPantalla();
        }
        return IDatPantalla;
    }
                                                
    public static IDatosPuntajePantalla getControladorPuntajePantalla()
    {
        if (IDatPuntajePantalla == null)
        {
            IDatPuntajePantalla = new DatosPuntajePantalla();
        }
        return IDatPuntajePantalla;
    }
                                                    
    public static IDatosTablero getControladorTablero()
    {
        if (IDatTablero == null)
        {
            IDatTablero = new DatosTablero();
        }
        return IDatTablero;
    }
                                                        
    public static IDatosTipoBonus getControladorTipoBonus()
    {
        if (IDatTipoBonus == null)
        {
            IDatTipoBonus = new DatosTipoBonus();
        }
        return IDatTipoBonus;
    }
                                                            
    public static IDatosTipoCondicionante getControladorTipoCondicionante()
    {
        if (IDatTipoCondicionante == null)
        {
            IDatTipoCondicionante = new DatosTipoCondicionante();
        }
        return IDatTipoCondicionante;
    }
                                                                
   public static IDatosTipoCuadrado getControladorTipoCuadrado()
    {
        if (IDatTipoCuadrado == null)
        {
            IDatTipoCuadrado = new DatosTipoCuadrado();
        }
        return IDatTipoCuadrado;
    }
                                                                    
    public static IDatosTipoJugador getControladorTipoJugador()
    {
        if (IDatTipoJugador == null)
        {
            IDatTipoJugador = new DatosTipoJugador();
        }
        return IDatTipoJugador;
    }
                                                                        
    public static IDatosTipoMensaje getControladorTipoMensaje()
    {
        if (IDatTipoMensaje == null)
        {
            IDatTipoMensaje = new DatosTipoMensaje();
        }
        return IDatTipoMensaje;
    }
                                                                            
    public static IDatosTipoObjetivo getControladorTipoObjetivo()
    {
        if (IDatTipoObjetivo == null)
        {
            IDatTipoObjetivo = new DatosTipoObjetivo();
        }
        return IDatTipoObjetivo;
    }
                                                                                
    public static IDatosUsuario getControladorTipoUsuario()
    {
        if (IDatTipoUsuario == null)
        {
            IDatTipoUsuario = new DatosUsuario();
        }
        return IDatTipoUsuario;
    }
                                                                                    
                                                                           
    public static IDatosFuncionalidad getControladorFuncionalidad()
    {
        if (IDatFuncionalidad == null)
        {
            IDatFuncionalidad = new DatosFuncionalidad();
        }
        return IDatFuncionalidad;
    }
    
    public static IDatosSubFuncionalidad getControladorSubFuncionalidad()
    {
        if (IDatSubFuncionalidad == null)
        {
            IDatSubFuncionalidad =new DatosSubFuncionalidad();
        }
        return IDatSubFuncionalidad;
    }
    
    public static IDatosTipoPermiso getControladorTipoPermiso()
    {
        if (IDatTipoPermiso == null)
        {
            IDatTipoPermiso = new DatosTipoPermiso();
        }
        return IDatTipoPermiso;
    }
    
    public static IDatosTipoOferta getControladorTipoOferta()
    {
        if (IDatTipoOferta == null)
        {
            IDatTipoOferta = new DatosTipoOferta();
        }
        return IDatTipoOferta;
    }

}
