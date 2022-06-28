package io.smallrye.reactive.messaging.ack;

import static io.smallrye.reactive.messaging.ack.BeanWithMessageProcessors.DEFAULT_ACKNOWLEDGMENT;
import static io.smallrye.reactive.messaging.ack.BeanWithMessageProcessors.DEFAULT_ACKNOWLEDGMENT_BUILDER;
import static io.smallrye.reactive.messaging.ack.BeanWithMessageProcessors.NO_ACKNOWLEDGMENT;
import static io.smallrye.reactive.messaging.ack.BeanWithMessageProcessors.NO_ACKNOWLEDGMENT_BUILDER;
import static io.smallrye.reactive.messaging.ack.BeanWithMessageProcessors.PRE_ACKNOWLEDGMENT;
import static io.smallrye.reactive.messaging.ack.BeanWithMessageProcessors.PRE_ACKNOWLEDGMENT_BUILDER;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PayloadProcessorAcknowledgementTest extends AcknowledgmentTestBase {

    private final Class<BeanWithPayloadProcessors> beanClass = BeanWithPayloadProcessors.class;

    @BeforeEach
    public void configure() {
        acks = Arrays.asList("a", "b", "c", "d", "e");
        expected = Arrays.asList("a", "a", "b", "b", "c", "c", "d", "d", "e", "e");
    }

    @Test
    public void testNoAcknowledgement() {
        SpiedBeanHelper bean = installInitializeAndGet(beanClass);
        assertNoAcknowledgment(bean, NO_ACKNOWLEDGMENT);
    }

    @Test
    public void testNoAcknowledgementBuilder() {
        SpiedBeanHelper bean = installInitializeAndGet(beanClass);
        assertNoAcknowledgment(bean, NO_ACKNOWLEDGMENT_BUILDER);
    }

    @Test
    public void testPreAck() {
        SpiedBeanHelper bean = installInitializeAndGet(beanClass);
        assertPreAcknowledgment(bean, PRE_ACKNOWLEDGMENT);
    }

    @Test
    public void testPreAckBuilder() {
        SpiedBeanHelper bean = installInitializeAndGet(beanClass);
        assertPreAcknowledgment(bean, PRE_ACKNOWLEDGMENT_BUILDER);
    }

    @Test
    public void testDefaultAck() {
        SpiedBeanHelper bean = installInitializeAndGet(beanClass);
        assertPreAcknowledgment(bean, DEFAULT_ACKNOWLEDGMENT);
    }

    @Test
    public void testDefaultAckBuilder() {
        SpiedBeanHelper bean = installInitializeAndGet(beanClass);
        assertPreAcknowledgment(bean, DEFAULT_ACKNOWLEDGMENT_BUILDER);
    }

}