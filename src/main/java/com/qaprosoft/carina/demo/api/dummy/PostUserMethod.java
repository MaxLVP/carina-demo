package com.qaprosoft.carina.demo.api.dummy;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/user/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/dummy/users/_post/rq.json")
@Header(key = "app-id", value = "63e9ff7f6450e9fba03746a9")
@ResponseTemplatePath(path = "api/dummy/users/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostUserMethod extends AbstractApiMethodV2 {

    public PostUserMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_dummy_url"));
    }
}
