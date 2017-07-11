package com.wit.hnxft.runtime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wit.hnxft.runtime.db.DatabaseChecker;

/**
 * 主控制器。
 *
 * @author yw
 *
 */
@RestController
public class HnxftMainController {

    @Autowired private DatabaseChecker databaseChecker;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/public/check-database")
    public void checkDatabase() {
        databaseChecker.checkDatabase();
    }

}
