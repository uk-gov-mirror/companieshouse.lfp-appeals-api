package uk.gov.companieshouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "appeals")
public class Appeal {

    @JsonIgnore
    @Id
    private String id;

    @JsonIgnore
    private LocalDateTime createdAt;

    @JsonIgnore
    private CreatedBy createdBy;

    @Valid
    @NotNull(message = "penaltyIdentifier must not be null")
    private PenaltyIdentifier penaltyIdentifier;

    @Valid
    @NotNull(message = "reasons must not be null")
    @JsonProperty("reasons")
    private Reason reason;

    public String getId() {
        return this.id;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public CreatedBy getCreatedBy() {
        return this.createdBy;
    }

    public PenaltyIdentifier getPenaltyIdentifier() {
        return this.penaltyIdentifier;
    }

    public Reason getReason() {
        return this.reason;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public void setPenaltyIdentifier(PenaltyIdentifier penaltyIdentifier) {
        this.penaltyIdentifier = penaltyIdentifier;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appeal appeal = (Appeal) o;
        return Objects.equals(id, appeal.id) &&
            Objects.equals(createdAt, appeal.createdAt) &&
            Objects.equals(createdBy, appeal.createdBy) &&
            Objects.equals(penaltyIdentifier, appeal.penaltyIdentifier) &&
            Objects.equals(reason, appeal.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, createdBy, penaltyIdentifier, reason);
    }

    @Override
    public String toString() {
        return "Appeal{" +
            "id='" + id + '\'' +
            ", createdAt=" + createdAt +
            ", createdBy=" + createdBy +
            ", penaltyIdentifier=" + penaltyIdentifier +
            ", reason=" + reason +
            '}';
    }
}