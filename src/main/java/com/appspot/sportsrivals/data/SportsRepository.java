package com.appspot.sportsrivals.data;

import com.appspot.sportsrivals.model.Sports;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "sports", path = "sports")
public interface SportsRepository extends MongoRepository<Sports, String> {

	List<Sports> findByName(@Param("name") String name);

	// Used to prevent resource deletion
	@RestResource(exported = false)
	@Override
	default void delete(Sports entity) { }

}
