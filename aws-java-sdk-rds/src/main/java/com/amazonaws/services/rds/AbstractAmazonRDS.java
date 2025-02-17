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
package com.amazonaws.services.rds;

import com.amazonaws.services.rds.model.*;
import com.amazonaws.*;

/**
 * Abstract implementation of {@code AmazonRDS}. Convenient method forms pass
 * through to the corresponding overload that takes a request object, which
 * throws an {@code UnsupportedOperationException}.
 */
public class AbstractAmazonRDS implements AmazonRDS {

    protected AbstractAmazonRDS() {
    }

    @Override
    public void setEndpoint(String endpoint) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public void setRegion(com.amazonaws.regions.Region region) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public EventSubscription addSourceIdentifierToSubscription(
            AddSourceIdentifierToSubscriptionRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public AddTagsToResourceResult addTagsToResource(
            AddTagsToResourceRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ResourcePendingMaintenanceActions applyPendingMaintenanceAction(
            ApplyPendingMaintenanceActionRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSecurityGroup authorizeDBSecurityGroupIngress(
            AuthorizeDBSecurityGroupIngressRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBClusterParameterGroup copyDBClusterParameterGroup(
            CopyDBClusterParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBClusterSnapshot copyDBClusterSnapshot(
            CopyDBClusterSnapshotRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBParameterGroup copyDBParameterGroup(
            CopyDBParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSnapshot copyDBSnapshot(CopyDBSnapshotRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public OptionGroup copyOptionGroup(CopyOptionGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBCluster createDBCluster(CreateDBClusterRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBClusterParameterGroup createDBClusterParameterGroup(
            CreateDBClusterParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBClusterSnapshot createDBClusterSnapshot(
            CreateDBClusterSnapshotRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBInstance createDBInstance(CreateDBInstanceRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBInstance createDBInstanceReadReplica(
            CreateDBInstanceReadReplicaRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBParameterGroup createDBParameterGroup(
            CreateDBParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSecurityGroup createDBSecurityGroup(
            CreateDBSecurityGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSnapshot createDBSnapshot(CreateDBSnapshotRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSubnetGroup createDBSubnetGroup(CreateDBSubnetGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public EventSubscription createEventSubscription(
            CreateEventSubscriptionRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public OptionGroup createOptionGroup(CreateOptionGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBCluster deleteDBCluster(DeleteDBClusterRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DeleteDBClusterParameterGroupResult deleteDBClusterParameterGroup(
            DeleteDBClusterParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBClusterSnapshot deleteDBClusterSnapshot(
            DeleteDBClusterSnapshotRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBInstance deleteDBInstance(DeleteDBInstanceRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DeleteDBParameterGroupResult deleteDBParameterGroup(
            DeleteDBParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DeleteDBSecurityGroupResult deleteDBSecurityGroup(
            DeleteDBSecurityGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSnapshot deleteDBSnapshot(DeleteDBSnapshotRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DeleteDBSubnetGroupResult deleteDBSubnetGroup(
            DeleteDBSubnetGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public EventSubscription deleteEventSubscription(
            DeleteEventSubscriptionRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DeleteOptionGroupResult deleteOptionGroup(
            DeleteOptionGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeAccountAttributesResult describeAccountAttributes(
            DescribeAccountAttributesRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeAccountAttributesResult describeAccountAttributes() {
        return describeAccountAttributes(new DescribeAccountAttributesRequest());
    }

    @Override
    public DescribeCertificatesResult describeCertificates(
            DescribeCertificatesRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeCertificatesResult describeCertificates() {
        return describeCertificates(new DescribeCertificatesRequest());
    }

    @Override
    public DescribeDBClusterParameterGroupsResult describeDBClusterParameterGroups(
            DescribeDBClusterParameterGroupsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBClusterParameterGroupsResult describeDBClusterParameterGroups() {
        return describeDBClusterParameterGroups(new DescribeDBClusterParameterGroupsRequest());
    }

    @Override
    public DescribeDBClusterParametersResult describeDBClusterParameters(
            DescribeDBClusterParametersRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBClusterSnapshotAttributesResult describeDBClusterSnapshotAttributes(
            DescribeDBClusterSnapshotAttributesRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBClusterSnapshotsResult describeDBClusterSnapshots(
            DescribeDBClusterSnapshotsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBClusterSnapshotsResult describeDBClusterSnapshots() {
        return describeDBClusterSnapshots(new DescribeDBClusterSnapshotsRequest());
    }

    @Override
    public DescribeDBClustersResult describeDBClusters(
            DescribeDBClustersRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBClustersResult describeDBClusters() {
        return describeDBClusters(new DescribeDBClustersRequest());
    }

    @Override
    public DescribeDBEngineVersionsResult describeDBEngineVersions(
            DescribeDBEngineVersionsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBEngineVersionsResult describeDBEngineVersions() {
        return describeDBEngineVersions(new DescribeDBEngineVersionsRequest());
    }

    @Override
    public DescribeDBInstancesResult describeDBInstances(
            DescribeDBInstancesRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBInstancesResult describeDBInstances() {
        return describeDBInstances(new DescribeDBInstancesRequest());
    }

    @Override
    public DescribeDBLogFilesResult describeDBLogFiles(
            DescribeDBLogFilesRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBParameterGroupsResult describeDBParameterGroups(
            DescribeDBParameterGroupsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBParameterGroupsResult describeDBParameterGroups() {
        return describeDBParameterGroups(new DescribeDBParameterGroupsRequest());
    }

    @Override
    public DescribeDBParametersResult describeDBParameters(
            DescribeDBParametersRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBSecurityGroupsResult describeDBSecurityGroups(
            DescribeDBSecurityGroupsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBSecurityGroupsResult describeDBSecurityGroups() {
        return describeDBSecurityGroups(new DescribeDBSecurityGroupsRequest());
    }

    @Override
    public DBSnapshotAttributesResult describeDBSnapshotAttributes(
            DescribeDBSnapshotAttributesRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSnapshotAttributesResult describeDBSnapshotAttributes() {
        return describeDBSnapshotAttributes(new DescribeDBSnapshotAttributesRequest());
    }

    @Override
    public DescribeDBSnapshotsResult describeDBSnapshots(
            DescribeDBSnapshotsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBSnapshotsResult describeDBSnapshots() {
        return describeDBSnapshots(new DescribeDBSnapshotsRequest());
    }

    @Override
    public DescribeDBSubnetGroupsResult describeDBSubnetGroups(
            DescribeDBSubnetGroupsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeDBSubnetGroupsResult describeDBSubnetGroups() {
        return describeDBSubnetGroups(new DescribeDBSubnetGroupsRequest());
    }

    @Override
    public EngineDefaults describeEngineDefaultClusterParameters(
            DescribeEngineDefaultClusterParametersRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public EngineDefaults describeEngineDefaultParameters(
            DescribeEngineDefaultParametersRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeEventCategoriesResult describeEventCategories(
            DescribeEventCategoriesRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeEventCategoriesResult describeEventCategories() {
        return describeEventCategories(new DescribeEventCategoriesRequest());
    }

    @Override
    public DescribeEventSubscriptionsResult describeEventSubscriptions(
            DescribeEventSubscriptionsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeEventSubscriptionsResult describeEventSubscriptions() {
        return describeEventSubscriptions(new DescribeEventSubscriptionsRequest());
    }

    @Override
    public DescribeEventsResult describeEvents(DescribeEventsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeEventsResult describeEvents() {
        return describeEvents(new DescribeEventsRequest());
    }

    @Override
    public DescribeOptionGroupOptionsResult describeOptionGroupOptions(
            DescribeOptionGroupOptionsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeOptionGroupsResult describeOptionGroups(
            DescribeOptionGroupsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeOptionGroupsResult describeOptionGroups() {
        return describeOptionGroups(new DescribeOptionGroupsRequest());
    }

    @Override
    public DescribeOrderableDBInstanceOptionsResult describeOrderableDBInstanceOptions(
            DescribeOrderableDBInstanceOptionsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribePendingMaintenanceActionsResult describePendingMaintenanceActions(
            DescribePendingMaintenanceActionsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribePendingMaintenanceActionsResult describePendingMaintenanceActions() {
        return describePendingMaintenanceActions(new DescribePendingMaintenanceActionsRequest());
    }

    @Override
    public DescribeReservedDBInstancesResult describeReservedDBInstances(
            DescribeReservedDBInstancesRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeReservedDBInstancesResult describeReservedDBInstances() {
        return describeReservedDBInstances(new DescribeReservedDBInstancesRequest());
    }

    @Override
    public DescribeReservedDBInstancesOfferingsResult describeReservedDBInstancesOfferings(
            DescribeReservedDBInstancesOfferingsRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DescribeReservedDBInstancesOfferingsResult describeReservedDBInstancesOfferings() {
        return describeReservedDBInstancesOfferings(new DescribeReservedDBInstancesOfferingsRequest());
    }

    @Override
    public DownloadDBLogFilePortionResult downloadDBLogFilePortion(
            DownloadDBLogFilePortionRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBCluster failoverDBCluster(FailoverDBClusterRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBCluster failoverDBCluster() {
        return failoverDBCluster(new FailoverDBClusterRequest());
    }

    @Override
    public ListTagsForResourceResult listTagsForResource(
            ListTagsForResourceRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBCluster modifyDBCluster(ModifyDBClusterRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ModifyDBClusterParameterGroupResult modifyDBClusterParameterGroup(
            ModifyDBClusterParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBClusterSnapshotAttributesResult modifyDBClusterSnapshotAttribute(
            ModifyDBClusterSnapshotAttributeRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBInstance modifyDBInstance(ModifyDBInstanceRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ModifyDBParameterGroupResult modifyDBParameterGroup(
            ModifyDBParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSnapshotAttributesResult modifyDBSnapshotAttribute(
            ModifyDBSnapshotAttributeRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSubnetGroup modifyDBSubnetGroup(ModifyDBSubnetGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public EventSubscription modifyEventSubscription(
            ModifyEventSubscriptionRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public OptionGroup modifyOptionGroup(ModifyOptionGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBInstance promoteReadReplica(PromoteReadReplicaRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBCluster promoteReadReplicaDBCluster(
            PromoteReadReplicaDBClusterRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ReservedDBInstance purchaseReservedDBInstancesOffering(
            PurchaseReservedDBInstancesOfferingRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBInstance rebootDBInstance(RebootDBInstanceRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public EventSubscription removeSourceIdentifierFromSubscription(
            RemoveSourceIdentifierFromSubscriptionRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public RemoveTagsFromResourceResult removeTagsFromResource(
            RemoveTagsFromResourceRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ResetDBClusterParameterGroupResult resetDBClusterParameterGroup(
            ResetDBClusterParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public ResetDBParameterGroupResult resetDBParameterGroup(
            ResetDBParameterGroupRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBCluster restoreDBClusterFromSnapshot(
            RestoreDBClusterFromSnapshotRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBCluster restoreDBClusterToPointInTime(
            RestoreDBClusterToPointInTimeRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBInstance restoreDBInstanceFromDBSnapshot(
            RestoreDBInstanceFromDBSnapshotRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBInstance restoreDBInstanceToPointInTime(
            RestoreDBInstanceToPointInTimeRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public DBSecurityGroup revokeDBSecurityGroupIngress(
            RevokeDBSecurityGroupIngressRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public void shutdown() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override
    public com.amazonaws.ResponseMetadata getCachedResponseMetadata(
            com.amazonaws.AmazonWebServiceRequest request) {
        throw new java.lang.UnsupportedOperationException();
    }
}
