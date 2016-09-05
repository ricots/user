package com.kos.user;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import android.support.v7.widget.Toolbar;

public class detail_kos extends AppCompatActivity {
    RequestQueue getBeritaDetail;
    Item item;
    Toolbar mToolbar;
    CollapsingToolbarLayout collapsingToolbar;
    private static final String TAG = detail_kos.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kos);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("detail kos");
        ImageView dtl_gambar = (ImageView) findViewById(R.id.detail_image_view2);
        TextView dtl_id = (TextView) findViewById(R.id.detail_id_kos);
        TextView dtl_almt = (TextView) findViewById(R.id.detail_alamat);
        TextView dtl_kat = (TextView) findViewById(R.id.detail_kategori);
        TextView dtl_hrg = (TextView) findViewById(R.id.detail_harga);
        TextView dtl_jml = (TextView) findViewById(R.id.detail_jml_kamar);
        TextView dtl_fast = (TextView) findViewById(R.id.detail_fasilitas);
        TextView dtl_no = (TextView) findViewById(R.id.detail_no_hp);
        getBeritaDetail = Volley.newRequestQueue(getApplicationContext());

        Intent in = getIntent();
        String id_kos = in.getStringExtra(config.TAG_id);
        String almt_kos = in.getStringExtra(config.KEY_alamat);
        String kat = in.getStringExtra(config.KEY_kategori);
        String no_hp_kos = in.getStringExtra(config.KEY_NO_HP);
        String jml = in.getStringExtra(config.KEY_jml_kamar);
        String fast_kos = in.getStringExtra(config.KEY_fasilitas);
        String gambr_kos = in.getStringExtra(config.KEY_GAMBAR);
        String hrg_kos = in.getStringExtra(config.KEY_harga);

        dtl_id.setText(id_kos);
        dtl_almt.setText(almt_kos);
        dtl_kat.setText(kat);
        dtl_hrg.setText(hrg_kos);
        dtl_jml.setText(jml);
        dtl_fast.setText(fast_kos);
        dtl_no.setText(no_hp_kos);
        Picasso.with(getApplicationContext()).load(gambr_kos).into(dtl_gambar);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // moveTaskToBack(true);;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
