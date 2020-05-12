/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		// Passo 1: Criar o objeto socket que é responsável por manter o dado
		DatagramSocket s = new DatagramSocket();
                InetAddress dest = InetAddress.getByName("localhost");
		String envio;
                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("> ");
                envio = teclado.readLine();
		byte buf[] = null;
		
		while (true)
		{
                    while(!envio.equalsIgnoreCase("")){
                        byte[] buffer = envio.getBytes();

                        DatagramPacket msg = new DatagramPacket(buffer,
                        buffer.length, dest, 4545);

                        s.send(msg);

                        DatagramPacket resposta = new DatagramPacket(new byte[512], 512);
                        s.receive(resposta);

                        for(int i = 0; i < resposta.getLength(); i++){
                            System.out.print((char) resposta.getData()[i]);
                        }
                        System.out.println();
                        System.out.print("> ");
                        envio = teclado.readLine();
                    }
                    s.close();
         
		}
		
	}

}
