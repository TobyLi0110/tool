package com.nan.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public @Data class TestLombok {
    @Getter private Integer id;
    @Getter private String str;
}
