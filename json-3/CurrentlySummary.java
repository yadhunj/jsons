import java.io.FileReader;
import java.util.Iterator;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CurrentlySummary
{
  long time;
  String summary;
  Double temperature;
  Double apparentTemperature;

  public void read(JSONObject jsonObject)
  {
    try
    {
      time = (long) jsonObject.get("time");
      summary = (String) jsonObject.get("summary");
      temperature = (Double) jsonObject.get("temperature");
      apparentTemperature = (Double) jsonObject.get("apparentTemperature");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    } 
  }

  public void print()
  {
    Date date = new Date(time*1000L);
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    sd.setTimeZone(TimeZone.getTimeZone("GMT"));
    String ourtime = sd.format(date);
   
    System.out.println("1) Time: " + ourtime);

    System.out.println("   Summary: " + summary);

    System.out.println("   Temperature: " + temperature);
    
    System.out.println("   Apparent Temperature: " + apparentTemperature);
  }
}
