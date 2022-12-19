package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="foodcooks", path="foodcooks")
public interface FoodcookRepository extends PagingAndSortingRepository<Foodcook, Long>{

}
