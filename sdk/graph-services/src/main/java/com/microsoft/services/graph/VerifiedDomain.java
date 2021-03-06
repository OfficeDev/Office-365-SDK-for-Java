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
 * The type Verified Domain.
*/
public class VerifiedDomain extends ODataBaseEntity {

    public VerifiedDomain(){
        setODataType("#Microsoft.Graph.VerifiedDomain");
    }

    private String capabilities;

    /**
    * Gets the capabilities.
    *
    * @return the String
    */
    public String getCapabilities() {
        return this.capabilities; 
    }

    /**
    * Sets the capabilities.
    *
    * @param value the String
    */
    public void setCapabilities(String value) { 
        this.capabilities = value;
        valueChanged("capabilities", value);

    }

    private Boolean $$__$$default;

    /**
    * Gets the default.
    *
    * @return the Boolean
    */
    public Boolean getDefault() {
        return this.$$__$$default; 
    }

    /**
    * Sets the default.
    *
    * @param value the Boolean
    */
    public void setDefault(Boolean value) { 
        this.$$__$$default = value;
        valueChanged("default", value);

    }

    private String id;

    /**
    * Gets the id.
    *
    * @return the String
    */
    public String getId() {
        return this.id; 
    }

    /**
    * Sets the id.
    *
    * @param value the String
    */
    public void setId(String value) { 
        this.id = value;
        valueChanged("id", value);

    }

    private Boolean initial;

    /**
    * Gets the initial.
    *
    * @return the Boolean
    */
    public Boolean getInitial() {
        return this.initial; 
    }

    /**
    * Sets the initial.
    *
    * @param value the Boolean
    */
    public void setInitial(Boolean value) { 
        this.initial = value;
        valueChanged("initial", value);

    }

    private String name;

    /**
    * Gets the name.
    *
    * @return the String
    */
    public String getName() {
        return this.name; 
    }

    /**
    * Sets the name.
    *
    * @param value the String
    */
    public void setName(String value) { 
        this.name = value;
        valueChanged("name", value);

    }

    private String type;

    /**
    * Gets the type.
    *
    * @return the String
    */
    public String getType() {
        return this.type; 
    }

    /**
    * Sets the type.
    *
    * @param value the String
    */
    public void setType(String value) { 
        this.type = value;
        valueChanged("type", value);

    }
}
