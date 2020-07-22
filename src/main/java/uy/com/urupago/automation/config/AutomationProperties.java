package uy.com.urupago.automation.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "automation")
public class AutomationProperties {

    @Getter
    private final Drivers drivers= new Drivers();
    @Getter
    private String url;

    @Data
    public static class Drivers {

        @Getter
        private final Chrome chrome = new Chrome();

        @Getter
        private final Firefox firefox = new Firefox();

        @Getter
        private final Remote remote = new Remote();

        @Data
        public static class Browser {
            private String driverPath;
        }
        @Data
        public static class Chrome extends Browser {
            private String driverPath;
        }
        @Data
        public static class Firefox extends Browser {
            private String driverPath;
        }
        @Data
        public static class Remote extends Browser {

        }
    }
}
