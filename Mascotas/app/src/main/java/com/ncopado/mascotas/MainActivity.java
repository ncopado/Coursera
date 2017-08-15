package com.ncopado.mascotas;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMilista;
    Adapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        sfiMiIndicadorRefresh= (SwipeRefreshLayout)  findViewById(R.id.sfiMiIndicadorRefresh);
        lstMilista=(ListView) findViewById(R.id.lstMilista);

        String[] planetas= getResources().getStringArray(R.array.planetas);

        lstMilista.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetas));

        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescadoContenido();
            }
        });



    }

    public  void  refrescadoContenido(){
        String[] planetas= getResources().getStringArray(R.array.planetas);

        lstMilista.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);

    }

    public  void  agregarFAB(){
        FloatingActionButton miFab= (FloatingActionButton) findViewById(R.id.floatingActionButton);
        miFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(getBaseContext(),getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();
                Snackbar.make(view,getResources().getString(R.string.mensaje),Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR","CLICK ");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();

            }
        });
    }
}
