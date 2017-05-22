package de.codecamps.card.operations;

import de.codecamps.card.entities.Card;

public class CardOperation {
    public Card createCard(String listId, String name, String description) {
        Card card = new Card();
        card.setListId(listId);
        card.setName(name);
        card.setDescription(description);
        return card;
    }
}
