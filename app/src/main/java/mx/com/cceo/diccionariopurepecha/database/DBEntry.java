package mx.com.cceo.diccionariopurepecha.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.com.cceo.diccionariopurepecha.model.Entry;

/**
 * Created by Hugo on 9/24/2015.
 */
public class DBEntry extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String ENTRY_TABLE_NAME = "entries";
    private static final String ENTRY_TABLE_CREATE =
            "CREATE TABLE " + ENTRY_TABLE_NAME + " (" +
                    "id_entry" + " INTEGER, " +
                    "word" + " TEXT, " +
                    "translation" + " TEXT);";

    public DBEntry(Context context) {
        super(context, "dictionary", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ENTRY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertEntry(Entry entry)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("id_entry", entry.getIdEntry());
        contentValues.put("word", entry.getWord());
        contentValues.put("translation", entry.getTranslation());

        db.insert("entries", null, contentValues);
        db.close();
        return true;
    }

    public ArrayList<Entry> getAllEntries()
    {
        ArrayList<Entry> entries = new ArrayList<Entry>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM entries", null );

        if(res.moveToFirst())
        {
            do
            {
                Entry temp = new Entry(res.getInt(0),res.getString(1),res.getString(2));
                entries.add(temp);
            }
            while (res.moveToNext());
        }
        return entries;
    }

    /**
     * Returns all entries that start with the prefix
     * @param prefix letter to be looked for
     * @return ArrayList with all found entries
     */
    public ArrayList<Entry> getEntriesStartingWith(String prefix)
    {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM entries WHERE word LIKE '" + prefix +"%'", null );

        if(res.moveToFirst())
        {
            do
            {
                Entry temp = new Entry(res.getInt(0),res.getString(1),res.getString(2));
                entries.add(temp);
            }
            while (res.moveToNext());
        }
        return entries;
    }
}
