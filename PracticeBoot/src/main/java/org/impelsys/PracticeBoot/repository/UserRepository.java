package org.impelsys.PracticeBoot.repository;

import org.impelsys.PracticeBoot.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository 
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {

	User findByName(String name);

	

	

	

}
