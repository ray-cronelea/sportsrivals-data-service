package com.appspot.sportsrivals;

import com.appspot.sportsrivals.model.*;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RestConfiguration extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Teams.class);
		config.exposeIdsFor(States.class);
		config.exposeIdsFor(Fixtures.class);
		config.exposeIdsFor(Cities.class);
		config.exposeIdsFor(Sports.class);
	}
}
