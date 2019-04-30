//package com.nineleaps.DocumentManagementSystem.configuration;
//
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.powermock.api.mockito.expectation.WithAnyArguments;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import static org.powermock.api.mockito.PowerMockito.when;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({})
//public class ElasticSearchConfigTest {
//
//    @InjectMocks
//    ElasticSearchConfig test;
//    @Mock
//    TransportClient transportClient;
//    @Mock
//    Settings.Builder builder;
//
//    @Test
//    public void clients() throws Exception {
//        Settings settings=mock(Settings.class);
//        whenNew(Settings.class).withAnyArguments().thenReturn(settings);
//        when(Settings.builder()).thenReturn(builder);
//        when(builder.put(anyString(),anyString())).thenReturn(builder);
//        when(builder.build()).thenReturn(settings);
//        TransportClient transportClient=mock(TransportClient.class);
//        whenNew(TransportClient.class).withAnyArguments().thenReturn(transportClient);
//        PreBuiltTransportClient preBuiltTransportClient=mock(PreBuiltTransportClient.class);
//        whenNew(PreBuiltTransportClient.class).withAnyArguments().thenReturn(preBuiltTransportClient);
//        Client data = test.client();
//    }
//
//    private WithAnyArguments<Object> whenNew(Class<Settings> settingsClass) {
//    }
//
//    @Test
//    public void jestClient() throws Exception {
//        JestClientFactory jestClientFactory=mock(JestClientFactory.class);
//        whenNew(JestClientFactory.class).withAnyArguments().thenReturn(jestClientFactory);
//        JestClient jestClient=test.jestClient();
//
//    }
//}