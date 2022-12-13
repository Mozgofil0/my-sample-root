package my.sample.repository.implementations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.sample.domain.entities.Item1;
import my.sample.domain.repositories.Item1Repository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

@Service
class Item1RepositoryImpl implements Item1Repository {

    @Value(value = "${my-sample.repository.directory}")
    private String directory;
    private Map<Long, Item1> heap;

    @Override
    public Item1 getById(long id) {

        System.out.printf("asked Item1 by id: %s%n", id);

        readHeap();
        if (heap.containsKey(id)) {
            return heap.get(id);
        } else {
            var m = new Item1();
            m.setId(id);
            m.setName(String.format("New Item1 with id:%s", id));
            heap.put(id, m);
            writeHeap();
            return m;
        }
    }

    @Override
    public void save(Item1 entity) {
        readHeap();
        heap.put(entity.getId(), entity);
        writeHeap();
    }

    private Path heapPath;

    private Path getHeapPath() {
        if (heapPath == null) {
            heapPath = Path.of(directory, "heap.json");
        }
        return heapPath;
    }

    private void readHeap() {
        try {
            if (!Files.exists(getHeapPath())) {
                heap = new HashMap<>();
                return;
            }
            String json = Files.readString(getHeapPath(), StandardCharsets.UTF_8);
            TypeReference<HashMap<Long, Item1>> typeRef
                    = new TypeReference<>() {
            };
            heap = new ObjectMapper().readValue(json, typeRef);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeHeap() {
        try {
            if (heap == null) {
                readHeap();
            }
            String json = new ObjectMapper()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(heap);
            if (!Files.exists(getHeapPath())) {
                Files.createDirectories(getHeapPath().getParent());
            }
            Files.writeString(getHeapPath(), json, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
