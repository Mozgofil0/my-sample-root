package my.sample.web.models;

import lombok.Data;
import my.sample.domain.entities.Item1;

@Data
public class Item1Model1 {

    long id;
    String name;

    public static Item1Model1 mapFrom(Item1 entity) {
        if (entity == null) {
            return null;
        }
        Item1Model1 model = new Item1Model1();

        model.setId(entity.getId());
        model.setName(entity.getName());

        return model;
    }

    public Item1 mapTo() {
        Item1 entity = new Item1();

        entity.setId(this.getId());
        entity.setName(this.getName());

        return entity;
    }
}
