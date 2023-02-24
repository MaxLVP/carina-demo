package com.qaprosoft.carina.demo.api.DummyJSON;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint( url = "${base_url}/user/1", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/dummyJson/todo/_get/rsuser.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUserToDoMethod extends AbstractApiMethodV2 {

    public GetUserToDoMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_dummyJSON_url"));
    }
}
