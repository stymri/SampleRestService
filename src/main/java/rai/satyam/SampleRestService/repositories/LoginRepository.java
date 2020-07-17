package rai.satyam.SampleRestService.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import rai.satyam.SampleRestService.entity.Login;

public interface LoginRepository extends CrudRepository<Login, String>{
	
	@Query("select l from Login l where l.gender = ?1 and l.date_of_birth=?2 ")
	java.util.List<Login> findLoginByGenderAndDateOfBirth(String gender , String Date);

}
