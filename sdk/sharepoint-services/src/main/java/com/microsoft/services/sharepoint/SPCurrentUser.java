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
public class SPCurrentUser extends OfficeEntity {

    /**
     * List from json.
     *
     * @param json the json
     * @return the list
     * @throws JSONException the JSON exception
     */
    public static List<SPCurrentUser> listFromJson(JSONObject json) throws JSONException {
        return listFromJson(json, SPCurrentUser.class);
    }


    /**
     * Instantiates a new SP list.
     * <p>
     * the JSON exception
     */
    public SPCurrentUser() {
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
     * Gets the login name.
     *
     * @return the login name
     */
    public String getLoginName() {
        return getData("LoginName").toString();
    }


    /**
     * Get whether user is site admin
     *
     * @return
     */
    public boolean getIsSiteAdmin() {
        return Boolean.parseBoolean(getData("IsSiteAdmin").toString());
    }


    /**
     * Get whether user is hidden in the UI
     *
     * @return hidden in UI
     */
    public boolean getIsHiddenInUIn() {
        return Boolean.parseBoolean(getData("IsHiddenInUI").toString());
    }


    /**
     * Get if the user is a guest user
     *
     * @return
     */
    public String getIsShareByEmailGuestUser() {
        return getData("Description").toString();
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
     * Gets the user's email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return getData("Email").toString();
    }


    /**
     * Gets the user's principal type.
     *
     * @return the principal type
     */
    public int getPrincipalType() {
        return Integer.parseInt(getData("PrincipalType").toString());
    }


}
