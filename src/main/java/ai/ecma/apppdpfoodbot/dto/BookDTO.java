package ai.ecma.apppdpfoodbot.dto;

import ai.ecma.apppdpfoodbot.entity.Attachment;
import ai.ecma.apppdpfoodbot.entity.Category;
import ai.ecma.apppdpfoodbot.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {


    private Integer attachmentId;

    private String name;

    private Integer categoryId;

    private String description;

    private double price;

}
