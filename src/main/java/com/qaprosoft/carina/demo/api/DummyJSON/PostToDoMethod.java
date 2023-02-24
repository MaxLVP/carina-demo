package com.qaprosoft.carina.demo.api.DummyJSON;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint( url = "${base_url}/add", methodType = HttpMethodType.POST)
@ResponseTemplatePath(path = "api/dummyJson/todo/_post/rs.json")
@RequestTemplatePath(path = "api/dummyJson/todo/_post/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostToDoMethod extends AbstractApiMethodV2 {

    public PostToDoMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_dummyJSON_url"));
    }
}
