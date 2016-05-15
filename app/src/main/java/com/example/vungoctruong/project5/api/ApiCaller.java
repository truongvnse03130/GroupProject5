package com.example.vungoctruong.project5.api;

import android.os.AsyncTask;
import android.util.Log;

import com.example.vungoctruong.project5.entities.Team;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Vu Ngoc Truong on 5/16/2016.
 */
public class ApiCaller extends AsyncTask<String, Void, List<Team>> {

    private static final int SLEEP = 0;


    public interface ApiListener {
        void onSuccess(List<Team> teamList);

        void onFailed();

    }


    private ApiListener apiListener;


    public void setApiListener(ApiListener apiListener) {
        this.apiListener = apiListener;
    }


    @Override
    protected List<Team> doInBackground(String... params) {

        StringBuilder builder = null;

        try {

            URL url = new URL(params[0]);

            BufferedReader in = new BufferedReader(

                    new InputStreamReader(url.openStream()));

            builder = new StringBuilder();

            String inputLine;

            Thread.sleep(SLEEP);

            while ((inputLine = in.readLine()) != null) {

                if (isCancelled()) {

                    break;

                }

                builder.append(inputLine);

            }
            Log.d("TruongVN", builder + "");

            in.close();
            return new Gson().fromJson(builder.toString(), new TypeToken<List<Team>>() {
            }.getType());

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (InterruptedException e) {

            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }


    @Override

    protected void onPostExecute(List<Team> listTeam) {
        super.onPostExecute(listTeam);
        if (apiListener != null) {
            if (listTeam == null) {
                apiListener.onFailed();
            } else {
                apiListener.onSuccess(listTeam);
            }
        }
    }
}