

package com.totalit.sbms.repository;

import com.totalit.sbms.domain.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author Roy Kanavheti
 */
public interface UserRoleRepository extends CrudRepository<UserRole, Long>{
    
    @Query("from UserRole p where p.active=:active Order By p.name ASC")
    public List<UserRole> getOptAll(@Param("active") Boolean active);
    
    @Query("from UserRole p where p.name=:name")
    public UserRole getUserRoleByName(@Param("name") String name);
}
