package it.famigliaxs.libretto.DBAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

/**
 * Created by federicosanchi on 26/03/15.
 */
public class DBAdapter {
    private static final String LOG_TAG = DBAdapter.class.getSimpleName();

    private Context context;
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    // Database fields
    private static final String DATABASE_TABLE = "TBL_SPESE";

    public static final String KEY_SPESAID = "ID";
    public static final String KEY_IMPORTO = "Importo";
    public static final String KEY_DATA = "Data";
    public static final String KEY_DESCRIZIONE = "Descrizione";
    public static final String KEY_UTENTE = "Utente";

    public DBAdapter(Context context) {
        this.context = context;
    }

    public DBAdapter open(){
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValues(float importo, Date data, String descrizione, String utente ) {
        ContentValues values = new ContentValues();
        values.put( KEY_IMPORTO, importo);
        values.put( KEY_DATA, data.toString());
        values.put( KEY_DESCRIZIONE, descrizione);
        values.put( KEY_UTENTE, utente );

        return values;
    }

    //Inserimento di una spesa
    public long insertSpesa(float importo, Date data, String descrizione, String utente ) {
        ContentValues initialValues = createContentValues(importo, data, descrizione, utente);
        return db.insertOrThrow(DATABASE_TABLE, null, initialValues);
    }

    /*update a contact
    public boolean updateContact( long contactID, String name, String surname, String sex, String birth_date ) {
        ContentValues updateValues = createContentValues(name, surname, sex, birth_date);
        return database.update(DATABASE_TABLE, updateValues, KEY_ CONTACTID + "=" + contactID, null) > 0;
    }

    //delete a contact
    public boolean deleteContact(long contactID) {
        return database.delete(DATABASE_TABLE, KEY_ CONTACTID + "=" + contactID, null) > 0;
    }
    */

    //Retrieve di tutte le spese inserite
    //TODO: limitare i risultati di questa query
    public Cursor fetchAllSpese() {
        return db.query(DATABASE_TABLE, new String[] { KEY_IMPORTO, KEY_DATA, KEY_DESCRIZIONE, KEY_UTENTE}, null, null, null, null, null);
    }

    /*
    //fetch contacts filter by a string
    public Cursor fetchContactsByFilter(String filter) {
        Cursor mCursor = database.query(true, DATABASE_TABLE, new String[] {
                        KEY_CONTACTID, KEY_NAME, KEY_SURNAME, KEY_SEX, KEY_BIRTH_DATE },
                KEY_NAME + " like '%"+ filter + "%'", null, null, null, null, null);

        return mCursor;
    }*/

}
