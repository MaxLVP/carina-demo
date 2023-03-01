package com.qaprosoft.carina.demo.web.re_store.models;

import com.zebrunner.carina.utils.R;

public class ProductBuilder {

    public static Product getProduct() {
        String id = R.TESTDATA.get("re_store_product_id");
        String name = R.TESTDATA.get("re_store_product_name");
        String brand = R.TESTDATA.get("re_store_product_brand");
        Double price = Double.valueOf(R.TESTDATA.get("re_store_product_price"));
        return new Product(id, name, price, brand);
    }
}
