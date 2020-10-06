package com.example.rockcatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rockcatalogue.R;
import com.example.rockcatalogue.model.Result;
import com.example.rockcatalogue.model.RockCatalogueModel;

import java.net.URL;

public class RockCatalogueAdapter extends RecyclerView.Adapter<RockCatalogueAdapter.ViewHolder> {
    RockCatalogueModel rockCatalogueModelList;
    int row_rockcatalogu;
    Context applicationContext;

    public RockCatalogueAdapter(RockCatalogueModel rockCatalogueModelList, int row_rockcatalogu, Context applicationContext) {
        this.rockCatalogueModelList = rockCatalogueModelList;
        this.row_rockcatalogu = row_rockcatalogu;
        this.applicationContext = applicationContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate( row_rockcatalogu, parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result rockCatalogueModel= rockCatalogueModelList.getResults().get( position );
        holder.rockcatName.setText( rockCatalogueModel.getArtistName() );
        URL newurl = null;
        Glide.with( applicationContext )
                .load( rockCatalogueModel.getArtworkUrl100() )
                .into( holder.rockcatImg );
    }

    @Override
    public int getItemCount() {
        return rockCatalogueModelList.getResultCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView rockcatName;
        ImageView rockcatImg;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            rockcatName = itemView.findViewById( R.id.tvRC );
            rockcatImg = itemView.findViewById( R.id.imgRC );
        }
    }
}
