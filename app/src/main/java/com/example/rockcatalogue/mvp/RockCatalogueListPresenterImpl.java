package com.example.rockcatalogue.mvp;

import com.example.rockcatalogue.MainActivity;
import com.example.rockcatalogue.model.RockCatalogueModel;
import com.example.rockcatalogue.network.ApiClient;
import com.example.rockcatalogue.network.ApiInterface;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RockCatalogueListPresenterImpl implements IRockCatalogueListContract.IPresenter {

    IRockCatalogueListContract.IView iView;
    private ApiInterface apiInterface = ApiClient.getRetrofit().create( ApiInterface.class);

    public RockCatalogueListPresenterImpl(IRockCatalogueListContract.IView IView) {
         this.iView= IView;
    }

    @Override
    public void displayRockCatalogueList() {
        apiInterface.getRockCatalogueList()
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer <RockCatalogueModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RockCatalogueModel rockCatalogueModel) {
                        iView.passDataToAdapter( rockCatalogueModel );
                    }

                    @Override
                    public void onError(Throwable e) {
                        iView.dismissProgressDialog();
                    }

                    @Override
                    public void onComplete() {
                        iView.dismissProgressDialog();
                    }
                } );

    }

    @Override
    public void start() {
        iView.setPresenter( RockCatalogueListPresenterImpl.this );
    }
}
