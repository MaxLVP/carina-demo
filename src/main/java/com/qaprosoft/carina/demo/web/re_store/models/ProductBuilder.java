package com.qaprosoft.carina.demo.web.re_store.models;

import com.zebrunner.carina.utils.R;

public class ProductBuilder {

    public static Product getFirstProduct() {
        Product product = new Product();
        product.setId(R.TESTDATA.get("re_store_first_product_id"));
        product.setBrand(R.TESTDATA.get("re_store_first_product_brand"));
        product.setPrice(Double.valueOf(R.TESTDATA.get("re_store_first_product_price")));
        return product;
    }

    public static Product getSecondProduct() {
        Product product = new Product();
        product.setId(R.TESTDATA.get("re_store_second_product_id"));
        product.setBrand(R.TESTDATA.get("re_store_second_product_brand"));
        product.setPrice(Double.valueOf(R.TESTDATA.get("re_store_second_product_price")));
        return product;
    }

    public static Product getThirdProduct() {
        Product product = new Product();
        product.setId(R.TESTDATA.get("re_store_third_product_id"));
        product.setBrand(R.TESTDATA.get("re_store_third_product_brand"));
        product.setPrice(Double.valueOf(R.TESTDATA.get("re_store_third_product_price")));
        return product;
    }
}
