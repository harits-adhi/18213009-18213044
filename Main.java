import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* Created by combining code from many source by 
 * Harits Adhi Pradhana(18213009) and Andika Fikrisyah Yasin(18213044)
 */

public class Main {
	
	private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
   public static void main(String[] args) throws Exception {
	  Document doc = Jsoup.connect("http://google.com/").get();
	  Elements links = doc.select("a[href]");
	  //creating the file
	  File fl = new File("D:/progrin/crawler/tmp/input.html"); //change it according to your needs
      FileWriter ye = new FileWriter(fl);
	  //write the web page to the file
      ye.write(doc.body().toString());
      ye.flush();
      ye.close();
	  print("\nLinks: (%d)", links.size());
      for (Element link : links) {
          print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
      }
      for (Element link : links) { 
    	  doc = Jsoup.connect(link.attr("abs:href")).timeout(30000).ignoreContentType(true).ignoreHttpErrors(true).followRedirects(true).get();
    	  fl = new File("D:/progrin/crawler/tmp/"+trim(link.text(), 35)+".html"); //change it according to your needs
    	  ye = new FileWriter(fl);
    	  ye.write(doc.body().toString());
    	  ye.flush();
    	  ye.close();
      }
      
   }
}