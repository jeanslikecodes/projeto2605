package jeancarlos.projetofinal;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jeancarlos.projetofinal.AnuncioActivity;
import jeancarlos.projetofinal.MainActivity;
import jeancarlos.projetofinal.NewAnuncioActivity;
import jeancarlos.projetofinal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        Button btnCriarAnuncios = (Button) v.findViewById(R.id.btn_criar_anuncios);
        btnCriarAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewAnuncioActivity.class);
                startActivity(intent);
            }
        });

        Button btnListarAnuncios = (Button) v.findViewById(R.id.btn_listar_anuncios);
        btnListarAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AnuncioActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

}
