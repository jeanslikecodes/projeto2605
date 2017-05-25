package jeancarlos.projetofinal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jeancarlos.projetofinal.R;
import jeancarlos.projetofinal.model.Anuncio;
import jeancarlos.projetofinal.my_interface.RecyclerViewOnClickListener;

/**
 * Created by Jean Carlos on 21/05/2017.
 */

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.MyViewHolder> {

    private List<Anuncio> anuncioList;
    private LayoutInflater layoutInflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public AnuncioAdapter(Context context, List<Anuncio> anuncioList) {
        this.anuncioList = anuncioList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("LOG", "onCreateViewHolder()");
        View view = layoutInflater.inflate(R.layout.list_item_anuncio, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i("LOG", "onBindViewHolder()");


        holder.txtDescricao.setText(anuncioList.get(position).getDescricao());
        holder.txtEstado.setText(anuncioList.get(position).getEstado());
        holder.txtPreco.setText(anuncioList.get(position).getPreco());
    }

    @Override
    public int getItemCount() {
        return anuncioList.size();
    }

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener recyclerViewOnClickListener){
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
    }

    public Anuncio getAnuncio(int position){
        return anuncioList.get(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtDescricao, txtEstado, txtPreco;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtDescricao = (TextView) itemView.findViewById(R.id.txtDescricao);
            txtEstado = (TextView) itemView.findViewById(R.id.txtEstado);
            txtPreco = (TextView) itemView.findViewById(R.id.txtPreco);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(recyclerViewOnClickListener != null){
                recyclerViewOnClickListener.onClickListener(view, getPosition());
            }
        }
    }
}
