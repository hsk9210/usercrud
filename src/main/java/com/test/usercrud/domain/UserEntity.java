package com.test.usercrud.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

//@Entity(name = "user") //이거 왠지 중복같은디...?
@Entity
@Table(name = "user", schema = "douzone", catalog = "")
public class UserEntity {
    //@GeneratedValue
    private int id;

    private String name;
    private String email;
    private String password;
    private String tel;
    private String profile;
    private String jobTitle;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Collection<ProjectEntity> projectsById;
    private Collection<ProjectMemberEntity> projectMembersById;

    public UserEntity(){

    }

    public UserEntity(String name){
        this.name= name;
    }

    public UserEntity(String name, String email, String password, String tel, String profile, String jobTitle, Timestamp createdAt, Timestamp updatedAt, Collection<ProjectEntity> projectsById, Collection<ProjectMemberEntity> projectMembersById) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.profile = profile;
        this.jobTitle = jobTitle;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.projectsById = projectsById;
        this.projectMembersById = projectMembersById;
    }

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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "profile")
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Basic
    @Column(name = "job_title")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(tel, that.tel) && Objects.equals(profile, that.profile) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, tel, profile, jobTitle, createdAt, updatedAt);
    }

    @JsonIgnore //존나 중요하다 건드리는 순간 무한루프다 고정할 것.
    @OneToMany(mappedBy = "userByUserId")
    public Collection<ProjectEntity> getProjectsById() {
        return projectsById;
    }

    public void setProjectsById(Collection<ProjectEntity> projectsById) {
        this.projectsById = projectsById;
    }

    @JsonIgnore //존나 중요하다 건드리는 순간 무한루프다 고정할 것.
    @OneToMany(mappedBy = "userByUserId")
    public Collection<ProjectMemberEntity> getProjectMembersById() {
        return projectMembersById;
    }

    public void setProjectMembersById(Collection<ProjectMemberEntity> projectMembersById) {
        this.projectMembersById = projectMembersById;
    }
}
