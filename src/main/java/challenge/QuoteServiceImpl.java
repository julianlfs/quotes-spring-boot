package challenge;

import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final Integer MAX_PAGE_SIZE = 1000;
    private final Integer MAX_ELEMENTS_BY_PAGE = 20;
    private static Integer cache = -1;

    @Autowired
    private QuoteRepository repository;

    @Override
    public Quote getQuote() {

        List<Quote> content = getPage().getContent();
        return content.get(randomize(content.size()));
    }

    @Override
    public Quote getQuoteByActor(String actor) {
        List<Quote> quoteByActor = repository.findQuoteByActorContains(actor);

        if (quoteByActor.size() == 0)
            return null;

        return quoteByActor.get(randomize(quoteByActor.size()));
    }

    private Page<Quote> getPage() {

        int pageNumber = cache >= 0 ? randomize(cache) : randomize(MAX_PAGE_SIZE);

        PageRequest pageRequest = PageRequest.of(pageNumber, MAX_ELEMENTS_BY_PAGE);
        Page<Quote> sortedPage = repository.findAll(pageRequest);

        int totalPages = sortedPage.getTotalPages() - 1;
        if (cache != totalPages)
            cache = totalPages;

        if (!sortedPage.hasContent())
            return getPage();

        return sortedPage;
    }

    private Integer randomize(int limit) {
        return new Random().nextInt(limit);
    }
}