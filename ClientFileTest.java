import java.io.*;
import java.net.*;

public class Client implements Runnable {

BufferedReader br1, br2;
PrintWriter pr1;
Socket socket;
Thread t1, t2;
String in = "", out = "";
public final static int SOCKET_PORT = 13267;      // change this accordingly
  public final static String SERVER = "localhost";  // use whatever server you want
  public final static String
       FILE_TO_RECEIVED = "d:/progrin/file/downloaded.txt";  // change this accordingly

  public final static int FILE_SIZE = 6022386;
  
public Client() {
    try {
        t1 = new Thread(this);
        t2 = new Thread(this);
        socket = new Socket(SERVER, SOCKET_PORT);
        t1.start();;
        t2.start();

    } catch (Exception e) {
    }
}

public void run() {
	int bytesRead;
    int current = 0;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
    Socket sock = null;

    try {
        if (Thread.currentThread() == t2) {
            do {
                br1 = new BufferedReader(new InputStreamReader(System.in));
                pr1 = new PrintWriter(socket.getOutputStream(), true);
                in = br1.readLine();
                pr1.println(in);
            } while (!in.equals("END"));
        } else {
            
                /*br2 = new BufferedReader(new   InputStreamReader(socket.getInputStream()));
                out = br2.readLine();
                System.out.println("Server says : " + out);*/
				// receive file
				  byte [] mybytearray  = new byte [FILE_SIZE];
				  InputStream is = sock.getInputStream();
				  fos = new FileOutputStream(FILE_TO_RECEIVED);
				  bos = new BufferedOutputStream(fos);
				  bytesRead = is.read(mybytearray,0,mybytearray.length);
				  current = bytesRead;

				  do {
					 bytesRead =
						is.read(mybytearray, current, (mybytearray.length-current));
					 if(bytesRead >= 0) current += bytesRead;
				  } while(bytesRead > -1);

				  bos.write(mybytearray, 0 , current);
				  bos.flush();
				  System.out.println("File " + FILE_TO_RECEIVED
					  + " downloaded (" + current + " bytes read)");
            
        }
    } catch (Exception e) {
    }

 }

 public static void main(String[] args) {
     new Client();
 }
 }
 
 
