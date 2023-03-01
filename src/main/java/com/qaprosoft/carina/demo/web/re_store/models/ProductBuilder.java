package com.qaprosoft.carina.demo.web.re_store.models;

import com.zebrunner.carina.utils.R;

public class ProductBuilder {

    public static Product getProduct() {
        Product product = new Product();
        product.setId(R.TESTDATA.get("re_store_product_id"));
        product.setBrand(R.TESTDATA.get("re_store_product_brand"));
        product.setPrice(Double.valueOf(R.TESTDATA.get("re_store_product_price")));
        return product;
    }
}
