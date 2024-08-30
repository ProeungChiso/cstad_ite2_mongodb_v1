package co.istad.coursemongodb;

import co.istad.coursemongodb.domain.Category;
import co.istad.coursemongodb.domain.Course;
import co.istad.coursemongodb.features.category.CategoryRepository;
import co.istad.coursemongodb.features.course.CourseRepository;
import org.bson.types.Decimal128;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@SpringBootTest
class CourseMongodbApplicationTests {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateCategory(){
        Category category = new Category();
        category.setName("backend");

        categoryRepository.save(category);
    }

    @Test
    void testCreateCourse() {
        Course course = new Course();
        course.setName("java");
        course.setDescription("basic java");
        course.setPrice(Decimal128.parse("50"));
        course.setImage("image.png");
        course.setLocation("phnompenh");
        course.setIsDeleted(false);
        course.setCategoryName("backend");

        courseRepository.save(course);
    }

    @Test
    void testFilter(){
        Query query = new Query();

        Criteria byName = Criteria
                .where("name")
                .regex("ja","i");

        Criteria byPrice = Criteria
                .where("price")
                .gte(Decimal128.parse("50"));

        Criteria criteria = new Criteria();
        criteria.andOperator(byName, byPrice);

        query.addCriteria(criteria);

        List<Course> courses = mongoTemplate.find(query, Course.class);

        courses.forEach(System.out::println);
    }

}
