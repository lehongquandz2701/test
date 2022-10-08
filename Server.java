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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    
    public static void main(String[] args) {
          // phải chạy 
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn có muốn bật server để kết nối tới client không  ?"+ "1:  Có" + " " + "2: Không" );
        int  choose = sc.nextInt();
        if(choose == 1) {
            try{
            
            // tao server socket
            ServerSocket serverSocket= new ServerSocket(6789);
            
            // server dang hoat dong
            System.out.println("Server dang hoat dong...");
            
            while(true){
                
                //tao socket
                Socket socket = serverSocket.accept();
                System.out.println("Kết nối thành công ");
                //tao 2 doi tuong de nhan va gui
                BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                
                // tao bien de nhan du lieu
                String duLieu = read.readLine();
                
                // thong bao du lieu nhan duoc tu client
                System.out.println("Client: " + duLieu);
                             
                // xu li du lieu va gui lai client
                out.println(bienDoiChuoi(duLieu));
                
                // xoa bo nho dem
                out.flush();
                
                //dong cac doi tuong
                read.close();
                out.close();
                socket.close();
            }
            
        }
        catch(Exception e){           
            System.out.println(e);            
        }
        }if (choose == 2) {
          System.out.println("Ngắt kết nối tới Client thành công " );
        }
        
    }
    
    static String bienDoiChuoi(String chuoi){
        String kq = "";
        if(chuoi.isEmpty()){
            kq = "Du lieu khong duoc de trong!";
            return kq;
        }       
        
        // xoa khoang trang 2 dau cua chuoi
      
               
        char[] charArray = chuoi.toCharArray();
        int n = 0;
        boolean check;
        
        kq+= "Do dai cua chuoi la: " + chuoi.length() + "\tSo lan xuat hien cac ki tu la: ";
        
        for(int i = 0; i < charArray.length; i++){
            check = false;
            for(int j = i - 1; j >= 0; j--){
                if(charArray[j] == charArray[i]){
                    check = true;
                    break;
                }
            }
            if(check) continue;
            n++;
            for(int j = i + 1; j < charArray.length; j++){
                if(charArray[i] == charArray[j]){
                    n++;
                }
            }
            
            kq += charArray[i] + ": " + n + ", ";                  
            n = 0;
            
        }
        
       return kq;
    }
    
}

