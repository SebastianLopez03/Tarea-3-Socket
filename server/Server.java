package Tarea3Socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private ServerSocket server; 

    public Server(int port){
        try {
            server = new ServerSocket(port);
            Socket sc;
            System.out.println("Servidor iniciado");
            while (true) {
                sc =server.accept();
                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());

                out.writeUTF("indicatunmae");
                String name = in.readUTF();
                ServerThread sThread = new ServerThread(in, out, name);
                sThread.start();
                System.out.println("Conexion creada con "+name);
            }   



        } catch (Exception e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}
