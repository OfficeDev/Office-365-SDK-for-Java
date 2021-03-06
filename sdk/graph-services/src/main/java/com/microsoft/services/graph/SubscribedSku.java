/*******************************************************************************
**NOTE** This code was generated by a tool and will occasionally be
overwritten. We welcome comments and issues regarding this code; they will be
addressed in the generation tool. If you wish to submit pull requests, please
do so for the templates in that tool.

This code was generated by Vipr (https://github.com/microsoft/vipr) using
the T4TemplateWriter (https://github.com/msopentech/vipr-t4templatewriter).

Copyright (c) Microsoft Open Technologies, Inc. All Rights Reserved.
Licensed under the Apache License 2.0; see LICENSE in the source repository
root for authoritative license information.﻿
******************************************************************************/
package com.microsoft.services.graph;

import com.microsoft.services.orc.core.ODataBaseEntity;


/**
 * The type Subscribed Sku.
*/
public class SubscribedSku extends ODataBaseEntity {

    public SubscribedSku(){
        setODataType("#Microsoft.Graph.SubscribedSku");
    }
            
    private String capabilityStatus;
     
    /**
    * Gets the capability Status.
    *
    * @return the String
    */
    public String getCapabilityStatus() {
        return this.capabilityStatus; 
    }

    /**
    * Sets the capability Status.
    *
    * @param value the String
    */
    public void setCapabilityStatus(String value) { 
        this.capabilityStatus = value; 
        valueChanged("capabilityStatus", value);

    }
            
    private Integer consumedUnits;
     
    /**
    * Gets the consumed Units.
    *
    * @return the Integer
    */
    public Integer getConsumedUnits() {
        return this.consumedUnits; 
    }

    /**
    * Sets the consumed Units.
    *
    * @param value the Integer
    */
    public void setConsumedUnits(Integer value) { 
        this.consumedUnits = value; 
        valueChanged("consumedUnits", value);

    }
            
    private String objectId;
     
    /**
    * Gets the object Id.
    *
    * @return the String
    */
    public String getObjectId() {
        return this.objectId; 
    }

    /**
    * Sets the object Id.
    *
    * @param value the String
    */
    public void setObjectId(String value) { 
        this.objectId = value; 
        valueChanged("objectId", value);

    }
            
    private LicenseUnitsDetail prepaidUnits;
     
    /**
    * Gets the prepaid Units.
    *
    * @return the LicenseUnitsDetail
    */
    public LicenseUnitsDetail getPrepaidUnits() {
        return this.prepaidUnits; 
    }

    /**
    * Sets the prepaid Units.
    *
    * @param value the LicenseUnitsDetail
    */
    public void setPrepaidUnits(LicenseUnitsDetail value) { 
        this.prepaidUnits = value; 
        valueChanged("prepaidUnits", value);

    }
    
        
    private java.util.List<ServicePlanInfo> servicePlans = null;
    
    
     
    /**
    * Gets the service Plans.
    *
    * @return the java.util.List<ServicePlanInfo>
    */
    public java.util.List<ServicePlanInfo> getServicePlans() {
        return this.servicePlans; 
    }

    /**
    * Sets the service Plans.
    *
    * @param value the java.util.List<ServicePlanInfo>
    */
    public void setServicePlans(java.util.List<ServicePlanInfo> value) { 
        this.servicePlans = value; 
        valueChanged("servicePlans", value);

    }
            
    private java.util.UUID skuId;
     
    /**
    * Gets the sku Id.
    *
    * @return the java.util.UUID
    */
    public java.util.UUID getSkuId() {
        return this.skuId; 
    }

    /**
    * Sets the sku Id.
    *
    * @param value the java.util.UUID
    */
    public void setSkuId(java.util.UUID value) { 
        this.skuId = value; 
        valueChanged("skuId", value);

    }
            
    private String skuPartNumber;
     
    /**
    * Gets the sku Part Number.
    *
    * @return the String
    */
    public String getSkuPartNumber() {
        return this.skuPartNumber; 
    }

    /**
    * Sets the sku Part Number.
    *
    * @param value the String
    */
    public void setSkuPartNumber(String value) { 
        this.skuPartNumber = value; 
        valueChanged("skuPartNumber", value);

    }
}

