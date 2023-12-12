package cn.edu.nju.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InRegulationSplit {
    @Id
    @Field("_id")
    private String id;

    private String title;

    private String itemContent;

    @TextIndexed
    private String _words;
}
