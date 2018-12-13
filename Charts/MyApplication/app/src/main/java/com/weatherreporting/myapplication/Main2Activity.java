package com.weatherreporting.myapplication;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    public String loginResult;
    MyOpenHelper mMyOpenHelper;
    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mMyOpenHelper = new MyOpenHelper(Main2Activity.this, "userDB", null, 1);
        mDB = mMyOpenHelper.getWritableDatabase();

        Location = (TextView)findViewById(R.id.Location);
        weatherData = (TextView)findViewById(R.id.weatheData);
        //cloudData = (TextView)findViewById(R.id.cloudData);
        //weatherData1 = (TextView)findViewById(R.id.weatheData1);

        setTime();
        Intent extras = getIntent();

        if (extras != null)
        {
            recArray = extras.getIntArrayExtra("ResultArray");
            UpsArray = extras.getStringArrayExtra("UpsArray");
            strTemp = extras.getStringExtra("value");
            if(strTemp == null)
            {
                strTemp = "0";
            }
        }

        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAB0B")));
        this.setTitle("Manual mode");

        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        //mDisaply = (TextView)findViewById(R.id.handleId);
        mDisaply1 = (TextView)findViewById(R.id.last_tweet);

        mDisaply1.setText("Scheduled Power Cut Timings @ Current Location :" +"\n"+"From: "+formattedDate+"\t\t"+formattedTime+"\n"+"To: "+formattedDate+"\t\t"+String.valueOf(hour)+":"+String.valueOf(min)+":"+String.valueOf(sec)+"\n"+"Duration: 3 Hrs");//http://www.bescom.org/lcr_new/



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Function.placeIdTask asyncTask =new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                String str = weather_city +"\t\t\t\t\t\t\t\t\t\t\t\t\t\t" +weather_temperature+"C"+"\n"+weather_description+"\t\t\t\t\t\t\t\t\t\t\t"+"31"+"/" +weather_temperature+"C";
                Location.setText(weather_city+"\n"+weather_description);
                weatherData.setText(weather_temperature+"C"+"\n"+"31"+"/" +weather_temperature+"C");
                //cloudData.setText(weather_description);
                //mDisaply.setText(str);
                // mDisaply1.setText(weather_temperature+"C");
                //mDisaply.setText(weather_description);
            }
        });
        asyncTask.execute("12.9716", "77.5946"); //  asyncTask.execute("Latitude", "Longitude")*/
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public void onSignoutClick(View view) {
        mDB.execSQL("delete from userData where _id=1");
        finish();
        Intent loginActivity = new Intent(this,GraphActivity.class);
        startActivity(loginActivity);
    }


    String str="";
    private TextView mDisaply,mDisaply1,mDisaply2;
    String strTemp="0";
    private Calendar calander;
    private SimpleDateFormat simpledateformat;
    String formattedDate,formattedTime;
    int hour=0,min=0,sec=0;
    private TextView Location,weatherData,weatherData1,cloudData;
    int[] recArray={0,0,0,0,0,0};

    String[] UpsArray = {"","","","",""};

    public void setTime()
    {
        calander = Calendar.getInstance();
        hour = calander.get(calander.HOUR_OF_DAY);
        min = calander.get(calander.MINUTE);
        sec = calander.get(calander.SECOND);
        if((hour+3)>24)
        {
            hour=(hour+3)-24;
        }
        else {
            hour+=3;
        }

        //simpledateformat = new SimpleDateFormat("HH:mm:ss:SSS");
        simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
        formattedDate = simpledateformat.format(calander.getTime());
        simpledateformat = new SimpleDateFormat("HH:mm:ss");
        formattedTime = simpledateformat.format(calander.getTime());
        //Toast.makeText(this,formattedDate,Toast.LENGTH_SHORT).show();

    }

    public void callReport(View view) {
        /*Intent intent = new Intent(HomeAutoMain.this, ReportActivity.class);
        HomeAutoMain.this.startActivity(intent);*/

    }

    public void callLivingRoom(View view) {

        //finish();
        /*Intent intent1 = new Intent(HomeAutoMain.this,RoomControlActivity.class);

        if(strTemp.equals("from_Notif_Page"))
            intent1.putExtra("value","10");

        startActivity(intent1);*/
    }

    public void callMasterBedRoom(View view) {

        //finish();
        /*Intent intent1 = new Intent(HomeAutoMain.this,BedRoomSwitches.class);
        if(strTemp.equals("from_Notif_Page"))
            intent1.putExtra("value","20");

        startActivity(intent1);*/
    }

    public void callBedRoom(View view) {
        //finish();
        /*Intent intent1 = new Intent(HomeAutoMain.this,SingleLight.class);

        if(strTemp.equals("from_Notif_Page"))
            intent1.putExtra("value","30");
        else
            intent1.putExtra("value","1");

        startActivity(intent1);*/

    }

    public void callKitchen(View view) {
        Intent loginActivity = new Intent(this,GraphActivity.class);
        startActivity(loginActivity);
        //finish();
        /*Intent intent1 = new Intent(HomeAutoMain.this,SingleLight.class);
        if(strTemp.equals("from_Notif_Page"))
            intent1.putExtra("value","40");
        else
            intent1.putExtra("value","2");

        startActivity(intent1);*/
    }
}


