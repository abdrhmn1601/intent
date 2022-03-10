package com.abd.intent;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.URI;

public class RSAwalBross extends ListActivity {
    @Override
    protected void onCreate( Bundle icicle) {
        super.onCreate(icicle);
        String[] listRS = new String[] {"Call Center","SMS Center","Driving Direction","Website","Info di Google","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listRS));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center"))
            {
                String nomortel ="tel:085233466478";
                a =new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));

            }else if (pilihan.equals("SMS Center")){
                String smsText ="Abdul Rahman/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:085233466478"));
                a.putExtra("sms_body",smsText);

            }else if (pilihan.equals("Driving Direction")){
                String lokasiRS ="google.navigation:q=0.463923,101.390353";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasiRS));

            }else  if (pilihan.equals("Website"))
            {
                String website ="http://www.awal_bross.net";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            }else if (pilihan.equals("Info di Google")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bross");
            }

            startActivity(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
