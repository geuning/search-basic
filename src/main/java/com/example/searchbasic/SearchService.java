package com.example.searchbasic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SearchService {
    private final SearchKeywordRepository searchKeywordRepository;

    public SearchService(SearchKeywordRepository searchKeywordRepository) {
        this.searchKeywordRepository = searchKeywordRepository;
    }

    @Transactional
    public SearchKeywordDto save(String keyword) {
        Optional<SearchKeyword> optionalSearchKeyword = searchKeywordRepository.findByKeyword(keyword);

        if(optionalSearchKeyword.isEmpty()){
            SearchKeyword searchKeyword = SearchKeyword.create(keyword);
            return new SearchKeywordDto(searchKeywordRepository.save(searchKeyword));
        }

        SearchKeyword searchKeyword = optionalSearchKeyword.get();
        searchKeyword.increaseSearchCnt();
        return new SearchKeywordDto(searchKeyword);
    }
}
