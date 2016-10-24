package ml.pevgen.test.springhibernate.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 15.09.2016.
 */
@Entity
@Table(name = "NSI.SPLMT")
public class Splmt {

    @Id
    @Column(name = "id_supplement", updatable=false)
    long idSupplement;

    @Column(name = "title", updatable=false)
    String title;
    @Column(name = "uri", updatable=false)
    String uri;
    @Column(name = "href", updatable=false)
    String href;
    @Column(name = "id_categ", updatable=false)
    Long idCateg;
    @Column(name = "group_name", updatable=false)
    String groupName;

//    @ManyToMany(fetch=FetchType.EAGER)  // FetchType.EAGER because the class is used in web-json-request (ServiceSontroller)
//    @JoinTable(
//            name="NSI.SPLMT_SET_IDS",
//            joinColumns=@JoinColumn(name="id_supplement", referencedColumnName="id_supplement"),
//            inverseJoinColumns=@JoinColumn(name="id_supplement_set", referencedColumnName="id_supplement_set"))
//    private List<SplmtSet> splmtSetList;

    public long getIdSupplement() {
        return idSupplement;
    }

    public void setIdSupplement(long idSupplement) {
        this.idSupplement = idSupplement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Long getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(Long idCateg) {
        this.idCateg = idCateg;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

//    public List<SplmtSet> getSplmtSetList() {
//        return splmtSetList;
//    }
//
//    public void setSplmtSetList(List<SplmtSet> splmtSetList) {
//        this.splmtSetList = splmtSetList;
//    }
}
