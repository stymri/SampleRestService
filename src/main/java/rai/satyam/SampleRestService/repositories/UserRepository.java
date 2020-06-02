package rai.satyam.SampleRestService.repositories;

import org.springframework.data.repository.CrudRepository;

import rai.satyam.SampleRestService.entity.User;

public interface UserRepository extends CrudRepository<User, String>{
}