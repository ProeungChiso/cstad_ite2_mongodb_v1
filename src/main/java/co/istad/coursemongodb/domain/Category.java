package co.istad.coursemongodb.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("categories")
public class Category {
    private String id;
    private String name;
}
