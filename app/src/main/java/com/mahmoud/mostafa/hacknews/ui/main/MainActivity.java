package com.mahmoud.mostafa.hacknews.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.mahmoud.mostafa.hacknews.R;
import com.mahmoud.mostafa.hacknews.base.BaseActivity;
import com.mahmoud.mostafa.hacknews.databinding.ActivityMainBinding;
import com.mahmoud.mostafa.hacknews.ui.details.DetailActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements MainMvpView, MainInterface {

    private MainPresenter mPresenter;
    private ActivityMainBinding binding;
    private StoriesAdapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter = new MainPresenter(this);
        mPresenter.getStoriesIds();

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();

    }

    @Override
    public void setupListView(ArrayList<String> ids) {
        adapter = new StoriesAdapter(ids, this, this);
        manager = new LinearLayoutManager(this);
        binding.rvStories.setLayoutManager(manager);
        binding.rvStories.setItemAnimator(new DefaultItemAnimator());
        binding.rvStories.setAdapter(adapter);
    }

    @Override
    public void openDetails(String id) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
        appearBottomRightAnimation(this);
    }
}
