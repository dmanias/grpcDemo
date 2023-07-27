package gr.dmanias.grpc;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@Configuration
public class ElasticConfig {

//    @Value("${spring.elasticsearch.rest.uris}")
//    private String elasticsearchUrl;
//
//    @Bean
//    public RestHighLevelClient client() {
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo(elasticsearchUrl)
//                .build();
//        return RestClients.create(clientConfiguration).rest();
//    }

    @Bean
    public RestHighLevelClient client() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
    }
    @Bean(name = "elasticsearchTemplate")
    public ElasticsearchOperations elasticsearchOperations() {
        return new ElasticsearchRestTemplate(client());
    }
}