package io.github.oleiva;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private TextView mTvDateCreate, mTvDateRegistered, mTvDateResolve, mTvWhoIsResponsible, mTvInfo, mTvTitle, mTvIconProgress;
    private TextView mTvCreate, mTvRegistered, mTvResolve, mTvResponsible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar;
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        assert toolbar != null;
        toolbar.setTitle(R.string.title_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<Uri> picList= new ArrayList<>();
        picList.add(Uri.parse(getString(R.string.pic1)));
        picList.add(Uri.parse(getString(R.string.pic2)));
        picList.add(Uri.parse(getString(R.string.pic3)));
        picList.add(Uri.parse(getString(R.string.pic4)));

        init();
        setAllText();

        RecyclerImageAdapter myAdapter = new RecyclerImageAdapter(this,picList);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(myAdapter);

        mRecyclerView.setOnClickListener(this);
        mTvDateCreate.setOnClickListener(this);
        mTvCreate.setOnClickListener(this);
        mTvDateRegistered.setOnClickListener(this);
        mTvRegistered.setOnClickListener(this);
        mTvDateResolve.setOnClickListener(this);
        mTvResolve.setOnClickListener(this);
        mTvWhoIsResponsible.setOnClickListener(this);
        mTvResponsible.setOnClickListener(this);
        mTvInfo.setOnClickListener(this);
        mTvTitle.setOnClickListener(this);
        mTvIconProgress.setOnClickListener(this);
    }

    private void init(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recView);
        mTvDateCreate = (TextView) findViewById(R.id.tvDateCreate);
        mTvCreate = (TextView) findViewById(R.id.tvCreate);
        mTvDateRegistered = (TextView) findViewById(R.id.tvDateRegistered);
        mTvRegistered = (TextView) findViewById(R.id.tvRegistered);
        mTvDateResolve = (TextView) findViewById(R.id.tvDateResolve);
        mTvResolve = (TextView) findViewById(R.id.tvResolve);
        mTvWhoIsResponsible = (TextView) findViewById(R.id.tvWhoIsResponsible);
        mTvResponsible = (TextView) findViewById(R.id.tvResponsible);
        mTvInfo = (TextView) findViewById(R.id.tvInfo);
        mTvTitle = (TextView) findViewById(R.id.tvTitle);
        mTvIconProgress = (TextView) findViewById(R.id.tvIconProgress);
    }

    private void setAllText(){
        mTvDateCreate.setText(R.string.text_created);
        mTvDateRegistered.setText(R.string.text_registered);
        mTvDateResolve.setText(R.string.text_resolve);
        mTvWhoIsResponsible.setText(R.string.text_responsible);
        mTvInfo.setText(R.string.text_info);
        mTvTitle.setText(R.string.text_title);
        mTvIconProgress.setText(R.string.text_icon_progress);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, v.getClass().getSimpleName(),Toast.LENGTH_SHORT).show();
    }

}
