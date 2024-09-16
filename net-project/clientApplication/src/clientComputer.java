
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Topu Dash Roy
 */
class clientMessage
{
    clientMessage()
    {
        Scanner in =new Scanner(System.in);
        try
        {
            Socket socket=new Socket("localhost",3000);
            System.out.println("Client Computer Connected with Server Computer");
            
            
            DataOutputStream obDOP=new DataOutputStream(socket.getOutputStream());
            
            
            while(true)
            {
                String str=in.nextLine();
                if(str.equals(null))
                {
                    break;
                }
                obDOP.writeUTF(str);
                obDOP.flush();
            }
            
            
        }catch(Exception obE)
        {
            System.out.println("Error");
        }
    }
}


class clientComputer
{
    public static void main(String args[])
    {
        clientMessage obCm=new clientMessage();
    }
}