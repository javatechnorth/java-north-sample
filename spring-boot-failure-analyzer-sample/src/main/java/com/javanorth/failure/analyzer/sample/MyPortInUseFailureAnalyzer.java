package com.javanorth.failure.analyzer.sample;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.web.server.PortInUseException;

public class MyPortInUseFailureAnalyzer extends AbstractFailureAnalyzer<PortInUseException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, PortInUseException cause) {
        return new FailureAnalysis("你启动的端口 " + cause.getPort() + " 被占用",
                "快检查下端口 " + cause.getPort() + " 被哪个程序占用",
                cause);
    }
}
