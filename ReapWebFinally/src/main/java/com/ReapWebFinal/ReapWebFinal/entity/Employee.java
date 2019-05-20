package com.ReapWebFinal.ReapWebFinal.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @NotNull

    String firstname;
    @NotNull

    String lastname;
    @NotNull

    String email;
    @NotNull

    String password;
    String imagepath;
    Boolean active=true;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Roles> roleSet = new HashSet<>(Arrays.asList(Roles.USER));

    @Transient
    MultipartFile multipartFile;
    Integer shareableGoldBadgeCount=1;
    Integer shareableSilverBadgeCount=2;
    Integer shareableBronzeBadgeCount=3;
    Integer receivedGoldCount=0;
    Integer receivedSilverBadgeCount=0;
    Integer receivedBronzeBadgeCount=0;
    Integer totalGoldPoint=0;
    Integer totalSilverPoint=0;
    Integer totalBronzePoint=0;
    Integer totalPoints=totalGoldPoint*30+totalSilverPoint*20+totalBronzePoint*10;
    Integer pointUsed=0;
    Integer pointsLeftztoUse=0;

    public Set<Roles> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Roles> roleSet) {
        this.roleSet = roleSet;
    }

    public Integer getPointUsed() {
        return pointUsed;
    }

    public void setPointUsed(Integer pointUsed) {
        this.pointUsed = pointUsed;
    }

    public Integer getPointsLeftztoUse() {
        return pointsLeftztoUse;
    }

    public void setPointsLeftztoUse(Integer pointsLeftztoUse) {
        this.pointsLeftztoUse = pointsLeftztoUse;
    }

    public Employee() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Integer getShareableGoldBadgeCount() {
        return shareableGoldBadgeCount;
    }

    public void setShareableGoldBadgeCount(Integer shareableGoldBadgeCount) {
        shareableGoldBadgeCount = shareableGoldBadgeCount;
    }

    public Integer getShareableSilverBadgeCount() {
        return shareableSilverBadgeCount;
    }

    public void setShareableSilverBadgeCount(Integer shareableSilverBadgeCount) {
        shareableSilverBadgeCount = shareableSilverBadgeCount;
    }

    public Integer getShareableBronzeBadgeCount() {
        return shareableBronzeBadgeCount;
    }

    public void setShareableBronzeBadgeCount(Integer shareableBronzeBadgeCount) {
        shareableBronzeBadgeCount = shareableBronzeBadgeCount;
    }

    public Integer getReceivedGoldCount() {
        return receivedGoldCount;
    }

    public void setReceivedGoldCount(Integer receivedGoldCount) {
        receivedGoldCount = receivedGoldCount;
    }

    public Integer getReceivedSilverBadgeCount() {
        return receivedSilverBadgeCount;
    }

    public void setReceivedSilverBadgeCount(Integer receivedSilverBadgeCount) {
        receivedSilverBadgeCount = receivedSilverBadgeCount;
    }

    public Integer getReceivedBronzeBadgeCount() {
        return receivedBronzeBadgeCount;
    }

    public void setReceivedBronzeBadgeCount(Integer receivedBronzeBadgeCount) {
        receivedBronzeBadgeCount = receivedBronzeBadgeCount;
    }

    public Integer getTotalGoldPoint() {
        return totalGoldPoint;
    }

    public void setTotalGoldPoint(Integer totalGoldPoint) {
        totalGoldPoint = totalGoldPoint;
    }

    public Integer getTotalSilverPoint() {
        return totalSilverPoint;
    }

    public void setTotalSilverPoint(Integer totalSilverPoint) {
        totalSilverPoint = totalSilverPoint;
    }

    public Integer getTotalBronzePoint() {
        return totalBronzePoint;
    }

    public void setTotalBronzePoint(Integer totalBronzePoint) {
        totalBronzePoint = totalBronzePoint;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        totalPoints = totalPoints;
    }


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        active = active;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imagepath='" + imagepath + '\'' +
                ", active=" + active +

                ", multipartFile=" + multipartFile +
                ", shareableGoldBadgeCount=" + shareableGoldBadgeCount +
                ", shareableSilverBadgeCount=" + shareableSilverBadgeCount +
                ", shareableBronzeBadgeCount=" + shareableBronzeBadgeCount +
                ", receivedGoldCount=" + receivedGoldCount +
                ", receivedSilverBadgeCount=" + receivedSilverBadgeCount +
                ", receivedBronzeBadgeCount=" + receivedBronzeBadgeCount +
                ", totalGoldPoint=" + totalGoldPoint +
                ", totalSilverPoint=" + totalSilverPoint +
                ", totalBronzePoint=" + totalBronzePoint +
                ", totalPoints=" + totalPoints +
                ", pointUsed=" + pointUsed +
                ", pointsLeftztoUse=" + pointsLeftztoUse +
                '}';
    }
}

