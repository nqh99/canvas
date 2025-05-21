package com.canvas.util;

import java.util.List;

public final class Util {
  private Util() {}

  public static String trimStr(String str) {
    return str != null ? str.trim() : "";
  }

  public static boolean isEmptyStr(String str) {
    return trimStr(str).isEmpty();
  }

  public static boolean isPositiveList(List<String> list) {
    if (list == null || list.isEmpty()) {
      return false;
    }
    return list.stream().map(Integer::parseInt).allMatch(element -> element > 0);
  }
}
