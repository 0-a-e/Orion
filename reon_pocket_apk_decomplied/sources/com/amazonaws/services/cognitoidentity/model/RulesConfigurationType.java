package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RulesConfigurationType implements Serializable {
    private List<MappingRule> rules;

    public List<MappingRule> getRules() {
        return this.rules;
    }

    public void setRules(Collection<MappingRule> collection) {
        if (collection == null) {
            this.rules = null;
        } else {
            this.rules = new ArrayList(collection);
        }
    }

    public RulesConfigurationType withRules(MappingRule... mappingRuleArr) {
        if (getRules() == null) {
            this.rules = new ArrayList(mappingRuleArr.length);
        }
        for (MappingRule add : mappingRuleArr) {
            this.rules.add(add);
        }
        return this;
    }

    public RulesConfigurationType withRules(Collection<MappingRule> collection) {
        setRules(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRules() != null) {
            sb.append("Rules: " + getRules());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getRules() == null ? 0 : getRules().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RulesConfigurationType)) {
            return false;
        }
        RulesConfigurationType rulesConfigurationType = (RulesConfigurationType) obj;
        if ((rulesConfigurationType.getRules() == null) ^ (getRules() == null)) {
            return false;
        }
        return rulesConfigurationType.getRules() == null || rulesConfigurationType.getRules().equals(getRules());
    }
}
