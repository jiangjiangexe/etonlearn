package com.jiang.etonlearn.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { java.lang.annotation.ElementType.METHOD } )
@Retention( RetentionPolicy.RUNTIME )
@Repeatable( Masks.class )
public @interface Mask {
	// 要遮蔽的欄位
	String[] FieldAry() default {};

	// 前n個字串不需要遮蔽
	int prefixLength() default 1;

	// 後n個字串不需要遮蔽
	int postfixLength() default 1;

	// 遮蔽的字串
	String paddingString() default "*";

	// TODO 那些角色不需要遮蔽
	String[] unMaskRoleAry() default {};

	// TODO 那些ID不需要遮蔽
	String[] unMaskIDAry() default {};
}
