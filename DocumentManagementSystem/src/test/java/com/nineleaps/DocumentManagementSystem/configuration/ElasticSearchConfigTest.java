//package com.nineleaps.DocumentManagementSystem.configuration;
//
//
//import io.searchbox.client.JestClient;
//import io.searchbox.client.JestClientFactory;
//import io.searchbox.client.config.HttpClientConfig;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.powermock.api.mockito.PowerMockito.*;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({Settings.class,PreBuiltTransportClient.class,TransportClient.class})
//public class ElasticSearchConfigTest {
//
//    @InjectMocks
//    ElasticSearchConfig test;
//    @Mock
//    TransportClient transportClient;
//    @Mock
//    Settings.Builder builder;
//    @Mock
//    HttpClientConfig httpClientConfig;
//
//    @Test
//    public void clients() throws Exception {
//        Settings settings = mock(Settings.class);
//        whenNew(Settings.class).withAnyArguments().thenReturn(settings);
//        TransportClient transportClient = mock(TransportClient.class, Mockito.CALLS_REAL_METHODS);
//
//        PreBuiltTransportClient preBuiltTransportClient = mock(PreBuiltTransportClient.class,Mockito.RETURNS_MOCKS);
//        whenNew(PreBuiltTransportClient.class).withArguments(any()).thenReturn(preBuiltTransportClient);
//        whenNew(TransportClient.class).withArguments(Mockito.any()).thenReturn(transportClient);
//        Client data = test.client();
//    }
//
//
//    @Test
//    public void jestClient() throws Exception {
//        JestClientFactory jestClientFactory = mock(JestClientFactory.class);
//        whenNew(JestClientFactory.class).withAnyArguments().thenReturn(jestClientFactory);
//
//        JestClient jestClient = test.jestClient();
//
//    }
//}