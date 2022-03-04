package com.example.gest_project;

import android.app.ProgressDialog;
//import android.os.AsyncTask;
import android.os.Bundle;

import com.example.gest_project.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    ArrayList<Model> modelList;
    ArrayAdapter<Model> listAdapter;
    Handler mainHandler = new Handler();
    ProgressDialog progressDialog;

    List<Model>model = new ArrayList<>();

    int img = R.drawable.icon;



    private Toolbar toolbar;

    private FloatingActionButton floatingActionButton;

    //Json link
    private static String JSON_URL = "https://run.mocky.io/v3/a8de9313-9fbe-46b5-80e3-2b37e85f50a5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model.add(new Model(001,img,"Projet1","Boss1", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        model.add(new Model(001,img,"Projet2","Boss2", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
        model.add(new Model(001,img,"Projet3","Boss3", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"));
        model.add(new Model(001,img,"Projet4","Boss4", "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"));
        model.add(new Model(001,img,"Projet5","Boss5", "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
        model.add(new Model(001,img,"Projet6","Boss6", "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"));
        model.add(new Model(001,img,"Projet7","Boss7", "ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
        model.add(new Model(001,img,"Projet8","Boss8", "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"));
        model.add(new Model(001,img,"Projet9","Boss9", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"));

        final ListView listView = findViewById(R.id.recycleView);
        listView.setAdapter(new Adaptery(this, model));


        toolbar = findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Project App");


        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProject();
            }

        });

        /*View annulationButton = findViewById(R.id.annul);
        annulationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                annuler();
            }
        });

        View ConfrmationButton = findViewById(R.id.conf);
        ConfrmationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmer();
            }
        });*/

    }




    /*private void initializeModelList() {

        modelList = new ArrayList<Model>();
        listAdapter = new ArrayAdapter<Model>(this,R.layout.item_post,modelList);
        binding.recycleView.setAdapter(listAdapter);

        //List<Model>image_details = fetchData().start();
        /*final ListView listView =findViewById(R.id.recycleView);
        listView.setAdapter(new Adaptery(this, (List<Model>) model));

}
    String data = "";
    Model model = new Model();*/



    /*
    class fetchData extends Thread{

        @Override
        public void run(){

            try {
                URL url =new URL("https://run.mocky.io/v3/a8de9313-9fbe-46b5-80e3-2b37e85f50a5");
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                InputStream inputStream = httpsURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;

                while ((line = bufferedReader.readLine()) != null){

                    data = data + line;

                }

                if (!data.isEmpty()){

                    JSONObject jsonObject = new JSONObject(data);
                    JSONArray models =jsonObject.getJSONArray("Model");
                    modelList.clear();

                    for (int i =0;i< models.length();i++ ){

                        JSONObject jsonObject1 = models.getJSONObject(i);


                        int img = R.drawable.icon;
                        model.setImg(img);
                        model.setId(jsonObject1.getInt("id"));
                        model.setProj(jsonObject1.getString("proj"));
                        model.setChef(jsonObject1.getString("chef"));
                        model.setDescription(jsonObject1.getString("description"));
                        modelList.add(model);

                    }

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }*/



    private void addProject() {
        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);

        View myView = inflater.inflate(R.layout.adding, null);
        myDialog.setView(myView);

        AlertDialog dialog = myDialog.create();
        dialog.setCancelable(false);
        dialog.show();
    }


    private void annuler() {

    }

    private void confirmer() {

    }

}