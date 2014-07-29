package akihyro.cloudprintconsole;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.commons.lang3.ObjectUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * アプリケーション。
 */
@ApplicationPath("/")
@Slf4j
public class CloudPrintConsoleApplication extends Application {

    /**
     * コンストラクタ。
     */
    public CloudPrintConsoleApplication() {
    }

    /**
     * 初期化する。
     */
    @PostConstruct
    public void init() {
        log.trace("@PostConstruct: {}", ObjectUtils.identityToString(this));
    }

    /**
     * 解放する。
     */
    @PreDestroy
    public void release() {
        log.trace("@PreDestroy: {}", ObjectUtils.identityToString(this));
    }

}
