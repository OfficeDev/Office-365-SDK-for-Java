/**
 * ****************************************************************************
 * Copyright (c) Microsoft Open Technologies, Inc.
 * All Rights Reserved
 * See License.txt in the project root for license information.
 * ****************************************************************************
 */
package com.microsoft.services.sharepoint;

import java.util.Locale;

import com.microsoft.services.sharepoint.http.HttpConnection;
import com.microsoft.services.sharepoint.http.JavaHttpConnection;


/**
 * Platform specific classes and operations
 */
public class Platform {
    static boolean mPlatformVerified = false;

    /**
     * Create http connection.
     *
     * @return the http connection
     */
    public static HttpConnection createHttpConnection() {
        return new JavaHttpConnection();
    }

    /**
     * Generates the User-Agent
     */
    public static String getUserAgent() {

        String osName = System.getProperty("os.name").toLowerCase(Locale.getDefault());
        return String.format("Office (lang=Java; os=%s; version=1.0)", osName);
    }
}
