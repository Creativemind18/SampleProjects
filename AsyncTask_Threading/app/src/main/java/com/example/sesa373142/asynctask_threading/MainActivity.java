package com.example.sesa373142.asynctask_threading;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mImageView = (ImageView) findViewById(R.id.imageView);


    }

    public void downloadImage(View view) {

        /*MyTask myTask = new MyTask(MainActivity.this,mImageView);
        myTask.execute("https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwidnquoyZrfAhXMbisKHZWPBeYQjRx6BAgBEAU&url=https%3A%2F%2Fwww.gettyimages.ie%2F&psig=AOvVaw1lmb69O-EZBIx0-dxUdmvc&ust=1544713755894565");//"http://www.w3schools.com/css/trolltunga.jpg");
        */

        Karthik getusercount = new Karthik();
        getusercount.execute("1");
    }


    class Karthik extends AsyncTask<String,Void,String>
    {

        String add_info_url;
        private String Json_String;
        private ProgressDialog progress;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            add_info_url = "http://karthik.test89.com/testfile.php";//"http://karthik.test89.com/add_info.php";
        }

        @Override
        protected String doInBackground(String... args) {
            String Request;
            String data="";

            Request = args[0];
            try {
                URL url = new URL(add_info_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));



                data = URLEncoder.encode("Request", "UTF-8") + "=" + URLEncoder.encode(Request, "UTF-8");



                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                ///////////////////////////////////////////////////////////////////////////////////////////////////////
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((Json_String = bufferedReader.readLine()) != null) {
                    stringBuilder.append(Json_String + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                //IS.close();
                //httpURLConnection.disconnect();
                //return "One row of data inserted ...";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }



        @Override
        protected void onPostExecute(final String result) {

             Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();



                }
            };









}
