package com.ReapWebFinal.ReapWebFinal.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.persistence.Transient;
import java.util.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String firstname;
    String lastname;
    String email;
    String password;
    String imagepath;
    Boolean active=true;
    @ElementCollection
    Set<String> roles= new HashSet<>(Arrays.asList("User"));
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

   /* public Employee(String firstname, String lastname, String email, String password, String imagepath, Boolean active,List<String> product, MultipartFile multipartFile, Integer shareableGoldBadgeCount, Integer shareableSilverBadgeCount, Integer shareableBronzeBadgeCount, Integer receivedGoldCount, Integer receivedSilverBadgeCount, Integer receivedBronzeBadgeCount, Integer totalGoldPoint, Integer totalSilverPoint, Integer totalBronzePoint, Integer totalPoints, Integer pointUsed, Integer pointsLeftztoUse,Set<String> roles, List<String> cart) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.imagepath = imagepath;
        this.active = active;
        Product = product;
        this.multipartFile = multipartFile;
        this.shareableGoldBadgeCount = shareableGoldBadgeCount;
        this.shareableSilverBadgeCount = shareableSilverBadgeCount;
        this.shareableBronzeBadgeCount = shareableBronzeBadgeCount;
        this.receivedGoldCount = receivedGoldCount;
        this.receivedSilverBadgeCount = receivedSilverBadgeCount;
        this.receivedBronzeBadgeCount = receivedBronzeBadgeCount;
        this.totalGoldPoint = totalGoldPoint;
        this.totalSilverPoint = totalSilverPoint;
        this.totalBronzePoint = totalBronzePoint;
        this.totalPoints = totalPoints;
        this.pointUsed = pointUsed;
        this.pointsLeftztoUse = pointsLeftztoUse;
        this.roles = roles;
        this.cart=cart;
    }*/

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }



}

