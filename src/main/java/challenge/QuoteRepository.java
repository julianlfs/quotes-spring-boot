package challenge;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends PagingAndSortingRepository<Quote, Integer> {

    List<Quote> findQuoteByActorContains(String actor);

    Page<Quote> findAll(Pageable pageable);
}