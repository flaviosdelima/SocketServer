/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Flávio
 */
public class TrataCliente implements Runnable {
 
   private InputStream cliente;
   private SocketServerChat servidor;
 
   public TrataCliente(InputStream cliente, SocketServerChat servidor) {
     this.cliente = cliente;
     this.servidor = servidor;
   }
 
   public void run() {
     // quando chegar uma msg, distribui pra todos
     Scanner s = new Scanner(this.cliente);
     while (s.hasNextLine()) {
       servidor.distribuiMensagem(s.nextLine());
     }
     s.close();
   }
 }
