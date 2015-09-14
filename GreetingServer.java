import java.net.*;
import java.io.*;

public class GreetingServer extends Thread
{
   private ServerSocket serverSocket;
   
   public GreetingServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(10000);
   }

   public void run()
   {
      
         try
         {
            System.out.println("Waiting for client on port " +
            serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            System.out.println("Just connected to "
                  + server.getRemoteSocketAddress());
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String message = in.readLine();
			System.out.println("message recieve : " + message);
			//in.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
         }catch(IOException e)
         {
            e.printStackTrace();
         }
      }
   public static void main(String [] args)
   {
      int port = Integer.parseInt(args[0]);
      try
      {
         Thread t = new GreetingServer(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}



