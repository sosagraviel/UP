package uy.com.urupago.automation.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "automation")
public class AutomationProperties {

    @Getter
    private final Drivers drivers = new Drivers();

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

        public static class Chrome extends Browser {

        }

        public static class Firefox extends Browser {

        }

        public static class Remote extends Browser {

        }
    }
}
