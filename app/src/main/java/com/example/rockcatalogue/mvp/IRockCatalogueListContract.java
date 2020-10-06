package com.example.rockcatalogue.mvp;

import com.example.rockcatalogue.model.RockCatalogueModel;

import java.util.List;

public interface IRockCatalogueListContract {
    interface IPresenter extends BasePresenter{
        void displayRockCatalogueList();
    }

    interface IView extends BaseView <IPresenter>{
        void showProgressDialog();
        void passDataToAdapter(RockCatalogueModel rockCatalogueModelList);
        void dismissProgressDialog();

    }
}
