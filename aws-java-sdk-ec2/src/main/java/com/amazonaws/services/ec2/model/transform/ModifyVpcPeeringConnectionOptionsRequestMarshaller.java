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

package com.amazonaws.services.ec2.model.transform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.ec2.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.IdempotentUtils;

/**
 * ModifyVpcPeeringConnectionOptionsRequest Marshaller
 */

public class ModifyVpcPeeringConnectionOptionsRequestMarshaller
        implements
        Marshaller<Request<ModifyVpcPeeringConnectionOptionsRequest>, ModifyVpcPeeringConnectionOptionsRequest> {

    public Request<ModifyVpcPeeringConnectionOptionsRequest> marshall(
            ModifyVpcPeeringConnectionOptionsRequest modifyVpcPeeringConnectionOptionsRequest) {

        if (modifyVpcPeeringConnectionOptionsRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<ModifyVpcPeeringConnectionOptionsRequest> request = new DefaultRequest<ModifyVpcPeeringConnectionOptionsRequest>(
                modifyVpcPeeringConnectionOptionsRequest, "AmazonEC2");
        request.addParameter("Action", "ModifyVpcPeeringConnectionOptions");
        request.addParameter("Version", "2016-04-01");
        request.setHttpMethod(HttpMethodName.POST);

        if (modifyVpcPeeringConnectionOptionsRequest
                .getVpcPeeringConnectionId() != null) {
            request.addParameter("VpcPeeringConnectionId", StringUtils
                    .fromString(modifyVpcPeeringConnectionOptionsRequest
                            .getVpcPeeringConnectionId()));
        }

        PeeringConnectionOptionsRequest requesterPeeringConnectionOptions = modifyVpcPeeringConnectionOptionsRequest
                .getRequesterPeeringConnectionOptions();
        if (requesterPeeringConnectionOptions != null) {

            if (requesterPeeringConnectionOptions
                    .getAllowEgressFromLocalClassicLinkToRemoteVpc() != null) {
                request.addParameter(
                        "RequesterPeeringConnectionOptions.AllowEgressFromLocalClassicLinkToRemoteVpc",
                        StringUtils.fromBoolean(requesterPeeringConnectionOptions
                                .getAllowEgressFromLocalClassicLinkToRemoteVpc()));
            }

            if (requesterPeeringConnectionOptions
                    .getAllowEgressFromLocalVpcToRemoteClassicLink() != null) {
                request.addParameter(
                        "RequesterPeeringConnectionOptions.AllowEgressFromLocalVpcToRemoteClassicLink",
                        StringUtils.fromBoolean(requesterPeeringConnectionOptions
                                .getAllowEgressFromLocalVpcToRemoteClassicLink()));
            }
        }

        PeeringConnectionOptionsRequest accepterPeeringConnectionOptions = modifyVpcPeeringConnectionOptionsRequest
                .getAccepterPeeringConnectionOptions();
        if (accepterPeeringConnectionOptions != null) {

            if (accepterPeeringConnectionOptions
                    .getAllowEgressFromLocalClassicLinkToRemoteVpc() != null) {
                request.addParameter(
                        "AccepterPeeringConnectionOptions.AllowEgressFromLocalClassicLinkToRemoteVpc",
                        StringUtils.fromBoolean(accepterPeeringConnectionOptions
                                .getAllowEgressFromLocalClassicLinkToRemoteVpc()));
            }

            if (accepterPeeringConnectionOptions
                    .getAllowEgressFromLocalVpcToRemoteClassicLink() != null) {
                request.addParameter(
                        "AccepterPeeringConnectionOptions.AllowEgressFromLocalVpcToRemoteClassicLink",
                        StringUtils.fromBoolean(accepterPeeringConnectionOptions
                                .getAllowEgressFromLocalVpcToRemoteClassicLink()));
            }
        }

        return request;
    }

}
