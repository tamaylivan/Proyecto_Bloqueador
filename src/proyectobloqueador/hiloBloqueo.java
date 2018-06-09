/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobloqueador;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro Tamay
 */
public class hiloBloqueo implements Runnable{
    ventanaLogin ventana;
    Thread hilo;
    
    public void start(){
        if(hilo==null){
            hilo = new Thread(this,"ejemplo");
            hilo.start();
        }    
    }
    

    @Override
    public void run() {
        
        ventana = new ventanaLogin();
        while(true){
           boolean valor = true;
           while(valor){
            if(ventana.getCantidadIntentos()>0){
                System.out.println("Intentos sobrantes: "+ventana.getCantidadIntentos());
            }else{
                valor = false;
            }
        }
        System.out.println("Intentos acabados");
        ventana.bloquearBoton(false);
        valor =true;
        while(valor){
            int contador = 10;
            
            while(contador >0){
                try {
                    hilo.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Esperar "+contador+" segundo(s)...");
                contador--;
            }
            ventana.bloquearBoton(true);
            valor = false;
        } 
        }
        
    }
}
