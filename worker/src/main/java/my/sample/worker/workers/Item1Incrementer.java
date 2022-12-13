package my.sample.worker.workers;

import my.sample.domain.services.Item1Service;
import my.sample.worker.configuration.Item1IncrementerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
class Item1Incrementer {

    @Autowired
    Item1IncrementerProperties properties;

    @Autowired
    Item1Service service;

    @Scheduled(fixedDelay = 3000, initialDelay = 3000)
    public void increment() {
        var entity = service.getById(properties.getId());
        entity.setValue(entity.getValue() + properties.getDelta());
        service.saveItem(entity);
    }
}
