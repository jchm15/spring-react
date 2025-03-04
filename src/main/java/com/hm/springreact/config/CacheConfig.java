package com.hm.springreact.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MaxSizePolicy;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String MENU_HAZELCAST_MAP = "menu-hazelcast-map";

    @Bean
    HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setClusterName("app-hazelcast-cluster")
                .setInstanceName("app-hazelcast-instance");

//        config.setCPSubsystemConfig(new CPSubsystemConfig().setCPMemberCount(3))
//                .setIntegrityCheckerConfig(new IntegrityCheckerConfig().setEnabled(true))
//                .setJetConfig(new JetConfig().setEnabled(true))


//        config.getNetworkConfig()
//                .setPortAutoIncrement(Boolean.TRUE)
//                .setPortCount(20)
//                .getJoin()
//                .setMulticastConfig(new MulticastConfig().setEnabled(Boolean.FALSE))
//                .setTcpIpConfig(new TcpIpConfig().addMember("127.0.0.1"));

        config.getMapConfig(MENU_HAZELCAST_MAP)
                .setTimeToLiveSeconds(20)
                .getEvictionConfig()
                .setEvictionPolicy(EvictionPolicy.LFU)
                .setSize(200)
                .setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE);

        return Hazelcast.newHazelcastInstance(config);
    }

}
