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
package com.amazonaws.services.glacier;

import org.w3c.dom.*;

import java.net.*;
import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.logging.*;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.protocol.json.*;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.client.AwsSyncClientParams;

import com.amazonaws.services.glacier.model.*;
import com.amazonaws.services.glacier.model.transform.*;

/**
 * Client for accessing Amazon Glacier. All service calls made using this client
 * are blocking, and will not return until the service call completes.
 * <p>
 * <p>
 * Amazon Glacier is a storage solution for "cold data."
 * </p>
 * <p>
 * Amazon Glacier is an extremely low-cost storage service that provides secure,
 * durable, and easy-to-use storage for data backup and archival. With Amazon
 * Glacier, customers can store their data cost effectively for months, years,
 * or decades. Amazon Glacier also enables customers to offload the
 * administrative burdens of operating and scaling storage to AWS, so they don't
 * have to worry about capacity planning, hardware provisioning, data
 * replication, hardware failure and recovery, or time-consuming hardware
 * migrations.
 * </p>
 * <p>
 * Amazon Glacier is a great storage choice when low storage cost is paramount,
 * your data is rarely retrieved, and retrieval latency of several hours is
 * acceptable. If your application requires fast or frequent access to your
 * data, consider using Amazon S3. For more information, go to <a
 * href="http://aws.amazon.com/s3/">Amazon Simple Storage Service (Amazon
 * S3)</a>.
 * </p>
 * <p>
 * You can store any kind of data in any format. There is no maximum limit on
 * the total amount of data you can store in Amazon Glacier.
 * </p>
 * <p>
 * If you are a first-time user of Amazon Glacier, we recommend that you begin
 * by reading the following sections in the <i>Amazon Glacier Developer
 * Guide</i>:
 * </p>
 * <ul>
 * <li>
 * <p>
 * <a href=
 * "http://docs.aws.amazon.com/amazonglacier/latest/dev/introduction.html">What
 * is Amazon Glacier</a> - This section of the Developer Guide describes the
 * underlying data model, the operations it supports, and the AWS SDKs that you
 * can use to interact with the service.
 * </p>
 * </li>
 * <li>
 * <p>
 * <a href=
 * "http://docs.aws.amazon.com/amazonglacier/latest/dev/amazon-glacier-getting-started.html"
 * >Getting Started with Amazon Glacier</a> - The Getting Started section walks
 * you through the process of creating a vault, uploading archives, creating
 * jobs to download archives, retrieving the job output, and deleting archives.
 * </p>
 * </li>
 * </ul>
 */
@ThreadSafe
public class AmazonGlacierClient extends AmazonWebServiceClient implements
        AmazonGlacier {
    /** Provider for AWS credentials. */
    private final AWSCredentialsProvider awsCredentialsProvider;

    private static final Log log = LogFactory.getLog(AmazonGlacier.class);

    /** Default signing name for the service. */
    private static final String DEFAULT_SIGNING_NAME = "glacier";

    /**
     * Client configuration factory providing ClientConfigurations tailored to
     * this client
     */
    protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();

    private final SdkJsonProtocolFactory protocolFactory = new SdkJsonProtocolFactory(
            new JsonClientMetadata()
                    .withProtocolVersion("1.1")
                    .withSupportsCbor(false)
                    .withContentTypeOverride("")
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("RequestTimeoutException")
                                    .withModeledClass(
                                            com.amazonaws.services.glacier.model.RequestTimeoutException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode(
                                            "MissingParameterValueException")
                                    .withModeledClass(
                                            com.amazonaws.services.glacier.model.MissingParameterValueException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode(
                                            "InvalidParameterValueException")
                                    .withModeledClass(
                                            com.amazonaws.services.glacier.model.InvalidParameterValueException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("ResourceNotFoundException")
                                    .withModeledClass(
                                            com.amazonaws.services.glacier.model.ResourceNotFoundException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode(
                                            "ServiceUnavailableException")
                                    .withModeledClass(
                                            com.amazonaws.services.glacier.model.ServiceUnavailableException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("LimitExceededException")
                                    .withModeledClass(
                                            com.amazonaws.services.glacier.model.LimitExceededException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("PolicyEnforcedException")
                                    .withModeledClass(
                                            com.amazonaws.services.glacier.model.PolicyEnforcedException.class)));

    /**
     * Constructs a new client to invoke service methods on Amazon Glacier. A
     * credentials provider chain will be used that searches for credentials in
     * this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonGlacierClient() {
        this(new DefaultAWSCredentialsProviderChain(), configFactory
                .getConfig());
    }

    /**
     * Constructs a new client to invoke service methods on Amazon Glacier. A
     * credentials provider chain will be used that searches for credentials in
     * this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param clientConfiguration
     *        The client configuration options controlling how this client
     *        connects to Amazon Glacier (ex: proxy settings, retry counts,
     *        etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonGlacierClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on Amazon Glacier using
     * the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     */
    public AmazonGlacierClient(AWSCredentials awsCredentials) {
        this(awsCredentials, configFactory.getConfig());
    }

    /**
     * Constructs a new client to invoke service methods on Amazon Glacier using
     * the specified AWS account credentials and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     * @param clientConfiguration
     *        The client configuration options controlling how this client
     *        connects to Amazon Glacier (ex: proxy settings, retry counts,
     *        etc.).
     */
    public AmazonGlacierClient(AWSCredentials awsCredentials,
            ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(
                awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on Amazon Glacier using
     * the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     */
    public AmazonGlacierClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, configFactory.getConfig());
    }

    /**
     * Constructs a new client to invoke service methods on Amazon Glacier using
     * the specified AWS account credentials provider and client configuration
     * options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @param clientConfiguration
     *        The client configuration options controlling how this client
     *        connects to Amazon Glacier (ex: proxy settings, retry counts,
     *        etc.).
     */
    public AmazonGlacierClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on Amazon Glacier using
     * the specified AWS account credentials provider, client configuration
     * options, and request metric collector.
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @param clientConfiguration
     *        The client configuration options controlling how this client
     *        connects to Amazon Glacier (ex: proxy settings, retry counts,
     *        etc.).
     * @param requestMetricCollector
     *        optional request metric collector
     */
    public AmazonGlacierClient(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(clientConfiguration, requestMetricCollector);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    /**
     * Constructs a new client to invoke service methods on Amazon Glacier using
     * the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    AmazonGlacierClient(AwsSyncClientParams clientParams) {
        super(clientParams);
        this.awsCredentialsProvider = clientParams.getCredentialsProvider();
        init();
    }

    private void init() {
        setServiceNameIntern(DEFAULT_SIGNING_NAME);
        setEndpointPrefix(ENDPOINT_PREFIX);
        // calling this.setEndPoint(...) will also modify the signer accordingly
        setEndpoint("https://glacier.us-east-1.amazonaws.com");
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s
                .addAll(chainFactory
                        .newRequestHandlerChain("/com/amazonaws/services/glacier/request.handlers"));
        requestHandler2s
                .addAll(chainFactory
                        .newRequestHandler2Chain("/com/amazonaws/services/glacier/request.handler2s"));
    }

    /**
     * <p>
     * This operation aborts a multipart upload identified by the upload ID.
     * </p>
     * <p>
     * After the Abort Multipart Upload request succeeds, you cannot upload any
     * more parts to the multipart upload or complete the multipart upload.
     * Aborting a completed upload fails. However, aborting an already-aborted
     * upload will succeed, for a short time. For more information about
     * uploading a part and completing a multipart upload, see
     * <a>UploadMultipartPart</a> and <a>CompleteMultipartUpload</a>.
     * </p>
     * <p>
     * This operation is idempotent.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/working-with-archives.html"
     * >Working with Archives in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-multipart-abort-upload.html"
     * >Abort Multipart Upload</a> in the <i>Amazon Glacier Developer Guide</i>.
     * </p>
     * 
     * @param abortMultipartUploadRequest
     *        Provides options to abort a multipart upload identified by the
     *        upload ID. </p>
     *        <p>
     *        For information about the underlying REST API, go to <a href=
     *        "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-multipart-abort-upload.html"
     *        >Abort Multipart Upload</a>. For conceptual information, go to <a
     *        href=
     *        "http://docs.aws.amazon.com/amazonglacier/latest/dev/working-with-archives.html"
     *        >Working with Archives in Amazon Glacier</a>.
     * @return Result of the AbortMultipartUpload operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.AbortMultipartUpload
     */
    @Override
    public AbortMultipartUploadResult abortMultipartUpload(
            AbortMultipartUploadRequest abortMultipartUploadRequest) {
        ExecutionContext executionContext = createExecutionContext(abortMultipartUploadRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AbortMultipartUploadRequest> request = null;
        Response<AbortMultipartUploadResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AbortMultipartUploadRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(abortMultipartUploadRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<AbortMultipartUploadResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new AbortMultipartUploadResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation aborts the vault locking process if the vault lock is not
     * in the <code>Locked</code> state. If the vault lock is in the
     * <code>Locked</code> state when this operation is requested, the operation
     * returns an <code>AccessDeniedException</code> error. Aborting the vault
     * locking process removes the vault lock policy from the specified vault.
     * </p>
     * <p>
     * A vault lock is put into the <code>InProgress</code> state by calling
     * <a>InitiateVaultLock</a>. A vault lock is put into the
     * <code>Locked</code> state by calling <a>CompleteVaultLock</a>. You can
     * get the state of a vault lock by calling <a>GetVaultLock</a>. For more
     * information about the vault locking process, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-lock.html"
     * >Amazon Glacier Vault Lock</a>. For more information about vault lock
     * policies, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-lock-policy.html"
     * >Amazon Glacier Access Control with Vault Lock Policies</a>.
     * </p>
     * <p>
     * This operation is idempotent. You can successfully invoke this operation
     * multiple times, if the vault lock is in the <code>InProgress</code> state
     * or if there is no policy associated with the vault.
     * </p>
     * 
     * @param abortVaultLockRequest
     *        The input values for <code>AbortVaultLock</code>.
     * @return Result of the AbortVaultLock operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.AbortVaultLock
     */
    @Override
    public AbortVaultLockResult abortVaultLock(
            AbortVaultLockRequest abortVaultLockRequest) {
        ExecutionContext executionContext = createExecutionContext(abortVaultLockRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AbortVaultLockRequest> request = null;
        Response<AbortVaultLockResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AbortVaultLockRequestMarshaller(protocolFactory)
                        .marshall(super
                                .beforeMarshalling(abortVaultLockRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<AbortVaultLockResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new AbortVaultLockResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation adds the specified tags to a vault. Each tag is composed
     * of a key and a value. Each vault can have up to 10 tags. If your request
     * would cause the tag limit for the vault to be exceeded, the operation
     * throws the <code>LimitExceededException</code> error. If a tag already
     * exists on the vault under a specified key, the existing key value will be
     * overwritten. For more information about tags, see <a
     * href="http://docs.aws.amazon.com/amazonglacier/latest/dev/tagging.html"
     * >Tagging Amazon Glacier Resources</a>.
     * </p>
     * 
     * @param addTagsToVaultRequest
     *        The input values for <code>AddTagsToVault</code>.
     * @return Result of the AddTagsToVault operation returned by the service.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws LimitExceededException
     *         Returned if the request results in a vault or account limit being
     *         exceeded.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.AddTagsToVault
     */
    @Override
    public AddTagsToVaultResult addTagsToVault(
            AddTagsToVaultRequest addTagsToVaultRequest) {
        ExecutionContext executionContext = createExecutionContext(addTagsToVaultRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<AddTagsToVaultRequest> request = null;
        Response<AddTagsToVaultResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new AddTagsToVaultRequestMarshaller(protocolFactory)
                        .marshall(super
                                .beforeMarshalling(addTagsToVaultRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<AddTagsToVaultResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new AddTagsToVaultResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * You call this operation to inform Amazon Glacier that all the archive
     * parts have been uploaded and that Amazon Glacier can now assemble the
     * archive from the uploaded parts. After assembling and saving the archive
     * to the vault, Amazon Glacier returns the URI path of the newly created
     * archive resource. Using the URI path, you can then access the archive.
     * After you upload an archive, you should save the archive ID returned to
     * retrieve the archive at a later point. You can also get the vault
     * inventory to obtain a list of archive IDs in a vault. For more
     * information, see <a>InitiateJob</a>.
     * </p>
     * <p>
     * In the request, you must include the computed SHA256 tree hash of the
     * entire archive you have uploaded. For information about computing a
     * SHA256 tree hash, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/checksum-calculations.html"
     * >Computing Checksums</a>. On the server side, Amazon Glacier also
     * constructs the SHA256 tree hash of the assembled archive. If the values
     * match, Amazon Glacier saves the archive to the vault; otherwise, it
     * returns an error, and the operation fails. The <a>ListParts</a> operation
     * returns a list of parts uploaded for a specific multipart upload. It
     * includes checksum information for each uploaded part that can be used to
     * debug a bad checksum issue.
     * </p>
     * <p>
     * Additionally, Amazon Glacier also checks for any missing content ranges
     * when assembling the archive, if missing content ranges are found, Amazon
     * Glacier returns an error and the operation fails.
     * </p>
     * <p>
     * Complete Multipart Upload is an idempotent operation. After your first
     * successful complete multipart upload, if you call the operation again
     * within a short period, the operation will succeed and return the same
     * archive ID. This is useful in the event you experience a network issue
     * that causes an aborted connection or receive a 500 server error, in which
     * case you can repeat your Complete Multipart Upload request and get the
     * same archive ID without creating duplicate archives. Note, however, that
     * after the multipart upload completes, you cannot call the List Parts
     * operation and the multipart upload will not appear in List Multipart
     * Uploads response, even if idempotent complete is possible.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/uploading-archive-mpu.html"
     * >Uploading Large Archives in Parts (Multipart Upload)</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-multipart-complete-upload.html"
     * >Complete Multipart Upload</a> in the <i>Amazon Glacier Developer
     * Guide</i>.
     * </p>
     * 
     * @param completeMultipartUploadRequest
     *        Provides options to complete a multipart upload operation. This
     *        informs Amazon Glacier that all the archive parts have been
     *        uploaded and Amazon Glacier can now assemble the archive from the
     *        uploaded parts. After assembling and saving the archive to the
     *        vault, Amazon Glacier returns the URI path of the newly created
     *        archive resource.
     * @return Result of the CompleteMultipartUpload operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.CompleteMultipartUpload
     */
    @Override
    public CompleteMultipartUploadResult completeMultipartUpload(
            CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        ExecutionContext executionContext = createExecutionContext(completeMultipartUploadRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CompleteMultipartUploadRequest> request = null;
        Response<CompleteMultipartUploadResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CompleteMultipartUploadRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(completeMultipartUploadRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CompleteMultipartUploadResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new CompleteMultipartUploadResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation completes the vault locking process by transitioning the
     * vault lock from the <code>InProgress</code> state to the
     * <code>Locked</code> state, which causes the vault lock policy to become
     * unchangeable. A vault lock is put into the <code>InProgress</code> state
     * by calling <a>InitiateVaultLock</a>. You can obtain the state of the
     * vault lock by calling <a>GetVaultLock</a>. For more information about the
     * vault locking process, <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-lock.html"
     * >Amazon Glacier Vault Lock</a>.
     * </p>
     * <p>
     * This operation is idempotent. This request is always successful if the
     * vault lock is in the <code>Locked</code> state and the provided lock ID
     * matches the lock ID originally used to lock the vault.
     * </p>
     * <p>
     * If an invalid lock ID is passed in the request when the vault lock is in
     * the <code>Locked</code> state, the operation returns an
     * <code>AccessDeniedException</code> error. If an invalid lock ID is passed
     * in the request when the vault lock is in the <code>InProgress</code>
     * state, the operation throws an <code>InvalidParameter</code> error.
     * </p>
     * 
     * @param completeVaultLockRequest
     *        The input values for <code>CompleteVaultLock</code>.
     * @return Result of the CompleteVaultLock operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.CompleteVaultLock
     */
    @Override
    public CompleteVaultLockResult completeVaultLock(
            CompleteVaultLockRequest completeVaultLockRequest) {
        ExecutionContext executionContext = createExecutionContext(completeVaultLockRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CompleteVaultLockRequest> request = null;
        Response<CompleteVaultLockResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CompleteVaultLockRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(completeVaultLockRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CompleteVaultLockResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new CompleteVaultLockResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation creates a new vault with the specified name. The name of
     * the vault must be unique within a region for an AWS account. You can
     * create up to 1,000 vaults per account. If you need to create more vaults,
     * contact Amazon Glacier.
     * </p>
     * <p>
     * You must use the following guidelines when naming a vault.
     * </p>
     * <p>
     * <ul>
     * <li>
     * <p>
     * Names can be between 1 and 255 characters long.
     * </p>
     * </li>
     * <li>
     * <p>
     * Allowed characters are a-z, A-Z, 0-9, '_' (underscore), '-' (hyphen), and
     * '.' (period).
     * </p>
     * </li>
     * </ul>
     * </p>
     * <p>
     * This operation is idempotent.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/creating-vaults.html"
     * >Creating a Vault in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-vault-put.html"
     * >Create Vault </a> in the <i>Amazon Glacier Developer Guide</i>.
     * </p>
     * 
     * @param createVaultRequest
     *        Provides options to create a vault.
     * @return Result of the CreateVault operation returned by the service.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @throws LimitExceededException
     *         Returned if the request results in a vault or account limit being
     *         exceeded.
     * @sample AmazonGlacier.CreateVault
     */
    @Override
    public CreateVaultResult createVault(CreateVaultRequest createVaultRequest) {
        ExecutionContext executionContext = createExecutionContext(createVaultRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<CreateVaultRequest> request = null;
        Response<CreateVaultResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new CreateVaultRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(createVaultRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<CreateVaultResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new CreateVaultResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation deletes an archive from a vault. Subsequent requests to
     * initiate a retrieval of this archive will fail. Archive retrievals that
     * are in progress for this archive ID may or may not succeed according to
     * the following scenarios:
     * </p>
     * <ul>
     * <li>If the archive retrieval job is actively preparing the data for
     * download when Amazon Glacier receives the delete archive request, the
     * archival retrieval operation might fail.</li>
     * <li>If the archive retrieval job has successfully prepared the archive
     * for download when Amazon Glacier receives the delete archive request, you
     * will be able to download the output.</li>
     * </ul>
     * <p>
     * This operation is idempotent. Attempting to delete an already-deleted
     * archive does not result in an error.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/deleting-an-archive.html"
     * >Deleting an Archive in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-archive-delete.html"
     * >Delete Archive</a> in the <i>Amazon Glacier Developer Guide</i>.
     * </p>
     * 
     * @param deleteArchiveRequest
     *        Provides options for deleting an archive from an Amazon Glacier
     *        vault.
     * @return Result of the DeleteArchive operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.DeleteArchive
     */
    @Override
    public DeleteArchiveResult deleteArchive(
            DeleteArchiveRequest deleteArchiveRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteArchiveRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteArchiveRequest> request = null;
        Response<DeleteArchiveResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteArchiveRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(deleteArchiveRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteArchiveResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new DeleteArchiveResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation deletes a vault. Amazon Glacier will delete a vault only
     * if there are no archives in the vault as of the last inventory and there
     * have been no writes to the vault since the last inventory. If either of
     * these conditions is not satisfied, the vault deletion fails (that is, the
     * vault is not removed) and Amazon Glacier returns an error. You can use
     * <a>DescribeVault</a> to return the number of archives in a vault, and you
     * can use <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-initiate-job-post.html"
     * >Initiate a Job (POST jobs)</a> to initiate a new inventory retrieval for
     * a vault. The inventory contains the archive IDs you use to delete
     * archives using <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-archive-delete.html"
     * >Delete Archive (DELETE archive)</a>.
     * </p>
     * <p>
     * This operation is idempotent.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/deleting-vaults.html"
     * >Deleting a Vault in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-vault-delete.html"
     * >Delete Vault </a> in the <i>Amazon Glacier Developer Guide</i>.
     * </p>
     * 
     * @param deleteVaultRequest
     *        Provides options for deleting a vault from Amazon Glacier.
     * @return Result of the DeleteVault operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.DeleteVault
     */
    @Override
    public DeleteVaultResult deleteVault(DeleteVaultRequest deleteVaultRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteVaultRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVaultRequest> request = null;
        Response<DeleteVaultResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVaultRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(deleteVaultRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteVaultResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new DeleteVaultResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation deletes the access policy associated with the specified
     * vault. The operation is eventually consistent; that is, it might take
     * some time for Amazon Glacier to completely remove the access policy, and
     * you might still see the effect of the policy for a short time after you
     * send the delete request.
     * </p>
     * <p>
     * This operation is idempotent. You can invoke delete multiple times, even
     * if there is no policy associated with the vault. For more information
     * about vault access policies, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-access-policy.html"
     * >Amazon Glacier Access Control with Vault Access Policies</a>.
     * </p>
     * 
     * @param deleteVaultAccessPolicyRequest
     *        DeleteVaultAccessPolicy input.
     * @return Result of the DeleteVaultAccessPolicy operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.DeleteVaultAccessPolicy
     */
    @Override
    public DeleteVaultAccessPolicyResult deleteVaultAccessPolicy(
            DeleteVaultAccessPolicyRequest deleteVaultAccessPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteVaultAccessPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVaultAccessPolicyRequest> request = null;
        Response<DeleteVaultAccessPolicyResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVaultAccessPolicyRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(deleteVaultAccessPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteVaultAccessPolicyResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new DeleteVaultAccessPolicyResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation deletes the notification configuration set for a vault.
     * The operation is eventually consistent; that is, it might take some time
     * for Amazon Glacier to completely disable the notifications and you might
     * still receive some notifications for a short time after you send the
     * delete request.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/configuring-notifications.html"
     * >Configuring Vault Notifications in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-vault-notifications-delete.html"
     * >Delete Vault Notification Configuration </a> in the Amazon Glacier
     * Developer Guide.
     * </p>
     * 
     * @param deleteVaultNotificationsRequest
     *        Provides options for deleting a vault notification configuration
     *        from an Amazon Glacier vault.
     * @return Result of the DeleteVaultNotifications operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.DeleteVaultNotifications
     */
    @Override
    public DeleteVaultNotificationsResult deleteVaultNotifications(
            DeleteVaultNotificationsRequest deleteVaultNotificationsRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteVaultNotificationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteVaultNotificationsRequest> request = null;
        Response<DeleteVaultNotificationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteVaultNotificationsRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(deleteVaultNotificationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteVaultNotificationsResult>> responseHandler = protocolFactory
                    .createResponseHandler(
                            new JsonOperationMetadata().withPayloadJson(true)
                                    .withHasStreamingSuccessResponse(false),
                            new DeleteVaultNotificationsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation returns information about a job you previously initiated,
     * including the job initiation date, the user who initiated the job, the
     * job status code/message and the Amazon SNS topic to notify after Amazon
     * Glacier completes the job. For more information about initiating a job,
     * see <a>InitiateJob</a>.
     * </p>
     * <note>
     * <p>
     * This operation enables you to check the status of your job. However, it
     * is strongly recommended that you set up an Amazon SNS topic and specify
     * it in your initiate job request so that Amazon Glacier can notify the
     * topic after it completes the job.
     * </p>
     * </note>
     * <p>
     * A job ID will not expire for at least 24 hours after Amazon Glacier
     * completes the job.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For information about the underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-describe-job-get.html"
     * >Working with Archives in Amazon Glacier</a> in the <i>Amazon Glacier
     * Developer Guide</i>.
     * </p>
     * 
     * @param describeJobRequest
     *        Provides options for retrieving a job description.
     * @return Result of the DescribeJob operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.DescribeJob
     */
    @Override
    public DescribeJobResult describeJob(DescribeJobRequest describeJobRequest) {
        ExecutionContext executionContext = createExecutionContext(describeJobRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeJobRequest> request = null;
        Response<DescribeJobResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeJobRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(describeJobRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DescribeJobResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new DescribeJobResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation returns information about a vault, including the vault's
     * Amazon Resource Name (ARN), the date the vault was created, the number of
     * archives it contains, and the total size of all the archives in the
     * vault. The number of archives and their total size are as of the last
     * inventory generation. This means that if you add or remove an archive
     * from a vault, and then immediately use Describe Vault, the change in
     * contents will not be immediately reflected. If you want to retrieve the
     * latest inventory of the vault, use <a>InitiateJob</a>. Amazon Glacier
     * generates vault inventories approximately daily. For more information,
     * see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-inventory.html"
     * >Downloading a Vault Inventory in Amazon Glacier</a>.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/retrieving-vault-info.html"
     * >Retrieving Vault Metadata in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-vault-get.html"
     * >Describe Vault </a> in the <i>Amazon Glacier Developer Guide</i>.
     * </p>
     * 
     * @param describeVaultRequest
     *        Provides options for retrieving metadata for a specific vault in
     *        Amazon Glacier.
     * @return Result of the DescribeVault operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.DescribeVault
     */
    @Override
    public DescribeVaultResult describeVault(
            DescribeVaultRequest describeVaultRequest) {
        ExecutionContext executionContext = createExecutionContext(describeVaultRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeVaultRequest> request = null;
        Response<DescribeVaultResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeVaultRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(describeVaultRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DescribeVaultResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new DescribeVaultResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation returns the current data retrieval policy for the account
     * and region specified in the GET request. For more information about data
     * retrieval policies, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/data-retrieval-policy.html"
     * >Amazon Glacier Data Retrieval Policies</a>.
     * </p>
     * 
     * @param getDataRetrievalPolicyRequest
     *        Input for GetDataRetrievalPolicy.
     * @return Result of the GetDataRetrievalPolicy operation returned by the
     *         service.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.GetDataRetrievalPolicy
     */
    @Override
    public GetDataRetrievalPolicyResult getDataRetrievalPolicy(
            GetDataRetrievalPolicyRequest getDataRetrievalPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(getDataRetrievalPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetDataRetrievalPolicyRequest> request = null;
        Response<GetDataRetrievalPolicyResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetDataRetrievalPolicyRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(getDataRetrievalPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetDataRetrievalPolicyResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new GetDataRetrievalPolicyResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation downloads the output of the job you initiated using
     * <a>InitiateJob</a>. Depending on the job type you specified when you
     * initiated the job, the output will be either the content of an archive or
     * a vault inventory.
     * </p>
     * <p>
     * A job ID will not expire for at least 24 hours after Amazon Glacier
     * completes the job. That is, you can download the job output within the 24
     * hours period after Amazon Glacier completes the job.
     * </p>
     * <p>
     * If the job output is large, then you can use the <code>Range</code>
     * request header to retrieve a portion of the output. This allows you to
     * download the entire output in smaller chunks of bytes. For example,
     * suppose you have 1 GB of job output you want to download and you decide
     * to download 128 MB chunks of data at a time, which is a total of eight
     * Get Job Output requests. You use the following process to download the
     * job output:
     * </p>
     * <ol>
     * <li>
     * <p>
     * Download a 128 MB chunk of output by specifying the appropriate byte
     * range using the <code>Range</code> header.
     * </p>
     * </li>
     * <li>
     * <p>
     * Along with the data, the response includes a SHA256 tree hash of the
     * payload. You compute the checksum of the payload on the client and
     * compare it with the checksum you received in the response to ensure you
     * received all the expected data.
     * </p>
     * </li>
     * <li>
     * <p>
     * Repeat steps 1 and 2 for all the eight 128 MB chunks of output data, each
     * time specifying the appropriate byte range.
     * </p>
     * </li>
     * <li>
     * <p>
     * After downloading all the parts of the job output, you have a list of
     * eight checksum values. Compute the tree hash of these values to find the
     * checksum of the entire output. Using the <a>DescribeJob</a> API, obtain
     * job information of the job that provided you the output. The response
     * includes the checksum of the entire archive stored in Amazon Glacier. You
     * compare this value with the checksum you computed to ensure you have
     * downloaded the entire archive content with no errors.
     * </p>
     * </li>
     * </ol>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and the underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-inventory.html"
     * >Downloading a Vault Inventory</a>, <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/downloading-an-archive.html"
     * >Downloading an Archive</a>, and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-job-output-get.html"
     * >Get Job Output </a>
     * </p>
     * 
     * @param getJobOutputRequest
     *        Provides options for downloading output of an Amazon Glacier job.
     * @return Result of the GetJobOutput operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.GetJobOutput
     */
    @Override
    public GetJobOutputResult getJobOutput(
            GetJobOutputRequest getJobOutputRequest) {
        ExecutionContext executionContext = createExecutionContext(getJobOutputRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetJobOutputRequest> request = null;
        Response<GetJobOutputResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetJobOutputRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(getJobOutputRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetJobOutputResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(false)
                            .withHasStreamingSuccessResponse(true),
                            new GetJobOutputResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            GetJobOutputResult result = response.getAwsResponse();

            // wrapping the response with the LengthCheckInputStream.
            result.setBody(new LengthCheckInputStream(
                    result.getBody(),
                    Long.parseLong(response.getHttpResponse().getHeaders()
                            .get("Content-Length")),
                    com.amazonaws.util.LengthCheckInputStream.INCLUDE_SKIPPED_BYTES));

            // wrapping the response with the service client holder input stream
            // to avoid client being GC'ed.
            result.setBody(new ServiceClientHolderInputStream(result.getBody(),
                    this));

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation retrieves the <code>access-policy</code> subresource set
     * on the vault; for more information on setting this subresource, see <a
     * href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-SetVaultAccessPolicy.html"
     * >Set Vault Access Policy (PUT access-policy)</a>. If there is no access
     * policy set on the vault, the operation returns a
     * <code>404 Not found</code> error. For more information about vault access
     * policies, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-access-policy.html"
     * >Amazon Glacier Access Control with Vault Access Policies</a>.
     * </p>
     * 
     * @param getVaultAccessPolicyRequest
     *        Input for GetVaultAccessPolicy.
     * @return Result of the GetVaultAccessPolicy operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.GetVaultAccessPolicy
     */
    @Override
    public GetVaultAccessPolicyResult getVaultAccessPolicy(
            GetVaultAccessPolicyRequest getVaultAccessPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(getVaultAccessPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetVaultAccessPolicyRequest> request = null;
        Response<GetVaultAccessPolicyResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetVaultAccessPolicyRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(getVaultAccessPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetVaultAccessPolicyResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new GetVaultAccessPolicyResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation retrieves the following attributes from the
     * <code>lock-policy</code> subresource set on the specified vault:
     * <ul>
     * <li>
     * <p>
     * The vault lock policy set on the vault.
     * </p>
     * </li>
     * <li>
     * <p>
     * The state of the vault lock, which is either <code>InProgess</code> or
     * <code>Locked</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * When the lock ID expires. The lock ID is used to complete the vault
     * locking process.
     * </p>
     * </li>
     * <li>
     * <p>
     * When the vault lock was initiated and put into the
     * <code>InProgress</code> state.
     * </p>
     * </li>
     * </ul>
     * </p>
     * <p>
     * A vault lock is put into the <code>InProgress</code> state by calling
     * <a>InitiateVaultLock</a>. A vault lock is put into the
     * <code>Locked</code> state by calling <a>CompleteVaultLock</a>. You can
     * abort the vault locking process by calling <a>AbortVaultLock</a>. For
     * more information about the vault locking process, <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-lock.html"
     * >Amazon Glacier Vault Lock</a>.
     * </p>
     * <p>
     * If there is no vault lock policy set on the vault, the operation returns
     * a <code>404 Not found</code> error. For more information about vault lock
     * policies, <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-lock-policy.html"
     * >Amazon Glacier Access Control with Vault Lock Policies</a>.
     * </p>
     * 
     * @param getVaultLockRequest
     *        The input values for <code>GetVaultLock</code>.
     * @return Result of the GetVaultLock operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.GetVaultLock
     */
    @Override
    public GetVaultLockResult getVaultLock(
            GetVaultLockRequest getVaultLockRequest) {
        ExecutionContext executionContext = createExecutionContext(getVaultLockRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetVaultLockRequest> request = null;
        Response<GetVaultLockResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetVaultLockRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(getVaultLockRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetVaultLockResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new GetVaultLockResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation retrieves the
     * <code class="code">notification-configuration</code> subresource of the
     * specified vault.
     * </p>
     * <p>
     * For information about setting a notification configuration on a vault,
     * see <a>SetVaultNotifications</a>. If a notification configuration for a
     * vault is not set, the operation returns a
     * <code class="code">404 Not Found</code> error. For more information about
     * vault notifications, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/configuring-notifications.html"
     * >Configuring Vault Notifications in Amazon Glacier</a>.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/configuring-notifications.html"
     * >Configuring Vault Notifications in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-vault-notifications-get.html"
     * >Get Vault Notification Configuration </a> in the <i>Amazon Glacier
     * Developer Guide</i>.
     * </p>
     * 
     * @param getVaultNotificationsRequest
     *        Provides options for retrieving the notification configuration set
     *        on an Amazon Glacier vault.
     * @return Result of the GetVaultNotifications operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.GetVaultNotifications
     */
    @Override
    public GetVaultNotificationsResult getVaultNotifications(
            GetVaultNotificationsRequest getVaultNotificationsRequest) {
        ExecutionContext executionContext = createExecutionContext(getVaultNotificationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<GetVaultNotificationsRequest> request = null;
        Response<GetVaultNotificationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new GetVaultNotificationsRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(getVaultNotificationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<GetVaultNotificationsResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new GetVaultNotificationsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation initiates a job of the specified type. In this release,
     * you can initiate a job to retrieve either an archive or a vault inventory
     * (a list of archives in a vault).
     * </p>
     * <p>
     * Retrieving data from Amazon Glacier is a two-step process:
     * </p>
     * <ol>
     * <li>
     * <p>
     * Initiate a retrieval job.
     * </p>
     * <note>
     * <p>
     * A data retrieval policy can cause your initiate retrieval job request to
     * fail with a PolicyEnforcedException exception. For more information about
     * data retrieval policies, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/data-retrieval-policy.html"
     * >Amazon Glacier Data Retrieval Policies</a>. For more information about
     * the PolicyEnforcedException exception, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-error-responses.html"
     * >Error Responses</a>.
     * </p>
     * </note></li>
     * <li>
     * <p>
     * After the job completes, download the bytes.
     * </p>
     * </li>
     * </ol>
     * <p>
     * The retrieval request is executed asynchronously. When you initiate a
     * retrieval job, Amazon Glacier creates a job and returns a job ID in the
     * response. When Amazon Glacier completes the job, you can get the job
     * output (archive or inventory data). For information about getting job
     * output, see <a>GetJobOutput</a> operation.
     * </p>
     * <p>
     * The job must complete before you can get its output. To determine when a
     * job is complete, you have the following options:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <b>Use Amazon SNS Notification</b> You can specify an Amazon Simple
     * Notification Service (Amazon SNS) topic to which Amazon Glacier can post
     * a notification after the job is completed. You can specify an SNS topic
     * per job request. The notification is sent only after Amazon Glacier
     * completes the job. In addition to specifying an SNS topic per job
     * request, you can configure vault notifications for a vault so that job
     * notifications are always sent. For more information, see
     * <a>SetVaultNotifications</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Get job details</b> You can make a <a>DescribeJob</a> request to
     * obtain job status information while a job is in progress. However, it is
     * more efficient to use an Amazon SNS notification to determine when a job
     * is complete.
     * </p>
     * </li>
     * </ul>
     * <note>
     * <p>
     * The information you get via notification is same that you get by calling
     * <a>DescribeJob</a>.
     * </p>
     * </note>
     * <p>
     * If for a specific event, you add both the notification configuration on
     * the vault and also specify an SNS topic in your initiate job request,
     * Amazon Glacier sends both notifications. For more information, see
     * <a>SetVaultNotifications</a>.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * <b>About the Vault Inventory</b>
     * </p>
     * <p>
     * Amazon Glacier prepares an inventory for each vault periodically, every
     * 24 hours. When you initiate a job for a vault inventory, Amazon Glacier
     * returns the last inventory for the vault. The inventory data you get
     * might be up to a day or two days old. Also, the initiate inventory job
     * might take some time to complete before you can download the vault
     * inventory. So you do not want to retrieve a vault inventory for each
     * vault operation. However, in some scenarios, you might find the vault
     * inventory useful. For example, when you upload an archive, you can
     * provide an archive description but not an archive name. Amazon Glacier
     * provides you a unique archive ID, an opaque string of characters. So, you
     * might maintain your own database that maps archive names to their
     * corresponding Amazon Glacier assigned archive IDs. You might find the
     * vault inventory useful in the event you need to reconcile information in
     * your database with the actual vault inventory.
     * </p>
     * <p>
     * <b>Range Inventory Retrieval</b>
     * </p>
     * <p>
     * You can limit the number of inventory items retrieved by filtering on the
     * archive creation date or by setting a limit.
     * </p>
     * <p>
     * <i>Filtering by Archive Creation Date</i>
     * </p>
     * <p>
     * You can retrieve inventory items for archives created between
     * <code>StartDate</code> and <code>EndDate</code> by specifying values for
     * these parameters in the <b>InitiateJob</b> request. Archives created on
     * or after the <code>StartDate</code> and before the <code>EndDate</code>
     * will be returned. If you only provide the <code>StartDate</code> without
     * the <code>EndDate</code>, you will retrieve the inventory for all
     * archives created on or after the <code>StartDate</code>. If you only
     * provide the <code>EndDate</code> without the <code>StartDate</code>, you
     * will get back the inventory for all archives created before the
     * <code>EndDate</code>.
     * </p>
     * <p>
     * <i>Limiting Inventory Items per Retrieval</i>
     * </p>
     * <p>
     * You can limit the number of inventory items returned by setting the
     * <code>Limit</code> parameter in the <b>InitiateJob</b> request. The
     * inventory job output will contain inventory items up to the specified
     * <code>Limit</code>. If there are more inventory items available, the
     * result is paginated. After a job is complete you can use the
     * <a>DescribeJob</a> operation to get a marker that you use in a subsequent
     * <b>InitiateJob</b> request. The marker will indicate the starting point
     * to retrieve the next set of inventory items. You can page through your
     * entire inventory by repeatedly making <b>InitiateJob</b> requests with
     * the marker from the previous <b>DescribeJob</b> output, until you get a
     * marker from <b>DescribeJob</b> that returns null, indicating that there
     * are no more inventory items available.
     * </p>
     * <p>
     * You can use the <code>Limit</code> parameter together with the date range
     * parameters.
     * </p>
     * <p>
     * <b>About Ranged Archive Retrieval</b>
     * </p>
     * <p>
     * You can initiate an archive retrieval for the whole archive or a range of
     * the archive. In the case of ranged archive retrieval, you specify a byte
     * range to return or the whole archive. The range specified must be
     * megabyte (MB) aligned, that is the range start value must be divisible by
     * 1 MB and range end value plus 1 must be divisible by 1 MB or equal the
     * end of the archive. If the ranged archive retrieval is not megabyte
     * aligned, this operation returns a 400 response. Furthermore, to ensure
     * you get checksum values for data you download using Get Job Output API,
     * the range must be tree hash aligned.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and the underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-initiate-job-post.html"
     * >Initiate a Job</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-inventory.html"
     * >Downloading a Vault Inventory</a>
     * </p>
     * 
     * @param initiateJobRequest
     *        Provides options for initiating an Amazon Glacier job.
     * @return Result of the InitiateJob operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws PolicyEnforcedException
     *         Returned if a retrieval job would exceed the current data
     *         policy's retrieval rate limit. For more information about data
     *         retrieval policies,
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.InitiateJob
     */
    @Override
    public InitiateJobResult initiateJob(InitiateJobRequest initiateJobRequest) {
        ExecutionContext executionContext = createExecutionContext(initiateJobRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<InitiateJobRequest> request = null;
        Response<InitiateJobResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new InitiateJobRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(initiateJobRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<InitiateJobResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new InitiateJobResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation initiates a multipart upload. Amazon Glacier creates a
     * multipart upload resource and returns its ID in the response. The
     * multipart upload ID is used in subsequent requests to upload parts of an
     * archive (see <a>UploadMultipartPart</a>).
     * </p>
     * <p>
     * When you initiate a multipart upload, you specify the part size in number
     * of bytes. The part size must be a megabyte (1024 KB) multiplied by a
     * power of 2-for example, 1048576 (1 MB), 2097152 (2 MB), 4194304 (4 MB),
     * 8388608 (8 MB), and so on. The minimum allowable part size is 1 MB, and
     * the maximum is 4 GB.
     * </p>
     * <p>
     * Every part you upload to this resource (see <a>UploadMultipartPart</a>),
     * except the last one, must have the same size. The last one can be the
     * same size or smaller. For example, suppose you want to upload a 16.2 MB
     * file. If you initiate the multipart upload with a part size of 4 MB, you
     * will upload four parts of 4 MB each and one part of 0.2 MB.
     * </p>
     * <note>
     * <p>
     * You don't need to know the size of the archive when you start a multipart
     * upload because Amazon Glacier does not require you to specify the overall
     * archive size.
     * </p>
     * </note>
     * <p>
     * After you complete the multipart upload, Amazon Glacier removes the
     * multipart upload resource referenced by the ID. Amazon Glacier also
     * removes the multipart upload resource if you cancel the multipart upload
     * or it may be removed if there is no activity for a period of 24 hours.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/uploading-archive-mpu.html"
     * >Uploading Large Archives in Parts (Multipart Upload)</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-multipart-initiate-upload.html"
     * >Initiate Multipart Upload</a> in the <i>Amazon Glacier Developer
     * Guide</i>.
     * </p>
     * 
     * @param initiateMultipartUploadRequest
     *        Provides options for initiating a multipart upload to an Amazon
     *        Glacier vault.
     * @return Result of the InitiateMultipartUpload operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.InitiateMultipartUpload
     */
    @Override
    public InitiateMultipartUploadResult initiateMultipartUpload(
            InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        ExecutionContext executionContext = createExecutionContext(initiateMultipartUploadRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<InitiateMultipartUploadRequest> request = null;
        Response<InitiateMultipartUploadResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new InitiateMultipartUploadRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(initiateMultipartUploadRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<InitiateMultipartUploadResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new InitiateMultipartUploadResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation initiates the vault locking process by doing the
     * following:
     * <ul>
     * <li>
     * <p>
     * Installing a vault lock policy on the specified vault.
     * </p>
     * </li>
     * <li>
     * <p>
     * Setting the lock state of vault lock to <code>InProgress</code>.
     * </p>
     * </li>
     * <li>
     * <p>
     * Returning a lock ID, which is used to complete the vault locking process.
     * </p>
     * </li>
     * </ul>
     * </p>
     * <p>
     * You can set one vault lock policy for each vault and this policy can be
     * up to 20 KB in size. For more information about vault lock policies, see
     * <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-lock-policy.html"
     * >Amazon Glacier Access Control with Vault Lock Policies</a>.
     * </p>
     * <p>
     * You must complete the vault locking process within 24 hours after the
     * vault lock enters the <code>InProgress</code> state. After the 24 hour
     * window ends, the lock ID expires, the vault automatically exits the
     * <code>InProgress</code> state, and the vault lock policy is removed from
     * the vault. You call <a>CompleteVaultLock</a> to complete the vault
     * locking process by setting the state of the vault lock to
     * <code>Locked</code>.
     * </p>
     * <p>
     * After a vault lock is in the <code>Locked</code> state, you cannot
     * initiate a new vault lock for the vault.
     * </p>
     * <p>
     * You can abort the vault locking process by calling <a>AbortVaultLock</a>.
     * You can get the state of the vault lock by calling <a>GetVaultLock</a>.
     * For more information about the vault locking process, <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-lock.html"
     * >Amazon Glacier Vault Lock</a>.
     * </p>
     * <p>
     * If this operation is called when the vault lock is in the
     * <code>InProgress</code> state, the operation returns an
     * <code>AccessDeniedException</code> error. When the vault lock is in the
     * <code>InProgress</code> state you must call <a>AbortVaultLock</a> before
     * you can initiate a new vault lock policy.
     * </p>
     * 
     * @param initiateVaultLockRequest
     *        The input values for <code>InitiateVaultLock</code>.
     * @return Result of the InitiateVaultLock operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.InitiateVaultLock
     */
    @Override
    public InitiateVaultLockResult initiateVaultLock(
            InitiateVaultLockRequest initiateVaultLockRequest) {
        ExecutionContext executionContext = createExecutionContext(initiateVaultLockRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<InitiateVaultLockRequest> request = null;
        Response<InitiateVaultLockResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new InitiateVaultLockRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(initiateVaultLockRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<InitiateVaultLockResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new InitiateVaultLockResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation lists jobs for a vault, including jobs that are
     * in-progress and jobs that have recently finished.
     * </p>
     * <note>
     * <p>
     * Amazon Glacier retains recently completed jobs for a period before
     * deleting them; however, it eventually removes completed jobs. The output
     * of completed jobs can be retrieved. Retaining completed jobs for a period
     * of time after they have completed enables you to get a job output in the
     * event you miss the job completion notification or your first attempt to
     * download it fails. For example, suppose you start an archive retrieval
     * job to download an archive. After the job completes, you start to
     * download the archive but encounter a network error. In this scenario, you
     * can retry and download the archive while the job exists.
     * </p>
     * </note>
     * <p>
     * To retrieve an archive or retrieve a vault inventory from Amazon Glacier,
     * you first initiate a job, and after the job completes, you download the
     * data. For an archive retrieval, the output is the archive data, and for
     * an inventory retrieval, it is the inventory list. The List Job operation
     * returns a list of these jobs sorted by job initiation time.
     * </p>
     * <p>
     * This List Jobs operation supports pagination. By default, this operation
     * returns up to 1,000 jobs in the response. You should always check the
     * response for a <code>marker</code> at which to continue the list; if
     * there are no more items the <code>marker</code> is <code>null</code>. To
     * return a list of jobs that begins at a specific job, set the
     * <code>marker</code> request parameter to the value you obtained from a
     * previous List Jobs request. You can also limit the number of jobs
     * returned in the response by specifying the <code>limit</code> parameter
     * in the request.
     * </p>
     * <p>
     * Additionally, you can filter the jobs list returned by specifying an
     * optional <code>statuscode</code> (InProgress, Succeeded, or Failed) and
     * <code>completed</code> (true, false) parameter. The
     * <code>statuscode</code> allows you to specify that only jobs that match a
     * specified status are returned. The <code>completed</code> parameter
     * allows you to specify that only jobs in a specific completion state are
     * returned.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For the underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-jobs-get.html"
     * >List Jobs </a>
     * </p>
     * 
     * @param listJobsRequest
     *        Provides options for retrieving a job list for an Amazon Glacier
     *        vault.
     * @return Result of the ListJobs operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.ListJobs
     */
    @Override
    public ListJobsResult listJobs(ListJobsRequest listJobsRequest) {
        ExecutionContext executionContext = createExecutionContext(listJobsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListJobsRequest> request = null;
        Response<ListJobsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListJobsRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(listJobsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListJobsResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new ListJobsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation lists in-progress multipart uploads for the specified
     * vault. An in-progress multipart upload is a multipart upload that has
     * been initiated by an <a>InitiateMultipartUpload</a> request, but has not
     * yet been completed or aborted. The list returned in the List Multipart
     * Upload response has no guaranteed order.
     * </p>
     * <p>
     * The List Multipart Uploads operation supports pagination. By default,
     * this operation returns up to 1,000 multipart uploads in the response. You
     * should always check the response for a <code>marker</code> at which to
     * continue the list; if there are no more items the <code>marker</code> is
     * <code>null</code>. To return a list of multipart uploads that begins at a
     * specific upload, set the <code>marker</code> request parameter to the
     * value you obtained from a previous List Multipart Upload request. You can
     * also limit the number of uploads returned in the response by specifying
     * the <code>limit</code> parameter in the request.
     * </p>
     * <p>
     * Note the difference between this operation and listing parts
     * (<a>ListParts</a>). The List Multipart Uploads operation lists all
     * multipart uploads for a vault and does not require a multipart upload ID.
     * The List Parts operation requires a multipart upload ID since parts are
     * associated with a single upload.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and the underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/working-with-archives.html"
     * >Working with Archives in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-multipart-list-uploads.html"
     * >List Multipart Uploads </a> in the <i>Amazon Glacier Developer
     * Guide</i>.
     * </p>
     * 
     * @param listMultipartUploadsRequest
     *        Provides options for retrieving list of in-progress multipart
     *        uploads for an Amazon Glacier vault.
     * @return Result of the ListMultipartUploads operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.ListMultipartUploads
     */
    @Override
    public ListMultipartUploadsResult listMultipartUploads(
            ListMultipartUploadsRequest listMultipartUploadsRequest) {
        ExecutionContext executionContext = createExecutionContext(listMultipartUploadsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListMultipartUploadsRequest> request = null;
        Response<ListMultipartUploadsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListMultipartUploadsRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(listMultipartUploadsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListMultipartUploadsResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new ListMultipartUploadsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation lists the parts of an archive that have been uploaded in a
     * specific multipart upload. You can make this request at any time during
     * an in-progress multipart upload before you complete the upload (see
     * <a>CompleteMultipartUpload</a>. List Parts returns an error for completed
     * uploads. The list returned in the List Parts response is sorted by part
     * range.
     * </p>
     * <p>
     * The List Parts operation supports pagination. By default, this operation
     * returns up to 1,000 uploaded parts in the response. You should always
     * check the response for a <code class="code">marker</code> at which to
     * continue the list; if there are no more items the
     * <code class="code">marker</code> is <code class="code">null</code>. To
     * return a list of parts that begins at a specific part, set the
     * <code>marker</code> request parameter to the value you obtained from a
     * previous List Parts request. You can also limit the number of parts
     * returned in the response by specifying the <code>limit</code> parameter
     * in the request.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and the underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/working-with-archives.html"
     * >Working with Archives in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-multipart-list-parts.html"
     * >List Parts</a> in the <i>Amazon Glacier Developer Guide</i>.
     * </p>
     * 
     * @param listPartsRequest
     *        Provides options for retrieving a list of parts of an archive that
     *        have been uploaded in a specific multipart upload.
     * @return Result of the ListParts operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.ListParts
     */
    @Override
    public ListPartsResult listParts(ListPartsRequest listPartsRequest) {
        ExecutionContext executionContext = createExecutionContext(listPartsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListPartsRequest> request = null;
        Response<ListPartsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListPartsRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(listPartsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListPartsResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new ListPartsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation lists all the tags attached to a vault. The operation
     * returns an empty map if there are no tags. For more information about
     * tags, see <a
     * href="http://docs.aws.amazon.com/amazonglacier/latest/dev/tagging.html"
     * >Tagging Amazon Glacier Resources</a>.
     * </p>
     * 
     * @param listTagsForVaultRequest
     *        The input value for <code>ListTagsForVaultInput</code>.
     * @return Result of the ListTagsForVault operation returned by the service.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.ListTagsForVault
     */
    @Override
    public ListTagsForVaultResult listTagsForVault(
            ListTagsForVaultRequest listTagsForVaultRequest) {
        ExecutionContext executionContext = createExecutionContext(listTagsForVaultRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListTagsForVaultRequest> request = null;
        Response<ListTagsForVaultResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListTagsForVaultRequestMarshaller(protocolFactory)
                        .marshall(super
                                .beforeMarshalling(listTagsForVaultRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListTagsForVaultResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new ListTagsForVaultResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation lists all vaults owned by the calling user's account. The
     * list returned in the response is ASCII-sorted by vault name.
     * </p>
     * <p>
     * By default, this operation returns up to 1,000 items. If there are more
     * vaults to list, the response <code class="code">marker</code> field
     * contains the vault Amazon Resource Name (ARN) at which to continue the
     * list with a new List Vaults request; otherwise, the
     * <code class="code">marker</code> field is <code class="code">null</code>.
     * To return a list of vaults that begins at a specific vault, set the
     * <code class="code">marker</code> request parameter to the vault ARN you
     * obtained from a previous List Vaults request. You can also limit the
     * number of vaults returned in the response by specifying the
     * <code class="code">limit</code> parameter in the request.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/retrieving-vault-info.html"
     * >Retrieving Vault Metadata in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-vaults-get.html"
     * >List Vaults </a> in the <i>Amazon Glacier Developer Guide</i>.
     * </p>
     * 
     * @param listVaultsRequest
     *        Provides options to retrieve the vault list owned by the calling
     *        user's account. The list provides metadata information for each
     *        vault.
     * @return Result of the ListVaults operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.ListVaults
     */
    @Override
    public ListVaultsResult listVaults(ListVaultsRequest listVaultsRequest) {
        ExecutionContext executionContext = createExecutionContext(listVaultsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<ListVaultsRequest> request = null;
        Response<ListVaultsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new ListVaultsRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(listVaultsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<ListVaultsResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new ListVaultsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation removes one or more tags from the set of tags attached to
     * a vault. For more information about tags, see <a
     * href="http://docs.aws.amazon.com/amazonglacier/latest/dev/tagging.html"
     * >Tagging Amazon Glacier Resources</a>. This operation is idempotent. The
     * operation will be successful, even if there are no tags attached to the
     * vault.
     * </p>
     * 
     * @param removeTagsFromVaultRequest
     *        The input value for <code>RemoveTagsFromVaultInput</code>.
     * @return Result of the RemoveTagsFromVault operation returned by the
     *         service.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.RemoveTagsFromVault
     */
    @Override
    public RemoveTagsFromVaultResult removeTagsFromVault(
            RemoveTagsFromVaultRequest removeTagsFromVaultRequest) {
        ExecutionContext executionContext = createExecutionContext(removeTagsFromVaultRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RemoveTagsFromVaultRequest> request = null;
        Response<RemoveTagsFromVaultResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RemoveTagsFromVaultRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(removeTagsFromVaultRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<RemoveTagsFromVaultResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new RemoveTagsFromVaultResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation sets and then enacts a data retrieval policy in the region
     * specified in the PUT request. You can set one policy per region for an
     * AWS account. The policy is enacted within a few minutes of a successful
     * PUT operation.
     * </p>
     * <p>
     * The set policy operation does not affect retrieval jobs that were in
     * progress before the policy was enacted. For more information about data
     * retrieval policies, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/data-retrieval-policy.html"
     * >Amazon Glacier Data Retrieval Policies</a>.
     * </p>
     * 
     * @param setDataRetrievalPolicyRequest
     *        SetDataRetrievalPolicy input.
     * @return Result of the SetDataRetrievalPolicy operation returned by the
     *         service.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.SetDataRetrievalPolicy
     */
    @Override
    public SetDataRetrievalPolicyResult setDataRetrievalPolicy(
            SetDataRetrievalPolicyRequest setDataRetrievalPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(setDataRetrievalPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetDataRetrievalPolicyRequest> request = null;
        Response<SetDataRetrievalPolicyResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetDataRetrievalPolicyRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(setDataRetrievalPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<SetDataRetrievalPolicyResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new SetDataRetrievalPolicyResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation configures an access policy for a vault and will overwrite
     * an existing policy. To configure a vault access policy, send a PUT
     * request to the <code>access-policy</code> subresource of the vault. An
     * access policy is specific to a vault and is also called a vault
     * subresource. You can set one access policy per vault and the policy can
     * be up to 20 KB in size. For more information about vault access policies,
     * see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/vault-access-policy.html"
     * >Amazon Glacier Access Control with Vault Access Policies</a>.
     * </p>
     * 
     * @param setVaultAccessPolicyRequest
     *        SetVaultAccessPolicy input.
     * @return Result of the SetVaultAccessPolicy operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.SetVaultAccessPolicy
     */
    @Override
    public SetVaultAccessPolicyResult setVaultAccessPolicy(
            SetVaultAccessPolicyRequest setVaultAccessPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(setVaultAccessPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetVaultAccessPolicyRequest> request = null;
        Response<SetVaultAccessPolicyResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetVaultAccessPolicyRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(setVaultAccessPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<SetVaultAccessPolicyResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new SetVaultAccessPolicyResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation configures notifications that will be sent when specific
     * events happen to a vault. By default, you don't get any notifications.
     * </p>
     * <p>
     * To configure vault notifications, send a PUT request to the
     * <code class="code">notification-configuration</code> subresource of the
     * vault. The request should include a JSON document that provides an Amazon
     * SNS topic and specific events for which you want Amazon Glacier to send
     * notifications to the topic.
     * </p>
     * <p>
     * Amazon SNS topics must grant permission to the vault to be allowed to
     * publish notifications to the topic. You can configure a vault to publish
     * a notification for the following vault events:
     * </p>
     * <ul>
     * <li><b>ArchiveRetrievalCompleted</b> This event occurs when a job that
     * was initiated for an archive retrieval is completed (<a>InitiateJob</a>).
     * The status of the completed job can be "Succeeded" or "Failed". The
     * notification sent to the SNS topic is the same output as returned from
     * <a>DescribeJob</a>.</li>
     * <li><b>InventoryRetrievalCompleted</b> This event occurs when a job that
     * was initiated for an inventory retrieval is completed
     * (<a>InitiateJob</a>). The status of the completed job can be "Succeeded"
     * or "Failed". The notification sent to the SNS topic is the same output as
     * returned from <a>DescribeJob</a>.</li>
     * </ul>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/configuring-notifications.html"
     * >Configuring Vault Notifications in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-vault-notifications-put.html"
     * >Set Vault Notification Configuration </a> in the <i>Amazon Glacier
     * Developer Guide</i>.
     * </p>
     * 
     * @param setVaultNotificationsRequest
     *        Provides options to configure notifications that will be sent when
     *        specific events happen to a vault.
     * @return Result of the SetVaultNotifications operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.SetVaultNotifications
     */
    @Override
    public SetVaultNotificationsResult setVaultNotifications(
            SetVaultNotificationsRequest setVaultNotificationsRequest) {
        ExecutionContext executionContext = createExecutionContext(setVaultNotificationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<SetVaultNotificationsRequest> request = null;
        Response<SetVaultNotificationsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new SetVaultNotificationsRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(setVaultNotificationsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<SetVaultNotificationsResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new SetVaultNotificationsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation adds an archive to a vault. This is a synchronous
     * operation, and for a successful upload, your data is durably persisted.
     * Amazon Glacier returns the archive ID in the
     * <code class="code">x-amz-archive-id</code> header of the response.
     * </p>
     * <p>
     * You must use the archive ID to access your data in Amazon Glacier. After
     * you upload an archive, you should save the archive ID returned so that
     * you can retrieve or delete the archive later. Besides saving the archive
     * ID, you can also index it and give it a friendly name to allow for better
     * searching. You can also use the optional archive description field to
     * specify how the archive is referred to in an external index of archives,
     * such as you might create in Amazon DynamoDB. You can also get the vault
     * inventory to obtain a list of archive IDs in a vault. For more
     * information, see <a>InitiateJob</a>.
     * </p>
     * <p>
     * You must provide a SHA256 tree hash of the data you are uploading. For
     * information about computing a SHA256 tree hash, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/checksum-calculations.html"
     * >Computing Checksums</a>.
     * </p>
     * <p>
     * You can optionally specify an archive description of up to 1,024
     * printable ASCII characters. You can get the archive description when you
     * either retrieve the archive or get the vault inventory. For more
     * information, see <a>InitiateJob</a>. Amazon Glacier does not interpret
     * the description in any way. An archive description does not need to be
     * unique. You cannot use the description to retrieve or sort the archive
     * list.
     * </p>
     * <p>
     * Archives are immutable. After you upload an archive, you cannot edit the
     * archive or its description.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/uploading-an-archive.html"
     * >Uploading an Archive in Amazon Glacier</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-archive-post.html"
     * >Upload Archive</a> in the <i>Amazon Glacier Developer Guide</i>.
     * </p>
     * 
     * @param uploadArchiveRequest
     *        Provides options to add an archive to a vault.
     * @return Result of the UploadArchive operation returned by the service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws RequestTimeoutException
     *         Returned if, when uploading an archive, Amazon Glacier times out
     *         while receiving the upload.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.UploadArchive
     */
    @Override
    public UploadArchiveResult uploadArchive(
            UploadArchiveRequest uploadArchiveRequest) {
        ExecutionContext executionContext = createExecutionContext(uploadArchiveRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UploadArchiveRequest> request = null;
        Response<UploadArchiveResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UploadArchiveRequestMarshaller(protocolFactory)
                        .marshall(super.beforeMarshalling(uploadArchiveRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UploadArchiveResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new UploadArchiveResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * This operation uploads a part of an archive. You can upload archive parts
     * in any order. You can also upload them in parallel. You can upload up to
     * 10,000 parts for a multipart upload.
     * </p>
     * <p>
     * Amazon Glacier rejects your upload part request if any of the following
     * conditions is true:
     * </p>
     * <ul>
     * <li>
     * <p>
     * <b>SHA256 tree hash does not match</b>To ensure that part data is not
     * corrupted in transmission, you compute a SHA256 tree hash of the part and
     * include it in your request. Upon receiving the part data, Amazon Glacier
     * also computes a SHA256 tree hash. If these hash values don't match, the
     * operation fails. For information about computing a SHA256 tree hash, see
     * <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/checksum-calculations.html"
     * >Computing Checksums</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * <b>Part size does not match</b>The size of each part except the last must
     * match the size specified in the corresponding
     * <a>InitiateMultipartUpload</a> request. The size of the last part must be
     * the same size as, or smaller than, the specified size.
     * </p>
     * <note>
     * <p>
     * If you upload a part whose size is smaller than the part size you
     * specified in your initiate multipart upload request and that part is not
     * the last part, then the upload part request will succeed. However, the
     * subsequent Complete Multipart Upload request will fail.
     * </p>
     * </note></li>
     * <li><b>Range does not align</b>The byte range value in the request does
     * not align with the part size specified in the corresponding initiate
     * request. For example, if you specify a part size of 4194304 bytes (4 MB),
     * then 0 to 4194303 bytes (4 MB - 1) and 4194304 (4 MB) to 8388607 (8 MB -
     * 1) are valid part ranges. However, if you set a range value of 2 MB to 6
     * MB, the range does not align with the part size and the upload will fail.
     * </li>
     * </ul>
     * <p>
     * This operation is idempotent. If you upload the same part multiple times,
     * the data included in the most recent request overwrites the previously
     * uploaded data.
     * </p>
     * <p>
     * An AWS account has full permission to perform all operations (actions).
     * However, AWS Identity and Access Management (IAM) users don't have any
     * permissions by default. You must grant them explicit permission to
     * perform specific actions. For more information, see <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/using-iam-with-amazon-glacier.html"
     * >Access Control Using AWS Identity and Access Management (IAM)</a>.
     * </p>
     * <p>
     * For conceptual information and underlying REST API, go to <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/uploading-archive-mpu.html"
     * >Uploading Large Archives in Parts (Multipart Upload)</a> and <a href=
     * "http://docs.aws.amazon.com/amazonglacier/latest/dev/api-upload-part.html"
     * >Upload Part </a> in the <i>Amazon Glacier Developer Guide</i>.
     * </p>
     * 
     * @param uploadMultipartPartRequest
     *        Provides options to upload a part of an archive in a multipart
     *        upload operation.
     * @return Result of the UploadMultipartPart operation returned by the
     *         service.
     * @throws ResourceNotFoundException
     *         Returned if the specified resource, such as a vault, upload ID,
     *         or job ID, does not exist.
     * @throws InvalidParameterValueException
     *         Returned if a parameter of the request is incorrectly specified.
     * @throws MissingParameterValueException
     *         Returned if a required header or parameter is missing from the
     *         request.
     * @throws RequestTimeoutException
     *         Returned if, when uploading an archive, Amazon Glacier times out
     *         while receiving the upload.
     * @throws ServiceUnavailableException
     *         Returned if the service cannot complete the request.
     * @sample AmazonGlacier.UploadMultipartPart
     */
    @Override
    public UploadMultipartPartResult uploadMultipartPart(
            UploadMultipartPartRequest uploadMultipartPartRequest) {
        ExecutionContext executionContext = createExecutionContext(uploadMultipartPartRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<UploadMultipartPartRequest> request = null;
        Response<UploadMultipartPartResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new UploadMultipartPartRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(uploadMultipartPartRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<UploadMultipartPartResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new UploadMultipartPartResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * Returns additional metadata for a previously executed successful,
     * request, typically used for debugging issues where a service isn't acting
     * as expected. This data isn't considered part of the result data returned
     * by an operation, so it's available through this separate, diagnostic
     * interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you
     * need to access this extra diagnostic information for an executed request,
     * you should use this method to retrieve it as soon as possible after
     * executing the request.
     *
     * @param request
     *        The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(
            AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    /**
     * Normal invoke with authentication. Credentials are required and may be
     * overriden at the request level.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(
            Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {

        executionContext.setCredentialsProvider(CredentialUtils
                .getCredentialsProvider(request.getOriginalRequest(),
                        awsCredentialsProvider));

        return doInvoke(request, responseHandler, executionContext);
    }

    /**
     * Invoke with no authentication. Credentials are not required and any
     * credentials set on the client or request will be ignored for this
     * operation.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> anonymousInvoke(
            Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {

        return doInvoke(request, responseHandler, executionContext);
    }

    /**
     * Invoke the request using the http client. Assumes credentials (or lack
     * thereof) have been configured in the ExecutionContext beforehand.
     **/
    private <X, Y extends AmazonWebServiceRequest> Response<X> doInvoke(
            Request<Y> request,
            HttpResponseHandler<AmazonWebServiceResponse<X>> responseHandler,
            ExecutionContext executionContext) {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);

        HttpResponseHandler<AmazonServiceException> errorResponseHandler = protocolFactory
                .createErrorResponseHandler(new JsonErrorResponseMetadata()
                        .withCustomErrorCodeFieldName("code"));

        return client.execute(request, responseHandler, errorResponseHandler,
                executionContext);
    }

}
