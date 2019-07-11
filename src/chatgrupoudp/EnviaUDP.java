/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatgrupoudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago Sordi
 */
public class EnviaUDP {
    
    public void envia(){
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress grupo = null;
            
            Scanner scan = new Scanner(System.in);
            String mensagem = "";
            
         
            grupo = InetAddress.getByName("230.0.0.2");
            
            System.out.print(">> ");
            mensagem = scan.nextLine();
            byte[] buff = mensagem.getBytes();
            
            DatagramPacket datagrama = new DatagramPacket(buff, buff.length, grupo, 12345);
            socket.send(datagrama);
            
        } catch (SocketException ex) {
            System.out.println("Erro");
        } catch (IOException ex) {
            System.out.println("Erro");
        }
    }
}
