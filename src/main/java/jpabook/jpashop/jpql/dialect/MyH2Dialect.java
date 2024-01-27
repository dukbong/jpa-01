package jpabook.jpashop.jpql.dialect;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MyH2Dialect extends H2Dialect {

	public MyH2Dialect() {
		registerFunction("function_name", new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
	}
}
