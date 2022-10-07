package test.app;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ceair.util.StringUtil;

/**
 * 每秒执行一次
 * 
 * @author Wuhp
 * @date 2020/06/02
 */
@Component
public class TestSchedule {
    @Scheduled(cron = "0/1 * * * * ? ")
    public void testPrint() {
        int stringConvert = StringUtil.stringConvert("1");
        System.out.println("定时任务被触发了，时间：" + LocalDateTime.now().toString() + "::::::" + stringConvert);
    }
}
