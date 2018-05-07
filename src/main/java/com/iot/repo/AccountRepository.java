package com.iot.repo;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.iot.security.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
  
  public Account findByUsername(String username);

}
