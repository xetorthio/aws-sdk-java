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
package com.amazonaws.services.applicationautoscaling;

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

import com.amazonaws.services.applicationautoscaling.model.*;
import com.amazonaws.services.applicationautoscaling.model.transform.*;

/**
 * Client for accessing Application Auto Scaling. All service calls made using
 * this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * <p>
 * Application Auto Scaling is a general purpose Auto Scaling service for
 * supported elastic AWS resources. With Application Auto Scaling, you can
 * automatically scale your AWS resources, with an experience similar to that of
 * Auto Scaling.
 * </p>
 * <note>
 * <p>
 * At this time, Application Auto Scaling only supports scaling Amazon ECS
 * services.
 * </p>
 * </note>
 * <p>
 * For example, you can use Application Auto Scaling to accomplish the following
 * tasks:
 * </p>
 * <ul>
 * <li>
 * <p>
 * Define scaling policies for automatically adjusting your application’s
 * resources
 * </p>
 * </li>
 * <li>
 * <p>
 * Scale your resources in response to CloudWatch alarms
 * </p>
 * </li>
 * <li>
 * <p>
 * View history of your scaling events
 * </p>
 * </li>
 * </ul>
 * <p>
 * Application Auto Scaling is available in the following regions:
 * </p>
 * <ul>
 * <li>
 * <p>
 * <code>us-east-1</code>
 * </p>
 * </li>
 * <li>
 * <p>
 * <code>us-west-2</code>
 * </p>
 * </li>
 * <li>
 * <p>
 * <code>eu-west-1</code>
 * </p>
 * </li>
 * </ul>
 */
@ThreadSafe
public class AWSApplicationAutoScalingClient extends AmazonWebServiceClient
        implements AWSApplicationAutoScaling {
    /** Provider for AWS credentials. */
    private final AWSCredentialsProvider awsCredentialsProvider;

    private static final Log log = LogFactory
            .getLog(AWSApplicationAutoScaling.class);

    /** Default signing name for the service. */
    private static final String DEFAULT_SIGNING_NAME = "application-autoscaling";

    /**
     * Client configuration factory providing ClientConfigurations tailored to
     * this client
     */
    protected static final ClientConfigurationFactory configFactory = new ClientConfigurationFactory();

    private final SdkJsonProtocolFactory protocolFactory = new SdkJsonProtocolFactory(
            new JsonClientMetadata()
                    .withProtocolVersion("1.1")
                    .withSupportsCbor(false)
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("ValidationException")
                                    .withModeledClass(
                                            com.amazonaws.services.applicationautoscaling.model.ValidationException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("InternalServiceException")
                                    .withModeledClass(
                                            com.amazonaws.services.applicationautoscaling.model.InternalServiceException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("InvalidNextTokenException")
                                    .withModeledClass(
                                            com.amazonaws.services.applicationautoscaling.model.InvalidNextTokenException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("ObjectNotFoundException")
                                    .withModeledClass(
                                            com.amazonaws.services.applicationautoscaling.model.ObjectNotFoundException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode(
                                            "FailedResourceAccessException")
                                    .withModeledClass(
                                            com.amazonaws.services.applicationautoscaling.model.FailedResourceAccessException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("LimitExceededException")
                                    .withModeledClass(
                                            com.amazonaws.services.applicationautoscaling.model.LimitExceededException.class))
                    .addErrorMetadata(
                            new JsonErrorShapeMetadata()
                                    .withErrorCode("ConcurrentUpdateException")
                                    .withModeledClass(
                                            com.amazonaws.services.applicationautoscaling.model.ConcurrentUpdateException.class)));

    /**
     * Constructs a new client to invoke service methods on Application Auto
     * Scaling. A credentials provider chain will be used that searches for
     * credentials in this order:
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
    public AWSApplicationAutoScalingClient() {
        this(new DefaultAWSCredentialsProviderChain(), configFactory
                .getConfig());
    }

    /**
     * Constructs a new client to invoke service methods on Application Auto
     * Scaling. A credentials provider chain will be used that searches for
     * credentials in this order:
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
     *        connects to Application Auto Scaling (ex: proxy settings, retry
     *        counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AWSApplicationAutoScalingClient(
            ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on Application Auto
     * Scaling using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     */
    public AWSApplicationAutoScalingClient(AWSCredentials awsCredentials) {
        this(awsCredentials, configFactory.getConfig());
    }

    /**
     * Constructs a new client to invoke service methods on Application Auto
     * Scaling using the specified AWS account credentials and client
     * configuration options.
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
     *        connects to Application Auto Scaling (ex: proxy settings, retry
     *        counts, etc.).
     */
    public AWSApplicationAutoScalingClient(AWSCredentials awsCredentials,
            ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(
                awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on Application Auto
     * Scaling using the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     */
    public AWSApplicationAutoScalingClient(
            AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, configFactory.getConfig());
    }

    /**
     * Constructs a new client to invoke service methods on Application Auto
     * Scaling using the specified AWS account credentials provider and client
     * configuration options.
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
     *        connects to Application Auto Scaling (ex: proxy settings, retry
     *        counts, etc.).
     */
    public AWSApplicationAutoScalingClient(
            AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on Application Auto
     * Scaling using the specified AWS account credentials provider, client
     * configuration options, and request metric collector.
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
     *        connects to Application Auto Scaling (ex: proxy settings, retry
     *        counts, etc.).
     * @param requestMetricCollector
     *        optional request metric collector
     */
    public AWSApplicationAutoScalingClient(
            AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(clientConfiguration, requestMetricCollector);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    /**
     * Constructs a new client to invoke service methods on Application Auto
     * Scaling using the specified parameters.
     *
     * <p>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     *
     * @param clientParams
     *        Object providing client parameters.
     */
    AWSApplicationAutoScalingClient(AwsSyncClientParams clientParams) {
        super(clientParams);
        this.awsCredentialsProvider = clientParams.getCredentialsProvider();
        init();
    }

    private void init() {
        setServiceNameIntern(DEFAULT_SIGNING_NAME);
        setEndpointPrefix(ENDPOINT_PREFIX);
        // calling this.setEndPoint(...) will also modify the signer accordingly
        setEndpoint("https://autoscaling.us-east-1.amazonaws.com");
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s
                .addAll(chainFactory
                        .newRequestHandlerChain("/com/amazonaws/services/applicationautoscaling/request.handlers"));
        requestHandler2s
                .addAll(chainFactory
                        .newRequestHandler2Chain("/com/amazonaws/services/applicationautoscaling/request.handler2s"));
    }

    /**
     * <p>
     * Deletes an Application Auto Scaling scaling policy that was previously
     * created. If you are no longer using a scaling policy, you can delete it
     * with this operation.
     * </p>
     * <p>
     * Deleting a policy deletes the underlying alarm action, but does not
     * delete the CloudWatch alarm, even if it no longer has an associated
     * action.
     * </p>
     * <p>
     * To create a new scaling policy or update an existing one, see
     * <a>PutScalingPolicy</a>.
     * </p>
     * 
     * @param deleteScalingPolicyRequest
     * @return Result of the DeleteScalingPolicy operation returned by the
     *         service.
     * @throws ValidationException
     *         An exception was thrown for a validation issue. Review the
     *         available parameters for the API request.
     * @throws ObjectNotFoundException
     *         The specified object could not be found. For any <code>Put</code>
     *         or <code>Register</code> API operation, which depends on the
     *         existence of a scalable target, this exception is thrown if the
     *         scalable target with the specified service namespace, resource
     *         ID, and scalable dimension does not exist. For any
     *         <code>Delete</code> or <code>Deregister</code> API operation,
     *         this exception is thrown if the resource that is to be deleted or
     *         deregistered cannot be found.
     * @throws ConcurrentUpdateException
     *         Concurrent updates caused an exception, for example, if you
     *         request an update to an Application Auto Scaling resource that
     *         already has a pending update.
     * @throws InternalServiceException
     *         The service encountered an internal error.
     * @sample AWSApplicationAutoScaling.DeleteScalingPolicy
     */
    @Override
    public DeleteScalingPolicyResult deleteScalingPolicy(
            DeleteScalingPolicyRequest deleteScalingPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteScalingPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeleteScalingPolicyRequest> request = null;
        Response<DeleteScalingPolicyResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeleteScalingPolicyRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(deleteScalingPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeleteScalingPolicyResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new DeleteScalingPolicyResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Deregisters a scalable target that was previously registered. If you are
     * no longer using a scalable target, you can delete it with this operation.
     * When you deregister a scalable target, all of the scaling policies that
     * are associated with that scalable target are deleted.
     * </p>
     * <p>
     * To create a new scalable target or update an existing one, see
     * <a>RegisterScalableTarget</a>.
     * </p>
     * 
     * @param deregisterScalableTargetRequest
     * @return Result of the DeregisterScalableTarget operation returned by the
     *         service.
     * @throws ValidationException
     *         An exception was thrown for a validation issue. Review the
     *         available parameters for the API request.
     * @throws ObjectNotFoundException
     *         The specified object could not be found. For any <code>Put</code>
     *         or <code>Register</code> API operation, which depends on the
     *         existence of a scalable target, this exception is thrown if the
     *         scalable target with the specified service namespace, resource
     *         ID, and scalable dimension does not exist. For any
     *         <code>Delete</code> or <code>Deregister</code> API operation,
     *         this exception is thrown if the resource that is to be deleted or
     *         deregistered cannot be found.
     * @throws ConcurrentUpdateException
     *         Concurrent updates caused an exception, for example, if you
     *         request an update to an Application Auto Scaling resource that
     *         already has a pending update.
     * @throws InternalServiceException
     *         The service encountered an internal error.
     * @sample AWSApplicationAutoScaling.DeregisterScalableTarget
     */
    @Override
    public DeregisterScalableTargetResult deregisterScalableTarget(
            DeregisterScalableTargetRequest deregisterScalableTargetRequest) {
        ExecutionContext executionContext = createExecutionContext(deregisterScalableTargetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DeregisterScalableTargetRequest> request = null;
        Response<DeregisterScalableTargetResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DeregisterScalableTargetRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(deregisterScalableTargetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DeregisterScalableTargetResult>> responseHandler = protocolFactory
                    .createResponseHandler(
                            new JsonOperationMetadata().withPayloadJson(true)
                                    .withHasStreamingSuccessResponse(false),
                            new DeregisterScalableTargetResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Provides descriptive information for scalable targets with a specified
     * service namespace.
     * </p>
     * <p>
     * You can filter the results in a service namespace with the
     * <code>ResourceIds</code> and <code>ScalableDimension</code> parameters.
     * </p>
     * <p>
     * To create a new scalable target or update an existing one, see
     * <a>RegisterScalableTarget</a>. If you are no longer using a scalable
     * target, you can deregister it with <a>DeregisterScalableTarget</a>.
     * </p>
     * 
     * @param describeScalableTargetsRequest
     * @return Result of the DescribeScalableTargets operation returned by the
     *         service.
     * @throws ValidationException
     *         An exception was thrown for a validation issue. Review the
     *         available parameters for the API request.
     * @throws InvalidNextTokenException
     *         The next token supplied was invalid.
     * @throws ConcurrentUpdateException
     *         Concurrent updates caused an exception, for example, if you
     *         request an update to an Application Auto Scaling resource that
     *         already has a pending update.
     * @throws InternalServiceException
     *         The service encountered an internal error.
     * @sample AWSApplicationAutoScaling.DescribeScalableTargets
     */
    @Override
    public DescribeScalableTargetsResult describeScalableTargets(
            DescribeScalableTargetsRequest describeScalableTargetsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeScalableTargetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeScalableTargetsRequest> request = null;
        Response<DescribeScalableTargetsResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeScalableTargetsRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(describeScalableTargetsRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DescribeScalableTargetsResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new DescribeScalableTargetsResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Provides descriptive information for scaling activities with a specified
     * service namespace.
     * </p>
     * <p>
     * You can filter the results in a service namespace with the
     * <code>ResourceId</code> and <code>ScalableDimension</code> parameters.
     * </p>
     * <p>
     * Scaling activities are triggered by CloudWatch alarms that are associated
     * with scaling policies. To view the existing scaling policies for a
     * service namespace, see <a>DescribeScalingPolicies</a>. To create a new
     * scaling policy or update an existing one, see <a>PutScalingPolicy</a>.
     * </p>
     * 
     * @param describeScalingActivitiesRequest
     * @return Result of the DescribeScalingActivities operation returned by the
     *         service.
     * @throws ValidationException
     *         An exception was thrown for a validation issue. Review the
     *         available parameters for the API request.
     * @throws InvalidNextTokenException
     *         The next token supplied was invalid.
     * @throws ConcurrentUpdateException
     *         Concurrent updates caused an exception, for example, if you
     *         request an update to an Application Auto Scaling resource that
     *         already has a pending update.
     * @throws InternalServiceException
     *         The service encountered an internal error.
     * @sample AWSApplicationAutoScaling.DescribeScalingActivities
     */
    @Override
    public DescribeScalingActivitiesResult describeScalingActivities(
            DescribeScalingActivitiesRequest describeScalingActivitiesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeScalingActivitiesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeScalingActivitiesRequest> request = null;
        Response<DescribeScalingActivitiesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeScalingActivitiesRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(describeScalingActivitiesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DescribeScalingActivitiesResult>> responseHandler = protocolFactory
                    .createResponseHandler(
                            new JsonOperationMetadata().withPayloadJson(true)
                                    .withHasStreamingSuccessResponse(false),
                            new DescribeScalingActivitiesResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Provides descriptive information for scaling policies with a specified
     * service namespace.
     * </p>
     * <p>
     * You can filter the results in a service namespace with the
     * <code>ResourceId</code>, <code>ScalableDimension</code>, and
     * <code>PolicyNames</code> parameters.
     * </p>
     * <p>
     * To create a new scaling policy or update an existing one, see
     * <a>PutScalingPolicy</a>. If you are no longer using a scaling policy, you
     * can delete it with <a>DeleteScalingPolicy</a>.
     * </p>
     * 
     * @param describeScalingPoliciesRequest
     * @return Result of the DescribeScalingPolicies operation returned by the
     *         service.
     * @throws ValidationException
     *         An exception was thrown for a validation issue. Review the
     *         available parameters for the API request.
     * @throws FailedResourceAccessException
     *         Failed access to resources caused an exception. This exception
     *         currently only applies to <a>DescribeScalingPolicies</a>. It is
     *         thrown when Application Auto Scaling is unable to retrieve the
     *         alarms associated with a scaling policy due to a client error,
     *         for example, if the role ARN specified for a scalable target does
     *         not have the proper permissions to call the CloudWatch <a href=
     *         "http://docs.aws.amazon.com/AmazonCloudWatch/latest/APIReference/API_DescribeAlarms.html"
     *         >DescribeAlarms</a> API operation on behalf of your account.
     * @throws InvalidNextTokenException
     *         The next token supplied was invalid.
     * @throws ConcurrentUpdateException
     *         Concurrent updates caused an exception, for example, if you
     *         request an update to an Application Auto Scaling resource that
     *         already has a pending update.
     * @throws InternalServiceException
     *         The service encountered an internal error.
     * @sample AWSApplicationAutoScaling.DescribeScalingPolicies
     */
    @Override
    public DescribeScalingPoliciesResult describeScalingPolicies(
            DescribeScalingPoliciesRequest describeScalingPoliciesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeScalingPoliciesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<DescribeScalingPoliciesRequest> request = null;
        Response<DescribeScalingPoliciesResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new DescribeScalingPoliciesRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(describeScalingPoliciesRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<DescribeScalingPoliciesResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new DescribeScalingPoliciesResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Creates or updates a policy for an existing Application Auto Scaling
     * scalable target. Each scalable target is identified by service namespace,
     * a resource ID, and a scalable dimension, and a scaling policy applies to
     * a scalable target that is identified by those three attributes. You
     * cannot create a scaling policy without first registering a scalable
     * target with <a>RegisterScalableTarget</a>.
     * </p>
     * <p>
     * To update an existing policy, use the existing policy name and set the
     * parameters you want to change. Any existing parameter not changed in an
     * update to an existing policy is not changed in this update request.
     * </p>
     * <p>
     * You can view the existing scaling policies for a service namespace with
     * <a>DescribeScalingPolicies</a>. If you are no longer using a scaling
     * policy, you can delete it with <a>DeleteScalingPolicy</a>.
     * </p>
     * 
     * @param putScalingPolicyRequest
     * @return Result of the PutScalingPolicy operation returned by the service.
     * @throws ValidationException
     *         An exception was thrown for a validation issue. Review the
     *         available parameters for the API request.
     * @throws LimitExceededException
     *         Your account exceeded a limit. This exception is thrown when a
     *         per-account resource limit is exceeded. Application Auto Scaling
     *         has a limit of 40 scalable targets per account for Amazon ECS
     *         services, 50 scaling policies per scalable target, and 20 step
     *         adjustments per step scaling policy.
     * @throws ObjectNotFoundException
     *         The specified object could not be found. For any <code>Put</code>
     *         or <code>Register</code> API operation, which depends on the
     *         existence of a scalable target, this exception is thrown if the
     *         scalable target with the specified service namespace, resource
     *         ID, and scalable dimension does not exist. For any
     *         <code>Delete</code> or <code>Deregister</code> API operation,
     *         this exception is thrown if the resource that is to be deleted or
     *         deregistered cannot be found.
     * @throws ConcurrentUpdateException
     *         Concurrent updates caused an exception, for example, if you
     *         request an update to an Application Auto Scaling resource that
     *         already has a pending update.
     * @throws InternalServiceException
     *         The service encountered an internal error.
     * @sample AWSApplicationAutoScaling.PutScalingPolicy
     */
    @Override
    public PutScalingPolicyResult putScalingPolicy(
            PutScalingPolicyRequest putScalingPolicyRequest) {
        ExecutionContext executionContext = createExecutionContext(putScalingPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<PutScalingPolicyRequest> request = null;
        Response<PutScalingPolicyResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new PutScalingPolicyRequestMarshaller(protocolFactory)
                        .marshall(super
                                .beforeMarshalling(putScalingPolicyRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<PutScalingPolicyResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new PutScalingPolicyResultJsonUnmarshaller());
            response = invoke(request, responseHandler, executionContext);

            return response.getAwsResponse();

        } finally {

            endClientExecution(awsRequestMetrics, request, response);
        }
    }

    /**
     * <p>
     * Registers or updates a scalable target. A scalable target is a resource
     * that can be scaled up or down with Application Auto Scaling. After you
     * have registered a scalable target, you can use this command to update the
     * minimum and maximum values for your scalable dimension.
     * </p>
     * <note>
     * <p>
     * At this time, Application Auto Scaling only supports scaling Amazon ECS
     * services.
     * </p>
     * </note>
     * <p>
     * After you register a scalable target with Application Auto Scaling, you
     * can create and apply scaling policies to it with <a>PutScalingPolicy</a>.
     * You can view the existing scaling policies for a service namespace with
     * <a>DescribeScalableTargets</a>. If you are no longer using a scalable
     * target, you can deregister it with <a>DeregisterScalableTarget</a>.
     * </p>
     * 
     * @param registerScalableTargetRequest
     * @return Result of the RegisterScalableTarget operation returned by the
     *         service.
     * @throws ValidationException
     *         An exception was thrown for a validation issue. Review the
     *         available parameters for the API request.
     * @throws LimitExceededException
     *         Your account exceeded a limit. This exception is thrown when a
     *         per-account resource limit is exceeded. Application Auto Scaling
     *         has a limit of 40 scalable targets per account for Amazon ECS
     *         services, 50 scaling policies per scalable target, and 20 step
     *         adjustments per step scaling policy.
     * @throws ConcurrentUpdateException
     *         Concurrent updates caused an exception, for example, if you
     *         request an update to an Application Auto Scaling resource that
     *         already has a pending update.
     * @throws InternalServiceException
     *         The service encountered an internal error.
     * @sample AWSApplicationAutoScaling.RegisterScalableTarget
     */
    @Override
    public RegisterScalableTargetResult registerScalableTarget(
            RegisterScalableTargetRequest registerScalableTargetRequest) {
        ExecutionContext executionContext = createExecutionContext(registerScalableTargetRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext
                .getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        Request<RegisterScalableTargetRequest> request = null;
        Response<RegisterScalableTargetResult> response = null;

        try {
            awsRequestMetrics.startEvent(Field.RequestMarshallTime);
            try {
                request = new RegisterScalableTargetRequestMarshaller(
                        protocolFactory).marshall(super
                        .beforeMarshalling(registerScalableTargetRequest));
                // Binds the request metrics to the current request.
                request.setAWSRequestMetrics(awsRequestMetrics);
            } finally {
                awsRequestMetrics.endEvent(Field.RequestMarshallTime);
            }

            HttpResponseHandler<AmazonWebServiceResponse<RegisterScalableTargetResult>> responseHandler = protocolFactory
                    .createResponseHandler(new JsonOperationMetadata()
                            .withPayloadJson(true)
                            .withHasStreamingSuccessResponse(false),
                            new RegisterScalableTargetResultJsonUnmarshaller());
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
                .createErrorResponseHandler(new JsonErrorResponseMetadata());

        return client.execute(request, responseHandler, errorResponseHandler,
                executionContext);
    }

}
