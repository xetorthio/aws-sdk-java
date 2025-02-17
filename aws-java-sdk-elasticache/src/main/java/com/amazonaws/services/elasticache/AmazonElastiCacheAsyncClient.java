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
package com.amazonaws.services.elasticache;

import com.amazonaws.services.elasticache.model.*;
import com.amazonaws.client.AwsAsyncClientParams;
import com.amazonaws.annotation.ThreadSafe;

/**
 * Interface for accessing Amazon ElastiCache asynchronously. Each asynchronous
 * method will return a Java Future object representing the asynchronous
 * operation; overloads which accept an {@code AsyncHandler} can be used to
 * receive notification when an asynchronous operation completes.
 * <p>
 * <fullname>Amazon ElastiCache</fullname>
 * <p>
 * Amazon ElastiCache is a web service that makes it easier to set up, operate,
 * and scale a distributed cache in the cloud.
 * </p>
 * <p>
 * With ElastiCache, customers gain all of the benefits of a high-performance,
 * in-memory cache with far less of the administrative burden of launching and
 * managing a distributed cache. The service makes setup, scaling, and cluster
 * failure handling much simpler than in a self-managed cache deployment.
 * </p>
 * <p>
 * In addition, through integration with Amazon CloudWatch, customers get
 * enhanced visibility into the key performance statistics associated with their
 * cache and can receive alarms if a part of their cache runs hot.
 * </p>
 */
@ThreadSafe
public class AmazonElastiCacheAsyncClient extends AmazonElastiCacheClient
        implements AmazonElastiCacheAsync {

    private static final int DEFAULT_THREAD_POOL_SIZE = 50;

    private final java.util.concurrent.ExecutorService executorService;

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache. A credentials provider chain will be used that searches for
     * credentials in this order:
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
    public AmazonElastiCacheAsyncClient() {
        this(new com.amazonaws.auth.DefaultAWSCredentialsProviderChain());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache. A credentials provider chain will be used that searches for
     * credentials in this order:
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
     *        connects to Amazon ElastiCache (ex: proxy settings, retry counts,
     *        etc).
     *
     * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
     * @see java.util.concurrent.Executors#newFixedThreadPool(int)
     */
    public AmazonElastiCacheAsyncClient(
            com.amazonaws.ClientConfiguration clientConfiguration) {
        this(new com.amazonaws.auth.DefaultAWSCredentialsProviderChain(),
                clientConfiguration, java.util.concurrent.Executors
                        .newFixedThreadPool(clientConfiguration
                                .getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache using the specified AWS account credentials.
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
    public AmazonElastiCacheAsyncClient(
            com.amazonaws.auth.AWSCredentials awsCredentials) {
        this(awsCredentials, java.util.concurrent.Executors
                .newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache using the specified AWS account credentials and executor
     * service. Default client settings will be used.
     *
     * @param awsCredentials
     *        The AWS credentials (access key ID and secret key) to use when
     *        authenticating with AWS services.
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonElastiCacheAsyncClient(
            com.amazonaws.auth.AWSCredentials awsCredentials,
            java.util.concurrent.ExecutorService executorService) {

        this(awsCredentials, configFactory.getConfig(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache using the specified AWS account credentials, executor
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
    public AmazonElastiCacheAsyncClient(
            com.amazonaws.auth.AWSCredentials awsCredentials,
            com.amazonaws.ClientConfiguration clientConfiguration,
            java.util.concurrent.ExecutorService executorService) {

        super(awsCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache using the specified AWS account credentials provider. Default
     * client settings will be used.
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
    public AmazonElastiCacheAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, java.util.concurrent.Executors
                .newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache using the provided AWS account credentials provider and
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
    public AmazonElastiCacheAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            com.amazonaws.ClientConfiguration clientConfiguration) {

        this(awsCredentialsProvider, clientConfiguration,
                java.util.concurrent.Executors
                        .newFixedThreadPool(clientConfiguration
                                .getMaxConnections()));
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache using the specified AWS account credentials provider and
     * executor service. Default client settings will be used.
     *
     * @param awsCredentialsProvider
     *        The AWS credentials provider which will provide credentials to
     *        authenticate requests with AWS services.
     * @param executorService
     *        The executor service by which all asynchronous requests will be
     *        executed.
     */
    public AmazonElastiCacheAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            java.util.concurrent.ExecutorService executorService) {

        this(awsCredentialsProvider, configFactory.getConfig(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache using the specified AWS account credentials provider,
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
    public AmazonElastiCacheAsyncClient(
            com.amazonaws.auth.AWSCredentialsProvider awsCredentialsProvider,
            com.amazonaws.ClientConfiguration clientConfiguration,
            java.util.concurrent.ExecutorService executorService) {

        super(awsCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on Amazon
     * ElastiCache using the specified parameters.
     *
     * @param asyncClientParams
     *        Object providing client parameters.
     */
    AmazonElastiCacheAsyncClient(AwsAsyncClientParams asyncClientParams) {
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
    public java.util.concurrent.Future<AddTagsToResourceResult> addTagsToResourceAsync(
            AddTagsToResourceRequest request) {

        return addTagsToResourceAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<AddTagsToResourceResult> addTagsToResourceAsync(
            final AddTagsToResourceRequest request,
            final com.amazonaws.handlers.AsyncHandler<AddTagsToResourceRequest, AddTagsToResourceResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<AddTagsToResourceResult>() {
                    @Override
                    public AddTagsToResourceResult call() throws Exception {
                        AddTagsToResourceResult result;

                        try {
                            result = addTagsToResource(request);
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
    public java.util.concurrent.Future<CacheSecurityGroup> authorizeCacheSecurityGroupIngressAsync(
            AuthorizeCacheSecurityGroupIngressRequest request) {

        return authorizeCacheSecurityGroupIngressAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheSecurityGroup> authorizeCacheSecurityGroupIngressAsync(
            final AuthorizeCacheSecurityGroupIngressRequest request,
            final com.amazonaws.handlers.AsyncHandler<AuthorizeCacheSecurityGroupIngressRequest, CacheSecurityGroup> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheSecurityGroup>() {
                    @Override
                    public CacheSecurityGroup call() throws Exception {
                        CacheSecurityGroup result;

                        try {
                            result = authorizeCacheSecurityGroupIngress(request);
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
    public java.util.concurrent.Future<Snapshot> copySnapshotAsync(
            CopySnapshotRequest request) {

        return copySnapshotAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<Snapshot> copySnapshotAsync(
            final CopySnapshotRequest request,
            final com.amazonaws.handlers.AsyncHandler<CopySnapshotRequest, Snapshot> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<Snapshot>() {
                    @Override
                    public Snapshot call() throws Exception {
                        Snapshot result;

                        try {
                            result = copySnapshot(request);
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
    public java.util.concurrent.Future<CacheCluster> createCacheClusterAsync(
            CreateCacheClusterRequest request) {

        return createCacheClusterAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheCluster> createCacheClusterAsync(
            final CreateCacheClusterRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateCacheClusterRequest, CacheCluster> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheCluster>() {
                    @Override
                    public CacheCluster call() throws Exception {
                        CacheCluster result;

                        try {
                            result = createCacheCluster(request);
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
    public java.util.concurrent.Future<CacheParameterGroup> createCacheParameterGroupAsync(
            CreateCacheParameterGroupRequest request) {

        return createCacheParameterGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheParameterGroup> createCacheParameterGroupAsync(
            final CreateCacheParameterGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateCacheParameterGroupRequest, CacheParameterGroup> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheParameterGroup>() {
                    @Override
                    public CacheParameterGroup call() throws Exception {
                        CacheParameterGroup result;

                        try {
                            result = createCacheParameterGroup(request);
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
    public java.util.concurrent.Future<CacheSecurityGroup> createCacheSecurityGroupAsync(
            CreateCacheSecurityGroupRequest request) {

        return createCacheSecurityGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheSecurityGroup> createCacheSecurityGroupAsync(
            final CreateCacheSecurityGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateCacheSecurityGroupRequest, CacheSecurityGroup> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheSecurityGroup>() {
                    @Override
                    public CacheSecurityGroup call() throws Exception {
                        CacheSecurityGroup result;

                        try {
                            result = createCacheSecurityGroup(request);
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
    public java.util.concurrent.Future<CacheSubnetGroup> createCacheSubnetGroupAsync(
            CreateCacheSubnetGroupRequest request) {

        return createCacheSubnetGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheSubnetGroup> createCacheSubnetGroupAsync(
            final CreateCacheSubnetGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateCacheSubnetGroupRequest, CacheSubnetGroup> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheSubnetGroup>() {
                    @Override
                    public CacheSubnetGroup call() throws Exception {
                        CacheSubnetGroup result;

                        try {
                            result = createCacheSubnetGroup(request);
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
    public java.util.concurrent.Future<ReplicationGroup> createReplicationGroupAsync(
            CreateReplicationGroupRequest request) {

        return createReplicationGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ReplicationGroup> createReplicationGroupAsync(
            final CreateReplicationGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateReplicationGroupRequest, ReplicationGroup> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ReplicationGroup>() {
                    @Override
                    public ReplicationGroup call() throws Exception {
                        ReplicationGroup result;

                        try {
                            result = createReplicationGroup(request);
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
    public java.util.concurrent.Future<Snapshot> createSnapshotAsync(
            CreateSnapshotRequest request) {

        return createSnapshotAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<Snapshot> createSnapshotAsync(
            final CreateSnapshotRequest request,
            final com.amazonaws.handlers.AsyncHandler<CreateSnapshotRequest, Snapshot> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<Snapshot>() {
                    @Override
                    public Snapshot call() throws Exception {
                        Snapshot result;

                        try {
                            result = createSnapshot(request);
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
    public java.util.concurrent.Future<CacheCluster> deleteCacheClusterAsync(
            DeleteCacheClusterRequest request) {

        return deleteCacheClusterAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheCluster> deleteCacheClusterAsync(
            final DeleteCacheClusterRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteCacheClusterRequest, CacheCluster> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheCluster>() {
                    @Override
                    public CacheCluster call() throws Exception {
                        CacheCluster result;

                        try {
                            result = deleteCacheCluster(request);
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
    public java.util.concurrent.Future<DeleteCacheParameterGroupResult> deleteCacheParameterGroupAsync(
            DeleteCacheParameterGroupRequest request) {

        return deleteCacheParameterGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeleteCacheParameterGroupResult> deleteCacheParameterGroupAsync(
            final DeleteCacheParameterGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteCacheParameterGroupRequest, DeleteCacheParameterGroupResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteCacheParameterGroupResult>() {
                    @Override
                    public DeleteCacheParameterGroupResult call()
                            throws Exception {
                        DeleteCacheParameterGroupResult result;

                        try {
                            result = deleteCacheParameterGroup(request);
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
    public java.util.concurrent.Future<DeleteCacheSecurityGroupResult> deleteCacheSecurityGroupAsync(
            DeleteCacheSecurityGroupRequest request) {

        return deleteCacheSecurityGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeleteCacheSecurityGroupResult> deleteCacheSecurityGroupAsync(
            final DeleteCacheSecurityGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteCacheSecurityGroupRequest, DeleteCacheSecurityGroupResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteCacheSecurityGroupResult>() {
                    @Override
                    public DeleteCacheSecurityGroupResult call()
                            throws Exception {
                        DeleteCacheSecurityGroupResult result;

                        try {
                            result = deleteCacheSecurityGroup(request);
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
    public java.util.concurrent.Future<DeleteCacheSubnetGroupResult> deleteCacheSubnetGroupAsync(
            DeleteCacheSubnetGroupRequest request) {

        return deleteCacheSubnetGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DeleteCacheSubnetGroupResult> deleteCacheSubnetGroupAsync(
            final DeleteCacheSubnetGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteCacheSubnetGroupRequest, DeleteCacheSubnetGroupResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DeleteCacheSubnetGroupResult>() {
                    @Override
                    public DeleteCacheSubnetGroupResult call() throws Exception {
                        DeleteCacheSubnetGroupResult result;

                        try {
                            result = deleteCacheSubnetGroup(request);
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
    public java.util.concurrent.Future<ReplicationGroup> deleteReplicationGroupAsync(
            DeleteReplicationGroupRequest request) {

        return deleteReplicationGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ReplicationGroup> deleteReplicationGroupAsync(
            final DeleteReplicationGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteReplicationGroupRequest, ReplicationGroup> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ReplicationGroup>() {
                    @Override
                    public ReplicationGroup call() throws Exception {
                        ReplicationGroup result;

                        try {
                            result = deleteReplicationGroup(request);
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
    public java.util.concurrent.Future<Snapshot> deleteSnapshotAsync(
            DeleteSnapshotRequest request) {

        return deleteSnapshotAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<Snapshot> deleteSnapshotAsync(
            final DeleteSnapshotRequest request,
            final com.amazonaws.handlers.AsyncHandler<DeleteSnapshotRequest, Snapshot> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<Snapshot>() {
                    @Override
                    public Snapshot call() throws Exception {
                        Snapshot result;

                        try {
                            result = deleteSnapshot(request);
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
    public java.util.concurrent.Future<DescribeCacheClustersResult> describeCacheClustersAsync(
            DescribeCacheClustersRequest request) {

        return describeCacheClustersAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheClustersResult> describeCacheClustersAsync(
            final DescribeCacheClustersRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeCacheClustersRequest, DescribeCacheClustersResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeCacheClustersResult>() {
                    @Override
                    public DescribeCacheClustersResult call() throws Exception {
                        DescribeCacheClustersResult result;

                        try {
                            result = describeCacheClusters(request);
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
     * Simplified method form for invoking the DescribeCacheClusters operation.
     *
     * @see #describeCacheClustersAsync(DescribeCacheClustersRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeCacheClustersResult> describeCacheClustersAsync() {

        return describeCacheClustersAsync(new DescribeCacheClustersRequest());
    }

    /**
     * Simplified method form for invoking the DescribeCacheClusters operation
     * with an AsyncHandler.
     *
     * @see #describeCacheClustersAsync(DescribeCacheClustersRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeCacheClustersResult> describeCacheClustersAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeCacheClustersRequest, DescribeCacheClustersResult> asyncHandler) {

        return describeCacheClustersAsync(new DescribeCacheClustersRequest(),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheEngineVersionsResult> describeCacheEngineVersionsAsync(
            DescribeCacheEngineVersionsRequest request) {

        return describeCacheEngineVersionsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheEngineVersionsResult> describeCacheEngineVersionsAsync(
            final DescribeCacheEngineVersionsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeCacheEngineVersionsRequest, DescribeCacheEngineVersionsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeCacheEngineVersionsResult>() {
                    @Override
                    public DescribeCacheEngineVersionsResult call()
                            throws Exception {
                        DescribeCacheEngineVersionsResult result;

                        try {
                            result = describeCacheEngineVersions(request);
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
     * Simplified method form for invoking the DescribeCacheEngineVersions
     * operation.
     *
     * @see #describeCacheEngineVersionsAsync(DescribeCacheEngineVersionsRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeCacheEngineVersionsResult> describeCacheEngineVersionsAsync() {

        return describeCacheEngineVersionsAsync(new DescribeCacheEngineVersionsRequest());
    }

    /**
     * Simplified method form for invoking the DescribeCacheEngineVersions
     * operation with an AsyncHandler.
     *
     * @see #describeCacheEngineVersionsAsync(DescribeCacheEngineVersionsRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeCacheEngineVersionsResult> describeCacheEngineVersionsAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeCacheEngineVersionsRequest, DescribeCacheEngineVersionsResult> asyncHandler) {

        return describeCacheEngineVersionsAsync(
                new DescribeCacheEngineVersionsRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheParameterGroupsResult> describeCacheParameterGroupsAsync(
            DescribeCacheParameterGroupsRequest request) {

        return describeCacheParameterGroupsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheParameterGroupsResult> describeCacheParameterGroupsAsync(
            final DescribeCacheParameterGroupsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeCacheParameterGroupsRequest, DescribeCacheParameterGroupsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeCacheParameterGroupsResult>() {
                    @Override
                    public DescribeCacheParameterGroupsResult call()
                            throws Exception {
                        DescribeCacheParameterGroupsResult result;

                        try {
                            result = describeCacheParameterGroups(request);
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
     * Simplified method form for invoking the DescribeCacheParameterGroups
     * operation.
     *
     * @see #describeCacheParameterGroupsAsync(DescribeCacheParameterGroupsRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeCacheParameterGroupsResult> describeCacheParameterGroupsAsync() {

        return describeCacheParameterGroupsAsync(new DescribeCacheParameterGroupsRequest());
    }

    /**
     * Simplified method form for invoking the DescribeCacheParameterGroups
     * operation with an AsyncHandler.
     *
     * @see #describeCacheParameterGroupsAsync(DescribeCacheParameterGroupsRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeCacheParameterGroupsResult> describeCacheParameterGroupsAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeCacheParameterGroupsRequest, DescribeCacheParameterGroupsResult> asyncHandler) {

        return describeCacheParameterGroupsAsync(
                new DescribeCacheParameterGroupsRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheParametersResult> describeCacheParametersAsync(
            DescribeCacheParametersRequest request) {

        return describeCacheParametersAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheParametersResult> describeCacheParametersAsync(
            final DescribeCacheParametersRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeCacheParametersRequest, DescribeCacheParametersResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeCacheParametersResult>() {
                    @Override
                    public DescribeCacheParametersResult call()
                            throws Exception {
                        DescribeCacheParametersResult result;

                        try {
                            result = describeCacheParameters(request);
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
    public java.util.concurrent.Future<DescribeCacheSecurityGroupsResult> describeCacheSecurityGroupsAsync(
            DescribeCacheSecurityGroupsRequest request) {

        return describeCacheSecurityGroupsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheSecurityGroupsResult> describeCacheSecurityGroupsAsync(
            final DescribeCacheSecurityGroupsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeCacheSecurityGroupsRequest, DescribeCacheSecurityGroupsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeCacheSecurityGroupsResult>() {
                    @Override
                    public DescribeCacheSecurityGroupsResult call()
                            throws Exception {
                        DescribeCacheSecurityGroupsResult result;

                        try {
                            result = describeCacheSecurityGroups(request);
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
     * Simplified method form for invoking the DescribeCacheSecurityGroups
     * operation.
     *
     * @see #describeCacheSecurityGroupsAsync(DescribeCacheSecurityGroupsRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeCacheSecurityGroupsResult> describeCacheSecurityGroupsAsync() {

        return describeCacheSecurityGroupsAsync(new DescribeCacheSecurityGroupsRequest());
    }

    /**
     * Simplified method form for invoking the DescribeCacheSecurityGroups
     * operation with an AsyncHandler.
     *
     * @see #describeCacheSecurityGroupsAsync(DescribeCacheSecurityGroupsRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeCacheSecurityGroupsResult> describeCacheSecurityGroupsAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeCacheSecurityGroupsRequest, DescribeCacheSecurityGroupsResult> asyncHandler) {

        return describeCacheSecurityGroupsAsync(
                new DescribeCacheSecurityGroupsRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheSubnetGroupsResult> describeCacheSubnetGroupsAsync(
            DescribeCacheSubnetGroupsRequest request) {

        return describeCacheSubnetGroupsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeCacheSubnetGroupsResult> describeCacheSubnetGroupsAsync(
            final DescribeCacheSubnetGroupsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeCacheSubnetGroupsRequest, DescribeCacheSubnetGroupsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeCacheSubnetGroupsResult>() {
                    @Override
                    public DescribeCacheSubnetGroupsResult call()
                            throws Exception {
                        DescribeCacheSubnetGroupsResult result;

                        try {
                            result = describeCacheSubnetGroups(request);
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
     * Simplified method form for invoking the DescribeCacheSubnetGroups
     * operation.
     *
     * @see #describeCacheSubnetGroupsAsync(DescribeCacheSubnetGroupsRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeCacheSubnetGroupsResult> describeCacheSubnetGroupsAsync() {

        return describeCacheSubnetGroupsAsync(new DescribeCacheSubnetGroupsRequest());
    }

    /**
     * Simplified method form for invoking the DescribeCacheSubnetGroups
     * operation with an AsyncHandler.
     *
     * @see #describeCacheSubnetGroupsAsync(DescribeCacheSubnetGroupsRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeCacheSubnetGroupsResult> describeCacheSubnetGroupsAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeCacheSubnetGroupsRequest, DescribeCacheSubnetGroupsResult> asyncHandler) {

        return describeCacheSubnetGroupsAsync(
                new DescribeCacheSubnetGroupsRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<EngineDefaults> describeEngineDefaultParametersAsync(
            DescribeEngineDefaultParametersRequest request) {

        return describeEngineDefaultParametersAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<EngineDefaults> describeEngineDefaultParametersAsync(
            final DescribeEngineDefaultParametersRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeEngineDefaultParametersRequest, EngineDefaults> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<EngineDefaults>() {
                    @Override
                    public EngineDefaults call() throws Exception {
                        EngineDefaults result;

                        try {
                            result = describeEngineDefaultParameters(request);
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
    public java.util.concurrent.Future<DescribeEventsResult> describeEventsAsync(
            DescribeEventsRequest request) {

        return describeEventsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeEventsResult> describeEventsAsync(
            final DescribeEventsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeEventsRequest, DescribeEventsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeEventsResult>() {
                    @Override
                    public DescribeEventsResult call() throws Exception {
                        DescribeEventsResult result;

                        try {
                            result = describeEvents(request);
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
     * Simplified method form for invoking the DescribeEvents operation.
     *
     * @see #describeEventsAsync(DescribeEventsRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeEventsResult> describeEventsAsync() {

        return describeEventsAsync(new DescribeEventsRequest());
    }

    /**
     * Simplified method form for invoking the DescribeEvents operation with an
     * AsyncHandler.
     *
     * @see #describeEventsAsync(DescribeEventsRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeEventsResult> describeEventsAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeEventsRequest, DescribeEventsResult> asyncHandler) {

        return describeEventsAsync(new DescribeEventsRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeReplicationGroupsResult> describeReplicationGroupsAsync(
            DescribeReplicationGroupsRequest request) {

        return describeReplicationGroupsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeReplicationGroupsResult> describeReplicationGroupsAsync(
            final DescribeReplicationGroupsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeReplicationGroupsRequest, DescribeReplicationGroupsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeReplicationGroupsResult>() {
                    @Override
                    public DescribeReplicationGroupsResult call()
                            throws Exception {
                        DescribeReplicationGroupsResult result;

                        try {
                            result = describeReplicationGroups(request);
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
     * Simplified method form for invoking the DescribeReplicationGroups
     * operation.
     *
     * @see #describeReplicationGroupsAsync(DescribeReplicationGroupsRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeReplicationGroupsResult> describeReplicationGroupsAsync() {

        return describeReplicationGroupsAsync(new DescribeReplicationGroupsRequest());
    }

    /**
     * Simplified method form for invoking the DescribeReplicationGroups
     * operation with an AsyncHandler.
     *
     * @see #describeReplicationGroupsAsync(DescribeReplicationGroupsRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeReplicationGroupsResult> describeReplicationGroupsAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeReplicationGroupsRequest, DescribeReplicationGroupsResult> asyncHandler) {

        return describeReplicationGroupsAsync(
                new DescribeReplicationGroupsRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeReservedCacheNodesResult> describeReservedCacheNodesAsync(
            DescribeReservedCacheNodesRequest request) {

        return describeReservedCacheNodesAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeReservedCacheNodesResult> describeReservedCacheNodesAsync(
            final DescribeReservedCacheNodesRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeReservedCacheNodesRequest, DescribeReservedCacheNodesResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeReservedCacheNodesResult>() {
                    @Override
                    public DescribeReservedCacheNodesResult call()
                            throws Exception {
                        DescribeReservedCacheNodesResult result;

                        try {
                            result = describeReservedCacheNodes(request);
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
     * Simplified method form for invoking the DescribeReservedCacheNodes
     * operation.
     *
     * @see #describeReservedCacheNodesAsync(DescribeReservedCacheNodesRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeReservedCacheNodesResult> describeReservedCacheNodesAsync() {

        return describeReservedCacheNodesAsync(new DescribeReservedCacheNodesRequest());
    }

    /**
     * Simplified method form for invoking the DescribeReservedCacheNodes
     * operation with an AsyncHandler.
     *
     * @see #describeReservedCacheNodesAsync(DescribeReservedCacheNodesRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeReservedCacheNodesResult> describeReservedCacheNodesAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeReservedCacheNodesRequest, DescribeReservedCacheNodesResult> asyncHandler) {

        return describeReservedCacheNodesAsync(
                new DescribeReservedCacheNodesRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeReservedCacheNodesOfferingsResult> describeReservedCacheNodesOfferingsAsync(
            DescribeReservedCacheNodesOfferingsRequest request) {

        return describeReservedCacheNodesOfferingsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeReservedCacheNodesOfferingsResult> describeReservedCacheNodesOfferingsAsync(
            final DescribeReservedCacheNodesOfferingsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeReservedCacheNodesOfferingsRequest, DescribeReservedCacheNodesOfferingsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeReservedCacheNodesOfferingsResult>() {
                    @Override
                    public DescribeReservedCacheNodesOfferingsResult call()
                            throws Exception {
                        DescribeReservedCacheNodesOfferingsResult result;

                        try {
                            result = describeReservedCacheNodesOfferings(request);
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
     * Simplified method form for invoking the
     * DescribeReservedCacheNodesOfferings operation.
     *
     * @see #describeReservedCacheNodesOfferingsAsync(DescribeReservedCacheNodesOfferingsRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeReservedCacheNodesOfferingsResult> describeReservedCacheNodesOfferingsAsync() {

        return describeReservedCacheNodesOfferingsAsync(new DescribeReservedCacheNodesOfferingsRequest());
    }

    /**
     * Simplified method form for invoking the
     * DescribeReservedCacheNodesOfferings operation with an AsyncHandler.
     *
     * @see #describeReservedCacheNodesOfferingsAsync(DescribeReservedCacheNodesOfferingsRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeReservedCacheNodesOfferingsResult> describeReservedCacheNodesOfferingsAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeReservedCacheNodesOfferingsRequest, DescribeReservedCacheNodesOfferingsResult> asyncHandler) {

        return describeReservedCacheNodesOfferingsAsync(
                new DescribeReservedCacheNodesOfferingsRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<DescribeSnapshotsResult> describeSnapshotsAsync(
            DescribeSnapshotsRequest request) {

        return describeSnapshotsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<DescribeSnapshotsResult> describeSnapshotsAsync(
            final DescribeSnapshotsRequest request,
            final com.amazonaws.handlers.AsyncHandler<DescribeSnapshotsRequest, DescribeSnapshotsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<DescribeSnapshotsResult>() {
                    @Override
                    public DescribeSnapshotsResult call() throws Exception {
                        DescribeSnapshotsResult result;

                        try {
                            result = describeSnapshots(request);
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
     * Simplified method form for invoking the DescribeSnapshots operation.
     *
     * @see #describeSnapshotsAsync(DescribeSnapshotsRequest)
     */
    @Override
    public java.util.concurrent.Future<DescribeSnapshotsResult> describeSnapshotsAsync() {

        return describeSnapshotsAsync(new DescribeSnapshotsRequest());
    }

    /**
     * Simplified method form for invoking the DescribeSnapshots operation with
     * an AsyncHandler.
     *
     * @see #describeSnapshotsAsync(DescribeSnapshotsRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<DescribeSnapshotsResult> describeSnapshotsAsync(
            com.amazonaws.handlers.AsyncHandler<DescribeSnapshotsRequest, DescribeSnapshotsResult> asyncHandler) {

        return describeSnapshotsAsync(new DescribeSnapshotsRequest(),
                asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<ListAllowedNodeTypeModificationsResult> listAllowedNodeTypeModificationsAsync(
            ListAllowedNodeTypeModificationsRequest request) {

        return listAllowedNodeTypeModificationsAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListAllowedNodeTypeModificationsResult> listAllowedNodeTypeModificationsAsync(
            final ListAllowedNodeTypeModificationsRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListAllowedNodeTypeModificationsRequest, ListAllowedNodeTypeModificationsResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ListAllowedNodeTypeModificationsResult>() {
                    @Override
                    public ListAllowedNodeTypeModificationsResult call()
                            throws Exception {
                        ListAllowedNodeTypeModificationsResult result;

                        try {
                            result = listAllowedNodeTypeModifications(request);
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
     * Simplified method form for invoking the ListAllowedNodeTypeModifications
     * operation.
     *
     * @see #listAllowedNodeTypeModificationsAsync(ListAllowedNodeTypeModificationsRequest)
     */
    @Override
    public java.util.concurrent.Future<ListAllowedNodeTypeModificationsResult> listAllowedNodeTypeModificationsAsync() {

        return listAllowedNodeTypeModificationsAsync(new ListAllowedNodeTypeModificationsRequest());
    }

    /**
     * Simplified method form for invoking the ListAllowedNodeTypeModifications
     * operation with an AsyncHandler.
     *
     * @see #listAllowedNodeTypeModificationsAsync(ListAllowedNodeTypeModificationsRequest,
     *      com.amazonaws.handlers.AsyncHandler)
     */
    public java.util.concurrent.Future<ListAllowedNodeTypeModificationsResult> listAllowedNodeTypeModificationsAsync(
            com.amazonaws.handlers.AsyncHandler<ListAllowedNodeTypeModificationsRequest, ListAllowedNodeTypeModificationsResult> asyncHandler) {

        return listAllowedNodeTypeModificationsAsync(
                new ListAllowedNodeTypeModificationsRequest(), asyncHandler);
    }

    @Override
    public java.util.concurrent.Future<ListTagsForResourceResult> listTagsForResourceAsync(
            ListTagsForResourceRequest request) {

        return listTagsForResourceAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ListTagsForResourceResult> listTagsForResourceAsync(
            final ListTagsForResourceRequest request,
            final com.amazonaws.handlers.AsyncHandler<ListTagsForResourceRequest, ListTagsForResourceResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ListTagsForResourceResult>() {
                    @Override
                    public ListTagsForResourceResult call() throws Exception {
                        ListTagsForResourceResult result;

                        try {
                            result = listTagsForResource(request);
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
    public java.util.concurrent.Future<CacheCluster> modifyCacheClusterAsync(
            ModifyCacheClusterRequest request) {

        return modifyCacheClusterAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheCluster> modifyCacheClusterAsync(
            final ModifyCacheClusterRequest request,
            final com.amazonaws.handlers.AsyncHandler<ModifyCacheClusterRequest, CacheCluster> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheCluster>() {
                    @Override
                    public CacheCluster call() throws Exception {
                        CacheCluster result;

                        try {
                            result = modifyCacheCluster(request);
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
    public java.util.concurrent.Future<ModifyCacheParameterGroupResult> modifyCacheParameterGroupAsync(
            ModifyCacheParameterGroupRequest request) {

        return modifyCacheParameterGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ModifyCacheParameterGroupResult> modifyCacheParameterGroupAsync(
            final ModifyCacheParameterGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<ModifyCacheParameterGroupRequest, ModifyCacheParameterGroupResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ModifyCacheParameterGroupResult>() {
                    @Override
                    public ModifyCacheParameterGroupResult call()
                            throws Exception {
                        ModifyCacheParameterGroupResult result;

                        try {
                            result = modifyCacheParameterGroup(request);
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
    public java.util.concurrent.Future<CacheSubnetGroup> modifyCacheSubnetGroupAsync(
            ModifyCacheSubnetGroupRequest request) {

        return modifyCacheSubnetGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheSubnetGroup> modifyCacheSubnetGroupAsync(
            final ModifyCacheSubnetGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<ModifyCacheSubnetGroupRequest, CacheSubnetGroup> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheSubnetGroup>() {
                    @Override
                    public CacheSubnetGroup call() throws Exception {
                        CacheSubnetGroup result;

                        try {
                            result = modifyCacheSubnetGroup(request);
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
    public java.util.concurrent.Future<ReplicationGroup> modifyReplicationGroupAsync(
            ModifyReplicationGroupRequest request) {

        return modifyReplicationGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ReplicationGroup> modifyReplicationGroupAsync(
            final ModifyReplicationGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<ModifyReplicationGroupRequest, ReplicationGroup> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ReplicationGroup>() {
                    @Override
                    public ReplicationGroup call() throws Exception {
                        ReplicationGroup result;

                        try {
                            result = modifyReplicationGroup(request);
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
    public java.util.concurrent.Future<ReservedCacheNode> purchaseReservedCacheNodesOfferingAsync(
            PurchaseReservedCacheNodesOfferingRequest request) {

        return purchaseReservedCacheNodesOfferingAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ReservedCacheNode> purchaseReservedCacheNodesOfferingAsync(
            final PurchaseReservedCacheNodesOfferingRequest request,
            final com.amazonaws.handlers.AsyncHandler<PurchaseReservedCacheNodesOfferingRequest, ReservedCacheNode> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ReservedCacheNode>() {
                    @Override
                    public ReservedCacheNode call() throws Exception {
                        ReservedCacheNode result;

                        try {
                            result = purchaseReservedCacheNodesOffering(request);
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
    public java.util.concurrent.Future<CacheCluster> rebootCacheClusterAsync(
            RebootCacheClusterRequest request) {

        return rebootCacheClusterAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheCluster> rebootCacheClusterAsync(
            final RebootCacheClusterRequest request,
            final com.amazonaws.handlers.AsyncHandler<RebootCacheClusterRequest, CacheCluster> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheCluster>() {
                    @Override
                    public CacheCluster call() throws Exception {
                        CacheCluster result;

                        try {
                            result = rebootCacheCluster(request);
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
    public java.util.concurrent.Future<RemoveTagsFromResourceResult> removeTagsFromResourceAsync(
            RemoveTagsFromResourceRequest request) {

        return removeTagsFromResourceAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<RemoveTagsFromResourceResult> removeTagsFromResourceAsync(
            final RemoveTagsFromResourceRequest request,
            final com.amazonaws.handlers.AsyncHandler<RemoveTagsFromResourceRequest, RemoveTagsFromResourceResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<RemoveTagsFromResourceResult>() {
                    @Override
                    public RemoveTagsFromResourceResult call() throws Exception {
                        RemoveTagsFromResourceResult result;

                        try {
                            result = removeTagsFromResource(request);
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
    public java.util.concurrent.Future<ResetCacheParameterGroupResult> resetCacheParameterGroupAsync(
            ResetCacheParameterGroupRequest request) {

        return resetCacheParameterGroupAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<ResetCacheParameterGroupResult> resetCacheParameterGroupAsync(
            final ResetCacheParameterGroupRequest request,
            final com.amazonaws.handlers.AsyncHandler<ResetCacheParameterGroupRequest, ResetCacheParameterGroupResult> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<ResetCacheParameterGroupResult>() {
                    @Override
                    public ResetCacheParameterGroupResult call()
                            throws Exception {
                        ResetCacheParameterGroupResult result;

                        try {
                            result = resetCacheParameterGroup(request);
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
    public java.util.concurrent.Future<CacheSecurityGroup> revokeCacheSecurityGroupIngressAsync(
            RevokeCacheSecurityGroupIngressRequest request) {

        return revokeCacheSecurityGroupIngressAsync(request, null);
    }

    @Override
    public java.util.concurrent.Future<CacheSecurityGroup> revokeCacheSecurityGroupIngressAsync(
            final RevokeCacheSecurityGroupIngressRequest request,
            final com.amazonaws.handlers.AsyncHandler<RevokeCacheSecurityGroupIngressRequest, CacheSecurityGroup> asyncHandler) {

        return executorService
                .submit(new java.util.concurrent.Callable<CacheSecurityGroup>() {
                    @Override
                    public CacheSecurityGroup call() throws Exception {
                        CacheSecurityGroup result;

                        try {
                            result = revokeCacheSecurityGroupIngress(request);
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
