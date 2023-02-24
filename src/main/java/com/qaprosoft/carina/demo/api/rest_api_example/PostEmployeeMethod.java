package com.qaprosoft.carina.demo.api.rest_api_example;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint( url = "${base_url}/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/rest_api_example/employee/_post/rq.json")
@ResponseTemplatePath(path = "api/rest_api_example/employee/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostEmployeeMethod extends AbstractApiMethodV2 {

    public PostEmployeeMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_rest_example"));
    }
}
