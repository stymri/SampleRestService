package rai.satyam.SampleRestService.repositories;

import org.springframework.data.repository.CrudRepository;

import rai.satyam.SampleRestService.entity.Login;

public interface LoginRepository extends CrudRepository<Login, String>{

}
