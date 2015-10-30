import java.io.FileReader;
import java.util.Iterator;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataPoints
{
  long time;
  String summary;
  String icon;
  long precipIntensity;
  long precipProbability;
  Double temperature;
  Double apparentTemperature;
  Double dewPoint;
  Double humidity;
  Double windSpeed;
  long windBearing;
  Double cloudCover;
  Double pressure;
  Double ozone;

  public void read(JSONObject jsonObject)
  {
    try
    {
      time = (long) jsonObject.get("time");

      summary = (String) jsonObject.get("summary");

      icon = (String) jsonObject.get("icon");

      precipIntensity = (long) jsonObject.get("precipIntensity");

      precipProbability = (long) jsonObject.get("precipProbability");
  
      temperature = (Double) jsonObject.get("temperature");

      apparentTemperature = (Double) jsonObject.get("apparentTemperature");

      dewPoint = (Double) jsonObject.get("dewPoint");

      humidity = (Double) jsonObject.get("humidity");

      windSpeed = (Double) jsonObject.get("windSpeed");

      windBearing = (long) jsonObject.get("windBearing");

      cloudCover = (Double) jsonObject.get("cloudCover");

      pressure = (Double) jsonObject.get("pressure");

      ozone = (Double) jsonObject.get("ozone");
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

    System.out.print(precipIntensity + ",");

    System.out.print(precipProbability+ ",");

    System.out.print(temperature + ", ");

    System.out.print(apparentTemperature + ", ");

    System.out.print(dewPoint + ", ");

    System.out.print(humidity + ", ");

    System.out.print(windSpeed + ", ");

    System.out.print(windBearing + ", ");

    System.out.print(cloudCover + ", ");

    System.out.print(pressure + ", ");

    System.out.println(ozone);
  }
}
