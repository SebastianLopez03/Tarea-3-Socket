package Tarea3Socket.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    private Scanner sn;
    private Socket sc;
    private DataInputStream in;
    private DataOutputStream out;
    public Client(String host, int port){
        try {
            sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        sc = new Socket(host,port);
        
        in = new DataInputStream(sc.getInputStream());
        out = new DataOutputStream(sc.getOutputStream());

        String message = in.readUTF();
        System.out.println(message);
        
        String name = sn.next();
        out.writeUTF(name);


        } catch (Exception e) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, host, e);
        }


    }

    public static void main(String[] args) {
        Client cl = new Client("127.0.0.1", 5000);
    }
}
