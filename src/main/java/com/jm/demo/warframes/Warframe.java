package com.jm.demo.warframes;

import com.jm.demo.abilities.Ability;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.Set;

@Data
@Document
@Accessors(chain = true)
public class Warframe {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;

    private Role role;

    private String difficulty;

    @DocumentReference
    private Set<Ability> abilities;
}
