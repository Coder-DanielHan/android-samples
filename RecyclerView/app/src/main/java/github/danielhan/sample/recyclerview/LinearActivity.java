package github.danielhan.sample.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LinearActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private LinearAdapter myAdapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(LinearActivity.this));
        recyclerview.addItemDecoration(new LinearItemDecoration(this, LinearItemDecoration.VERTICAL,100));
        for (int i = 0; i < 50; i++) {
            list.add(i + "");
        }
        myAdapter = new LinearAdapter(list);
        recyclerview.setAdapter(myAdapter);
    }
}
