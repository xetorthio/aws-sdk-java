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

/**
 * <p>
 * The SSL certificate that can be used to encrypt connections between the
 * endpoints and the replication instance.
 * </p>
 */
public class Certificate implements Serializable, Cloneable {

    /**
     * <p>
     * The customer-assigned name of the certificate. Valid characters are
     * [A-z_0-9].
     * </p>
     */
    private String certificateIdentifier;
    /**
     * <p>
     * the date the certificate was created.
     * </p>
     */
    private java.util.Date certificateCreationDate;
    /**
     * <p>
     * The contents of the .pem X.509 certificate file.
     * </p>
     */
    private String certificatePem;
    /**
     * <p>
     * The Amazon Resource Name (ARN) for the certificate.
     * </p>
     */
    private String certificateArn;
    /**
     * <p>
     * The owner of the certificate.
     * </p>
     */
    private String certificateOwner;
    /**
     * <p>
     * The beginning date the certificate is valid.
     * </p>
     */
    private java.util.Date validFromDate;
    /**
     * <p>
     * the final date the certificate is valid.
     * </p>
     */
    private java.util.Date validToDate;
    /**
     * <p>
     * The signing algorithm for the certificate.
     * </p>
     */
    private String signingAlgorithm;
    /**
     * <p>
     * The key length of the cryptographic algorithm being used.
     * </p>
     */
    private Integer keyLength;

    /**
     * <p>
     * The customer-assigned name of the certificate. Valid characters are
     * [A-z_0-9].
     * </p>
     * 
     * @param certificateIdentifier
     *        The customer-assigned name of the certificate. Valid characters
     *        are [A-z_0-9].
     */

    public void setCertificateIdentifier(String certificateIdentifier) {
        this.certificateIdentifier = certificateIdentifier;
    }

    /**
     * <p>
     * The customer-assigned name of the certificate. Valid characters are
     * [A-z_0-9].
     * </p>
     * 
     * @return The customer-assigned name of the certificate. Valid characters
     *         are [A-z_0-9].
     */

    public String getCertificateIdentifier() {
        return this.certificateIdentifier;
    }

    /**
     * <p>
     * The customer-assigned name of the certificate. Valid characters are
     * [A-z_0-9].
     * </p>
     * 
     * @param certificateIdentifier
     *        The customer-assigned name of the certificate. Valid characters
     *        are [A-z_0-9].
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public Certificate withCertificateIdentifier(String certificateIdentifier) {
        setCertificateIdentifier(certificateIdentifier);
        return this;
    }

    /**
     * <p>
     * the date the certificate was created.
     * </p>
     * 
     * @param certificateCreationDate
     *        the date the certificate was created.
     */

    public void setCertificateCreationDate(
            java.util.Date certificateCreationDate) {
        this.certificateCreationDate = certificateCreationDate;
    }

    /**
     * <p>
     * the date the certificate was created.
     * </p>
     * 
     * @return the date the certificate was created.
     */

    public java.util.Date getCertificateCreationDate() {
        return this.certificateCreationDate;
    }

    /**
     * <p>
     * the date the certificate was created.
     * </p>
     * 
     * @param certificateCreationDate
     *        the date the certificate was created.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public Certificate withCertificateCreationDate(
            java.util.Date certificateCreationDate) {
        setCertificateCreationDate(certificateCreationDate);
        return this;
    }

    /**
     * <p>
     * The contents of the .pem X.509 certificate file.
     * </p>
     * 
     * @param certificatePem
     *        The contents of the .pem X.509 certificate file.
     */

    public void setCertificatePem(String certificatePem) {
        this.certificatePem = certificatePem;
    }

    /**
     * <p>
     * The contents of the .pem X.509 certificate file.
     * </p>
     * 
     * @return The contents of the .pem X.509 certificate file.
     */

    public String getCertificatePem() {
        return this.certificatePem;
    }

    /**
     * <p>
     * The contents of the .pem X.509 certificate file.
     * </p>
     * 
     * @param certificatePem
     *        The contents of the .pem X.509 certificate file.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public Certificate withCertificatePem(String certificatePem) {
        setCertificatePem(certificatePem);
        return this;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) for the certificate.
     * </p>
     * 
     * @param certificateArn
     *        The Amazon Resource Name (ARN) for the certificate.
     */

    public void setCertificateArn(String certificateArn) {
        this.certificateArn = certificateArn;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) for the certificate.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) for the certificate.
     */

    public String getCertificateArn() {
        return this.certificateArn;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) for the certificate.
     * </p>
     * 
     * @param certificateArn
     *        The Amazon Resource Name (ARN) for the certificate.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public Certificate withCertificateArn(String certificateArn) {
        setCertificateArn(certificateArn);
        return this;
    }

    /**
     * <p>
     * The owner of the certificate.
     * </p>
     * 
     * @param certificateOwner
     *        The owner of the certificate.
     */

    public void setCertificateOwner(String certificateOwner) {
        this.certificateOwner = certificateOwner;
    }

    /**
     * <p>
     * The owner of the certificate.
     * </p>
     * 
     * @return The owner of the certificate.
     */

    public String getCertificateOwner() {
        return this.certificateOwner;
    }

    /**
     * <p>
     * The owner of the certificate.
     * </p>
     * 
     * @param certificateOwner
     *        The owner of the certificate.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public Certificate withCertificateOwner(String certificateOwner) {
        setCertificateOwner(certificateOwner);
        return this;
    }

    /**
     * <p>
     * The beginning date the certificate is valid.
     * </p>
     * 
     * @param validFromDate
     *        The beginning date the certificate is valid.
     */

    public void setValidFromDate(java.util.Date validFromDate) {
        this.validFromDate = validFromDate;
    }

    /**
     * <p>
     * The beginning date the certificate is valid.
     * </p>
     * 
     * @return The beginning date the certificate is valid.
     */

    public java.util.Date getValidFromDate() {
        return this.validFromDate;
    }

    /**
     * <p>
     * The beginning date the certificate is valid.
     * </p>
     * 
     * @param validFromDate
     *        The beginning date the certificate is valid.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public Certificate withValidFromDate(java.util.Date validFromDate) {
        setValidFromDate(validFromDate);
        return this;
    }

    /**
     * <p>
     * the final date the certificate is valid.
     * </p>
     * 
     * @param validToDate
     *        the final date the certificate is valid.
     */

    public void setValidToDate(java.util.Date validToDate) {
        this.validToDate = validToDate;
    }

    /**
     * <p>
     * the final date the certificate is valid.
     * </p>
     * 
     * @return the final date the certificate is valid.
     */

    public java.util.Date getValidToDate() {
        return this.validToDate;
    }

    /**
     * <p>
     * the final date the certificate is valid.
     * </p>
     * 
     * @param validToDate
     *        the final date the certificate is valid.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public Certificate withValidToDate(java.util.Date validToDate) {
        setValidToDate(validToDate);
        return this;
    }

    /**
     * <p>
     * The signing algorithm for the certificate.
     * </p>
     * 
     * @param signingAlgorithm
     *        The signing algorithm for the certificate.
     */

    public void setSigningAlgorithm(String signingAlgorithm) {
        this.signingAlgorithm = signingAlgorithm;
    }

    /**
     * <p>
     * The signing algorithm for the certificate.
     * </p>
     * 
     * @return The signing algorithm for the certificate.
     */

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    /**
     * <p>
     * The signing algorithm for the certificate.
     * </p>
     * 
     * @param signingAlgorithm
     *        The signing algorithm for the certificate.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public Certificate withSigningAlgorithm(String signingAlgorithm) {
        setSigningAlgorithm(signingAlgorithm);
        return this;
    }

    /**
     * <p>
     * The key length of the cryptographic algorithm being used.
     * </p>
     * 
     * @param keyLength
     *        The key length of the cryptographic algorithm being used.
     */

    public void setKeyLength(Integer keyLength) {
        this.keyLength = keyLength;
    }

    /**
     * <p>
     * The key length of the cryptographic algorithm being used.
     * </p>
     * 
     * @return The key length of the cryptographic algorithm being used.
     */

    public Integer getKeyLength() {
        return this.keyLength;
    }

    /**
     * <p>
     * The key length of the cryptographic algorithm being used.
     * </p>
     * 
     * @param keyLength
     *        The key length of the cryptographic algorithm being used.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public Certificate withKeyLength(Integer keyLength) {
        setKeyLength(keyLength);
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
        if (getCertificateIdentifier() != null)
            sb.append("CertificateIdentifier: " + getCertificateIdentifier()
                    + ",");
        if (getCertificateCreationDate() != null)
            sb.append("CertificateCreationDate: "
                    + getCertificateCreationDate() + ",");
        if (getCertificatePem() != null)
            sb.append("CertificatePem: " + getCertificatePem() + ",");
        if (getCertificateArn() != null)
            sb.append("CertificateArn: " + getCertificateArn() + ",");
        if (getCertificateOwner() != null)
            sb.append("CertificateOwner: " + getCertificateOwner() + ",");
        if (getValidFromDate() != null)
            sb.append("ValidFromDate: " + getValidFromDate() + ",");
        if (getValidToDate() != null)
            sb.append("ValidToDate: " + getValidToDate() + ",");
        if (getSigningAlgorithm() != null)
            sb.append("SigningAlgorithm: " + getSigningAlgorithm() + ",");
        if (getKeyLength() != null)
            sb.append("KeyLength: " + getKeyLength());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof Certificate == false)
            return false;
        Certificate other = (Certificate) obj;
        if (other.getCertificateIdentifier() == null
                ^ this.getCertificateIdentifier() == null)
            return false;
        if (other.getCertificateIdentifier() != null
                && other.getCertificateIdentifier().equals(
                        this.getCertificateIdentifier()) == false)
            return false;
        if (other.getCertificateCreationDate() == null
                ^ this.getCertificateCreationDate() == null)
            return false;
        if (other.getCertificateCreationDate() != null
                && other.getCertificateCreationDate().equals(
                        this.getCertificateCreationDate()) == false)
            return false;
        if (other.getCertificatePem() == null
                ^ this.getCertificatePem() == null)
            return false;
        if (other.getCertificatePem() != null
                && other.getCertificatePem().equals(this.getCertificatePem()) == false)
            return false;
        if (other.getCertificateArn() == null
                ^ this.getCertificateArn() == null)
            return false;
        if (other.getCertificateArn() != null
                && other.getCertificateArn().equals(this.getCertificateArn()) == false)
            return false;
        if (other.getCertificateOwner() == null
                ^ this.getCertificateOwner() == null)
            return false;
        if (other.getCertificateOwner() != null
                && other.getCertificateOwner().equals(
                        this.getCertificateOwner()) == false)
            return false;
        if (other.getValidFromDate() == null ^ this.getValidFromDate() == null)
            return false;
        if (other.getValidFromDate() != null
                && other.getValidFromDate().equals(this.getValidFromDate()) == false)
            return false;
        if (other.getValidToDate() == null ^ this.getValidToDate() == null)
            return false;
        if (other.getValidToDate() != null
                && other.getValidToDate().equals(this.getValidToDate()) == false)
            return false;
        if (other.getSigningAlgorithm() == null
                ^ this.getSigningAlgorithm() == null)
            return false;
        if (other.getSigningAlgorithm() != null
                && other.getSigningAlgorithm().equals(
                        this.getSigningAlgorithm()) == false)
            return false;
        if (other.getKeyLength() == null ^ this.getKeyLength() == null)
            return false;
        if (other.getKeyLength() != null
                && other.getKeyLength().equals(this.getKeyLength()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime
                * hashCode
                + ((getCertificateIdentifier() == null) ? 0
                        : getCertificateIdentifier().hashCode());
        hashCode = prime
                * hashCode
                + ((getCertificateCreationDate() == null) ? 0
                        : getCertificateCreationDate().hashCode());
        hashCode = prime
                * hashCode
                + ((getCertificatePem() == null) ? 0 : getCertificatePem()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getCertificateArn() == null) ? 0 : getCertificateArn()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getCertificateOwner() == null) ? 0 : getCertificateOwner()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getValidFromDate() == null) ? 0 : getValidFromDate()
                        .hashCode());
        hashCode = prime
                * hashCode
                + ((getValidToDate() == null) ? 0 : getValidToDate().hashCode());
        hashCode = prime
                * hashCode
                + ((getSigningAlgorithm() == null) ? 0 : getSigningAlgorithm()
                        .hashCode());
        hashCode = prime * hashCode
                + ((getKeyLength() == null) ? 0 : getKeyLength().hashCode());
        return hashCode;
    }

    @Override
    public Certificate clone() {
        try {
            return (Certificate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
