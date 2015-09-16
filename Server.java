import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public final static int SOCKET_PORT = 13267;  // you may change this
  public final static String FILE_TO_SEND_1 = "d:/progrin/file/a.txt";  // you may change this
  public final static String FILE_TO_SEND_2 = "d:/progrin/file/b.txt";
  public final static String FILE_TO_SEND_3 = "d:/progrin/file/c.txt";

  public static void main (String [] args ) throws IOException {
	BufferedReader br1, br2;
	PrintWriter pr1;
	String pgn = "List of files : \n 1. a.txt\n 2. b.txt\n 3. c.txt\n";
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    OutputStream os = null;
    ServerSocket servsock = null;
    Socket sock = null;
    try {
      servsock = new ServerSocket(SOCKET_PORT);
      while (true) {
        System.out.println("Waiting...");
        try {
          sock = servsock.accept();
          System.out.println("Accepted connection : " + sock);
		  br1 = new BufferedReader(new InputStreamReader(System.in));
          pr1 = new PrintWriter(sock.getOutputStream(), true);
          pr1.println(pgn);
		  System.out.println("List of files : \n 1. a.txt\n 2. b.txt\n 3. c.txt\n");
		  BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		  String message = in.readLine();
		  System.out.println("message recieve : " + message);
		  if(message.equals("1")) {
			  // send file
			  File myFile = new File (FILE_TO_SEND_1);
			  byte [] mybytearray  = new byte [(int)myFile.length()];
			  fis = new FileInputStream(myFile);
			  bis = new BufferedInputStream(fis);
			  bis.read(mybytearray,0,mybytearray.length);
			  os = sock.getOutputStream();
			  System.out.println("Sending " + FILE_TO_SEND_1 + "(" + mybytearray.length + " bytes)");
			  os.write(mybytearray,0,mybytearray.length);
			  os.flush();
			  System.out.println("Done.");
		  }
		  else if(message.equals("2")) {
			  // send file
			  File myFile = new File (FILE_TO_SEND_2);
			  byte [] mybytearray  = new byte [(int)myFile.length()];
			  fis = new FileInputStream(myFile);
			  bis = new BufferedInputStream(fis);
			  bis.read(mybytearray,0,mybytearray.length);
			  os = sock.getOutputStream();
			  System.out.println("Sending " + FILE_TO_SEND_2 + "(" + mybytearray.length + " bytes)");
			  os.write(mybytearray,0,mybytearray.length);
			  os.flush();
			  System.out.println("Done.");
		  }
		  else if(message.equals("3")) {
			  // send file
			  File myFile = new File (FILE_TO_SEND_3);
			  byte [] mybytearray  = new byte [(int)myFile.length()];
			  fis = new FileInputStream(myFile);
			  bis = new BufferedInputStream(fis);
			  bis.read(mybytearray,0,mybytearray.length);
			  os = sock.getOutputStream();
			  System.out.println("Sending " + FILE_TO_SEND_3 + "(" + mybytearray.length + " bytes)");
			  os.write(mybytearray,0,mybytearray.length);
			  os.flush();
			  System.out.println("Done.");
		  }
        }
        finally {
          if (bis != null) bis.close();
          if (os != null) os.close();
          if (sock!=null) sock.close();
        }
      }
    }
    finally {
      if (servsock != null) servsock.close();
    }
  }
}