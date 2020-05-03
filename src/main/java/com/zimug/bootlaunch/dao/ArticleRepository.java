package com.zimug.bootlaunch.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleDO,Long> {

    ArticleDO findByAuthor(String author);

    //查询article表的所有数据，传入Pageable分页参数，不需要自己写SQL
    Page<ArticleDO> findAll(Pageable pageable);
    //根据author字段查询article表数据，传入Pageable分页参数，不需要自己写SQL
    Page<ArticleDO> findByAuthor(String author, Pageable pageable);
    //根据author字段和title字段，查询article表数据，传入Pageable分页参数，不需要自己写SQL
    Slice<ArticleDO> findByAuthorAndTitle(String author, String title, Pageable pageable);
}
