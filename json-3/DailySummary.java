import java.io.FileReader;
import java.util.Iterator;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DailySummary
{
  long time;
  String summary;
  Double temperatureMax;
  Double temperatureMin;
  Double apparentTemperatureMax;
  Double apparentTemperatureMin;

  public void read(JSONObject jsonObject)
  {
    try
    {
      time = (long) jsonObject.get("time");
      summary = (String) jsonObject.get("summary");
      temperatureMax = (Double) jsonObject.get("temperatureMax");
      temperatureMin = (Double) jsonObject.get("temperatureMin");
      apparentTemperatureMax = (Double) jsonObject.get("apparentTemperatureMax");
      apparentTemperatureMin = (Double) jsonObject.get("apparentTemperatureMin");
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
    System.out.println("Time: " + ourtime);
   
    System.out.println("   Summary: " + summary);
   
    System.out.println("   Temperature Max: " + temperatureMax);
    
    System.out.println("   Temperature Min: " + temperatureMin);
   
    System.out.println("   Apparent TemperatureMax: " + apparentTemperatureMax);
  
    System.out.println("   Apparent TemperatureMin: " + apparentTemperatureMin + "\n");
  }
}
