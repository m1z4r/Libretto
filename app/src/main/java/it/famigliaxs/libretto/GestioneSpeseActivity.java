package it.famigliaxs.libretto;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;
import java.util.logging.ConsoleHandler;

import it.famigliaxs.libretto.DBAccess.DBAdapter;
import it.famigliaxs.libretto.DBAccess.DBHelper;
import it.famigliaxs.libretto.Model.SpesaModel;


public class GestioneSpeseActivity extends ActionBarActivity {

    private DBAdapter dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestione_spese);

        dbhelper = new DBAdapter(this);

        Button btn_SalvaSpesa = (Button) findViewById(R.id.btn_SalvaImporto);
        btn_SalvaSpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaSpesa();
            }
        });

        Button btn_VisualizzaSpese = (Button) findViewById(R.id.btn_VisualizzaSpese);
        btn_VisualizzaSpese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualizzaSpese();
            }
        });

        updateLstUltimeSpese();
    }

    private void salvaSpesa(){
        try{
            dbhelper.open();
            //TODO: modificare i campi inseriti
            long l = dbhelper.insertSpesa(10, new Date(), "test", "test");
            dbhelper.close();
        } catch(Exception e){
            Log.w("App", e.getMessage());
        }

        updateLstUltimeSpese();
    }

    private void visualizzaSpese(){
        //richiamare activity selezione operazione
        final Intent i = new Intent(this, GestioneSpeseActivity.class);
        startActivity(i);
    }

    private void updateLstUltimeSpese(){
        Log.w("EFFE: ", "updateUltimeSpese()");
        List<SpesaModel> listaSpese;

        try{
            dbhelper.open();
            Cursor c = dbhelper.fetchAllSpese();
            dbhelper.close();

            if(c != null){
                Adapter adapter = new CursorAdapter(this, c, 0) {
                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, null);
                    }

                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        ((TextView) view.findViewById(android.R.id.text1)).setText("PROVA1");
                        ((TextView) view.findViewById(android.R.id.text2)).setText("PROVA2");
                    }
                };

                ListView lst_spese = (ListView) findViewById(R.id.lst_UltimeSpese);
                lst_spese.setAdapter((ListAdapter) adapter);



            }
        } catch(Exception e){
            Log.w("App", e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gestione_spese, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
