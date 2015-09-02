package com.microsoft.services;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.services.files.fetchers.FilesClient;
import com.microsoft.services.graph.Item;
import com.microsoft.services.graph.fetchers.GraphServiceClient;
import com.microsoft.services.orc.log.LogLevel;
import com.microsoft.services.orc.resolvers.JavaDependencyResolver;

import javax.naming.ServiceUnavailableException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EntryPoint {

    private final static String AUTHORITY = "https://login.windows.net/common";
    private final static String CLIENT_ID = "4a63455a-foo-4ac6-baar-0d046cf1c3f7";
    private final static String ID = "john.smith@bar.onmicrosoft.com";
    private final static String PASSWORD = "foo";

    private final static String RESOURCE_FILES = "https://foobar.sharepoint.com";
    private final static String RESOURCE_GRAPH = "00000003-0000-0000-c000-000000000000";
    private final static String FILES_ENDPOINT = "https://msopentechtest01-my.sharepoint.com/_api/v1.0/me";
    private final static String GRAPH_ENDPOINT = "https://graph.microsoft.com/beta/myOrganization";

    public static void main(String[] args) throws Exception {

        retrieveFileServicesFile();
        retrieveGraphServicesFile();
    }

    private static void retrieveFileServicesFile() throws Exception {

        AuthenticationResult result = getAccessTokenFromUserCredentials(RESOURCE_FILES, ID, PASSWORD);

        System.out.println("Access Token - " + result.getAccessToken());
        System.out.println("Refresh Token - " + result.getRefreshToken());

        JavaDependencyResolver resolver = new JavaDependencyResolver(result.getAccessToken());
        resolver.getLogger().setEnabled(true);
        resolver.getLogger().setLogLevel(LogLevel.VERBOSE);

        FilesClient client = new FilesClient(FILES_ENDPOINT, resolver);
        String filename = UUID.randomUUID().toString() + ".txt";

        com.microsoft.services.files.Item newFile = new com.microsoft.services.files.Item();
        newFile.setType("File");
        newFile.setName(filename);

        String payload = "My Content";
        com.microsoft.services.files.Item addedFile = client.getFiles().add(newFile).get();
        client.getFiles().getById(addedFile.getId()).asFile().putContent(payload.getBytes()).get();

        byte[] content = client.getFiles().getById(addedFile.getId()).asFile().getContent().get();
        String retrieved = new String(content, "UTF-8");

        System.out.println();
        System.out.println(retrieved);
    }

    private static void retrieveGraphServicesFile() throws Exception {

        AuthenticationResult result = getAccessTokenFromUserCredentials(RESOURCE_GRAPH, ID, PASSWORD);

        System.out.println("Access Token - " + result.getAccessToken());
        System.out.println("Refresh Token - " + result.getRefreshToken());

        JavaDependencyResolver resolver = new JavaDependencyResolver(result.getAccessToken());
        resolver.getLogger().setEnabled(true);
        resolver.getLogger().setLogLevel(LogLevel.VERBOSE);

        GraphServiceClient client = new GraphServiceClient(GRAPH_ENDPOINT, resolver);
        String filename = UUID.randomUUID().toString() + ".txt";

        Item newFile = new Item();
        newFile.setType("File");
        newFile.setName(filename);

        String payload = "My Content";
        Item addedFile = client.getUsers().getById(ID).getFiles().add(newFile).get();
        client.getUsers().getById(ID).getFiles().getById(addedFile.getId())
                .asFile().getOperations().uploadContent(payload.getBytes()).get();

        byte[] content = client.getUsers().getById(ID).getFiles().getById(addedFile.getId()).asFile().getOperations().content().get();
        String retrieved = new String(content, "UTF-8");

        System.out.println();
        System.out.println(retrieved);
    }

    private static AuthenticationResult getAccessTokenFromUserCredentials(String resource,
                                                                          String username, String password) throws Exception {
        AuthenticationContext context;
        AuthenticationResult result = null;
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(1);
            context = new AuthenticationContext(AUTHORITY, false, service);
            Future<AuthenticationResult> future = context.acquireToken(
                    resource, CLIENT_ID, username, password,
                    null);
            result = future.get();
        } finally {
            service.shutdown();
        }

        if (result == null) {
            throw new ServiceUnavailableException(
                    "authentication result was null");
        }
        return result;
    }
}
