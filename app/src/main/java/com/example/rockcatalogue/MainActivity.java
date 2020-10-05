package com.example.rockcatalogue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.rockcatalogue.adapter.RockCatalogueAdapter;
import com.example.rockcatalogue.model.RockCatalogueModel;
import com.example.rockcatalogue.mvp.IRockCatalogueListContract;
import com.example.rockcatalogue.mvp.RockCatalogueListPresenterImpl;

import java.util.List;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements IRockCatalogueListContract.IView {

    IRockCatalogueListContract.IPresenter iPresenter;
    RockCatalogueListPresenterImpl rockCatalogueListPresenter;
    RecyclerView recyclerView;
    RockCatalogueAdapter rockCatalogueAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        initializePresenterClass();
        initializeRecyclerView();
    }

    public void initializePresenterClass(){
        rockCatalogueListPresenter = new RockCatalogueListPresenterImpl(this);
        rockCatalogueListPresenter.displayRockCatalogueList();
    }

    public void initializeRecyclerView(){
        recyclerView = findViewById( R.id.list );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
    }
    @Override
    protected void onResume(){
        super.onResume();
        rockCatalogueListPresenter.start();
    }
    @Override
    public void showProgressDialog() {

    }

    @Override
    public void passDataToAdapter(RockCatalogueModel rockCatalogueModelList) {
        Log.i("ArtistRespose", String.valueOf(rockCatalogueModelList.getResults().get(0).getArtistName()));
        recyclerView.setAdapter( new RockCatalogueAdapter(rockCatalogueModelList, R.layout.row_rockcatalogu, getApplicationContext()) );

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void setPresenter(@NonNull IRockCatalogueListContract.IPresenter presenter) {
        iPresenter = checkNotNull (presenter);

    }
}