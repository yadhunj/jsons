// This program parses a json file that has information about the weather
// conditions of a place and saves them in data structures and prints them
// using the print methods.

import java.io.FileReader;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
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
      String fPath = "/home/yadhunj/jsons/json-3/tw.json";
      JSONObject jot = fileInitialize(fPath);
      
      // Get location information
      // processLocation(jot);

      // Get current weather condition
      // processCurrently(jot);
 
      // Get hourly weather condition
      // processHourly(jot);
    
      // Get daily weather condition
      // processDaily(jot);

      // Get Currently Summary
      SummaryCurrently(jot);   
  
      // Get Hourly Summary
      SummaryHourly(jot);
  
      // Get Daily Summary
      SummaryDaily(jot);
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

  static void processLocation(JSONObject jObjt)
  {
    LocationInfo locinf =new LocationInfo();
    locinf.read(jObjt);
    locinf.print(); 
  }

  static void processCurrently(JSONObject jObjt)
  {
    JSONObject currently = (JSONObject) jObjt.get("currently");
    DataPoints dPoints = new DataPoints();
    dPoints.read(currently);
    dPoints.print();
  }
  
  static void processHourly(JSONObject jObjt)
  {
    JSONObject hourly = (JSONObject) jObjt.get("hourly");
    ArrayList hpt;
    hpt =  readHourlyData(hourly);
    printHourlyData(hpt);
  }

  static void processDaily(JSONObject jObjt)
  {
    JSONObject daily = (JSONObject) jObjt.get("daily");
    ArrayList dpt;
    dpt = readDailyData(daily);
    printDailyData(dpt);
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
   
  static void printHourlyData(ArrayList hpt)
  {
    for(int k = 0; k < hpt.size(); k++)
    {
      HourlyDataPoints hPoints;
      hPoints = (HourlyDataPoints) hpt.get(k);
      hPoints.print();
    }
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
 
  static void printDailyData(ArrayList dpt)
  {
    for(int l = 0; l < dpt.size(); l++)
    {
      DailyDataPoints dPoints;
      dPoints = (DailyDataPoints) dpt.get(l);
      dPoints.print();
    }
  }

  static void SummaryCurrently(JSONObject jObjt)
  {
    System.out.println("CURRENTLY SUMMARY:");
    JSONObject currently = (JSONObject) jObjt.get("currently");
    CurrentlySummary cSummary = new CurrentlySummary();
    cSummary.read(currently);
    cSummary.print();
  }

  static void SummaryHourly(JSONObject jObjt)
  {
    JSONObject hourly = (JSONObject) jObjt.get("hourly");
    HourlyDataSummary(hourly);
  }

  static void HourlyDataSummary(JSONObject jObject)
  {
    System.out.println("HOURLY SUMMARY:");
    JSONArray hourlydata = (JSONArray) jObject.get("data");
    Iterator i = hourlydata.iterator();
    while (i.hasNext())
    {
      JSONObject jObjt = (JSONObject) i.next();
      HourlySummary hSummary = new HourlySummary();
      hSummary.read(jObjt);
      hSummary.print();
    }
  }
  
  static void SummaryDaily(JSONObject jObjt)
  {
    JSONObject daily = (JSONObject) jObjt.get("daily");
    DailyDataSummary(daily);
  }

  static void DailyDataSummary(JSONObject jObject)
  {
    System.out.println("DAILY SUMMARY:");
    JSONArray Dailydata = (JSONArray) jObject.get("data");
    Iterator i = Dailydata.iterator();
    while (i.hasNext())
    {
      JSONObject jObjt = (JSONObject) i.next();
      DailySummary dSummary = new DailySummary();
      dSummary.read(jObjt);
      dSummary.print();
    }
  }
}
