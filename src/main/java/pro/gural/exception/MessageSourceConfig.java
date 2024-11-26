package pro.gural.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * @author Vladyslav Gural
 * @version 2024-08-01
 */
@Configuration
public class MessageSourceConfig {

    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
        res.setDefaultEncoding("UTF-8");
        res.setFallbackToSystemLocale(false);
        res.addBasenames("classpath:messages/exception-ext", "classpath:messages/validation-ext",
                "classpath:messages/messages-ext", "classpath:messages/titles-ext",
                "classpath:messages/exception", "classpath:messages/validation",
                "classpath:messages/messages", "classpath:messages/titles");
        return res;
    }

    @Bean
    public MessageSourceAccessor getMessageSourceAccessor(final MessageSource messageSource) {
        return new MessageSourceAccessor(messageSource, Locale.US);
    }
}
