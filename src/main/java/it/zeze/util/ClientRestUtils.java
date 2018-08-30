package it.zeze.util;

import it.zeze.fanta.exception.FantaFormazioneException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import javax.net.ssl.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;

public class ClientRestUtils {

    private static final Log LOG = LogFactory.getLog(ListUtil.class);

    private static Client client = null;

    private static final boolean THROW_ON_HTTP_ERROR = true;

    private static int getTimetoutFromProperties() {
        int toReturn = 120000;
        return toReturn;
    }

    private static Client getClient() {
        if (client == null) {
            ClientConfig configuration = new ClientConfig();
            configuration.property(ClientProperties.CONNECT_TIMEOUT, getTimetoutFromProperties());
            configuration.property(ClientProperties.READ_TIMEOUT, getTimetoutFromProperties());
            client = ClientBuilder.newClient(configuration);
        }
        return client;
    }

    /**
     * @param keyStorePath
     * @param keyStorePassword
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws KeyStoreException
     * @throws IOException
     * @throws CertificateException
     * @throws UnrecoverableKeyException
     * @throws KeyManagementException
     */
    public static Client createSSLClient(String keyStorePath, String keyStorePassword) throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException, IOException, CertificateException, UnrecoverableKeyException, KeyManagementException {
        KeyManager[] oKeyManager = null;
        String _sKeyStorePath = keyStorePath;
        String _sKeyStorePwd = keyStorePassword;
        if (_sKeyStorePath != null) {
            KeyManagerFactory keyMgrFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            KeyStore oKeyStore = KeyStore.getInstance("PKCS12");
            InputStream inKeyStore = FileUtils.openInputStream(new File(_sKeyStorePath));
            oKeyStore.load(inKeyStore, _sKeyStorePwd.toCharArray());
            keyMgrFactory.init(oKeyStore, _sKeyStorePwd.toCharArray());
            oKeyManager = keyMgrFactory.getKeyManagers();
        }

        TrustManager easyTrustManager = new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkServerTrusted(X509Certificate[] arg0, String arg1) {
                return;
            }

            public void checkClientTrusted(X509Certificate[] arg0, String arg1) {
                return;
            }
        };

        SSLContext oSSLContext = SSLContext.getInstance("TLS");
        oSSLContext.init(oKeyManager, new TrustManager[]{easyTrustManager}, new SecureRandom());

        Client clientSSL = ClientBuilder.newBuilder().sslContext(oSSLContext).build();
        clientSSL.property(ClientProperties.CONNECT_TIMEOUT, getTimetoutFromProperties());
        clientSSL.property(ClientProperties.READ_TIMEOUT, getTimetoutFromProperties());

        return clientSSL;
    }

    private static <T> T getCall(WebTarget webTarget, Map<String, String> headerParams, Map<String, String> queryParams, MediaType returnedMediaType, Class<T> returnedClass, boolean throwOnHTTPError) throws Exception {
        T toReturn = null;

        webTarget = setQueryParams(webTarget, queryParams);

        Invocation.Builder invocationBuilder = webTarget.request(returnedMediaType);
        setHeaderParams(invocationBuilder, headerParams);

        String restUrl = webTarget.getUri().toString();
        LOG.debug("Calling GET - [" + restUrl + "] ...");
        Response response = invocationBuilder.get();
        LOG.debug("... end GET - [" + restUrl + "]");
        checkResponse(response, throwOnHTTPError);

        toReturn = response.readEntity(returnedClass);
        return toReturn;
    }

    public static <T> T getCall(String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType returnedMediaType, Class<T> returnedClass) throws Exception {
        return getCall(restUrl, headerParams, queryParams, returnedMediaType, returnedClass, THROW_ON_HTTP_ERROR);
    }

    public static <T> T getCall(String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType returnedMediaType, Class<T> returnedClass, boolean throwOnHTTPError) throws Exception {
        WebTarget webTarget = getClient().target(restUrl);
        return getCall(webTarget, headerParams, queryParams, returnedMediaType, returnedClass, throwOnHTTPError);
    }

    public static <T> T getCall(Client client, String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType returnedMediaType, Class<T> returnedClass) throws Exception {
        WebTarget webTarget = client.target(restUrl);
        return getCall(webTarget, headerParams, queryParams, returnedMediaType, returnedClass, THROW_ON_HTTP_ERROR);
    }

    public static <T> T getCall(Client client, String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType returnedMediaType, Class<T> returnedClass, boolean throwOnHTTPError) throws Exception {
        WebTarget webTarget = client.target(restUrl);
        return getCall(webTarget, headerParams, queryParams, returnedMediaType, returnedClass, throwOnHTTPError);
    }

    private static <T> String postCall(WebTarget webTarget, Map<String, String> headerParams, Map<String, String> queryParams, MediaType postMediaTypeObj, T postObj, MediaType returnedMediaType, boolean throwOnHTTPError) throws Exception {
        String toReturn = null;

        webTarget = setQueryParams(webTarget, queryParams);

        Invocation.Builder invocationBuilder = webTarget.request(returnedMediaType);
        setHeaderParams(invocationBuilder, headerParams);

        String restUrl = webTarget.getUri().toString();
        Entity<T> entityToSend = Entity.entity(postObj, postMediaTypeObj);

        LOG.debug("Calling POST - [" + restUrl + "] ...");
        Response response = invocationBuilder.post(entityToSend);
        LOG.debug("... end POST - [" + restUrl + "]");

        checkResponse(response, throwOnHTTPError);

        toReturn = response.readEntity(String.class);
        return toReturn;
    }

    public static String postCall(String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType postMediaTypeObj, String postObj, MediaType returnedMediaType) throws Exception {
        return postCall(restUrl, headerParams, queryParams, postMediaTypeObj, postObj, returnedMediaType, THROW_ON_HTTP_ERROR);
    }

    public static String postCall(String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType postMediaTypeObj, String postObj, MediaType returnedMediaType, boolean throwOnHTTPError) throws Exception {
        WebTarget webTarget = getClient().target(restUrl);
        return postCall(webTarget, headerParams, queryParams, postMediaTypeObj, postObj, returnedMediaType, throwOnHTTPError);
    }

    public static String postCall(Client client, String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType postMediaTypeObj, String postObj, MediaType returnedMediaType) throws Exception {
        WebTarget webTarget = client.target(restUrl);
        return postCall(webTarget, headerParams, queryParams, postMediaTypeObj, postObj, returnedMediaType, THROW_ON_HTTP_ERROR);
    }

    public static String postCall(Client client, String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType postMediaTypeObj, String postObj, MediaType returnedMediaType, boolean throwOnHTTPError) throws Exception {
        WebTarget webTarget = client.target(restUrl);
        return postCall(webTarget, headerParams, queryParams, postMediaTypeObj, postObj, returnedMediaType, throwOnHTTPError);
    }

    public static String postCall(String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType postMediaTypeObj, List<MultiPartObject> files, MediaType returnedMediaType) throws Exception {
        return postCall(restUrl, headerParams, queryParams, postMediaTypeObj, files, returnedMediaType, THROW_ON_HTTP_ERROR);
    }

    public static String postCall(String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType postMediaTypeObj, List<MultiPartObject> files, MediaType returnedMediaType, boolean throwOnHTTPError) throws Exception {
        String toReturn = null;
        List<File> tmpFiles = new ArrayList<File>();

        Client client = ClientBuilder.newClient();
        client.register(MultiPartFeature.class);

        WebTarget webTarget = client.target(restUrl);

        webTarget = setQueryParams(webTarget, queryParams);

        Invocation.Builder invocationBuilder = webTarget.request(returnedMediaType);

        setHeaderParams(invocationBuilder, headerParams);

        try (FormDataMultiPart multiPartEntity = new FormDataMultiPart();) {
            String multiPartName;
            String multiPartFileName;
            for (MultiPartObject currentMultiPartToSend : files) {
                multiPartName = currentMultiPartToSend.getFileDisposition().getName();
                multiPartFileName = currentMultiPartToSend.getFileDisposition().getFileName();
                File tmpFile = File.createTempFile(multiPartFileName, "");
                FileUtils.copyInputStreamToFile(currentMultiPartToSend.getFile(), tmpFile);
                FileDataBodyPart fileDataBodyPart = new FileDataBodyPart(multiPartName, tmpFile);
                fileDataBodyPart.setContentDisposition(
                        FormDataContentDisposition
                                .name(multiPartName)
                                .fileName(multiPartFileName)
                                .build());
                multiPartEntity.bodyPart(fileDataBodyPart);
                tmpFiles.add(tmpFile);
            }

            Entity<FormDataMultiPart> entityToSend = Entity.entity(multiPartEntity, multiPartEntity.getMediaType());
            multiPartEntity.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
            LOG.debug("Calling POST - [" + restUrl + "] ...");
            Response response = invocationBuilder.post(entityToSend);
            LOG.debug("... end POST - [" + restUrl + "]");

            checkResponse(response, true);

            toReturn = response.readEntity(String.class);
            LOG.debug(toReturn);
            return toReturn;
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            for (File tmpFile : tmpFiles)
                tmpFile.delete();
        }
    }

    private static String putCall(WebTarget webTarget, Map<String, String> headerParams, MediaType postMediaTypeObj, String postObj, MediaType returnedMediaType, boolean throwOnHTTPError) throws Exception {
        String toReturn = null;

        Invocation.Builder invocationBuilder = webTarget.request(returnedMediaType);
        setHeaderParams(invocationBuilder, headerParams);

        Entity<String> entityToSend = Entity.entity(postObj, postMediaTypeObj);
        String restUrl = webTarget.getUri().toString();
        LOG.debug("Calling PUT - [" + restUrl + "] ...");
        Response response = invocationBuilder.put(entityToSend);
        LOG.debug("... end PUT - [" + restUrl + "]");

        checkResponse(response, throwOnHTTPError);

        toReturn = response.readEntity(String.class);
        return toReturn;
    }

    public static String putCall(String restUrl, Map<String, String> headerParams, MediaType postMediaTypeObj, String postObj, MediaType returnedMediaType) throws Exception {
        return putCall(restUrl, headerParams, postMediaTypeObj, postObj, returnedMediaType, THROW_ON_HTTP_ERROR);
    }

    public static String putCall(String restUrl, Map<String, String> headerParams, MediaType postMediaTypeObj, String postObj, MediaType returnedMediaType, boolean throwOnHTTPError) throws Exception {
        WebTarget webTarget = getClient().target(restUrl);
        return putCall(webTarget, headerParams, postMediaTypeObj, postObj, returnedMediaType, throwOnHTTPError);
    }

    public static String putCall(Client client, String restUrl, Map<String, String> headerParams, MediaType postMediaTypeObj, String postObj, MediaType returnedMediaType) throws Exception {
        WebTarget webTarget = client.target(restUrl);
        return putCall(webTarget, headerParams, postMediaTypeObj, postObj, returnedMediaType, THROW_ON_HTTP_ERROR);
    }

    public static String putCall(Client client, String restUrl, Map<String, String> headerParams, MediaType postMediaTypeObj, String postObj, MediaType returnedMediaType, boolean throwOnHTTPError) throws Exception {
        WebTarget webTarget = client.target(restUrl);
        return putCall(webTarget, headerParams, postMediaTypeObj, postObj, returnedMediaType, throwOnHTTPError);
    }

    private static String deleteCall(WebTarget webTarget, Map<String, String> headerParams, Map<String, String> queryParams, MediaType returnedMediaType, boolean throwOnHTTPError) throws Exception {
        String toReturn = null;

        webTarget = setQueryParams(webTarget, queryParams);

        Invocation.Builder invocationBuilder = webTarget.request(returnedMediaType);
        setHeaderParams(invocationBuilder, headerParams);

        String restUrl = webTarget.getUri().toString();
        LOG.debug("Calling DELETE - [" + restUrl + "] ...");
        Response response = invocationBuilder.delete();
        LOG.debug("... end DELETE - [" + restUrl + "]");

        checkResponse(response, throwOnHTTPError);

        toReturn = response.readEntity(String.class);
        return toReturn;
    }

    public static String deleteCall(String restUrl, Map<String, String> headerParams, Map<String, String> queryParams, MediaType returnedMediaType) throws Exception {
        WebTarget webTarget = getClient().target(restUrl);
        return deleteCall(webTarget, headerParams, queryParams, returnedMediaType, THROW_ON_HTTP_ERROR);
    }

    private static void checkResponse(Response response, boolean throwOnHTTPError) throws Exception {
        if (response != null) {
            if (throwOnHTTPError) {
                int statusCode = response.getStatus();
                if (statusCode < 200 || statusCode >= 300) {
                    LOG.error(response.readEntity(String.class));
                    String responseMessage = response.getStatusInfo().getReasonPhrase();
                    throw new FantaFormazioneException("Rest response code status [" + statusCode + "] message [" + responseMessage + "]");
                }
            }
        } else {
            throw new Exception("Rest response is null");
        }
    }

    private static void setHeaderParams(Invocation.Builder invocationBuilder, Map<String, String> headerParams) {
        if (headerParams != null && !headerParams.isEmpty()) {
            Iterator<Entry<String, String>> itEntrySet = headerParams.entrySet().iterator();
            Entry<String, String> currentEntry;
            while (itEntrySet.hasNext()) {
                currentEntry = itEntrySet.next();
                invocationBuilder = invocationBuilder.header(currentEntry.getKey(), currentEntry.getValue());
            }
        }
    }

    private static WebTarget setQueryParams(WebTarget webTarget, Map<String, String> queryParams) {
        WebTarget toReturn = webTarget;
        if (queryParams != null && !queryParams.isEmpty()) {
            Iterator<Entry<String, String>> itEntrySet = queryParams.entrySet().iterator();
            Entry<String, String> currentEntry;
            while (itEntrySet.hasNext()) {
                currentEntry = itEntrySet.next();
                toReturn = toReturn.queryParam(currentEntry.getKey(), currentEntry.getValue());
            }
        }
        return toReturn;
    }

    public static Map<String, String> createBasicAuth(String username, String password) {
        Map<String, String> toReturn = new HashMap<String, String>();
        String toConvert = username + ":" + password;
        String converted = Base64.encodeBase64String(toConvert.getBytes());
        toReturn.put("Authorization", "Basic " + converted);
        return toReturn;
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> headerParams = new HashMap<String, String>();

        InputStream response = getCall("https://www.fantagazzetta.com/Servizi/Voti.ashx?s=2018-19&g=2&tv=273177201713&t=17", headerParams, null, MediaType.APPLICATION_OCTET_STREAM_TYPE, InputStream.class);
        System.out.println(IOUtils.toString(response));

    }
}
