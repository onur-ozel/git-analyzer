package com.onur.scout24.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ModelTest
 */
public class ModelTest {
  byte red;

  @JsonProperty("r")
  public byte getR() {
    return red;
  }

  @JsonProperty("red")
  public void setRed(byte red) {
    this.red = red;
  }

}