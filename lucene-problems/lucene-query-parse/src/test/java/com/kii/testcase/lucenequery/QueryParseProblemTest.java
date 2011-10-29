package com.kii.testcase.lucenequery;

import org.apache.lucene.search.Query;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class QueryParseProblemTest {

	@Rule
	public TestName name = new TestName();

	public void check(Query oldStyle, Query newStyle) {
		System.out.println("====================================");
		System.out.println("Test " + name.getMethodName() + ": "
				+ oldStyle.equals(newStyle));
		System.out.println("Old = " + oldStyle);
		System.out.println("New = " + newStyle);
		Assert.assertEquals("Test " + name, oldStyle, newStyle);

	}

	@Test
	public void testJapaneseAndQueryWithDefaultAnd() {
		String query = "_deleted:true AND title:東京";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, true);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, true);
		check(oldStyle, newStyle);
	}

	@Test
	public void testJapaneseAndQueryWithDefaultOr() {
		String query = "_deleted:true AND title:東京";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, false);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, false);
		check(oldStyle, newStyle);
	}

	@Test
	public void testJapaneseQueryWithDefaultAnd() {
		String query = "_deleted:true title:東京";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, true);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, true);
		check(oldStyle, newStyle);
	}

	@Test
	public void testJapaneseQueryWithDefaultOr() {
		String query = "_deleted:true title:東京";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, false);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, false);
		check(oldStyle, newStyle);
	}

	@Test
	public void testEnglishAndQueryWithDefaultAnd() {
		String query = "_deleted:true AND title:Tokyo";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, true);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, true);
		check(oldStyle, newStyle);
	}

	@Test
	public void testEnglishAndQueryWithDefaultOr() {
		String query = "_deleted:true AND title:Tokyo";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, false);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, false);
		check(oldStyle, newStyle);
	}

	@Test
	public void testEnglishQueryWithDefaultAnd() {
		String query = "_deleted:true title:Tokyo";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, true);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, true);
		check(oldStyle, newStyle);
	}

	@Test
	public void testEnglishParenthesisQueryWithDefaultOr() {
		String query = "_deleted:true (title:Tokyo)";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, false);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, false);
		check(oldStyle, newStyle);
	}

	@Test
	public void testEnglishParenthesisAndQueryWithDefaultAnd() {
		String query = "_deleted:true AND (title:Tokyo)";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, true);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, true);
		check(oldStyle, newStyle);
	}

	@Test
	public void testEnglishAndParenthesisQueryWithDefaultOr() {
		String query = "_deleted:true AND (title:Tokyo)";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, false);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, false);
		check(oldStyle, newStyle);
	}

	@Test
	public void testEnglishParenthesisQueryWithDefaultAnd() {
		String query = "_deleted:true (title:Tokyo)";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, true);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, true);
		check(oldStyle, newStyle);
	}

	@Test
	public void testEnglishQueryWithDefaultOr() {
		String query = "_deleted:true title:Tokyo";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, false);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, false);
		check(oldStyle, newStyle);
	}

	@Test
	public void testJapaneseAndParenthesisQueryWithDefaultAnd() {
		String query = "_deleted:true AND (title:東京)";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, true);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, true);
		check(oldStyle, newStyle);
	}

	@Test
	public void testJapaneseAndParenthesisQueryWithDefaultOr() {
		String query = "_deleted:true AND (title:東京)";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, false);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, false);
		check(oldStyle, newStyle);
	}

	@Test
	public void testJapaneseParenthesisQueryWithDefaultAnd() {
		String query = "_deleted:true (title:東京)";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, true);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, true);
		check(oldStyle, newStyle);
	}

	@Test
	public void testJapaneseParenthesisQueryWithDefaultOr() {
		String query = "_deleted:true (title:東京)";
		Query oldStyle = ParserUtil.parseWithQueryParser(query, false);
		Query newStyle = ParserUtil.parseWithStandardQueryParser(query, false);
		check(oldStyle, newStyle);
	}

}
