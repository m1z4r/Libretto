package it.famigliaxs.libretto.DBAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by federicosanchi on 26/03/15.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "Spese.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "CREATE TABLE TBL_SPESE (ID integer primary key autoincrement, Importo float not null, Data date not null, Descrizione text null, Utente text null);";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.w("DB: ", "creazione tabella");
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TBL_SPESE");
        onCreate(db);
    }
}
