package client;
import java.io.*;
import  java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {

    public static void main(String[] args) throws  UnknownHostException, IOException
            {
       
    int number = 0 ,temp;
    Scanner sc =new Scanner(System.in);
    Socket s =new  Socket("192.168.177.1",8080);
    Scanner sc1 = new Scanner(s.getInputStream());
    
    System.out.println("enter any number");
    PrintStream p=new PrintStream(s.getOutputStream());
    p.println(number);
    temp= sc1.nextInt();
    System.out.println(temp);
    
    }
    
}
