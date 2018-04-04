/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.fachada;

import logica.controlador.*;
import logica.interfaces.*;

/**
 *
 * @author Lourdes Couto
 */
public class FabricaLogica {
    
    private static ILogicaBonus ILogBonus; 
    private static ILogicaCondicionante ILogCondicionante;
    private static ILogicaCorazon ILogCorazon;
    private static ILogicaCuadrado ILogCuadrado;
    private static ILogicaEstrella ILogEstrella;
    private static ILogicaFicha ILogFicha;
    private static ILogicaFuncionalidad ILogFuncionalidad;
    private static ILogicaImagenJuego ILogImagenJuego;
    private static ILogicaImagenMapa ILogImagenData;
    private static ILogicaJugador ILogJugador;
    private static ILogicaLingote ILogLingote;
    private static ILogicaMapa ILogMapa;
    private static ILogicaMensaje ILogMensaje;
    private static ILogicaModelo  ILogModelo;
    private static ILogicaObjetivo ILogObjetivo;
    private static ILogicaOferta ILogOferta;
    private static ILogicaPantalla ILogPantalla;
    private static ILogicaPerfilUsuario ILogUsuario;
    private static ILogicaPermisoFuncionalidad ILogPermisoFuncionalidad;
    private static ILogicaPuntajePantalla ILogPuntajePantalla;
    private static ILogicaSubFuncionalidad ILogSubFuncionalidad;
    private static ILogicaTablero ILogTablero;
    private static ILogicaTipoBonus ILogTipoBonus;
    private static ILogicaTipoCondicionante ILogTipoCondicionante;
    private static ILogicaTipoCuadrado ILogTipoCuadrado;
    private static ILogicaTipoJugador  ILogTipoJugador;
    private static ILogicaTipoMensaje ILogTipoMensaje;
    private static ILogicaTipoObjetivo ILogTipoObjetivo;
    private static ILogicaTipoOferta ILogTipoOferta;
    private static ILogicaTipoPerfil ILogTipoPerfil;
    private static ILogicaTipoPermiso ILogTipoPermiso;
    private static ILogicaUsuario ILogTipoUsuario;
    
    public static ILogicaBonus getControladorBonus()
    {
        if (ILogBonus == null)
        {
            ILogBonus = new LogicaBonus();
        }
        return ILogBonus;
    }
    
//     public static ILogicaCondicionante getControladorCondicionante()
//    {
//        if (ILogCondicionante == null)
//        {
//            ILogCondicionante = new LogicaCondicionante();
//        }
//        return ILogCondicionante;
//    }
//    
//    public static IDatosCorazon getControladorCorazon()
//    {
//        if (IDatCorazon == null)
//        {
//            IDatCorazon = new DatosCorazon();
//        }
//        return IDatCorazon;
//    }
//        
//    public static IDatosCuadrado getControladorCuadrado()
//    {
//        if (IDatCuadrado == null)
//        {
//            IDatCuadrado = new DatosCuadrado();
//        }
//        return IDatCuadrado;
//    }
//        
//        
//    public static IDatosEstrella getControladorEstrella()
//    {
//        if (IDatEstrella == null)
//        {
//            IDatEstrella = new DatosEstrella();
//        }
//        return IDatEstrella;
//    }
//            
    public static ILogicaFicha getControladorFicha()
    {
        if (ILogFicha == null)
        {
            ILogFicha = new LogicaFicha();
        }
        return ILogFicha;
    }
//                
//    public static IDatosJugador getControladorJugador()
//    {
//        if (IDatJugador == null)
//        {
//            IDatJugador = new DatosJugador();
//        }
//        return IDatJugador;
//    }
//                    
//    public static IDatosLingote getControladorLingote()
//    {
//        if (IDatLingote == null)
//        {
//            IDatLingote = new DatosLingote();
//        }
//        return IDatLingote;
//    }
//                        
//    public static IDatosMapa getControladorMapa()
//    {
//        if (IDatMapa == null)
//        {
//            IDatMapa = new DatosMapa();
//        }
//        return IDatMapa;
//    }
//                            
//   public static IDatosMensaje getControladorMensaje()
//    {
//        if (IDatMensaje == null)
//        {
//            IDatMensaje = new DatosMensaje();
//        }
//        return IDatMensaje;
//    }
//                                
//   public static IDatosModelo getControladorModelo()
//    {
//        if (IDatModelo == null)
//        {
//            IDatModelo = new DatosModelo();
//        }
//        return IDatModelo;
//    }
//                                    
//    public static IDatosObjetivo getControladorObjetivo()
//    {
//        if (IDatObjetivo == null)
//        {
//            IDatObjetivo = new DatosObjetivo();
//        }
//        return IDatObjetivo;
//    }
//                                        
//    public static IDatosOferta getControladorOferta()
//    {
//        if (IDatOferta == null)
//        {
//            IDatOferta = new DatosOferta();
//        }
//        return IDatOferta;
//    }
//                                            
//    public static IDatosPantalla getControladorPantalla()
//    {
//        if (IDatPantalla == null)
//        {
//            IDatPantalla = new DatosPantalla();
//        }
//        return IDatPantalla;
//    }
//                                                
//    public static IDatosPuntajePantalla getControladorPuntajePantalla()
//    {
//        if (IDatPuntajePantalla == null)
//        {
//            IDatPuntajePantalla = new DatosPuntajePantalla();
//        }
//        return IDatPuntajePantalla;
//    }
//                                                    
//    public static IDatosTablero getControladorTablero()
//    {
//        if (IDatTablero == null)
//        {
//            IDatTablero = new DatosTablero();
//        }
//        return IDatTablero;
//    }
//                                                        
//    public static IDatosTipoBonus getControladorTipoBonus()
//    {
//        if (IDatTipoBonus == null)
//        {
//            IDatTipoBonus = new DatosTipoBonus();
//        }
//        return IDatTipoBonus;
//    }
//                                                            
//    public static IDatosTipoCondicionante getControladorTipoCondicionante()
//    {
//        if (IDatTipoCondicionante == null)
//        {
//            IDatTipoCondicionante = new DatosTipoCondicionante();
//        }
//        return IDatTipoCondicionante;
//    }
//                                                                
//   public static IDatosTipoCuadrado getControladorTipoCuadrado()
//    {
//        if (IDatTipoCuadrado == null)
//        {
//            IDatTipoCuadrado = new DatosTipoCuadrado();
//        }
//        return IDatTipoCuadrado;
//    }
//                                                                    
//    public static IDatosTipoJugador getControladorTipoJugador()
//    {
//        if (IDatTipoJugador == null)
//        {
//            IDatTipoJugador = new DatosTipoJugador();
//        }
//        return IDatTipoJugador;
//    }
//                                                                        
//    public static IDatosTipoMensaje getControladorTipoMensaje()
//    {
//        if (IDatTipoMensaje == null)
//        {
//            IDatTipoMensaje = new DatosTipoMensaje();
//        }
//        return IDatTipoMensaje;
//    }
//                                                                            
//    public static IDatosTipoObjetivo getControladorTipoObjetivo()
//    {
//        if (IDatTipoObjetivo == null)
//        {
//            IDatTipoObjetivo = new DatosTipoObjetivo();
//        }
//        return IDatTipoObjetivo;
//    }
//                                                                                
//    public static IDatosUsuario getControladorTipoUsuario()
//    {
//        if (IDatTipoUsuario == null)
//        {
//            IDatTipoUsuario = new DatosUsuario();
//        }
//        return IDatTipoUsuario;
//    }
    
    public static ILogicaFuncionalidad getControladorFuncionalidad()
    {
        if (ILogFuncionalidad == null)
        {
            ILogFuncionalidad = new LogicaFuncionalidad();
        }
        return ILogFuncionalidad;
    }
    
    public static ILogicaSubFuncionalidad getControladorSubFuncionalidad()
    {
        if (ILogSubFuncionalidad == null)
        {
            ILogSubFuncionalidad =new LogicaSubFuncionalidad();
        }
        return ILogSubFuncionalidad;
    }
    
    public static ILogicaTipoPermiso getControladorTipoPermiso()
    {
        if (ILogTipoPermiso == null)
        {
            ILogTipoPermiso = new LogicaTipoPermiso();
        }
        return ILogTipoPermiso;
    }
    
    public static ILogicaTablero getControladorTablero()
    {
        if (ILogTablero == null)
        {
            ILogTablero = new LogicaTablero();
        }
        return ILogTablero;
    }
    
    public static ILogicaCuadrado getControladorCuadrado()
    {
        if (ILogCuadrado == null)
        {
            ILogCuadrado = new LogicaCuadrado();
        }
        return ILogCuadrado;
    }
    
   
}
