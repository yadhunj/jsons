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
  String icon;
  Double temperatureMax;
  Double temperatureMin;
  String precipType;
  Double apparentTemperatureMax;
  Double apparentTemperatureMin;
  Double pressure;

  public void read(JSONObject jsonObject)
  {
    try
    {
      time = (long) jsonObject.get("time");
      summary = (String) jsonObject.get("summary");
      icon = (String) jsonObject.get("icon");
      temperatureMax = (Double) jsonObject.get("temperatureMax");
      temperatureMin = (Double) jsonObject.get("temperatureMin");
      precipType = (String) jsonObject.get("precipType");
      apparentTemperatureMax = (Double) jsonObject.get("apparentTemperatureMax");
      apparentTemperatureMin = (Double) jsonObject.get("apparentTemperatureMin");
      pressure = (Double) jsonObject.get("pressure");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
 
  public void print()
  {
    Date date = new Date(time*1000L);
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    sd.setTimeZone(TimeZone.getTimeZone("GMT"));
    String ourtime = sd.format(date);
    System.out.print(ourtime + ", ");
   
    System.out.print(summary + ", ");
   
    System.out.print(icon + ", ");
   
    System.out.print(temperatureMax + ", ");
    
    System.out.print(temperatureMin + ", ");
   
    System.out.print(precipType + ", ");
   
    System.out.print(apparentTemperatureMax + ", ");
  
    System.out.print(apparentTemperatureMin + ", ");
  
    System.out.println(pressure);
  }
}
