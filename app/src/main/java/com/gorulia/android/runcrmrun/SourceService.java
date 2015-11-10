package com.gorulia.android.runcrmrun;

import com.gorulia.android.runcrmrun.POJO.SourceModel;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

public interface SourceService {
    @GET("/api/sources")
    Call<List<SourceModel>> getSources();
}
