package com.neutrux.BrandMS.repository;

import com.neutrux.BrandMS.model.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

}