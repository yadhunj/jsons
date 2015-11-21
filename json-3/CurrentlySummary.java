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
  String icon;
  Double temperature;
  Double apparentTemperature;
  Double pressure;

  public void read(JSONObject jsonObject)
  {
    try
    {
      time = (long) jsonObject.get("time");
      summary = (String) jsonObject.get("summary");
      icon = (String) jsonObject.get("icon");
      temperature = (Double) jsonObject.get("temperature");
      apparentTemperature = (Double) jsonObject.get("apparentTemperature");
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
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    sd.setTimeZone(TimeZone.getTimeZone("GMT"));
    String ourtime = sd.format(date);
   
    System.out.print("Time: " + ourtime + ", ");

    System.out.print("Summary: " + summary + ", ");

    System.out.print("Icon: " + icon + ", ");

    System.out.print("Temperature: " + temperature + ", ");
    
    System.out.print("Apparent Temperature: " + apparentTemperature + ", ");
   
    System.out.println("Pressure: " + pressure);
  }
}
