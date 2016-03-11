package com.teksystem.searchApi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SearchApiNegativeTest {
    SearchApiService serviceApi;

    @Before
    public void setup() {
        serviceApi = new SearchApiService();
    }

    @Test
    public void searchItunes_BadRequest() throws ClientProtocolException, IOException {
        Assert.assertEquals(400, serviceApi.searchApi("", "", "", "").getStatusCode());
    }
 
    @Test
    public void searchItunes_InValidTerm() throws ClientProtocolException, IOException {
        Assert.assertEquals(0, serviceApi.searchApi("xvyt ", "", "", "").getResultCount());
    }

    @Test
    public void searchItunes_InValidCountryCode() throws ClientProtocolException, IOException{
       Assert.assertEquals(400, serviceApi.searchApi("Alex","XYZ","music","20").getStatusCode()); 
    }


    @Test
    public void searchItunes_InValidMedia() throws ClientProtocolException, IOException{
       Assert.assertEquals(400, serviceApi.searchApi("Alex","","sss","20").getStatusCode()); 
    }
    
    // Below two test cases as per requirements should be expecting bad request as the count
    //   is of invalid format and size is more than permissible value
    
    @Test
    public void searchItunes_InValidCountFormat() throws ClientProtocolException, IOException{
       Assert.assertEquals(400, serviceApi.searchApi("Alex","","music","xyz").getStatusCode()); 
    }
    
    @Test
    public void searchItunes_InValidCountSize() throws ClientProtocolException, IOException{
       Assert.assertEquals(400, serviceApi.searchApi("Alex","","music","500").getStatusCode()); 
    }
    
}
