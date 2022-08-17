package DuAn.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import DuAn.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}