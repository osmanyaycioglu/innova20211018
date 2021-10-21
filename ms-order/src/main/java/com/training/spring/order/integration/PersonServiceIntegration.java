package com.training.spring.order.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.spring.order.error.RestClientException;

@Service
public class PersonServiceIntegration {

    @Autowired
    private RestTemplate  rt;

    @Autowired
    private EurekaClient  eClient;

    @Autowired
    private IPersonClient personClient;

    public String callHello2(final String name) {
        String retLoc = this.rt.getForObject("http://PERSON/first/hello2/" + name,
                                             String.class);
        return retLoc;
    }

    public String callHello2b(final String name) throws RestClientException {
        Person personLoc = new Person().setName(name)
                                       .setSurname("surname")
                                       .setHeight(200)
                                       .setWeight(100);
        personLoc = this.personClient.hello9(personLoc);
        String retLoc = this.personClient.hello2(name);
        return retLoc;
    }


    public String callHello2a(final String name) {
        Application applicationLoc = this.eClient.getApplication("PERSON");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        InstanceInfo instanceInfoLoc = instancesLoc.get(0);
        RestTemplate rti = new RestTemplate();
        String retLoc = rti.getForObject("http://"
                                         + instanceInfoLoc.getIPAddr()
                                         + ":"
                                         + instanceInfoLoc.getPort()
                                         + " /first/hello2/"
                                         + name,
                                         String.class);
        return retLoc;
    }


}
