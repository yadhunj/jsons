import java.net.*;
import java.io.*;

public class urllib 
{
  public static void main (String[] args) throws IOException 
  {
    try
    {
    //  URL url = new URL("http://yadhumylife.wordpress.com/");
      URL url = new URL("http://google.co.in/");
      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
      String str;

      while ((str = in.readLine()) != null) 
      {
        System.out.println(str);
      }
      in.close();
    } 
    catch (MalformedURLException e) {} 
    catch (IOException e) {}
  }
}
