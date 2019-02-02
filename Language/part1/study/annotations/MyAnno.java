package study.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PACKAGE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) 
public @interface MyAnno
{
	String str();
	int val();
	String memo() default "No memo";
}

