package gr.dmanias.grpc;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;

public interface GrpcLogRepository extends ElasticsearchRepository<GrpcLog, String>{
    <S extends GrpcLog> S save(S entity);
}
