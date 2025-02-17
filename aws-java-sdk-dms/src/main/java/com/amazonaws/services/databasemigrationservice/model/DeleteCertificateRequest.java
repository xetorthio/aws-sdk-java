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

package com.amazonaws.services.databasemigrationservice.model;

import java.io.Serializable;
import com.amazonaws.AmazonWebServiceRequest;

/**
 * 
 */
public class DeleteCertificateRequest extends AmazonWebServiceRequest implements
        Serializable, Cloneable {

    /**
     * <p>
     * the Amazon Resource Name (ARN) of the deleted certificate.
     * </p>
     */
    private String certificateArn;

    /**
     * <p>
     * the Amazon Resource Name (ARN) of the deleted certificate.
     * </p>
     * 
     * @param certificateArn
     *        the Amazon Resource Name (ARN) of the deleted certificate.
     */

    public void setCertificateArn(String certificateArn) {
        this.certificateArn = certificateArn;
    }

    /**
     * <p>
     * the Amazon Resource Name (ARN) of the deleted certificate.
     * </p>
     * 
     * @return the Amazon Resource Name (ARN) of the deleted certificate.
     */

    public String getCertificateArn() {
        return this.certificateArn;
    }

    /**
     * <p>
     * the Amazon Resource Name (ARN) of the deleted certificate.
     * </p>
     * 
     * @param certificateArn
     *        the Amazon Resource Name (ARN) of the deleted certificate.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public DeleteCertificateRequest withCertificateArn(String certificateArn) {
        setCertificateArn(certificateArn);
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
        if (getCertificateArn() != null)
            sb.append("CertificateArn: " + getCertificateArn());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DeleteCertificateRequest == false)
            return false;
        DeleteCertificateRequest other = (DeleteCertificateRequest) obj;
        if (other.getCertificateArn() == null
                ^ this.getCertificateArn() == null)
            return false;
        if (other.getCertificateArn() != null
                && other.getCertificateArn().equals(this.getCertificateArn()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime
                * hashCode
                + ((getCertificateArn() == null) ? 0 : getCertificateArn()
                        .hashCode());
        return hashCode;
    }

    @Override
    public DeleteCertificateRequest clone() {
        return (DeleteCertificateRequest) super.clone();
    }
}