import java.io.FileReader;
import java.util.Iterator;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DailyDataPoints
{
  Double apparentTemperatureMax;
  long apparentTemperatureMaxTime;
  Double apparentTemperatureMin;
  long apparentTemperatureMinTime;
  Double cloudCover;
  Double dewPoint;
  Double humidity;
  String icon;
  Double moonPhase;
  Double ozone;
  Double precipIntensity;
  Double precipIntensityMax;
  long precipIntensityMaxTime;
  Double precipProbability;
  String precipType;
  Double pressure;
  String summary;
  long sunriseTime;
  long sunsetTime;
  Double temperatureMax;
  long temperatureMaxTime;
  Double temperatureMin;
  long temperatureMinTime;
  long time;
  long windBearing;
  Double windSpeed;

  public void read(JSONObject jObject) 
  {
    try
    {
        time = (long) jObject.get("time");

        summary = (String) jObject.get("summary");

        icon = (String) jObject.get("icon");

        precipIntensity = (Double) jObject.get("precipIntensity");

        precipIntensityMax = (Double) jObject.get("precipIntensityMax");

        precipIntensityMaxTime = (long) jObject.get("precipIntensityMaxTime");

        precipProbability = (Double) jObject.get("precipProbability");

        precipType = (String) jObject.get("precipType");

        temperatureMax = (Double) jObject.get("temperatureMax");

        temperatureMaxTime = (long) jObject.get("temperatureMaxTime");

        temperatureMin = (Double) jObject.get("temperatureMin");

        temperatureMinTime = (long) jObject.get("temperatureMinTime");

        apparentTemperatureMax = (Double) jObject.get("apparentTemperatureMax");

        apparentTemperatureMaxTime = (long) jObject.get("apparentTemperatureMaxTime");

        apparentTemperatureMin = (Double) jObject.get("apparentTemperatureMin");

        apparentTemperatureMinTime = (long) jObject.get("apparentTemperatureMinTime");

        dewPoint = (Double) jObject.get("dewPoint");

        humidity = (Double) jObject.get("humidity");

        windSpeed = (Double) jObject.get("windSpeed");

        windBearing = (long) jObject.get("windBearing");

        cloudCover = (Double) jObject.get("cloudCover");

        pressure = (Double) jObject.get("pressure");

        ozone = (Double) jObject.get("ozone");
   
        moonPhase = (Double) jObject.get("moonPhase");

        sunriseTime = (long) jObject.get("sunriseTime");

        sunsetTime = (long) jObject.get("sunsetTime");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void print()
  {
    Date date = new Date(time * 1000L);
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    sd.setTimeZone(TimeZone.getTimeZone("GMT"));
    String ourtime = sd.format(date);

    System.out.print(ourtime + ", ");
    
    System.out.print(summary + ", ");

    System.out.print(icon  + ", ");

    System.out.print(precipIntensity + ", ");

    System.out.print(precipIntensityMax + ", ");

    System.out.print(precipIntensityMaxTime + ", ");

    System.out.print(precipProbability + ", ");

    System.out.print(precipType + ", ");

    System.out.print(temperatureMax + ", ");

    System.out.print(temperatureMaxTime + ", ");

    System.out.print(temperatureMin + ", ");

    System.out.print(temperatureMinTime + ", ");

    System.out.print(apparentTemperatureMax + ", ");

    System.out.print(apparentTemperatureMaxTime + ", ");

    System.out.print(apparentTemperatureMin + ", ");

    System.out.print(apparentTemperatureMinTime + ", ");

    System.out.print(dewPoint + ", ");

    System.out.print(humidity + ", ");

    System.out.print(windSpeed + ", ");

    System.out.print(windBearing + ", ");
    
    System.out.print(cloudCover + ", ");

    System.out.print(pressure + ", ");

    System.out.print(ozone + ", ");
 
    System.out.print(moonPhase + ", ");

    System.out.print(sunriseTime + ", ");

    System.out.println(sunsetTime);
  }
}
