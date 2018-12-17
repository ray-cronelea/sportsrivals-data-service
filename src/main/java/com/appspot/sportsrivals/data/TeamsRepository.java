package com.appspot.sportsrivals.data;

import com.appspot.sportsrivals.model.Teams;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "teams", path = "teams")
public interface TeamsRepository extends MongoRepository<Teams, String>, TeamsRepositoryCustom {

	List<Teams> findByName(String name);
	List<Teams> findByState(String id);
	List<Teams> findBySport(String id);
	List<Teams> findByCity(String id);

	// Used to prevent resource deletion
	@RestResource(exported = false)
	@Override
	default void delete(Teams entity) { }

}
