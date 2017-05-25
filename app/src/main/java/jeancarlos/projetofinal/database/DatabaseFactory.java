package jeancarlos.projetofinal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jean Carlos on 21/05/2017.
 */

public class DatabaseFactory extends SQLiteOpenHelper {

    private static final String Snap_DB = "snap_db";

    public static final String ANUNCIO_TABLE = "anuncio";

    public static final String ID_ANUNCIO = "id_anuncio";
    public static final String DESCRICAO = "descricao";
    public static final String ESTADO = "estado";
    public static final String PRECO = "preco";

    public DatabaseFactory(Context context) {
        super(context, Snap_DB, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlAnuncio = "CREATE TABLE IF NOT EXISTS "+ ANUNCIO_TABLE +"( " +
                ID_ANUNCIO +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                DESCRICAO +" TEXT NOT NULL, " +
                ESTADO +" TEXT NOT NULL, " +
                PRECO +" TEXT NOT NULL " +
                ");";

        db.execSQL(sqlAnuncio);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlAnuncio = "DROP TABLE IF EXISTS "+ ANUNCIO_TABLE +";";
        db.execSQL(sqlAnuncio);
        onCreate(db);
    }
}
