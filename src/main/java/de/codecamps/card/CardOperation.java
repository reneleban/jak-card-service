package de.codecamps.card;

public class CardOperation {

    public String getCard(long id) {
        return null;
    }

    public Card createCard(String listId, String name, String description) {
        Card card = new Card();
        card.setListId(listId);
        card.setName(name);
        card.setDescription(description);
        return card;
    }
}
