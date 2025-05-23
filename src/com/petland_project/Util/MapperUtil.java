package com.petland_project.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.petland_project.dto.OwnerDTO;
import com.petland_project.enums.Gender;
import com.petland_project.enums.PetType;

/**
 * @author NIVEDHA
 *
 */
public class MapperUtil {
	private MapperUtil() {

	}

	public static OwnerDTO convertOwnerResultSetToDto(ResultSet resultSet) throws SQLException {
		OwnerDTO owner = new OwnerDTO();
		owner.setId(resultSet.getInt("id"));
		owner.setFirstName(resultSet.getString("first_name"));
		owner.setLastName(resultSet.getString("last_name"));
		owner.setGender(Gender.valueOf(resultSet.getString("gender")));
		owner.setCity(resultSet.getString("city"));
		owner.setState(resultSet.getString("state"));
		owner.setMobileNumber(resultSet.getString("mobile_number"));
		owner.setEmailId(resultSet.getString("email_id"));
		owner.setPetId(resultSet.getInt("pet_id"));
		owner.setPetName(resultSet.getString("pet_name"));
		owner.setPetBirthDate(resultSet.getDate("pet_date_of_birth").toLocalDate());
		owner.setPetGender(Gender.valueOf(resultSet.getString("pet_gender")));
		owner.setPetType(PetType.valueOf(resultSet.getString("pet_type")));
		return owner;
	}
}