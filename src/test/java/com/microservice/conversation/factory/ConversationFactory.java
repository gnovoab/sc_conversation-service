
//Namespace
package com.microservice.conversation.factory;

//Imports
import com.microservice.conversation.domain.Conversation;
import java.util.Random;

/**
 * User factory class
 */
public final class ConversationFactory {

	public static final String BOT_INTEGRATION_TEST = "BOT_IT";

    static Random random = new Random();

	/**
	 * Factory method
	 * @return
	 */
	public static Conversation getConversation(){
        Conversation conversation = new Conversation();
        conversation.setBotId("BOT_UT");
        conversation.setUserId("7809284XY");
        conversation.setSessionId(String.valueOf(1000000 + random.nextInt(9000000)));
        conversation.setUserQuestion("Hi");
        conversation.setBotResponse("Hi! how can I help?");
		return conversation;
	}


	/**
	 * Factory method
	 * @return
	 */
	public static Conversation getIntegrationConversation(){
        Conversation conversation = getConversation();
        conversation.setBotId(BOT_INTEGRATION_TEST);
		return conversation;
	}
}
