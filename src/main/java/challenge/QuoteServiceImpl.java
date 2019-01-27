package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
        return repository.findQuoteById(randomQuote());
	}

	@Override
	public Quote getQuoteByActor(String actor) {
	    // TODO - implementar estratégia pra randomizar quotes do ator
		return repository.findQuoteByActorContains(actor)
                .stream()
                .findFirst()
                .get();
	}

	private Integer randomQuote() {
	    // TODO - retornar random só com ids presentes na base
	    return new Random().nextInt(1000);
    }

}
