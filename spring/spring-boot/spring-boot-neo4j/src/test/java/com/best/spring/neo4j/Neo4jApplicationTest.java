package com.best.spring.neo4j;

import com.best.spring.neo4j.dao.*;
import com.best.spring.neo4j.model.*;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Neo4jApplicationTest {
    @Autowired
    private FieldRepo fieldRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private PlatformRepo platformRepo;
    @Autowired
    private FieldValueRepo fieldValueRepo;
    @Autowired
    private AssociatedFieldRepo associatedFieldRepo;
    @Autowired
    private PreAssociatedFieldRepo preAssociatedFieldRepo;
    @Autowired
    private AssociatedFieldValueRepo associatedFieldValueRepo;

    @Test
    public void test() {
        Platform platform = Platform.builder().platformNumber(1).platformName("亚马逊").build();
        Country country = Country.builder().countryCnName("美国").countryEnName("usa").build();
        Category category = Category.builder().categoryId("123").categoryName("dress").build();
        Field field = Field.builder().fieldName("is_adult_product").build();
        FieldValue aTrue = FieldValue.builder().enValue("TRUE").build();
        FieldValue aFalse = FieldValue.builder().enValue("FALSE").build();
        AssociatedFieldValue associatedFieldValue = AssociatedFieldValue.builder().enValue("CHILD_TRUE").build();
        associatedFieldValueRepo.saveAll(Lists.newArrayList(associatedFieldValue));
        AssociatedField associatedField = AssociatedField.builder().attributesCnName("关联标签").attributesEnName("AssociatedField").associatedFieldValue(associatedFieldValue).build();
        associatedFieldRepo.save(associatedField);
        PreAssociatedField preAssociatedField = PreAssociatedField.builder().fileName("1234").associatedField(associatedField).build();
        aTrue.setPreAssociatedField(preAssociatedField);
        field.setFieldValue(Lists.newArrayList(aFalse, aTrue));
        fieldRepo.save(field);
        category.setField(field);
        categoryRepo.save(category);
        country.setAssociatedCategory(category);
        countryRepo.save(country);
        platform.setCountry(country);
        platformRepo.save(platform);
    }
}