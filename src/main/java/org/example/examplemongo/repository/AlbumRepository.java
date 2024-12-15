package org.example.examplemongo.repository;

import org.example.examplemongo.domain.entity.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, Long> {
}
