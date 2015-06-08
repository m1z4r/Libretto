package it.famigliaxs.libretto;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SelezioneOperazioneActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selezione_operazione);

        Button btn_GestioneSpese = (Button) findViewById(R.id.btn_Spese);
        btn_GestioneSpese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterGestioneSpese();
            }
        });
    }

    private void enterGestioneSpese(){
        //richiamare activity selezione operazione
        final Intent i = new Intent(this, GestioneSpeseActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selezione_operazione, menu);
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
