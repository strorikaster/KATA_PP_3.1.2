package com.webcrudsecurityboot.repository;

import com.webcrudsecurityboot.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//public interface RoleRepository {
//    List<Role> getAllRoles();
//    Role show(Long id);
//    void save(Role role);
//    void update(Role updatedRole);
//    void delete(Long id);
//}
@Repository
public  interface RoleRepository extends CrudRepository<Role, Long> {
    //User findByName(String name);
}

