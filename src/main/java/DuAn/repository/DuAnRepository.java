package DuAn.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import DuAn.model.DuAn;

@Repository
public interface DuAnRepository extends MongoRepository<DuAn, String> {

}