package com.qaprosoft.carina.demo.web.re_store.models;

import com.zebrunner.carina.utils.R;

public class UserBuilder {

    public static User getUser() {
        String name = R.TESTDATA.get("re_store_name");
        String email = R.TESTDATA.get("re_store_email");
        String phone = R.TESTDATA.get("re_store_phone");
        String password = R.TESTDATA.get("re_store_password");
        return new User(name, email, phone, password);
    }
}
