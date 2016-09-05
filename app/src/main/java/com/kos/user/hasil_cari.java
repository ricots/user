package com.kos.user;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class hasil_cari extends AppCompatActivity {
    SharedPreferences sp,spp;
    SharedPreferences.Editor spe,spee;
    TextView tamp_harga,tamp_kategori,tamp_fasilitas;
    ProgressDialog dialog;
    ListView tamp_kos;
    private List<Item> array = new ArrayList<Item>();
    private Adapter_hasil adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_cari);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("hasil cari kos");

        tamp_harga = (TextView) findViewById(R.id.tamp_harga);
        tamp_kategori = (TextView) findViewById(R.id.tamp_kategori);
        tamp_fasilitas = (TextView) findViewById(R.id.tamp_fasilitas);
        sp = this.getSharedPreferences("parameter", 0);
        spe = sp.edit();
        String tp_harga = sp.getString("paramet","");
        String tp_kategori = sp.getString("parameter","");
        String tp_fasilitas = sp.getString("paramete","");
        tamp_kategori.setText(tp_kategori);
        tamp_fasilitas.setText(tp_fasilitas);
        tamp_harga.setText(tp_harga);
        System.out.println("hasilnya "+tp_fasilitas);

        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        tamp_kos = (ListView) findViewById(R.id.tamp_kos);

        tamp_kos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item map =  array.get(position);
                String gambar_detail = ((CircleImageView) view.findViewById(R.id.image_view1)).toString();
                String d_id = ((TextView) view.findViewById(R.id.hs_id)).getText().toString();
                String d_harga = ((TextView) view.findViewById(R.id.hs_harga)).getText().toString();
                String d_kategori = ((TextView) view.findViewById(R.id.hs_kategori)).getText().toString();
                String d_fasilitas = ((TextView) view.findViewById(R.id.hs_fasilitas)).getText().toString();
                String d_jml = ((TextView) view.findViewById(R.id.hs_jml_kmr)).getText().toString();
                String d_no = ((TextView) view.findViewById(R.id.hs_no)).getText().toString();
                String d_alamat = ((TextView) view.findViewById(R.id.hs_alamat)).getText().toString();

                Intent in = new Intent(hasil_cari.this,detail_kos.class);
                in.putExtra(config.KEY_GAMBAR, map.getFoto());
                in.putExtra(config.TAG_id, d_id);
                in.putExtra(config.KEY_harga, d_harga);
                in.putExtra(config.KEY_kategori, d_kategori);
                in.putExtra(config.KEY_fasilitas, d_fasilitas);
                in.putExtra(config.KEY_jml_kamar, d_jml);
                in.putExtra(config.KEY_NO_HP, d_no);
                in.putExtra(config.KEY_alamat, d_alamat);
                startActivity(in);
            }
        });
        adp=new Adapter_hasil(this,array);
        tamp_kos.setAdapter(adp);
        cari();
    }

    public void cari(){
        String URL_CARI = config.CARI_KOST + tamp_harga.getText().toString() +"&kategori=" +
                tamp_kategori.getText().toString() +"&fasilitas=" + tamp_fasilitas.getText().toString();

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL_CARI, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                hideDialog();

                for(int i=0;i<response.length();i++){
                    try{
                        JSONObject obj=response.getJSONObject(i);
                        Item item=new Item();
                        item.setAlamat(obj.getString(config.KEY_alamat));
                        item.setHarga(obj.getString(config.KEY_harga));
                        item.setFasilitas(obj.getString(config.KEY_fasilitas));
                        item.setKategori(obj.getString(config.KEY_kategori));
                        item.setNo_hp(obj.getString(config.KEY_NO_HP));
                        item.setJumlah_kamar(obj.getString(config.KEY_jml_kamar));
                        item.setId_pemilik(obj.getString(config.TAG_id));
                        if (obj.getString(config.KEY_GAMBAR) != "") {
                            item.setFoto(obj.getString(config.KEY_GAMBAR));
                        }

                        array.add(item);
                    }catch(JSONException ex){
                        ex.printStackTrace();
                    }
                }
                adp.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"silahkan cek koneksi data anda",Toast.LENGTH_LONG).show();
            }
        });
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                10800, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        hideDialog();
        AppController.getInstance().addToRequesQueue(jsonArrayRequest);
    }

    public void hideDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
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
