package com.gm.gencode.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gm.gencode.util.DataNature;
import com.gm.gencode.util.FieldType;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormField {
    String name() default "";

    int sort() default 100;

    String label() default "";

    FieldType type() default FieldType.TEXTINPUT;

    boolean show() default true;

    String data() default "";

    DataNature dataNature() default DataNature.ARRAY;

    Class ds() default String.class;
}
