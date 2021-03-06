package com.github.vlsidlyarevich.unity.db.repository;

import com.github.vlsidlyarevich.unity.db.model.JobType;
import com.github.vlsidlyarevich.unity.db.model.Speciality;
import com.github.vlsidlyarevich.unity.db.model.Vacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VacancyRepository extends MongoRepository<Vacancy, String> {

    Vacancy findById(String id);

    List<Vacancy> findBySpeciality(Speciality speciality);

    List<Vacancy> findByJobType(JobType jobType);

    List<Vacancy> findByLocation(String location);

}
