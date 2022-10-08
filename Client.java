/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom3_pm24.pkg06;

/**
 *
 * @author lehon
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    
    public static void main(String[] args) {
          Scanner sc =  new Scanner(System.in);
         
         
             try{
                  
            while(true){
                
                 
                    //tao socket
                Socket socket = new Socket("127.0.0.1", 6789);
                
                //tao 2 doi tuong de nhan va gui
                BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                
                // nhap du lieu
             
                System.out.print("Nhap du lieu can gui: ");
                String duLieu = sc.nextLine();                
                
                // gui toi server
                out.println(duLieu);
                //xoa bo nho dem
                out.flush();
                
                //tao bien nhan du lieu tu server
                String ketQua = read.readLine();
                
                // thong bao du lieu nhan duoc tu server
                System.out.println("Server: " + ketQua);                                             
                 
                //dong cac doi tuong
                read.close();
                out.close();
                socket.close();
                }
                
            }
            
        
        catch(Exception e){           
            System.out.println("server chưa được bật kìa bật server rồi runfile lại client nhé !!!");  
           
        }
        
        
       
    }
    
}

