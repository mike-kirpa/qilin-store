package com.projectname.appmanager.helpers;

import io.restassured.RestAssured;
import io.restassured.filter.log.UrlDecoder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class AFile {

    /**
     This example shows how to download a file with RESTAssured
     This will download the file as binary so can be used for images, zip files etc.
     The example is coded to download a source file from github, but you can download anything.
     I sometimes use this during GUI automating to download files.
     Also I use this when interacting with sites that don't provide an API.
     */



    public String downloadUrlAsFile(String urlToDownload, String downloadFileName, String downloadFolder) throws IOException {

        // By default this is going to be a subfolder in your project, you can change this to an
        // absolute path or resources if you want to. I kept it simple for the example
        File outputPath = new File(downloadFolder);

        // create the folder structure if it does not exist
        outputPath.mkdirs();

        // if your url was extracted from a json respose in another message then you might need to decode it first
        // to make sure it is a completely valid URL e.g. doesn't have any \u0026 type values
        urlToDownload = UrlDecoder.urlDecode(urlToDownload, Charset.defaultCharset(), false);


        // Sometimes I add a timestamp to the file e.g.
        //String downloadFileName = "downloadedFile_" + System.currentTimeMillis() + "_.txt";

        // Sometimes I add a GUID to the file e.g.
        //String downloadFileName = "downloadedFile_" + UUID.randomUUID() + "_.txt";

        // the point is, control the filename so you know what you are downloading



        // For the purpose of the test, if the file already exists then I will delete it

        File checkDownloaded = new File(outputPath.getPath(), downloadFileName);
        if(checkDownloaded.exists()) {
            checkDownloaded.delete();
        }

        File outputFile = new File(outputPath.getPath(), downloadFileName);

        final Response response = RestAssured.get(urlToDownload).andReturn();

        // check if the URL actually exists
        if(response.getStatusCode() == 200){

            // I am choosing to delete the file if it already exists and write it again
            // if it already exists you might choose to return and not overwrite it
            if (outputFile.exists()) {
                outputFile.delete();
            }

            // I might choose to use the mime type of the file to control the file extension
            // here I am just outputting it to the console to demonstrate how to get the type
            System.out.println("Downloaded an " + response.getHeader("Content-Type"));

            // get the contents of the file
            byte[] fileContents = response.getBody().asByteArray();

            // output contents to file
            OutputStream outStream=null;

            try {

                outStream = new FileOutputStream(outputFile);
                outStream.write(fileContents);

            }catch(Exception e){

                System.out.println("Error writing file " + outputFile.getAbsolutePath());

            }finally {

                if(outStream!=null){
                    outStream.close();
                }
            }
        }

        // Added an assert to check if file exists
        Assert.assertTrue(outputFile.exists());
        return checkDownloaded.getAbsolutePath();
    }

    public void readJsonFromFile(String filename){
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(filename)) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);


            String name = (String) jsonObject.get("path");
            System.out.println(name);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}