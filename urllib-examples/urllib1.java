import java.net.*;
import java.io.*;
import java.util.*;

public class urllib1
{
/*  public static void main (String[] url) 
  {
        try {
            URL url = new URL(url);
    
            BufferedReader in = 
                new BufferedReader(new InputStreamReader(url.openStream()));
            String str;

            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }

            in.close();
        } 
        catch (MalformedURLException e) {} 
        catch (IOException e) {}
    }*/

  public static void main(String[] args) 
  {
    URL url;
    InputStream is = null;
    BufferedReader br;
    String line;
    try 
    {
      // url = new URL("https://yadhumylife.wordpress.com/");
      url = new URL("http://google.co.in/");
      is = url.openStream(); 
      br = new BufferedReader(new InputStreamReader(is));
           
      while ((line = br.readLine()) != null) 
      {
        System.out.println(line);
      }
    } 
    catch (MalformedURLException e) 
    {
      e.printStackTrace();
    }
    catch (IOException e) 
    {
      e.printStackTrace();
    }
  }
}
