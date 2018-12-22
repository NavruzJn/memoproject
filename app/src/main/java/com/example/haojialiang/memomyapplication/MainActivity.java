package com.example.haojialiang.memomyapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    @BindView(R.id.container)
    RecyclerView container;

    private MemosAdapter adaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        firebaseAuth = FirebaseAuth.getInstance();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddMemo.class);
                startActivity(intent);
            }
        });

        adaper = new MemosAdapter();
        container.setAdapter(adaper);

        ArrayList list = new ArrayList<Memo>();
        list.add(new Memo("BLA BLA", "bla bla", "2018-12-18"));
        list.add(new Memo("HER HER", "bla bla", "2018-12-18"));
        adaper.setItems(list);
        adaper.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null) {
//            startActivity(new Intent(getApplicationContext(), Login.class));
//            finish();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener != null) {
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

    public static class MemosAdapter extends RecyclerView.Adapter<MemosAdapter.ViewHolder> {

        private List<Memo> items;

        public void setItems(List<Memo> items) {
            this.items = items;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.memo_item, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            Memo memo = items.get(i);
            viewHolder.memo = memo;
            viewHolder.title.setText(memo.getTitle());
            viewHolder.subTitle.setText(memo.getDescription());
            viewHolder.date.setText(memo.getCreatedAt());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.title)
            TextView title;
            @BindView(R.id.subTitle)
            TextView subTitle;
        @BindView(R.id.tv_show_item_date)
                TextView date;
            Memo memo;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }

            @OnClick(R.id.cv_item)
            public void showItem() {
                Intent intent = new Intent(itemView.getContext(), AddMemo.class);
                intent.putExtra("memo", memo);
                itemView.getContext().startActivity(intent);
            }
        }
    }

}