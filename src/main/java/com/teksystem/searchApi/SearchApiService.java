package com.teksystem.searchApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;




public class SearchApiService {

    //BaseUrl
    String baseRequestUrl="https://itunes.apple.com/search?";
    ItuneSearchResponse apiResponse =null;
    
    public ItuneSearchResponse searchApi(String term, String country, String media, String limit) throws  IOException{
        List<NameValuePair> params = new LinkedList<NameValuePair>();
        String requestUrl=baseRequestUrl;
        apiResponse = new ItuneSearchResponse();
        
        //Check If the passed values are not Null or Empty
        
        if (!StringUtils.isBlank(term)){
            params.add(new BasicNameValuePair("term", term));
        }else{
            System.out.println("Require parameter is not passed exit the method");
            apiResponse.setStatusCode(400);
            return apiResponse;
           
        }

        if (!StringUtils.isBlank(country)){
            params.add(new BasicNameValuePair("country", country));
        }
       
        
        if (!StringUtils.isBlank(media)){
            params.add(new BasicNameValuePair("media", media));
        }

        if (!StringUtils.isBlank(limit)){
            params.add(new BasicNameValuePair("limit", limit));
        }


        String paramString = URLEncodedUtils.format(params, "utf-8");

        requestUrl += paramString;
        
        System.out.println("The requestUrl is: " +requestUrl);
        
        URL obj = new URL(requestUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        int responseCode = con.getResponseCode();
        System.out.println(responseCode);
        
        apiResponse.setStatusCode(responseCode);
        if(responseCode==200){
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        //print result
        JSONObject json = new JSONObject(response.toString());
        int count=  (Integer) json.get("resultCount");
        
        apiResponse.setResultCount(count);
        
        System.out.println("the vlaue of result count is " + count);
        
        JSONArray resultArray = (JSONArray) json.get("results");
        apiResponse.setResultArray(resultArray.toString());
        
        System.out.println(" the result array is "+ resultArray);
        System.out.println("the vlaue of result count is " + count);
        in.close();
        }
        return apiResponse;
    }
}
