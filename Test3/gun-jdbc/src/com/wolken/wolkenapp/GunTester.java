package com.wolken.wolkenapp;

import java.util.Scanner;

import com.wolken.wolkenapp.dto.GunDTO;
import com.wolken.wolkenapp.service.GunService;
import com.wolken.wolkenapp.service.GunServiceImpl;



public class GunTester {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		GunDTO gunDTO = new GunDTO();
		GunService gunService = new GunServiceImpl();

		while (true) {

			System.out.println("Gun details:");

			System.out.println("Select any of the following choices:");
			System.out.println(
					"1 - Add the gun data\n2 - Update the gun data by serial number\n3 - Get the gun data by brand name \n4 - Get the gun data by country name\n5 - Get all\n6 - Delete the gun data by guns id\n");

			System.out.println("Enter the choice");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter the gun id:");
				gunDTO.setGunsId(scanner.nextInt());

				System.out.println("Enter the gun name:");
				gunDTO.setName(scanner.next());

				System.out.println("Enter the price:");
				gunDTO.setPrice(scanner.nextInt());
				
				System.out.println("Enter the serial number:");
				gunDTO.setSerialNumber(scanner.next());

				System.out.println("Enter the brand name:");
				gunDTO.setBrandName(scanner.next());
				
				System.out.println("Enter the type:");
				gunDTO.setType(scanner.next());

				System.out.println("Enter the no. of bullets:");
				gunDTO.setNoOfBullets((scanner.nextInt()));
				
				System.out.println("Enter the country name:");
				gunDTO.setMadeIn(scanner.next());

				gunService.validateAndAdd(gunDTO);
				break;

			case 2:
				System.out.println("Enter the serial number:");
				gunService.validateAndUpdate(scanner.next()); //GunDTO
				break;
				
			case 3:

				System.out.println("Enter the brand name:");
				gunService.validateAndGetByBrandName(scanner.next());
				break;
				
			case 4:
				System.out.println("Enter the country name:");
				gunService.validateAndGetByCountryName(scanner.next());
				break;
				
			case 5:
				gunService.validateAndGetAll();
				break;

			case 6:
				System.out.println("Enter the gun id:");
				gunService.validateAndDeleteByGunId(scanner.nextInt()); //GunDTO
				break;

			default:
				System.out.println("Enter the valid choice!");

			}

		}
	}

}
