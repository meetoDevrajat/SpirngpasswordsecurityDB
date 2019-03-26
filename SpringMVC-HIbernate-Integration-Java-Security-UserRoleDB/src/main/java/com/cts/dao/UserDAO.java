package com.cts.dao;

import com.cts.entity.User;

public interface UserDAO {

		User findByUserName(String username);

	}

