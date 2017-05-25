package jeancarlos.projetofinal.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import jeancarlos.projetofinal.database.DatabaseFactory;
import jeancarlos.projetofinal.model.Anuncio;

/**
 * Created by Jean Carlos on 21/05/2017.
 */

public class AnuncioDAO extends DatabaseFactory {

    public AnuncioDAO(Context context) {
        super(context);
    }

    public void insertAnuncio(Anuncio anuncio) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(anuncio);
        db.insert(ANUNCIO_TABLE, null, dados);
    }

    public void updateAnuncio(Anuncio anuncio) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValues(anuncio);
        String[] params ={anuncio.getId().toString()};
        db.update(ANUNCIO_TABLE, dados, ID_ANUNCIO + " = ?", params);
    }

    @NonNull
    private ContentValues getContentValues(Anuncio anuncio) {
        ContentValues dados = new ContentValues();
        dados.put(DESCRICAO, anuncio.getDescricao());
        dados.put(ESTADO, anuncio.getEstado());
        dados.put(PRECO, anuncio.getPreco());
        return dados;
    }

    public void deleteAnuncio(Anuncio anuncio) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {anuncio.getId().toString()};
        db.delete(ANUNCIO_TABLE, ID_ANUNCIO +" = ?", params);
    }

    public List<Anuncio> searchAnuncio()  {
        String sql = "SELECT * FROM "+ ANUNCIO_TABLE +";";
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.rawQuery(sql, null);
            Log.d("DEBUG: ", c.toString());
            List<Anuncio> anuncios = new ArrayList<>();
            while (c.moveToNext()) {
                Anuncio anuncio = new Anuncio();
                anuncio.setId(c.getLong(c.getColumnIndex(ID_ANUNCIO)));
                anuncio.setDescricao(c.getString(c.getColumnIndex(DESCRICAO)));
                anuncio.setEstado(c.getString(c.getColumnIndex(ESTADO)));
                anuncio.setPreco(c.getString(c.getColumnIndex(PRECO)));
                anuncios.add(anuncio);
            }
            c.close();
            return anuncios;
        }
        catch (Exception e){
            Log.e("ERROR: ", e.getMessage());
            return null;
        }

    }
}
