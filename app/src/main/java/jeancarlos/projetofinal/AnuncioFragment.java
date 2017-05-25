package jeancarlos.projetofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;

import java.util.List;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import jeancarlos.projetofinal.adapter.AnuncioAdapter;
import jeancarlos.projetofinal.dao.AnuncioDAO;
import jeancarlos.projetofinal.model.Anuncio;
import jeancarlos.projetofinal.my_interface.RecyclerViewOnClickListener;


public class AnuncioFragment extends Fragment implements RecyclerViewOnClickListener {

    private RecyclerView recyclerView;
    private List<Anuncio> anuncioList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_anuncio, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        if(!getResources().getBoolean(R.bool.modoGrande)) {

            FragmentManager manager = getActivity().getSupportFragmentManager();
            FragmentTransaction tx = manager.beginTransaction();

            NewAnuncioFragment newAnuncio = new NewAnuncioFragment();
            tx.replace(R.id.newAnuncioFragment, newAnuncio);
            tx.commit();
        }

        carregar();

        return view;


    }

    private void carregar() {
        AnuncioDAO dao = new AnuncioDAO(getContext());
        anuncioList = dao.searchAnuncio();
        dao.close();

        AnuncioAdapter adapter = new AnuncioAdapter(getActivity(), anuncioList);
        adapter.setRecyclerViewOnClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getActivity(), "Position: "+position, Toast.LENGTH_SHORT).show();

        AnuncioAdapter adapter = (AnuncioAdapter) recyclerView.getAdapter();

        Anuncio contact = adapter.getAnuncio(position);
        Intent intent = new Intent(getContext(),
                NewAnuncioActivity.class);

        intent.putExtra("goAnuncio", contact);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        carregar();
    }
}
