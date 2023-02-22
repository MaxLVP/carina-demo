package com.qaprosoft.carina.demo.api.dummy;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.Header;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/user/${id}", methodType = HttpMethodType.GET)
@Header(key = "app-id", value = "63e9ff7f6450e9fba03746a9")
@ResponseTemplatePath(path = "api/dummy/users/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUserMethod extends AbstractApiMethodV2 {

    public GetUserMethod(String id) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_dummy_url"));
        replaceUrlPlaceholder("id", id);
    }
}
