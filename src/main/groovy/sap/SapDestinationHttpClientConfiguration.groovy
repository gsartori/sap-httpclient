package sap

import com.sap.cloud.sdk.cloudplatform.connectivity.ApacheHttpClient5Accessor
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor
import org.apache.hc.client5.http.classic.HttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory

@Configuration
class SapDestinationHttpClientConfiguration {

    @Bean
    HttpComponentsClientHttpRequestFactory requestFactory() {
        Destination destination = DestinationAccessor.getDestination("DESTINATION_DEV")
        HttpClient client = ApacheHttpClient5Accessor.getHttpClient(destination)
        return new HttpComponentsClientHttpRequestFactory(client)
    }

}