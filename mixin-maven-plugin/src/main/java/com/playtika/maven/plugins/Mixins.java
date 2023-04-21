package com.playtika.maven.plugins;

import java.util.ArrayList;
import java.util.List;

public class Mixins {
    private List<Mixin> mixins = new ArrayList<Mixin>();
    private boolean mergePlugins = true;
    private boolean mergePluginManagement = true;
    private boolean mergeProperties = true;
    private boolean mergeReporting = true;
    private boolean mergeDistributionManagement = true;
    private boolean recurse = true;
    private boolean activateProfiles = true;
    private String defaultMixinType = "pom";
    private boolean mergeScm = true;
    private boolean mergeRepositories = true;
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

    public void setMergePluginRepositories(boolean mergePluginRepositories) {
        this.mergePluginRepositories = mergePluginRepositories;
    }

}
