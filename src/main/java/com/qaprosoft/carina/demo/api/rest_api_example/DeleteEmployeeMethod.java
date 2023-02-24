package com.qaprosoft.carina.demo.api.rest_api_example;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint( url = "${base_url}/delete/24", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/rest_api_example/employee/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteEmployeeMethod extends AbstractApiMethodV2 {

    public DeleteEmployeeMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_rest_example"));
    }
}
