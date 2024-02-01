package com.explore.larosa.v1.Repositories;


import org.springframework.data.repository.CrudRepository;

import com.explore.larosa.v1.Model.User;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}
