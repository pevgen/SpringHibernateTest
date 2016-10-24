package ml.pevgen.test.springhibernate.domain;

import ml.pevgen.test.springhibernate.xmlmodel.StringToCustomLayoutConverter;
import ml.pevgen.test.springhibernate.xmlmodel.XmlCustomLayout;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Polyak on 18.10.2016.
 */
@Entity
@Table(name = "TDM.CUSTOM_LAYOUT")
public class CustomLayout {

    @Id
    @Column(name = "id_layout", updatable=false)
    String layoutId;

    @Column(name = "is_active", updatable=false)
    Integer isActive;

//    @ColumnTransformer(read = "(xml).getClobVal()")
    @Column(name = "xml", updatable=false)
    @Convert(converter = StringToCustomLayoutConverter.class)
    XmlCustomLayout xmlCustomLayout;

    @Column(name = "userid", updatable=false)
    Long userId;
    @Column(name = "description", updatable=false)
    String description;
    @Column(name = "create_date", updatable=false)
    LocalDateTime createDate;
    @Column(name = "groupname", updatable=false)
    String groupName;
    @Column(name = "type_id", updatable=false)
    Integer typeId;
    @Column(name = "id_stan", updatable=false)
    Long stanId;
    @Column(name = "enable_backup", updatable=false)
    Integer enableBackup;
    @Column(name = "daily_backup_hour", updatable=false)
    Integer dailyBackupHour;

    public String getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Long getStanId() {
        return stanId;
    }

    public void setStanId(Long stanId) {
        this.stanId = stanId;
    }

    public Integer getEnableBackup() {
        return enableBackup;
    }

    public void setEnableBackup(Integer enableBackup) {
        this.enableBackup = enableBackup;
    }

    public Integer getDailyBackupHour() {
        return dailyBackupHour;
    }

    public void setDailyBackupHour(Integer dailyBackupHour) {
        this.dailyBackupHour = dailyBackupHour;
    }

    public XmlCustomLayout getXmlCustomLayout() {
        return xmlCustomLayout;
    }

    public void setXmlCustomLayout(XmlCustomLayout xmlCustomLayout) {
        this.xmlCustomLayout = xmlCustomLayout;
    }
}
