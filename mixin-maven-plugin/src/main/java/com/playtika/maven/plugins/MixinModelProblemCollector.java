package com.playtika.maven.plugins;

import org.apache.maven.MavenExecutionException;
import org.apache.maven.model.building.ModelProblem;
import org.apache.maven.model.building.ModelProblemCollector;
import org.apache.maven.model.building.ModelProblemCollectorRequest;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class MixinModelProblemCollector implements ModelProblemCollector {
    private final Set<ModelProblem.Severity> SEVERITIES = EnumSet.noneOf(ModelProblem.Severity.class);
    List<ModelProblemCollectorRequest> problems = new ArrayList<>();

    @Override
    public void add(ModelProblemCollectorRequest req) {
        problems.add(req);
        SEVERITIES.add(req.getSeverity());
    }

    public void clear() {
        problems.clear();
        SEVERITIES.clear();
    }

    public void checkErrors(File pom) throws MavenExecutionException {
        if (SEVERITIES.contains(ModelProblem.Severity.ERROR) || SEVERITIES.contains(ModelProblem.Severity.FATAL)) {
            PrintWriter out = new PrintWriter(new StringWriter());
            for (ModelProblemCollectorRequest request : problems) {
                out.printf("Model Problem: %s%n", request.getMessage());
            }
            throw new MavenExecutionException(out.toString(), pom);
        }

    }
}
