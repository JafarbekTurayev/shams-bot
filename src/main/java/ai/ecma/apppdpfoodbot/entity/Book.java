package ai.ecma.apppdpfoodbot.entity;

import ai.ecma.apppdpfoodbot.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book extends AbsNameEntity {

    @OneToOne
    private Attachment attachment;

    @ManyToOne
    private Category category;

    @Column(columnDefinition = "text")
    private String description;

    private double price;

}
