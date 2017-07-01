package com.example.alexanderbespalov.bashapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.alexanderbespalov.bashapp.Adapters.PostsAdapter;
import com.example.alexanderbespalov.bashapp.R;
import com.example.alexanderbespalov.bashapp.RetrofitApp;
import com.example.alexanderbespalov.bashapp.model.PostModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_root_bash) RecyclerView recyclerViewBash;
    @BindView(R.id.recycler_root_abyss) RecyclerView recyclerViewAbyss;
    @BindView(R.id.tabhost) TabHost tabHost;
//   RecyclerView recyclerViewBash;
    List<PostModel> postsBash;
    List<PostModel> postsAbyss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTitle("Bash 4ever");

        postsBash = new ArrayList<>();
        postsAbyss = new ArrayList<>();

        LinearLayoutManager layoutManagerBash = new LinearLayoutManager(this);
        LinearLayoutManager layoutManagerAbyss = new LinearLayoutManager(this);
        recyclerViewBash.setLayoutManager(layoutManagerBash);
        recyclerViewAbyss.setLayoutManager(layoutManagerAbyss);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerViewBash.getContext(),
                layoutManagerBash.getOrientation());

        recyclerViewBash.addItemDecoration(dividerItemDecoration);
        recyclerViewAbyss.addItemDecoration(dividerItemDecoration);

        PostsAdapter adapterBash = new PostsAdapter(postsBash);
        recyclerViewBash.setAdapter(adapterBash);

        PostsAdapter adapterAbyss = new PostsAdapter(postsAbyss);
        recyclerViewAbyss.setAdapter(adapterAbyss);

        tabHost.setup(); // Инициализирует контейнер вкладок. Необходимо вызывать перед добавлением вкладок, если TabHost загружается методом findViewById()

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setContent(R.id.tab_new);
        tabSpec.setIndicator("Новое");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.tab_abyss);
        tabSpec.setIndicator("Бездна");
        tabHost.addTab(tabSpec);
        tabHost.setCurrentTab(0); // Выводит заданную вкладку на передний план






/*        try {
            Response response = RetrofitApp.getApi().getData("bash", 50).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        RetrofitApp.getApi().getData("bash", 50).enqueue(new Callback<List<PostModel>>() {

            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postsBash.addAll(response.body());
                recyclerViewBash.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occured during networking", Toast.LENGTH_SHORT).show();
                Log.e("blyat",t.getMessage() + t.getCause(),t);
            }
        });
        RetrofitApp.getApi().getData("abyss", 50).enqueue(new Callback<List<PostModel>>() {

            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postsAbyss.addAll(response.body());
                recyclerViewAbyss.getAdapter().notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occured during networking", Toast.LENGTH_SHORT).show();
                Log.e("blyat",t.getMessage() + t.getCause(),t);
            }
        });
    }
}
