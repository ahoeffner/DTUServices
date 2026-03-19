package dtu.services;

import dtu.services.api.MetricsApi;
import dtu.services.api.model.Metrics;
import tools.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import tools.jackson.dataformat.yaml.YAMLFactory;
import dtu.services.library.metrics.MetricsAggregator;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class MetricsService implements MetricsApi
{
    @Autowired
    private MetricsAggregator metrics;

    private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());


    @Override
    public ResponseEntity<Metrics> metrics()
    {
        Metrics stats = mapper.convertValue(metrics.getSnapshot(),Metrics.class);
        return(ResponseEntity.ok(stats));
    }
}