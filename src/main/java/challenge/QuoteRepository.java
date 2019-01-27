package challenge;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Integer> {

    Quote findQuoteById(Integer id);

    List<Quote> findQuoteByActorContains(String actor);

    Quote findQuoteByIdBetween(Integer start, Integer end);
}