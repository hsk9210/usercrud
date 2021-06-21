package com.test.usercrud.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "project_member", schema = "douzone", catalog = "")
public class ProjectMemberEntity {
    private int id;
    private String position;
    private String comment;
    private String status;
    private String portfolioUrl;
    private String portfolioFilename;
    private String pAuth;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer toDeprecated;
    private Timestamp appliedDateDeprecated;
    private ProjectEntity projectByProjectId;
    private UserEntity userByUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "portfolio_url")
    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    @Basic
    @Column(name = "portfolio_filename")
    public String getPortfolioFilename() {
        return portfolioFilename;
    }

    public void setPortfolioFilename(String portfolioFilename) {
        this.portfolioFilename = portfolioFilename;
    }

    @Basic
    @Column(name = "p_auth")
    public String getpAuth() {
        return pAuth;
    }

    public void setpAuth(String pAuth) {
        this.pAuth = pAuth;
    }

    @Basic
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "to_deprecated")
    public Integer getToDeprecated() {
        return toDeprecated;
    }

    public void setToDeprecated(Integer toDeprecated) {
        this.toDeprecated = toDeprecated;
    }

    @Basic
    @Column(name = "applied_date_deprecated")
    public Timestamp getAppliedDateDeprecated() {
        return appliedDateDeprecated;
    }

    public void setAppliedDateDeprecated(Timestamp appliedDateDeprecated) {
        this.appliedDateDeprecated = appliedDateDeprecated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectMemberEntity that = (ProjectMemberEntity) o;
        return id == that.id && Objects.equals(position, that.position) && Objects.equals(comment, that.comment) && Objects.equals(status, that.status) && Objects.equals(portfolioUrl, that.portfolioUrl) && Objects.equals(portfolioFilename, that.portfolioFilename) && Objects.equals(pAuth, that.pAuth) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(toDeprecated, that.toDeprecated) && Objects.equals(appliedDateDeprecated, that.appliedDateDeprecated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, comment, status, portfolioUrl, portfolioFilename, pAuth, createdAt, updatedAt, toDeprecated, appliedDateDeprecated);
    }

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = false)
    public ProjectEntity getProjectByProjectId() {
        return projectByProjectId;
    }

    public void setProjectByProjectId(ProjectEntity projectByProjectId) {
        this.projectByProjectId = projectByProjectId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
