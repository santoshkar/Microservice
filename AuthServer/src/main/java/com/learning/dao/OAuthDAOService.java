package com.learning.dao;

import com.learning.model.UserEntity;

public interface OAuthDAOService {

	UserEntity getUserDetails(String emailId);
}
