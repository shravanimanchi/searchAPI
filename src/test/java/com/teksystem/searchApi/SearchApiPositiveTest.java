package com.teksystem.searchApi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SearchApiPositiveTest {
    SearchApiService serviceApi;
    
    @Before
    public void setup(){
        serviceApi = new SearchApiService();
    }
    
    
    @Test
    public void searchItunes_SuccecssStatusCode() throws ClientProtocolException, IOException{
       Assert.assertEquals(200, serviceApi.searchApi("John ","","","").getStatusCode()); 
    }
    
    @Test
    public void searchItunes_ResultcountDefault() throws ClientProtocolException, IOException{
       Assert.assertEquals(50, serviceApi.searchApi("John ","","movie","").getResultCount()); 
    }
    
    
    @Test
    public void searchItunes_SpecfiedResultCount() throws ClientProtocolException, IOException{
       Assert.assertEquals(5, serviceApi.searchApi("Alex","","music","5").getResultCount()); 
    }
    
     
    
    @Test
    public void searchItunes_SpecfiedCountry() throws ClientProtocolException, IOException{
       Assert.assertEquals(5, serviceApi.searchApi("Mark","FR","","5").getResultCount()); 
    }
     
    /**
     * 
     * We should be writing multiple test cases for asserting to Country and media to make sure if the result set
     * matches the request parameters.
     * This is extendible using the test properties files
     * 
     */
   
    @Test
    public void searchItunes_SpecfiedResultCountUS() throws ClientProtocolException, IOException{
       Assert.assertEquals(20, serviceApi.searchApi("Alex","US","music","20").getResultCount()); 
    }
    
  
    @Test
    public void searchItunes_SpecfiedResultCountUK() throws ClientProtocolException, IOException{
       Assert.assertEquals(20, serviceApi.searchApi("Alex","GB","music","20").getResultCount()); 
    }
    
    
    @Test
    public void searchItunes_SpecfiedResultCountry() throws ClientProtocolException, IOException{
       Assert.assertEquals(200, serviceApi.searchApi("Alex","US","music","20").getStatusCode()); 
    }
    
    
}
