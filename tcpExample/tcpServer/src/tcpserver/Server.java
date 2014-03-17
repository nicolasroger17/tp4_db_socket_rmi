package tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        new Server().begin(4444);
    }

    
    ServerSocket serverSocket;

    public void begin(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            System.out.println("Waiting for clients to connect on port " + port + "...");
            new ProtocolThread(serverSocket.accept()).start();
            //Thread.start() calls Thread.run()
        }
    }

    class ProtocolThread extends Thread {

        Socket socket;
        PrintWriter out_socket;
        BufferedReader in_socket;

        public ProtocolThread(Socket socket) {
            System.out.println("Accepting connection from " + socket.getInetAddress() + "...");
            this.socket = socket;
            try {
                out_socket = new PrintWriter(socket.getOutputStream(), true);
                in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int chosenVal = (int) (Math.random() * 5);
        @Override
        public void run() {
            try {
                System.out.println("Expecting Hello from client...");
                //sleep(5000);
                if ("Hello".equals(in_socket.readLine())) {
                    System.out.println("Client is nice :) Let's be polite...");
                    out_socket.println("Hello");
                    System.out.println("The value is "+chosenVal);
                    while(checkVal()){}
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    System.out.println("Closing connection.");
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        public boolean checkVal() throws Exception{
            int val = Integer.parseInt(in_socket.readLine());
            
            if(val > chosenVal){
                System.out.println("it's less");
                out_socket.println("-");
            }
            else if(val < chosenVal){
                System.out.println("it's more");
                out_socket.println("+");
            }
            else{
                System.out.println("He finally found it");
                out_socket.println("done");
                return false;
            }
            return true;
        }
    }
}