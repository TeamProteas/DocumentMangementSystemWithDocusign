package com.nineleaps.DocumentManagementSystem.cors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;


@RunWith(PowerMockRunner.class)
@PrepareForTest(CorsFilterTest.class)
public class CorsFilterTest {

    @InjectMocks
    CorsFilter corsFilter;
    @Mock
    ServerWebExchange serverWebExchange;
    @Mock
    WebFilterChain webFilterChain;

    @Test
    public void filter() {

        Mono<Void> voidMono = corsFilter.filter(serverWebExchange, webFilterChain);
    }
}