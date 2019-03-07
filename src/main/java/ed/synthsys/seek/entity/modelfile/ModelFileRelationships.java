package ed.synthsys.seek.entity.modelfile;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import ed.synthsys.seek.entity.common.Assays;
import ed.synthsys.seek.entity.common.Creators;
import ed.synthsys.seek.entity.common.Projects;
import ed.synthsys.seek.entity.common.Publications;
import ed.synthsys.seek.entity.common.Relationships;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "creators",
    "projects",
    "assays",
    "publications"
})
public class ModelFileRelationships implements Serializable, Relationships {

    private static final long serialVersionUID = -3137950239067923565L;

    @JsonProperty("creators")
    private Creators creators;
    @JsonProperty("projects")
    private Projects projects;
    @JsonProperty("assays")
    private Assays assays;
    @JsonProperty("publications")
    private Publications publications;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("creators")
    public Creators getCreators() {
        return creators;
    }

    @JsonProperty("creators")
    public void setCreators(Creators creators) {
        this.creators = creators;
    }

    @JsonProperty("projects")
    public Projects getProjects() {
        return projects;
    }

    @JsonProperty("projects")
    public void setProjects(Projects projects) {
        this.projects = projects;
    }

    @JsonProperty("assays")
    public Assays getAssays() {
        return assays;
    }

    @JsonProperty("assays")
    public void setAssays(Assays assays) {
        this.assays = assays;
    }

    @JsonProperty("publications")
    public Publications getPublications() {
        return publications;
    }

    @JsonProperty("publications")
    public void setPublications(Publications publications) {
        this.publications = publications;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("creators", creators).append("projects", projects).append("assays", assays).append("publications", publications).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(creators).append(projects).append(publications).append(additionalProperties).append(assays).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ModelFileRelationships) == false) {
            return false;
        }
        ModelFileRelationships rhs = ((ModelFileRelationships) other);
        return new EqualsBuilder().append(creators, rhs.creators).append(projects, rhs.projects).append(publications, rhs.publications).append(additionalProperties, rhs.additionalProperties).append(assays, rhs.assays).isEquals();
    }

}
