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
package com.amazonaws.services.elasticloadbalancing;

import com.amazonaws.services.elasticloadbalancing.model.*;
import com.amazonaws.client.AwsAsyncClientParams;
import com.amazonaws.annotation.ThreadSafe;

/**
 * Interface for accessing Elastic Load Balancing asynchronously. Each
 * asynchronous method will return a Java Future object representing the
 * asynchronous operation; overloads which accept an {@code AsyncHandler} can be
 * used to receive notification when an asynchronous operation completes.
 * <p>
 * <fullname>Elastic Load Balancing</fullname>
 * <p>
 * Elastic Load Balancing distributes incoming traffic across your EC2
 * instances.
 * </p>
 * <p>
 * For information about the features of Elastic Load Balancing, see <a href=
 * "http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/elastic-load-balancing.html"
 * >What Is Elastic Load Balancing?</a> in the <i>Elastic Load Balancing
 * Developer Guide</i>.
 * </p>
 * <p>
 * For information about the AWS regions supported by Elastic Load Balancing,
 * see <a
 * href="http://docs.aws.amazon.com/general/latest/gr/rande.html#elb_region"
 * >Regions and Endpoints - Elastic Load Balancing</a> in the <i>Amazon Web
 * Services General Reference</i>.
 * </p>
 * <p>
 * All Elastic Load Balancing operations are <i>idempotent</i>, which means that
 * they complete at most one time. If you repeat an operation, it succeeds with
 * a 200 OK response code.
 * </p>
 */
@ThreadSafe
public class AmazonElasticLoadBalancingAsyncClient extends
        AmazonElasticLoadBalancingClient implements
        AmazonElasticLoadBalancingAsync {

    private static final int DEFAULT_THREAD_POOL_SIZE = 50;

    private final java.util.concurrent.ExecutorService executorService;

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing. A credentials provider chain will be used that searches
     * for credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Credential profiles file at the default location (~/.aws/credentials)
     * shared by all AWS SDKs and the AWS CLI</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * 50 threads (to match the default maximum number of concurrent connections
     * to the service).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonElasticLoadBalancingAsyncClient() {
        this(new com.amazonaws.auth.DefaultAWSCredentialsProviderChain());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing. A credentials provider chain will be used that searches
     * for credentials in this order:
     * <ul>
     * <li>Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY</li>
     * <li>Java System Properties - aws.accessKeyId and aws.secretKey</li>
     * <li>Credential profiles file at the default location (~/.aws/credentials)
     * shared by all AWS SDKs and the AWS CLI</li>
     * <li>Instance profile credentials delivered through the Amazon EC2
     * metadata service</li>
     * </ul>
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * a number of threads equal to the maximum number of concurrent connections
     * configured via {@code ClientConfiguration.getMaxConnections()}.
     *
     * @param clientConfiguration
     *        The client configuration options controlling how this client
     *        connects to Elastic Load Balancing (ex: proxy settings, retry
     *        counts, etc).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonElasticLoadBalancingAsyncClient(
            com.amazonaws.ClientConfiguration clientConfiguration) {
        this(new com.amazonaws.auth.DefaultAWSCredentialsProviderChain(),
                clientConfiguration, java.util.concurrent.Executors
                        .newFixedThreadPool(clientConfiguration
                                .getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing using the specified AWS account credentials.
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * 50 threads (to match the default maximum number of concurrent connections
     * to the service).
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonElasticLoadBalancingAsyncClient(
            com.amazonaws.auth.AWSCredentials awsCredentials) {
        this(awsCredentials, java.util.concurrent.Executors
                .newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing using the specified AWS account credentials and executor
     * service. Default client settings will be used.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonElasticLoadBalancingAsyncClient(
            com.amazonaws.auth.AWSCredentials awsCredentials,
            java.util.concurrent.ExecutorService executorService) {

        this(awsCredentials, configFactory.getConfig(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing using the specified AWS account credentials, executor
     * service, and client configuration options.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     * @param clientConfiguration
     *        Client configuration options (ex: max retry limit, proxy settings,
     *        etc).
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonElasticLoadBalancingAsyncClient(
            com.amazonaws.auth.AWSCredentials awsCredentials,
            com.amazonaws.ClientConfiguration clientConfiguration,
            java.util.concurrent.ExecutorService executorService) {

        super(awsCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing using the specified AWS account credentials provider.
     * Default client settings will be used.
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * 50 threads (to match the default maximum number of concurrent connections
     * to the service).
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonElasticLoadBalancingAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, java.util.concurrent.Executors
                .newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing using the provided AWS account credentials provider and
     * client configuration options.
     * <p>
     * Asynchronous methods are delegated to a fixed-size thread pool containing
     * a number of threads equal to the maximum number of concurrent connections
     * configured via {@code ClientConfiguration.getMaxConnections()}.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @param clientConfiguration
     *        Client configuration options (ex: max retry limit, proxy settings,
     *        etc).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonElasticLoadBalancingAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            com.amazonaws.ClientConfiguration clientConfiguration) {

        this(awsCredentialsProvider, clientConfiguration,
                java.util.concurrent.Executors
                        .newFixedThreadPool(clientConfiguration
                                .getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing using the specified AWS account credentials provider and
     * executor service. Default client settings will be used.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonElasticLoadBalancingAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            java.util.concurrent.ExecutorService executorService) {

        this(awsCredentialsProvider, configFactory.getConfig(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing using the specified AWS account credentials provider,
     * executor service, and client configuration options.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @param clientConfiguration
     *        Client configuration options (ex: max retry limit, proxy settings,
     *        etc).
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonElasticLoadBalancingAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            com.amazonaws.ClientConfiguration clientConfiguration,
            java.util.concurrent.ExecutorService executorService) {

        super(awsCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Elastic
     * Load Balancing using the specified parameters.
     *
     * @param asyncClientParams
     *        Object providing client parameters.
     */
    AmazonElasticLoadBalancingAsyncClient(AwsAsyncClientParams asyncClientParams) {
        super(asyncClientParams);
        this.executorService = asyncClientParams.getExecutor();
    }

    /**
     * Returns the executor service used by this client to execute async
     * requests.
     *
     * @return The executor service used by this client to execute async
     *         requests.
     */
    public java.util.concurrent.ExecutorService getExecutorService() {
        return executorService;
    }

    @Override
    public java.util.concurrent.Future<AddTagsResult> addTagsAsync(
            AddTagsRequest request) {

        return addTagsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<AddTagsResult> addTagsAsync(
            final AddTagsRequest request,
            final com.amazonaws.handlers.AsyncHandler<AddTagsRequest, AddTagsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<AddTagsResult>() {
                    @Override
                    public AddTagsResult call() throws Exception {
                        AddTagsResult result;

                        try {
                            result = addTags(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ApplySecurityGroupsToLoadBalancerResult> applySecurityGroupsToLoadBalancerAsync(
            ApplySecurityGroupsToLoadBalancerRequest request) {

        return applySecurityGroupsToLoadBalancerAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ApplySecurityGroupsToLoadBalancerResult> applySecurityGroupsToLoadBalancerAsync(
            final ApplySecurityGroupsToLoadBalancerRequest request,
            final com.amazonaws.handlers.AsyncHandler<ApplySecurityGroupsToLoadBalancerRequest, ApplySecurityGroupsToLoadBalancerResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ApplySecurityGroupsToLoadBalancerResult>() {
                    @Override
                    public ApplySecurityGroupsToLoadBalancerResult call()
                            throws Exception {
                        ApplySecurityGroupsToLoadBalancerResult result;

                        try {
                            result = applySecurityGroupsToLoadBalancer(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<AttachLoadBalancerToSubnetsResult> attachLoadBalancerToSubnetsAsync(
            AttachLoadBalancerToSubnetsRequest request) {

        return attachLoadBalancerToSubnetsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<AttachLoadBalancerToSubnetsResult> attachLoadBalancerToSubnetsAsync(
            final AttachLoadBalancerToSubnetsRequest request,
            final com.amazonaws.handlers.AsyncHandler<AttachLoadBalancerToSubnetsRequest, AttachLoadBalancerToSubnetsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<AttachLoadBalancerToSubnetsResult>() {
                    @Override
                    public AttachLoadBalancerToSubnetsResult call()
                            throws Exception {
                        AttachLoadBalancerToSubnetsResult result;

                        try {
                            result = attachLoadBalancerToSubnets(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ConfigureHealthCheckResult> configureHealthCheckAsync(
            ConfigureHealthCheckRequest request) {

        return configureHealthCheckAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ConfigureHealthCheckResult> configureHealthCheckAsync(
            final ConfigureHealthCheckRequest request,
            final com.amazonaws.handlers.AsyncHandler<ConfigureHealthCheckRequest, ConfigureHealthCheckResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ConfigureHealthCheckResult>() {
                    @Override
                    public ConfigureHealthCheckResult call() throws Exception {
                        ConfigureHealthCheckResult result;

                        try {
                            result = configureHealthCheck(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<CreateAppCookieStickinessPolicyResult> createAppCookieStickinessPolicyAsync(
            CreateAppCookieStickinessPolicyRequest request) {

        return createAppCookieStickinessPolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CreateAppCookieStickinessPolicyResult> createAppCookieStickinessPolicyAsync(
            final CreateAppCookieStickinessPolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateAppCookieStickinessPolicyRequest, CreateAppCookieStickinessPolicyResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CreateAppCookieStickinessPolicyResult>() {
                    @Override
                    public CreateAppCookieStickinessPolicyResult call()
                            throws Exception {
                        CreateAppCookieStickinessPolicyResult result;

                        try {
                            result = createAppCookieStickinessPolicy(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<CreateLBCookieStickinessPolicyResult> createLBCookieStickinessPolicyAsync(
            CreateLBCookieStickinessPolicyRequest request) {

        return createLBCookieStickinessPolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CreateLBCookieStickinessPolicyResult> createLBCookieStickinessPolicyAsync(
            final CreateLBCookieStickinessPolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateLBCookieStickinessPolicyRequest, CreateLBCookieStickinessPolicyResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CreateLBCookieStickinessPolicyResult>() {
                    @Override
                    public CreateLBCookieStickinessPolicyResult call()
                            throws Exception {
                        CreateLBCookieStickinessPolicyResult result;

                        try {
                            result = createLBCookieStickinessPolicy(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<CreateLoadBalancerResult> createLoadBalancerAsync(
            CreateLoadBalancerRequest request) {

        return createLoadBalancerAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CreateLoadBalancerResult> createLoadBalancerAsync(
            final CreateLoadBalancerRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateLoadBalancerRequest, CreateLoadBalancerResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CreateLoadBalancerResult>() {
                    @Override
                    public CreateLoadBalancerResult call() throws Exception {
                        CreateLoadBalancerResult result;

                        try {
                            result = createLoadBalancer(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<CreateLoadBalancerListenersResult> createLoadBalancerListenersAsync(
            CreateLoadBalancerListenersRequest request) {

        return createLoadBalancerListenersAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CreateLoadBalancerListenersResult> createLoadBalancerListenersAsync(
            final CreateLoadBalancerListenersRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateLoadBalancerListenersRequest, CreateLoadBalancerListenersResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CreateLoadBalancerListenersResult>() {
                    @Override
                    public CreateLoadBalancerListenersResult call()
                            throws Exception {
                        CreateLoadBalancerListenersResult result;

                        try {
                            result = createLoadBalancerListeners(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<CreateLoadBalancerPolicyResult> createLoadBalancerPolicyAsync(
            CreateLoadBalancerPolicyRequest request) {

        return createLoadBalancerPolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CreateLoadBalancerPolicyResult> createLoadBalancerPolicyAsync(
            final CreateLoadBalancerPolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateLoadBalancerPolicyRequest, CreateLoadBalancerPolicyResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CreateLoadBalancerPolicyResult>() {
                    @Override
                    public CreateLoadBalancerPolicyResult call()
                            throws Exception {
                        CreateLoadBalancerPolicyResult result;

                        try {
                            result = createLoadBalancerPolicy(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DeleteLoadBalancerResult> deleteLoadBalancerAsync(
            DeleteLoadBalancerRequest request) {

        return deleteLoadBalancerAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeleteLoadBalancerResult> deleteLoadBalancerAsync(
            final DeleteLoadBalancerRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteLoadBalancerRequest, DeleteLoadBalancerResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteLoadBalancerResult>() {
                    @Override
                    public DeleteLoadBalancerResult call() throws Exception {
                        DeleteLoadBalancerResult result;

                        try {
                            result = deleteLoadBalancer(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DeleteLoadBalancerListenersResult> deleteLoadBalancerListenersAsync(
            DeleteLoadBalancerListenersRequest request) {

        return deleteLoadBalancerListenersAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeleteLoadBalancerListenersResult> deleteLoadBalancerListenersAsync(
            final DeleteLoadBalancerListenersRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteLoadBalancerListenersRequest, DeleteLoadBalancerListenersResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteLoadBalancerListenersResult>() {
                    @Override
                    public DeleteLoadBalancerListenersResult call()
                            throws Exception {
                        DeleteLoadBalancerListenersResult result;

                        try {
                            result = deleteLoadBalancerListeners(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DeleteLoadBalancerPolicyResult> deleteLoadBalancerPolicyAsync(
            DeleteLoadBalancerPolicyRequest request) {

        return deleteLoadBalancerPolicyAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeleteLoadBalancerPolicyResult> deleteLoadBalancerPolicyAsync(
            final DeleteLoadBalancerPolicyRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteLoadBalancerPolicyRequest, DeleteLoadBalancerPolicyResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteLoadBalancerPolicyResult>() {
                    @Override
                    public DeleteLoadBalancerPolicyResult call()
                            throws Exception {
                        DeleteLoadBalancerPolicyResult result;

                        try {
                            result = deleteLoadBalancerPolicy(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DeregisterInstancesFromLoadBalancerResult> deregisterInstancesFromLoadBalancerAsync(
            DeregisterInstancesFromLoadBalancerRequest request) {

        return deregisterInstancesFromLoadBalancerAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeregisterInstancesFromLoadBalancerResult> deregisterInstancesFromLoadBalancerAsync(
            final DeregisterInstancesFromLoadBalancerRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeregisterInstancesFromLoadBalancerRequest, DeregisterInstancesFromLoadBalancerResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeregisterInstancesFromLoadBalancerResult>() {
                    @Override
                    public DeregisterInstancesFromLoadBalancerResult call()
                            throws Exception {
                        DeregisterInstancesFromLoadBalancerResult result;

                        try {
                            result = deregisterInstancesFromLoadBalancer(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DescribeInstanceHealthResult> describeInstanceHealthAsync(
            DescribeInstanceHealthRequest request) {

        return describeInstanceHealthAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeInstanceHealthResult> describeInstanceHealthAsync(
            final DescribeInstanceHealthRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeInstanceHealthRequest, DescribeInstanceHealthResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeInstanceHealthResult>() {
                    @Override
                    public DescribeInstanceHealthResult call() throws Exception {
                        DescribeInstanceHealthResult result;

                        try {
                            result = describeInstanceHealth(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DescribeLoadBalancerAttributesResult> describeLoadBalancerAttributesAsync(
            DescribeLoadBalancerAttributesRequest request) {

        return describeLoadBalancerAttributesAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeLoadBalancerAttributesResult> describeLoadBalancerAttributesAsync(
            final DescribeLoadBalancerAttributesRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeLoadBalancerAttributesRequest, DescribeLoadBalancerAttributesResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeLoadBalancerAttributesResult>() {
                    @Override
                    public DescribeLoadBalancerAttributesResult call()
                            throws Exception {
                        DescribeLoadBalancerAttributesResult result;

                        try {
                            result = describeLoadBalancerAttributes(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DescribeLoadBalancerPoliciesResult> describeLoadBalancerPoliciesAsync(
            DescribeLoadBalancerPoliciesRequest request) {

        return describeLoadBalancerPoliciesAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeLoadBalancerPoliciesResult> describeLoadBalancerPoliciesAsync(
            final DescribeLoadBalancerPoliciesRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeLoadBalancerPoliciesRequest, DescribeLoadBalancerPoliciesResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeLoadBalancerPoliciesResult>() {
                    @Override
                    public DescribeLoadBalancerPoliciesResult call()
                            throws Exception {
                        DescribeLoadBalancerPoliciesResult result;

                        try {
                            result = describeLoadBalancerPolicies(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    /**
     * Simplified method form for invoking the DescribeLoadBalancerPolicies
     * operation.
     *
     * @see #describeLoadBalancerPoliciesAsync(DescribeLoadBalancerPoliciesRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeLoadBalancerPoliciesResult> describeLoadBalancerPoliciesAsync() {

        return describeLoadBalancerPoliciesAsync(new DescribeLoadBalancerPoliciesRequest());
    }

    /**
     * Simplified method form for invoking the DescribeLoadBalancerPolicies
     * operation with an AsyncHandler.
     *
     * @see #describeLoadBalancerPoliciesAsync(DescribeLoadBalancerPoliciesRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeLoadBalancerPoliciesResult> describeLoadBalancerPoliciesAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeLoadBalancerPoliciesRequest, DescribeLoadBalancerPoliciesResult> asyncHandler) {

        return describeLoadBalancerPoliciesAsync(
                new DescribeLoadBalancerPoliciesRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeLoadBalancerPolicyTypesResult> describeLoadBalancerPolicyTypesAsync(
            DescribeLoadBalancerPolicyTypesRequest request) {

        return describeLoadBalancerPolicyTypesAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeLoadBalancerPolicyTypesResult> describeLoadBalancerPolicyTypesAsync(
            final DescribeLoadBalancerPolicyTypesRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeLoadBalancerPolicyTypesRequest, DescribeLoadBalancerPolicyTypesResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeLoadBalancerPolicyTypesResult>() {
                    @Override
                    public DescribeLoadBalancerPolicyTypesResult call()
                            throws Exception {
                        DescribeLoadBalancerPolicyTypesResult result;

                        try {
                            result = describeLoadBalancerPolicyTypes(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    /**
     * Simplified method form for invoking the DescribeLoadBalancerPolicyTypes
     * operation.
     *
     * @see #describeLoadBalancerPolicyTypesAsync(DescribeLoadBalancerPolicyTypesRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeLoadBalancerPolicyTypesResult> describeLoadBalancerPolicyTypesAsync() {

        return describeLoadBalancerPolicyTypesAsync(new DescribeLoadBalancerPolicyTypesRequest());
    }

    /**
     * Simplified method form for invoking the DescribeLoadBalancerPolicyTypes
     * operation with an AsyncHandler.
     *
     * @see #describeLoadBalancerPolicyTypesAsync(DescribeLoadBalancerPolicyTypesRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeLoadBalancerPolicyTypesResult> describeLoadBalancerPolicyTypesAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeLoadBalancerPolicyTypesRequest, DescribeLoadBalancerPolicyTypesResult> asyncHandler) {

        return describeLoadBalancerPolicyTypesAsync(
                new DescribeLoadBalancerPolicyTypesRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeLoadBalancersResult> describeLoadBalancersAsync(
            DescribeLoadBalancersRequest request) {

        return describeLoadBalancersAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeLoadBalancersResult> describeLoadBalancersAsync(
            final DescribeLoadBalancersRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeLoadBalancersRequest, DescribeLoadBalancersResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeLoadBalancersResult>() {
                    @Override
                    public DescribeLoadBalancersResult call() throws Exception {
                        DescribeLoadBalancersResult result;

                        try {
                            result = describeLoadBalancers(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    /**
     * Simplified method form for invoking the DescribeLoadBalancers operation.
     *
     * @see #describeLoadBalancersAsync(DescribeLoadBalancersRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeLoadBalancersResult> describeLoadBalancersAsync() {

        return describeLoadBalancersAsync(new DescribeLoadBalancersRequest());
    }

    /**
     * Simplified method form for invoking the DescribeLoadBalancers operation
     * with an AsyncHandler.
     *
     * @see #describeLoadBalancersAsync(DescribeLoadBalancersRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeLoadBalancersResult> describeLoadBalancersAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeLoadBalancersRequest, DescribeLoadBalancersResult> asyncHandler) {

        return describeLoadBalancersAsync(new DescribeLoadBalancersRequest(),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeTagsResult> describeTagsAsync(
            DescribeTagsRequest request) {

        return describeTagsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeTagsResult> describeTagsAsync(
            final DescribeTagsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeTagsRequest, DescribeTagsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeTagsResult>() {
                    @Override
                    public DescribeTagsResult call() throws Exception {
                        DescribeTagsResult result;

                        try {
                            result = describeTags(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DetachLoadBalancerFromSubnetsResult> detachLoadBalancerFromSubnetsAsync(
            DetachLoadBalancerFromSubnetsRequest request) {

        return detachLoadBalancerFromSubnetsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DetachLoadBalancerFromSubnetsResult> detachLoadBalancerFromSubnetsAsync(
            final DetachLoadBalancerFromSubnetsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DetachLoadBalancerFromSubnetsRequest, DetachLoadBalancerFromSubnetsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DetachLoadBalancerFromSubnetsResult>() {
                    @Override
                    public DetachLoadBalancerFromSubnetsResult call()
                            throws Exception {
                        DetachLoadBalancerFromSubnetsResult result;

                        try {
                            result = detachLoadBalancerFromSubnets(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<DisableAvailabilityZonesForLoadBalancerResult> disableAvailabilityZonesForLoadBalancerAsync(
            DisableAvailabilityZonesForLoadBalancerRequest request) {

        return disableAvailabilityZonesForLoadBalancerAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DisableAvailabilityZonesForLoadBalancerResult> disableAvailabilityZonesForLoadBalancerAsync(
            final DisableAvailabilityZonesForLoadBalancerRequest request,
            final com.amazonaws.handlers.AsyncHandler<DisableAvailabilityZonesForLoadBalancerRequest, DisableAvailabilityZonesForLoadBalancerResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DisableAvailabilityZonesForLoadBalancerResult>() {
                    @Override
                    public DisableAvailabilityZonesForLoadBalancerResult call()
                            throws Exception {
                        DisableAvailabilityZonesForLoadBalancerResult result;

                        try {
                            result = disableAvailabilityZonesForLoadBalancer(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<EnableAvailabilityZonesForLoadBalancerResult> enableAvailabilityZonesForLoadBalancerAsync(
            EnableAvailabilityZonesForLoadBalancerRequest request) {

        return enableAvailabilityZonesForLoadBalancerAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<EnableAvailabilityZonesForLoadBalancerResult> enableAvailabilityZonesForLoadBalancerAsync(
            final EnableAvailabilityZonesForLoadBalancerRequest request,
            final com.amazonaws.handlers.AsyncHandler<EnableAvailabilityZonesForLoadBalancerRequest, EnableAvailabilityZonesForLoadBalancerResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<EnableAvailabilityZonesForLoadBalancerResult>() {
                    @Override
                    public EnableAvailabilityZonesForLoadBalancerResult call()
                            throws Exception {
                        EnableAvailabilityZonesForLoadBalancerResult result;

                        try {
                            result = enableAvailabilityZonesForLoadBalancer(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<ModifyLoadBalancerAttributesResult> modifyLoadBalancerAttributesAsync(
            ModifyLoadBalancerAttributesRequest request) {

        return modifyLoadBalancerAttributesAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ModifyLoadBalancerAttributesResult> modifyLoadBalancerAttributesAsync(
            final ModifyLoadBalancerAttributesRequest request,
            final com.amazonaws.handlers.AsyncHandler<ModifyLoadBalancerAttributesRequest, ModifyLoadBalancerAttributesResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ModifyLoadBalancerAttributesResult>() {
                    @Override
                    public ModifyLoadBalancerAttributesResult call()
                            throws Exception {
                        ModifyLoadBalancerAttributesResult result;

                        try {
                            result = modifyLoadBalancerAttributes(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<RegisterInstancesWithLoadBalancerResult> registerInstancesWithLoadBalancerAsync(
            RegisterInstancesWithLoadBalancerRequest request) {

        return registerInstancesWithLoadBalancerAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<RegisterInstancesWithLoadBalancerResult> registerInstancesWithLoadBalancerAsync(
            final RegisterInstancesWithLoadBalancerRequest request,
            final com.amazonaws.handlers.AsyncHandler<RegisterInstancesWithLoadBalancerRequest, RegisterInstancesWithLoadBalancerResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<RegisterInstancesWithLoadBalancerResult>() {
                    @Override
                    public RegisterInstancesWithLoadBalancerResult call()
                            throws Exception {
                        RegisterInstancesWithLoadBalancerResult result;

                        try {
                            result = registerInstancesWithLoadBalancer(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<RemoveTagsResult> removeTagsAsync(
            RemoveTagsRequest request) {

        return removeTagsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<RemoveTagsResult> removeTagsAsync(
            final RemoveTagsRequest request,
            final com.amazonaws.handlers.AsyncHandler<RemoveTagsRequest, RemoveTagsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<RemoveTagsResult>() {
                    @Override
                    public RemoveTagsResult call() throws Exception {
                        RemoveTagsResult result;

                        try {
                            result = removeTags(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<SetLoadBalancerListenerSSLCertificateResult> setLoadBalancerListenerSSLCertificateAsync(
            SetLoadBalancerListenerSSLCertificateRequest request) {

        return setLoadBalancerListenerSSLCertificateAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<SetLoadBalancerListenerSSLCertificateResult> setLoadBalancerListenerSSLCertificateAsync(
            final SetLoadBalancerListenerSSLCertificateRequest request,
            final com.amazonaws.handlers.AsyncHandler<SetLoadBalancerListenerSSLCertificateRequest, SetLoadBalancerListenerSSLCertificateResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<SetLoadBalancerListenerSSLCertificateResult>() {
                    @Override
                    public SetLoadBalancerListenerSSLCertificateResult call()
                            throws Exception {
                        SetLoadBalancerListenerSSLCertificateResult result;

                        try {
                            result = setLoadBalancerListenerSSLCertificate(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<SetLoadBalancerPoliciesForBackendServerResult> setLoadBalancerPoliciesForBackendServerAsync(
            SetLoadBalancerPoliciesForBackendServerRequest request) {

        return setLoadBalancerPoliciesForBackendServerAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<SetLoadBalancerPoliciesForBackendServerResult> setLoadBalancerPoliciesForBackendServerAsync(
            final SetLoadBalancerPoliciesForBackendServerRequest request,
            final com.amazonaws.handlers.AsyncHandler<SetLoadBalancerPoliciesForBackendServerRequest, SetLoadBalancerPoliciesForBackendServerResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<SetLoadBalancerPoliciesForBackendServerResult>() {
                    @Override
                    public SetLoadBalancerPoliciesForBackendServerResult call()
                            throws Exception {
                        SetLoadBalancerPoliciesForBackendServerResult result;

                        try {
                            result = setLoadBalancerPoliciesForBackendServer(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    @Override
    public java.util.concurrent.Future<SetLoadBalancerPoliciesOfListenerResult> setLoadBalancerPoliciesOfListenerAsync(
            SetLoadBalancerPoliciesOfListenerRequest request) {

        return setLoadBalancerPoliciesOfListenerAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<SetLoadBalancerPoliciesOfListenerResult> setLoadBalancerPoliciesOfListenerAsync(
            final SetLoadBalancerPoliciesOfListenerRequest request,
            final com.amazonaws.handlers.AsyncHandler<SetLoadBalancerPoliciesOfListenerRequest, SetLoadBalancerPoliciesOfListenerResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<SetLoadBalancerPoliciesOfListenerResult>() {
                    @Override
                    public SetLoadBalancerPoliciesOfListenerResult call()
                            throws Exception {
                        SetLoadBalancerPoliciesOfListenerResult result;

                        try {
                            result = setLoadBalancerPoliciesOfListener(request);
                        } catch (Exception ex) {
                            if (asyncHandler != null) {
                                asyncHandler.onError(ex);
                            }
                            throw ex;
                        }

                        if (asyncHandler != null) {
                            asyncHandler.onSuccess(request, result);
                        }
                        return result;
                    }
                });
    }

    /**
     * Shuts down the client, releasing all managed resources. This includes
     * forcibly terminating all pending asynchronous service calls. Clients who
     * wish to give pending asynchronous service calls time to complete should
     * call {@code getExecutorService().shutdown()} followed by
     * {@code getExecutorService().awaitTermination()} prior to calling this
     * method.
     */
    @Override
    public void shutdown() {
        super.shutdown();
        executorService.shutdownNow();
    }
}
