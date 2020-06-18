package com.mahmoud.mostafa.hacknews.ui.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.mahmoud.mostafa.hacknews.R;
import com.mahmoud.mostafa.hacknews.base.BaseActivity;
import com.mahmoud.mostafa.hacknews.databinding.ActivityDetailBinding;

public class    DetailActivity extends BaseActivity implements DetailMvpView {

    private String id;
    private DetailsPresenter mPresenter;
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        id = getIntent().getStringExtra("id");
        mPresenter = new DetailsPresenter(this);
        mPresenter.getStoryDetails(id);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        disappearBottomRightAnimation(this);

        return super.onSupportNavigateUp();
    }

    @Override
    public void setupWebView(String url) {
        binding.wvStory.getSettings().setJavaScriptEnabled(true);
        binding.wvStory.loadUrl(url);
    }

    @Override
    public void setUpTitle(String title) {
        getSupportActionBar().setTitle(title.subSequence(0, 15) + "...");
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
