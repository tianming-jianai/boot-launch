package com.zimug.bootlaunch.dao.testdb2;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author You
 * @version 0.1.0
 * @Description
 * @create 2020-05-03 21:22
 * @since 0.1.0
 **/
public interface MessageRepository extends JpaRepository<Message,Long> {

}
