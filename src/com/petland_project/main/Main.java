package com.petland_project.main;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.petland_project.Util.InputUtil;
import com.petland_project.dto.OwnerDTO;
import com.petland_project.service.OwnerService;
import com.petland_project.serviceImpl.OwnerServiceImpl;



/**
 * @author NIVEDHA
 *
 */
public class Main {
		private OwnerService ownerService;

		public static void main(String[] args) throws IOException {
			Main demo = new Main();
			demo.run(args);
		}

		public void run(String... args) {
			ownerService = new OwnerServiceImpl();
			try (Scanner scanner = new Scanner(System.in)) {
				do {
					System.out.println("Welcome to Pet Land");
					int menuOption = InputUtil.acceptMenuOption(scanner);
					switch (menuOption) {
					case 1:
						OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
						ownerService.saveOwner(ownerDTO);
						System.out.println("Owner has been saved successfully.");
						break;
					case 2:
						int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
						ownerDTO = ownerService.findOwner(ownerId);
						System.out.println("Owner has been fetched successfully.");
						System.out.println(ownerDTO);
						break;
					case 3:
						ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
						String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
						ownerService.updatePetDetails(ownerId, petName);
						System.out.println("Pet details of owner have been updated successfully.");
						break;
					case 4:
						ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
						ownerService.deleteOwner(ownerId);
						System.out.println("Owner has been deleted successfully.");
						break;
					case 5:
						List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
						System.out.println("There are " + ownerDTOList.size() + " owners.");
						ownerDTOList.forEach(System.out::println);
						break;
					case 6:
						String ownerEmailId = InputUtil.acceptOwnerEmailIdToOperate(scanner);
						LocalDate petBirthDate = InputUtil.acceptPetBirthDateToOperate(scanner);
						ownerDTOList = ownerService.findOwner(ownerEmailId, petBirthDate);
						ownerDTOList.forEach(System.out::println);
						break;
					default:
						System.out.println("Invalid option entered.");
					}
				} while (InputUtil.wantToContinue(scanner));
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
