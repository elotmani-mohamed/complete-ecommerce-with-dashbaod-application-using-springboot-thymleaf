package com.ecommerce.upload;

import java.util.List;

public interface UsersService {

	List<Users> getAllUsers();

	Users saveUsers(Users users);

}
