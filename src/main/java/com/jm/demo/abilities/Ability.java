package com.jm.demo.abilities;

import com.jm.demo.warframes.Warframe;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@Document
public class Ability {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;

    private Double damage;

    @DocumentReference(lazy = true)
    private Warframe warframe;
}
