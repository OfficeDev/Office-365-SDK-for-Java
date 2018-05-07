/*******************************************************************************
 * Copyright (c) Microsoft Open Technologies, Inc.
 * All Rights Reserved
 * See License.txt in the project root for license information.
 ******************************************************************************/
package com.microsoft.services.sharepoint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * The Class OfficeEntity.
 */
public abstract class OfficeEntity {

    /**
     * The m json data.
     */
    private JSONObject mJsonData;


    /**
     * Gets the json data.
     *
     * @return the json data
     */
    protected JSONObject getJsonData() {
        return mJsonData;
    }


    /**
     * List from json.
     *
     * @param <E>   the element type
     * @param json  the json
     * @param clazz the clazz
     * @return the list
     * @throws org.json.JSONException the JSON exception
     */
    protected static <E extends OfficeEntity> List<E> listFromJson(JSONObject json,
                                                                   Class<E> clazz) throws JSONException {
        List<E> list = new ArrayList<E>();

        JSONArray results = null;
        if (json.has("d")) {
            JSONObject d = json.getJSONObject("d");
            if (d.has("results"))
                results = d.getJSONArray("results");
            else if (d.has("Webs"))
                results = d.getJSONObject("Webs").getJSONArray("results");
        } else {
            results = json.getJSONArray("results");
        }

        if (results != null)
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);

                E item = null;
                try {
                    item = clazz.newInstance();
                } catch (Throwable e) {
                }

                if (item != null) {
                    item.loadFromJson(result);
                    list.add(item);
                }
            }

        return list;
    }


    protected static <E extends OfficeEntity> E createFromJson(JSONObject json,
                                                               Class<E> clazz) throws JSONException {
        JSONObject o = json;
        if (json.has("d")) {
            o = json.getJSONObject("d");
        }
        E item = null;
        try {
            item = clazz.newInstance();
        } catch (Throwable e) {
        }

        if (item != null) {
            item.loadFromJson(o);
        }
        return item;
    }


    /**
     * Load from json.
     *
     * @param json the json
     */
    public void loadFromJson(JSONObject json) {
        mJsonData = json;
    }


    /**
     * Load from json.
     *
     * @param json        the json
     * @param isPlainItem the is plain item
     */
    public void loadFromJson(JSONObject json, boolean isPlainItem) {
        if (isPlainItem) {
            loadFromJson(json);
        } else {
            JSONObject innerJson;
            try {
                innerJson = json.getJSONObject("d");
                loadFromJson(innerJson);
            } catch (JSONException e) {
                throw new IllegalArgumentException("Expected 'd' element", e);
            }
        }
    }


    /**
     * Gets the data.
     *
     * @param field the field
     * @return the data
     */
    public Object getData(String field) {
        try {
            JSONObject innerJson;
            if (mJsonData.has("d")) {
                innerJson = mJsonData.getJSONObject("d");
                return innerJson.get(field);
            } else {
                return mJsonData.get(field);
            }
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid field name " + field, e);
        }
    }


    public Collection<String> getKeyNames() throws JSONException {
        JSONObject innerJson = mJsonData;
        if (mJsonData.has("d")) {
            innerJson = mJsonData.getJSONObject("d");
        }
        return Arrays.asList(JSONObject.getNames(innerJson));
    }


    @Override
    public String toString() {
        if (mJsonData != null) {
            return mJsonData.toString();
        }
        return super.toString();
    }
}
