package com.nan.fastjson;

import java.util.List;
import java.util.Map;

public class A {
  private Map<String, String> map;
  private List<Map<String, String>> childCity;

  public Map<String, String> getMap() {
    return map;
  }

  public void setMap(Map<String, String> map) {
    this.map = map;
  }

  public List<Map<String, String>> getChildCity() {
    return childCity;
  }

  public void setChildCity(List<Map<String, String>> childCity) {
    this.childCity = childCity;
  }
}
