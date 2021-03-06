package org.koushik.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON) //return format of the GET request
	public List<Message> getMessage()
	{
		return messageService.getAllMessages();
	}
	
	/**
	 * Returns a specific message based off a param.
	 * If MessageService finds no message with the passed Id, null gets passed back. 204 status would appear.
	 * Could cause a 404 by passing any non-numerical value in as the messageId.
	 * @param messageId
	 * @return
	 */
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId)
	{
		return messageService.getMessage(messageId);	
	}
}


