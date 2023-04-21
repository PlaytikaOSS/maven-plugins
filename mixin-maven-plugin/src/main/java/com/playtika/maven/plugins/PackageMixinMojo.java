package com.playtika.maven.plugins;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.MavenProjectHelper;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Mojo(name = "package-mixin", defaultPhase = LifecyclePhase.PACKAGE, requiresDependencyResolution = ResolutionScope.COMPILE, threadSafe = true)
public class PackageMixinMojo extends AbstractMojo {
    private final MavenXpp3Reader mavenXpp3reader = new MavenXpp3Reader();
    @Parameter
    private MavenProject mavenProject;
    @Parameter
    private MavenProjectHelper projectHelper;
    @Parameter(defaultValue = "${project.basedir}/mixin.xml", readonly = true)
    private File mixinFile;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (!mixinFile.exists()) {
            throw new MojoExecutionException("Cannot find file: " + mixinFile);
        }
        try (InputStream is = Files.newInputStream(mixinFile.toPath())) {
            @SuppressWarnings("unused")
            Model model = mavenXpp3reader.read(is);
            mavenProject.getArtifact().setFile(mixinFile);
        } catch (IOException e) {
            throw new MojoExecutionException("Cannot load file: " + mixinFile, e);
        } catch (XmlPullParserException e) {
            throw new MojoExecutionException("Cannot parse file: " + mixinFile, e);
        }
    }
}
