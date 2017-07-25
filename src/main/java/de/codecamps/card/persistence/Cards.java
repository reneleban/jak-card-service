package de.codecamps.card.persistence;

import de.codecamps.card.entities.Card;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class Cards {

    @PersistenceContext(unitName = "card-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public Card getCard(long id){
        return entityManager.find(Card.class, id);
    }

    public void addCard(Card card) {
        entityManager.persist(card);
    }

    public void deleteCard(Card card) {
        entityManager.remove(card);
    }

    @SuppressWarnings("unchecked")
    public List<Card> getCards(final String listId) {
        Query query = entityManager.createQuery("SELECT c from Card as c where c.listId=:listId order by c.name");
        query.setParameter("listId", listId);
        return query.getResultList();
    }
}
