package com.devsuperior.movieflix.dto;

public class MovieMinDTO {

  private String title;
  private String subTitle;
  private Integer year;
  private String imgUrl;

  public MovieMinDTO() {
  }

  public MovieMinDTO(String title, String subTitle, Integer year, String imgUrl) {
    this.title = title;
    this.subTitle = subTitle;
    this.year = year;
    this.imgUrl = imgUrl;
  }

  public MovieMinDTO(MovieDTO movieDTO) {
    this.title = title;
    this.subTitle = subTitle;
    this.year = year;
    this.imgUrl = imgUrl;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
}
