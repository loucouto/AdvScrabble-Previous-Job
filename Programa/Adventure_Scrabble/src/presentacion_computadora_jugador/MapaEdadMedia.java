/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion_computadora_jugador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lourdes
 */
public class MapaEdadMedia {
    
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
            
                MarcoMapa marco1 = new MarcoMapa();
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

 class MarcoMapa extends JFrame
 {
     
        private int largo = 0;
        private int altura = 0;
        private int comienzo = 0;
        private JButton corona_uno = new JButton();
        private JButton corona_dos = new JButton();        
        private Point p = new Point();
       
        public MarcoMapa()
        {
           try
           {
                setTitle("Adventure Scrabble - Mantenimiento");
                setBounds(100,50,752,495);

              //  largo = this.getWidth();
              //  altura = this.getHeight();
                
                LaminaConImagen milamina = new LaminaConImagen();
                add(milamina);
                
                addComponentListener(new java.awt.event.ComponentAdapter() {
                       public void componentResized(java.awt.event.ComponentEvent evt) {
                           formComponentResized(evt);
                       }
                   });
                
                milamina.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
                    public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                        LaminaMouseWheelMoved(evt);
                    }
                });

           }
           catch(Exception ex)
           {
                 Logger.getLogger(MarcoMapa.class.getName()).log(Level.SEVERE, null, ex); 
           } 
            
        } 
     
         private void formComponentResized(java.awt.event.ComponentEvent evt) {                                      
       // TODO add your handling code here:
 
               LaminaConImagen milamina = new LaminaConImagen();
               add(milamina);
        }  
         
         private void BotonCoronaUnoActionPerformed(java.awt.event.ActionEvent evt)
         {
         
         
         }
         
         private void BotonCoronaDosActionPerformed(java.awt.event.ActionEvent evt)
         {
         
         
         }
        
    private void LaminaMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                               
        // TODO add your handling code here:
         
        if(evt.getWheelRotation() > 0)
        {
            
            comienzo++;
                
        }
        else
        {   
            comienzo--;
        }        

        LaminaConImagen milamina = new LaminaConImagen();
        add(milamina);
        
    }                             
         
    class LaminaConImagen extends JPanel
    {
     
        private Image imagen;
//        
//
        public LaminaConImagen(){}
//
        public void paintComponent(Graphics  g)
        {
            try
            { 
//
                  super.paintComponent(g);
                  
                  
                  File miimagen = new File("C:\\Users\\Lourdes\\Desktop\\Trabajos\\ProyVideojuegoScrabbleNumber\\Programa\\Barras y Otros\\ImagenPrueba.png"); 
                  imagen = ImageIO.read(miimagen);
                 // g.drawImage(imagen, 0, 0, largo, altura, null);
                  g.drawImage(imagen, 0, comienzo, null);
                  
                  corona_uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CoronaRey1.png")));
                  corona_dos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CoronaRey2.png")));
                  
                  corona_uno.setBorder(null);
                  corona_dos.setBorder(null);
                  
                  add(corona_uno);
                  add(corona_dos);
                  
                  p = new Point(40,600);
                  corona_uno.setLocation(p);
                  
                  p = new Point(120,550);
                  corona_dos.setLocation(p);

            }
            catch(Exception ex)
            {
                   Logger.getLogger(LaminaConImagen.class.getName()).log(Level.SEVERE, null, ex); 
            }
//
        }
//        
        
        
     }
    
   
       // public void repintarComponente()
        
    }
