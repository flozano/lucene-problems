package com.kii.testcase.lucenequery;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.queryParser.QueryParser.Operator;
import org.apache.lucene.queryParser.core.QueryNodeException;
import org.apache.lucene.queryParser.standard.StandardQueryParser;
// import org.apache.lucene.queryParser.standard.config.StandardQueryConfigHandler.Operator;
import org.apache.lucene.search.Query;

public abstract class ParserUtil {

	public static Query parseWithStandardQueryParser(String query, boolean and) {
		StandardQueryParser sqp = new StandardQueryParser(getDefaultAnalyzer());
		sqp.setAllowLeadingWildcard(true);
		// sqp.setDefaultOperator(Operator.AND);
		sqp.setDefaultOperator(and ? org.apache.lucene.queryParser.standard.config.StandardQueryConfigHandler.Operator.AND
				: org.apache.lucene.queryParser.standard.config.StandardQueryConfigHandler.Operator.OR);

		try {
			return sqp.parse(query, LuceneConst.LUCENE_DEFAULT_FIELD);
		} catch (QueryNodeException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Query parseWithQueryParser(String query, boolean and) {
		QueryParser qp = new QueryParser(LuceneConst.LUCENE_VERSION,
				LuceneConst.LUCENE_DEFAULT_FIELD, getDefaultAnalyzer());
		qp.setAllowLeadingWildcard(true);
		qp.setDefaultOperator(and ? Operator.AND : Operator.OR);
		try {
			return qp.parse(query);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Analyzer getDefaultAnalyzer() {
		return new StandardAnalyzer(LuceneConst.LUCENE_VERSION);
	}
}
