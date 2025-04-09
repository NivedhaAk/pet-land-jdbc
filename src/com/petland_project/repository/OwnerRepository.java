package com.petland_project.repository;

import java.time.LocalDate;
import java.util.List;

import com.petland_project.dto.OwnerDTO;


/**
 * @author NIVEDHA
 *
 */
public interface OwnerRepository {
	void saveOwner(OwnerDTO owner);

	OwnerDTO findOwner(int ownerId);

	void updatePetDetails(int ownerId, String petName);

	void deleteOwner(int ownerId);

	List<OwnerDTO> findAllOwners();
	
	List<OwnerDTO> findOwner(String ownerEmailId, LocalDate petBirthDate);
}
