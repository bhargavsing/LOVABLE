package com.MAJORPROJECT.LOVABLE.repository;

import com.MAJORPROJECT.LOVABLE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
