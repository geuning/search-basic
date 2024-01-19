package com.example.searchbasic;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "`search_keyword`", indexes = {@Index(name = "keyword", columnList = "keyword")})
public class SearchKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keywordId;

    private String keyword;

    private Long searchCnt;

    @Version
    private long version;

    @Builder
    public SearchKeyword(Long keywordId, String keyword, Long searchCnt) {
        this.keywordId = keywordId;
        this.keyword = keyword;
        this.searchCnt = searchCnt;
    }
    public static SearchKeyword create(String keyword) {
        return SearchKeyword.builder()
                .keyword(keyword)
                .searchCnt(1L)
                .build();
    }


    public void increaseSearchCnt() {
        searchCnt += 1;
    }
}
