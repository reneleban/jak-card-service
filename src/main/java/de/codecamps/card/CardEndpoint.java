package de.codecamps.card;

import de.codecamps.card.entities.Card;
import de.codecamps.card.jwt.JWTTokenNeeded;
import de.codecamps.card.operations.CardOperation;
import de.codecamps.card.persistence.Cards;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Stateless
@Produces({MediaType.APPLICATION_JSON})
@JWTTokenNeeded
@Path("/card")
public class CardEndpoint {

    @Inject
    CardOperation cardOperation;

    @Inject
    Cards cards;

    @POST
    @Path("/{token}/{list_id}")
    public Card addCard(
            @PathParam("token") String token,
            @PathParam("list_id") String listId,
            @FormParam("name") String name,
            @FormParam("description") String description,
            @Context SecurityContext securityContext) {
        Card card = cardOperation.createCard(listId, name, description);
        cards.addCard(card);
        return card;
    }
}
