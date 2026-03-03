package dtu.services;

import dtu.services.api.MetricsApi;
import dtu.services.api.model.Metrics;
import org.springframework.http.ResponseEntity;
import dtu.services.library.metrics.MetricsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class MetricsController implements MetricsApi
{
    @Autowired
    private MetricsService metrics;
    private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());



    @Override
    public ResponseEntity<dtu.services.api.model.Metrics> metrics()
    {
        Metrics stats = mapper.convertValue(metrics.getSnapshot(),Metrics.class);
        return(ResponseEntity.ok(stats));
    }
}