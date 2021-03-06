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

package com.microsoft.windowsazure.management.scheduler;

import com.microsoft.windowsazure.core.OperationResponse;
import com.microsoft.windowsazure.core.ServiceClient;
import com.microsoft.windowsazure.core.utils.BOMInputStream;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.credentials.SubscriptionCloudCredentials;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.configuration.ManagementConfiguration;
import com.microsoft.windowsazure.management.scheduler.models.CloudServiceOperationStatus;
import com.microsoft.windowsazure.management.scheduler.models.CloudServiceOperationStatusResponse;
import com.microsoft.windowsazure.management.scheduler.models.EntitleResourceParameters;
import com.microsoft.windowsazure.tracing.CloudTracing;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class CloudServiceManagementClientImpl extends ServiceClient<CloudServiceManagementClient> implements CloudServiceManagementClient {
    private String apiVersion;
    
    /**
    * Gets the API version.
    * @return The ApiVersion value.
    */
    public String getApiVersion() {
        return this.apiVersion;
    }
    
    private URI baseUri;
    
    /**
    * Gets the URI used as the base for all cloud service requests.
    * @return The BaseUri value.
    */
    public URI getBaseUri() {
        return this.baseUri;
    }
    
    private SubscriptionCloudCredentials credentials;
    
    /**
    * Gets subscription credentials which uniquely identify Microsoft Azure
    * subscription. The subscription ID forms part of the URI for every
    * service call.
    * @return The Credentials value.
    */
    public SubscriptionCloudCredentials getCredentials() {
        return this.credentials;
    }
    
    private int longRunningOperationInitialTimeout;
    
    /**
    * Gets or sets the initial timeout for Long Running Operations.
    * @return The LongRunningOperationInitialTimeout value.
    */
    public int getLongRunningOperationInitialTimeout() {
        return this.longRunningOperationInitialTimeout;
    }
    
    /**
    * Gets or sets the initial timeout for Long Running Operations.
    * @param longRunningOperationInitialTimeoutValue The
    * LongRunningOperationInitialTimeout value.
    */
    public void setLongRunningOperationInitialTimeout(final int longRunningOperationInitialTimeoutValue) {
        this.longRunningOperationInitialTimeout = longRunningOperationInitialTimeoutValue;
    }
    
    private int longRunningOperationRetryTimeout;
    
    /**
    * Gets or sets the retry timeout for Long Running Operations.
    * @return The LongRunningOperationRetryTimeout value.
    */
    public int getLongRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }
    
    /**
    * Gets or sets the retry timeout for Long Running Operations.
    * @param longRunningOperationRetryTimeoutValue The
    * LongRunningOperationRetryTimeout value.
    */
    public void setLongRunningOperationRetryTimeout(final int longRunningOperationRetryTimeoutValue) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeoutValue;
    }
    
    private CloudServiceOperations cloudServices;
    
    /**
    * @return The CloudServicesOperations value.
    */
    public CloudServiceOperations getCloudServicesOperations() {
        return this.cloudServices;
    }
    
    /**
    * Initializes a new instance of the CloudServiceManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    */
    public CloudServiceManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService) {
        super(httpBuilder, executorService);
        this.cloudServices = new CloudServiceOperationsImpl(this);
        this.apiVersion = "2013-03-01";
        this.longRunningOperationInitialTimeout = -1;
        this.longRunningOperationRetryTimeout = -1;
    }
    
    /**
    * Initializes a new instance of the CloudServiceManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    * @param credentials Required. Gets subscription credentials which uniquely
    * identify Microsoft Azure subscription. The subscription ID forms part of
    * the URI for every service call.
    * @param baseUri Optional. Gets the URI used as the base for all cloud
    * service requests.
    */
    @Inject
    public CloudServiceManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService, @Named(ManagementConfiguration.SUBSCRIPTION_CLOUD_CREDENTIALS) SubscriptionCloudCredentials credentials, @Named(ManagementConfiguration.URI) URI baseUri) {
        this(httpBuilder, executorService);
        if (credentials == null) {
            throw new NullPointerException("credentials");
        } else {
            this.credentials = credentials;
        }
        if (baseUri == null) {
            try {
                this.baseUri = new URI("https://management.core.windows.net");
            }
            catch (URISyntaxException ex) {
            }
        } else {
            this.baseUri = baseUri;
        }
    }
    
    /**
    * Initializes a new instance of the CloudServiceManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    * @param credentials Required. Gets subscription credentials which uniquely
    * identify Microsoft Azure subscription. The subscription ID forms part of
    * the URI for every service call.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    */
    public CloudServiceManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService, SubscriptionCloudCredentials credentials) throws URISyntaxException {
        this(httpBuilder, executorService);
        if (credentials == null) {
            throw new NullPointerException("credentials");
        }
        this.credentials = credentials;
        this.baseUri = new URI("https://management.core.windows.net");
    }
    
    /**
    * Initializes a new instance of the CloudServiceManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    * @param credentials Required. Gets subscription credentials which uniquely
    * identify Microsoft Azure subscription. The subscription ID forms part of
    * the URI for every service call.
    * @param baseUri Optional. Gets the URI used as the base for all cloud
    * service requests.
    * @param apiVersion Optional. Gets the API version.
    * @param longRunningOperationInitialTimeout Required. Gets or sets the
    * initial timeout for Long Running Operations.
    * @param longRunningOperationRetryTimeout Required. Gets or sets the retry
    * timeout for Long Running Operations.
    */
    public CloudServiceManagementClientImpl(HttpClientBuilder httpBuilder, ExecutorService executorService, SubscriptionCloudCredentials credentials, URI baseUri, String apiVersion, int longRunningOperationInitialTimeout, int longRunningOperationRetryTimeout) {
        this(httpBuilder, executorService);
        this.credentials = credentials;
        this.baseUri = baseUri;
        this.apiVersion = apiVersion;
        this.longRunningOperationInitialTimeout = longRunningOperationInitialTimeout;
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
    }
    
    /**
    * Initializes a new instance of the CloudServiceManagementClientImpl class.
    *
    * @param httpBuilder The HTTP client builder.
    * @param executorService The executor service.
    */
    protected CloudServiceManagementClientImpl newInstance(HttpClientBuilder httpBuilder, ExecutorService executorService) {
        return new CloudServiceManagementClientImpl(httpBuilder, executorService, this.getCredentials(), this.getBaseUri(), this.getApiVersion(), this.getLongRunningOperationInitialTimeout(), this.getLongRunningOperationRetryTimeout());
    }
    
    /**
    * EntitleResource is used only for 3rd party Store providers. Each
    * subscription must be entitled for the resource before creating that
    * particular type of resource.
    *
    * @param parameters Required. Parameters provided to the EntitleResource
    * method.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<OperationResponse> entitleResourceAsync(final EntitleResourceParameters parameters) {
        return this.getExecutorService().submit(new Callable<OperationResponse>() { 
            @Override
            public OperationResponse call() throws Exception {
                return entitleResource(parameters);
            }
         });
    }
    
    /**
    * EntitleResource is used only for 3rd party Store providers. Each
    * subscription must be entitled for the resource before creating that
    * particular type of resource.
    *
    * @param parameters Required. Parameters provided to the EntitleResource
    * method.
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public OperationResponse entitleResource(EntitleResourceParameters parameters) throws ParserConfigurationException, SAXException, TransformerException, IOException, ServiceException {
        // Validate
        if (parameters == null) {
            throw new NullPointerException("parameters");
        }
        if (parameters.getResourceNamespace() == null) {
            throw new NullPointerException("parameters.ResourceNamespace");
        }
        if (parameters.getResourceType() == null) {
            throw new NullPointerException("parameters.ResourceType");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "entitleResourceAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "";
        if (this.getCredentials().getSubscriptionId() != null) {
            url = url + URLEncoder.encode(this.getCredentials().getSubscriptionId(), "UTF-8");
        }
        url = url + "/EntitleResource";
        String baseUrl = this.getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        url = url.replace(" ", "%20");
        
        // Create HTTP transport objects
        HttpPost httpRequest = new HttpPost(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/xml");
        httpRequest.setHeader("x-ms-version", "2013-03-01");
        
        // Serialize Request
        String requestContent = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document requestDoc = documentBuilder.newDocument();
        
        Element entitleResourceElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "EntitleResource");
        requestDoc.appendChild(entitleResourceElement);
        
        Element resourceProviderNameSpaceElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "ResourceProviderNameSpace");
        resourceProviderNameSpaceElement.appendChild(requestDoc.createTextNode(parameters.getResourceNamespace()));
        entitleResourceElement.appendChild(resourceProviderNameSpaceElement);
        
        Element typeElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "Type");
        typeElement.appendChild(requestDoc.createTextNode(parameters.getResourceType()));
        entitleResourceElement.appendChild(typeElement);
        
        Element registrationDateElement = requestDoc.createElementNS("http://schemas.microsoft.com/windowsazure", "RegistrationDate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        registrationDateElement.appendChild(requestDoc.createTextNode(simpleDateFormat.format(parameters.getRegistrationDate().getTime())));
        entitleResourceElement.appendChild(registrationDateElement);
        
        DOMSource domSource = new DOMSource(requestDoc);
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);
        requestContent = stringWriter.toString();
        StringEntity entity = new StringEntity(requestContent);
        httpRequest.setEntity(entity);
        httpRequest.setHeader("Content-Type", "application/xml");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_ACCEPTED) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, requestContent, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            OperationResponse result = null;
            // Deserialize Response
            result = new OperationResponse();
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * The Get Operation Status operation returns the status of thespecified
    * operation. After calling an asynchronous operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param requestId Required. The request ID for the request you wish to
    * track. The request ID is returned in the x-ms-request-id response header
    * for every request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request.  If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    @Override
    public Future<CloudServiceOperationStatusResponse> getOperationStatusAsync(final String requestId) {
        return this.getExecutorService().submit(new Callable<CloudServiceOperationStatusResponse>() { 
            @Override
            public CloudServiceOperationStatusResponse call() throws Exception {
                return getOperationStatus(requestId);
            }
         });
    }
    
    /**
    * The Get Operation Status operation returns the status of thespecified
    * operation. After calling an asynchronous operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param requestId Required. The request ID for the request you wish to
    * track. The request ID is returned in the x-ms-request-id response header
    * for every request.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request.  If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    @Override
    public CloudServiceOperationStatusResponse getOperationStatus(String requestId) throws IOException, ServiceException, ParserConfigurationException, SAXException {
        // Validate
        if (requestId == null) {
            throw new NullPointerException("requestId");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("requestId", requestId);
            CloudTracing.enter(invocationId, this, "getOperationStatusAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "";
        if (this.getCredentials().getSubscriptionId() != null) {
            url = url + URLEncoder.encode(this.getCredentials().getSubscriptionId(), "UTF-8");
        }
        url = url + "/operations/";
        url = url + URLEncoder.encode(requestId, "UTF-8");
        String baseUrl = this.getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        url = url.replace(" ", "%20");
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2013-03-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            CloudServiceOperationStatusResponse result = null;
            // Deserialize Response
            if (statusCode == HttpStatus.SC_OK) {
                InputStream responseContent = httpResponse.getEntity().getContent();
                result = new CloudServiceOperationStatusResponse();
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                documentBuilderFactory.setNamespaceAware(true);
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document responseDoc = documentBuilder.parse(new BOMInputStream(responseContent));
                
                Element operationElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "Operation");
                if (operationElement != null) {
                    Element idElement = XmlUtility.getElementByTagNameNS(operationElement, "http://schemas.microsoft.com/windowsazure", "ID");
                    if (idElement != null) {
                        String idInstance;
                        idInstance = idElement.getTextContent();
                        result.setId(idInstance);
                    }
                    
                    Element statusElement = XmlUtility.getElementByTagNameNS(operationElement, "http://schemas.microsoft.com/windowsazure", "Status");
                    if (statusElement != null && statusElement.getTextContent() != null && !statusElement.getTextContent().isEmpty()) {
                        CloudServiceOperationStatus statusInstance;
                        statusInstance = CloudServiceOperationStatus.valueOf(statusElement.getTextContent());
                        result.setStatus(statusInstance);
                    }
                    
                    Element httpStatusCodeElement = XmlUtility.getElementByTagNameNS(operationElement, "http://schemas.microsoft.com/windowsazure", "HttpStatusCode");
                    if (httpStatusCodeElement != null && httpStatusCodeElement.getTextContent() != null && !httpStatusCodeElement.getTextContent().isEmpty()) {
                        Integer httpStatusCodeInstance;
                        httpStatusCodeInstance = Integer.valueOf(httpStatusCodeElement.getTextContent());
                        result.setHttpStatusCode(httpStatusCodeInstance);
                    }
                    
                    Element errorElement = XmlUtility.getElementByTagNameNS(operationElement, "http://schemas.microsoft.com/windowsazure", "Error");
                    if (errorElement != null) {
                        CloudServiceOperationStatusResponse.ErrorDetails errorInstance = new CloudServiceOperationStatusResponse.ErrorDetails();
                        result.setError(errorInstance);
                        
                        Element codeElement = XmlUtility.getElementByTagNameNS(errorElement, "http://schemas.microsoft.com/windowsazure", "Code");
                        if (codeElement != null) {
                            String codeInstance;
                            codeInstance = codeElement.getTextContent();
                            errorInstance.setCode(codeInstance);
                        }
                        
                        Element messageElement = XmlUtility.getElementByTagNameNS(errorElement, "http://schemas.microsoft.com/windowsazure", "Message");
                        if (messageElement != null) {
                            String messageInstance;
                            messageInstance = messageElement.getTextContent();
                            errorInstance.setMessage(messageInstance);
                        }
                    }
                }
                
            }
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
}
