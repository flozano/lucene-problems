package com.kii.testcase.lucenequery;

import org.apache.lucene.util.NumericUtils;
import org.apache.lucene.util.Version;

public abstract class LuceneConst {
	
	public static final String LUCENE_DEFAULT_FIELD = "_all";
	
	public static final Version LUCENE_VERSION = Version.LUCENE_34;
	
	public static final int LUCENE_NUMERIC_PRECISION_STEP = NumericUtils.PRECISION_STEP_DEFAULT;
	
	
}
