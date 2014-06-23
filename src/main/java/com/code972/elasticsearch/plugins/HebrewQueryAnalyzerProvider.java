package com.code972.elasticsearch.plugins;

import com.code972.elasticsearch.analysis.HebrewQueryAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
import org.elasticsearch.common.collect.Maps;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import org.elasticsearch.index.settings.IndexSettings;

import java.io.IOException;
import java.util.Map;

public class HebrewQueryAnalyzerProvider extends AbstractIndexAnalyzerProvider<HebrewQueryAnalyzer> {
    private final HebrewQueryAnalyzer hebrewAnalyzer;

    @Inject
    public HebrewQueryAnalyzerProvider(Index index, @IndexSettings Settings indexSettings, Environment env, @Assisted String name, @Assisted Settings settings) throws IOException {
        super(index, indexSettings, name, settings);
        hebrewAnalyzer = new HebrewQueryAnalyzer();
    }

    @Override
    public HebrewQueryAnalyzer get() {
        return hebrewAnalyzer;
    }
}