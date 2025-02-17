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

package com.amazonaws.services.workspaces.model;

import com.amazonaws.AmazonServiceException;

/**
 * <p>
 * The resource could not be found.
 * </p>
 */
public class ResourceNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1L;

    /**
     * <p>
     * The resource could not be found.
     * </p>
     */
    private String resourceId;

    /**
     * Constructs a new ResourceNotFoundException with the specified error
     * message.
     *
     * @param message
     *        Describes the error encountered.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * <p>
     * The resource could not be found.
     * </p>
     * 
     * @param resourceId
     *        The resource could not be found.
     */

    @com.fasterxml.jackson.annotation.JsonProperty("ResourceId")
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * <p>
     * The resource could not be found.
     * </p>
     * 
     * @return The resource could not be found.
     */

    @com.fasterxml.jackson.annotation.JsonProperty("ResourceId")
    public String getResourceId() {
        return this.resourceId;
    }

    /**
     * <p>
     * The resource could not be found.
     * </p>
     * 
     * @param resourceId
     *        The resource could not be found.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public ResourceNotFoundException withResourceId(String resourceId) {
        setResourceId(resourceId);
        return this;
    }

}