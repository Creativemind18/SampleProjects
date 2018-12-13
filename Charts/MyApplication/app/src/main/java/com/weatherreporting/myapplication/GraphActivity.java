package com.weatherreporting.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.ValueFormatter;

import java.util.ArrayList;



public class GraphActivity extends AppCompatActivity {

    PieChart pieChart;
    BarChart barChart;
    View layPiechart;
    TextView chartTitle1,chartTitle2,chartTitle3,chartTitle4,chartTitle5,chartTitle6,chartTitle7;
    private static final String RANGE1 = "5am - 8am";
    private static final String RANGE2 = "8am - 10am";
    private static final String RANGE3 = "10am - 12pm";
    private static final String RANGE4 = "12pm - 3pm";
    private static final String RANGE11 = "3pm - 6pm";
    private static final String RANGE22 = "6pm - 9pm";
    private static final String RANGE33 = "9pm - 11pm";

    private static final String RANGE5 = "Empty Seats";
    private static final String RANGE6 = "Full Seats";
    private static final String RANGE7 = "Adv Book";
    private static final String RANGE8 = "Cancelled";

    private static SharedPreferences mSharedPreferences;


    private static final String LABLE_PIEDATA = "piedata";
    private static final String LABLE_BARDATA = "bardata";


    ImageView imageView4;
    TextView text_load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_graph );
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        layPiechart=findViewById(R.id.sub_lay_piechart);
        barChart=(BarChart) findViewById(R.id.bar_chart);
        pieChart=(PieChart) findViewById(R.id.pieChart_load);

        chartTitle1=(TextView)findViewById(R.id.chart_title1);
        chartTitle2=(TextView)findViewById(R.id.chart_title2);
        chartTitle3=(TextView)findViewById(R.id.chart_title3);
        chartTitle4=(TextView)findViewById(R.id.chart_title4);
        chartTitle5=(TextView)findViewById(R.id.chart_title5);
        chartTitle6=(TextView)findViewById(R.id.chart_title6);
        chartTitle7=(TextView)findViewById(R.id.chart_title7);

        imageView4=(ImageView) findViewById(R.id.imageView4);
        text_load=(TextView) findViewById(R.id.text_load);

        mSharedPreferences = getApplicationContext().getSharedPreferences(
                "twitter4j-sample", 0);

        barChart.setOnChartValueSelectedListener( new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

                int position=h.getXIndex();
                switch (position){
                    case 0:
                        Toast.makeText(GraphActivity.this,"Off-Peak hours is slected",Toast.LENGTH_SHORT).show();
                        drawPieChart(80,20,0,10);

                        if(isON("0")){
                            imageView4.setImageResource(R.drawable.alarm_w);
                            text_load.setText("Fan & light is ON!");
                        }else{
                            imageView4.setImageResource(R.drawable.okay);
                            text_load.setText("All Good!");
                        }

                        break;
                    case 1:
                        drawPieChart(10,90,30,0);
                        Toast.makeText(GraphActivity.this,"Mid-Peak hours is Selected",Toast.LENGTH_SHORT).show();

                        if(isON("2")){
                            imageView4.setImageResource(R.drawable.alarm_w);
                            text_load.setText("Light is ON!");
                        }else{
                            imageView4.setImageResource(R.drawable.okay);
                            text_load.setText("All Good!");
                        }
                        break;
                    case 2:
                        drawPieChart(0,100,70,0);
                        Toast.makeText(GraphActivity.this,"On-Peak hours is Selected",Toast.LENGTH_SHORT).show();

                        if(isON("3")){
                            imageView4.setImageResource(R.drawable.alarm_w);
                            text_load.setText("Light is ON!");
                        }else{
                            imageView4.setImageResource(R.drawable.okay);
                            text_load.setText("All Good!");
                        }
                        break;
                    case 3:
                        Toast.makeText(GraphActivity.this,"Mid-Peak hours is Selected",Toast.LENGTH_SHORT).show();
                        drawPieChart(5,90,30,20);


                        if(isON("4")){
                            imageView4.setImageResource(R.drawable.alarm_w);
                            text_load.setText("Lights are ON!");
                        }else{
                            imageView4.setImageResource(R.drawable.okay);
                            text_load.setText("All Good!");
                        }

                        break;
                    case 4:
                        drawPieChart(0,100,70,0);
                        Toast.makeText(GraphActivity.this,"On-Peak hours is Selected",Toast.LENGTH_SHORT).show();
                        imageView4.setImageResource(R.drawable.alarm_w);
                        text_load.setText("Less Money Generated");

                        break;
                    case 5:
                        drawPieChart(0,100,70,0);
                        Toast.makeText(GraphActivity.this,"On-Peak hours is Selected",Toast.LENGTH_SHORT).show();

                        if(isON("3")){
                            imageView4.setImageResource(R.drawable.alarm_w);
                            text_load.setText("Light is ON!");
                        }else{
                            imageView4.setImageResource(R.drawable.okay);
                            text_load.setText("All Good!");
                        }
                        break;
                    case 6:
                        drawPieChart(0,100,70,0);
                        Toast.makeText(GraphActivity.this,"On-Peak hours is Selected",Toast.LENGTH_SHORT).show();

                        if(isON("3")){
                            imageView4.setImageResource(R.drawable.alarm_w);
                            text_load.setText("Light is ON!");
                        }else{
                            imageView4.setImageResource(R.drawable.okay);
                            text_load.setText("All Good!");
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected() {

            }
        });

        drawBarChart();
        setBarData(1500,3000, 5000, 2500,1100,3500,1800);
        drawPieChart(80,20,0,0);
    }
    private void drawBarChart() {

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(false);
        barChart.setTouchEnabled(true);
        barChart.setDescription("");

        //disable zoom
        barChart.setDoubleTapToZoomEnabled(false);
        barChart.setScaleEnabled(false);

        barChart.setDrawGridBackground(false);

        XAxis xAxis = barChart.getXAxis();

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(10f);
        xAxis.setEnabled(true);

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setAxisLineColor( ContextCompat.getColor(this, R.color.dark_grey));
        //leftAxis.setAxisMaxValue(20);
        leftAxis.setLabelCount(6);
        leftAxis.setDrawGridLines(true);
        leftAxis.setTextSize(10f);
        leftAxis.setEnabled(true);

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setEnabled(false);

        barChart.animateY(2000);


        barChart.getLegend().setEnabled(false);

    }

    private void setBarData(int temp1, int temp2, int temp3, int temp4,int temp5, int temp6, int temp7) {


        barChart.setVisibility(View.VISIBLE);
        ArrayList<String> xVal = new ArrayList<>();

        xVal.add(RANGE1);
        xVal.add(RANGE2);
        xVal.add(RANGE3);
        xVal.add(RANGE4);
        xVal.add(RANGE11);
        xVal.add(RANGE22);
        xVal.add(RANGE33);

        chartTitle1.setText(String.valueOf(temp1));
        chartTitle2.setText(String.valueOf(temp2));
        chartTitle3.setText(String.valueOf(temp3));
        chartTitle4.setText(String.valueOf(temp4));
        chartTitle5.setText(String.valueOf(temp5));
        chartTitle6.setText(String.valueOf(temp6));
        chartTitle7.setText(String.valueOf(temp7));

        ArrayList<BarEntry> yVal = new ArrayList<>();

        yVal.add(new BarEntry(temp1, 0));
        yVal.add(new BarEntry(temp2, 1));
        yVal.add(new BarEntry(temp3, 2));
        yVal.add(new BarEntry(temp4, 3));
        yVal.add(new BarEntry(temp5, 4));
        yVal.add(new BarEntry(temp6, 5));
        yVal.add(new BarEntry(temp7, 6));

        BarDataSet set1 = new BarDataSet(yVal, LABLE_BARDATA);

        ArrayList<BarDataSet> dataSets = new ArrayList<>();

        set1.resetColors();

        int lightBlue = ContextCompat.getColor(this, R.color.blue_light);
        int lightGreen = ContextCompat.getColor(this, R.color.green_light);
        int lightOrange = ContextCompat.getColor(this, R.color.orange_light);
        int lightRed = ContextCompat.getColor(this, R.color.light_red);
        int MiscColor1 = ContextCompat.getColor(this, R.color.misc_colorone);
        int MiscColor2 = ContextCompat.getColor(this, R.color.misc_colortwo);
        int MiscColor3 = ContextCompat.getColor(this, R.color.misc_colorthr);

        set1.addColor(lightBlue);

        set1.addColor(lightGreen);

        set1.addColor(lightOrange);

        set1.addColor(lightRed);

        set1.addColor(MiscColor1);

        set1.addColor(MiscColor2);

        set1.addColor(MiscColor3);

        set1.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return "";
            }
        });


        dataSets.add(set1);

        BarData data = new BarData(xVal, dataSets);

        data.setValueTextSize(10f);


        barChart.setData(data);

        barChart.setVisibleXRangeMaximum( 3.0f );

        barChart.invalidate();

    }


    private void drawPieChart(final int temp1, final int temp2, final int temp3, final int temp4) {


        layPiechart.post(new Runnable() {
            @Override
            public void run() {

                pieChart.setHoleRadius(50f);
                pieChart.setTransparentCircleRadius(75f);
                pieChart.setTouchEnabled(true);
                pieChart.setDrawSliceText(false);
                pieChart.setUsePercentValues(false);

                Legend l = pieChart.getLegend();
                l.setEnabled(true);
                l.setFormSize(9f); // set the size of the legend forms/shapes
                l.setForm(Legend.LegendForm.SQUARE); // set what type of form/shape should be used
                l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
                l.setTextSize(11f);
                l.setTextColor( Color.BLACK);
                l.setXOffset(10F);

                ArrayList<Entry> entries = new ArrayList<>();
                entries.add(new Entry(temp1, 0));
                entries.add(new Entry(temp2, 1));
                entries.add(new Entry(temp3, 2));
                entries.add(new Entry(temp4, 3));

                PieDataSet dataset = new PieDataSet(entries, LABLE_PIEDATA);
                dataset.resetColors();

                ArrayList<String> labels = new ArrayList<String>();
                labels.add(RANGE5);
                labels.add(RANGE6);
                labels.add(RANGE7);
                labels.add(RANGE8);

                int lightBlue = ContextCompat.getColor(GraphActivity.this, R.color.blue_light);
                int lightGreen = ContextCompat.getColor(GraphActivity.this, R.color.green_light);
                int lightOrange = ContextCompat.getColor(GraphActivity.this, R.color.orange_light);
                int lightRed = ContextCompat.getColor(GraphActivity.this, R.color.light_red);

                dataset.addColor(lightBlue);
                dataset.addColor(lightGreen);
                dataset.addColor(lightOrange);
                dataset.addColor(lightRed);
                dataset.setDrawValues(false);


                // set custom labels and colors
                l.setCustom(dataset.getColors(), labels);


                PieData data = new PieData(labels, dataset);
                data.setDrawValues(false);



                // undo all highlights
                pieChart.highlightValues(null);
                pieChart.setData(data);

                pieChart.setMinimumHeight(layPiechart.getHeight() - (int) getResources().getDimension(R.dimen.twenty));
                pieChart.setMinimumWidth(layPiechart.getWidth());

                pieChart.animateX(2000);
                pieChart.invalidate();
            }
        });


    }


    public void callLine(View d) {
        /*Intent i = new Intent(GraphActivity.this, LineGraphActivity.class);
        startActivity(i);*/
    }


    private boolean isON(String val) {
        // return twitter login status from Shared Preferences
        return mSharedPreferences.getBoolean(val, false);
    }



}

