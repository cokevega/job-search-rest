
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
    "br",
    "pt",
    "nl",
    "hr",
    "fa",
    "de",
    "es",
    "fr",
    "ja",
    "it",
    "hu"
})
@Generated("jsonschema2pojo")
public class Translations {

    @JsonProperty("br")
    private String br;
    @JsonProperty("pt")
    private String pt;
    @JsonProperty("nl")
    private String nl;
    @JsonProperty("hr")
    private String hr;
    @JsonProperty("fa")
    private String fa;
    @JsonProperty("de")
    private String de;
    @JsonProperty("es")
    private String es;
    @JsonProperty("fr")
    private String fr;
    @JsonProperty("ja")
    private String ja;
    @JsonProperty("it")
    private String it;
    @JsonProperty("hu")
    private String hu;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("br")
    public String getBr() {
        return br;
    }

    @JsonProperty("br")
    public void setBr(String br) {
        this.br = br;
    }

    public Translations withBr(String br) {
        this.br = br;
        return this;
    }

    @JsonProperty("pt")
    public String getPt() {
        return pt;
    }

    @JsonProperty("pt")
    public void setPt(String pt) {
        this.pt = pt;
    }

    public Translations withPt(String pt) {
        this.pt = pt;
        return this;
    }

    @JsonProperty("nl")
    public String getNl() {
        return nl;
    }

    @JsonProperty("nl")
    public void setNl(String nl) {
        this.nl = nl;
    }

    public Translations withNl(String nl) {
        this.nl = nl;
        return this;
    }

    @JsonProperty("hr")
    public String getHr() {
        return hr;
    }

    @JsonProperty("hr")
    public void setHr(String hr) {
        this.hr = hr;
    }

    public Translations withHr(String hr) {
        this.hr = hr;
        return this;
    }

    @JsonProperty("fa")
    public String getFa() {
        return fa;
    }

    @JsonProperty("fa")
    public void setFa(String fa) {
        this.fa = fa;
    }

    public Translations withFa(String fa) {
        this.fa = fa;
        return this;
    }

    @JsonProperty("de")
    public String getDe() {
        return de;
    }

    @JsonProperty("de")
    public void setDe(String de) {
        this.de = de;
    }

    public Translations withDe(String de) {
        this.de = de;
        return this;
    }

    @JsonProperty("es")
    public String getEs() {
        return es;
    }

    @JsonProperty("es")
    public void setEs(String es) {
        this.es = es;
    }

    public Translations withEs(String es) {
        this.es = es;
        return this;
    }

    @JsonProperty("fr")
    public String getFr() {
        return fr;
    }

    @JsonProperty("fr")
    public void setFr(String fr) {
        this.fr = fr;
    }

    public Translations withFr(String fr) {
        this.fr = fr;
        return this;
    }

    @JsonProperty("ja")
    public String getJa() {
        return ja;
    }

    @JsonProperty("ja")
    public void setJa(String ja) {
        this.ja = ja;
    }

    public Translations withJa(String ja) {
        this.ja = ja;
        return this;
    }

    @JsonProperty("it")
    public String getIt() {
        return it;
    }

    @JsonProperty("it")
    public void setIt(String it) {
        this.it = it;
    }

    public Translations withIt(String it) {
        this.it = it;
        return this;
    }

    @JsonProperty("hu")
    public String getHu() {
        return hu;
    }

    @JsonProperty("hu")
    public void setHu(String hu) {
        this.hu = hu;
    }

    public Translations withHu(String hu) {
        this.hu = hu;
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

    public Translations withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Translations.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("br");
        sb.append('=');
        sb.append(((this.br == null)?"<null>":this.br));
        sb.append(',');
        sb.append("pt");
        sb.append('=');
        sb.append(((this.pt == null)?"<null>":this.pt));
        sb.append(',');
        sb.append("nl");
        sb.append('=');
        sb.append(((this.nl == null)?"<null>":this.nl));
        sb.append(',');
        sb.append("hr");
        sb.append('=');
        sb.append(((this.hr == null)?"<null>":this.hr));
        sb.append(',');
        sb.append("fa");
        sb.append('=');
        sb.append(((this.fa == null)?"<null>":this.fa));
        sb.append(',');
        sb.append("de");
        sb.append('=');
        sb.append(((this.de == null)?"<null>":this.de));
        sb.append(',');
        sb.append("es");
        sb.append('=');
        sb.append(((this.es == null)?"<null>":this.es));
        sb.append(',');
        sb.append("fr");
        sb.append('=');
        sb.append(((this.fr == null)?"<null>":this.fr));
        sb.append(',');
        sb.append("ja");
        sb.append('=');
        sb.append(((this.ja == null)?"<null>":this.ja));
        sb.append(',');
        sb.append("it");
        sb.append('=');
        sb.append(((this.it == null)?"<null>":this.it));
        sb.append(',');
        sb.append("hu");
        sb.append('=');
        sb.append(((this.hu == null)?"<null>":this.hu));
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
        result = ((result* 31)+((this.de == null)? 0 :this.de.hashCode()));
        result = ((result* 31)+((this.pt == null)? 0 :this.pt.hashCode()));
        result = ((result* 31)+((this.hr == null)? 0 :this.hr.hashCode()));
        result = ((result* 31)+((this.it == null)? 0 :this.it.hashCode()));
        result = ((result* 31)+((this.fr == null)? 0 :this.fr.hashCode()));
        result = ((result* 31)+((this.hu == null)? 0 :this.hu.hashCode()));
        result = ((result* 31)+((this.es == null)? 0 :this.es.hashCode()));
        result = ((result* 31)+((this.br == null)? 0 :this.br.hashCode()));
        result = ((result* 31)+((this.ja == null)? 0 :this.ja.hashCode()));
        result = ((result* 31)+((this.fa == null)? 0 :this.fa.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.nl == null)? 0 :this.nl.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Translations) == false) {
            return false;
        }
        Translations rhs = ((Translations) other);
        return (((((((((((((this.de == rhs.de)||((this.de!= null)&&this.de.equals(rhs.de)))&&((this.pt == rhs.pt)||((this.pt!= null)&&this.pt.equals(rhs.pt))))&&((this.hr == rhs.hr)||((this.hr!= null)&&this.hr.equals(rhs.hr))))&&((this.it == rhs.it)||((this.it!= null)&&this.it.equals(rhs.it))))&&((this.fr == rhs.fr)||((this.fr!= null)&&this.fr.equals(rhs.fr))))&&((this.hu == rhs.hu)||((this.hu!= null)&&this.hu.equals(rhs.hu))))&&((this.es == rhs.es)||((this.es!= null)&&this.es.equals(rhs.es))))&&((this.br == rhs.br)||((this.br!= null)&&this.br.equals(rhs.br))))&&((this.ja == rhs.ja)||((this.ja!= null)&&this.ja.equals(rhs.ja))))&&((this.fa == rhs.fa)||((this.fa!= null)&&this.fa.equals(rhs.fa))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.nl == rhs.nl)||((this.nl!= null)&&this.nl.equals(rhs.nl))));
    }

}
