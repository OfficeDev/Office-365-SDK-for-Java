/*******************************************************************************
 * Copyright (c) Microsoft Open Technologies, Inc.
 * All Rights Reserved
 * See License.txt in the project root for license information.
 ******************************************************************************/
package com.microsoft.services.sharepoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * The Class SPList.
 */
public class SPWeb extends OfficeEntity {

    /**
     * List from json.
     *
     * @param json the json
     * @return the list
     * @throws JSONException the JSON exception
     */
    public static List<SPWeb> listFromJson(JSONObject json) throws JSONException {
        return listFromJson(json, SPWeb.class);
    }


    /**
     * Instantiates a new SP list.
     * <p>
     * the JSON exception
     */
    public SPWeb() {
        super();
    }


    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return getData("Id").toString();
    }


    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return getData("Title").toString();
    }


    /**
     * Get the server relative URL
     * @return
     */
    public String getServerRelativeUrl() {
        return getData("ServerRelativeUrl").toString();
    }

    /**
     * Get the description
     * @return
     */
    public String getDescription() {
        return getData("Description").toString();
    }

}
