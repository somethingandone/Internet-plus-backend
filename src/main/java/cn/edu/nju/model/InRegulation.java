package cn.edu.nju.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InRegulation {
    @Id
    @Field("_id")
    private String id;

    private String title;

    private String content;

    private String department;

//    @Field("created_at")
//    private Date createdAt;
}
