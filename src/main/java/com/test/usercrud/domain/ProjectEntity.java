package com.test.usercrud.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "project", schema = "douzone", catalog = "")
public class ProjectEntity {
    private int id;
    private String name;
    private String thumbnail;
    private String viewCount;
    private String description;
    private String contents;
    private Integer authority;
    private Integer totalTo;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserEntity userByUserId;
    private Collection<ProjectMemberEntity> projectMembersById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Basic
    @Column(name = "view_count")
    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "contents")
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Basic
    @Column(name = "authority")
    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    @Basic
    @Column(name = "total_to")
    public Integer getTotalTo() {
        return totalTo;
    }

    public void setTotalTo(Integer totalTo) {
        this.totalTo = totalTo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity that = (ProjectEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(thumbnail, that.thumbnail) && Objects.equals(viewCount, that.viewCount) && Objects.equals(description, that.description) && Objects.equals(contents, that.contents) && Objects.equals(authority, that.authority) && Objects.equals(totalTo, that.totalTo) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, thumbnail, viewCount, description, contents, authority, totalTo, createdAt, updatedAt);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "projectByProjectId")
    public Collection<ProjectMemberEntity> getProjectMembersById() {
        return projectMembersById;
    }

    public void setProjectMembersById(Collection<ProjectMemberEntity> projectMembersById) {
        this.projectMembersById = projectMembersById;
    }
}
