package com.qaprosoft.carina.demo.api.dummy;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/user/${id}", methodType = HttpMethodType.PUT)
@ResponseTemplatePath(path = "api/dummy/users/_put/rs.json")
@RequestTemplatePath(path = "api/dummy/users/_put/rq.json")
@Header(key = "app-id", value = "63e9ff7f6450e9fba03746a9")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutUserMethod extends AbstractApiMethodV2 {

    public PutUserMethod(String id) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_dummy_url"));
        replaceUrlPlaceholder("id", id);
    }
}
