
package com.jgvega.rest.jobsearch.model;

import java.util.HashMap;
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
    "iso639_1",
    "iso639_2",
    "name",
    "nativeName"
})
@Generated("jsonschema2pojo")
public class Language {

    @JsonProperty("iso639_1")
    private String iso6391;
    @JsonProperty("iso639_2")
    private String iso6392;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nativeName")
    private String nativeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("iso639_1")
    public String getIso6391() {
        return iso6391;
    }

    @JsonProperty("iso639_1")
    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public Language withIso6391(String iso6391) {
        this.iso6391 = iso6391;
        return this;
    }

    @JsonProperty("iso639_2")
    public String getIso6392() {
        return iso6392;
    }

    @JsonProperty("iso639_2")
    public void setIso6392(String iso6392) {
        this.iso6392 = iso6392;
    }

    public Language withIso6392(String iso6392) {
        this.iso6392 = iso6392;
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

    public Language withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("nativeName")
    public String getNativeName() {
        return nativeName;
    }

    @JsonProperty("nativeName")
    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public Language withNativeName(String nativeName) {
        this.nativeName = nativeName;
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

    public Language withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Language.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("iso6391");
        sb.append('=');
        sb.append(((this.iso6391 == null)?"<null>":this.iso6391));
        sb.append(',');
        sb.append("iso6392");
        sb.append('=');
        sb.append(((this.iso6392 == null)?"<null>":this.iso6392));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("nativeName");
        sb.append('=');
        sb.append(((this.nativeName == null)?"<null>":this.nativeName));
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
        result = ((result* 31)+((this.nativeName == null)? 0 :this.nativeName.hashCode()));
        result = ((result* 31)+((this.iso6392 == null)? 0 :this.iso6392 .hashCode()));
        result = ((result* 31)+((this.iso6391 == null)? 0 :this.iso6391 .hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Language) == false) {
            return false;
        }
        Language rhs = ((Language) other);
        return ((((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.nativeName == rhs.nativeName)||((this.nativeName!= null)&&this.nativeName.equals(rhs.nativeName))))&&((this.iso6392 == rhs.iso6392)||((this.iso6392 != null)&&this.iso6392 .equals(rhs.iso6392))))&&((this.iso6391 == rhs.iso6391)||((this.iso6391 != null)&&this.iso6391 .equals(rhs.iso6391))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
