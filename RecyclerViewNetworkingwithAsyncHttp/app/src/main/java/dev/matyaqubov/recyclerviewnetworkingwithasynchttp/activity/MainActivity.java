package dev.matyaqubov.recyclerviewnetworkingwithasynchttp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpRequest;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import dev.matyaqubov.recyclerviewnetworkingwithasynchttp.R;
import dev.matyaqubov.recyclerviewnetworkingwithasynchttp.adapter.MainAdapter;
import dev.matyaqubov.recyclerviewnetworkingwithasynchttp.helper.ServerURI;
import dev.matyaqubov.recyclerviewnetworkingwithasynchttp.model.Player;
import dev.matyaqubov.recyclerviewnetworkingwithasynchttp.model.PlayerData;

public class MainActivity extends AppCompatActivity  implements ServerURI {
    private RecyclerView recyclerView;
    private ProgressBar process;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        apiUSingAsyncHttp();
    }

    private void apiUSingAsyncHttp() {
        process.setVisibility(View.VISIBLE);

        RequestParams params =new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();

        client.post(SERVER_URL, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("@@@", "onFailure: "+statusCode);
                process.setVisibility(View.GONE);

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                Log.d("@@@", "onSuccess: "+statusCode);
                PlayerData playerData= new Gson().fromJson(responseString,PlayerData.class);
                processWithResponse(playerData);


            }
        });
    }

    private void processWithResponse(PlayerData playerData) {
        process.setVisibility(View.GONE);

        String message=playerData.getMessage();
        List<Player> players=playerData.getData();

        fireToast(message);
        refreshAdapter(players);


    }

    private void refreshAdapter(List<Player> players) {

        MainAdapter mainAdapter=new MainAdapter(this,players);
        recyclerView.setAdapter(mainAdapter);


    }

    private void fireToast(String message) {
        Toast.makeText(this,message , Toast.LENGTH_SHORT).show();

    }

    private void initViews() {
        process=findViewById(R.id.pr_bar);
        recyclerView=findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }
}