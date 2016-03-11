package com.teksystem.searchApi;

public class ItuneSearchResponse {

    int statusCode;
    int resultCount;
    String resultArray;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public String getResultArray() {
        return resultArray;
    }

    public void setResultArray(String resultArray) {
        this.resultArray = resultArray;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

 

}
