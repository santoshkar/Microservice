package com.learning.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.learning.model.UserEntity;

@Repository
public class OAuthDAOServiceImpl implements OAuthDAOService {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserEntity getUserDetails(String username) {
		
		Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		
		List<UserEntity> list = jdbcTemplate.query("SELECT * FROM USER WHERE USERNAME=?", new String[] { username },
				(ResultSet rs, int rowNum) -> {
					UserEntity user = new UserEntity();
					user.setUsername(username);
					user.setEmailId("EMAIL_ID");
					user.setId(rs.getString("ID"));
					user.setName(rs.getString("NAME"));
					user.setPassword(rs.getString("PASSWORD"));
					return user;
				});

		if(!list.isEmpty()) {
			
			UserEntity userEntity = list.get(0);
			
			List<String> permissionList = jdbcTemplate.query("SELECT DISTINCT P.PERMISSION_NAME FROM PERMISSION P \r\n" + 
					"INNER JOIN ASSIGN_PERMISSION_TO_ROLE P_R ON P.ID=P_R.PERMISSION_ID\r\n" + 
					"INNER JOIN ROLE R ON R.ID=P_R.ROLE_ID \r\n" + 
					"INNER JOIN ASSIGN_USER_TO_ROLE U_R ON U_R.ROLE_ID=R.ID\r\n" + 
					"INNER JOIN USER U ON U.ID=U_R.USER_ID\r\n" + 
					"WHERE U.USERNAME=?", new String[] { userEntity.getUsername() },
					(ResultSet rs, int rowNum) -> {
						return "ROLE_" + rs.getString("PERMISSION_NAME");
					});
			
			if (permissionList != null && !permissionList.isEmpty()) {
				for (String permission : permissionList) {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
					grantedAuthoritiesList.add(grantedAuthority);
				}
				userEntity.setGrantedAuthoritiesList(grantedAuthoritiesList);
			}
			return userEntity;
		}
		
		return null;
	
		
		
	}

}
