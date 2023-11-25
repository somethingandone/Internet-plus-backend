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
public class ExRegulation {
    @Id
    @Field("_id")
    private String id;

    private String title;

    private String abstractContent;

    private String text;

    private String docId;

    private String indexNo;

    private String interviewTypeName;

    private String agencyTypeName;

    private String builddate;

    private String docSubtitle;

    private String documentNo;
}
