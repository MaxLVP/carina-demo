package com.qaprosoft.carina.demo.mobile.bellewhole.models;

import com.zebrunner.carina.utils.R;

public class DressBuilder {

    public static DressModel getTestDress() {
        DressModel dressModel = new DressModel();
        dressModel.setId(R.TESTDATA.get("belle_dress_id"));
        dressModel.setPrice(Double.valueOf(R.TESTDATA.get("belle_dress_price")));
        dressModel.setLength(R.TESTDATA.get("belle_dress_length"));
        dressModel.setMaterial(R.TESTDATA.get("belle_dress_material"));
        dressModel.setStyle(R.TESTDATA.get("belle_dress_style"));
        return dressModel;
    }
}
