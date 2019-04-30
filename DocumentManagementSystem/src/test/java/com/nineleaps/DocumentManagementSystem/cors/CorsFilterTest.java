package com.nineleaps.DocumentManagementSystem.cors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CorsFilterTest {

    @InjectMocks
    CorsFilter corsFilter;

    @Mock
    WebFilterChain webFilterChain;
    @Mock
    ServerHttpRequest serverHttpRequest;

    @Test
    public void filter() {
        ServerWebExchange serverWebExchange = mock(ServerWebExchange.class, Mockito.RETURNS_MOCKS);
        Mono<Void> voidMono = corsFilter.filter(serverWebExchange, webFilterChain);
    }

    @Test
    public void filter1() {
        ServerWebExchange serverWebExchange = mock(ServerWebExchange.class, Mockito.RETURNS_MOCKS);

        when(serverWebExchange.getRequest()).thenReturn(serverHttpRequest);
        when(serverHttpRequest.getMethod()).thenReturn(HttpMethod.OPTIONS);
        Mono<Void> voidMono = corsFilter.filter(serverWebExchange, webFilterChain);


    }
    @Test
    public void filter2() {
//        ServerWebExchange serverWebExchange = mock(ServerWebExchange.class, Mockito.RETURNS_MOCKS);
//        when(serverWebExchange).thenReturn(null);
        Mono<Void> voidMono = corsFilter.filter(null, webFilterChain);


    }
}