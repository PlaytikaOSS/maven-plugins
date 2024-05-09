package com.playtika.maven.plugins;

import org.apache.maven.plugins.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Mixins {
    private List<Mixin> mixins = new ArrayList<Mixin>();
    private String defaultMixinType = "pom";

    @Parameter(property = "mergePlugins")
    private boolean mergePlugins = true;
    @Parameter(property = "mergePluginManagement")
    private boolean mergePluginManagement = true;
    @Parameter(property = "mergeBuildExtensions")
    private boolean mergeBuildExtensions = true;
    @Parameter(property = "mergeProperties")
    private boolean mergeProperties = true;
    @Parameter(property = "mergeReporting")
    private boolean mergeReporting = true;
    @Parameter(property = "mergeDistributionManagement")
    private boolean mergeDistributionManagement = true;
    private boolean recurse = true;
    private boolean activateProfiles = true;
    @Parameter(property = "mergeScm")
    private boolean mergeScm = true;
    @Parameter(property = "mergeRepositories")
    private boolean mergeRepositories = true;
    @Parameter(property = "mergePluginRepositories")
    private boolean mergePluginRepositories = true;

    public String getDefaultMixinType() {
        return defaultMixinType;
    }

    public void setDefaultMixinType(String defaultMixinType) {
        this.defaultMixinType = defaultMixinType;
    }

    public void addMixin(Mixin mixin) {
        mixins.add(mixin);
        mixin.setMixins(this);
    }

    public List<Mixin> getMixins() {
        return mixins;
    }

    public boolean isMergePlugins() {
        return mergePlugins;
    }

    public void setMergePlugins(boolean mergePlugins) {
        this.mergePlugins = mergePlugins;
    }

    public boolean isMergePluginManagement() {
        return mergePluginManagement;
    }

    public void setMergePluginManagement(boolean mergePluginManagement) {
        this.mergePluginManagement = mergePluginManagement;
    }

    public boolean isMergeProperties() {
        return mergeProperties;
    }

    public void setMergeProperties(boolean mergeProperties) {
        this.mergeProperties = mergeProperties;
    }

    public boolean isMergeDistributionManagement() {
        return mergeDistributionManagement;
    }

    public void setMergeDistributionManagement(boolean mergeDistributionManagement) {
        this.mergeDistributionManagement = mergeDistributionManagement;
    }

    public boolean isRecurse() {
        return recurse;
    }

    public void setRecurse(boolean recurse) {
        this.recurse = recurse;
    }

    public boolean isActivateProfiles() {
        return activateProfiles;
    }

    public void setActivateProfiles(boolean activateProfiles) {
        this.activateProfiles = activateProfiles;
    }

    public boolean isMergeReporting() {
        return mergeReporting;
    }

    public void setMergeReporting(boolean mergeReporting) {
        this.mergeReporting = mergeReporting;
    }

    public boolean isMergeScm() {
        return mergeScm;
    }

    public void setMergeScm(boolean mergeScm) {
        this.mergeScm = mergeScm;
    }

    public boolean isMergeRepositories() {
        return mergeRepositories;
    }

    public void setMergeRepositories(boolean mergeRepositories) {
        this.mergeRepositories = mergeRepositories;
    }

    public boolean isMergePluginRepositories() {
        return mergePluginRepositories;
    }

    public boolean isMergeBuildExtensions() {
        return mergeBuildExtensions;
    }

    public void setMergeBuildExtensions(boolean mergeBuildExtensions) {
        this.mergeBuildExtensions = mergeBuildExtensions;
    }

    public void setMergePluginRepositories(boolean mergePluginRepositories) {
        this.mergePluginRepositories = mergePluginRepositories;
    }

}
