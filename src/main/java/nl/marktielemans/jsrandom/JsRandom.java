package nl.marktielemans.jsrandom;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.alfresco.repo.processor.BaseProcessorExtension;
import org.apache.commons.lang3.RandomStringUtils;

public class JsRandom extends BaseProcessorExtension {

    public Date randomDate() {
        return randomDate(new Date());
    }

    public Date randomDate(final Date beforeDate) {
        return new Date(ThreadLocalRandom.current().nextLong(beforeDate.getTime()));
    }

    public int randomNumber() {
        return randomNumber(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public int randomNumber(final int max) {
        return randomNumber(Integer.MIN_VALUE, max);
    }
    
    public int randomPositive(final int max) {
        return randomNumber(0, max);
    }

    public int randomNumber(final int min, final int max) {
        if (max < 0) {
            return ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
        }

        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public String randomString(final int length) {
        return RandomStringUtils.random(length, true, true);
    }

    public String randomString(final int length, final boolean letters, final boolean numbers) {
        return RandomStringUtils.random(length, letters, numbers);
    }
}
