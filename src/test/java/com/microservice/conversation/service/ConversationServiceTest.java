
//Namesapce
package com.microservice.conversation.service;

//Imports

import com.microservice.conversation.factory.ConversationFactory;
import com.microservice.conversation.repository.ConversationRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Unit test class for ConversationService
 */
@ActiveProfiles("local")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConversationServiceTest {

    //Fields
    @Resource
    private ConversationService conversationService;

    @Resource
    private ConversationRepository conversationRepository;


    @Test
    public void testSave() throws Exception {
        long rowsNoBefore = conversationRepository.count();
        conversationService.save(ConversationFactory.getConversation());
        long rowsNoAfter = conversationRepository.count();
        Assert.assertTrue(rowsNoAfter == rowsNoBefore+1);
    }
}
