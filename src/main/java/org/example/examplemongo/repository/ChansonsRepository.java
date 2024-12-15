package org.example.examplemongo.repository;

import org.example.examplemongo.domain.entity.Chanson;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChansonsRepository extends MongoRepository<Chanson, Long> {
}
