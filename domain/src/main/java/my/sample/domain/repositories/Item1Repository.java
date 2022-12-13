package my.sample.domain.repositories;

import my.sample.domain.entities.Item1;

public interface Item1Repository {
    Item1 getById(long id);
    void save(Item1 entity);
}
