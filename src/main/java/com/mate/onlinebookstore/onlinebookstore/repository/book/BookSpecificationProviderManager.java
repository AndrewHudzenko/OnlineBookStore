package com.mate.onlinebookstore.onlinebookstore.repository.book;

import com.mate.onlinebookstore.onlinebookstore.model.Book;
import com.mate.onlinebookstore.onlinebookstore.repository.SpecificationProvider;
import com.mate.onlinebookstore.onlinebookstore.repository.SpecificationProviderManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return bookSpecificationProviders.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst().orElseThrow(
                        () -> new RuntimeException("Can't find correct "
                                + "specification provider key " + key));
    }
}
