package com.ReapWebFinal.ReapWebFinal.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WallOfFame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String giverName;
    String receiverName;
    Integer giverId;
    Integer receiverId;
    String reason;
    String karma;
    String badgeType;
    Date givenDateAndTime;

    public String getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

   /* public WallOfFame(String giverName, String receiverName, Integer giverId, Integer receiverId, String reason, String karma, String badgeType, Date givenDateAndTime) {
        this.giverName = giverName;
        this.receiverName = receiverName;
        this.giverId = giverId;
        this.receiverId = receiverId;
        this.reason = reason;
        this.karma = karma;
        this.badgeType = badgeType;
        this.givenDateAndTime = givenDateAndTime;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGiverName() {
        return giverName;
    }

    public void setGiverName(String giverName) {
        this.giverName = giverName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getGiverId() {
        return giverId;
    }

    public void setGiverId(Integer giverId) {
        this.giverId = giverId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getKarma() {
        return karma;
    }

    public void setKarma(String karma) {
        this.karma = karma;
    }



    public Date getGivenDateAndTime() {
        return givenDateAndTime;
    }

    public void setGivenDateAndTime(Date givenDateAndTime) {
        this.givenDateAndTime = givenDateAndTime;
    }

    public WallOfFame() {
    }

}

