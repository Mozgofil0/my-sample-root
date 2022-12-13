package my.sample.domain.implementations;

import my.sample.domain.entities.Item1;
import my.sample.domain.repositories.Item1Repository;
import my.sample.domain.services.Item1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class Item1ServiceImpl implements Item1Service {

    @Autowired
    Item1Repository repository;

    @Override
    public Item1 getById(long id) {
        return repository.getById(id);
    }

    @Override
    public void saveItem(Item1 item1) {
        repository.save(item1);
    }
}
