package com.szp.demo.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PetCategoryCount  {
    private long all;
    private long cat;
    private long dog;
}
