package co.istad.coursemongodb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("courses")
public class Course {
    @Id
    private String id;
    private String name;
    private Decimal128 price;
    private String description;
    private String categoryName;
    private String location;
    private String image;
    private Boolean isDeleted;
}
