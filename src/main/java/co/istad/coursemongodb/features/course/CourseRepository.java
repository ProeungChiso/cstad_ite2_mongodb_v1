package co.istad.coursemongodb.features.course;

import co.istad.coursemongodb.domain.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {

}
