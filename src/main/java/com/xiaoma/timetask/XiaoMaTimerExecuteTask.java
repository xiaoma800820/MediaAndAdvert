package com.xiaoma.timetask;

import com.xiaoma.service.core.TimerTaskCoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class XiaoMaTimerExecuteTask {



    @Autowired
    private TimerTaskCoreService timerTaskCoreService;

    /**
     * 广告主结算
     * 广告主结算每天凌晨0：30分
     */
    @Scheduled(cron = "0 30 0 * * ?")
    public void advertiserSettleExecute(){
        log.info("=== 定时任务广告主结算开始 ===");
        timerTaskCoreService.advertiserSettleTask();
        log.info("=== 定时任务广告主结算结束 ===");
    }

    /**
     * 媒体主结算
     * 媒体主结算每天凌晨1点
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void mediaOwnerSettleExecute(){
        log.info("=== 定时任务媒体主结算开始 ===");
        timerTaskCoreService.mediaOwnerSettleTask();
        log.info("=== 定时任务媒体主结算结束 ===");
    }

    /**
     * 广告主结算按天的计划
     * 每天零点2分钟触发
     */
    @Scheduled(cron = "0 2 0 * * ?")
    public void advertiserSettleExecuteCPT(){
        log.info("=== 定时任务广告主按天结算开始 ===");
        timerTaskCoreService.advertiserSettleExecuteCPT();
        log.info("=== 定时任务广告主按天结算结束 ===");
    }

    /**
     * 媒体主结算按天的计划
     * 每天零点10分触发
     */
    @Scheduled(cron = "0 10 0 * * ?")
    public void mediaOwnerSettleExecuteCPT(){
        log.info("=== 定时任务媒体主按天结算开始 ===");
        timerTaskCoreService.mediaOwnerSettleExecuteCPT();
        log.info("=== 定时任务媒体主按天结算结束 ===");
    }
}