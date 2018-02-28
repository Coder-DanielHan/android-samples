package github.danielhan.sample.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private GridAdapter myAdapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new GridLayoutManager(GridActivity.this, 3));
        recyclerview.addItemDecoration(new GridItemDecoration(GridActivity.this, 15, 30, 3));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        myAdapter = new GridAdapter(list, new GridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                addData();
            }
        });
        recyclerview.setAdapter(myAdapter);
    }

    public void addData() {
        list.add(2, "100");
        myAdapter.notifyItemInserted(2);
        myAdapter.notifyItemRangeChanged(2, list.size());
    }
}
