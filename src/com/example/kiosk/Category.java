package com.example.kiosk;

// Menu의 카테고리 Enum 클래스
public enum Category {
  BURGERS("Burgers"),
  DRINKS("Drinks"),
  DESSERTS("Desserts");

  private final String label;

  Category(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }
}
