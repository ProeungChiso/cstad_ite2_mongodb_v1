package co.istad.coursemongodb.features.category;

import co.istad.coursemongodb.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
