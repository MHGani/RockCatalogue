package com.example.rockcatalogue.network;

import com.example.rockcatalogue.model.RockCatalogueModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET(Constants.ROCKCATALOGUE_LIST_API)
    Observable <RockCatalogueModel>getRockCatalogueList();

}
