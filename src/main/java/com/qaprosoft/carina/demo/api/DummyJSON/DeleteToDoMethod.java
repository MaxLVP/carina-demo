package com.qaprosoft.carina.demo.api.DummyJSON;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/1", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/dummyJson/todo/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteToDoMethod extends AbstractApiMethodV2 {

    public DeleteToDoMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_dummyJSON_url"));
    }
}
