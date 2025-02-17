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

package com.amazonaws.services.gamelift.model;

import java.io.Serializable;

/**
 * <p>
 * A set of instructions for launching server processes on each instance in a
 * fleet. Each instruction set identifies the location of the server executable,
 * optional launch parameters, and the number of server processes with this
 * configuration to maintain concurrently on the instance. Server process
 * configurations make up a fleet's <code><a>RuntimeConfiguration</a></code>.
 * </p>
 */
public class ServerProcess implements Serializable, Cloneable {

    /**
     * <p>
     * Location in the game build of the server executable. All game builds are
     * installed on instances at the root <code>C:\game\...</code>, so an
     * executable file located at <code>MyGame\latest\server.exe</code> has a
     * launch path of "<code>C:\game\MyGame\latest\server.exe</code>".
     * </p>
     */
    private String launchPath;
    /**
     * <p>
     * Optional list of parameters to pass to the server executable on launch.
     * </p>
     */
    private String parameters;
    /**
     * <p>
     * Number of server processes using this configuration to run concurrently
     * on an instance.
     * </p>
     */
    private Integer concurrentExecutions;

    /**
     * <p>
     * Location in the game build of the server executable. All game builds are
     * installed on instances at the root <code>C:\game\...</code>, so an
     * executable file located at <code>MyGame\latest\server.exe</code> has a
     * launch path of "<code>C:\game\MyGame\latest\server.exe</code>".
     * </p>
     * 
     * @param launchPath
     *        Location in the game build of the server executable. All game
     *        builds are installed on instances at the root
     *        <code>C:\game\...</code>, so an executable file located at
     *        <code>MyGame\latest\server.exe</code> has a launch path of "
     *        <code>C:\game\MyGame\latest\server.exe</code>".
     */

    public void setLaunchPath(String launchPath) {
        this.launchPath = launchPath;
    }

    /**
     * <p>
     * Location in the game build of the server executable. All game builds are
     * installed on instances at the root <code>C:\game\...</code>, so an
     * executable file located at <code>MyGame\latest\server.exe</code> has a
     * launch path of "<code>C:\game\MyGame\latest\server.exe</code>".
     * </p>
     * 
     * @return Location in the game build of the server executable. All game
     *         builds are installed on instances at the root
     *         <code>C:\game\...</code>, so an executable file located at
     *         <code>MyGame\latest\server.exe</code> has a launch path of "
     *         <code>C:\game\MyGame\latest\server.exe</code>".
     */

    public String getLaunchPath() {
        return this.launchPath;
    }

    /**
     * <p>
     * Location in the game build of the server executable. All game builds are
     * installed on instances at the root <code>C:\game\...</code>, so an
     * executable file located at <code>MyGame\latest\server.exe</code> has a
     * launch path of "<code>C:\game\MyGame\latest\server.exe</code>".
     * </p>
     * 
     * @param launchPath
     *        Location in the game build of the server executable. All game
     *        builds are installed on instances at the root
     *        <code>C:\game\...</code>, so an executable file located at
     *        <code>MyGame\latest\server.exe</code> has a launch path of "
     *        <code>C:\game\MyGame\latest\server.exe</code>".
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public ServerProcess withLaunchPath(String launchPath) {
        setLaunchPath(launchPath);
        return this;
    }

    /**
     * <p>
     * Optional list of parameters to pass to the server executable on launch.
     * </p>
     * 
     * @param parameters
     *        Optional list of parameters to pass to the server executable on
     *        launch.
     */

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    /**
     * <p>
     * Optional list of parameters to pass to the server executable on launch.
     * </p>
     * 
     * @return Optional list of parameters to pass to the server executable on
     *         launch.
     */

    public String getParameters() {
        return this.parameters;
    }

    /**
     * <p>
     * Optional list of parameters to pass to the server executable on launch.
     * </p>
     * 
     * @param parameters
     *        Optional list of parameters to pass to the server executable on
     *        launch.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public ServerProcess withParameters(String parameters) {
        setParameters(parameters);
        return this;
    }

    /**
     * <p>
     * Number of server processes using this configuration to run concurrently
     * on an instance.
     * </p>
     * 
     * @param concurrentExecutions
     *        Number of server processes using this configuration to run
     *        concurrently on an instance.
     */

    public void setConcurrentExecutions(Integer concurrentExecutions) {
        this.concurrentExecutions = concurrentExecutions;
    }

    /**
     * <p>
     * Number of server processes using this configuration to run concurrently
     * on an instance.
     * </p>
     * 
     * @return Number of server processes using this configuration to run
     *         concurrently on an instance.
     */

    public Integer getConcurrentExecutions() {
        return this.concurrentExecutions;
    }

    /**
     * <p>
     * Number of server processes using this configuration to run concurrently
     * on an instance.
     * </p>
     * 
     * @param concurrentExecutions
     *        Number of server processes using this configuration to run
     *        concurrently on an instance.
     * @return Returns a reference to this object so that method calls can be
     *         chained together.
     */

    public ServerProcess withConcurrentExecutions(Integer concurrentExecutions) {
        setConcurrentExecutions(concurrentExecutions);
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
        if (getLaunchPath() != null)
            sb.append("LaunchPath: " + getLaunchPath() + ",");
        if (getParameters() != null)
            sb.append("Parameters: " + getParameters() + ",");
        if (getConcurrentExecutions() != null)
            sb.append("ConcurrentExecutions: " + getConcurrentExecutions());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof ServerProcess == false)
            return false;
        ServerProcess other = (ServerProcess) obj;
        if (other.getLaunchPath() == null ^ this.getLaunchPath() == null)
            return false;
        if (other.getLaunchPath() != null
                && other.getLaunchPath().equals(this.getLaunchPath()) == false)
            return false;
        if (other.getParameters() == null ^ this.getParameters() == null)
            return false;
        if (other.getParameters() != null
                && other.getParameters().equals(this.getParameters()) == false)
            return false;
        if (other.getConcurrentExecutions() == null
                ^ this.getConcurrentExecutions() == null)
            return false;
        if (other.getConcurrentExecutions() != null
                && other.getConcurrentExecutions().equals(
                        this.getConcurrentExecutions()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getLaunchPath() == null) ? 0 : getLaunchPath().hashCode());
        hashCode = prime * hashCode
                + ((getParameters() == null) ? 0 : getParameters().hashCode());
        hashCode = prime
                * hashCode
                + ((getConcurrentExecutions() == null) ? 0
                        : getConcurrentExecutions().hashCode());
        return hashCode;
    }

    @Override
    public ServerProcess clone() {
        try {
            return (ServerProcess) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}
