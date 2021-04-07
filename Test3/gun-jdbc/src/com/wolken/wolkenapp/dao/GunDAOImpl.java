package com.wolken.wolkenapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mel.melsapp.Connect;
import com.wolken.wolkenapp.dto.GunDTO;

public class GunDAOImpl implements GunDAO{
	//GunDTO gunDTO ;

public GunDAOImpl() {
	// TODO Auto-generated constructor stub
	//this.gunDTO = gunDTO;
}

	@Override
	public GunDTO add(GunDTO gunDTO) {
		// TODO Auto-generated method stub
		try (Connection connection = Connect.getConnect();) {  
			try (PreparedStatement preparedStatement = connection
					.prepareStatement("insert gun_details values(?,?,?,?,?,?,?,?)");) {

				preparedStatement.setInt(1, gunDTO.getGunsId());
				preparedStatement.setString(2, gunDTO.getName());
				preparedStatement.setInt(3, gunDTO.getPrice());
				preparedStatement.setString(4, gunDTO.getSerialNumber());
				preparedStatement.setString(5, gunDTO.getBrandName());
				preparedStatement.setString(6, gunDTO.getType());
				preparedStatement.setInt(7, gunDTO.getNoOfBullets());
				preparedStatement.setString(8, gunDTO.getMadeIn());

				preparedStatement.executeUpdate();

				System.out.println("Data added Successfully!!");
				
				preparedStatement.close();
				
				return gunDTO;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void getAllData() {
		// TODO Auto-generated method stub
		try (Connection connection = Connect.getConnect();) {

			try (PreparedStatement preparedStatement = connection.prepareStatement("select * from gun_details");) {

				try (ResultSet rs = preparedStatement.executeQuery();) {

					System.out.println("Getting the data");
					while (rs.next()) {
						int gunId = rs.getInt("gun_id");
						String name = rs.getString("gun_name");
						int price = rs.getInt("price");
						String brand = rs.getString("brand_name");
						String serialNumber = rs.getString("serial_number");
						String type = rs.getString("type");
						int noOfBullets = rs.getInt("no_of_bullets");
						String madeIn = rs.getString("country_name");
						System.out.println("GunId - " + gunId + "	Gun Name - " + name + "	Price - "
								+ price + "	 BrandName - " + brand + "	SerialNumber - "+ serialNumber + " Type - " + type +"	NoOfBullets - " + noOfBullets + "	CountryName - " + madeIn +"\n");
					}
				}
				preparedStatement.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void getDataByBrandName(String brandName) {
		// TODO Auto-generated method stub
		try (Connection connection = Connect.getConnect();) {

			try (PreparedStatement preparedStatement = connection
					.prepareStatement("select * from gun_details where brand_name = ?");) {
				preparedStatement.setString(1, brandName);
				try (ResultSet rs = preparedStatement.executeQuery();) {
					while (rs.next()) {
						System.out.println("Getting the data");
						while (rs.next()) {
							int gunId = rs.getInt("gun_id");
							String name = rs.getString("gun_name");
							int price = rs.getInt("price");
							String brand = rs.getString("brand_name");
							String serialNumber = rs.getString("serial_number");
							String type = rs.getString("type");
							int noOfBullets = rs.getInt("no_of_bullets");
							String madeIn = rs.getString("country_name");
							System.out.println("GunId - " + gunId + "	Gun Name - " + name + "	Price - "
									+ price + "	 BrandName - " + brand + "	SerialNumber - "+ serialNumber + " Type - " + type +"	NoOfBullets - " + noOfBullets + "	CountryName - " + madeIn +"\n");
						}
							}
				}
				preparedStatement.close();
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getDataByCountryName(String madeIn) {
		// TODO Auto-generated method stub
		try (Connection connection = Connect.getConnect();) {

			try (PreparedStatement preparedStatement = connection
					.prepareStatement("select * from gun_details where country_name = ?");) {
				preparedStatement.setString(1, madeIn);
				try (ResultSet rs = preparedStatement.executeQuery();) {
					while (rs.next()) {
						System.out.println("Getting the data");
						while (rs.next()) {
							int gunId = rs.getInt("gun_id");
							String name = rs.getString("gun_name");
							int price = rs.getInt("price");
							String brand = rs.getString("brand_name");
							String serialNumber = rs.getString("serial_number");
							String type = rs.getString("type");
							int noOfBullets = rs.getInt("no_of_bullets");
							String countryName = rs.getString("country_name");
							System.out.println("GunId - " + gunId + "	Gun Name - " + name + "	Price - "
									+ price + "	 BrandName - " + brand + "	SerialNumber - "+ serialNumber + " Type - " + type +"	NoOfBullets - " + noOfBullets + "	CountryName - " + countryName +"\n");
						}
							}
				}
				preparedStatement.close();
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public GunDTO deleteByGunId(int gunId) {
		// TODO Auto-generated method stub
		GunDTO dto=getDataByGunId(gunId);
		try (Connection connection = Connect.getConnect();) {

			try (PreparedStatement preparedStatement = connection
					.prepareStatement("delete from gun_details where gun_id = ?");) {
				preparedStatement.setInt(1, gunId);
				preparedStatement.executeUpdate();

				preparedStatement.close();
				return dto;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
	}

	private GunDTO getDataByGunId(int gunId) {
		// TODO Auto-generated method stub
		if(gunId >0) {
			GunDTO gundto =  new GunDTO();
			try (Connection connection = Connect.getConnect();) {

				try (PreparedStatement preparedStatement = connection
						.prepareStatement("select * from gun_details where gun_id = ?");) {
					preparedStatement.setInt(1, gunId);
					try (ResultSet rs = preparedStatement.executeQuery();) {
						while (rs.next()) {
							System.out.println("Getting the data");
							while (rs.next()) {
								gundto.setGunsId( rs.getInt("gun_id"));
								gundto.setName(rs.getString("gun_name"));
								gundto.setPrice(rs.getInt("price"));
								gundto.setBrandName(rs.getString("brand_name"));
								gundto.setSerialNumber(rs.getString("serial_number"));
								gundto.setType(rs.getString("type"));
								gundto.setNoOfBullets(rs.getInt("no_of_bullets")); 
								gundto.setMadeIn(rs.getString("country_name"));
								System.out.println("GunId - " + Id + "	Gun Name - " + name + "	Price - "
										+ price + "	 BrandName - " + brand + "	SerialNumber - "+ serialNumber + " Type - " + type +"	NoOfBullets - " + noOfBullets + "	CountryName - " + countryName +"\n");
							}
								}
					}
					preparedStatement.close();
					return gundto;
				} 
	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
		
	}

	@Override
	public GunDTO updateBySerialNumber(String serialNumber) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		try (Connection connection = Connect.getConnect();) {

			try (PreparedStatement preparedStatement = connection.prepareStatement("update gun_details set gun_name =? where serialNumber =? ");){
			
				System.out.println("Enter the name to be updated:");
				String name = scanner.next();
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, serialNumber);

				preparedStatement.executeUpdate();

				System.out.println("SerialNumber - " + serialNumber + "	Name - " + name + "\n");
				
				preparedStatement.close();
				connection.close();
				
				return gunDTO;
			}
			

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	


}
