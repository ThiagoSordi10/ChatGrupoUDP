/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatgrupoudp;

/**
 *
 * @author Thiago Sordi
 */
public class ChatGrupoUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EnviaUDP enviador = new EnviaUDP();
        ThreadRecebeUDP recebedor = new ThreadRecebeUDP();
        recebedor.start();   
        while(true){
            enviador.envia();
        }         
    }
    
}
