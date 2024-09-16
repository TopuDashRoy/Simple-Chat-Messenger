import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;


import gnu.io.NRSerialPort;
import java.io.DataOutputStream;
/**
 *
 * @author Topu Dash Roy
 */

class serverMessage
{
    serverMessage()
    {
        try
        {
            ServerSocket server=new ServerSocket(3000);
            Socket socket=new Socket();
            
            System.out.println("Server Computer waiting for connect with Client Computer");
            
            socket=server.accept();
            
            System.out.println("Client Computer  Connected  with Server Computer");
            
            DataInputStream obDIP=new DataInputStream(socket.getInputStream());
            
            
            NRSerialPort obNRSerial = new NRSerialPort("COM15",9600);
            obNRSerial.connect();
        
            DataOutputStream  obDOP2=new DataOutputStream(obNRSerial.getOutputStream());
            
            while(true)
           {
               String str;
               str = obDIP.readUTF();
               System.out.println(str);
               if(str.equals("ON"))
               {
                   
                   obDOP2.write('H');
                  
               }
               else if(str.equals("OFF"))
               {
                   obDOP2.write('L');
               }
               System.out.println(str);
              
             }
            
            
            
        }catch (Exception obE) 
        {
           System.out.println("Error");
        }
    }
}




class serverComputer 
{
    public static void main(String args[])
    {
        serverMessage ob=new serverMessage();
    }
}
