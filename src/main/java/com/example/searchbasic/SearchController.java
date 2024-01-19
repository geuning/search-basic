package com.example.searchbasic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public ResponseEntity<SearchKeywordDto> search(@RequestBody SearchKeywordReqDto request) {
        String keyword = request.getKeyword();
        return ResponseEntity.ok(searchService.save(keyword));
    }

}
