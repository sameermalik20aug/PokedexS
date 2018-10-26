package com.example.hp.lesson10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ImageButton button;
    TextView textView;
    ImageView imageView;
    TextView textView2;
    TextView textView3;
    EditText editText;
    int i=1;
    ImageButton button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tView1);
        button = findViewById(R.id.button3);
        imageView = findViewById(R.id.iView);
        textView2 = findViewById(R.id.tView2);
        textView3 = findViewById(R.id.tView3);
        button2 = findViewById(R.id.button);
        button3 = findViewById(R.id.button2);
        editText =findViewById(R.id.eText1);
        String url = "http://pokeapi.co/api/v2/pokemon/1/";
        makeNetworkCall(url);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i= Integer.parseInt((editText.getText().toString()));
                if(i>=1&&i<=802) {
                    Toast.makeText(MainActivity.this, "Please Wait..", Toast.LENGTH_SHORT).show();
                    makeNetworkCall("http://pokeapi.co/api/v2/pokemon/" + i + "/");
                    editText.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter A Valid Value..", Toast.LENGTH_SHORT).show();

                }
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i>1&&i<=802) {
                    i--;
                    Toast.makeText(MainActivity.this, "Please Wait..", Toast.LENGTH_SHORT).show();
                    makeNetworkCall("http://pokeapi.co/api/v2/pokemon/" + i + "/");
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Already On The First!!", Toast.LENGTH_SHORT).show();
                    i=1;
                }
                }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i>=1&&i<802) {
                    i++;
                    Toast.makeText(MainActivity.this, "Please Wait..", Toast.LENGTH_SHORT).show();
                    makeNetworkCall("http://pokeapi.co/api/v2/pokemon/" + i + "/");
                }
                else {
                    Toast.makeText(MainActivity.this, "At The End!!", Toast.LENGTH_SHORT).show();
                    i=802;
                }
                }
        });

    }
    private void makeNetworkCall(String url) {

        OkHttpClient okHttpClient= new OkHttpClient();

        final Request request= new Request.Builder()
                .url(url)
                .build();


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String result = response.body().string();
                final Gson gson = new Gson();
                final APIresponse apiResponse = gson.fromJson(result, APIresponse.class);



                (MainActivity.this).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        textView.setText(apiResponse.getName());
                        Picasso.get().load(apiResponse.getSprites().getFront_shiny()).into(imageView);
                        textView2.setText(String.valueOf(apiResponse.getId()));
                        String toSet="\n";
                        for(stats a : apiResponse.getStats()){
                            toSet = toSet + a.getStat().getName() +": \n\tBase Stat -> "+a.getBase_stat()+"\n\tEffort -> "+a.getEffort()+"\n\n";
                        }
                        textView3.setText("\tHeight ->\t"+String.valueOf(apiResponse.getHeight())+
                                "\n\tWeight ->\t"+String.valueOf(apiResponse.getWeight())+toSet);
                    }

                });

            }
        });
    }
}