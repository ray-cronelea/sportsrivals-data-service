package com.appspot.sportsrivals.data;

import com.appspot.sportsrivals.model.States;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "states", path = "states")
public interface StatesRepository extends MongoRepository<States, String> {

	List<States> findByName(@Param("name") String name);

	// Used to prevent resource deletion
	@RestResource(exported = false)
	@Override
	default void delete(States entity) { }

}
