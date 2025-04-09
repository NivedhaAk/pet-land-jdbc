package com.petland_project.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.petland_project.config.PropertiesConfig;
import com.petland_project.dto.OwnerDTO;
import com.petland_project.exceptions.DuplicateOwnerException;
import com.petland_project.exceptions.OwnerNotFoundException;
import com.petland_project.repository.OwnerRepository;
import com.petland_project.repositoryImpl.OwnerRepositoryImpl;
import com.petland_project.service.OwnerService;


/**
 * @author NIVEDHA
 *
 */
public class OwnerServiceImpl implements OwnerService {
	private OwnerRepository ownerRepository;
	private static final String OWNER_ALREADY_EXISTS = "owner.already.exists";
	private static final String OWNER_NOT_FOUND = "owner.not.found";
	private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();


	public OwnerServiceImpl() {
		this.ownerRepository = new OwnerRepositoryImpl();
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException {
		OwnerDTO existingOwner = ownerRepository.findOwner(ownerDTO.getId());
		if (Objects.nonNull(existingOwner)) {
			throw new DuplicateOwnerException(PROPERTIES_CONFIG.getProperty(OWNER_ALREADY_EXISTS) + ownerDTO.getId());
		} else {
			ownerRepository.saveOwner(ownerDTO);
		}
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		OwnerDTO owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND) + ownerId);
		} else {
			return owner;
		}
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
		OwnerDTO owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND) + ownerId);
		} else {
			ownerRepository.updatePetDetails(ownerId, petName);
		}
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		OwnerDTO owner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(owner)) {
			throw new OwnerNotFoundException(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND) + ownerId);
		} else {
			ownerRepository.deleteOwner(ownerId);
		}
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return ownerRepository.findAllOwners();
	}
	
	@Override
	public List<OwnerDTO> findOwner(String ownerEmailId, LocalDate petBirthDate) {
		return ownerRepository.findOwner(ownerEmailId, petBirthDate);
	}
}

