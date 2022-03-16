package ai.ecma.apppdpfoodbot.entity;

import ai.ecma.apppdpfoodbot.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends AbsEntity {

    private String chatId;

    private String fullName;
    private float lat;
    private float lon;

    private String phone;
    private String lang;
    private String state;

}
