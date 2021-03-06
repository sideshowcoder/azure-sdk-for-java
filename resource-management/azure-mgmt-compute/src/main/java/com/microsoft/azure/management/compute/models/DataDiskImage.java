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

package com.microsoft.azure.management.compute.models;

/**
* Contains the data disk images information.
*/
public class DataDiskImage {
    private int lun;
    
    /**
    * Required. Gets the LUN number for a data disk.This value is used to
    * identify data disk image inside the VMImage therefore it must be unique
    * for each data disk.The allowed character for the value is digit.
    * @return The Lun value.
    */
    public int getLun() {
        return this.lun;
    }
    
    /**
    * Required. Gets the LUN number for a data disk.This value is used to
    * identify data disk image inside the VMImage therefore it must be unique
    * for each data disk.The allowed character for the value is digit.
    * @param lunValue The Lun value.
    */
    public void setLun(final int lunValue) {
        this.lun = lunValue;
    }
    
    /**
    * Initializes a new instance of the DataDiskImage class.
    *
    */
    public DataDiskImage() {
    }
    
    /**
    * Initializes a new instance of the DataDiskImage class with required
    * arguments.
    *
    * @param lun Gets the LUN number for a data disk.This value is used to
    * identify data disk image inside the VMImage therefore it must be unique
    * for each data disk.The allowed character for the value is digit.
    */
    public DataDiskImage(int lun) {
        this.setLun(lun);
    }
}
