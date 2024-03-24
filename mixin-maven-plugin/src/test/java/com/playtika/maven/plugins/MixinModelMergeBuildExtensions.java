package com.playtika.maven.plugins;

import java.util.List;

import org.apache.maven.model.Build;
import org.apache.maven.model.Extension;
import org.apache.maven.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class MixinModelMergeBuildExtensions {

    private MixinModelMerger merger;
    private Model buildExtensions, emptyBuildExtensions;

    @BeforeEach
    public void setup() {
        merger = new MixinModelMerger();
        buildExtensions = new Model();
        buildExtensions.setBuild(new Build());
        Extension extension = new Extension();
        extension.setGroupId("com.test");
        extension.setArtifactId("test-magre-extension");
        extension.setVersion("1.0.0");
        buildExtensions.getBuild().getExtensions().add(extension);

        emptyBuildExtensions = new Model();
        emptyBuildExtensions.setBuild(new Build());
    }

    @Test
    public void testEmptyTarget() {
        List<Extension> origExtensions = buildExtensions.getBuild().getExtensions();
        assertNotNull(origExtensions);
        assertEquals(origExtensions.size(), 1);
        merger.mergeBuildExtensions(emptyBuildExtensions, buildExtensions);
        assertEquals(origExtensions, buildExtensions.getBuild().getExtensions());
    }

    @Test
    public void testEmptySrc() {
        merger.mergeScm(buildExtensions, emptyBuildExtensions);
        assertNotNull(emptyBuildExtensions.getBuild().getExtensions());
        assertEquals(emptyBuildExtensions.getBuild().getExtensions().size(), 0);

        assertNotNull(buildExtensions.getBuild().getExtensions());
        assertEquals(buildExtensions.getBuild().getExtensions().size(), 1);
    }

    @Test
    public void testMageFromSrc() {
        emptyBuildExtensions = new Model();
        emptyBuildExtensions.setBuild(new Build());
        Extension extension = new Extension();
        extension.setGroupId("com.test2");
        extension.setArtifactId("test-magre-extension-v2");
        extension.setVersion("2.0.0");
        emptyBuildExtensions.getBuild().getExtensions().add(extension);

        assertNotNull(buildExtensions.getBuild().getExtensions());
        assertEquals(1, buildExtensions.getBuild().getExtensions().size());

        assertNotNull(emptyBuildExtensions.getBuild().getExtensions());
        assertEquals(1, emptyBuildExtensions.getBuild().getExtensions().size());

        merger.mergeBuildExtensions(buildExtensions, emptyBuildExtensions);

        assertNotNull(buildExtensions.getBuild().getExtensions());
        assertEquals(2, buildExtensions.getBuild().getExtensions().size());
    }
}
