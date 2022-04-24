
package com.jgvega.rest.jobsearch.model;

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
    "name",
    "topLevelDomain",
    "alpha2Code",
    "alpha3Code",
    "callingCodes",
    "capital",
    "altSpellings",
    "subregion",
    "region",
    "population",
    "latlng",
    "demonym",
    "area",
    "timezones",
    "borders",
    "nativeName",
    "numericCode",
    "flags",
    "currencies",
    "languages",
    "translations",
    "flag",
    "regionalBlocs",
    "cioc",
    "independent",
    "gini"
})
@Generated("jsonschema2pojo")
public class CountryResponse {

    @JsonProperty("name")
    private String name;
    @JsonProperty("topLevelDomain")
    private List<String> topLevelDomain = new ArrayList<String>();
    @JsonProperty("alpha2Code")
    private String alpha2Code;
    @JsonProperty("alpha3Code")
    private String alpha3Code;
    @JsonProperty("callingCodes")
    private List<String> callingCodes = new ArrayList<String>();
    @JsonProperty("capital")
    private String capital;
    @JsonProperty("altSpellings")
    private List<String> altSpellings = new ArrayList<String>();
    @JsonProperty("subregion")
    private String subregion;
    @JsonProperty("region")
    private String region;
    @JsonProperty("population")
    private Integer population;
    @JsonProperty("latlng")
    private List<Double> latlng = new ArrayList<Double>();
    @JsonProperty("demonym")
    private String demonym;
    @JsonProperty("area")
    private Double area;
    @JsonProperty("timezones")
    private List<String> timezones = new ArrayList<String>();
    @JsonProperty("borders")
    private List<String> borders = new ArrayList<String>();
    @JsonProperty("nativeName")
    private String nativeName;
    @JsonProperty("numericCode")
    private String numericCode;
    @JsonProperty("flags")
    private Flags flags;
    @JsonProperty("currencies")
    private List<Currency> currencies = new ArrayList<Currency>();
    @JsonProperty("languages")
    private List<Language> languages = new ArrayList<Language>();
    @JsonProperty("translations")
    private Translations translations;
    @JsonProperty("flag")
    private String flag;
    @JsonProperty("regionalBlocs")
    private List<RegionalBloc> regionalBlocs = new ArrayList<RegionalBloc>();
    @JsonProperty("cioc")
    private String cioc;
    @JsonProperty("independent")
    private Boolean independent;
    @JsonProperty("gini")
    private Double gini;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public CountryResponse withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("topLevelDomain")
    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    @JsonProperty("topLevelDomain")
    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public CountryResponse withTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
        return this;
    }

    @JsonProperty("alpha2Code")
    public String getAlpha2Code() {
        return alpha2Code;
    }

    @JsonProperty("alpha2Code")
    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public CountryResponse withAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
        return this;
    }

    @JsonProperty("alpha3Code")
    public String getAlpha3Code() {
        return alpha3Code;
    }

    @JsonProperty("alpha3Code")
    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public CountryResponse withAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
        return this;
    }

    @JsonProperty("callingCodes")
    public List<String> getCallingCodes() {
        return callingCodes;
    }

    @JsonProperty("callingCodes")
    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public CountryResponse withCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
        return this;
    }

    @JsonProperty("capital")
    public String getCapital() {
        return capital;
    }

    @JsonProperty("capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    public CountryResponse withCapital(String capital) {
        this.capital = capital;
        return this;
    }

    @JsonProperty("altSpellings")
    public List<String> getAltSpellings() {
        return altSpellings;
    }

    @JsonProperty("altSpellings")
    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public CountryResponse withAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
        return this;
    }

    @JsonProperty("subregion")
    public String getSubregion() {
        return subregion;
    }

    @JsonProperty("subregion")
    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public CountryResponse withSubregion(String subregion) {
        this.subregion = subregion;
        return this;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    public CountryResponse withRegion(String region) {
        this.region = region;
        return this;
    }

    @JsonProperty("population")
    public Integer getPopulation() {
        return population;
    }

    @JsonProperty("population")
    public void setPopulation(Integer population) {
        this.population = population;
    }

    public CountryResponse withPopulation(Integer population) {
        this.population = population;
        return this;
    }

    @JsonProperty("latlng")
    public List<Double> getLatlng() {
        return latlng;
    }

    @JsonProperty("latlng")
    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public CountryResponse withLatlng(List<Double> latlng) {
        this.latlng = latlng;
        return this;
    }

    @JsonProperty("demonym")
    public String getDemonym() {
        return demonym;
    }

    @JsonProperty("demonym")
    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public CountryResponse withDemonym(String demonym) {
        this.demonym = demonym;
        return this;
    }

    @JsonProperty("area")
    public Double getArea() {
        return area;
    }

    @JsonProperty("area")
    public void setArea(Double area) {
        this.area = area;
    }

    public CountryResponse withArea(Double area) {
        this.area = area;
        return this;
    }

    @JsonProperty("timezones")
    public List<String> getTimezones() {
        return timezones;
    }

    @JsonProperty("timezones")
    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public CountryResponse withTimezones(List<String> timezones) {
        this.timezones = timezones;
        return this;
    }

    @JsonProperty("borders")
    public List<String> getBorders() {
        return borders;
    }

    @JsonProperty("borders")
    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public CountryResponse withBorders(List<String> borders) {
        this.borders = borders;
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

    public CountryResponse withNativeName(String nativeName) {
        this.nativeName = nativeName;
        return this;
    }

    @JsonProperty("numericCode")
    public String getNumericCode() {
        return numericCode;
    }

    @JsonProperty("numericCode")
    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public CountryResponse withNumericCode(String numericCode) {
        this.numericCode = numericCode;
        return this;
    }

    @JsonProperty("flags")
    public Flags getFlags() {
        return flags;
    }

    @JsonProperty("flags")
    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public CountryResponse withFlags(Flags flags) {
        this.flags = flags;
        return this;
    }

    @JsonProperty("currencies")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    @JsonProperty("currencies")
    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public CountryResponse withCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

    @JsonProperty("languages")
    public List<Language> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public CountryResponse withLanguages(List<Language> languages) {
        this.languages = languages;
        return this;
    }

    @JsonProperty("translations")
    public Translations getTranslations() {
        return translations;
    }

    @JsonProperty("translations")
    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public CountryResponse withTranslations(Translations translations) {
        this.translations = translations;
        return this;
    }

    @JsonProperty("flag")
    public String getFlag() {
        return flag;
    }

    @JsonProperty("flag")
    public void setFlag(String flag) {
        this.flag = flag;
    }

    public CountryResponse withFlag(String flag) {
        this.flag = flag;
        return this;
    }

    @JsonProperty("regionalBlocs")
    public List<RegionalBloc> getRegionalBlocs() {
        return regionalBlocs;
    }

    @JsonProperty("regionalBlocs")
    public void setRegionalBlocs(List<RegionalBloc> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public CountryResponse withRegionalBlocs(List<RegionalBloc> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
        return this;
    }

    @JsonProperty("cioc")
    public String getCioc() {
        return cioc;
    }

    @JsonProperty("cioc")
    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public CountryResponse withCioc(String cioc) {
        this.cioc = cioc;
        return this;
    }

    @JsonProperty("independent")
    public Boolean getIndependent() {
        return independent;
    }

    @JsonProperty("independent")
    public void setIndependent(Boolean independent) {
        this.independent = independent;
    }

    public CountryResponse withIndependent(Boolean independent) {
        this.independent = independent;
        return this;
    }

    @JsonProperty("gini")
    public Double getGini() {
        return gini;
    }

    @JsonProperty("gini")
    public void setGini(Double gini) {
        this.gini = gini;
    }

    public CountryResponse withGini(Double gini) {
        this.gini = gini;
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

    public CountryResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CountryResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("topLevelDomain");
        sb.append('=');
        sb.append(((this.topLevelDomain == null)?"<null>":this.topLevelDomain));
        sb.append(',');
        sb.append("alpha2Code");
        sb.append('=');
        sb.append(((this.alpha2Code == null)?"<null>":this.alpha2Code));
        sb.append(',');
        sb.append("alpha3Code");
        sb.append('=');
        sb.append(((this.alpha3Code == null)?"<null>":this.alpha3Code));
        sb.append(',');
        sb.append("callingCodes");
        sb.append('=');
        sb.append(((this.callingCodes == null)?"<null>":this.callingCodes));
        sb.append(',');
        sb.append("capital");
        sb.append('=');
        sb.append(((this.capital == null)?"<null>":this.capital));
        sb.append(',');
        sb.append("altSpellings");
        sb.append('=');
        sb.append(((this.altSpellings == null)?"<null>":this.altSpellings));
        sb.append(',');
        sb.append("subregion");
        sb.append('=');
        sb.append(((this.subregion == null)?"<null>":this.subregion));
        sb.append(',');
        sb.append("region");
        sb.append('=');
        sb.append(((this.region == null)?"<null>":this.region));
        sb.append(',');
        sb.append("population");
        sb.append('=');
        sb.append(((this.population == null)?"<null>":this.population));
        sb.append(',');
        sb.append("latlng");
        sb.append('=');
        sb.append(((this.latlng == null)?"<null>":this.latlng));
        sb.append(',');
        sb.append("demonym");
        sb.append('=');
        sb.append(((this.demonym == null)?"<null>":this.demonym));
        sb.append(',');
        sb.append("area");
        sb.append('=');
        sb.append(((this.area == null)?"<null>":this.area));
        sb.append(',');
        sb.append("timezones");
        sb.append('=');
        sb.append(((this.timezones == null)?"<null>":this.timezones));
        sb.append(',');
        sb.append("borders");
        sb.append('=');
        sb.append(((this.borders == null)?"<null>":this.borders));
        sb.append(',');
        sb.append("nativeName");
        sb.append('=');
        sb.append(((this.nativeName == null)?"<null>":this.nativeName));
        sb.append(',');
        sb.append("numericCode");
        sb.append('=');
        sb.append(((this.numericCode == null)?"<null>":this.numericCode));
        sb.append(',');
        sb.append("flags");
        sb.append('=');
        sb.append(((this.flags == null)?"<null>":this.flags));
        sb.append(',');
        sb.append("currencies");
        sb.append('=');
        sb.append(((this.currencies == null)?"<null>":this.currencies));
        sb.append(',');
        sb.append("languages");
        sb.append('=');
        sb.append(((this.languages == null)?"<null>":this.languages));
        sb.append(',');
        sb.append("translations");
        sb.append('=');
        sb.append(((this.translations == null)?"<null>":this.translations));
        sb.append(',');
        sb.append("flag");
        sb.append('=');
        sb.append(((this.flag == null)?"<null>":this.flag));
        sb.append(',');
        sb.append("regionalBlocs");
        sb.append('=');
        sb.append(((this.regionalBlocs == null)?"<null>":this.regionalBlocs));
        sb.append(',');
        sb.append("cioc");
        sb.append('=');
        sb.append(((this.cioc == null)?"<null>":this.cioc));
        sb.append(',');
        sb.append("independent");
        sb.append('=');
        sb.append(((this.independent == null)?"<null>":this.independent));
        sb.append(',');
        sb.append("gini");
        sb.append('=');
        sb.append(((this.gini == null)?"<null>":this.gini));
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
        result = ((result* 31)+((this.nativeName == null)? 0 :this.nativeName.hashCode()));
        result = ((result* 31)+((this.capital == null)? 0 :this.capital.hashCode()));
        result = ((result* 31)+((this.demonym == null)? 0 :this.demonym.hashCode()));
        result = ((result* 31)+((this.flag == null)? 0 :this.flag.hashCode()));
        result = ((result* 31)+((this.alpha2Code == null)? 0 :this.alpha2Code.hashCode()));
        result = ((result* 31)+((this.independent == null)? 0 :this.independent.hashCode()));
        result = ((result* 31)+((this.borders == null)? 0 :this.borders.hashCode()));
        result = ((result* 31)+((this.flags == null)? 0 :this.flags.hashCode()));
        result = ((result* 31)+((this.numericCode == null)? 0 :this.numericCode.hashCode()));
        result = ((result* 31)+((this.alpha3Code == null)? 0 :this.alpha3Code.hashCode()));
        result = ((result* 31)+((this.topLevelDomain == null)? 0 :this.topLevelDomain.hashCode()));
        result = ((result* 31)+((this.cioc == null)? 0 :this.cioc.hashCode()));
        result = ((result* 31)+((this.translations == null)? 0 :this.translations.hashCode()));
        result = ((result* 31)+((this.altSpellings == null)? 0 :this.altSpellings.hashCode()));
        result = ((result* 31)+((this.area == null)? 0 :this.area.hashCode()));
        result = ((result* 31)+((this.languages == null)? 0 :this.languages.hashCode()));
        result = ((result* 31)+((this.subregion == null)? 0 :this.subregion.hashCode()));
        result = ((result* 31)+((this.callingCodes == null)? 0 :this.callingCodes.hashCode()));
        result = ((result* 31)+((this.regionalBlocs == null)? 0 :this.regionalBlocs.hashCode()));
        result = ((result* 31)+((this.gini == null)? 0 :this.gini.hashCode()));
        result = ((result* 31)+((this.population == null)? 0 :this.population.hashCode()));
        result = ((result* 31)+((this.timezones == null)? 0 :this.timezones.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.region == null)? 0 :this.region.hashCode()));
        result = ((result* 31)+((this.latlng == null)? 0 :this.latlng.hashCode()));
        result = ((result* 31)+((this.currencies == null)? 0 :this.currencies.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CountryResponse) == false) {
            return false;
        }
        CountryResponse rhs = ((CountryResponse) other);
        return ((((((((((((((((((((((((((((this.nativeName == rhs.nativeName)||((this.nativeName!= null)&&this.nativeName.equals(rhs.nativeName)))&&((this.capital == rhs.capital)||((this.capital!= null)&&this.capital.equals(rhs.capital))))&&((this.demonym == rhs.demonym)||((this.demonym!= null)&&this.demonym.equals(rhs.demonym))))&&((this.flag == rhs.flag)||((this.flag!= null)&&this.flag.equals(rhs.flag))))&&((this.alpha2Code == rhs.alpha2Code)||((this.alpha2Code!= null)&&this.alpha2Code.equals(rhs.alpha2Code))))&&((this.independent == rhs.independent)||((this.independent!= null)&&this.independent.equals(rhs.independent))))&&((this.borders == rhs.borders)||((this.borders!= null)&&this.borders.equals(rhs.borders))))&&((this.flags == rhs.flags)||((this.flags!= null)&&this.flags.equals(rhs.flags))))&&((this.numericCode == rhs.numericCode)||((this.numericCode!= null)&&this.numericCode.equals(rhs.numericCode))))&&((this.alpha3Code == rhs.alpha3Code)||((this.alpha3Code!= null)&&this.alpha3Code.equals(rhs.alpha3Code))))&&((this.topLevelDomain == rhs.topLevelDomain)||((this.topLevelDomain!= null)&&this.topLevelDomain.equals(rhs.topLevelDomain))))&&((this.cioc == rhs.cioc)||((this.cioc!= null)&&this.cioc.equals(rhs.cioc))))&&((this.translations == rhs.translations)||((this.translations!= null)&&this.translations.equals(rhs.translations))))&&((this.altSpellings == rhs.altSpellings)||((this.altSpellings!= null)&&this.altSpellings.equals(rhs.altSpellings))))&&((this.area == rhs.area)||((this.area!= null)&&this.area.equals(rhs.area))))&&((this.languages == rhs.languages)||((this.languages!= null)&&this.languages.equals(rhs.languages))))&&((this.subregion == rhs.subregion)||((this.subregion!= null)&&this.subregion.equals(rhs.subregion))))&&((this.callingCodes == rhs.callingCodes)||((this.callingCodes!= null)&&this.callingCodes.equals(rhs.callingCodes))))&&((this.regionalBlocs == rhs.regionalBlocs)||((this.regionalBlocs!= null)&&this.regionalBlocs.equals(rhs.regionalBlocs))))&&((this.gini == rhs.gini)||((this.gini!= null)&&this.gini.equals(rhs.gini))))&&((this.population == rhs.population)||((this.population!= null)&&this.population.equals(rhs.population))))&&((this.timezones == rhs.timezones)||((this.timezones!= null)&&this.timezones.equals(rhs.timezones))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.region == rhs.region)||((this.region!= null)&&this.region.equals(rhs.region))))&&((this.latlng == rhs.latlng)||((this.latlng!= null)&&this.latlng.equals(rhs.latlng))))&&((this.currencies == rhs.currencies)||((this.currencies!= null)&&this.currencies.equals(rhs.currencies))));
    }

}
