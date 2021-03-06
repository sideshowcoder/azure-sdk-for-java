/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.azure.management.websites.models;

/**
* Per site limits
*/
public class SiteLimits {
    private Long maxDiskSizeInMb;
    
    /**
    * Optional. Maximum disk size allowed in MB
    * @return The MaxDiskSizeInMb value.
    */
    public Long getMaxDiskSizeInMb() {
        return this.maxDiskSizeInMb;
    }
    
    /**
    * Optional. Maximum disk size allowed in MB
    * @param maxDiskSizeInMbValue The MaxDiskSizeInMb value.
    */
    public void setMaxDiskSizeInMb(final Long maxDiskSizeInMbValue) {
        this.maxDiskSizeInMb = maxDiskSizeInMbValue;
    }
    
    private Long maxMemoryInMb;
    
    /**
    * Optional. Maximum memory allowed in MB
    * @return The MaxMemoryInMb value.
    */
    public Long getMaxMemoryInMb() {
        return this.maxMemoryInMb;
    }
    
    /**
    * Optional. Maximum memory allowed in MB
    * @param maxMemoryInMbValue The MaxMemoryInMb value.
    */
    public void setMaxMemoryInMb(final Long maxMemoryInMbValue) {
        this.maxMemoryInMb = maxMemoryInMbValue;
    }
    
    private Double maxPercentageCpu;
    
    /**
    * Optional. The name of the pair.
    * @return The MaxPercentageCpu value.
    */
    public Double getMaxPercentageCpu() {
        return this.maxPercentageCpu;
    }
    
    /**
    * Optional. The name of the pair.
    * @param maxPercentageCpuValue The MaxPercentageCpu value.
    */
    public void setMaxPercentageCpu(final Double maxPercentageCpuValue) {
        this.maxPercentageCpu = maxPercentageCpuValue;
    }
}
