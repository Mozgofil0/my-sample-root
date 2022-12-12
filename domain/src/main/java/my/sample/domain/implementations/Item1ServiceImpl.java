package my.sample.domain.implementations;

import my.sample.domain.entities.Item1;
import my.sample.domain.services.Item1Service;
import org.springframework.stereotype.Service;

@Service
class Item1ServiceImpl implements Item1Service {
    @Override
    public Item1 getById(long id) {
        var m = new Item1();

        System.out.printf("asked Item1 by id: %s%n", id);

        m.setId(id);
        m.setName(String.format("Item1 № %s", id));
        return m;
    }
}
