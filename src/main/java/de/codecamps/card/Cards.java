package de.codecamps.card;

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

    public void addCard(Card card) {
        entityManager.persist(card);
    }

    public void deleteCard(Card card) {
        entityManager.remove(card);
    }

    @SuppressWarnings("unchecked")
    public List<Card> getCards() {
        Query query = entityManager.createQuery("SELECT c from Card as c");
        return query.getResultList();
    }
}
