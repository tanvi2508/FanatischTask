package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.test.modal.DataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String Url="https://jsonblob.com/api/933015671865098240";
    List<DataModel> models;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        models=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler_view);


        GetData data=new GetData();
        data.execute();



    }

    public class GetData extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {

            String current = " ";

            try {
                URL url;
                HttpURLConnection httpURLConnection = null;

                try {
                    url = new URL(Url);
                    httpURLConnection = (HttpURLConnection) url.openConnection();


                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);


                    int data = inputStreamReader.read();
                    while (data != -1) {
                        current += (char) data;
                        data = inputStreamReader.read();
                    }
                    return current;


                } catch (MalformedURLException e) {
                    e.printStackTrace();


                }

            }
        catch (IOException e) {
                    e.printStackTrace();
                }

            return current;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            try {
                JSONObject jsonObject=new JSONObject(s);
                JSONArray jsonArray=jsonObject.getJSONArray("users");


                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);

                    


                    DataModel dataModel=new DataModel();
                    dataModel.setFirstName(jsonObject1.getString("firstName"));
                    dataModel.setLastName(jsonObject1.getString("lastName"));
                    dataModel.setEmail(jsonObject1.getString("email"));
                    dataModel.setMobileNumber(jsonObject1.getString("mobile"));
                    dataModel.setAge(jsonObject1.getString("age"));
                    dataModel.setImage_url(jsonObject1.getString("imageUrl"));

                    models.add(dataModel);





                }

                Collections.sort(models, new Comparator<DataModel>() {
                    @Override
                    public int compare(DataModel dataModel, DataModel t1) {
                        return dataModel.getAge().compareTo(t1.getAge());
                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }


            PutData( models);
        }

    }

    private void PutData(List<DataModel> models){

        MyAdapter adapter=new MyAdapter(this,models);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}