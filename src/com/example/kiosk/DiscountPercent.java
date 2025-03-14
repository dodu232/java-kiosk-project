package com.example.kiosk;

public enum DiscountPercent {
  SOLDIER("군인", 5),
  STUDENT("학생", 3),
  GENERAL("일반", 0);
  private final String type;
  private final int discountRate;

  DiscountPercent(String type, int discountRate) {
    this.type = type;
    this.discountRate = discountRate;
  }

  public int getDiscountRate() {
    return this.discountRate;
  }

  @Override
  public String toString() {
    return String.format(".  %-5s :   %d%%", type, discountRate);
  }
}
