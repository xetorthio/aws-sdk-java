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

package com.amazonaws.services.directory.model;

import java.io.Serializable;

/**
 * <p>
 * Result of a VerifyTrust request.
 * </p>
 */
public class VerifyTrustResult implements Serializable, Cloneable {

    /**
     * <p>
     * The unique Trust ID of the trust relationship that was verified.
     * </p>
     */
    private String trustId;

    /**
     * <p>
     * The unique Trust ID of the trust relationship that was verified.
     * </p>
     * 
     * @param trustId
     *        The unique Trust ID of the trust relationship that was verified.
     */

    public void setTrustId(String trustId) {
        this.trustId = trustId;
    }

    /**
     * <p>
     * The unique Trust ID of the trust relationship that was verified.
     * </p>
     * 
     * @return The unique Trust ID of the trust relationship that was verified.
     */

    public String getTrustId() {
        return this.trustId;
    }

    /**
     * <p>
     * The unique Trust ID of the trust relationship that was verified.
     * </p>
     * 
     * @param trustId
     *        The unique Trust ID of the trust relationship that was verified.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public VerifyTrustResult withTrustId(String trustId) {
        setTrustId(trustId);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTrustId() != null)
            sb.append("TrustId: " + getTrustId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof VerifyTrustResult == false)
            return false;
        VerifyTrustResult other = (VerifyTrustResult) obj;
        if (other.getTrustId() == null ^ this.getTrustId() == null)
            return false;
        if (other.getTrustId() != null
                && other.getTrustId().equals(this.getTrustId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getTrustId() == null) ? 0 : getTrustId().hashCode());
        return hashCode;
    }

    @Override
    public VerifyTrustResult clone() {
        try {
            return (VerifyTrustResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
