
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
    "svg",
    "png"
})
@Generated("jsonschema2pojo")
public class Flags {

    @JsonProperty("svg")
    private String svg;
    @JsonProperty("png")
    private String png;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("svg")
    public String getSvg() {
        return svg;
    }

    @JsonProperty("svg")
    public void setSvg(String svg) {
        this.svg = svg;
    }

    public Flags withSvg(String svg) {
        this.svg = svg;
        return this;
    }

    @JsonProperty("png")
    public String getPng() {
        return png;
    }

    @JsonProperty("png")
    public void setPng(String png) {
        this.png = png;
    }

    public Flags withPng(String png) {
        this.png = png;
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

    public Flags withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Flags.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("svg");
        sb.append('=');
        sb.append(((this.svg == null)?"<null>":this.svg));
        sb.append(',');
        sb.append("png");
        sb.append('=');
        sb.append(((this.png == null)?"<null>":this.png));
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
        result = ((result* 31)+((this.png == null)? 0 :this.png.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.svg == null)? 0 :this.svg.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Flags) == false) {
            return false;
        }
        Flags rhs = ((Flags) other);
        return ((((this.png == rhs.png)||((this.png!= null)&&this.png.equals(rhs.png)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.svg == rhs.svg)||((this.svg!= null)&&this.svg.equals(rhs.svg))));
    }

}
