/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.route53domains.model.transform;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.route53domains.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.protocol.json.*;

/**
 * UpdateTagsForDomainRequest Marshaller
 */
public class UpdateTagsForDomainRequestMarshaller
        implements
        Marshaller<Request<UpdateTagsForDomainRequest>, UpdateTagsForDomainRequest> {

    private final SdkJsonProtocolFactory protocolFactory;

    public UpdateTagsForDomainRequestMarshaller(
            SdkJsonProtocolFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<UpdateTagsForDomainRequest> marshall(
            UpdateTagsForDomainRequest updateTagsForDomainRequest) {

        if (updateTagsForDomainRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<UpdateTagsForDomainRequest> request = new DefaultRequest<UpdateTagsForDomainRequest>(
                updateTagsForDomainRequest, "AmazonRoute53Domains");
        request.addHeader("X-Amz-Target",
                "Route53Domains_v20140515.UpdateTagsForDomain");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory
                    .createGenerator();

            jsonGenerator.writeStartObject();

            if (updateTagsForDomainRequest.getDomainName() != null) {
                jsonGenerator.writeFieldName("DomainName").writeValue(
                        updateTagsForDomainRequest.getDomainName());
            }

            com.amazonaws.internal.SdkInternalList<Tag> tagsToUpdateList = (com.amazonaws.internal.SdkInternalList<Tag>) updateTagsForDomainRequest
                    .getTagsToUpdate();
            if (!tagsToUpdateList.isEmpty()
                    || !tagsToUpdateList.isAutoConstruct()) {
                jsonGenerator.writeFieldName("TagsToUpdate");
                jsonGenerator.writeStartArray();
                for (Tag tagsToUpdateListValue : tagsToUpdateList) {
                    if (tagsToUpdateListValue != null) {

                        TagJsonMarshaller.getInstance().marshall(
                                tagsToUpdateListValue, jsonGenerator);
                    }
                }
                jsonGenerator.writeEndArray();
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length",
                    Integer.toString(content.length));
            request.addHeader("Content-Type", protocolFactory.getContentType());
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
