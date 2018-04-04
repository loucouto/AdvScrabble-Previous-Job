/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion_computadora_jugador;

import entidades_compartidas.FichaTablero;
import entidades_compartidas.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logica.fachada.FabricaLogica;

/**
 *
 * @author Lourdes
 */
public class PantallaUno {
    
       public static void main(String[] args) {
        // TODO code application logic here
        
         try 
         {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }

            }
            
                MarcoPantallaUno marco1 = new MarcoPantallaUno();
                marco1.setVisible(true);
                marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        } 
         catch (ClassNotFoundException ex) 
         {
            java.util.logging.Logger.getLogger(MapaEdadMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } 
         catch (InstantiationException ex) 
         {
            java.util.logging.Logger.getLogger(MapaEdadMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } 
         catch (IllegalAccessException ex) 
         {
            java.util.logging.Logger.getLogger(MapaEdadMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } 
         catch (javax.swing.UnsupportedLookAndFeelException ex) 
         {
            java.util.logging.Logger.getLogger(MapaEdadMedia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
       
    }
    
}
 class MarcoPantallaUno extends JFrame
 {
        private Font fuente = new Font("Comic Sans MS", Font.BOLD, 18);
        private Point p = new Point();
        JButton boton_bonus1 = new JButton();
        JButton boton_bonus2 = new JButton();
        JButton boton_bonus3 = new JButton();
        JButton botonizq = new JButton();
        JButton botonder = new JButton();
        private ArrayList<Bonus> lista_bonus = new ArrayList();
        private int numero_azar = 0;
        private int k = 0;
        Ficha f = new Ficha();
        ArrayList<Ficha> lista_ficha = new ArrayList();
       // ArrayList<JLabel> lista_label = new ArrayList();
        private int lugar = 0;
        private boolean movido = false;
        private int mouse_x = 0;
        private int mouse_y = 0;
        private Image imagenFicha;
        private Image imagenCuadrado;
        private boolean soltado = false;
        private boolean tocado = false;
        private boolean presionado = false;
        private boolean primera_ficha = true;
        private int numero_de_ficha = -1;
        private int numero_k = 0;
        private int tope_k = 10;
        private ArrayList<FichaTablero> lista_ficha_tablero = new ArrayList();
        private Tablero t = new Tablero();
//        int [] lista_x = {400, 464, 528 ,592, 656, 720, 784, 848, 912, 976};
//        int [] lista_y = {10, 74, 138, 202, 266, 330, 394, 458, 522, 586};532
        private int x_ady = 0;
        private int y_ady = 0;
        private int puntos_bloque = 0;
        private int suma_puntos = 0;
        
        
        public MarcoPantallaUno()
        {
           try
           {
                setTitle("Pantalla1");
                setBounds(100,50,752,495);
                botonizq.setActionCommand("izquierda");
                botonder.setActionCommand("derecha");
                 for(int i=0 ; i<15; i++)
                  {
                      while (numero_azar == 0)
                      {
                         numero_azar = (int)(Math.random()*90);
                      }

                      f = FabricaLogica.getControladorFicha().BuscarFichaPorId(numero_azar);
                      lista_ficha.add(f);

                      numero_azar = 0;
                  }
                
//                  for (int i = 0; i<15; i++)
//                  {
//                      JLabel ficha = new JLabel();
//                      lista_label.add(ficha);
//                  }       

                t = FabricaLogica.getControladorTablero().BuscarTableroPorId(1, 1, 1);

                LaminaPantalla milamina = new LaminaPantalla();
                add(milamina);

                botonizq.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActionPerformed(evt);
                }
            });
                
                botonder.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActionPerformed(evt);
                }
                });
                
                milamina.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                public void mouseDragged(java.awt.event.MouseEvent evt) {
                    MiLaminaMouseDragged(evt);
                }
                });
                
                milamina.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                MiLaminaMouseReleased(evt);
                }
                 public void mousePressed(java.awt.event.MouseEvent evt) {
                MiLaminaMousePressed(evt);
                }
                });
                
           }
           catch(Exception ex)
           {
                 Logger.getLogger(MarcoMapa.class.getName()).log(Level.SEVERE, null, ex); 
           } 
            
        } 
     
   private void BotonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        try
        {
             if(evt.getActionCommand().equals("izquierda"))
             {
                 if(k>0)
                 {
                    k--;
                 }   
             }
             else
             {
                 if(k<tope_k)
                 {
                    k++;
                 }
             }
            //  removido = true;
//             LaminaPantalla milamina = new LaminaPantalla();
//             add(milamina);
            
        }
        catch(Exception ex)
        {
            Logger.getLogger(LaminaPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
   
    private void MiLaminaMouseDragged(java.awt.event.MouseEvent evt) {                                            
        // TODO add your handling code here:
        try
        {
              mouse_x = evt.getX();
              mouse_y = evt.getY();
              
              movido = true;
        }
        catch(Exception ex)
        {
            Logger.getLogger(LaminaPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }             
   
      private void MiLaminaMouseReleased(java.awt.event.MouseEvent evt) {                                             
        // TODO add your handling code here:
         try
        {
                mouse_x = evt.getX();
                mouse_y = evt.getY();
              
                movido = false; 
                soltado = true;
        }
        catch(Exception ex)
        {
            Logger.getLogger(LaminaPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }      
    
    private void MiLaminaMousePressed(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
       try
        {
             mouse_x = evt.getX();
             mouse_y = evt.getY();

           tocado = true;
           movido = true;
          //  }
        }
        catch(Exception ex)
        {
            Logger.getLogger(LaminaPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                 
  
      
  
    class LaminaPantalla extends JPanel
    {
     
        private Image imagen;
//        
//
        public LaminaPantalla(){}
//
        private Cuadrado ObtenerCuadrado(int pCoordenada_x, int pCoordenada_y)
        {
           Cuadrado retorno = new Cuadrado();
            
            for(int i = 0; i < t.getLista_cuadrado().size() ;i++)
            {
                 if((t.getLista_cuadrado().get(i).getCoordenada_x() == pCoordenada_x) && (t.getLista_cuadrado().get(i).getCoordenada_y() == pCoordenada_y))
                 {
                    retorno = t.getLista_cuadrado().get(i);
                 }
            }

            return retorno;
        }
         
         private boolean EstaCuadradoOcupado(int pCoordenada_x, int pCoordenada_y)
        {
            boolean retorno = false;
            
            for(int i = 0; i < t.getLista_cuadrado().size() ;i++)
            {
                 if((t.getLista_cuadrado().get(i).getCoordenada_x() == pCoordenada_x) && (t.getLista_cuadrado().get(i).getCoordenada_y() == pCoordenada_y))
                 {
                    retorno = t.getLista_cuadrado().get(i).isOcupado();
                 }
            }

            return retorno;
        }
        
         private void OcuparCuadrado(int pCoordenada_x, int pCoordenada_y)
         {
            for(int i = 0; i < t.getLista_cuadrado().size() ;i++)
            {
                 if((t.getLista_cuadrado().get(i).getCoordenada_x() == pCoordenada_x) && (t.getLista_cuadrado().get(i).getCoordenada_y() == pCoordenada_y))
                 {
                    t.getLista_cuadrado().get(i).setOcupado(true);
                 }
            }
         } 

        public void paintComponent(Graphics  g)
        {
            try
            { 
                  super.paintComponent(g);
             
                  File miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Tableros\\" + t.getArchivo()); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 400, 10, null);
                  
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\Dispensador.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 500, 609, 384, 97,null);
                  
                  botonizq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonDesplazamientoIzq.png")));
                  add(botonizq);
                  botonizq.setBorder(null);
                  p = new Point(415,619);
                  botonizq.setLocation(p);
                  
                  botonder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BotonDesplazamientoDer.png")));
                  add(botonder);
                  botonder.setBorder(null);
                  p = new Point(890,619);
                  botonder.setLocation(p);
                  
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\BarraListaBonus.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 10, 10, null);
                  
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\Barra2.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 10, 100, null);
                  g.setFont(fuente);
                  g.setColor(Color.BLACK);
                  g.drawString("" + mouse_x + " " + mouse_y, 45, 144);
                  
                  g.drawImage(imagen, 10, 310, null);
                   
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\BarraMov.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 10, 190, null); 
                  
                  g.setFont(fuente);
                  g.setColor(Color.BLACK);
                  g.drawString("Ficha:", 45, 235);
                  
                  g.setFont(fuente);
                  g.setColor(Color.BLACK);
                  g.drawString("Movimiento:", 45, 262);
                  
                  g.setFont(fuente);
                  g.setColor(Color.BLACK);
                  g.drawString("Puntaje:", 47, 355);
                  
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\CuadroPuntaje.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 10, 408, null);
                  
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\BarraPuntaje2.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 45, 502, null); 
                  
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\EstrellaRoja.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 45, 455, null); 
                  
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\EstrellaAmarilla.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 100, 455, null); 
                  
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\EstrellaVerde.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, 140, 455, null); 
                  
//                  if(primera_ficha == true)
//                  {
                  x_ady = 656;
                  y_ady = 266;
                  miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoCuadradosRemarcados\\CuadradoEstrellaRemarcado.png"); 
                  imagen = ImageIO.read(miimagen);
                  g.drawImage(imagen, x_ady, y_ady, null);
                  primera_ficha = false;
//                  }
                  
                  /*Para el listado de bonus*/
                  
                  boton_bonus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ManoBonus.png")));
                  boton_bonus1.setBorder(null);
                  add(boton_bonus1);
                  p = new Point(40,35);
                  boton_bonus1.setLocation(p);
                  boton_bonus1.setFont(new java.awt.Font("Tahoma", 1, 11));
                  boton_bonus1.setForeground(Color.BLACK);
                  boton_bonus1.setOpaque(false);
                  boton_bonus1.setText("" + 1);
                  boton_bonus1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                  
                  boton_bonus2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PuntajeBonus.png")));
                  boton_bonus2.setBorder(null);
                  add(boton_bonus2);
                  p = new Point(75,35);
                  boton_bonus2.setLocation(p);
                  boton_bonus2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                  boton_bonus2.setForeground(new java.awt.Color(255, 255, 255));
                  boton_bonus2.setText("" + 1);
                  boton_bonus2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                  boton_bonus3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IntercambioBonus.png")));
                  boton_bonus3.setBorder(null);
                  add(boton_bonus3);
                  p = new Point(110,35);
                  boton_bonus3.setLocation(p);
                  boton_bonus3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
                  boton_bonus3.setForeground(Color.BLACK);
                  boton_bonus3.setText("" + 1);
                  boton_bonus3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                 boolean tope_kenesimo = false;

                 for(int i=k; i<(k+5) && tope_kenesimo == false; i++)
                 {
                     
//                      lista_label.get(i).setIcon(new javax.swing.ImageIcon(getClass().getResource(lista_ficha.get(i).getArchivo())));
//                      lista_label.get(i).setBorder(null);
//                      add(lista_label.get(i));
//                      p = new Point(541 + (60 * lugar),592);
//                      lista_label.get(i).setLocation(p);
//                      lugar++;
                        miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoFichas\\"  +  lista_ficha.get(i).getArchivo()); 
                        imagen = ImageIO.read(miimagen);
                        g.drawImage(imagen, 541 + (60 * lugar), 592, null); 
                        lugar++;
                        
                        if(i == lista_ficha.size()-1)
                        {
                            tope_kenesimo = true;
                        }
                 }
                 
                 if(movido == true)
                 {
                       if((mouse_x >=  541) && (mouse_x <= 600) && (mouse_y >= 592) && (mouse_y <= 652) && (presionado == false))
                       {
                           miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoFichas\\"  +  lista_ficha.get(k).getArchivo()); 
                           imagenFicha = ImageIO.read(miimagen);
                           numero_k = k;
                           presionado = true;
                       }
                       else if((mouse_x >=  601) && (mouse_x <= 660) && (mouse_y >= 592) && (mouse_y <= 652) && (presionado == false))
                       {
                           miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoFichas\\"  +  lista_ficha.get(k+1).getArchivo()); 
                           imagenFicha = ImageIO.read(miimagen);
                           numero_k = k+1;
                           presionado = true;
                       }
                       else if((mouse_x >=  661) && (mouse_x <= 720) && (mouse_y >= 592) && (mouse_y <= 652) && (presionado == false))
                       {
                           miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoFichas\\"  +  lista_ficha.get(k+2).getArchivo()); 
                           imagenFicha = ImageIO.read(miimagen);
                           numero_k = k+2;
                           presionado = true;
                       }
                       else if((mouse_x >=  721) && (mouse_x <= 780) && (mouse_y >= 592) && (mouse_y <= 652) && (presionado == false))
                       {
                           miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoFichas\\"  +  lista_ficha.get(k+3).getArchivo()); 
                           imagenFicha = ImageIO.read(miimagen);
                           numero_k = k+3;
                           presionado = true;
                       }
                       else if((mouse_x >=  781) && (mouse_x <= 840) && (mouse_y >= 592) && (mouse_y <= 652) && (presionado == false))
                       {
                           miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoFichas\\"  +  lista_ficha.get(k+4).getArchivo()); 
                           imagenFicha = ImageIO.read(miimagen);
                           numero_k = k+4;
                           presionado = true;
                       }
                       
                       if(tocado == true)
                       {
                           if((mouse_x >=  541) && (mouse_x <= 600) && (mouse_y >= 592) && (mouse_y <= 652))
                           {
                               lista_ficha.remove(k);
                           }
                           else if((mouse_x >=  601) && (mouse_x <= 660) && (mouse_y >= 592) && (mouse_y <= 652))
                           {
                               lista_ficha.remove(k+1);
                           }
                           else if((mouse_x >=  661) && (mouse_x <= 720) && (mouse_y >= 592) && (mouse_y <= 652))
                           {
                               lista_ficha.remove(k+2);
                           }
                           else if((mouse_x >=  721) && (mouse_x <= 780) && (mouse_y >= 592) && (mouse_y <= 652))
                           {
                               lista_ficha.remove(k+3);
                           }
                           else if((mouse_x >=  781) && (mouse_x <= 840) && (mouse_y >= 592) && (mouse_y <= 652))
                           {
                               lista_ficha.remove(k+4);
                           }
                           
                           --tope_k; 
                        }

                       g.drawImage(imagenFicha, mouse_x, mouse_y, null); 
                       tocado = false;
                       movido = false;
                      
                  }
                 
//                 if(soltado == true)
//                 {
//                      
//                 }
                 
                if(imagenFicha!=null)
                {                 
                    if((numero_de_ficha != numero_k) && (soltado == true) && ((mouse_x >= 400) && (mouse_x <= 979) && (mouse_y >= 10) && (mouse_y <= 590)))
                    {
                        presionado = false;
                        boolean tope_x = false;
                        boolean tope_y = false;
                       
                        for(int i=0; i<t.getLista_cuadrado().size() && tope_x==false; i++)
                        {
                            if(t.getLista_cuadrado().get(i).getCoordenada_x() - 4  > mouse_x)
                            {
                                if(((t.getLista_cuadrado().get(i).getCoordenada_x() - 4) - mouse_x) < (mouse_x - (t.getLista_cuadrado().get(i-1).getCoordenada_x() - 4)))
                                {
                                   mouse_x = t.getLista_cuadrado().get(i).getCoordenada_x();
                                }
                                else
                                {
                                   mouse_x = t.getLista_cuadrado().get(i-1).getCoordenada_x();
                                }
                                
                                tope_x = true;
                            }

                        }
                        
                        for(int i=0; i<t.getLista_cuadrado().size() && tope_y == false; i++)
                        {
                            if(t.getLista_cuadrado().get(i).getCoordenada_y() - 4  > mouse_y)
                            {
                                if(((t.getLista_cuadrado().get(i).getCoordenada_y() - 4) - mouse_y) < (mouse_y - (t.getLista_cuadrado().get(i-1).getCoordenada_y() - 4)))
                                {
                                   mouse_y = t.getLista_cuadrado().get(i).getCoordenada_y();
                                }
                                else
                                {
                                   mouse_y = t.getLista_cuadrado().get(i-1).getCoordenada_y();
                                }
                                
                                tope_y = true;
                            }

                        }

                        while(this.EstaCuadradoOcupado(mouse_x, mouse_y) == true)
                        {
                            int n = 1;
                            
                            if(this.EstaCuadradoOcupado(mouse_x+(64 * n), mouse_y) == false)
                            {
                                mouse_x =  mouse_x + (64 * n);
                            }
                            else if(this.EstaCuadradoOcupado(mouse_x+(64 * n), mouse_y+(64 * n)) == false)
                            {
                                mouse_x =  mouse_x + (64 * n);
                                mouse_y = mouse_y + (64 * n);
                            }
                            else if(this.EstaCuadradoOcupado(mouse_x, mouse_y+(64 * n)) == false)
                            {
                                mouse_y = mouse_y + (64 * n);
                            }
                            else if(this.EstaCuadradoOcupado(mouse_x-(64 * n), mouse_y+(64 * n)) == false)
                            {
                                mouse_x =  mouse_x - (64 * n);
                                mouse_y = mouse_y + (64 * n);
                            
                            }
                            else if(this.EstaCuadradoOcupado(mouse_x-(64 * n), mouse_y) == false)
                            {
                                mouse_x =  mouse_x - (64 * n);
                            }
                            else if(this.EstaCuadradoOcupado(mouse_x-(64 * n), mouse_y-(64 * n)) == false)
                            {
                                mouse_x =  mouse_x - (64 * n);
                                mouse_y = mouse_y - (64 * n);
                            
                            }
                            else if(this.EstaCuadradoOcupado(mouse_x, mouse_y-(64 * n)) == false)
                            {
                                mouse_y = mouse_y - (64 * n);
                            }
                            else if(this.EstaCuadradoOcupado(mouse_x + (64 * n), mouse_y -(64 * n)) == false)
                            {
                                mouse_x =  mouse_x + (64 * n);
                                mouse_y = mouse_y - (64 * n);
                            }
                            
                            n++;
                        }
                        
//                        if(primera_ficha == false)
//                        {
//                            x_ady = 532;
//                            y_ady = 14;
//                            miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoCuadradosRemarcados\\CuadroEstrellaRemarcado.png"); 
//                            imagen = ImageIO.read(miimagen);
//                            g.drawImage(imagen, x_ady, y_ady, null);
//                            primera_ficha = false;
//                        }

                        FichaTablero ft = new FichaTablero();
                        ft.setImagen(imagenFicha);
                        ft.setCoordenada_x(mouse_x);
                        ft.setCoordenada_y(mouse_y);
                        ft.setNumero_ficha(lista_ficha.get(numero_k).getNumero_ficha());
                        ft.setPuntaje_ficha(lista_ficha.get(numero_k).getPuntaje_ficha());
                        
                        lista_ficha_tablero.add(ft);
                        numero_de_ficha = numero_k;
                        soltado = false;
                        imagenFicha = null; 
                        this.OcuparCuadrado(mouse_x, mouse_y);
                    }
                }
  
                for(FichaTablero ftr : lista_ficha_tablero)
                {
                        g.drawImage(ftr.getImagen(), ftr.getCoordenada_x(), ftr.getCoordenada_y(), null);

//                        if(this.EstaCuadradoOcupado(ftr.getCoordenada_x(), ftr.getCoordenada_y()) == false)
//                        {
//
//                            miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoCuadradosRemarcados\\CuadradoSimpleRemarcado.png"); 
//                            imagenCuadrado = ImageIO.read(miimagen);
//                            g.drawImage(imagenCuadrado, ftr.getCoordenada_x() + 68, ftr.getCoordenada_y(), null);
//                            
//                            miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoCuadradosRemarcados\\CuadradoSimpleRemarcado.png"); 
//                            imagenCuadrado = ImageIO.read(miimagen);
//                            g.drawImage(imagenCuadrado, ftr.getCoordenada_x() + 68, ftr.getCoordenada_y() + 68, null);
//                            
//                            miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoCuadradosRemarcados\\CuadradoSimpleRemarcado.png"); 
//                            imagenCuadrado = ImageIO.read(miimagen);
//                            g.drawImage(imagenCuadrado, ftr.getCoordenada_x() - 68, ftr.getCoordenada_y(), null);
//                            
//                            miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\DibujoCuadradosRemarcados\\CuadradoSimpleRemarcado.png"); 
//                            imagenCuadrado = ImageIO.read(miimagen);
//                            g.drawImage(imagenCuadrado, ftr.getCoordenada_x() - 68, ftr.getCoordenada_y() - 68, null);
//
//                        }
                        
                      
//                            Cuadrado c = this.ObtenerCuadrado(mouse_x, mouse_y);
//                            if(c!= null)
//                            {
//                                switch(c.getTipo_cuadrado().getId())
//                                {
//    //                                case 1:
//    //                                    
//    //                                    
//    //                                break;                            
//                                    case 2:
//
//                                        puntos_bloque = ftr.getPuntaje_ficha() * 2;
//
//                                    break;
//    
//    //                                case 5:
//    //
//    //                                    
//    //                                break; 
//                                    case 6:
//
//                                        puntos_bloque = ftr.getPuntaje_ficha() * 3;
//
//                                    break; 
//                                    default:
//
//                                    puntos_bloque = ftr.getPuntaje_ficha();
//
//                                }
//                            }
//                          suma_puntos += puntos_bloque;
                          
                }
                
//                  g.setFont(fuente);
//                  g.setColor(Color.BLACK);
//                  //g.drawString("Objetivo:", 45, 144);
//                  g.drawString("" + suma_puntos, 120, 355);
//
//                 puntos_bloque = 0;
//                 suma_puntos = 0;
                lugar = 0;
               
            }
            catch(Exception ex)
            {
                   Logger.getLogger(LaminaPantalla.class.getName()).log(Level.SEVERE, null, ex); 
            }
//
        }
   
     }
    
   
       // public void repintarComponente()
        
    }
    
       
       

    

