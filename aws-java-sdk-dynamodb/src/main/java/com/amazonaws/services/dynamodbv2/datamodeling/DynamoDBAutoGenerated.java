/*
 * Copyright 2011-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a property using a custom auto-generator.
 *
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedDefault
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerator
 * @see com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBVersionAttribute
 */
@DynamoDB
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface DynamoDBAutoGenerated {

    /**
     * The auto-generator class for this property.
     */
    Class<? extends DynamoDBAutoGenerator> generator();

}
