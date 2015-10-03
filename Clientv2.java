Pemberian Tugas : 15 September 2015

import java.io.*;
import java.net.*;

class Client{
    public static void main(String argv[]) throws Exception
 {
  boolean isExit = false;
  Socket clientSocket = new Socket("localhost", 13267);
  String sentence;
  String modifiedSentence;
  System.out.println("List of files : \n 1. a.txt\n 2. b.txt\n 3. c.txt\n");

  
  while(!(isExit)) 
   {  
  BufferedReader inFromUser = new BufferedReader(
     new InputStreamReader(System.in));
  DataOutputStream outToServer = new DataOutputStream(
     clientSocket.getOutputStream());
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	 
  sentence = inFromUser.readLine();
  outToServer.writeBytes(sentence+"\n");
  modifiedSentence = inFromServer.readLine();
  System.out.println("FROM SERVER: File has been downloaded"); 
	if(sentence.equals("1")){
	byte[] mybytearray = new byte[1024];
    InputStream is = clientSocket.getInputStream();
    FileOutputStream fos = new FileOutputStream("fileSent1.txt");// nama file yg diterima dari server pada client
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    int bytesRead = is.read(mybytearray, 0, mybytearray.length);
    bos.write(mybytearray, 0, bytesRead);
    bos.close();
	sentence = "0";
	
	}
	else if(sentence.equals("2")){
		byte[] mybytearray = new byte[1024];
		InputStream is = clientSocket.getInputStream();
		FileOutputStream fos = new FileOutputStream("fileSent2.txt");// nama file yang diterima dari server pada client
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int bytesRead = is.read(mybytearray, 0, mybytearray.length);
		bos.write(mybytearray, 0, bytesRead);
		bos.close();
		sentence = "0";
	}
	else if(sentence.equals("3")){
		byte[] mybytearray = new byte[1024];
		InputStream is = clientSocket.getInputStream();
		FileOutputStream fos = new FileOutputStream("fileSent3.txt");// nama file yang diterima dari server pada client
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int bytesRead = is.read(mybytearray, 0, mybytearray.length);
		bos.write(mybytearray, 0, bytesRead);
		bos.close();
		sentence = "0";
	}
	}
  clientSocket.close();
 }
}
