package jeancarlos.projetofinal.helper;

import android.view.View;
import android.widget.EditText;

import jeancarlos.projetofinal.NewAnuncioActivity;
import jeancarlos.projetofinal.R;
import jeancarlos.projetofinal.model.Anuncio;

/**
 * Created by Jean Carlos on 21/05/2017.
 */

public class AnuncioHelper {

    private EditText descricao, estado, preco;

    private Anuncio anuncio;

    public AnuncioHelper(View view) {
        this.descricao = (EditText) view.findViewById(R.id.editDescricao);
        this.estado = (EditText) view.findViewById(R.id.editEstado);
        this.preco = (EditText) view.findViewById(R.id.editPreco);
        this.anuncio = new Anuncio();
    }

    public Anuncio getAnuncio() {
        anuncio.setDescricao(descricao.getText().toString());
        anuncio.setEstado(estado.getText().toString());
        anuncio.setPreco(preco.getText().toString());
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        descricao.setText(anuncio.getDescricao());
        estado.setText(anuncio.getEstado());
        preco.setText(anuncio.getPreco());
        this.anuncio = anuncio;
    }
}
