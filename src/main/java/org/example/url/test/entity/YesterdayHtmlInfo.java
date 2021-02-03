package org.example.url.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class YesterdayHtmlInfo {
    @Id
    private String url;

    private String htmlCode;

    public YesterdayHtmlInfo() {
    }

    public YesterdayHtmlInfo(String url, String htmlCode) {
        this.url = url;
        this.htmlCode = htmlCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(String htmlCode) {
        this.htmlCode = htmlCode;
    }

    @Override
    public String toString() {
        return "'" + url + "'";
    }
}
