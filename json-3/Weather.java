// This program parses a json file that has information about the weather
// conditions of a place and saves them in data structures and prints them
// using the print methods.

import java.io.FileReader;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class Weather
{ 
  public static void main(String[] args) 
  {
    try 
    {
      JSONObject jot = fileInitialize("/home/yadhunj/jsons/json-3/tw.json");
      
      // Get location information
      LocationInfo lio;
      lio = processLocation(jot);

      // Get current weather condition
      DataPoints dpt;
      dpt =  processCurrently(jot);
 
      // Get hourly weather condition
      ArrayList hpt;
      hpt = processHourly(jot);
    
      // Get daily weather condition
      ArrayList dDt;  
      dDt = processDaily(jot);

      // Get Weather Summary
      Scanner summary = new Scanner(System.in);
      boolean PrintSummaryMode = summary.nextBoolean();
      if(PrintSummaryMode == true)
      {
        PrintSummary(dDt,hpt,dpt,lio);
      } 
      else if(PrintSummaryMode == false)
      {
        PrintFullSummary(dDt,hpt,dpt,lio);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }      
  }

  static JSONObject fileInitialize(String path)
  {
    JSONObject jObj = new JSONObject();
    try
    {
      JSONParser parser = new JSONParser();
      FileReader file = new FileReader(path);
      jObj = (JSONObject) parser.parse(file); 
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return jObj;
  }

  static LocationInfo processLocation(JSONObject jObjt)
  {
    LocationInfo locinf =new LocationInfo();
    locinf.read(jObjt);
    return locinf; 
  }

  static DataPoints processCurrently(JSONObject jObjt)
  {
    JSONObject currently = (JSONObject) jObjt.get("currently");
    DataPoints dPoints = new DataPoints();
    dPoints.read(currently);
    return dPoints;
  }
  
  static ArrayList processHourly(JSONObject jObjt)
  {
    JSONObject hourly = (JSONObject) jObjt.get("hourly");
    ArrayList hpt;
    hpt =  readHourlyData(hourly);
    return hpt;
  }

  static ArrayList processDaily(JSONObject jObjt)
  {
    JSONObject daily = (JSONObject) jObjt.get("daily");
    ArrayList dpt;
    dpt = readDailyData(daily);
    return dpt;
  }

  static ArrayList readHourlyData(JSONObject jObject)
  {   
    ArrayList hourlist = new ArrayList();  
    JSONArray hourlydata = (JSONArray) jObject.get("data");
    Iterator i = hourlydata.iterator();
    while (i.hasNext())
    {
      JSONObject jObjt = (JSONObject) i.next();
      HourlyDataPoints hPoints = new HourlyDataPoints();
      hPoints.read(jObjt);
      hourlist.add(hPoints);
    } 
    return hourlist;
  }
   
  static ArrayList readDailyData(JSONObject jObj)
  {
    ArrayList dailylist = new ArrayList();
    JSONArray dailydata = (JSONArray) jObj.get("data");
    Iterator j = dailydata.iterator();
    while (j.hasNext())
    {
      JSONObject jObjt = (JSONObject) j.next();
      DailyDataPoints dDPoints = new DailyDataPoints();
      dDPoints.read(jObjt);
      dailylist.add(dDPoints);
    }
    return dailylist;
  } 
 
  static void PrintSummary(ArrayList dSumm, ArrayList hSumm, DataPoints dpoints, LocationInfo linfo)
  {
    long time;
    String summary;
    Double temperatureMax,temperatureMin,temperature,Temperature,TemperatureMax,TemperatureMin;

    System.out.println("Current Weather Report:\n");
    DataPoints dpoint;
    dpoint = (DataPoints) dpoints;   
   
    time = (long) dpoint.time;
    Date date = new Date(time*1000L);
    SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy HH:mm aa");
    sd.setTimeZone(TimeZone.getTimeZone("GMT"));
    String ourtime = sd.format(date);
    System.out.println("Date/Time: " + ourtime);  
     
    summary =  (String) dpoint.summary;
    System.out.println("Summary: " + summary);

    Temperature = (Double) dpoint.temperature;
    temperature = ((Temperature - 32)*5)/9;
    System.out.println("Temperature: " + temperature + " C" + " / " + Temperature + " F");
    
    System.out.println("\nWeather Report for Next 5 hours:\n");
    for(int i = 0; (i < hSumm.size()) && (i < 5); i++)
    {
      HourlyDataPoints hDSum;
      hDSum = (HourlyDataPoints) hSumm.get(i);
    
      time = (long) hDSum.time;
      Date dat = new Date(time*1000L);
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm aa");
      sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
      String ourTime = sdf.format(dat);
      System.out.println("Date/Time: " + ourTime);
     
      summary = (String) hDSum.summary;
      System.out.println("Summary: " + summary);
     
      Temperature = (Double) hDSum.temperature;
      temperature = ((Temperature - 32)*5)/9;
      System.out.println("Temperature: " + temperature + " C" + " / " + Temperature + " F\n");
    } 
    
    System.out.println("\nWeather Report for 2 Days:\n");
    for(int i = 1; (i < dSumm.size()) && (i <= 2); i++)
    {
      DailyDataPoints dDSum;
      dDSum = (DailyDataPoints) dSumm.get(i);
      
      time = (long) dDSum.time;
      Date Dat = new Date(time*1000L);
      SimpleDateFormat sdF = new SimpleDateFormat("dd-MMM-yyyy HH:mm aa");
      sdF.setTimeZone(TimeZone.getTimeZone("GMT"));
      String Ourtime = sdF.format(Dat);
      System.out.println("Date/Time: " + Ourtime);

      summary =  (String) dDSum.summary;
      System.out.println("Summary: " + summary);
  
      TemperatureMax = (Double) dDSum.temperatureMax;
      temperatureMax = ((TemperatureMax - 32)*5)/9;
      System.out.println("Temperature Max: " + temperatureMax + " C" + " / " + TemperatureMax + " F");

      TemperatureMin = (Double) dDSum.temperatureMin;
      temperatureMin = ((TemperatureMin - 32)*5)/9;
      System.out.println("Temperature Min: " + temperatureMin + " C" + " / " + TemperatureMin + " F\n");
    }
  }
  
  static void PrintFullSummary(ArrayList DSumm, ArrayList HSumm, DataPoints DPoints, LocationInfo Linfo)
  {
    System.out.println("Location Information:");
    LocationInfo locinf;
    locinf = (LocationInfo) Linfo;
    locinf.print();
 
    System.out.println("\nCurrent Weather Report:");
    DataPoints dpoints;
    dpoints = (DataPoints) DPoints; 
    dpoints.print();

    System.out.println("\nHourly Weather Report:");
    for(int k = 0; k < HSumm.size(); k++)
    {
    HourlyDataPoints hDSum;
    hDSum = (HourlyDataPoints) HSumm.get(k);
    hDSum.print();
    }

    System.out.println("\nDaily Weather Report:");
    for(int l = 0; l < DSumm.size(); l++)
    {
    DailyDataPoints dDSum;
    dDSum = (DailyDataPoints) DSumm.get(l);
    dDSum.print();  
    }
  }
}
