package com.sripiranavan.backend.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sripiranavan.backend.model.Role;
import com.sripiranavan.backend.model.RoleName;
import com.sripiranavan.backend.repository.RoleRepository;

@Component
public class InitData {

	@Autowired
	private RoleRepository repository;

	@EventListener
	public void loadInitData(ApplicationReadyEvent event) {
		if (repository.findAll().isEmpty()) {
			Role adminRole = new Role(RoleName.ROLE_ADMIN);
			repository.saveAndFlush(adminRole);

			Role pmRole = new Role(RoleName.ROLE_PM);
			repository.saveAndFlush(pmRole);

			Role userRole = new Role(RoleName.ROLE_USER);
			repository.saveAndFlush(userRole);
		}
	}
}
