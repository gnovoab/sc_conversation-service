
//Namespace
package com.microservice.conversation.repository;

import com.microservice.conversation.domain.Conversation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class that handles database operations for Conversation
 */
@Transactional
public interface ConversationRepository extends CrudRepository<Conversation,Long> {
}
