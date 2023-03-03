package com.qaprosoft.carina.demo.web.re_store.models;

import com.zebrunner.carina.utils.R;

public class UserBuilder {

    public static User getUser() {
        User user = new User();
        user.setFirstName(R.TESTDATA.get("re_store_name"));
        user.setEmail(R.TESTDATA.get("re_store_email"));
        user.setPhone(R.TESTDATA.get("re_store_phone"));
        user.setPassword(R.TESTDATA.get("re_store_password"));
        return user;
    }
}
