package com.javanorth.failure.analyzer.sample;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

public class JavaNorthFailureAnalyzer  extends AbstractFailureAnalyzer<JavaNorthException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, JavaNorthException cause) {
        return new FailureAnalysis("java north error.", "快去检查一下吧", cause);
    }
}
