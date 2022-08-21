package com.busrauzan.customerarchiving.DataAccess;

import com.busrauzan.customerarchiving.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
