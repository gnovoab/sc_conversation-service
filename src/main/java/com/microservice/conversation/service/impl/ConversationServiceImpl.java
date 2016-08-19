
//Namesapce
package com.microservice.conversation.service.impl;

//Imports
import com.microservice.conversation.domain.Conversation;
import com.microservice.conversation.exception.DatabaseException;
import com.microservice.conversation.repository.ConversationRepository;
import com.microservice.conversation.service.ConversationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Class that handles operations regarding conversation
 */
@Service
public class ConversationServiceImpl implements ConversationService {

    //The LOG
    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationServiceImpl.class);

    //Fields
    @Resource
    private ConversationRepository conversationRepository;

    /**
     * Store conversation into DB
     * @param conversation
     */
    @Override
    public void save(Conversation conversation) {
        try {
            LOGGER.info("Storing conversation with SessionID[{}] for BotId[{}]",conversation.getSessionId(),conversation.getBotId());
            conversationRepository.save(conversation);
            LOGGER.info("Conversation with SessionID[{}] for BotId[{}] store succesfully");

        }
        catch (Exception e) {
            LOGGER.error("Unknown exception while storing conversation with BotId[{}]  SessionID[] userId[{}] userQuestion[{}] botResponse[{}]",
                    conversation.getBotId(), conversation.getSessionId(), conversation.getUserId(), conversation.getUserQuestion(), conversation.getBotResponse(),e);
            throw new DatabaseException("Exception while storing conversation", e);
        }
    }
}
