package com.dany.model.repository.secondary;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondaryRepository extends MongoRepository<SecondaryMongoObject,String> {
}
