package com.qaprosoft.carina.demo.api.DummyJSON;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/1", methodType = HttpMethodType.PUT)
@ResponseTemplatePath(path = "api/dummyJson/todo/_put/rs.json")
@RequestTemplatePath(path = "api/dummyJson/todo/_put/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutToDoMethod extends AbstractApiMethodV2 {

    public PutToDoMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_dummyJSON_url"));
    }
}
