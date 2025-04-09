package com.petland_project.service;

import java.time.LocalDate;
import java.util.List;

import com.petland_project.dto.OwnerDTO;
import com.petland_project.exceptions.DuplicateOwnerException;
import com.petland_project.exceptions.OwnerNotFoundException;


/**
 * @author NIVEDHA
 *
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException;

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;

	List<OwnerDTO> findAllOwners();
	
	List<OwnerDTO> findOwner(String ownerEmailId, LocalDate petBirthDate);
}