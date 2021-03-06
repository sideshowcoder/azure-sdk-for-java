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

package com.microsoft.azure.management.sql.models;

import com.microsoft.windowsazure.core.LazyHashMap;

import java.util.HashMap;

public class CreateUpdateBase {
    private String location;
    
    /**
    * Required. Gets or sets the location of the resource.
    * @return The Location value.
    */
    public String getLocation() {
        return this.location;
    }
    
    /**
    * Required. Gets or sets the location of the resource.
    * @param locationValue The Location value.
    */
    public void setLocation(final String locationValue) {
        this.location = locationValue;
    }
    
    private HashMap<String, String> tags;
    
    /**
    * Required. Gets or sets the tags associated with the request.
    * @return The Tags value.
    */
    public HashMap<String, String> getTags() {
        return this.tags;
    }
    
    /**
    * Required. Gets or sets the tags associated with the request.
    * @param tagsValue The Tags value.
    */
    public void setTags(final HashMap<String, String> tagsValue) {
        this.tags = tagsValue;
    }
    
    /**
    * Initializes a new instance of the CreateUpdateBase class.
    *
    */
    public CreateUpdateBase() {
        this.setTags(new LazyHashMap<String, String>());
    }
    
    /**
    * Initializes a new instance of the CreateUpdateBase class with required
    * arguments.
    *
    * @param location Gets or sets the location of the resource.
    * @param tags Gets or sets the tags associated with the request.
    */
    public CreateUpdateBase(String location, HashMap<String, String> tags) {
        this();
        if (location == null) {
            throw new NullPointerException("location");
        }
        if (tags == null) {
            throw new NullPointerException("tags");
        }
        this.setLocation(location);
        this.setTags(tags);
    }
}
