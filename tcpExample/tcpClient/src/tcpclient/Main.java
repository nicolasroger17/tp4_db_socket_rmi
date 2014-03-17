package tcpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    
    static Socket socket;
    static PrintWriter outSocket;
    static BufferedReader inSocket;
    
    public static void main(String[] args) throws Exception {
        socket = new Socket("localhost", 4444);
        //Socket socket = new Socket("127.0.0.1", 4444);
        //to get the ip address
        System.out.println((java.net.InetAddress.getLocalHost()).toString());

        //true: it will flush the output buffer
        outSocket = new PrintWriter(socket.getOutputStream(), true);
        inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       // Thread.sleep(1000);

        System.out.println("Sending Hello to server");
        outSocket.println("Hello");
        System.out.println("Waiting answer from server");
        if ("Hello".equals(inSocket.readLine())) {
            System.out.println("Server is nice :)");
        }
        while(true){
            sendValToServer();
        }
    }
    
    public static void sendValToServer() throws Exception{
        Scanner sc;
        int val;
        
        sc = new Scanner(System.in);
        System.out.println("Plz enter a value");
        val = Integer.parseInt(sc.nextLine());
        outSocket = new PrintWriter(socket.getOutputStream(), true);
        outSocket.println(val);
        System.out.println("value sent to Server");
        String res = inSocket.readLine();
        if(res.equals("done")){
            System.out.println("You Won");
            System.exit(1);
        }
        else{
            System.out.println(res);
        }
    }
}