package com.space.repositories;

import com.space.domains.SpaceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceUserRepository extends JpaRepository<SpaceUser,String> {

}
