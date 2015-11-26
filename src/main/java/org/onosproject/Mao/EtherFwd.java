package org.onosproject.Mao;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.onosproject.core.ApplicationId;
import org.onosproject.core.CoreService;
import org.onosproject.net.flow.FlowRuleService;
import org.onosproject.net.packet.PacketContext;
import org.onosproject.net.packet.PacketProcessor;
import org.onosproject.net.packet.PacketService;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mao on 11/26/15.
 */

@Component(immediate = true)
public class EtherFwd {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected CoreService coreSerivice;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected PacketService packetService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected FlowRuleService flowRuleService;




    private ApplicationId appId;


    @Activate
    public void activate(ComponentContext context){
        appId = coreSerivice.registerApplication("org.onosproject.Mao.Mao-Ether-igmp");
        log.info("Mao Started, id: {}, name: {}",appId.id(),appId.name());
    }

    @Deactivate
    public void deactivate(){
        log.info("Mao Stopped, id: {}, name: {}",appId.id(),appId.name());
    }




    private class InternalPacketProcessor implements PacketProcessor{

        @Override
        public void process(PacketContext context){




        }

    }

}
