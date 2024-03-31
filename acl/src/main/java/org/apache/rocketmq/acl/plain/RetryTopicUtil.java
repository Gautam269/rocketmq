package org.apache.rocketmq.acl.plain;

import org.apache.rocketmq.acl.plain.PlainAccessResource;
import org.apache.rocketmq.common.KeyBuilder;
import org.apache.rocketmq.common.MixAll;

public class RetryTopicUtil {

    private static final String RETRY_GROUP_TOPIC_PREFIX = MixAll.RETRY_GROUP_TOPIC_PREFIX;

    public static boolean isRetryTopic(String topic) {
        return null != topic && topic.startsWith(RETRY_GROUP_TOPIC_PREFIX);
    }

    public static String getGroupFromRetryTopic(String retryTopic) {
        if (retryTopic == null) {
            return null;
        }
        return KeyBuilder.parseGroup(retryTopic);
    }


    public static String getRetryTopic(String group) {
        if (group == null) {
            return null;
        }
        return MixAll.getRetryTopic(group);
    }

}
