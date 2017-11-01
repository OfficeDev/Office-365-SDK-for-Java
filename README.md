**Important**: This preview SDK has been deprecated and is no longer being maintained. We recommend that you use [Microsoft Graph](https://graph.microsoft.com/) and the associated [Microsoft Graph SDKs](https://developer.microsoft.com/en-us/graph/code-samples-and-sdks) instead.

# Office 365 SDKs for Java

Easily integrate services and data from Office 365 into Java apps using these libraries.

[![Build Status](https://travis-ci.org/OfficeDev/Office-365-SDK-for-Java.svg?branch=master)](https://travis-ci.org/OfficeDev/Office-365-SDK-for-Java)
[![Download](https://api.bintray.com/packages/msopentech/Maven/Office-365-SDK-for-Java/images/download.svg)](https://bintray.com/msopentech/Maven/Office-365-SDK-for-Java/_latestVersion)

---

:exclamation:**NOTE**: You are free to use this code and library according to the terms of its included [LICENSE](/LICENSE) and to open issues in this repo for unofficial support.

Information about official Microsoft support is available [here][support-placeholder].

[support-placeholder]: https://support.microsoft.com/

---

These libraries are generated from API metadata using [Vipr] and [Vipr-T4TemplateWriter] and use a shared client stack provided by [orc-for-java].

For information on release cadence and how to access built binaries before release, see [Releases](https://github.com/OfficeDev/Office-365-SDK-for-Java/wiki/Releases).

Current services, service versions, and SDK versions:

|API|Service Version|SDK Version|Artifact Id|
|---|---------------|-----------|-----------|
|Mail/Calendar/Contacts|1.0|1.0.0|outlook-services-java|
|Files|1.0|1.0.0|files-services-java|
|Discovery|1.0|1.0.0|discovery-services-java|
|AAD Graph|1.5|0.15.0|directory-services-java|
|OneNote|1.0|0.15.0|onenote-services-java|
|Unified API|beta|0.2.5|graph-services-java|
|SharePoint Lists|1.0|1.0.0|sharepoint-services-java|

[Vipr]: https://github.com/microsoft/vipr
[Vipr-T4TemplateWriter]: https://github.com/msopentech/vipr-t4templatewriter
[orc-for-java]: https://github.com/msopentech/orc-for-java

## Quick Start

To use these libraries in your project, follow these general steps, as described further below:

1. Configure dependencies in build.gradle.
2. Set up authentication.
3. Construct an API client.
4. Call methods to make REST calls and receive results.

### Authenticate and construct client
With your project prepared, the next step is to initialize the dependency manager and an API client.

:exclamation: If you haven't yet registered your app in Azure AD, you'll need to do so before completing this step by following [these instructions][MSDN Add Common Consent].

[MSDN Add Common Consent]: https://msdn.microsoft.com/en-us/office/office365/howto/add-common-consent-manually

## Contributing
You will need to sign a [Contributor License Agreement](https://cla.msopentech.com/) before submitting your pull request. To complete the Contributor License Agreement (CLA), you will need to submit a request via the form and then electronically sign the Contributor License Agreement when you receive the email containing the link to the document. This needs to only be done once for any Microsoft Open Technologies OSS project.

## License
Copyright (c) Microsoft Open Technologies, Inc. All rights reserved. Licensed under the Apache License, Version 2.0.
