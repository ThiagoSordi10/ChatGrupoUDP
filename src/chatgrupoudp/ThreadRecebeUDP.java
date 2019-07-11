/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatgrupoudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Thiago Sordi
 */
public class ThreadRecebeUDP extends Thread{
    public void run(){
        while(true){
            try {
                MulticastSocket socket = new MulticastSocket(12345);
                InetAddress grupo = InetAddress.getByName("230.0.0.2");

                socket.joinGroup(grupo);

                 //Recebimento de mensagens por meio do socket multicast criado
                byte[] buff = new byte[256];
                DatagramPacket datagrama = new DatagramPacket(buff, buff.length);
                socket.receive(datagrama);
                String mensagemRecebida = new String(datagrama.getData(), 0, datagrama.getLength());
                InetAddress ip = datagrama.getAddress();

                System.out.println(ip + ": " + mensagemRecebida);
            } catch (IOException ex) {
                System.out.println("Erro");
            }
        }
    }
}
