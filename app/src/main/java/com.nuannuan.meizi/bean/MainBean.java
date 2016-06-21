package com.nuannuan.meizi.bean;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.Sort;
import io.realm.annotations.PrimaryKey;
import java.io.Serializable;
import java.util.List;

/**
 * @author kevin.
 */
public class MainBean extends RealmObject implements Serializable {

  @PrimaryKey private String imageurl;
  private int count;
  private int width;
  private int height;
  private String url;
  private String title;
  private String type;
  private int groupid;
  private int order;

  public static List<MainBean> all(Realm realm,String type) {
    return realm.where(MainBean.class)
        .equalTo("type",type)
        .findAllSorted("groupid",Sort.DESCENDING);
  }

  public int getGroupid() {
    return groupid;
  }

  public void setGroupid(int groupid) {
    this.groupid = groupid;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getImageurl() {
    return imageurl;
  }

  public void setImageurl(String imageurl) {
    this.imageurl = imageurl;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}