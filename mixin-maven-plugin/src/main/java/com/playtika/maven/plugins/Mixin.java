package com.playtika.maven.plugins;

import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Model;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

public class Mixin {
    @Parameter(property = "groupId")
    private String groupId;
    @Parameter(property = "artifactId")
    private String artifactId;
    @Parameter(property = "version")
    private String version;
    @Parameter(property = "type")
    private String type;

    @Parameter(property = "mergePluginManagement")
    private Boolean mergePluginManagement;
    @Parameter(property = "mergePlugins")
    private Boolean mergePlugins;
    @Parameter(property = "mergeReporting")
    private Boolean mergeReporting;
    @Parameter(property = "mergeProperties")
    private Boolean mergeProperties;
    @Parameter(property = "mergeDistributionManagement")
    private Boolean mergeDistributionManagement;
    @Parameter(property = "mergeScm")
    private Boolean mergeScm;
    @Parameter(property = "mergeRepositories")
    private Boolean mergeRepositories;
    @Parameter(property = "mergePluginRepositories")
    private Boolean mergePluginRepositories;
    @Parameter(property = "mergeBuildExtensions")
    private Boolean mergeBuildExtensions;
    private Boolean recurse;
    private Boolean activateProfiles;
    private Mixins mixins;

    private String key;

    public void setMixins(Mixins mixins) {
        this.mixins = mixins;
    }

    public void setActivateProfiles(Boolean activateProfiles) {
        this.activateProfiles = activateProfiles;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isMergePluginManagement() {
        return mergePluginManagement != null ? mergePluginManagement : mixins.isMergePluginManagement();
    }

    public void setMergePluginManagement(Boolean mergePluginManagement) {
        this.mergePluginManagement = mergePluginManagement;
    }

    public boolean isMergePlugins() {
        return mergePlugins != null ? mergePlugins : mixins.isMergePlugins();
    }

    public void setMergePlugins(Boolean mergePlugins) {
        this.mergePlugins = mergePlugins;
    }

    public boolean isMergeReporting() {
        return mergeReporting != null ? mergeReporting : mixins.isMergeReporting();
    }

    public void setMergeReporting(Boolean mergeReporting) {
        this.mergeReporting = mergeReporting;
    }

    public boolean isMergeProperties() {
        return mergeProperties != null ? mergeProperties : mixins.isMergeProperties();
    }

    public void setMergeProperties(Boolean mergeProperties) {
        this.mergeProperties = mergeProperties;
    }

    public boolean isMergeDistributionManagement() {
        return mergeDistributionManagement != null ? mergeDistributionManagement : mixins.isMergeDistributionManagement();
    }

    public void setMergeDistributionManagement(Boolean mergeDistributionManagement) {
        this.mergeDistributionManagement = mergeDistributionManagement;
    }

    public boolean isMergeScm() {
        return mergeScm != null ? mergeScm : mixins.isMergeScm();
    }

    public void setMergeScm(Boolean mergeScm) {
        this.mergeScm = mergeScm;
    }

    private boolean isMergeRepositories() {
        return mergeRepositories != null ? mergeRepositories : mixins.isMergeRepositories();
    }

    public void setMergeRepositories(Boolean mergeRepositories) {
        this.mergeRepositories = mergeRepositories;
    }

    public boolean isMergePluginRepositories() {
        return mergePluginRepositories != null ? mergePluginRepositories : mixins.isMergePluginRepositories();
    }

    public void setMergePluginRepositories(Boolean mergePluginRepositories) {
        this.mergePluginRepositories = mergePluginRepositories;
    }

    public boolean isMergeBuildExtensions() {
        return mergeBuildExtensions != null ? mergeBuildExtensions : mixins.isMergeBuildExtensions();
    }

    public void setMergeBuildExtensions(Boolean mergeBuildExtensions) {
        this.mergeBuildExtensions = mergeBuildExtensions;
    }

    public boolean isRecurse() {
        return recurse != null ? recurse : mixins.isRecurse();
    }

    public void setRecurse(Boolean recurse) {
        this.recurse = recurse;
    }

    public Boolean isActivateProfiles() {
        return activateProfiles != null ? activateProfiles : mixins.isActivateProfiles();
    }

    public String getType() {
        if (type == null) {
            type = mixins.getDefaultMixinType();
        }
        return type;
    }

    public String getKey() {
        if (key == null) {
            key = groupId + ":" + artifactId + ":" + getType();
        }
        return key;
    }

    public void merge(Model mixinModel, MavenProject mavenProject, MavenSession mavenSession, MixinModelMerger mixinModelMerger) throws MavenExecutionException {
        if (isMergeProperties()) {
            mixinModelMerger.mergeProperties(mavenProject.getModel(), mixinModel);
        }
        if (isMergePluginManagement()) {
            mixinModelMerger.mergePluginManagement(mavenProject.getModel(), mixinModel);
        }
        if (isMergePlugins()) {
            mixinModelMerger.mergePlugins(mavenProject.getModel(), mixinModel);
        }
        if (isMergeReporting()) {
            mixinModelMerger.mergeReporting(mavenProject.getModel(), mixinModel);
        }
        if (isMergeDistributionManagement()) {
            mixinModelMerger.mergeDistributionManagement(mavenProject.getModel(), mixinModel);
        }
        if (isMergeScm()) {
            mixinModelMerger.mergeScm(mavenProject.getModel(), mixinModel);
        }
        if (isMergeRepositories()) {
            mixinModelMerger.mergeRepositories(mavenProject.getModel(), mixinModel);
        }
        if (isMergePluginRepositories()) {
            mixinModelMerger.mergePluginRepositories(mavenProject.getModel(), mixinModel);
        }
        if (isMergeBuildExtensions()) {
            mixinModelMerger.mergeBuildExtensions(mavenProject.getModel(), mixinModel);
        }
    }

    @Override
    public String toString() {
        return getKey();
    }
}
