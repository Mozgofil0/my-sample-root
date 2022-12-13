package my.sample.domain.services;

import my.sample.domain.entities.Item1;

public interface Item1Service {
    Item1 getById(long id);
    void saveItem(Item1 item1);
}
