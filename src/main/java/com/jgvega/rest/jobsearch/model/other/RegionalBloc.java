
package com.jgvega.rest.jobsearch.model.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acronym",
    "name",
    "otherNames",
    "otherAcronyms"
})
@Generated("jsonschema2pojo")
public class RegionalBloc {

    @JsonProperty("acronym")
    private String acronym;
    @JsonProperty("name")
    private String name;
    @JsonProperty("otherNames")
    private List<String> otherNames = new ArrayList<String>();
    @JsonProperty("otherAcronyms")
    private List<String> otherAcronyms = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("acronym")
    public String getAcronym() {
        return acronym;
    }

    @JsonProperty("acronym")
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public RegionalBloc withAcronym(String acronym) {
        this.acronym = acronym;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public RegionalBloc withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("otherNames")
    public List<String> getOtherNames() {
        return otherNames;
    }

    @JsonProperty("otherNames")
    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    public RegionalBloc withOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
        return this;
    }

    @JsonProperty("otherAcronyms")
    public List<String> getOtherAcronyms() {
        return otherAcronyms;
    }

    @JsonProperty("otherAcronyms")
    public void setOtherAcronyms(List<String> otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    public RegionalBloc withOtherAcronyms(List<String> otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public RegionalBloc withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RegionalBloc.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("acronym");
        sb.append('=');
        sb.append(((this.acronym == null)?"<null>":this.acronym));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("otherNames");
        sb.append('=');
        sb.append(((this.otherNames == null)?"<null>":this.otherNames));
        sb.append(',');
        sb.append("otherAcronyms");
        sb.append('=');
        sb.append(((this.otherAcronyms == null)?"<null>":this.otherAcronyms));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.otherAcronyms == null)? 0 :this.otherAcronyms.hashCode()));
        result = ((result* 31)+((this.otherNames == null)? 0 :this.otherNames.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.acronym == null)? 0 :this.acronym.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RegionalBloc) == false) {
            return false;
        }
        RegionalBloc rhs = ((RegionalBloc) other);
        return ((((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.otherAcronyms == rhs.otherAcronyms)||((this.otherAcronyms!= null)&&this.otherAcronyms.equals(rhs.otherAcronyms))))&&((this.otherNames == rhs.otherNames)||((this.otherNames!= null)&&this.otherNames.equals(rhs.otherNames))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.acronym == rhs.acronym)||((this.acronym!= null)&&this.acronym.equals(rhs.acronym))));
    }

}
