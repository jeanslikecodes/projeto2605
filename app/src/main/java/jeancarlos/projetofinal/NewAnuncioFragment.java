package jeancarlos.projetofinal;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;

import jeancarlos.projetofinal.dao.AnuncioDAO;
import jeancarlos.projetofinal.helper.AnuncioHelper;
import jeancarlos.projetofinal.model.Anuncio;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewAnuncioFragment extends Fragment {

    AnuncioHelper helper;

    public NewAnuncioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_anuncio, container, false);

        helper = new AnuncioHelper(v);

        Intent intent = getActivity().getIntent();
        final Anuncio anuncio = (Anuncio) intent.getSerializableExtra("goNewAnuncio");

        if(anuncio != null) {
            helper.setAnuncio(anuncio);

            Button btnDelete = (Button) v.findViewById(R.id.btnDeletarAnuncio);
            btnDelete.setVisibility(View.VISIBLE);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AnuncioDAO dao = new AnuncioDAO(getActivity());
                    dao.deleteAnuncio(anuncio);
                    dao.close();
                    getActivity().finish();
                }
            });
        }

        Button btnSave = (Button) v.findViewById(R.id.btnCadastrarAnuncio);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anuncio newAnuncio = helper.getAnuncio();
                AnuncioDAO dao = new AnuncioDAO(getActivity());

                if(newAnuncio.getId() != null){
                    dao.updateAnuncio(newAnuncio);
                }
                else {
                    dao.insertAnuncio(newAnuncio);
                    Toast.makeText(getActivity(), "Usuário "+ newAnuncio.getDescricao() + " cadastrado com sucesso.", Toast.LENGTH_LONG).show();
                }
                dao.close();
                getActivity().finish();
            }
        });

        return v;
    }

}
