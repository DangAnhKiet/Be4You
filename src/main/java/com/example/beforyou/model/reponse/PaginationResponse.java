package com.example.beforyou.model.reponse;

import lombok.Data;

@Data
public class PaginationResponse {
    private long total;
    private long page;
    private long size;
}
