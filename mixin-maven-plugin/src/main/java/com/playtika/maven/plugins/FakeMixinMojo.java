package com.playtika.maven.plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * This mojo is a fake mojo just for having the mixins configuration available in IDEs such as intelliJ
 *
 * @author odavid
 */
@Mojo(name = "fake-mixin-mojo", threadSafe = true)
public class FakeMixinMojo extends AbstractMojo {

    @Parameter(property = "mixins")
    private List<Mixin> mixins = new ArrayList<>();

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        //DO NOTHING...
    }

}
