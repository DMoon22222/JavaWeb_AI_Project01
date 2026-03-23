package com.scut;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LogTest {

    @Test
    public void testLog(){

        log.debug("开始计算……");

        int sum = 0;
        int[] nums = {1, 5, 3, 2, 1, 4, 5, 4, 6, 7, 4, 34, 2, 23};
        for (int num : nums) {
            sum += num;
        }
        log.info("计算结果为：{}", sum);
        log.debug("计算结束……");

        log.trace("trace……");
        log.warn("warn……");
        log.error("error……");


    }

}

