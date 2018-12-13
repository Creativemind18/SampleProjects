package com.example.sesa373142.asynctask_threading;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by SESA373142 on 11/19/2016.
 */

public class MyTask extends AsyncTask<String,String,Bitmap> {

    private Context mContext;
    private ImageView mImageView;
    private ProgressDialog mProgressDialog;

    public MyTask(Context mContext, ImageView mImageView) {
        this.mContext = mContext;
        this.mImageView = mImageView;
        this.mProgressDialog = new ProgressDialog(mContext);
    }

    @Override
    protected void onPreExecute() {//running on main
        super.onPreExecute();
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bm = null;
        try {
            Thread.sleep(2000);
            publishProgress("start connecting ...");
            URL aURL = new URL(params[0]);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            Thread.sleep(2000);
            publishProgress("started downloading ...");
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            Thread.sleep(2000);
            publishProgress("download completed ...");
            Thread.sleep(2000);
            bis.close();
            is.close();
        } catch (Exception e) {
            Log.e("Hub","Error getting the image from server : " + e.getMessage().toString());
        }
        return bm;
    }

    @Override
    protected void onProgressUpdate(String... values) {//String... values or String[]
        super.onProgressUpdate(values);
        mProgressDialog.setMessage(values[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        mProgressDialog.dismiss();
        mImageView.setImageBitmap(bitmap);
    }

}
